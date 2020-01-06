package com.example.thecalendarapp

import android.content.DialogInterface
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.create_new_period_alert.*


data class Period(
    var className: String,
    var teacher: String = "",
    var classNumber: String = "",
    var groupNumber: String = "",
    var timeOfDay: String = ""
)

val defaultPeriod : Period = Period(
    className = "Period Name",
    teacher = "Teacher's Name",
    classNumber = "Classroom Room",
    groupNumber = "Group Number"
)

data class SchoolDay(
    var periods : Array<Period> = Array(5) { defaultPeriod }
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

var weekDaySchedule: Array<SchoolDay> = Array(5) { SchoolDay() }
var nineDaySchedule: Array<SchoolDay> = Array(9) { SchoolDay() }
var periodTypes: MutableList<Period> = mutableListOf(defaultPeriod)
var periodNames: MutableList<String> = mutableListOf()

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val day_buttons: List<Button> = listOf(mondayBtn, tuesdayBtn, wednesdayBtn, thursdayBtn, fridayBtn, day1Btn, day2Btn, day3Btn, day4Btn, day5Btn, day6Btn, day7Btn, day8Btn, day9Btn)
        nineDaySw.setOnClickListener {
            for (i in (1..day_buttons.size)) {
                with(day_buttons[i - 1])
                {
                    isClickable = !isClickable
                    isEnabled = !isEnabled
                    isFocusable = !isFocusable
                    visibility = if (visibility == GONE) VISIBLE else GONE
                }
            }
        }

        val period_spinners: List<Spinner> = listOf(period1spn, period2spn, period3spn, period4spn, period5spn)

        for (i in (1..day_buttons.size)){
            if (i <= 5){
                day_buttons[i - 1].setOnClickListener{
                    for (k in (1..period_spinners.size)) {
                        period_spinners[k].adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, periodNames)
                        for (m in 0 until period1spn.adapter.count) {
                            if (period_spinners[k].adapter.getItem(i).toString().contains(weekDaySchedule[i - 1].periods[k - 1].className)) {
                                period_spinners[k].setSelection(m)
                            }
                        }
                    }
                }
            }
            else{
                day_buttons[i - 1].setOnClickListener{
                    for (k in (1..period_spinners.size)) {
                        period_spinners[k].adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, periodNames)
                        for (m in 0 until period1spn.adapter.count) {
                            if (period_spinners[k].adapter.getItem(i).toString().contains(nineDaySchedule[i - 6].periods[k - 1].className)) {
                                period_spinners[k].setSelection(m)
                            }
                        }
                    }
                }
            }
        }
/*
        for (i in (1..period_spinners.size)){
            with(period_spinners[i]) {
                setOnClickListener {

                }
            }
        }
*/
/*
        mondayBtn.setOnClickListener{ ShowDayInfo(1)}
        tuesdayBtn.setOnClickListener{ ShowDayInfo(2}
        wednesdayBtn.setOnClickListener{ ShowDayInfo(3)}
        thursdayBtn.setOnClickListener{ ShowDayInfo(4)}
        fridayBtn.setOnClickListener{ ShowDayInfo(5)}
        day1Btn.setOnClickListener{ ShowDayInfo(1, true)}
        day2Btn.setOnClickListener{ ShowDayInfo(2, true)}
        day3Btn.setOnClickListener{ ShowDayInfo(3, true)}
        day4Btn.setOnClickListener{ ShowDayInfo(4, true)}
        day5Btn.setOnClickListener{ ShowDayInfo(5, true)}
        day6Btn.setOnClickListener{ ShowDayInfo(6, true)}
        day7Btn.setOnClickListener{ ShowDayInfo(7, true)}
        day8Btn.setOnClickListener{ ShowDayInfo(8, true)}
        day9Btn.setOnClickListener{ ShowDayInfo(9, true)}
*/
        val dialog = AlertDialog.Builder(this)
        val dialogView = layoutInflater.inflate(R.layout.create_new_period_alert, null)
        val periodNameEt = dialogView.findViewById<EditText>(R.id.periodNameEt)
        val teacherEt = dialogView.findViewById<EditText>(R.id.periodNameEt)
        val classroomRoomEt = dialogView.findViewById<EditText>(R.id.periodNameEt)
        val groupEt = dialogView.findViewById<EditText>(R.id.periodNameEt)
        val confirmChk = dialogView.findViewById<CheckBox>(R.id.newPeriodConfirmChk)
        val builder = AlertDialog.Builder(this)
        var createNewPeriod = false
        builder.setTitle("Warning")
        builder.setMessage("Missing optional information. Continue?")
        builder.setPositiveButton("Continue") { _: DialogInterface, _: Int ->
            createNewPeriod = true
        }
        builder.setNegativeButton("Never mind...") {_: DialogInterface, _:Int ->}
        dialog.setView(dialogView)
        dialog.setCancelable(false)
        newPeriodBtn.setOnClickListener{
            dialog.show()
            newPeriodCreateBtn.setOnClickListener{
                if (confirmChk.isChecked) {
                    if (periodNameEt.text.toString() == "") {
                        Toast.makeText(baseContext, "Period name required", Toast.LENGTH_SHORT).show()
                        createNewPeriod = false
                    }
                    else if(teacherEt.text.toString() == "" ||
                            classroomRoomEt.text.toString() == "" ||
                            groupEt.text.toString() == ""){
                            builder.show()
                    }
                    if (createNewPeriod){
                        periodTypes.add(Period(
                            periodNameEt.text.toString(),
                            teacherEt.text.toString(),
                            classroomRoomEt.text.toString(),
                            groupEt.text.toString()
                        ))
                        periodNames.add(periodNameEt.text.toString())
                    }
                }
                else{
                    Toast.makeText(baseContext, "Please check the confirm box", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
