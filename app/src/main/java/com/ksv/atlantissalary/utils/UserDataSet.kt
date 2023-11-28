package com.ksv.atlantissalary.utils


data class UserDataSet(
    val grade: Float,
    val totalHours: Float,
    val nightHours: Float,
    val daysOverShifts: Int,
    val nightsOverShifts: Int,
    val overShiftsChecked: Boolean
)
