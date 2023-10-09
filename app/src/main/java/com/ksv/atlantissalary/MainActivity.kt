package com.ksv.atlantissalary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ksv.atlantissalary.controller.Controller
import com.ksv.atlantissalary.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var controller : Controller


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        controller = Controller(binding)
        addTextChangedListeners()

        binding.buttonCalculate.setOnClickListener { inputDataChanged() }


    }

     private fun addTextChangedListeners() {

         var grade = binding.editTextSalaryGrade.text.toString()
         binding.editTextSalaryGrade.setOnFocusChangeListener { view, hasFocus ->
             if (!hasFocus){
                 if (binding.editTextSalaryGrade.text.toString() != grade)
                     inputDataChanged()
             }else{
                 grade = binding.editTextSalaryGrade.text.toString()
             }
         }

         var totalHours = binding.editTextTotalHours.text.toString()
         binding.editTextTotalHours.setOnFocusChangeListener { view, hadFocus ->
             if(hadFocus){
                 totalHours = binding.editTextTotalHours.text.toString()
             } else{
                 if(totalHours != binding.editTextTotalHours.text.toString())
                     inputDataChanged()
             }
         }

         var  nightHours = binding.editTextNightHours.text.toString()
         binding.editTextNightHours.setOnFocusChangeListener { view, hadFocus ->
             if(hadFocus){
                 nightHours = binding.editTextNightHours.text.toString()
             } else{
                 if(nightHours != binding.editTextNightHours.text.toString())
                     inputDataChanged()
             }

         }

         var dayOvershifts = binding.editTextDaysOvershifts.text.toString()
         binding.editTextDaysOvershifts.setOnFocusChangeListener { view, hadFocus ->
             if(hadFocus){
                 dayOvershifts = binding.editTextDaysOvershifts.text.toString()
             }else{
                 if(dayOvershifts != binding.editTextDaysOvershifts.text.toString())
                     inputDataChanged()
             }
         }

         var nightOvershifts = binding.editTextNightOvershifts.text.toString()
         binding.editTextNightOvershifts.setOnFocusChangeListener { view, hadFocus ->
             if(hadFocus){
                 nightOvershifts = binding.editTextNightOvershifts.text.toString()
             }else{
                 if(nightOvershifts != binding.editTextNightOvershifts.text.toString())
                     inputDataChanged()
             }

         }
    }

    private fun inputDataChanged(){
        controller.onChangeInputData()
    }

}