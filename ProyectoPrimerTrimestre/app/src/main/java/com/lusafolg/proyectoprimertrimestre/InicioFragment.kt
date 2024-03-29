package com.lusafolg.proyectoprimertrimestre

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.lusafolg.proyectoprimertrimestre.databinding.ActivityInicioBinding
import com.lusafolg.proyectoprimertrimestre.databinding.FragmentInicioBinding


class InicioFragment : Fragment(), OnClickListener {

    private lateinit var entradaAdapter: EntradaAdapter
    private lateinit var linearLayoutManager: RecyclerView.LayoutManager
    private var _binding:FragmentInicioBinding?=null
    private val binding get() = _binding!!

    private fun getEntradas(): MutableList<Entrada> {

        val entradas = mutableListOf<Entrada>()

        val u1 = Usuario(
            1,
            "FishEnjoyer92",
            "PECES",
            "Un fanático de los peces más.",
            "https://badis.es/img/cms/Blog/2022/marinos-faciles/pez-pallaso.jpg"
        )

        val u2 = Usuario(
            2,
            "FanDLosPeces",
            "FISH",
            "ME ENCANTAN LOS PECES.",
            "https://badis.es/img/cms/Blog/2022/marinos-faciles/pez-pallaso.jpg"
        )

        val e1 = Entrada(
            1,
            "Cirujano amarillo",
            "Es uno de los peces marinos más populares, resistentes y solicitados en acuariofilia. Es un ágil y vistoso nadador, además de sociable con la mayoría de habitantes del arrecife, a excepción de machos territoriales de su misma especie.",
            "Pez de agua salada",
            "https://badis.es/img/ets_blog/post/pez-cirujano-amarillo-badis-aquarios-reus.jpg",
            u1
        )

        val e2 = Entrada(
            2,
            "Cirujano azul",
            "El pez cirujano azul tiene un cuerpo comprimido lateralmente de color azul índigo y rayas negras, la superior desde el nacimiento de la aleta caudal hasta la cabeza, atravesando el ojo, y la inferior, aproximadamente hasta la altura de la aleta pectoral, que a menudo se unen dejando un círculo azul en el medio. Sus aletas dorsal y anal son de color azul coronadas ambas por una franja negra. Su aleta caudal es amarilla, así como el borde de sus aletas pectorales. La intensidad de la coloración varía en función de la edad.",
            "Pez de agua salada",
            "https://upload.wikimedia.org/wikipedia/commons/2/25/Blue_tang_%28Paracanthurus_hepatus%29_02.jpg",
            u2
        )

        val e3 = Entrada(
            3,
            "Cirujano amarillo",
            "Es uno de los peces marinos más populares, resistentes y solicitados en acuariofilia. Es un ágil y vistoso nadador, además de sociable con la mayoría de habitantes del arrecife, a excepción de machos territoriales de su misma especie.",
            "Pez de agua salada",
            "https://badis.es/img/ets_blog/post/pez-cirujano-amarillo-badis-aquarios-reus.jpg",
            u1
        )
        entradas.add(e1)

        entradas.add(e2)

        entradas.add(e3)

        return entradas

    }

    override fun onClick(entrada: Entrada, position: Int) {

        cambiarpantalla(EntradaActivity(), entrada.id)

    }

    override fun onLongClick(entrada: Entrada) {

        val preferences=InicioActivity().getPreferences(Context.MODE_PRIVATE)

        val strsetdef= setOf<String>("0")

        val listafavs=preferences.getStringSet("favs",strsetdef)

        if (listafavs!!.contains(entrada.id.toString())){

            Toast.makeText(requireContext(), "Esta entrada ya figura en Favoritos", Toast.LENGTH_SHORT).show()

        }else{

            listafavs.add(entrada.id.toString())

            with(preferences.edit()){

                putStringSet("favs", listafavs).apply()

            }

            Toast.makeText(requireContext(), "Entrada añadida a Favoritos", Toast.LENGTH_SHORT).show()

        }

    }

    private fun loadimage(url: String, id: ImageView) {
        Glide.with(this)
            .load(url)
            .diskCacheStrategy(
                DiskCacheStrategy.ALL
            ).centerCrop().circleCrop().into(id)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding=FragmentInicioBinding.inflate(inflater,container,false)
        val view=binding.root
        entradaAdapter = EntradaAdapter(getEntradas(), this)
        linearLayoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.apply {
            layoutManager = linearLayoutManager
            adapter = entradaAdapter
        }

        binding.user1.setOnClickListener(){

            cambiarpantalla(PerfilActivity(), 1)

        }

        binding.user2.setOnClickListener(){

            cambiarpantalla(PerfilActivity(), 2)

        }

        binding.user3.setOnClickListener(){

            cambiarpantalla(PerfilActivity(), 3)

        }

        binding.user4.setOnClickListener(){

            cambiarpantalla(PerfilActivity(), 4)

        }

        loadimage(
            "https://badis.es/img/cms/Blog/2022/marinos-faciles/pez-pallaso.jpg",
            binding.imgPhoto1
        )

        loadimage(
            "https://badis.es/img/cms/Blog/2022/marinos-faciles/pez-pallaso.jpg",
            binding.imgPhoto2
        )

        loadimage(
            "data:image/jpeg;base64,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",
            binding.imgPhoto3
        )

        loadimage(
            "data:image/jpeg;base64,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",
            binding.imgPhoto4
        )

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }

    private fun cambiarpantalla(destino:Activity,id:Int){

        val intent=Intent(requireContext(), destino::class.java).putExtra("id", id)

        startActivity(intent)

    }
}

