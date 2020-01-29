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
import jdk.nashorn.internal.objects.NativeDate.getTime
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalTime
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
    var holidayDate : DateFormat
)

var weekDaySchedule: Array<SchoolDay> = Array(5) { SchoolDay() }
var nineDaySchedule: Array<SchoolDay> = Array(9) { SchoolDay() }
var periodTypes: MutableList<SchoolPeriod> = mutableListOf(defaultPeriod)
var periodNames: MutableList<String> = mutableListOf(defaultPeriod.className)
var holidays: MutableList<Holiday> = mutableListOf()
@SuppressLint("NewApi")
var defaultHolidayChoices: MutableList<MutableList<Holiday>> = mutableListOf(mutableListOf(Holiday("List of holidays",LocalDate.of(2000, 1, 1))))
var defaultHolidayListNames : MutableList<String> = mutableListOf("--- School holiday lists ---")
var day : Int = 0
var schoolYears : MutableList<String> = mutableListOf("School Year")
var schoolName : String = ""
var schoolYear : Int = 0
var isItNineDays : Boolean = false
@SuppressLint("NewApi")
var periodTimeInfo : Array<LocalTime> = Array(10) {LocalTime.of(12, 0)}
@SuppressLint("SimpleDateFormat")
val timeFormatter : DateFormat = SimpleDateFormat("hh:mm:ss a")

class MainActivity : AppCompatActivity() {

    @SuppressLint("InflateParams", "NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val stLouisHolidays = mutableListOf(
            Holiday("Demie journée pédagogique", Date(2019, 8, 28)),
            Holiday("Demie journée pédagogique", LocalDate.of(2019, 8, 29)),
            Holiday("Fête du travail", LocalDate.of(2019, 9, 2)),
            Holiday("Journée pédagogique", LocalDate.of(2019, 9, 20)),
            Holiday("Action de grâce", LocalDate.of(2019, 10, 14)),
            Holiday("Journée pédagogique", LocalDate.of(2019, 10, 21)),
            Holiday("Journée pédagogique", LocalDate.of(2019, 11, 1)),
            Holiday("Journée pédagogique mobile", LocalDate.of(2019, 11, 22)),
            Holiday("Journée pédagogique", LocalDate.of(2019, 12, 6)),
            Holiday("Congé de Noël", LocalDate.of(2019, 12, 23)),
            Holiday("Congé de Noël", LocalDate.of(2019, 12, 24)),
            Holiday("Noël", LocalDate.of(2019, 12, 25)),
            Holiday("Congé de Noël", LocalDate.of(2019, 12, 26)),
            Holiday("Congé de Noël", LocalDate.of(2019, 12, 27)),
            Holiday("Congé de Noël", LocalDate.of(2019, 12, 30)),
            Holiday("Congé de Noël", LocalDate.of(2019, 12, 31)),
            Holiday("Congé de Noël", LocalDate.of(2020, 1, 1)),
            Holiday("Journée pédagogique", LocalDate.of(2020, 1, 24)),
            Holiday("Journée pédagogique", LocalDate.of(2020, 2, 12)),
            Holiday("Journée blanche", LocalDate.of(2020, 2, 20)),
            Holiday("Journée pédagogique mobile", LocalDate.of(2020, 2, 28)),
            Holiday("Semaine de relâche", LocalDate.of(2020, 3, 2)),
            Holiday("Semaine de relâche", LocalDate.of(2020, 3, 3)),
            Holiday("Semaine de relâche", LocalDate.of(2020, 3, 4)),
            Holiday("Semaine de relâche", LocalDate.of(2020, 3, 5)),
            Holiday("Semaine de relâche", LocalDate.of(2020, 3, 6)),
            Holiday("Journée pédagogique mobile", LocalDate.of(2020, 4, 9)),
            Holiday("Vendredi saint", LocalDate.of(2020, 4, 10)),
            Holiday("Lundi de Pâques", LocalDate.of(2020, 4, 13)),
            Holiday("Journée pédagogique", LocalDate.of(2020, 4, 24)),
            Holiday("Journée pédagogique", LocalDate.of(2020, 5, 1)),
            Holiday("Journée verte", LocalDate.of(2020, 5, 27)),
            Holiday("Journée nationale des patriotes", LocalDate.of(2020, 5, 18)),
            Holiday("Journée pédagogique", LocalDate.of(2020, 6, 1)),
            Holiday("Défi endurance", LocalDate.of(2020, 6, 5)))

        defaultHolidayChoices.add(stLouisHolidays)
        defaultHolidayListNames.add("Collège St-Louis")

        val page1Objects = listOf<View>(schoolNameEt,
            schoolYearSpn,
            nineDaySw,
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
            day9Btn,
            newPeriodBtn,
            period1spn,
            period2spn,
            period3spn,
            period4spn,
            period5spn,
            next1Btn,
            confirmChk)

