package com.lusafolg.proyectoprimertrimestre

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.lusafolg.proyectoprimertrimestre.databinding.ActivityEntradaBinding

class EntradaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEntradaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityEntradaBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

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

        val entradas= listOf<Entrada>(e1,e2,e3,e4)

        var intentAnterior = getIntent()

        var idSeleccionado=intentAnterior.getIntExtra("id", 0)

        var entradaseleccionada:Entrada

        for (entrada in entradas){

            if(entrada.id==idSeleccionado){

                entradaseleccionada=entrada

                sincronizarEntrada(entradaseleccionada)

            }

        }

    }

    private fun sincronizarEntrada(entrada: Entrada){

            binding.tvNombreEntrada.text=entrada.nombre

            binding.tvHabitTexto.text=entrada.habitat

            binding.tvDescripTexto.text=entrada.descripcion

            binding.tvUser.text=entrada.usuario.nombre

            loadimage(entrada.foto,binding.ivEntrada)

            loadprofilepicture(entrada.usuario.foto,binding.imgPhoto)

        binding.user.setOnClickListener(){

            cambiarpantalla(PerfilActivity(), entrada.usuario.id)

        }

    }

    private fun loadimage(url:String,id: ImageView) {
        Glide.with(this)
            .load(url)
            .diskCacheStrategy(
                DiskCacheStrategy.ALL
            ).centerCrop().into(id)
    }

    private fun loadprofilepicture(url:String,id: ImageView) {
        Glide.with(this)
            .load(url)
            .diskCacheStrategy(
                DiskCacheStrategy.ALL
            ).centerCrop().circleCrop().into(id)
    }

    private fun cambiarpantalla(destino:Activity,id:Int){

        val intent=Intent(this, destino::class.java).putExtra("id", id)

        startActivity(intent)

    }
}