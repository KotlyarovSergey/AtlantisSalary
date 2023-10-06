package com.ksv.atlantissalary.model.accruals

import com.ksv.atlantissalary.model.AllWorkedHours
import com.ksv.atlantissalary.model.SalaryCalc

class AdditionalWeekendsSalary : SalaryCalc {
    private val nameOfAccural = "Доплата за работу в праздники и выходные\n"
    override fun calc(grade: Double, allWorkedHours: AllWorkedHours): Double {
        return grade * allWorkedHours.ovdHours
    }
    override fun nameOfAccruals(): String {
        return this.nameOfAccural
    }
}