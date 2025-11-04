package com.example.school

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
<<<<<<< HEAD
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.school.data.Condutor
import com.example.school.data.SchoolViewModel
import com.example.school.data.SchoolViewModelFactory
=======
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.school.data.AppDatabase
import com.example.school.data.Condutor
>>>>>>> 32522647552eaf3437a1ad301fed80a1ea22492c
import com.example.school.databinding.FragmentCadastrarCondutoresBinding
import kotlinx.coroutines.launch

class CadastrarCondutoresFragment : Fragment() {

    private var _binding: FragmentCadastrarCondutoresBinding? = null
    private val binding get() = _binding!!

<<<<<<< HEAD
    private val viewModel: SchoolViewModel by activityViewModels {
        val database = (activity?.application as SchoolApplication).database
        SchoolViewModelFactory(database.alunoDao(), database.responsavelDao(), database.turmaDao(), database.escolaDao(), database.condutorDao())
    }

    private var condutorId: Int = -1
    private var condutor: Condutor? = null
=======
    private val db by lazy { AppDatabase.getDatabase(requireContext()) }
    private val args: CadastrarCondutoresFragmentArgs by navArgs()
    private var condutorId: Int = -1
>>>>>>> 32522647552eaf3437a1ad301fed80a1ea22492c

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCadastrarCondutoresBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
<<<<<<< HEAD

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

=======
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

>>>>>>> 32522647552eaf3437a1ad301fed80a1ea22492c
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
