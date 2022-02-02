package com.example.kotlinbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinbar.databinding.ActivityProduitListBinding


class ProduitListActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityProduitListBinding

//    private val produit = listOf(
//        Produits()
//    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProduitListBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}