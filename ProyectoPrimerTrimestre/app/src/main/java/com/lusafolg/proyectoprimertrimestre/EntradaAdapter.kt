package com.lusafolg.proyectoprimertrimestre

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.lusafolg.proyectoprimertrimestre.databinding.ItemEntradaBinding

class EntradaAdapter(private val entradas: List<Entrada>, private val listener:OnClickListener): RecyclerView.Adapter<EntradaAdapter.ViewHolder>() {
    private lateinit var context: Context
    inner class ViewHolder(view: View):
        RecyclerView.ViewHolder(view) {
        val binding = ItemEntradaBinding.bind(view)

        fun setListener(entrada: Entrada, position: Int) {
            binding.root.setOnClickListener { listener.onClick(entrada,
                position) }

            binding.root.setOnLongClickListener { listener.onLongClick(entrada); true }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view =
            LayoutInflater.from(context).inflate(R.layout.item_entrada,
                parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = entradas.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val entrada = entradas.get(position)
        with(holder) {
            setListener(entrada, position + 1)
            binding.tvNombre.text=entrada.nombre
            binding.tvHabitat.text=entrada.habitat
            binding.tvUser.text=entrada.usuario.nombre
            Glide.with(context)
                .load(entrada.foto)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .into(binding.imgEntrada)

            Glide.with(context)
                .load(entrada.usuario.foto)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .circleCrop()
                .into(binding.imgPhoto)

        }
    }
}