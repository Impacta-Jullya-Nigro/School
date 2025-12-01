package com.example.school

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.school.R
import com.example.school.databinding.FragmentEscolaOptionsBinding

class EscolaOptionsFragment : Fragment() {

    private var _binding: FragmentEscolaOptionsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEscolaOptionsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonCadastrarEscola.setOnClickListener {
            findNavController().navigate(R.id.action_escolaOptionsFragment_to_cadastrarEscolaFragment)
        }

        binding.buttonEditarEscolas.setOnClickListener {
            findNavController().navigate(R.id.action_escolaOptionsFragment_to_editarEscolasFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}