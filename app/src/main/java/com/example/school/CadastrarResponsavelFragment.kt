package com.example.school

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.school.data.Responsavel
import com.example.school.data.SchoolViewModel
import com.example.school.data.SchoolViewModelFactory
import com.example.school.databinding.FragmentCadastrarResponsaveisBinding

class CadastrarResponsavelFragment : Fragment() {

    private var _binding: FragmentCadastrarResponsaveisBinding? = null
    private val binding get() = _binding!!

    private val viewModel: SchoolViewModel by activityViewModels {
        val database = (activity?.application as SchoolApplication).database
        SchoolViewModelFactory(database.alunoDao(), database.responsavelDao(), database.turmaDao(), database.escolaDao(), database.condutorDao())
    }

    private var responsavelId: Int = -1
    private var responsavel: Responsavel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCadastrarResponsaveisBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        responsavelId = arguments?.getInt("responsavelId") ?: -1

        if (responsavelId > 0) {
            viewModel.getResponsavel(responsavelId).observe(viewLifecycleOwner) { responsavelSelecionado ->
                responsavel = responsavelSelecionado
                responsavel?.let { bind(it) }
            }
        } else {
            binding.buttonSalvar.text = "Salvar"
        }

        binding.buttonSalvar.setOnClickListener {
            salvarResponsavel()
        }
    }

    private fun bind(responsavel: Responsavel) {
        binding.apply {
            editTextNome.setText(responsavel.nome)
            editTextTelefone.setText(responsavel.telefone)
            editTextEmail.setText(responsavel.email)
            buttonSalvar.text = "Atualizar"
        }
    }

    private fun salvarResponsavel() {
        val nome = binding.editTextNome.text.toString()
        val telefone = binding.editTextTelefone.text.toString()
        val email = binding.editTextEmail.text.toString()

        if (nome.isBlank() || telefone.isBlank() || email.isBlank()) {
            Toast.makeText(context, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            return
        }

        if (responsavel != null && responsavelId > 0) {
            viewModel.updateResponsavel(responsavelId, nome, telefone, email)
            Toast.makeText(context, "Responsável atualizado com sucesso", Toast.LENGTH_SHORT).show()
        } else {
            viewModel.addNewResponsavel(nome, telefone, email)
            Toast.makeText(context, "Responsável salvo com sucesso", Toast.LENGTH_SHORT).show()
        }

        findNavController().navigateUp()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}