package com.rai.listademercado

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.rai.listademercado.databinding.FragmentFirstBinding
import java.util.zip.Inflater

//Tela FirstFrament criada
//Ela herda de Fragment(), então o Android entende que essa classe representa um fragm. de interface
class FirstFragment : Fragment() {

    //Essa variável quarda a ligação com o XML fragment_first.xml
    private var _binding: FragmentFirstBinding? = null

    //forma mais fácil de acessar o binging. O !! diz que a variável não é nula.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstacesState: Bundle?
        ): View{

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }
}