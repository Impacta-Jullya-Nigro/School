package com.example.school

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.school.data.SchoolViewModel
import com.example.school.data.SchoolViewModelFactory
import com.example.school.databinding.FragmentCadastrarAlunoBinding

class CadastrarAlunoFragment : Fragment() {

    private var _binding: FragmentCadastrarAlunoBinding? = null
    private val binding get() = _binding!!

    private val viewModel: SchoolViewModel by activityViewModels {
        SchoolViewModelFactory(
            (activity?.application as SchoolApplication).database.alunoDao()
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCadastrarAlunoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSalvar.setOnClickListener {
            salvarAluno()
        }
    }

    private fun salvarAluno() {
        val nome = binding.editTextNome.text.toString()
        val idadeStr = binding.editTextIdade.text.toString()
        val serie = binding.editTextSerie.text.toString()
        val turma = binding.editTextTurma.text.toString()
        val professor = binding.editTextProfessor.text.toString()

        if (nome.isBlank() || idadeStr.isBlank() || serie.isBlank() || turma.isBlank() || professor.isBlank()) {
            Toast.makeText(context, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            return
        }

        val idade = idadeStr.toIntOrNull()
        if (idade == null) {
            Toast.makeText(context, "Idade inválida", Toast.LENGTH_SHORT).show()
            return
        }

        viewModel.addNewAluno(nome, idade, serie, turma, professor)
        Toast.makeText(context, "Aluno salvo com sucesso", Toast.LENGTH_SHORT).show()
        findNavController().navigateUp()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}