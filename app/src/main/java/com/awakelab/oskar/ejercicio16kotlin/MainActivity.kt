package com.awakelab.oskar.ejercicio16kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.awakelab.oskar.ejercicio16kotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ItemAdapter.PaisCallback {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initAdapter()
    }

    private fun initAdapter() {
        val itemAdapter = ItemAdapter()
        val paises = PaisesLatam.paises
        itemAdapter.setData(paises)
        itemAdapter.callback = this
        binding.RV.adapter = itemAdapter
    }

    override fun showContry(poblacion: String, pais: String) {
        binding.tvCiudad.text = poblacion
        binding.tvPais.text = pais
    }


}