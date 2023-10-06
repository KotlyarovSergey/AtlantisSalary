package com.ksv.atlantissalary.model.accruals

import com.ksv.atlantissalary.model.SalaryCalc

class OvertimeSalry(val grade: Double, val osrHours: Double) : SalaryCalc{
    private val nameOfAccural = "Оплата сверхурочных часов"
    override fun calc(): Double {
        return this.grade * this.osrHours
    }
    override fun nameOfAccurals(): String {
        return this.nameOfAccural
    }
}