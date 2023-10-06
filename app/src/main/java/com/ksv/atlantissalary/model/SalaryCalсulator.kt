package com.ksv.atlantissalary.model

import com.ksv.atlantissalary.model.accruals.AdditionalNightWeekedsSalary
import com.ksv.atlantissalary.model.accruals.AdditionalNightworkSalary
import com.ksv.atlantissalary.model.accruals.AdditionalWeekendsSalary
import com.ksv.atlantissalary.model.accruals.BaseSalary
import com.ksv.atlantissalary.model.accruals.HarmfullnessSalary
import com.ksv.atlantissalary.model.accruals.OvertimeSalry
import com.ksv.atlantissalary.model.accruals.PremiumSalary
import com.ksv.atlantissalary.model.accruals.WeekendsSalary

class SalaryCalculator (val grade: Double, val allWorkedHours: AllWorkedHours){
    //var summary: String = ""
    fun calculate():Double{
        val accruals = listOf(
            BaseSalary(),
            PremiumSalary(),
            WeekendsSalary(),
            AdditionalWeekendsSalary(),
            OvertimeSalry(),
            AdditionalNightworkSalary(),
            AdditionalNightWeekedsSalary(),
            HarmfullnessSalary()
        )

        var amount = 0.0
        for (salaryCalc: SalaryCalc in accruals){
            val salary = salaryCalc.calc(grade, allWorkedHours)
            amount += salary
            //this.summary += String.format("%.2f", salary) + "\n"
        }

        return amount
    }


}