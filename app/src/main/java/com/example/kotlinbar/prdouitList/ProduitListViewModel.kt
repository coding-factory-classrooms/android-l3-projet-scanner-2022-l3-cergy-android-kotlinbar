package com.example.kotlinbar.prdouitList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinbar.R

class ProduitListViewModel : ViewModel() {

    private val produitLiveData = MutableLiveData<List<Produit>>()
    fun getProduitLiveData(): LiveData<List<Produit>> = produitLiveData

    private  val produits = listOf(
        Produit("coca","boisson a base de cafeine,sucre, eau...", R.drawable.coca),
        Produit("coca","boisson a base de cafeine,sucre, eau...", R.drawable.coca),
        Produit("coca","boisson a base de cafeine,sucre, eau...", R.drawable.coca),
        Produit("coca","boisson a base de cafeine,sucre, eau...", R.drawable.coca),
        Produit("coca","boisson a base de cafeine,sucre, eau...", R.drawable.coca),
    )

    fun loadProduit(){
        produitLiveData.value = produits
    }
}