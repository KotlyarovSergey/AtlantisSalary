package com.ksv.atlantissalary.model.accruals

import com.ksv.atlantissalary.model.AllWorkedHours
import com.ksv.atlantissalary.model.SalaryCalc

class BaseSalary : SalaryCalc {
    private val nameOfAccural = "Оплата по часовому тарифу"
    override fun calc(grade: Double, allWorkedHours: AllWorkedHours): Double {
        return grade * allWorkedHours.totalWorkedHours
    }
    override fun nameOfAccruals(): String {
        return this.nameOfAccural
    }
}