package com.ksv.atlantissalary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import com.ksv.atlantissalary.controller.Controller
import com.ksv.atlantissalary.databinding.ActivityMainBinding
import com.ksv.atlantissalary.model.AllWorkedHours
import com.ksv.atlantissalary.model.NameAmountPair
import com.ksv.atlantissalary.model.SalaryCalculator
import com.ksv.atlantissalary.view.Viewer

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var controller : Controller

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        controller = Controller(binding)
        addTextChangedListeners()

        binding.buttonCalculate.setOnClickListener { controller.onChangeInputData() }

    }

     private fun addTextChangedListeners() {
        binding.editTextSalaryGrade.addTextChangedListener { controller.onChangeInputData() }
        binding.editTextTotalHours.addTextChangedListener { controller.onChangeInputData() }
        binding.editTextNightHours.addTextChangedListener { controller.onChangeInputData() }
        binding.editTextDaysOvershifts.addTextChangedListener { controller.onChangeInputData() }
        binding.editTextNightOvershifts.addTextChangedListener { controller.onChangeInputData() }
    }

}