package com.ksv.atlantissalary.model.accruals

import com.ksv.atlantissalary.model.SalaryCalc

class WeekendsSalary(val grade: Double, val ovdHours: Double) : SalaryCalc{
    private val nameOfAccural = "Оплата праздничных и выходных дней"
    override fun calc(): Double {
        return this.grade * this.ovdHours
    }
    override fun nameOfAccurals(): String {
        return this.nameOfAccural
    }
}