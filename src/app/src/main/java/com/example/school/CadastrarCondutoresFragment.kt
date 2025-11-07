package com.example.school

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.school.data.Condutor
import com.example.school.data.SchoolViewModel
import com.example.school.data.SchoolViewModelFactory
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.example.school.data.AppDatabase
import com.example.school.databinding.FragmentCadastrarCondutoresBinding
import kotlinx.coroutines.launch
import kotlin.getValue


class CadastrarCondutoresFragment : Fragment() {

    private var _binding: FragmentCadastrarCondutoresBinding? = null
    private val binding get() = _binding!!

    private val viewModel: SchoolViewModel by activityViewModels {
        val database = (activity?.application as SchoolApplication).database
        SchoolViewModelFactory(database.alunoDao(), database.responsavelDao(), database.turmaDao(), database.escolaDao(), database.condutorDao())
    }

    private var condutor: Condutor? = null
    private val db by lazy { AppDatabase.getDatabase(requireContext()) }
//    private val args: CadastrarCondutoresFragmentArgs by navArgs()
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

        condutorId = arguments?.getInt("condutorId") ?: -1

        if (condutorId > 0) {
            viewModel.getCondutor(condutorId).observe(viewLifecycleOwner) { condutorSelecionado ->
                condutor = condutorSelecionado
                condutor?.let { bind(it) }
            }
        } else {
            binding.buttonSalvar.text = "Salvar"
        }

        binding.buttonSalvar.setOnClickListener {
            salvarCondutor()
        }
    }

    private fun bind(condutor: Condutor) {
        binding.apply {
            editTextNome.setText(condutor.nome)
            editTextTelefone.setText(condutor.telefone)
            editTextPlaca.setText(condutor.placaVeiculo)
            buttonSalvar.text = "Atualizar"
        }
    }

    private fun salvarCondutor() {
        val nome = binding.editTextNome.text.toString()
        val telefone = binding.editTextTelefone.text.toString()
        val placa = binding.editTextPlaca.text.toString()

        if (nome.isBlank() || telefone.isBlank() || placa.isBlank()) {
            Toast.makeText(context, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            return
        }

        if (condutor != null && condutorId > 0) {
            viewModel.updateCondutor(condutorId, nome, telefone, placa)
            Toast.makeText(context, "Condutor atualizado com sucesso", Toast.LENGTH_SHORT).show()
        } else {
            viewModel.addNewCondutor(nome, telefone, placa)
            Toast.makeText(context, "Condutor salvo com sucesso", Toast.LENGTH_SHORT).show()
        }

        findNavController().navigateUp()
    }


}
