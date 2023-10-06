package com.ksv.atlantissalary.model.accruals

import com.ksv.atlantissalary.model.AllWorkedHours
import com.ksv.atlantissalary.model.SalaryCalc

class HarmfullnessSalary : SalaryCalc {
    private val nameOfAccural = "Доплата за вредные условия 31_ЧасоваяТС"
    private val harmfulnessPercent = 0.04
    override fun calc(grade: Double, allWorkedHours: AllWorkedHours): Double {
        return grade * (allWorkedHours.totalWorkedHours + allWorkedHours.ovdHours) * this.harmfulnessPercent
    }
    override fun nameOfAccruals(): String {
        return this.nameOfAccural
    }
}