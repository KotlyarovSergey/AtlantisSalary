package com.ksv.atlantissalary

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import android.widget.ImageView
import com.ksv.atlantissalary.controller.Controller
import com.ksv.atlantissalary.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var controller: Controller


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        controller = Controller(binding)
        controller.onChangeInputData()
        addListeners()


    }

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
                //binding.tableLayoutOverShifts.visibility = View.VISIBLE
                binding.editTextDaysOvershifts.isEnabled = true
                binding.editTextNightOvershifts.isEnabled = true
                binding.textViewSwitchOverShifts.setTextColor(Color.BLACK)
                binding.textViewDaysOverShifts.setTextColor(Color.BLACK)
                binding.textViewNightOverShifts.setTextColor(Color.BLACK)
            } else {
                //binding.tableLayoutOverShifts.visibility = View.INVISIBLE
                binding.editTextDaysOvershifts.isEnabled = false
                binding.editTextNightOvershifts.isEnabled = false
                binding.textViewSwitchOverShifts.setTextColor(Color.GRAY)
                binding.textViewDaysOverShifts.setTextColor(Color.GRAY)
                binding.textViewNightOverShifts.setTextColor(Color.GRAY)
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