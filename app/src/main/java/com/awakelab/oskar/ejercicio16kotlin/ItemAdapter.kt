package com.awakelab.oskar.ejercicio16kotlin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.awakelab.oskar.ejercicio16kotlin.databinding.ItemLayoutBinding

class ItemAdapter : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {
    var paises = mutableListOf<Pais>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemLayoutBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return paises.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = paises[position]
        holder.bind(item)
    }

    fun setData(listaPaises: List<Pais>) {
        this.paises = listaPaises.toMutableList()
    }

    class ViewHolder(val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(pais: Pais) {
            binding.textView.text = pais.nombre
            binding.imageView.load(pais.imgUrl)
        }


    }

}