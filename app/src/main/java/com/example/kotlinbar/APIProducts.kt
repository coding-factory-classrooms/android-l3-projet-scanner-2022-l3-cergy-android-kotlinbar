package com.example.kotlinbar

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface APIProducts {

        @GET("{id}")
        fun listRepos(@Path("id") user: String?): Call<ClassProduits>?
    }
