package com.ksv.atlantissalary.model.accruals

import com.ksv.atlantissalary.model.AllWorkedHours
import com.ksv.atlantissalary.model.Caclulable

class PremiumSalary : Caclulable{
    private val nameOfAccrual = "Премия"
    private val premiumPercent = 0.25
    override fun calc(grade: Double, allWorkedHours: AllWorkedHours): Double {
        return grade * (allWorkedHours.totalWorkedHours + allWorkedHours.ovdHours + allWorkedHours.osrHours) * premiumPercent
    }
    override fun nameOfAccruals(): String {
        return this.nameOfAccrual
    }
}