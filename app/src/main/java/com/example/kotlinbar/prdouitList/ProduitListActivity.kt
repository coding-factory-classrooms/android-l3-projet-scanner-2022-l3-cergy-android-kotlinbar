package com.example.kotlinbar.prdouitList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinbar.Produits
import com.example.kotlinbar.databinding.ActivityProduitListBinding


class ProduitListActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityProduitListBinding
    private val model : ProduitListViewModel by viewModels()
    private lateinit var  adapter: ProduitAdapter

//    private val produit = listOf(
//        Produits(1, "coca", "coca-cola light", 5,"cafeine, sucre, eau")
//    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProduitListBinding.inflate(layoutInflater)
        setContentView(binding.root)

    adapter= ProduitAdapter(listOf() )

    binding.recyclerView.adapter = adapter
    binding.recyclerView.layoutManager = LinearLayoutManager(this)

    model.getProduitLiveData().observe(this, {produit ->updateProduits(produit!!)} )
    model.loadProduit()

    }

    private fun updateProduits(produit: List<Produit>) {
        adapter.updateDataSet(produit)
    }
}