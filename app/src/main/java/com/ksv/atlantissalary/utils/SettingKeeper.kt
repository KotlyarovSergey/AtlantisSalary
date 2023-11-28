package com.ksv.atlantissalary.utils

import android.content.SharedPreferences
import com.ksv.atlantissalary.model.AllWorkedHours
import com.ksv.atlantissalary.values.SavedFields

class SettingKeeper {

    fun saveUserDataSet(userDataSet: UserDataSet, sharedPrefs: SharedPreferences){
        val editor = sharedPrefs.edit()
        editor.putFloat(SavedFields.GRADE, userDataSet.grade.toFloat()).apply()
        editor.putFloat(SavedFields.TOTALHOURS, userDataSet.hours.totalWorkedHours.toFloat()).apply()
        editor.putFloat(SavedFields.NIGHTHOURS, userDataSet.hours.nightHorus.toFloat()).apply()
        editor.putFloat(SavedFields.OVDHOURS, userDataSet.hours.ovdHours.toFloat()).apply()
        editor.putFloat(SavedFields.OSRHOURS, userDataSet.hours.osrHours.toFloat()).apply()
        editor.putBoolean(SavedFields.OVERSHIFTS, userDataSet.overShifts).apply()
    }

    fun loadUserDataSet(sharedPrefs: SharedPreferences): UserDataSet{

        var grade = 0.0

        if(sharedPrefs.contains(SavedFields.GRADE)){
            // Получаем число из настроек
            grade = sharedPrefs.getFloat(SavedFields.GRADE, 0.0f).toDouble()
        }
        val totalHours = sharedPrefs.getFloat(SavedFields.TOTALHOURS, 0.0f).toDouble()
        val nightHours = sharedPrefs.getFloat(SavedFields.NIGHTHOURS, 0.0f).toDouble()
        val ovdHours = sharedPrefs.getFloat(SavedFields.OVDHOURS, 0.0f).toDouble()
        val osrHours = sharedPrefs.getFloat(SavedFields.OSRHOURS, 0.0f).toDouble()
        val overShifts = sharedPrefs.getBoolean(SavedFields.OVERSHIFTS, false)


        val allWorkedHours = AllWorkedHours(totalHours, nightHours, ovdHours, osrHours)
        return UserDataSet(grade, allWorkedHours, overShifts)
    }
}