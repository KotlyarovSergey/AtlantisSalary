package com.ksv.atlantissalary.model

data class AllWorkedHours(
    val totalWorkedHours: Double,
    val nightHorus: Double,
    var ovdHours: Double,
    var osrHours: Double
)
