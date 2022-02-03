package com.example.kotlinbar


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Movie : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        data class produits(val nom : String , val category : String ,val image : Int,val ingredients : String  );


    }
}