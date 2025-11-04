package com.example.school

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.school.R
import com.example.school.databinding.FragmentTurmaOptionsBinding

class TurmaOptionsFragment : Fragment() {

    private var _binding: FragmentTurmaOptionsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTurmaOptionsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonCadastrarTurma.setOnClickListener {
            findNavController().navigate(R.id.action_turmaOptionsFragment_to_cadastrarTurmaFragment)
        }

        binding.buttonEditarTurmas.setOnClickListener {
            findNavController().navigate(R.id.action_turmaOptionsFragment_to_editarTurmasFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}