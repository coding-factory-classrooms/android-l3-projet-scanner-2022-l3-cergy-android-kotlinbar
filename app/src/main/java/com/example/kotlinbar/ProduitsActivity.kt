package com.example.kotlinbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

const val TAG = "ApiResult"

class ProduitsActivity : AppCompatActivity() {

    private val url = "https://fr.openfoodfacts.org/"
    private val API_VER = "v0"
    private val API_P = "api/$API_VER"

    val retrofit = Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val service = retrofit.create(BarServices::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_produits)

        call.enqueue(object  : Callback<ApiBar> {
            override fun onResponse(call: Call<ApiBar>, response: Response<ApiBar>) {
                Log.i(TAG, "onResponse : ")
                val bar = response.body()
                if (bar != null) {
                    val ApiBarResponse = response.body()!!
                    val bar = mapApiBar(ApiBarResponse)
                    Log.i(TAG, "ApiBar : $ApiBarResponse")
                    Log.i(TAG, "bar: $bar")

                    val intent = Intent()

                    intent.putExtra("generic_name_fr", bar.generic_name_fr)
                    intent.putExtra("image_front_url", bar.image_front_url)
                    intent.putExtra("ingredients_text_fr", bar.ingredients_text_fr)
                    Log.i(TAG, "intent: $intent")
                    finish()
                }
            }

            override fun onFailure(call: Call<ApiBar>, t: Throwable) {
                Log.i(TAG, "onFailure: $t")
                error("error")
            }
        })
    }






















}
//
//    val TAG = "MainActivity"
//
//    private val model : produitsViewModel by viewModels()
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_produits)
//
//        val retrofit = Retrofit.Builder()
//            .baseUrl("http://fr.openfoodfacts.org")
//            .addConverterFactory(ScalarsConverterFactory.create())
//            .build()
////        val api = retrofit.create(BarServices::class.java)
//        val service: BarServices = retrofit.create(BarServices::class.java)
////val call = api.getRecipeData("42434")
//        val call:Call<String> = service.getProductByBarcode()
//
//        call.enqueue(object: Callback<String> {
//            override fun onResponse(call: Call<String>?, response: Response<String>?) {
//                Log.i(TAG, "Get response : ${response?.body()}")
//            }
//
//            override fun onFailure(call: Call<String>?, t: Throwable?) {
//                TODO("Not yet implemented")
//            }
//
//        })
//
//
//
//model.getProduits().observe(this, Observer { produits -> onProduitsUpdated(produits)})
//    }
//
//    private fun onProduitsUpdated(produits: Produits?) {
//        Log.i("ProduitsActivity","onProduitsUpdated: $produits")
//    }
//
//
//}