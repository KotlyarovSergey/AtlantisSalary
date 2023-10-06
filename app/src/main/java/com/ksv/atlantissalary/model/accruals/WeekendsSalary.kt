package com.ksv.atlantissalary.model.accruals

import com.ksv.atlantissalary.model.AllWorkedHours
import com.ksv.atlantissalary.model.SalaryCalc

class WeekendsSalary : SalaryCalc{
    private val nameOfAccural = "Оплата праздничных и выходных дней"
    override fun calc(grade: Double, allWorkedHours: AllWorkedHours): Double {
        return grade * allWorkedHours.ovdHours
    }
    override fun nameOfAccruals(): String {
        return this.nameOfAccural
    }
}