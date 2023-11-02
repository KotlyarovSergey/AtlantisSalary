package com.ksv.atlantissalary.model

import com.ksv.atlantissalary.model.accruals.AdditionalNightWeekedsSalary
import com.ksv.atlantissalary.model.accruals.AdditionalNightworkSalary
import com.ksv.atlantissalary.model.accruals.AdditionalWeekendsSalary
import com.ksv.atlantissalary.model.accruals.BaseSalary
import com.ksv.atlantissalary.model.accruals.FeedSalary
import com.ksv.atlantissalary.model.accruals.HarmfullnessSalary
import com.ksv.atlantissalary.model.accruals.OvertimeSalry
import com.ksv.atlantissalary.model.accruals.PremiumSalary
import com.ksv.atlantissalary.model.accruals.WeekendsSalary
import com.ksv.atlantissalary.values.Values

class SalaryCalculator (val grade: Double, val allWorkedHours: AllWorkedHours){
    private var totalAmount = 0.0
//    private var onHandAmount = 0.0
    fun calculate():List<NameAmountPair>{
        val accruals = listOf(
            OvertimeSalry(),
            FeedSalary(),
            BaseSalary(),
            PremiumSalary(),
            WeekendsSalary(),
            AdditionalWeekendsSalary(),
            HarmfullnessSalary(),
            AdditionalNightWeekedsSalary(),
            AdditionalNightworkSalary()
        )

        this.totalAmount = 0.0
//        this.onHandAmount = 0.0
        val allAccruals = mutableListOf<NameAmountPair>()
        for (accrual: Caclulable in accruals){
            val amount = accrual.calc(grade, allWorkedHours)
            if(amount > 0) {
                this.totalAmount += amount
                val name = accrual.nameOfAccruals()
                val nameAmountPair = NameAmountPair(name, amount)
                allAccruals.add(nameAmountPair)
            }
        }

        return allAccruals
    }

    fun calcOnHandAmount(childrenForDecrement: Int): Double{
        var onHandAmount = this.totalAmount * (1-Values.TAX)
        onHandAmount += childrenForDecrement * Values.CHILDREN_DECREMENT
        return onHandAmount
    }


}