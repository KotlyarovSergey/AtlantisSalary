package com.ksv.atlantissalary.model.accruals

import com.ksv.atlantissalary.model.SalaryCalc

class AdditionalNightworkSalary(val grade: Double, val nightHorus: Double) : SalaryCalc {
    private val nameOfAccural = "Доплата за работу в ночное время"
    private val nightAdditionalPercent = 0.2
    override fun calc(): Double {
        return this.grade * this.nightHorus * nightAdditionalPercent
    }
    override fun nameOfAccurals(): String {
        return this.nameOfAccural
    }
}