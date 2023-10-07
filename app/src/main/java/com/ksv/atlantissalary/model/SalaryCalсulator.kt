package com.ksv.atlantissalary.model

import com.ksv.atlantissalary.model.accruals.AdditionalNightWeekedsSalary
import com.ksv.atlantissalary.model.accruals.AdditionalNightworkSalary
import com.ksv.atlantissalary.model.accruals.AdditionalWeekendsSalary
import com.ksv.atlantissalary.model.accruals.BaseSalary
import com.ksv.atlantissalary.model.accruals.FeedSalary
import com.ksv.atlantissalary.model.accruals.HarmfullnessSalary
import com.ksv.atlantissalary.model.accruals.OvertimeSalry
import com.ksv.atlantissalary.model.accruals.PremiumSalary
import com.ksv.atlantissalary.model.accruals.WeekendsSalary

class SalaryCalculator (val grade: Double, val allWorkedHours: AllWorkedHours){
    //var summary: String = ""
    fun calculate():List<NameAmountPair>{
        val accruals = listOf(
            OvertimeSalry(),
            FeedSalary(),
            BaseSalary(),
            PremiumSalary(),
            WeekendsSalary(),
            AdditionalWeekendsSalary(),
            HarmfullnessSalary(),
            AdditionalNightWeekedsSalary(),
            AdditionalNightworkSalary()
        )

        val allAccruals = mutableListOf<NameAmountPair>()
        for (accrual: Caclulable in accruals){
            val amount = accrual.calc(grade, allWorkedHours)
            val name = accrual.nameOfAccruals()
            val nameAmountPair = NameAmountPair(name, amount)
            allAccruals.add(nameAmountPair)
        }

        return allAccruals
    }


}