package com.example.kotlinbar.Produit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.kotlinbar.Produits
import com.example.kotlinbar.R
import com.example.kotlinbar.produitsViewModel


class ProduitsActivity : AppCompatActivity() {
    private val model : produitsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page_details)

model.getProduits().observe(this, Observer { produits -> onProduitsUpdated(produits)})
    }

    private fun onProduitsUpdated(produits: Produits?) {
        Log.i("ProduitsActivity","onProduitsUpdated: $produits")
    }


}