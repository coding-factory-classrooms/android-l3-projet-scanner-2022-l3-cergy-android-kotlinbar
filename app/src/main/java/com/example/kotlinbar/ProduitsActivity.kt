package com.example.kotlinbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel






class ProduitsActivity : AppCompatActivity() {
    private val model : produitsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_produits)

model.getProduits().observe(this, Observer { produits -> onProduitsUpdated(produits)})
    }

    private fun onProduitsUpdated(produits: Produits?) {
        Log.i("ProduitsActivity","onProduitsUpdated: $produits")
    }


}