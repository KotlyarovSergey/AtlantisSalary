package com.ksv.atlantissalary.utils


import android.app.ActionBar
import android.app.Activity
import android.view.Gravity
import android.view.View
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import com.google.android.material.internal.ContextUtils.getActivity
import com.ksv.atlantissalary.MainActivity
import com.ksv.atlantissalary.R


class TableLayoutConstructor (val tableLayout: TableLayout, val activity: Activity){
    fun clear(){
        tableLayout.removeAllViews()
    }

    fun addTextViewRow(data: List<String>){
        val row = TableRow(activity)
        val layoutParams0 = TableRow.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT, 1f)
        val layoutParams1 = TableRow.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT, 30f)

        val tvName = TextView(activity)
        tvName.text = data[0]
        tvName.layoutParams = layoutParams0
        tvName.setBackgroundResource(R.drawable.border)

        val tvAmount = TextView(activity)
        tvAmount.text = data[1]
        //tvAmount.layoutParams = layoutParams1
        tvAmount.setPadding(2, 0, 10, 0)
        tvAmount.setBackgroundResource(R.drawable.border)

        row.addView(tvName)
        row.addView(tvAmount)

        tableLayout.addView(row)
    }

    fun addTitleRow(captions: List<String>){
        val row = TableRow(activity)
        val layoutParams0 = TableRow.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT, 5f)
        //val layoutParams1 = TableRow.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT, 1f)

        val tvName = TextView(activity)
        tvName.text = captions[0]
        tvName.layoutParams = layoutParams0
        tvName.setBackgroundResource(R.drawable.border)
        tvName.gravity = Gravity.CENTER

        val tvAmount = TextView(activity)
        tvAmount.text = captions[1]
        //tvAmount.layoutParams = layoutParams1
        tvAmount.setPadding(2, 0, 10, 0)
        tvAmount.setBackgroundResource(R.drawable.border)
        tvName.gravity = Gravity.CENTER

        row.addView(tvName)
        row.addView(tvAmount)
        tableLayout.addView(row)
    }



}