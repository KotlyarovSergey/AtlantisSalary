package com.ksv.atlantissalary.model.accruals

import com.ksv.atlantissalary.model.SalaryCalc

class BaseSalary(val grade: Double, val totalWorkedHours: Double) : SalaryCalc {
    private val nameOfAccural = "Оплата по часовому тарифу"
    override fun calc(): Double {
        return this.grade * totalWorkedHours
    }
    override fun nameOfAccurals(): String {
        return this.nameOfAccural
    }
}