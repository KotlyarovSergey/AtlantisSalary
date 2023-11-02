package com.ksv.atlantissalary.view

import android.app.Activity
import android.view.View
import com.ksv.atlantissalary.databinding.ActivityMainBinding
import com.ksv.atlantissalary.model.NameAmountPair
import com.ksv.atlantissalary.utils.TableLayoutConstructor


class Viewer(private val binding: ActivityMainBinding, val activity: Activity) {
    fun addToTable(accruals: List<NameAmountPair>) {

    }

    fun fillAccrualsTable(data: List<NameAmountPair>) {
        val tableLayout = binding.tableLayoutAccruals
        val tableConstructor = TableLayoutConstructor(tableLayout, activity)
        tableConstructor.clear()

        tableConstructor.addTitleRow(listOf("Вид начислений", "Сумма"))

        data.forEach {
            val amount = String.format("%.2f", it.amount)
            tableConstructor.addTextViewRow(listOf(it.accrualName, amount))
        }

        tableLayout.visibility = View.VISIBLE
    }

    fun setTotalAmount(amount: Double) {
        binding.textViewAmount.text = String.format("%.2f", amount)
    }

    fun setOnHandAmount(amount: Double) {
        binding.textViewOnHands.text = String.format("%.2f", amount)
    }

}