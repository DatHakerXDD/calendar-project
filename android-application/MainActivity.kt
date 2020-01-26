package com.example.test2

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


data class SchoolPeriod(
    var className: String,
    var teacher: String = "",
    var classNumber: String = "",
    var groupNumber: String = "",
    var timeOfDay: String = ""
)

val defaultPeriod : SchoolPeriod = SchoolPeriod(
    className = "Period Name",
    teacher = "Teacher's Name",
    classNumber = "Classroom Room",
    groupNumber = "Group Number"
)

data class SchoolDay(
    var periods : Array<SchoolPeriod> = Array(5) { defaultPeriod }
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as SchoolDay

        if (!periods.contentEquals(other.periods)) return false

        return true
    }

    override fun hashCode(): Int {
        return periods.contentHashCode()
    }
}

data class Holiday(
    var holidayName : String,
    var holidayDate : Date
)

var weekDaySchedule: Array<SchoolDay> = Array(5) { SchoolDay() }
var nineDaySchedule: Array<SchoolDay> = Array(9) { SchoolDay() }
var periodTypes: MutableList<SchoolPeriod> = mutableListOf(defaultPeriod)
var periodNames: MutableList<String> = mutableListOf(defaultPeriod.className)
var holidays: MutableList<Holiday> = mutableListOf()
var day : Int = 0
var schoolYears : MutableList<String> = mutableListOf("School Year")
var schoolName : String = ""

class MainActivity : AppCompatActivity() {

