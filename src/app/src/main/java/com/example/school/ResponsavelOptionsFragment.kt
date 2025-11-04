package com.example.school

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.school.R
import com.example.school.databinding.FragmentResponsavelOptionsBinding

class ResponsavelOptionsFragment : Fragment() {

    private var _binding: FragmentResponsavelOptionsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResponsavelOptionsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonCadastrarResponsavel.setOnClickListener {
            findNavController().navigate(R.id.action_responsavelOptionsFragment_to_cadastrarResponsavelFragment)
        }

        binding.buttonEditarResponsaveis.setOnClickListener {
            // A navegação para a tela de edição será adicionada em breve
            findNavController().navigate(R.id.action_responsavelOptionsFragment_to_editarResponsaveisFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}