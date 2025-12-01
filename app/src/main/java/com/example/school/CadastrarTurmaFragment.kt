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
import com.example.school.data.Turma
import com.example.school.data.SchoolViewModel
import com.example.school.data.SchoolViewModelFactory
import com.example.school.databinding.FragmentCadastrarTurmaBinding

class CadastrarTurmaFragment : Fragment() {

    private var _binding: FragmentCadastrarTurmaBinding? = null
    private val binding get() = _binding!!

    private val viewModel: SchoolViewModel by activityViewModels {
        val database = (activity?.application as SchoolApplication).database
        SchoolViewModelFactory(database.alunoDao(), database.responsavelDao(), database.turmaDao(), database.escolaDao(), database.condutorDao())
    }

    private var turmaId: Int = -1
    private var turma: Turma? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCadastrarTurmaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupDropdowns()

        turmaId = arguments?.getInt("turmaId") ?: -1

        if (turmaId > 0) {
            viewModel.getTurma(turmaId).observe(viewLifecycleOwner) { turmaSelecionada ->
                turma = turmaSelecionada
                turma?.let { bind(it) }
            }
        } else {
            binding.buttonSalvar.text = "Salvar"
        }

        binding.buttonSalvar.setOnClickListener {
            salvarTurma()
        }
    }

    private fun setupDropdowns() {
        val turnos = listOf("Manhã", "Tarde", "Noite")
        val series = (1..9).map { "${it}º ano" }
        val nomesTurma = ('A'..'F').map { it.toString() }

        val turnoAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, turnos)
        binding.autoCompleteTurno.setAdapter(turnoAdapter)

        val serieAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, series)
        binding.autoCompleteSerie.setAdapter(serieAdapter)

        val nomeTurmaAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, nomesTurma)
        binding.autoCompleteNomeTurma.setAdapter(nomeTurmaAdapter)
    }

    private fun bind(turma: Turma) {
        binding.apply {
            autoCompleteTurno.setText(turma.turno, false)
            autoCompleteSerie.setText(turma.serie, false)
            autoCompleteNomeTurma.setText(turma.nome, false)
            buttonSalvar.text = "Atualizar"
        }
    }

    private fun salvarTurma() {
        val turno = binding.autoCompleteTurno.text.toString()
        val serie = binding.autoCompleteSerie.text.toString()
        val nome = binding.autoCompleteNomeTurma.text.toString()

        if (turno.isBlank() || serie.isBlank() || nome.isBlank()) {
            Toast.makeText(context, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            return
        }

        if (turma != null && turmaId > 0) {
            viewModel.updateTurma(turmaId, turno, serie, nome)
            Toast.makeText(context, "Turma atualizada com sucesso", Toast.LENGTH_SHORT).show()
        } else {
            viewModel.addNewTurma(turno, serie, nome)
            Toast.makeText(context, "Turma salva com sucesso", Toast.LENGTH_SHORT).show()
        }

        findNavController().navigateUp()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}