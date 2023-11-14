package com.lusafolg.proyectoprimertrimestre

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lusafolg.proyectoprimertrimestre.databinding.FragmentAjustesBinding
import com.lusafolg.proyectoprimertrimestre.databinding.FragmentHistorialBinding

class AjustesFragment : Fragment(),OnClickListener {

    private lateinit var ajusteAdapter: AjusteAdapter
    private lateinit var linearLayoutManager: RecyclerView.LayoutManager
    private var _binding: FragmentAjustesBinding?=null
    private val binding get() = _binding!!

    private fun getAjustes(): MutableList<Ajuste>{

        val ajustes = mutableListOf<Ajuste>()

        val a1=Ajuste("Mantener esta cuenta como anónima")

        val a2=Ajuste("Recibir notificaciones")

        val a3=Ajuste("Enviar datos de uso")

        val a4=Ajuste("Visualizar autor de entrada(no interactuable)")

        val a5=Ajuste("Mostrar hábitat del pez de la entrada")

        val a6=Ajuste("Registrar entradas visitadas en Historial")

        ajustes.add(a1)

        ajustes.add(a2)

        ajustes.add(a3)

        ajustes.add(a4)

        ajustes.add(a5)

        ajustes.add(a6)

        return ajustes

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding= FragmentAjustesBinding.inflate(inflater,container,false)
        val view=binding.root
        ajusteAdapter = AjusteAdapter(getAjustes(), this)
        linearLayoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.apply {
            layoutManager = linearLayoutManager
            adapter = ajusteAdapter
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }

    override fun onClick(entrada: Entrada, position: Int) {
        TODO("Not yet implemented")
    }
}