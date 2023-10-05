package com.ksv.atlantissalary.model

class SalaryCalсulator (
    private val grade: Double,
    private val totalHours: TotalHours,
    private val overShifts: OverShifts){

    val OVDHOURSINDAYSHIFT = 11.0
    val OVDHOURSINNIGTSHIFT = 8.0
    val OSRHOURSINNIGTSHIFT = 3.0
    var PREMIUMPERCENT = 0.25
    val NIGHTADDITIONALPERCENT = 0.2
    val NIGHTWEEKENDADDITIONALPERCENT = 1.4
    val HARMFULLNESSPERCENT = 0.4

    var baseSalary: Double = 0.0
    var overtimeSalry: Double = 0.0
    var osrHours: Double = 0.0
    var ovdHours: Double = 0.0
    var weekendsSalary = 0.0
    var additionalWeekendsSalary = 0.0
    var premiumSalary = 0.0
    var additionalNightworkSalary = 0.0
    var additionalNightWeekedsSalary = 0.0
    var harmfullnessSalary = 0.0

    init {
        this.baseSalary = calcBaseSalary()
        calcOverHours()
        this.overtimeSalry = calcOvertimeSalary()
        this.weekendsSalary = this.calcWeekendsSalary()
        this.additionalWeekendsSalary = this.calcAdditionalWeekendsSalary()
        this.premiumSalary = this.calcPremiumSalary()
        this.additionalNightworkSalary = this.calcAdditionalNightworkSalary()
        this.additionalNightWeekedsSalary = this.calcAdditionalNightWeekendsSalary()
        this.harmfullnessSalary = this.calcHarmfullnessSalary()
    }
    private fun calcBaseSalary() : Double = this.grade * this.totalHours.workedHours

    private fun calcOverHours(){
        this.ovdHours = this.overShifts.daysOverShifts * OVDHOURSINDAYSHIFT
        this.ovdHours += this.overShifts.nightsOverShifts * OVDHOURSINNIGTSHIFT
        this.osrHours = this.overShifts.nightsOverShifts * OSRHOURSINNIGTSHIFT
    }

    private fun calcOvertimeSalary():Double = this.grade * this.osrHours
    private fun calcWeekendsSalary(): Double = this.grade * this.ovdHours
    private fun calcAdditionalWeekendsSalary(): Double = this.grade * this.ovdHours
    private fun calcPremiumSalary(): Double = (this.baseSalary + this.weekendsSalary + this.overtimeSalry) * PREMIUMPERCENT
    private fun calcAdditionalNightworkSalary(): Double = this.grade * this.totalHours.nightHorus * NIGHTADDITIONALPERCENT
    private fun calcAdditionalNightWeekendsSalary(): Double = this.grade * (this.osrHours / 3) * NIGHTWEEKENDADDITIONALPERCENT
    private fun calcHarmfullnessSalary(): Double = (this.baseSalary + this.weekendsSalary) * HARMFULLNESSPERCENT


}