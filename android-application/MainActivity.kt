<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <EditText
        android:id="@+id/schoolNameEt"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:ems="10"
        android:hint="@string/school_name_box_hint"
        android:importantForAutofill="no"
        android:inputType="textPersonName"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintHorizontal_bias="0.191"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.049" />

    <Spinner
        android:id="@+id/schoolYearSpn"
        android:layout_width="215dp"
        android:layout_height="40dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintHorizontal_bias="0.191"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.13" />

    <Switch
        android:id="@+id/nineDaySw"
        android:layout_width="95dp"
        android:layout_height="51dp"
        android:text="@string/nine_day_switch_text"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintHorizontal_bias="0.879"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.088" />

    <ToggleButton
        android:id="@+id/mondayBtn"
        android:layout_width="@dimen/day_button_width"
        android:layout_height="@dimen/day_button_height"
        android:text="@string/monday_button_text"
        android:textOff="@string/monday_button_text"
        android:textOn="@string/monday_button_text"
        android:visibility="visible"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintHorizontal_bias="0.047"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.213" />


    <ToggleButton
        android:id="@+id/tuesdayBtn"
        android:layout_width="@dimen/day_button_width"
        android:layout_height="@dimen/day_button_height"
        android:text="@string/tuesday_button_text"
        android:textOff="@string/tuesday_button_text"
        android:textOn="@string/tuesday_button_text"
        android:visibility="visible"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintHorizontal_bias="0.27"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.213" />

    <ToggleButton
        android:id="@+id/wednesdayBtn"
        android:layout_width="@dimen/day_button_width"
        android:layout_height="@dimen/day_button_height"
        android:text="@string/wednesday_button_text"
        android:textOff="@string/wednesday_button_text"
        android:textOn="@string/wednesday_button_text"
        android:visibility="visible"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintHorizontal_bias="0.494"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.213" />

    <ToggleButton
        android:id="@+id/thursdayBtn"
        android:layout_width="@dimen/day_button_width"
        android:layout_height="@dimen/day_button_height"
        android:text="@string/thursday_button_text"
        android:textOff="@string/thursday_button_text"
        android:textOn="@string/thursday_button_text"
        android:visibility="visible"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintHorizontal_bias="0.717"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.213" />

    <ToggleButton
        android:id="@+id/fridayBtn"
        android:layout_width="@dimen/day_button_width"
        android:layout_height="@dimen/day_button_height"
        android:text="@string/friday_button_text"
        android:textOff="@string/friday_button_text"
        android:textOn="@string/friday_button_text"
        android:visibility="visible"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintHorizontal_bias="0.94"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.213" />

    <ToggleButton
        android:id="@+id/day1Btn"
        android:layout_width="@dimen/day_button_width"
        android:layout_height="@dimen/day_button_height"
        android:text="@string/day1_button_text"
        android:textOff="@string/day1_button_text"
        android:textOn="@string/day1_button_text"
        android:visibility="gone"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintHorizontal_bias="0.047"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.213" />


    <ToggleButton
        android:id="@+id/day2Btn"
        android:layout_width="@dimen/day_button_width"
        android:layout_height="@dimen/day_button_height"
        android:text="@string/day2_button_text"
        android:textOff="@string/day2_button_text"
        android:textOn="@string/day2_button_text"
        android:visibility="gone"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintHorizontal_bias="0.27"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.213" />

    <ToggleButton
        android:id="@+id/day3Btn"
        android:layout_width="@dimen/day_button_width"
        android:layout_height="@dimen/day_button_height"
        android:text="@string/day3_button_text"
        android:textOff="@string/day3_button_text"
        android:textOn="@string/day3_button_text"
        android:visibility="gone"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintHorizontal_bias="0.494"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.213" />

    <ToggleButton
        android:id="@+id/day4Btn"
        android:layout_width="@dimen/day_button_width"
        android:layout_height="@dimen/day_button_height"
        android:text="@string/day4_button_text"
        android:textOff="@string/day4_button_text"
        android:textOn="@string/day4_button_text"
        android:visibility="gone"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintHorizontal_bias="0.717"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.213" />

    <ToggleButton
        android:id="@+id/day5Btn"
        android:layout_width="@dimen/day_button_width"
        android:layout_height="@dimen/day_button_height"
        android:text="@string/day5_button_text"
        android:textOff="@string/day5_button_text"
        android:textOn="@string/day5_button_text"
        android:visibility="gone"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintHorizontal_bias="0.94"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.213" />

    <ToggleButton
        android:id="@+id/day6Btn"
        android:layout_width="@dimen/day_button_width"
        android:layout_height="@dimen/day_button_height"
        android:text="@string/day6_button_text"
        android:textOff="@string/day6_button_text"
        android:textOn="@string/day6_button_text"
        android:visibility="gone"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintHorizontal_bias="0.157"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.268" />

    <ToggleButton
        android:id="@+id/day7Btn"
        android:layout_width="@dimen/day_button_width"
        android:layout_height="@dimen/day_button_height"
        android:text="@string/day7_button_text"
        android:textOff="@string/day7_button_text"
        android:textOn="@string/day7_button_text"
        android:visibility="gone"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintHorizontal_bias="0.38"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.268" />

    <ToggleButton
        android:id="@+id/day8Btn"
        android:layout_width="@dimen/day_button_width"
        android:layout_height="@dimen/day_button_height"
        android:text="@string/day8_button_text"
        android:textOff="@string/day8_button_text"
        android:textOn="@string/day8_button_text"
        android:visibility="gone"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintHorizontal_bias="0.607"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.268" />

    <ToggleButton
        android:id="@+id/day9Btn"
        android:layout_width="@dimen/day_button_width"
        android:layout_height="@dimen/day_button_height"
        android:text="@string/day9_button_text"
        android:textOff="@string/day9_button_text"
        android:textOn="@string/day9_button_text"
        android:visibility="gone"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintHorizontal_bias="0.83"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.268" />

    <Button
        android:id="@+id/newPeriodBtn"
        android:layout_width="@dimen/create_new_period_button_width"
        android:layout_height="@dimen/create_new_period_button_height"
        android:text="@string/create_new_period_button_text"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintHorizontal_bias="0.5"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.348" />

    <Spinner
        android:id="@+id/period3spn"
        android:layout_width="match_parent"
        android:layout_height="40dp"
        android:layout_marginLeft="@dimen/period_spinner_side_margin"
        android:layout_marginRight="@dimen/period_spinner_side_margin"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintHorizontal_bias="0.0"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.613" />

    <Spinner
        android:id="@+id/period1spn"
        android:layout_width="match_parent"
        android:layout_height="40dp"
        android:layout_marginLeft="@dimen/period_spinner_side_margin"
        android:layout_marginRight="@dimen/period_spinner_side_margin"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintHorizontal_bias="0.0"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.439" />

    <Spinner
        android:id="@+id/period2spn"
        android:layout_width="match_parent"
        android:layout_height="40dp"
        android:layout_marginLeft="@dimen/period_spinner_side_margin"
        android:layout_marginRight="@dimen/period_spinner_side_margin"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintHorizontal_bias="0.0"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.526" />

    <Spinner
        android:id="@+id/period5spn"
        android:layout_width="match_parent"
        android:layout_height="40dp"
        android:layout_marginLeft="@dimen/period_spinner_side_margin"
        android:layout_marginRight="@dimen/period_spinner_side_margin"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintHorizontal_bias="0.0"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.782" />

    <Spinner
        android:id="@+id/period4spn"
        android:layout_width="match_parent"
        android:layout_height="40dp"
        android:layout_marginLeft="@dimen/period_spinner_side_margin"
        android:layout_marginRight="@dimen/period_spinner_side_margin"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintHorizontal_bias="0.0"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.697" />


    <Button
        android:id="@+id/next1Btn"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="start"
        android:text="@string/next_button_text"
        android:enabled="false"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintHorizontal_bias="0.5"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.959" />

    <CheckBox
        android:id="@+id/confirmChk"
        android:layout_width="@dimen/confirm_box_height"
        android:layout_height="wrap_content"
        android:text="@string/new_period_confirm_checkbox_text"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintHorizontal_bias="0.5"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.869"/>

    <Button
        android:id="@+id/back1btn"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/back_button_text"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintHorizontal_bias="0.176"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.948"
        android:visibility="gone"/>

    <Button
        android:id="@+id/next2btn"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/next_button_text"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintHorizontal_bias="0.842"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.948"
        android:visibility="gone"/>

    <Button
        android:id="@+id/addHolidayBtn"
        android:layout_width="@dimen/add_holiday_button_width"
        android:layout_height="@dimen/add_period_button_height"
        android:text="@string/add_holiday_button_text"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.4"
        android:visibility="gone"/>

    <Spinner
        android:id="@+id/holidayChoiceSpn"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginLeft="@dimen/period_spinner_side_margin"
        android:layout_marginRight="@dimen/period_spinner_side_margin"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintHorizontal_bias="1.0"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.782"
        android:visibility="gone"/>

    <TextView
        android:id="@+id/holidayTitle1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/holiday_title_1_text"
        android:textSize="@dimen/holiday_title_text_size_1"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintHorizontal_bias="0.5"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.077"
        android:visibility="gone"/>

    <TextView
        android:id="@+id/holidayTitle2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/holiday_title_2_text"
        android:textSize="@dimen/holiday_title_text_size_2"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintHorizontal_bias="0.5"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.559"
        android:visibility="gone"/>

    <TextView
        android:id="@+id/holidayTitle3"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textSize="@dimen/holiday_title_text_size_1"
        android:text="@string/holiday_title_3_text"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintHorizontal_bias="0.5"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.692"
        android:visibility="gone"/>

    <ToggleButton
        android:id="@+id/holidayTgb1"
        android:layout_width="@dimen/holiday_toggle_button_width"
        android:layout_height="@dimen/holiday_toggle_button_height"
        android:textOff="@string/empty_string"
        android:textOn="@string/empty_string"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintHorizontal_bias="0.05"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.076"
        android:visibility="gone"/>

    <ToggleButton
        android:id="@+id/holidayTgb2"
        android:layout_width="@dimen/holiday_toggle_button_width"
        android:layout_height="@dimen/holiday_toggle_button_height"
        android:textOff="@string/empty_string"
        android:textOn="@string/empty_string"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintHorizontal_bias="0.05"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.694"
        android:visibility="gone"/>

    <Button
        android:id="@+id/back2Btn"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/back_button_text"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintHorizontal_bias="0.207"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.91"
        android:visibility="gone"/>

    <Button
        android:id="@+id/next3Btn"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/next_button_text"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintHorizontal_bias="0.77"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.91"
        android:visibility="gone"/>

    <EditText
        android:id="@+id/period1StartEt"
        android:layout_width="@dimen/period_time_edittext_width"
        android:layout_height="@dimen/period_time_edittext_height"
        android:ems="10"
        android:inputType="textPersonName"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintHorizontal_bias="0.462"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.454"
        android:importantForAutofill="no"
        android:hint="@string/period_time_edittext_hint"
        android:visibility="gone" />

    <EditText
        android:id="@+id/period2StartEt"
        android:layout_width="@dimen/period_time_edittext_width"
        android:layout_height="@dimen/period_time_edittext_height"
        android:ems="10"
        android:inputType="textPersonName"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintHorizontal_bias="0.462"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.525"
        android:importantForAutofill="no"
        android:hint="@string/period_time_edittext_hint"
        android:visibility="gone" />

    <EditText
        android:id="@+id/period3StartEt"
        android:layout_width="@dimen/period_time_edittext_width"
        android:layout_height="@dimen/period_time_edittext_height"
        android:ems="10"
        android:inputType="textPersonName"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintHorizontal_bias="0.462"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.594"
        android:importantForAutofill="no"
        android:hint="@string/period_time_edittext_hint"
        android:visibility="gone"/>

    <EditText
        android:id="@+id/period4StartEt"
        android:layout_width="@dimen/period_time_edittext_width"
        android:layout_height="@dimen/period_time_edittext_height"
        android:ems="10"
        android:inputType="textPersonName"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintHorizontal_bias="0.462"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.661"
        android:importantForAutofill="no"
        android:hint="@string/period_time_edittext_hint"
        android:visibility="gone" />


    <EditText
        android:id="@+id/period5StartEt"
        android:layout_width="@dimen/period_time_edittext_width"
        android:layout_height="@dimen/period_time_edittext_height"
        android:ems="10"
        android:inputType="textPersonName"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintHorizontal_bias="0.462"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.729"
        android:importantForAutofill="no"
        android:hint="@string/period_time_edittext_hint"
        android:visibility="gone" />

    <EditText
        android:id="@+id/period1EndEt"
        android:layout_width="@dimen/period_time_edittext_width"
        android:layout_height="@dimen/period_time_edittext_height"
        android:ems="10"
        android:inputType="textPersonName"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintHorizontal_bias="0.861"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.454"
        android:importantForAutofill="no"
        android:hint="@string/period_time_edittext_hint"
        android:visibility="gone" />

    <EditText
        android:id="@+id/period2EndEt"
        android:layout_width="@dimen/period_time_edittext_width"
        android:layout_height="@dimen/period_time_edittext_height"
        android:ems="10"
        android:inputType="textPersonName"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintHorizontal_bias="0.861"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.525"
        android:importantForAutofill="no"
        android:hint="@string/period_time_edittext_hint"
        android:visibility="gone" />

    <EditText
        android:id="@+id/period3EndEt"
        android:layout_width="@dimen/period_time_edittext_width"
        android:layout_height="@dimen/period_time_edittext_height"
        android:ems="10"
        android:inputType="textPersonName"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintHorizontal_bias="0.861"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.594"
        android:importantForAutofill="no"
        android:hint="@string/period_time_edittext_hint"
        android:visibility="gone"  />


    <EditText
        android:id="@+id/period4EndEt"
        android:layout_width="@dimen/period_time_edittext_width"
        android:layout_height="@dimen/period_time_edittext_height"
        android:ems="10"
        android:inputType="textPersonName"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintHorizontal_bias="0.861"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.66"
        android:importantForAutofill="no"
        android:hint="@string/period_time_edittext_hint"
        android:visibility="gone"/>


    <EditText
        android:id="@+id/period5EndEt"
        android:layout_width="@dimen/period_time_edittext_width"
        android:layout_height="@dimen/period_time_edittext_height"
        android:ems="10"
        android:inputType="textPersonName"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintHorizontal_bias="0.861"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.729"
        android:importantForAutofill="no"
        android:hint="@string/period_time_edittext_hint"
        android:visibility="gone" />

    <TextView
        android:id="@+id/period1Time"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/period_1_time_text"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintHorizontal_bias="0.088"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.457"
        android:visibility="gone" />

    <TextView
        android:id="@+id/period2Time"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/period_2_time_text"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintHorizontal_bias="0.088"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.523"
        android:visibility="gone"/>

    <TextView
        android:id="@+id/period3Time"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/period_3_time_text"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintHorizontal_bias="0.088"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.591"
        android:visibility="gone"/>


    <TextView
        android:id="@+id/period4Time"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/period_4time_text"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintHorizontal_bias="0.088"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.655"
        android:visibility="gone"/>

    <TextView
        android:id="@+id/period5Time"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/period_5time_text"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintHorizontal_bias="0.088"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.724"
        android:visibility="gone"/>

    <TextView
        android:id="@+id/periodStart"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/period_start_text"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintHorizontal_bias="0.474"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.394"
        android:visibility="gone" />

    <TextView
        android:id="@+id/periodEnd"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/period_end_text"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintHorizontal_bias="0.818"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.394"
        android:visibility="gone" />

    <TextView
        android:id="@+id/schoolYearStartTv"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/school_start_text"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintHorizontal_bias="0.054"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.172"
        android:visibility="gone"/>

    <TextView
        android:id="@+id/schoolYearEndTv"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/school_end_text"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintHorizontal_bias="0.054"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.258"
        android:visibility="gone" />

    <EditText
        android:id="@+id/schoolYearStartEt"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:ems="10"
        android:inputType="date"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintHorizontal_bias="0.843"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.16"
        android:importantForAutofill="no"
        android:hint="@string/period_time_edittext_hint"
        android:visibility="gone"/>

    <EditText
        android:id="@+id/schoolYearEndEt"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:ems="10"
        android:inputType="date"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintHorizontal_bias="0.843"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.253"
        android:importantForAutofill="no"
        android:hint="@string/period_time_edittext_hint"
        android:visibility="gone" />


</androidx.constraintlayout.widget.ConstraintLayout>
