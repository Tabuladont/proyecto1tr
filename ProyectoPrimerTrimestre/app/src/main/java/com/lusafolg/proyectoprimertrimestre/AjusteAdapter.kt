package com.lusafolg.proyectoprimertrimestre

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.lusafolg.proyectoprimertrimestre.databinding.ItemAjusteBinding
import com.lusafolg.proyectoprimertrimestre.databinding.ItemEntradaBinding

class AjusteAdapter(private val ajustes: List<Ajuste>, private val listener:OnClickListener): RecyclerView.Adapter<AjusteAdapter.ViewHolder>() {
    private lateinit var context: Context
    inner class ViewHolder(view: View):
        RecyclerView.ViewHolder(view) {
        val binding = ItemAjusteBinding.bind(view)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view =
            LayoutInflater.from(context).inflate(R.layout.item_entrada,
                parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = ajustes.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ajuste = ajustes.get(position)
        with(holder) {

            binding.tvAjuste.text=ajuste.texto

        }
    }
}