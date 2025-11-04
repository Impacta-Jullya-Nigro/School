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
import com.example.school.databinding.FragmentEditarAlunosBinding

class EditarAlunosFragment : Fragment() {

    private var _binding: FragmentEditarAlunosBinding? = null
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
        _binding = FragmentEditarAlunosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = EditarAlunosAdapter(
            onEdit = { aluno ->
                findNavController().navigate(
                    R.id.action_editarAlunosFragment_to_cadastrarAlunoFragment,
                    bundleOf("alunoId" to aluno.id)
                )
            },
            onDelete = { aluno ->
                viewModel.deleteAluno(aluno)
            }
        )

        binding.recyclerViewAlunos.adapter = adapter
        binding.recyclerViewAlunos.layoutManager = LinearLayoutManager(context)

        viewModel.allAlunos.observe(viewLifecycleOwner) { alunos ->
            alunos?.let { adapter.submitList(it) }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}