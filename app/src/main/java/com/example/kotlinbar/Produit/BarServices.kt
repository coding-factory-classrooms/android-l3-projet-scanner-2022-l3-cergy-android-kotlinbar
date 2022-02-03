package com.example.kotlinbar
import androidx.activity.viewModels
import android.os.Bundle
import android.util.Log
import com.example.kotlinbar.Produit.TAG
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.*

var retrofit = Retrofit.Builder()
    .baseUrl("https://api.github.com/")
    .build()

private val url = "https://fr.openfoodfacts.org/"
private val API_VER = "v0"
private val API_P = "api/$API_VER"

val service = retrofit.create(BarServices::class.java)



private fun onProduitsUpdated(produits: Produits?) {
    Log.i("ProduitsActivity","onProduitsUpdated: $produits")
}
interface BarServices {
    companion object {
        private const val API_VER = "v0"
        private const val API_P = "api/$API_VER"
     //    var service: GitHubService = retrofit.create(GitHubService::class.java)

    }


    @GET("$API_P/product/7613287335524.json?product_name_fr")
    fun getProductByBarcode(): Call<String>

    @GET("$API_P/product/{result.content}.json?fields=ingredients")
    fun getIngredientsByBarcode(@Path("barcode") barcode: String)

    @GET("$API_P/product/{barcode}.json?fields=images")
    fun getProductImages(@Path("barcode") barcode: String)

    @GET("$API_P/product/{barcode}.json?fields=generic_name")
    fun getProductGenericName(@Path("barcode") barcode: String)

}
