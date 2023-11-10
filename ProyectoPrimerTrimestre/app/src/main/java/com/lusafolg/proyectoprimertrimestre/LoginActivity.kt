package com.lusafolg.proyectoprimertrimestre

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.lusafolg.proyectoprimertrimestre.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding:ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityLoginBinding.inflate(layoutInflater)

        setContentView(binding.root)

        loadimage("https://i.pinimg.com/originals/25/78/bd/2578bd660a9f7b8bc665d6dd9914239f.jpg", binding.ivLogin)

    }

    private fun loadimage(url:String,id: ImageView) {
        Glide.with(this)
            .load(url)
            .diskCacheStrategy(
                DiskCacheStrategy.ALL
            ).centerCrop().into(id)
    }
}