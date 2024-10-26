package com.example.pizza

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<Button>(R.id.orderButton).setOnClickListener {
            val sizeOfPizza =
                if(findViewById<RadioButton>(R.id.smallPizza).isChecked){
                    "mała"
                }else if(findViewById<RadioButton>(R.id.mediumPizza).isChecked){
                    "średnia"
                }else if(findViewById<RadioButton>(R.id.largePizza).isChecked){
                    "duża"
                }else{
                    ""
                }

            val extras = mutableListOf<String>()
            if(findViewById<CheckBox>(R.id.cheese).isChecked){
                extras.add("podwójny ser")
            }
            if(findViewById<CheckBox>(R.id.mushrooms).isChecked){
                extras.add("pieczarki")
            }
            if(findViewById<CheckBox>(R.id.salami).isChecked){
                extras.add("salami")
            }

            var extrasText = extras.toString()
            extrasText = extrasText.drop(1)
            extrasText = extrasText.dropLast(1)

            val text = "Wybrana pizza: $sizeOfPizza, dodatki: $extrasText"


            val resultText = findViewById<TextView>(R.id.textView)
            resultText.text = "Twoje zamówienie:\n$text"
        }
    }
}