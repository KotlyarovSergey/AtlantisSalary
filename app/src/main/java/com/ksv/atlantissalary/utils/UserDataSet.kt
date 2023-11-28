package com.ksv.atlantissalary.utils

import com.ksv.atlantissalary.model.AllWorkedHours

data class UserDataSet(
    val grade: Double,
    val hours: AllWorkedHours,
    val overShifts: Boolean
)
