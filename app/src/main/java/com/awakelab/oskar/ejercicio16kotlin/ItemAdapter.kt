package com.awakelab.oskar.ejercicio16kotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.awakelab.oskar.ejercicio16kotlin.databinding.ItemLayoutBinding

class ItemAdapter : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {
    var paises = mutableListOf<Pais>()
    var callback: PaisCallback? = null
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

    inner class ViewHolder(val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(pais: Pais) {
            binding.textView.text = pais.nombre
            binding.imageView.load(pais.imgUrl)
            binding.cardView1.setOnClickListener(View.OnClickListener {
                val poblacion = "Poblacion: ${pais.poblacion}"
                val pais = "Pais: ${pais.nombre}"
                callback?.showContry(poblacion, pais)

                /*Toast.makeText(
                     itemView.context,
                     "Pais: ${pais.nombre}, Poblacion: ${pais.poblacion}",
                     Toast.LENGTH_SHORT
                 ).show()*/
            })
        }


    }

    interface PaisCallback {
        fun showContry(poblacion: String, pais: String)
    }

}