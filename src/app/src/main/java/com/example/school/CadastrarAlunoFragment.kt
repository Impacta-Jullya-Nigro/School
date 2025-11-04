package com.example.school

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.school.data.Aluno
import com.example.school.data.Condutor
import com.example.school.data.Responsavel
import com.example.school.data.Turma
import com.example.school.data.SchoolViewModel
import com.example.school.data.SchoolViewModelFactory
import com.example.school.databinding.FragmentCadastrarAlunoBinding

class CadastrarAlunoFragment : Fragment() {

    private var _binding: FragmentCadastrarAlunoBinding? = null
    private val binding get() = _binding!!

    private val viewModel: SchoolViewModel by activityViewModels {
        val database = (activity?.application as SchoolApplication).database
        SchoolViewModelFactory(database.alunoDao(), database.responsavelDao(), database.turmaDao(), database.escolaDao(), database.condutorDao())
    }

    private var alunoId: Int = -1
    private var aluno: Aluno? = null
    private var turmaList: List<Turma> = emptyList()
    private var responsavelList: List<Responsavel> = emptyList()
    private var condutorList: List<Condutor> = emptyList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCadastrarAlunoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupTurmaSpinner()
        setupResponsavelSpinner()
        setupCondutorSpinner()

        alunoId = arguments?.getInt("alunoId") ?: -1

        if (alunoId > 0) {
            viewModel.getAluno(alunoId).observe(viewLifecycleOwner) { alunoSelecionado ->
                aluno = alunoSelecionado
                aluno?.let { bind(it) }
            }
        } else {
            binding.buttonSalvar.text = "Salvar Aluno"
        }

        binding.buttonSalvar.setOnClickListener {
            salvarAluno()
        }
    }

    private fun setupTurmaSpinner() {
        viewModel.allTurmas.observe(viewLifecycleOwner) { turmas ->
            turmaList = turmas
            val turmaNomes = mutableListOf("Nenhuma")
            turmaNomes.addAll(turmas.map { "${it.serie} ${it.nome} - ${it.turno}" })
            val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, turmaNomes)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spinnerTurmas.adapter = adapter
            aluno?.turmaId?.let { id ->
                val position = turmaList.indexOfFirst { it.id == id } + 1
                if (position > 0) binding.spinnerTurmas.setSelection(position)
            }
        }
    }

    private fun setupResponsavelSpinner() {
        viewModel.allResponsaveis.observe(viewLifecycleOwner) { responsaveis ->
            responsavelList = responsaveis
            val responsavelNomes = mutableListOf("Nenhum")
            responsavelNomes.addAll(responsaveis.map { it.nome })
            val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, responsavelNomes)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spinnerResponsaveis.adapter = adapter
            aluno?.responsavelId?.let { id ->
                val position = responsavelList.indexOfFirst { it.id == id } + 1
                if (position > 0) binding.spinnerResponsaveis.setSelection(position)
            }
        }
    }

    private fun setupCondutorSpinner() {
        viewModel.allCondutores.observe(viewLifecycleOwner) { condutores ->
            condutorList = condutores
            val condutorNomes = mutableListOf("Nenhum")
            condutorNomes.addAll(condutores.map { it.nome })
            val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, condutorNomes)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spinnerCondutores.adapter = adapter
            aluno?.condutorId?.let { id ->
                val position = condutorList.indexOfFirst { it.id == id } + 1
                if (position > 0) binding.spinnerCondutores.setSelection(position)
            }
        }
    }

    private fun bind(aluno: Aluno) {
        binding.apply {
            editTextNome.setText(aluno.nome)
            editTextIdade.setText(aluno.idade.toString())
            editTextProfessor.setText(aluno.professor)
            buttonSalvar.text = "Atualizar Aluno"

            if (turmaList.isNotEmpty()) {
                val position = turmaList.indexOfFirst { it.id == aluno.turmaId } + 1
                if (position > 0) spinnerTurmas.setSelection(position)
            }
            if (responsavelList.isNotEmpty()) {
                val position = responsavelList.indexOfFirst { it.id == aluno.responsavelId } + 1
                if (position > 0) spinnerResponsaveis.setSelection(position)
            }
            if (condutorList.isNotEmpty()) {
                val position = condutorList.indexOfFirst { it.id == aluno.condutorId } + 1
                if (position > 0) spinnerCondutores.setSelection(position)
            }
        }
    }

    private fun salvarAluno() {
        val nome = binding.editTextNome.text.toString()
        val idadeStr = binding.editTextIdade.text.toString()
        val professor = binding.editTextProfessor.text.toString()

        if (nome.isBlank() || idadeStr.isBlank() || professor.isBlank()) {
            Toast.makeText(context, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            return
        }

        val idade = idadeStr.toIntOrNull()
        if (idade == null) {
            Toast.makeText(context, "Idade inválida", Toast.LENGTH_SHORT).show()
            return
        }

        val selectedTurmaId = if (binding.spinnerTurmas.selectedItemPosition > 0) {
            turmaList[binding.spinnerTurmas.selectedItemPosition - 1].id
        } else null

        val selectedResponsavelId = if (binding.spinnerResponsaveis.selectedItemPosition > 0) {
            responsavelList[binding.spinnerResponsaveis.selectedItemPosition - 1].id
        } else null

        val selectedCondutorId = if (binding.spinnerCondutores.selectedItemPosition > 0) {
            condutorList[binding.spinnerCondutores.selectedItemPosition - 1].id
        } else null

        if (aluno != null && alunoId > 0) {
            viewModel.updateAluno(alunoId, nome, idade, professor, selectedTurmaId, selectedResponsavelId, selectedCondutorId)
            Toast.makeText(context, "Aluno atualizado com sucesso", Toast.LENGTH_SHORT).show()
        } else {
            viewModel.addNewAluno(nome, idade, professor, selectedTurmaId, selectedResponsavelId, selectedCondutorId)
            Toast.makeText(context, "Aluno salvo com sucesso", Toast.LENGTH_SHORT).show()
        }

        findNavController().navigateUp()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}