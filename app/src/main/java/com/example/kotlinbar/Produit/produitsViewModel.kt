package com.example.kotlinbar

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

data class Produits(val id : Int ,val nom : String , val generic_name : String ,val image : Int,val ingredients : String  );

class produitsViewModel : ViewModel(){

private val produits = MutableLiveData<Produits>()

  fun getProduits() : LiveData<Produits> = produits


fun loadProduits(produitsId : Int ){


}
}