package com.ksv.atlantissalary.model.accruals

import com.ksv.atlantissalary.model.AllWorkedHours
import com.ksv.atlantissalary.model.Caclulable

class AdditionalNightworkSalary : Caclulable {
    private val nameOfAccrual = "Доплата за работу в ночное время"
    private val nightAdditionalPercent = 0.2
    override fun calc(grade: Double, allWorkedHours: AllWorkedHours): Double {
        return grade * allWorkedHours.nightHorus * nightAdditionalPercent
    }
    override fun nameOfAccruals(): String {
        return this.nameOfAccrual
    }
}