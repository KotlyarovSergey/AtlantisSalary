package com.ksv.atlantissalary.model.accruals

import com.ksv.atlantissalary.model.AllWorkedHours
import com.ksv.atlantissalary.model.Caclulable

class WeekendsSalary : Caclulable{
    private val nameOfAccrual = "Оплата праздничных и выходных дней"
    override fun calc(grade: Double, allWorkedHours: AllWorkedHours): Double {
        return grade * allWorkedHours.ovdHours
    }
    override fun nameOfAccruals(): String {
        return this.nameOfAccrual
    }
}