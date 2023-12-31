package com.ksv.atlantissalary

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.ksv.atlantissalary.controller.Controller
import com.ksv.atlantissalary.controller.datasaver.ActivityData
import com.ksv.atlantissalary.controller.datasaver.impl.ActivityDataKeeper
import com.ksv.atlantissalary.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var controller: Controller
    private lateinit var prefs: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prefs = getSharedPreferences("settings", Context.MODE_PRIVATE)

        addListeners()

        controller = Controller(binding, this)
    }

    override fun onStart() {
        super.onStart()

        val activityDataKeeper = ActivityDataKeeper(prefs)
        val activityData = activityDataKeeper.load()
        applyActivityData(activityData)

        controller.onChangeInputData()
    }

    override fun onStop() {
        super.onStop()

        val dataSaver = ActivityDataKeeper(prefs)
        val activityData = gatherActivityData()
        dataSaver.save(activityData)
    }
//

    private fun addListeners() {
        addTextChangedListeners()
        addSwitchChangeListener()
        binding.buttonCalculate.setOnClickListener { inputDataChanged() }
    }

    private fun addSwitchChangeListener() {

        binding.switchOverShifts.setOnCheckedChangeListener { _, checked ->
            controller.onChangeInputData()
            if (checked) {
                binding.tableLayoutOverShifts.visibility = View.VISIBLE
            } else {
                binding.tableLayoutOverShifts.visibility = View.GONE
            }
        }
    }

    private fun addTextChangedListeners() {

        var grade = binding.editTextSalaryGrade.text.toString()
        binding.editTextSalaryGrade.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                if (binding.editTextSalaryGrade.text.toString() != grade)
                    inputDataChanged()
            } else {
                grade = binding.editTextSalaryGrade.text.toString()
            }
        }

        var totalHours = binding.editTextTotalHours.text.toString()
        binding.editTextTotalHours.setOnFocusChangeListener { _, hadFocus ->
            if (hadFocus) {
                totalHours = binding.editTextTotalHours.text.toString()
            } else {
                if (totalHours != binding.editTextTotalHours.text.toString())
                    inputDataChanged()
            }
        }

        var nightHours = binding.editTextNightHours.text.toString()
        binding.editTextNightHours.setOnFocusChangeListener { _, hadFocus ->
            if (hadFocus) {
                nightHours = binding.editTextNightHours.text.toString()
            } else {
                if (nightHours != binding.editTextNightHours.text.toString())
                    inputDataChanged()
            }

        }

        var dayOvershifts = binding.editTextDaysOvershifts.text.toString()
        binding.editTextDaysOvershifts.setOnFocusChangeListener { _, hadFocus ->
            if (hadFocus) {
                dayOvershifts = binding.editTextDaysOvershifts.text.toString()
            } else {
                if (dayOvershifts != binding.editTextDaysOvershifts.text.toString())
                    inputDataChanged()
            }
        }

        var nightOvershifts = binding.editTextNightOvershifts.text.toString()
        binding.editTextNightOvershifts.setOnFocusChangeListener { _, hadFocus ->
            if (hadFocus) {
                nightOvershifts = binding.editTextNightOvershifts.text.toString()
            } else {
                if (nightOvershifts != binding.editTextNightOvershifts.text.toString())
                    inputDataChanged()
            }

        }
    }

    private fun inputDataChanged() {
        controller.onChangeInputData()
    }

    private fun gatherActivityData(): ActivityData{
        val grade = binding.editTextSalaryGrade.text.toString()
        val totalHours = binding.editTextTotalHours.text.toString()
        val nightHours = binding.editTextNightHours.text.toString()
        val daysOvershifts = binding.editTextDaysOvershifts.text.toString()
        val nightOvershifts = binding.editTextNightOvershifts.text.toString()
        val overShiftsChecked = binding.switchOverShifts.isChecked

        return ActivityData(grade, totalHours, nightHours, daysOvershifts, nightOvershifts, overShiftsChecked)
    }

    private fun applyActivityData(activityData: ActivityData){
        binding.apply {
            editTextSalaryGrade.setText(activityData.grade)
            editTextTotalHours.setText(activityData.totalHours)
            editTextNightHours.setText(activityData.nightHours)
            editTextDaysOvershifts.setText(activityData.daysOverShifts)
            editTextNightOvershifts.setText(activityData.nightsOverShifts)
            switchOverShifts.isChecked = activityData.overShiftsExists
        }
    }
}