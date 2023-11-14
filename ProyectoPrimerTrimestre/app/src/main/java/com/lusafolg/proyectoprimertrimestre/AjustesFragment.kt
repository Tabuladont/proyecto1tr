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
import com.lusafolg.proyectoprimertrimestre.databinding.FragmentAjustesBinding
import com.lusafolg.proyectoprimertrimestre.databinding.FragmentHistorialBinding

class AjustesFragment : Fragment() {

    private var _binding: FragmentAjustesBinding?=null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding= FragmentAjustesBinding.inflate(inflater,container,false)
        val view=binding.root

        binding.btnLogout.setOnClickListener(){

            cambiarpantalla(LoginActivity())


        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }

    private fun cambiarpantalla(destino: Activity){

        val intent= Intent(requireContext(), destino::class.java)

        startActivity(intent)

    }

}