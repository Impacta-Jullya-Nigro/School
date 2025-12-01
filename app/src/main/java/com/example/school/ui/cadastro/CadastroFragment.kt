package com.example.school.ui.cadastro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.school.R
import com.example.school.databinding.FragmentCadastroBinding

class CadastroFragment : Fragment() {

    private var _binding: FragmentCadastroBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCadastroBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.imageButtonAlunos.setOnClickListener {
            findNavController().navigate(R.id.action_nav_cadastro_to_alunoOptionsFragment)
        }

        binding.imageButtonResponsaveis.setOnClickListener {
            findNavController().navigate(R.id.action_nav_cadastro_to_responsavelOptionsFragment)
        }

        binding.imageButtonTurma.setOnClickListener {
            findNavController().navigate(R.id.action_nav_cadastro_to_turmaOptionsFragment)
        }

        binding.imageButtonEscola.setOnClickListener {
            findNavController().navigate(R.id.action_nav_cadastro_to_escolaOptionsFragment)
        }

        binding.imageButtonCondutores.setOnClickListener {
            findNavController().navigate(R.id.action_nav_cadastro_to_condutorOptionsFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}