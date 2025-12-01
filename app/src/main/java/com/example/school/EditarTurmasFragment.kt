package com.example.school

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.school.data.SchoolViewModel
import com.example.school.data.SchoolViewModelFactory
import com.example.school.databinding.FragmentEditarTurmasBinding

class EditarTurmasFragment : Fragment() {

    private var _binding: FragmentEditarTurmasBinding? = null
    private val binding get() = _binding!!

    private val viewModel: SchoolViewModel by activityViewModels {
        val database = (activity?.application as SchoolApplication).database
        SchoolViewModelFactory(database.alunoDao(), database.responsavelDao(), database.turmaDao(), database.escolaDao(), database.condutorDao())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEditarTurmasBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = EditarTurmasAdapter(
            onEdit = { turma ->
                findNavController().navigate(
                    R.id.action_editarTurmasFragment_to_cadastrarTurmaFragment,
                    bundleOf("turmaId" to turma.id)
                )
            },
            onDelete = { turma ->
                viewModel.deleteTurma(turma)
            }
        )

        binding.recyclerViewTurmas.adapter = adapter
        binding.recyclerViewTurmas.layoutManager = LinearLayoutManager(context)

        viewModel.allTurmas.observe(viewLifecycleOwner) { turmas ->
            turmas?.let { adapter.submitList(it) }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}