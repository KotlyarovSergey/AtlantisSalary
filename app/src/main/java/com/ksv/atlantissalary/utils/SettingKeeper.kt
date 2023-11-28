package com.ksv.atlantissalary.utils

import android.content.SharedPreferences
import com.ksv.atlantissalary.values.SavedFields

class SettingKeeper {

    fun saveUserDataSet(userDataSet: UserDataSet, sharedPrefs: SharedPreferences){
        val editor = sharedPrefs.edit()
        editor.putFloat(SavedFields.GRADE, userDataSet.grade).apply()
        editor.putFloat(SavedFields.TOTALHOURS, userDataSet.totalHours).apply()
        editor.putFloat(SavedFields.NIGHTHOURS, userDataSet.nightHours).apply()
        editor.putInt(SavedFields.DAYOVERSHIFTS, userDataSet.daysOverShifts).apply()
        editor.putInt(SavedFields.NIGHTOVERSHIFTS, userDataSet.nightsOverShifts).apply()
        editor.putBoolean(SavedFields.OVERSHIFTSCHECKED, userDataSet.overShiftsChecked).apply()
    }

    fun loadUserDataSet(sharedPrefs: SharedPreferences): UserDataSet{

        var grade = 0.0f

        if(sharedPrefs.contains(SavedFields.GRADE)){
            // Получаем число из настроек
            grade = sharedPrefs.getFloat(SavedFields.GRADE, 0.0f)
        }
        val totalHours = sharedPrefs.getFloat(SavedFields.TOTALHOURS, 0.0f)
        val nightHours = sharedPrefs.getFloat(SavedFields.NIGHTHOURS, 0.0f)
        val ovdShifts = sharedPrefs.getInt(SavedFields.DAYOVERSHIFTS, 0)
        val osrShifts = sharedPrefs.getInt(SavedFields.NIGHTOVERSHIFTS, 0)
        val overShifts = sharedPrefs.getBoolean(SavedFields.OVERSHIFTSCHECKED, false)

        return UserDataSet(grade, totalHours, nightHours, ovdShifts, osrShifts, overShifts)
    }
}