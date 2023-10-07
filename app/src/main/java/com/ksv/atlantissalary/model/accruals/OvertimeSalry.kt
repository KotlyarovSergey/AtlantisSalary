package com.ksv.atlantissalary.model.accruals

import com.ksv.atlantissalary.model.AllWorkedHours
import com.ksv.atlantissalary.model.Caclulable

class OvertimeSalry : Caclulable{
    private val nameOfAccrual = "Оплата сверхурочных часов"
    override fun calc(grade: Double, allWorkedHours: AllWorkedHours): Double {
        return grade * allWorkedHours.osrHours
    }
    override fun nameOfAccruals(): String {
        return this.nameOfAccrual
    }
}