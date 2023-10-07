package com.ksv.atlantissalary.model.accruals

import com.ksv.atlantissalary.model.AllWorkedHours
import com.ksv.atlantissalary.model.Caclulable

class FeedSalary : Caclulable {
    private val nameOfAccrual = "Оплата питания"
    override fun calc(grade: Double, allWorkedHours: AllWorkedHours): Double {
        return allWorkedHours.totalWorkedHours + allWorkedHours.ovdHours + allWorkedHours.osrHours
    }

    override fun nameOfAccruals(): String {
        return this.nameOfAccrual
    }

}