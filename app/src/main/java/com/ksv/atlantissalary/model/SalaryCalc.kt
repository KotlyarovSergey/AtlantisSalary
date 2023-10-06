package com.ksv.atlantissalary.model

interface SalaryCalc {
//    fun calc(): Double
    fun calc(grade: Double, allWorkedHours: AllWorkedHours): Double
    fun nameOfAccruals() : String
}