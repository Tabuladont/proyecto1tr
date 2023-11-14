package com.lusafolg.proyectoprimertrimestre

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.lusafolg.proyectoprimertrimestre.databinding.ActivityInicioBinding

class InicioActivity : AppCompatActivity() {

    private lateinit var bottomNavigation: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        initComponents()

        initListeners()

        replaceFragment(InicioFragment())

    }

    private fun initComponents(){

        bottomNavigation=findViewById(R.id.bottomNavigation)

    }

    private fun initListeners(){

        bottomNavigation.setOnItemSelectedListener { MenuItem ->
            when (MenuItem.itemId) {

                R.id.bottomHome -> {

                    replaceFragment(InicioFragment())
                    true

                }

                R.id.bottomHistorial -> {

                    replaceFragment(HistorialFragment())
                    true
                }

                R.id.bottomSettings -> {

                    replaceFragment(AjustesFragment())
                    true

                }

                else -> false

            }

        }

    }

    private fun replaceFragment(fragment: Fragment){

        supportFragmentManager.beginTransaction().replace(R.id.frameContainer, fragment)
            .addToBackStack(null)
            .commit()

    }

}