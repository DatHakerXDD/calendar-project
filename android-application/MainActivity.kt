package com.example.therealapplication

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.content.DialogInterface
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.time.LocalDate
import java.time.LocalTime
import java.util.*
import android.widget.TextView
import android.widget.Button
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.time.DayOfWeek


data class SchoolPeriod(
    var className: String,
    var teacher: String = "",
    var classNumber: String = "",
    var groupNumber: String = ""
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
    var holidayDate : LocalDate
)

var weekDaySchedule: Array<SchoolDay> = Array(5) { SchoolDay() }
var nineDaySchedule: Array<SchoolDay> = Array(9) { SchoolDay() }
var periodTypes: MutableList<SchoolPeriod> = mutableListOf(defaultPeriod)
var periodNames: MutableList<String> = mutableListOf(defaultPeriod.className)
var holidayDates: MutableList<LocalDate> = mutableListOf() //TODO
@SuppressLint("NewApi")
var defaultHolidayChoices: MutableList<MutableList<Holiday>> = mutableListOf(mutableListOf(Holiday("List of holidays",LocalDate.of(2000, 1, 1))))
var defaultHolidayListNames : MutableList<String> = mutableListOf("--- School holiday lists ---")
var day : Int = 0
var schoolYears : MutableList<String> = mutableListOf("School Year")
var schoolName : String = ""
var schoolYear : Int = 0
var isItNineDays : Boolean = false
@SuppressLint("NewApi")
@RequiresApi(Build.VERSION_CODES.O)
var schoolDays : Array<LocalDate> = Array(2) {LocalDate.of(2000,1,1) }
@RequiresApi(Build.VERSION_CODES.O)
var schoolTimeInfo : Array<LocalTime> = arrayOf(
    LocalTime.of(8,0,0),
    LocalTime.of(9,15,0),
    LocalTime.of(9,23,0),
    LocalTime.of(10,38,0),
    LocalTime.of(10,55,0),
    LocalTime.of(12,10,0),
    LocalTime.of(13,35,0),
    LocalTime.of(14,50,0),
    LocalTime.of(14,50,0),
    LocalTime.of(14,50,0))
var selectedHolidayList : Int = 0

