package com.ksv.atlantissalary.model.accruals

import com.ksv.atlantissalary.model.SalaryCalc

class HarmfullnessSalary(val grade: Double, val totalWorkedHours: Double, val ovdHours: Double) : SalaryCalc {
    private val nameOfAccural = "Доплата за вредные условия 31_ЧасоваяТС"
    private val harmfulnessPercent = 0.04
    override fun calc(): Double {
        return this.grade * (this.totalWorkedHours + this.ovdHours) * this.harmfulnessPercent
    }
    override fun nameOfAccurals(): String {
        return this.nameOfAccural
    }
}