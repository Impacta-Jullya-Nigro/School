package com.example.school

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.school.R
import com.example.school.databinding.FragmentAlunoOptionsBinding

class AlunoOptionsFragment : Fragment() {

    private var _binding: FragmentAlunoOptionsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAlunoOptionsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonCadastrarAluno.setOnClickListener {
            findNavController().navigate(R.id.action_alunoOptionsFragment_to_cadastrarAlunoFragment)
        }

        binding.buttonEditarAlunos.setOnClickListener {
            findNavController().navigate(R.id.action_alunoOptionsFragment_to_editarAlunosFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}