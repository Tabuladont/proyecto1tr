package com.lusafolg.proyectoprimertrimestre

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lusafolg.proyectoprimertrimestre.databinding.FragmentHistorialBinding

class HistorialFragment : Fragment(),OnClickListener {
    private lateinit var entradaAdapter: EntradaAdapter
    private lateinit var linearLayoutManager: RecyclerView.LayoutManager
    private var _binding: FragmentHistorialBinding?=null
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

        val e4 = Entrada(
            4,
            "Cirujano azul",
            "El pez cirujano azul tiene un cuerpo comprimido lateralmente de color azul índigo y rayas negras, la superior desde el nacimiento de la aleta caudal hasta la cabeza, atravesando el ojo, y la inferior, aproximadamente hasta la altura de la aleta pectoral, que a menudo se unen dejando un círculo azul en el medio. Sus aletas dorsal y anal son de color azul coronadas ambas por una franja negra. Su aleta caudal es amarilla, así como el borde de sus aletas pectorales. La intensidad de la coloración varía en función de la edad.",
            "Pez de agua salada",
            "https://upload.wikimedia.org/wikipedia/commons/2/25/Blue_tang_%28Paracanthurus_hepatus%29_02.jpg",
            u2
        )
        entradas.add(e1)

        entradas.add(e2)

        entradas.add(e3)

        entradas.add(e4)



        return entradas

    }

    override fun onClick(entrada: Entrada, position: Int) {

        cambiarpantalla(EntradaActivity(), entrada.id)

    }

    override fun onLongClick(entrada: Entrada) {
        TODO("Not yet implemented")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding= FragmentHistorialBinding.inflate(inflater,container,false)
        val view=binding.root
        entradaAdapter = EntradaAdapter(getEntradas(), this)
        linearLayoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.apply {
            layoutManager = linearLayoutManager
            adapter = entradaAdapter
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }

    private fun cambiarpantalla(destino: Activity, id:Int){

        val intent= Intent(requireContext(), destino::class.java).putExtra("id", id)

        startActivity(intent)

    }
}