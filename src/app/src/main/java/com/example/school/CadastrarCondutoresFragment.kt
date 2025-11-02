package com.example.school

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.school.data.AppDatabase
import com.example.school.data.Condutor
import com.example.school.databinding.FragmentCadastrarCondutoresBinding
import kotlinx.coroutines.launch

class CadastrarCondutoresFragment : Fragment() {

    private var _binding: FragmentCadastrarCondutoresBinding? = null
    private val binding get() = _binding!!

    private val db by lazy { AppDatabase.getDatabase(requireContext()) }
    private val args: CadastrarCondutoresFragmentArgs by navArgs()
    private var condutorId: Int = -1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCadastrarCondutoresBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        condutorId = args.condutorId

        if (condutorId != -1) {
            binding.salvarCondutor.text = "Atualizar"
            binding.listarCondutores.visibility = View.GONE
            lifecycleScope.launch {
                db.condutorDao().getCondutorById(condutorId)?.let {
                    binding.nomeCondutor.setText(it.nome)
                    binding.telefoneCondutor.setText(it.telefone)
                    binding.placaVeiculoCondutor.setText(it.placaVeiculo)
                }
            }
        }

        binding.salvarCondutor.setOnClickListener {
            val nome = binding.nomeCondutor.text.toString()
            val telefone = binding.telefoneCondutor.text.toString()
            val placa = binding.placaVeiculoCondutor.text.toString()

            if (nome.isBlank() || telefone.isBlank() || placa.isBlank()) {
                Toast.makeText(requireContext(), "Preencha todos os campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val condutor = Condutor(
                id = if (condutorId != -1) condutorId else 0,
                nome = nome,
                telefone = telefone,
                placaVeiculo = placa
            )

            lifecycleScope.launch {
                if (condutorId != -1) {
                    db.condutorDao().update(condutor)
                    Toast.makeText(requireContext(), "Condutor atualizado com sucesso", Toast.LENGTH_SHORT).show()
                    findNavController().popBackStack()
                } else {
                    db.condutorDao().insert(condutor)
                    Toast.makeText(requireContext(), "Condutor cadastrado com sucesso", Toast.LENGTH_SHORT).show()
                    findNavController().navigate(R.id.action_cadastrarCondutoresFragment_to_listarCondutoresFragment)
                }
            }
        }

        binding.listarCondutores.setOnClickListener {
            findNavController().navigate(R.id.action_cadastrarCondutoresFragment_to_listarCondutoresFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
