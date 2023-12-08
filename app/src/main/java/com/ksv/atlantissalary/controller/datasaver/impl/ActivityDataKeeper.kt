package com.ksv.atlantissalary.controller.datasaver.impl

import android.content.SharedPreferences
import com.ksv.atlantissalary.controller.datasaver.ActivityData
import com.ksv.atlantissalary.controller.datasaver.DataSaver
import com.ksv.atlantissalary.values.SavedFields

class ActivityDataKeeper (private val sharedPrefs: SharedPreferences): DataSaver<ActivityData>{
    override fun save(data: ActivityData) {
        val editor = sharedPrefs.edit()
        editor.putString(SavedFields.GRADE, data.grade).apply()
        editor.putString(SavedFields.TOTALHOURS, data.totalHours).apply()
        editor.putString(SavedFields.NIGHTHOURS, data.nightHours).apply()
        editor.putString(SavedFields.DAYOVERSHIFTS, data.daysOverShifts).apply()
        editor.putString(SavedFields.NIGHTOVERSHIFTS, data.nightsOverShifts).apply()
        editor.putBoolean(SavedFields.OVERSHIFTSCHECKED, data.overShiftsExists).apply()
    }

    override fun load(): ActivityData {
        val grade = sharedPrefs.getString(SavedFields.GRADE, "0") ?: "0"
        val totalHours = sharedPrefs.getString(SavedFields.TOTALHOURS, "0") ?: "0"
        val nightHours = sharedPrefs.getString(SavedFields.NIGHTHOURS, "0") ?: "0"
        val daysOverShifts = sharedPrefs.getString(SavedFields.DAYOVERSHIFTS, "0") ?: "0"
        val nightsOverShifts = sharedPrefs.getString(SavedFields.NIGHTOVERSHIFTS, "0") ?: "0"
        val overShiftsExists = sharedPrefs.getBoolean(SavedFields.OVERSHIFTSCHECKED, false)
        return ActivityData(grade, totalHours, nightHours, daysOverShifts, nightsOverShifts, overShiftsExists)
    }

}