package com.ksv.atlantissalary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TableRow
import com.ksv.atlantissalary.databinding.ActivityMainBinding
import com.ksv.atlantissalary.model.OverShifts
import com.ksv.atlantissalary.model.SalaryCalсulator
import com.ksv.atlantissalary.model.TotalHours

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalculate.setOnClickListener {
            val grade = binding.editTextSalaryGrade.text.toString().toDouble()
            val totalHours = getTotalHours()
            val overShifts = getOverShifts()

            val salaryCalсulator = SalaryCalсulator(grade, totalHours, overShifts)

            val baseSalary = salaryCalсulator.baseSalary
            val premiumSalary = salaryCalсulator.premiumSalary
            val weekendsSalary = salaryCalсulator.weekendsSalary
            val additionalWeekendsSalary = salaryCalсulator.additionalWeekendsSalary
            val overtimeSalry = salaryCalсulator.overtimeSalry
            val additionalNightworkSalary = salaryCalсulator.additionalNightworkSalary
            val additionalNightWeekedsSalary = salaryCalсulator.additionalNightWeekedsSalary
            val harmfullnessSalary = salaryCalсulator.harmfullnessSalary

            val sum = (baseSalary + premiumSalary + weekendsSalary + additionalWeekendsSalary
                    + overtimeSalry+ additionalNightworkSalary + additionalNightWeekedsSalary
                    + harmfullnessSalary)

            binding.textViewAmount.text = sum.toString()

            val stringBuilder = StringBuilder()
            stringBuilder.append(String.format("Bs: %.2f, \n", baseSalary))
                .append(String.format("Pr: %.2f, \n", premiumSalary))
                .append(String.format("We: %.2f, \n", weekendsSalary))
                .append(String.format("Aw: %.2f, \n", additionalWeekendsSalary))
                .append(String.format("Ov: %.2f, \n", overtimeSalry))
                .append(String.format("An: %.2f, \n", additionalNightworkSalary))
                .append(String.format("Anw: %.2f, \n", additionalNightWeekedsSalary))
                .append(String.format("Hf: %.2f", harmfullnessSalary))

            binding.textView10.text = stringBuilder.toString()


        }
    }

    fun getTotalHours(): TotalHours{
        val allHours = binding.editTextTotalHours.text.toString().toDouble()
        val nightHours = binding.editTextNightHours.text.toString().toDouble()
        return TotalHours(allHours, nightHours)
    }
    fun getOverShifts(): OverShifts{
        val dayOverShifts = binding.editTextDaysOvershifts.text.toString().toInt()
        val nightOverShifts = binding.editTextNightOvershifts.text.toString().toInt()
        return OverShifts(dayOverShifts, nightOverShifts)
    }

}