    @SuppressLint("InflateParams")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val thisYear = Calendar.getInstance()[Calendar.YEAR]
        for (i in (1..10)){
            schoolYears.add((thisYear - 6 + i).toString().plus(" - ").plus((thisYear - 5 + i).toString()))
        }
        schoolYearSpn.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            schoolYears
        )
        schoolYearSpn.setSelection(0)
        //Show and hide day buttons according to nine day switch
        val dayButtons: List<ToggleButton> = listOf(
            mondayBtn,
            tuesdayBtn,
            wednesdayBtn,
            thursdayBtn,
            fridayBtn,
            day1Btn,
            day2Btn,
            day3Btn,
            day4Btn,
            day5Btn,
            day6Btn,
            day7Btn,
            day8Btn,
            day9Btn
        )
        val periodSpinners: List<Spinner> =
            listOf(period1spn, period2spn, period3spn, period4spn, period5spn)

        nineDaySw.setOnClickListener {
            for (i in (dayButtons.indices)) {
                with(dayButtons[i])
                {
                    visibility = if (visibility == GONE) VISIBLE else GONE
                }
                dayButtons[i].isChecked = false
            }
            if (nineDaySw.isChecked){
                day1Btn.isChecked = true
                day = 5
                for (i in periodSpinners.indices){
                    val pos : Int = periodNames.indexOf(nineDaySchedule[0].periods[i].className)
                    periodSpinners[i].setSelection(pos)
                }
            }
            else{
                mondayBtn.isChecked = true
                day = 0
                for (i in periodSpinners.indices){
                    val pos : Int = periodNames.indexOf(weekDaySchedule[0].periods[i].className)
                    periodSpinners[i].setSelection(pos)
                }
            }
        }

        //Get and display information of each day on spinners when their buttons are clicked
        for (i in (dayButtons.indices)) {
            if (i < 5) {
                dayButtons[i].setOnClickListener {
                    //Get periods of that day and display on spinners
                    for (o in dayButtons.indices){
                        dayButtons[o].isChecked = false
                    }
                    dayButtons[i].isChecked = true
                    day = i
                    for (k in (periodSpinners.indices)) {
                        //Set spinner adapters with periodNames list
                        periodSpinners[k].adapter = ArrayAdapter(
                            this,
                            android.R.layout.simple_spinner_dropdown_item,
                            periodNames
                        )
                        for (m in (0 until periodNames.size)) {
                            if (periodSpinners[k].adapter.getItem(m).toString().contains(
                                    weekDaySchedule[i].periods[k].className
                                )
                            ) {
                                periodSpinners[k].setSelection(m)
                            }
                        }
                    }
                }
            } else {
                dayButtons[i].setOnClickListener {
                    for (o in dayButtons.indices){
                        dayButtons[o].isChecked = false
                    }
                    dayButtons[i].isChecked = true
                    day = i
                    for (k in (periodSpinners.indices)) {
                        periodSpinners[k].adapter = ArrayAdapter(
                            this,
                            android.R.layout.simple_spinner_dropdown_item,
                            periodNames
                        )
                        for (m in (0 until periodNames.size)) {
                            if (periodSpinners[k].adapter.getItem(m).toString().contains(
                                    nineDaySchedule[i - 5].periods[k].className
                                )
                            ) {
                                periodSpinners[k].setSelection(m)
                            }
                        }
                    }
                }
            }
        }
        newPeriodBtn.setOnClickListener {
            val periodDialog = AlertDialog.Builder(this)
            val periodDialogView = layoutInflater.inflate(R.layout.create_new_period_alert, null)
            periodDialog.setView(periodDialogView)
            periodDialog.setCancelable(true)
            val periodConfirm: CheckBox = periodDialogView.findViewById(R.id.newPeriodConfirmChk)
            val periodName: EditText = periodDialogView.findViewById(R.id.periodNameEt)
            val teacher: EditText = periodDialogView.findViewById(R.id.teacherEt)
            val classRoom: EditText = periodDialogView.findViewById(R.id.classroomRoomEt)
            val groupNumber: EditText = periodDialogView.findViewById(R.id.groupEt)
            val newPeriodButton: Button = periodDialogView.findViewById(R.id.newPeriodCreateBtn)
            periodConfirm.setOnClickListener {
                newPeriodButton.isEnabled = !newPeriodButton.isEnabled
            }
            periodDialog.show()
            newPeriodButton.isEnabled = false
            periodDialogView.findViewById<Button>(R.id.newPeriodCreateBtn).setOnClickListener {
                val periodBuilder = AlertDialog.Builder(this)
                periodBuilder.setTitle("Warning")
                periodBuilder.setCancelable(false)
                periodBuilder.setMessage("Missing optional information. Continue?")
                periodBuilder.setPositiveButton("Continue") { _: DialogInterface, _: Int ->
                    periodTypes.add(
                        SchoolPeriod(
                            className = periodName.text.toString(),
                            teacher = teacher.text.toString(),
                            classNumber = classRoom.text.toString(),
                            groupNumber = groupNumber.text.toString()
                        )
                    )
                    periodNames.add(periodName.text.toString())
                    Toast.makeText(baseContext, "Period Created!", Toast.LENGTH_SHORT).show()
                }
                val periodBuilder2 = AlertDialog.Builder(this)
                periodBuilder2.setTitle("Warning")
                periodBuilder2.setCancelable(false)
                periodBuilder2.setMessage("Repeated period name. Replace?")
                periodBuilder2.setPositiveButton("Replace") { _: DialogInterface, _: Int ->
                    val pos : Int = periodNames.indexOf(periodName.text.toString())
                    periodTypes[pos] = SchoolPeriod(
                            className = periodName.text.toString(),
                            teacher = teacher.text.toString(),
                            classNumber = classRoom.text.toString(),
                            groupNumber = groupNumber.text.toString())
                    Toast.makeText(baseContext, "Period Created!", Toast.LENGTH_SHORT).show()
                }
                periodBuilder2.setNegativeButton("Never mind...") { _: DialogInterface, _: Int -> }
                periodBuilder.setNegativeButton("Never mind...") { _: DialogInterface, _: Int -> }
                when {
                    periodName.text.toString() == "" -> {
                        Toast.makeText(baseContext, "Period name required", Toast.LENGTH_SHORT).show()
                    }
                    periodNames.find { it.contains(periodName.text.toString()) } != null -> {
                        periodBuilder2.show()
                    }
                    teacher.text.toString() == "" || classRoom.text.toString() == "" || groupNumber.text.toString() == "" -> {
                        periodBuilder.show()
                    }
                    else -> {
                        periodTypes.add(
                            SchoolPeriod(
                                className = periodName.text.toString(),
                                teacher = teacher.text.toString(),
                                classNumber = classRoom.text.toString(),
                                groupNumber = groupNumber.text.toString()
                            )
                        )
                        periodNames.add(periodName.text.toString())
                        Toast.makeText(baseContext, "Period Created!", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
        for (i in periodSpinners.indices) {
            periodSpinners[i].onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener{
                override fun onNothingSelected(parent: AdapterView<*>?) {
                    val position: Int = if (day < 5) periodNames.indexOf(weekDaySchedule[day].periods[i].className)
                                        else periodNames.indexOf(nineDaySchedule[day - 5].periods[i].className)
                    periodSpinners[i].setSelection(position)
                }

                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    if (day < 5){
                        weekDaySchedule[day].periods[i] = periodTypes[position]
                    }
                    else{
                        nineDaySchedule[day - 5].periods[i] = periodTypes[position]
                    }
                }
            }
        }
        confirmChk.setOnClickListener{
            next1Btn.isEnabled = !next1Btn.isEnabled
        }
        next1Btn.setOnClickListener{
            when {
                schoolNameEt.text.toString() == "" -> {
                    Toast.makeText(this, "Please enter a valid school name", Toast.LENGTH_SHORT).show()
                }
                schoolYearSpn.selectedItemPosition == 0 -> {
                    Toast.makeText(this, "Please choose a valid school year", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    schoolName = schoolNameEt.text.toString()
                }
            }
        }
        mondayBtn.performClick()
    }
}
