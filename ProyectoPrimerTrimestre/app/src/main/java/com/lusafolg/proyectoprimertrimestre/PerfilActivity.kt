package com.lusafolg.proyectoprimertrimestre

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.lusafolg.proyectoprimertrimestre.databinding.ActivityPerfilBinding

class PerfilActivity : AppCompatActivity() {

    private lateinit var binding:ActivityPerfilBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityPerfilBinding.inflate(layoutInflater)
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

        val u3 = Usuario(
            3,
            "CirujanoFan",
            "CIRUJANOS",
            "Un cirujano fan de los cirujanos.",
            "https://www.fishipedia.es/wp-content/uploads/2018/10/20150414_120002_Paracanthurus-hepatus_EIO.jpg"
        )

        val u4 = Usuario(
            4,
            "RokuhiraChihiro",
            "Kagurabachi",
            "Hijo de Kunishige Rokuhira. ¿Mis aficiones? Cortar a aquellos que no merezcan usar una katana y los peces de colores.",
            "https://cff2.earth.com/uploads/2022/01/06080341/Goldfish.jpg"
        )

        val usuarios= listOf<Usuario>(u1,u2,u3,u4)

        var intentAnterior = getIntent()

        var idSeleccionado=intentAnterior.getIntExtra("id", 0)

        var usuarioseleccionado:Usuario

        for (usuario in usuarios){

            if(usuario.id==idSeleccionado){

                usuarioseleccionado=usuario

                sincronizarPerfil(usuarioseleccionado)

            }

        }

    }

    private fun sincronizarPerfil(usuario: Usuario){

        binding.tvNombreTexto.text=usuario.nombre

        binding.tvDescripTexto.text=usuario.descripcion

        loadimage(usuario.foto, binding.ivEntrada)

    }

    private fun loadimage(url:String,id: ImageView) {
        Glide.with(this)
            .load(url)
            .diskCacheStrategy(
                DiskCacheStrategy.ALL
            ).centerCrop().into(id)
    }


}