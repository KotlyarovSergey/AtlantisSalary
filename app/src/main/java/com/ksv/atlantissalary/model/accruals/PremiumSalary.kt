package com.ksv.atlantissalary.model.accruals

import com.ksv.atlantissalary.model.AllWorkedHours
import com.ksv.atlantissalary.model.SalaryCalc

class PremiumSalary(val grade: Double, val allWorkedHours: AllWorkedHours) : SalaryCalc{
    private val nameOfAccural = "Премия"
    private val premiumPercent = 0.25
    override fun calc(): Double {
        return grade * (allWorkedHours.totalWorkedHours + allWorkedHours.ovdHours + allWorkedHours.osrHours) * premiumPercent
    }
    override fun nameOfAccurals(): String {
        return this.nameOfAccural
    }
}