        val page2Objects = listOf<View>(
            back1btn,
            next2btn,
            holidayChoiceSpn,
            addHolidayBtn,
            holidayTitle1,
            holidayTitle2,
            holidayTitle3,
            holidayTgb1,
            holidayTgb2
        )

        val page3Objects = listOf<View>(
            back2Btn,
            next3Btn,
            period1StartEt,
            period1EndEt,
            period2StartEt,
            period2EndEt,
            period3StartEt,
            period3EndEt,
            period4StartEt,
            period4EndEt,
            period5StartEt,
            period5EndEt,
            period1Time,
            period2Time,
            period3Time,
            period4Time,
            period5Time,
            periodStart,
            periodEnd,
            schoolYearStartEt,
            schoolYearEndEt,
            schoolYearStartTv,
            schoolYearEndTv
        )

        holidayChoiceSpn.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            defaultHolidayListNames)
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
            isItNineDays = !isItNineDays
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
                    schoolYear = schoolYears[schoolYearSpn.selectedItemPosition].take(4).toInt()
                    for (i in page1Objects.indices){
                        page1Objects[i].visibility = GONE

                    }
                    for (i in page2Objects.indices){
                        page2Objects[i].visibility = VISIBLE

                    }
                    holidayTgb2.performClick()
                }
            }
        }

        back1btn.setOnClickListener{
            for (i in page1Objects.indices){
                page1Objects[i].visibility = VISIBLE

            }
            for (i in page2Objects.indices){
                page2Objects[i].visibility = GONE

            }
            mondayBtn.performClick()
        }

        addHolidayBtn.setOnClickListener{
            Toast.makeText(baseContext, "Coming soon", Toast.LENGTH_SHORT).show()
            //TODO
        }

        val holidayToggles = listOf<ToggleButton>(holidayTgb1, holidayTgb2)
        for (i in holidayToggles.indices){
            holidayToggles[i].setOnClickListener{
                holidayToggles[i].isChecked = true
                holidayToggles[if (i == 1) 0 else 1].isChecked = false
            }
        }

        mondayBtn.performClick()

        next2btn.setOnClickListener{
            when {
                holidayTgb1.isChecked -> {
                    Toast.makeText(baseContext, "Custom holiday sets coming soon", Toast.LENGTH_SHORT).show()
                    Toast.makeText(baseContext, "Please choose a default set of holidays", Toast.LENGTH_SHORT).show()
                }
                holidayChoiceSpn.selectedItemPosition == 0 -> {
                    Toast.makeText(baseContext, "Please choose a valid list of holidays", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    for (i in page2Objects.indices){
                        page2Objects[i].visibility = GONE
                    }
                    for (i in page3Objects.indices){
                        page3Objects[i].visibility = VISIBLE
                    }
                }
            }
        }

        val periodTimeEditTexts : List<EditText> = listOf(
            period1StartEt,
            period1EndEt,
            period2StartEt,
            period2EndEt,
            period3StartEt,
            period3EndEt,
            period4StartEt,
            period4EndEt,
            period5StartEt,
            period5EndEt,
            schoolYearStartEt,
            schoolYearEndEt
        )

        var pass = true
        next3Btn.setOnClickListener{
            for (i in periodTimeEditTexts.indices){
                if (periodTimeEditTexts[i].text.toString() == ""){
                    pass = false
                }
            }
            if (pass){
                val generateCalendarBuilder = AlertDialog.Builder(this)
                generateCalendarBuilder.setTitle("Continue?")
                generateCalendarBuilder.setCancelable(false)
                generateCalendarBuilder.setMessage("Are you sure you want to continue?")
                generateCalendarBuilder.setPositiveButton("Continue") { _: DialogInterface, _: Int ->
                    for (i in (0..9)){
                        periodTimeInfo[i] = timeFormatter.parse(periodTimeEditTexts[i].text.toString()
                    }
                    createCSV()
                }
                generateCalendarBuilder.setNegativeButton("Cancel"){ _: DialogInterface, _: Int ->
                    pass = false
                }
                generateCalendarBuilder.show()

            }
            else{
                Toast.makeText(baseContext, "Missing required information", Toast.LENGTH_SHORT).show()
            }
        }

        back2Btn.setOnClickListener{
            for (i in page2Objects.indices){
                page2Objects[i].visibility = VISIBLE
            }
            for (i in page3Objects.indices){
                page3Objects[i].visibility = GONE
            }
            for (i in (0..9)){
                //TODO periodTimeInfo[i] = periodTimeEditTexts[i].text.toString().
            }
        }
    }
}

public fun createCSV(){

    val CSVFile = File("CSV Export")
    for (month in (0..11)){}
    if (CSVFile.createNewFile()){
        with(CSVFile){
            writeText("Subject,Start Date,End Date,All Day Event,Start Time,End Time,Description,Location,Private")
            writeText("")
        }
    }//TODO
