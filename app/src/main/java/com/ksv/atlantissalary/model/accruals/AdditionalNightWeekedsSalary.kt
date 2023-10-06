package com.ksv.atlantissalary.model.accruals

import com.ksv.atlantissalary.model.SalaryCalc

class AdditionalNightWeekedsSalary(val grade: Double, val osrHours: Double) : SalaryCalc {
    private val nameOfAccural = "Доплата за ночные часы в праздничные и выходные дни"
    private val nightWeekendAdditionalPercent = 1.4
    private val hoursOfAdditionPayment = 3
    override fun calc(): Double {
        return this.grade * (this.osrHours / hoursOfAdditionPayment)  * nightWeekendAdditionalPercent
    }

    override fun nameOfAccurals(): String {
        return this.nameOfAccural
    }
}