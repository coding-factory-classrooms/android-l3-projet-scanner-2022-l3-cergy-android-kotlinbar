package com.example.kotlinbar.Produit

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ClassProduitsWrapperCode(
    val code: ClassProduitsWrapper
)
@JsonClass(generateAdapter = true)
data class ClassProduitsWrapper(
    val product: ClassProduits
)

@JsonClass(generateAdapter = true)
data class ClassProduits(
    val generic_name_fr : String , val ingredients_text_fr : String, val product_name_fr :String,
    );