package com.ksv.atlantissalary.model.accruals

import com.ksv.atlantissalary.model.AllWorkedHours
import com.ksv.atlantissalary.model.SalaryCalc

class AdditionalNightWeekedsSalary : SalaryCalc {
    private val nameOfAccural = "Доплата за ночные часы в праздничные и выходные дни"
    private val nightWeekendAdditionalPercent = 1.4
    private val hoursOfAdditionPayment = 3
    override fun calc(grade: Double, allWorkedHours: AllWorkedHours): Double {
        return grade * (allWorkedHours.osrHours / hoursOfAdditionPayment)  * nightWeekendAdditionalPercent
    }

    override fun nameOfAccruals(): String {
        return this.nameOfAccural
    }
}