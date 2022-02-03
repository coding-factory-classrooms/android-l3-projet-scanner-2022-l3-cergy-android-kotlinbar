package com.example.kotlinbar

import retrofit2.Call
import retrofit2.http.*

interface BarServices {
    companion object {
        private const val API_VER = "v0"
        private const val API_P = "api/$API_VER"


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
