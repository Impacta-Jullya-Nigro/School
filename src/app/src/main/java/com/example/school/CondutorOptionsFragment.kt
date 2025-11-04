package com.example.school

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.school.R
import com.example.school.databinding.FragmentCondutorOptionsBinding

class CondutorOptionsFragment : Fragment() {

    private var _binding: FragmentCondutorOptionsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCondutorOptionsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonCadastrarCondutor.setOnClickListener {
            findNavController().navigate(R.id.action_condutorOptionsFragment_to_cadastrarCondutoresFragment)
        }

        binding.buttonEditarCondutores.setOnClickListener {
            findNavController().navigate(R.id.action_condutorOptionsFragment_to_editarCondutoresFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}