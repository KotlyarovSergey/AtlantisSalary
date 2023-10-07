package com.ksv.atlantissalary.view

import com.ksv.atlantissalary.databinding.ActivityMainBinding
import com.ksv.atlantissalary.model.NameAmountPair


class Viewer(private val binding: ActivityMainBinding) {
    fun addToTable(accruals: List<NameAmountPair>){

    }
    fun setTotalAmount(number: Double){
        binding.textViewAmount.text = String.format("%.2f", number)
    }

}