package com.lusafolg.proyectoprimertrimestre

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.lusafolg.proyectoprimertrimestre.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding:ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityLoginBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val u1=Usuario( 1,"FishEnjoyer92", "PECES", "Un fanático de los peces más.", "https://badis.es/img/cms/Blog/2022/marinos-faciles/pez-pallaso.jpg")

        val u2=Usuario(2, "FanDLosPeces", "FISH", "ME ENCANTAN LOS PECES.", "https://badis.es/img/cms/Blog/2022/marinos-faciles/pez-pallaso.jpg")

        val u3=Usuario(3,"CirujanoFan", "CIRUJANOS", "Un cirujano fan de los cirujanos.","https://www.fishipedia.es/wp-content/uploads/2018/10/20150414_120002_Paracanthurus-hepatus_EIO.jpg")

        val u4=Usuario(4,"RokuhiraChihiro", "Kagurabachi", "Hijo de Kunishige Rokuhira. ¿Mis aficiones? Cortar a aquellos que no merezcan usar una katana y los peces de colores.", "https://cff2.earth.com/uploads/2022/01/06080341/Goldfish.jpg")


        var usuarios= mutableListOf<Usuario>(u1,u2,u3,u4)

        cargarDatos()

        loadimage("https://i.pinimg.com/originals/25/78/bd/2578bd660a9f7b8bc665d6dd9914239f.jpg", binding.ivLogin)

        binding.btnLogin.setOnClickListener(){

            val preferences = getPreferences(Context.MODE_PRIVATE)

            val user=binding.tietUser.text.toString()

            val pass=binding.tietPassword.text.toString()

            var usuariosp=preferences.getString(user,null)

            val recordar=binding.cbRecordarme


            if(usuariosp==pass){

                if (recordar.isChecked){

                    guardarDatos()

                }

                entrar()

            }else{

                Toast.makeText(this, "Credenciales no válidas.\n" +
                        "Si no posees cuenta,créala pulsando 'Crear cuenta'", Toast.LENGTH_SHORT).show()


            }

        }

        binding.tvCrearcuenta.setOnClickListener(){

            val preferences = getPreferences(Context.MODE_PRIVATE)

            val user=binding.tietUser.text.toString()

            val pass=binding.tietPassword.text.toString()

            var usuariosp=preferences.getString(user,null)

            var id:Int=1

            for(usuario in usuarios){

                id+=1

            }

            if (usuariosp==null){

                val usuarionuevo=Usuario(id,user,pass, "Un nuevo usuario en Wikipeces", "https://badis.es/img/cms/Blog/2022/marinos-faciles/pez-pallaso.jpg")

                usuarios.add(usuarionuevo)

                actualizarUsuarios(usuarios)

                Toast.makeText(this, "Cuenta creada con éxito", Toast.LENGTH_SHORT).show()

            }else{

                Toast.makeText(this, "Esta cuenta ya existe", Toast.LENGTH_SHORT).show()

            }

        }

    }

    private fun loadimage(url:String,id: ImageView) {
        Glide.with(this)
            .load(url)
            .diskCacheStrategy(
                DiskCacheStrategy.ALL
            ).centerCrop().into(id)
    }

    private fun guardarDatos(){

        val preferences = getPreferences(Context.MODE_PRIVATE)
        val username = binding.tietUser.text.toString()
        val pass = binding.tietPassword.text.toString()


        with(preferences.edit()){

            putString("User",username)
            putString("Pass",pass)
                .apply()
        }

    }

    private fun cargarDatos(){

        val preferences = getPreferences(Context.MODE_PRIVATE)

        val user = preferences.getString("User",null)

        val pass = preferences.getString("Pass",null)

        binding.tietUser.setText(user)

        binding.tietPassword.setText(pass)

    }

    private fun actualizarUsuarios(usuarios:List<Usuario>){

        val preferences = getPreferences(Context.MODE_PRIVATE)


        for (i in usuarios) {


            with(preferences.edit()) {

                putString(i.nombre, i.pass).apply()

            }

        }

    }

    private fun entrar(){

        intent= Intent(this,InicioActivity::class.java)

        startActivity(intent)

    }
}