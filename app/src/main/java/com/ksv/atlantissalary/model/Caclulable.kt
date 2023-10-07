package com.ksv.atlantissalary.model

interface Caclulable {
//    fun calc(): Double
    fun calc(grade: Double, allWorkedHours: AllWorkedHours): Double
    fun nameOfAccruals() : String
}