package com.ksv.atlantissalary.model.accruals

import com.ksv.atlantissalary.model.AllWorkedHours
import com.ksv.atlantissalary.model.Caclulable

class BaseSalary : Caclulable {
    private val nameOfAccrual = "Оплата по часовому тарифу"
    override fun calc(grade: Double, allWorkedHours: AllWorkedHours): Double {
        return grade * allWorkedHours.totalWorkedHours
    }
    override fun nameOfAccruals(): String {
        return this.nameOfAccrual
    }
}