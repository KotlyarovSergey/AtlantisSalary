package com.ksv.atlantissalary.controller.datasaver

data class ActivityData (
    val grade: String,
    val totalHours: String,
    val nightHours: String,
    val daysOverShifts: String,
    val nightsOverShifts: String,
    val overShiftsExists: Boolean
)