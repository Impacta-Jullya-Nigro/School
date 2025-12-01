package com.example.school

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.school.api.Endereco
import com.example.school.api.RetrofitClient
import com.example.school.data.Escola
import com.example.school.data.SchoolViewModel
import com.example.school.data.SchoolViewModelFactory
import com.example.school.databinding.FragmentCadastrarEscolaBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

        binding.buttonBuscarCep.setOnClickListener {
            buscarCep()
        }

        binding.buttonSalvar.setOnClickListener {
            salvarEscola()
        }
    }

    private fun buscarCep() {
        val cep = binding.editTextCep.text.toString()
        if (cep.isNotBlank()) {
            RetrofitClient.instance.getEndereco(cep).enqueue(object : Callback<Endereco> {
                override fun onResponse(call: Call<Endereco>, response: Response<Endereco>) {
                    if (response.isSuccessful) {
                        val endereco = response.body()
                        if (endereco != null) {
                            binding.editTextLogradouro.setText(endereco.logradouro)
                            binding.editTextBairro.setText(endereco.bairro)
                            binding.editTextCidade.setText("${endereco.localidade} - ${endereco.uf}")
                        } else {
                            Toast.makeText(context, "CEP não encontrado", Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        Toast.makeText(context, "Erro ao buscar CEP", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<Endereco>, t: Throwable) {
                    Toast.makeText(context, "Falha na conexão: ${t.message}", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }

    private fun bind(escola: Escola) {
        binding.apply {
            editTextNome.setText(escola.nome)
            editTextLogradouro.setText(escola.logradouro)
            editTextBairro.setText(escola.bairro)
            editTextCidade.setText(escola.cidade)
            editTextNumero.setText(escola.numero)
            editTextCep.setText(escola.cep)
            editTextDiretor.setText(escola.diretor)
            buttonSalvar.text = "Atualizar"
        }
    }

    private fun salvarEscola() {
        val nome = binding.editTextNome.text.toString()
        val logradouro = binding.editTextLogradouro.text.toString()
        val bairro = binding.editTextBairro.text.toString()
        val cidade = binding.editTextCidade.text.toString()
        val numero = binding.editTextNumero.text.toString()
        val cep = binding.editTextCep.text.toString()
        val diretor = binding.editTextDiretor.text.toString()

        if (nome.isBlank() || logradouro.isBlank() || bairro.isBlank() || cidade.isBlank() || cep.isBlank() || diretor.isBlank()) {
            Toast.makeText(context, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            return
        }

        if (escola != null && escolaId > 0) {
            viewModel.updateEscola(escolaId, nome, logradouro, bairro, cidade, numero, cep, diretor)
            Toast.makeText(context, "Escola atualizada com sucesso", Toast.LENGTH_SHORT).show()
        } else {
            viewModel.addNewEscola(nome, logradouro, bairro, cidade, numero, cep, diretor)
            Toast.makeText(context, "Escola salva com sucesso", Toast.LENGTH_SHORT).show()
        }

        findNavController().navigateUp()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}