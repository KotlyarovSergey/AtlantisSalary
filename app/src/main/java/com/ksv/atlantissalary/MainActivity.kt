package com.ksv.atlantissalary

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TableRow
import android.widget.TextView
import com.ksv.atlantissalary.controller.Controller
import com.ksv.atlantissalary.databinding.ActivityMainBinding
import com.ksv.atlantissalary.model.AllWorkedHours
import com.ksv.atlantissalary.utils.SettingKeeper
import com.ksv.atlantissalary.utils.UserDataSet

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var controller: Controller
    private lateinit var prefs: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        controller = Controller(binding, this)
        controller.onChangeInputData()
        addListeners()

        prefs = getSharedPreferences("settings", Context.MODE_PRIVATE)

    }

    override fun onStart() {
        super.onStart()
        val settingKeeper = SettingKeeper()
        val userDataSet = settingKeeper.loadUserDataSet(prefs)
        binding.editTextSalaryGrade.setText(userDataSet.grade.toString())
    }

    override fun onStop() {
        super.onStop()
        val settingKeeper = SettingKeeper()
        val grade = binding.editTextSalaryGrade.toString().toDouble()
        val userDataSet = UserDataSet(grade, AllWorkedHours(0.0, 0.0, 0.0, 0.0), false)
        settingKeeper.saveUserDataSet(userDataSet, prefs)
    }
//

    private fun addListeners() {
        addTextChangedListeners()
        addSwitchChangeListener()
        binding.buttonCalculate.setOnClickListener { inputDataChanged() }


    }

    private fun addSwitchChangeListener() {
        // binding.switchOverShifts.setOnClickListener {
        //    controller.onChangeInputData()
        // }
        binding.switchOverShifts.setOnCheckedChangeListener { _, checked ->
            controller.onChangeInputData()
            if (checked) {
                binding.tableLayoutOverShifts.visibility = View.VISIBLE
//                binding.tableLayoutOverShifts.layoutParams.height = LayoutParams.WRAP_CONTENT

//                binding.editTextDaysOvershifts.isEnabled = true
//                binding.editTextNightOvershifts.isEnabled = true
//                binding.textViewSwitchOverShifts.setTextColor(Color.BLACK)
//                binding.textViewDaysOverShifts.setTextColor(Color.BLACK)
//                binding.textViewNightOverShifts.setTextColor(Color.BLACK)
            } else {
                binding.tableLayoutOverShifts.visibility = View.GONE
//                binding.tableLayoutOverShifts.layoutParams.height = 0

//                binding.editTextDaysOvershifts.isEnabled = false
//                binding.editTextNightOvershifts.isEnabled = false
//                binding.textViewSwitchOverShifts.setTextColor(Color.GRAY)
//                binding.textViewDaysOverShifts.setTextColor(Color.GRAY)
//                binding.textViewNightOverShifts.setTextColor(Color.GRAY)
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

}