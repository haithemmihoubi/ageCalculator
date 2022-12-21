package com.example.agecalculator

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       val button = findViewById<Button>(R.id.button)
        val pickedDate: TextView= findViewById(R.id.selectedDate)

        showDatePickerDialog(button, pickedDate)
        //calculateAge(pickedDate)
        val  day= Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        val  month= Calendar.getInstance().get(Calendar.MONTH)
        val  year = Calendar.getInstance().get(Calendar.YEAR)
        val  currentdate = "$day/$month/$year"
        pickedDate.text = currentdate

    }
    fun showDatePickerDialog(button: Button,pickedDate: TextView) {
        val  day= Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        val  month= Calendar.getInstance().get(Calendar.MONTH)
        val  year = Calendar.getInstance().get(Calendar.YEAR)
        button.setOnClickListener {
            DatePickerDialog(this, { _, year, month, dayOfMonth ->
                val selectedDate = "$dayOfMonth/${month + 1}/$year"
                pickedDate.text = selectedDate
                val date = selectedDate.split("/")
                val day = date[0].toInt()
                val month = date[1].toInt()
                val year = date[2].toInt()
                val currentDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
                val currentMonth = Calendar.getInstance().get(Calendar.MONTH) + 1
                val currentYear = Calendar.getInstance().get(Calendar.YEAR)
                var age = currentYear - year
                if (currentMonth <= month) {
                    if (currentMonth == month) {
                        if (currentDay < day) age--
                    } else age--
                }
                Toast.makeText(this, "Your age is $age years", Toast.LENGTH_LONG).show()

            }, year, month, day).show()


        }

    }
    fun calculateAge(selectedDate: TextView) {
        val date = selectedDate.text.split("/")
        val day = date[0].toInt()
        val month = date[1].toInt()
        val year = date[2].toInt()
        val currentDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        val currentMonth = Calendar.getInstance().get(Calendar.MONTH) + 1
        val currentYear = Calendar.getInstance().get(Calendar.YEAR)
        var age = currentYear - year
        if (currentMonth <= month) {
            if (currentMonth == month) {
                if (currentDay < day) age--
            } else age--
        }
        Toast.makeText(this, "Your age is $age years", Toast.LENGTH_LONG).show()
    }
}