@RequiresApi(Build.VERSION_CODES.O)
val stLouisHolidays = mutableListOf(
    Holiday("Demie journée pédagogique", LocalDate.of(2019, 8, 28)),
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

class MainActivity : AppCompatActivity() {

    @SuppressLint("InflateParams", "NewApi", "SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
            period1StartBtn,
            period1EndBtn,
            period2StartBtn,
            period2EndBtn,
            period3StartBtn,
            period3EndBtn,
            period4StartBtn,
            period4EndBtn,
            period5StartBtn,
            period5EndBtn,
            period1TimeTv,
            period2TimeTv,
            period3TimeTv,
            period4TimeTv,
            period5TimeTv,
            periodStartTv,
            periodEndTv,
            schoolYearStartBtn,
            schoolYearEndBtn,
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
                        (0 until periodNames.size).forEach {
                            if (periodSpinners[k].adapter.getItem(it).toString().contains(
                                    weekDaySchedule[i].periods[k].className
                                )
                            ) {
                                periodSpinners[k].setSelection(it)
                            }
                        }
                    }
                }
            } else {
                dayButtons[i].setOnClickListener {
                    dayButtons.indices.forEach {
                        dayButtons[it].isChecked = false
                    }
                    dayButtons[i].isChecked = true
                    day = i
                    (periodSpinners.indices).forEach { k ->
                        periodSpinners[k].adapter = ArrayAdapter(
                            this,
                            android.R.layout.simple_spinner_dropdown_item,
                            periodNames
                        )
                        (0 until periodNames.size).forEach {
                            if (periodSpinners[k].adapter.getItem(it).toString().contains(
                                    nineDaySchedule[i - 5].periods[k].className
                                )
                            ) {
                                periodSpinners[k].setSelection(it)
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
                    periodDialogView.findViewById<EditText>(R.id.periodNameEt).text.clear()
                    periodDialogView.findViewById<EditText>(R.id.teacherEt).text.clear()
                    periodDialogView.findViewById<EditText>(R.id.classroomRoomEt).text.clear()
                    periodDialogView.findViewById<EditText>(R.id.groupEt).text.clear()
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
                    periodDialogView.findViewById<EditText>(R.id.periodNameEt).text.clear()
                    periodDialogView.findViewById<EditText>(R.id.teacherEt).text.clear()
                    periodDialogView.findViewById<EditText>(R.id.classroomRoomEt).text.clear()
                    periodDialogView.findViewById<EditText>(R.id.groupEt).text.clear()
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
                        periodDialogView.findViewById<EditText>(R.id.periodNameEt).text.clear()
                        periodDialogView.findViewById<EditText>(R.id.teacherEt).text.clear()
                        periodDialogView.findViewById<EditText>(R.id.classroomRoomEt).text.clear()
                        periodDialogView.findViewById<EditText>(R.id.groupEt).text.clear()
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
                    page1Objects.indices.forEach {
                        page1Objects[it].visibility = GONE
                    }
                    page2Objects.indices.forEach {
                        page2Objects[it].visibility = VISIBLE
                    }
                    holidayTgb2.performClick()
                    holidayChoiceSpn.setSelection(selectedHolidayList)
                }
            }
        }

        back1btn.setOnClickListener{
            selectedHolidayList = holidayChoiceSpn.selectedItemPosition
            page1Objects.indices.forEach {
                page1Objects[it].visibility = VISIBLE
            }
            page2Objects.indices.forEach {
                page2Objects[it].visibility = GONE
            }
            nineDaySw.isChecked = isItNineDays
            day1Btn.visibility = if (!isItNineDays) GONE else VISIBLE
            day2Btn.visibility = if (!isItNineDays)  GONE  else VISIBLE
            day3Btn.visibility = if (!isItNineDays)  GONE  else VISIBLE
            day4Btn.visibility = if (!isItNineDays)  GONE  else VISIBLE
            day5Btn.visibility = if (!isItNineDays)  GONE  else VISIBLE
            day6Btn.visibility = if (!isItNineDays)  GONE  else VISIBLE
            day7Btn.visibility = if (!isItNineDays)  GONE  else VISIBLE
            day8Btn.visibility = if (!isItNineDays)  GONE  else VISIBLE
            day9Btn.visibility = if (!isItNineDays)  GONE  else VISIBLE
            mondayBtn.visibility = if (isItNineDays)  GONE  else VISIBLE
            tuesdayBtn.visibility = if (isItNineDays)  GONE  else VISIBLE
            wednesdayBtn.visibility = if (isItNineDays)  GONE  else VISIBLE
            thursdayBtn.visibility = if (isItNineDays)  GONE  else VISIBLE
            fridayBtn.visibility = if (isItNineDays)  GONE  else VISIBLE
            if (isItNineDays) day1Btn.performClick() else mondayBtn.performClick()
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

        val datePickBtns = listOf<Button>(
            schoolYearStartBtn,
            schoolYearEndBtn
        )
        val timePickBtns = listOf<Button>(
            period1StartBtn,
            period1EndBtn,
            period2StartBtn,
            period2EndBtn,
            period3StartBtn,
            period3EndBtn,
            period4StartBtn,
            period4EndBtn,
            period5StartBtn,
            period5EndBtn
        )

        var firstTime = true
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
                    selectedHolidayList = holidayChoiceSpn.selectedItemPosition
                    page2Objects.indices.forEach {
                        page2Objects[it].visibility = GONE
                    }
                    page3Objects.indices.forEach {
                        page3Objects[it].visibility = VISIBLE
                    }
                    if (firstTime) {
                        firstTime = false

                    }
                    else{
                        datePickBtns.indices.forEach {
                            datePickBtns[it].text = schoolDays[it].toString()
                        }
                        timePickBtns.indices.forEach {
                            timePickBtns[it].text = schoolTimeInfo[it].toString()
                        }
                    }
                }
            }
        }

        val periodTimeBtns : List<TextView> = listOf(
            period1StartBtn,
            period1EndBtn,
            period2StartBtn,
            period2EndBtn,
            period3StartBtn,
            period3EndBtn,
            period4StartBtn,
            period4EndBtn,
            period5StartBtn,
            period5EndBtn,
            schoolYearStartBtn,
            schoolYearEndBtn
        )

        var pass = true

        next3Btn.setOnClickListener{
            periodTimeBtns.indices.forEach {
                if (periodTimeBtns[it].text.toString() == "" || periodTimeBtns[it].text.toString() == "NOT SET"){
                    pass = false
                }
            }
            if (pass){
                val generateCalendarBuilder = AlertDialog.Builder(this)
                generateCalendarBuilder.setTitle("Continue?")
                generateCalendarBuilder.setCancelable(false)
                generateCalendarBuilder.setMessage("Are you sure you want to continue?")
                generateCalendarBuilder.setPositiveButton("Continue") { _: DialogInterface, _: Int ->
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
            page2Objects.indices.forEach {
                page2Objects[it].visibility = VISIBLE
            }
            page3Objects.indices.forEach {
                page3Objects[it].visibility = GONE
            }
            holidayChoiceSpn.setSelection(selectedHolidayList)
        }

        val todayDate = Calendar.getInstance()

        datePickBtns.indices.forEach {
            val dateSetListener = DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
                todayDate.set(Calendar.YEAR, year)
                todayDate.set(Calendar.MONTH, monthOfYear)
                todayDate.set(Calendar.DAY_OF_MONTH, dayOfMonth)

                val myFormat = "EEE, MMM d, yyyy"
                val sdf = SimpleDateFormat(myFormat, Locale.US)
                datePickBtns[it].text = sdf.format(todayDate.time)
                schoolDays[it] = LocalDate.of(year, monthOfYear, dayOfMonth)
            }
            datePickBtns[it].setOnClickListener {
                DatePickerDialog(
                    this@MainActivity, dateSetListener,
                    todayDate.get(Calendar.YEAR),
                    todayDate.get(Calendar.MONTH),
                    todayDate.get(Calendar.DAY_OF_MONTH)
                ).show()
            }
        }

        timePickBtns.indices.forEach{ i ->
            timePickBtns[i].setOnClickListener {
                val cal = Calendar.getInstance()
                val timeSetListener = TimePickerDialog.OnTimeSetListener { _, hour, minute ->
                    cal.set(Calendar.HOUR_OF_DAY, hour)
                    cal.set(Calendar.MINUTE, minute)
                    timePickBtns[i].text = SimpleDateFormat("HH:mm").format(cal.time)
                    schoolTimeInfo[i] = LocalTime.of(hour,minute,0)
                }
                TimePickerDialog(this, timeSetListener, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), true).show()
            }
        }
    }


    @RequiresApi(Build.VERSION_CODES.O)
    fun createCSV() {
        val path = applicationContext.getExternalFilesDir(null)

        val letDirectory = File(path, "LET")

        if (!letDirectory.exists()){
            letDirectory.mkdirs()
        }

        val file = File(letDirectory, "test.txt")

        file.writeText("")
        file.appendText("Subject,Start Date,End Date,All Day Event,Start Time,End Time,Description,Location,Private\n")

        for (it in defaultHolidayChoices[selectedHolidayList]) {
            holidayDates.add(it.holidayDate)
            file.appendText("${it.holidayName}," +
                    "${it.holidayDate}," +
                    "${it.holidayDate}," +
                    "True,,,No school," +
                    "${schoolName}," +
                    "False\n")
        }

        var dayCount = schoolDays[0]
        var dayCountInt = 0
        val firstDay = schoolDays[0]
        val lastDay = schoolDays[1]

        val Months = (firstDay.monthValue..(firstDay.monthValue + 10))
        val Weeks = (1..4)
        val DayPeriods = (1..5)
        var iMonth = 0
        var iWeeks = 0
        var lastDayOfMonth = LocalDate.of(1,1,1)
        var iYear = schoolYear
        var dayOfSchedule = 1
        var periodNumber = 1

        for (asdf in Months){
            iMonth = asdf
            if (iMonth > 12) iMonth -= 12
            if (asdf == 12) {iYear = schoolYear + 1}
            lastDayOfMonth = LocalDate.of(schoolYear, iMonth + 1, 1).minusDays(1)
            if (iMonth == firstDay.monthValue){
                while (dayCount.dayOfMonth <= lastDayOfMonth.dayOfMonth){
                    if (dayCount.dayOfWeek == DayOfWeek.SUNDAY || dayCount.dayOfWeek == DayOfWeek.SATURDAY){
                    }
                    else{
                        for (edc in DayPeriods){
                            periodNumber = edc
                            with(nineDaySchedule[dayOfSchedule].periods[periodNumber]) {
                                file.appendText(
                                    className +
                                            ",$dayCount" +
                                            ",$dayCount," +
                                            "False," +
                                            "${schoolTimeInfo[(periodNumber - 1) * 2]}" +
                                            ",${schoolTimeInfo[(periodNumber - 1) * 2 + 1]}," +
                                            "$groupNumber with $teacher,$classNumber," +
                                            "False\n"
                                )
                            }
                        }
                    }
                    dayCount = dayCount.plusDays(1)
                    dayCountInt++

                }
                lastDayOfMonth.dayOfMonth - firstDay.dayOfMonth
            }
            else{
                for (xdlol in Weeks){
                    iWeeks = xdlol
                    firstDay.dayOfMonth
                }
            }

        }

        if (isItNineDays) {
            while (true) {
                for (it in nineDaySchedule.indices) {
                    if (dayCount.dayOfWeek == DayOfWeek.SATURDAY || dayCount.dayOfWeek == DayOfWeek.SUNDAY) {
                        dayCount = dayCount.plusDays(1)
                    }
                    for (periodNumber in (1..5)) {
                        if (!holidayDates.contains(dayCount)){
                            with(nineDaySchedule[it].periods[periodNumber]) {
                                file.appendText(
                                    className +
                                            ",$dayCount" +
                                            ",$dayCount," +
                                            "False," +
                                            "${schoolTimeInfo[(periodNumber - 1) * 2]}" +
                                            ",${schoolTimeInfo[(periodNumber - 1) * 2 + 1]}," +
                                            "$groupNumber with $teacher,$classNumber," +
                                            "False\n"
                                )
                            }
                        }
                    }
                    dayCountInt++
                    dayCount.plusDays(1)
                    if (dayCount == lastDay || firstDay.plusDays(dayCountInt.toLong()) == lastDay || dayCountInt > 250) {
                        break
                    }
                }

                if (dayCount == lastDay || firstDay.plusDays(dayCountInt.toLong()) == lastDay || dayCountInt > 250) {
                    break
                }
            }
        }

        else {
            while (true) {
                for (it in weekDaySchedule.indices) {
                    if (dayCount.dayOfWeek == DayOfWeek.SATURDAY || dayCount.dayOfWeek == DayOfWeek.SUNDAY) {
                        dayCount = dayCount.plusDays(1)
                    }
                    for (periodNumber in (1..5)) {
                        if (!holidayDates.contains(dayCount)){
                            with(weekDaySchedule[it].periods[periodNumber]) {
                                file.appendText(
                                    className +
                                            ",$dayCount" +
                                            ",$dayCount," +
                                            "False," +
                                            "${schoolTimeInfo[(periodNumber - 1) * 2]}" +
                                            ",${schoolTimeInfo[(periodNumber - 1) * 2 + 1]}," +
                                            "$groupNumber with $teacher,$classNumber," +
                                            "False\n"
                                )
                            }
                        }
                    }
                    dayCountInt++
                    dayCount.plusDays(1)
                    if (dayCount == lastDay || firstDay.plusDays(dayCountInt.toLong()) == lastDay || dayCountInt > 250) {
                        break
                    }
                }

                if (dayCount == lastDay || firstDay.plusDays(dayCountInt.toLong()) == lastDay || dayCountInt > 250) {
                    break
                }
            }
        }
        Toast.makeText(baseContext, "CSV file created!", Toast.LENGTH_SHORT).show()
    }

    fun isHoliday(date : LocalDate): Boolean {
        return holidayDates.contains(date)
    }
}



