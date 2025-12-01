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
import com.example.school.databinding.FragmentEditarCondutoresBinding

class EditarCondutoresFragment : Fragment() {

    private var _binding: FragmentEditarCondutoresBinding? = null
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
        _binding = FragmentEditarCondutoresBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = EditarCondutoresAdapter(
            onEdit = { condutor ->
                findNavController().navigate(
                    R.id.action_editarCondutoresFragment_to_cadastrarCondutoresFragment,
                    bundleOf("condutorId" to condutor.id)
                )
            },
            onDelete = { condutor ->
                viewModel.deleteCondutor(condutor)
            }
        )

        binding.recyclerViewCondutores.adapter = adapter
        binding.recyclerViewCondutores.layoutManager = LinearLayoutManager(context)

        viewModel.allCondutores.observe(viewLifecycleOwner) { condutores ->
            condutores?.let { adapter.submitList(it) }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}