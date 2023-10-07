package com.ksv.atlantissalary.controller

import com.ksv.atlantissalary.databinding.ActivityMainBinding
import com.ksv.atlantissalary.model.AllWorkedHours
import com.ksv.atlantissalary.model.NameAmountPair
import com.ksv.atlantissalary.model.SalaryCalculator
import com.ksv.atlantissalary.view.Viewer

class Controller(private val binding: ActivityMainBinding) {
    private var grade = 0.0
    lateinit private var allWorkedHours: AllWorkedHours
    private var viever = Viewer(binding)

    fun onChangeInputData(){
        getGrade()
        getAllWorkedHours()

        val salaryCalculator = SalaryCalculator(grade, allWorkedHours)
        val accruals = salaryCalculator.calculate()
        fillTable(accruals)
        fillTotalAmount(accruals)
    }

    private fun getGrade(){
        try {
            grade = binding.editTextSalaryGrade.text.toString().toDouble()
        } catch (e: Exception) {
            grade = 0.0
        }
    }
    private fun getAllWorkedHours() {
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

        } catch (e: Exception) {
            // do nothing
        }
        val ovdHours = dayOverShifts * ovdHoursInDayShift + nightOverShifts * ovdHoursInNightShift
        val osrHours = nightOverShifts * osrHoursInNightShift
        allWorkedHours = AllWorkedHours(allHours, nightHours, ovdHours, osrHours)
    }
    private fun fillTable(accruals: List<NameAmountPair>){

    }
    private fun fillTotalAmount(accruals: List<NameAmountPair>){
        var summ = 0.0
        for(once : NameAmountPair in accruals){
            summ += once.amount
        }
        viever.setTotalAmount(summ)
    }

}