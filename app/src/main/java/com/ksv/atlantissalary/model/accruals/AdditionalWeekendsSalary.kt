package com.ksv.atlantissalary.model.accruals

import com.ksv.atlantissalary.model.SalaryCalc

class AdditionalWeekendsSalary(val grade: Double, val ovdHours: Double) : SalaryCalc {
    private val nameOfAccural = "Доплата за работу в праздники и выходные\n"
    override fun calc(): Double {
        return this.grade * this.ovdHours
    }
    override fun nameOfAccurals(): String {
        return this.nameOfAccural
    }
}