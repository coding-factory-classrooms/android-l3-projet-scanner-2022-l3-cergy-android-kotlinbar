package com.example.kotlinbar.Produit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.kotlinbar.API.BarServices

import com.example.kotlinbar.Produits
import com.example.kotlinbar.R
import com.example.kotlinbar.produitsViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


const val TAG = "ApiResult"

class ProduitsActivity : AppCompatActivity() {

    private val url = "https://fr.openfoodfacts.org/"
    private val API_VER = "v0"
    private val API_P = "api/$API_VER"

    val retrofit = Retrofit.Builder()
        .baseUrl(" https://world.openfoodfacts.org/api/v0/product/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val service = retrofit.create(BarServices::class.java)

    private val model : produitsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page_details)
        val call = service.getProductByBarcode()
        call.enqueue(object  : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                Log.i(TAG, "onResponse : ${response.body()}")
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                Log.i(TAG, "onFailure: $t")
                error("error")
            }
        })
    }

    private fun onProduitsUpdated(produits: Produits?) {
        Log.i("ProduitsActivity","onProduitsUpdated: $produits")
    }


}