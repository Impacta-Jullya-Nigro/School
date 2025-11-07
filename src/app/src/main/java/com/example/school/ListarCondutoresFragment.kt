package com.example.school

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.school.data.AppDatabase
import com.example.school.data.Condutor
import com.example.school.databinding.FragmentListarCondutoresBinding
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch

class ListarCondutoresFragment : Fragment() {

    private var _binding: FragmentListarCondutoresBinding? = null
    private val binding get() = _binding!!

    private val db by lazy { AppDatabase.getDatabase(requireContext()) }
    private lateinit var condutorAdapter: CondutorAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListarCondutoresBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

        lifecycleScope.launch {
            val condutores = db.condutorDao().getAllCondutores()
            condutores.collect { myDataObject ->
            condutorAdapter.submitList(myDataObject)
            }
        }
    }

    private fun setupRecyclerView() {
        condutorAdapter = CondutorAdapter(
            onEdit = { condutorId ->
                val action = ListarCondutoresFragmentDirections.actionListarCondutoresFragmentToCadastrarCondutoresFragment(condutorId)
                findNavController().navigate(action)
            },
            onDelete = { condutor ->
                lifecycleScope.launch {
                    db.condutorDao().delete(condutor)
                    val condutores = db.condutorDao().getAllCondutores()
                    condutorAdapter.submitList(condutores)
                }
            }
        )
        binding.recyclerViewCondutores.apply {
            adapter = condutorAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    override fun onResume() {
        super.onResume()
        lifecycleScope.launch {
            val condutores = db.condutorDao().getAllCondutores()
            condutorAdapter.submitList(condutores)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}