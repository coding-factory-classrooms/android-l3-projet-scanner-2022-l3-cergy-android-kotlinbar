package com.example.kotlinbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.kotlinbar.Scanner.ScannerActivity

class MainActivity : AppCompatActivity()  {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

          val button = findViewById<Button>(R.id.Scannerbutton)
            button.setOnClickListener{
               val intent = Intent(this, ScannerActivity::class.java)
                startActivity(intent)
            }


        }
    }

