package com.example.kotlinbar.API

import com.example.kotlinbar.Produit.ClassProduits
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface APIProducts {

        @GET("{id}.json")
        fun listRepos(@Path("id") user: String?): Call<ClassProduits>?
    }
