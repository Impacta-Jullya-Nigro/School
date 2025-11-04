package com.example.school

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.school.data.Escola
import com.example.school.data.SchoolViewModel
import com.example.school.data.SchoolViewModelFactory
import com.example.school.databinding.FragmentCadastrarEscolaBinding

class CadastrarEscolaFragment : Fragment() {

    private var _binding: FragmentCadastrarEscolaBinding? = null
    private val binding get() = _binding!!

    private val viewModel: SchoolViewModel by activityViewModels {
        val database = (activity?.application as SchoolApplication).database
        SchoolViewModelFactory(database.alunoDao(), database.responsavelDao(), database.turmaDao(), database.escolaDao(), database.condutorDao())
    }

    private var escolaId: Int = -1
    private var escola: Escola? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCadastrarEscolaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        escolaId = arguments?.getInt("escolaId") ?: -1

        if (escolaId > 0) {
            viewModel.getEscola(escolaId).observe(viewLifecycleOwner) { escolaSelecionada ->
                escola = escolaSelecionada
                escola?.let { bind(it) }
            }
        } else {
            binding.buttonSalvar.text = "Salvar"
        }

        binding.buttonSalvar.setOnClickListener {
            salvarEscola()
        }
    }

    private fun bind(escola: Escola) {
        binding.apply {
            editTextNome.setText(escola.nome)
            editTextEndereco.setText(escola.endereco)
            editTextNumero.setText(escola.numero)
            editTextCep.setText(escola.cep)
            editTextDiretor.setText(escola.diretor)
            buttonSalvar.text = "Atualizar"
        }
    }

    private fun salvarEscola() {
        val nome = binding.editTextNome.text.toString()
        val endereco = binding.editTextEndereco.text.toString()
        val numero = binding.editTextNumero.text.toString()
        val cep = binding.editTextCep.text.toString()
        val diretor = binding.editTextDiretor.text.toString()

        if (nome.isBlank() || endereco.isBlank() || numero.isBlank() || cep.isBlank() || diretor.isBlank()) {
            Toast.makeText(context, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            return
        }

        if (escola != null && escolaId > 0) {
            viewModel.updateEscola(escolaId, nome, endereco, numero, cep, diretor)
            Toast.makeText(context, "Escola atualizada com sucesso", Toast.LENGTH_SHORT).show()
        } else {
            viewModel.addNewEscola(nome, endereco, numero, cep, diretor)
            Toast.makeText(context, "Escola salva com sucesso", Toast.LENGTH_SHORT).show()
        }

        findNavController().navigateUp()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}