package com.ksv.atlantissalary.model.accruals

import com.ksv.atlantissalary.model.AllWorkedHours
import com.ksv.atlantissalary.model.SalaryCalc

class OvertimeSalry : SalaryCalc{
    private val nameOfAccural = "Оплата сверхурочных часов"
    override fun calc(grade: Double, allWorkedHours: AllWorkedHours): Double {
        return grade * allWorkedHours.osrHours
    }
    override fun nameOfAccruals(): String {
        return this.nameOfAccural
    }
}