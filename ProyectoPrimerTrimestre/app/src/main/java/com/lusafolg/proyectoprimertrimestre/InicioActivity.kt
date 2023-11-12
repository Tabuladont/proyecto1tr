package com.lusafolg.proyectoprimertrimestre

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lusafolg.proyectoprimertrimestre.databinding.ActivityInicioBinding

class InicioActivity : AppCompatActivity(), OnClickListener {


    private fun getEntradas():MutableList<Entrada>{

        val entradas= mutableListOf<Entrada>()

        val u1=Usuario( "FishEnjoyer92", "PECES")

        val u2=Usuario("FanDLosPeces", "FISH")

        val u3=Usuario("CirujanoFan", "CIRUJANOS")

        val u4=Usuario("RokuhiraChihiro", "Kagurabachi")

        val e1=Entrada(1, "Cirujano amarillo", "Es uno de los peces marinos más populares, resistentes y solicitados en acuariofilia. Es un ágil y vistoso nadador, además de sociable con la mayoría de habitantes del arrecife, a excepción de machos territoriales de su misma especie.", "Pez de agua salada", "https://badis.es/img/ets_blog/post/pez-cirujano-amarillo-badis-aquarios-reus.jpg", u1)

        val e2=Entrada(2 ,"Cirujano azul", "El pez cirujano azul tiene un cuerpo comprimido lateralmente de color azul índigo y rayas negras, la superior desde el nacimiento de la aleta caudal hasta la cabeza, atravesando el ojo, y la inferior, aproximadamente hasta la altura de la aleta pectoral, que a menudo se unen dejando un círculo azul en el medio. Sus aletas dorsal y anal son de color azul coronadas ambas por una franja negra. Su aleta caudal es amarilla, así como el borde de sus aletas pectorales. La intensidad de la coloración varía en función de la edad.", "Pez de agua salada", "https://upload.wikimedia.org/wikipedia/commons/2/25/Blue_tang_%28Paracanthurus_hepatus%29_02.jpg", u2)

        entradas.add(e1)

        entradas.add(e2)

        return entradas

    }


    private lateinit var entradaAdapter: EntradaAdapter
    private lateinit var linearLayoutManager: RecyclerView.LayoutManager
    private lateinit var binding: ActivityInicioBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInicioBinding.inflate(layoutInflater)
        setContentView(binding.root)
        entradaAdapter = EntradaAdapter(getEntradas(),this)
        linearLayoutManager = LinearLayoutManager(this)
        binding.recyclerView.apply {
            layoutManager = linearLayoutManager
            adapter = entradaAdapter
        }
    }

    override fun onClick(entrada: Entrada, position: Int) {
        TODO("Not yet implemented")
    }


}