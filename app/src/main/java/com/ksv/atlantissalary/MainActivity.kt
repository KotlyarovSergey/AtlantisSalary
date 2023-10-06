package com.ksv.atlantissalary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ksv.atlantissalary.databinding.ActivityMainBinding
import com.ksv.atlantissalary.model.AllWorkedHours
import com.ksv.atlantissalary.model.SalaryCalculator

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalculate.setOnClickListener {
            val grade = binding.editTextSalaryGrade.text.toString().toDouble()
            val allWorkedHours = getAllWorkedHours()

            val salaryCalculator = SalaryCalculator(grade, allWorkedHours)
            val sum = salaryCalculator.calculate()
            binding.textViewAmount.text = String.format("%.2f",sum)
            //binding.textView10.text = salaryCalculator.summary

        }
    }

    fun getAllWorkedHours(): AllWorkedHours{
        val ovdHoursInDayShift = 11.0
        val ovdHoursInNightShift = 8.0
        val osrHoursInNightShift = 3.0

        var allHours = 0.0
        var nightHours = 0.0
        var dayOverShifts = 0
        var nightOverShifts = 0
        try {
            allHours = binding.editTextTotalHours.text.toString().toDouble()
            nightHours = binding.editTextNightHours.text.toString().toDouble()
            dayOverShifts = binding.editTextDaysOvershifts.text.toString().toInt()
            nightOverShifts = binding.editTextNightOvershifts.text.toString().toInt()

        } catch (e: Exception){

        }
        val ovdHours = dayOverShifts * ovdHoursInDayShift +  nightOverShifts * ovdHoursInNightShift
        val osrHours = nightOverShifts * osrHoursInNightShift
        return AllWorkedHours(allHours, nightHours, ovdHours, osrHours)
    }
}