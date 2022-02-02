package com.example.kotlinbar

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.inputmethod.InputBinding
import androidx.constraintlayout.widget.ConstraintSet
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinbar.databinding.ItemProduitBinding

class ProduitAdapter (private var produit : List<Produits>)
    : RecyclerView.Adapter<ProduitAdapter.ViewHolder>()
{
    class ViewHolder(val binding: ItemProduitBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemProduitBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produit = produit.get(position)
        with(holder.binding) {
            nameProduit.text = produit.nom
            description.text="description"
            produitImage.setImageResource(produit.image)

        }
    }

    override fun getItemCount(): Int {
        return produit.size
    }
}