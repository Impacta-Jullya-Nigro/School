package com.example.school.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class SchoolViewModel(
    private val alunoDao: AlunoDao, 
    private val responsavelDao: ResponsavelDao,
    private val turmaDao: TurmaDao,
    private val escolaDao: EscolaDao,
    private val condutorDao: CondutorDao
) : ViewModel() {

    // Aluno methods
    val allAlunos: LiveData<List<Aluno>> = alunoDao.getAllAlunos().asLiveData()

    fun getAluno(id: Int): LiveData<Aluno> {
        return alunoDao.getAluno(id).asLiveData()
    }

    fun addNewAluno(nome: String, idade: Int, professor: String, turmaId: Int?, responsavelId: Int?, condutorId: Int?) {
        val novoAluno = Aluno(nome = nome, idade = idade, professor = professor, turmaId = turmaId, responsavelId = responsavelId, condutorId = condutorId)
        viewModelScope.launch {
            alunoDao.insert(novoAluno)
        }
    }

    fun updateAluno(id: Int, nome: String, idade: Int, professor: String, turmaId: Int?, responsavelId: Int?, condutorId: Int?) {
        val alunoAtualizado = Aluno(id = id, nome = nome, idade = idade, professor = professor, turmaId = turmaId, responsavelId = responsavelId, condutorId = condutorId)
        viewModelScope.launch {
            alunoDao.update(alunoAtualizado)
        }
    }

    fun deleteAluno(aluno: Aluno) {
        viewModelScope.launch {
            alunoDao.delete(aluno)
        }
    }

    // Responsavel methods
    val allResponsaveis: LiveData<List<Responsavel>> = responsavelDao.getAllResponsaveis().asLiveData()

    fun getResponsavel(id: Int): LiveData<Responsavel> {
        return responsavelDao.getResponsavel(id).asLiveData()
    }

    fun addNewResponsavel(nome: String, telefone: String, email: String) {
        val novoResponsavel = Responsavel(nome = nome, telefone = telefone, email = email)
        viewModelScope.launch {
            responsavelDao.insert(novoResponsavel)
        }
    }

    fun updateResponsavel(id: Int, nome: String, telefone: String, email: String) {
        val responsavelAtualizado = Responsavel(id = id, nome = nome, telefone = telefone, email = email)
        viewModelScope.launch {
            responsavelDao.update(responsavelAtualizado)
        }
    }

    fun deleteResponsavel(responsavel: Responsavel) {
        viewModelScope.launch {
            responsavelDao.delete(responsavel)
        }
    }

    // Turma methods
    val allTurmas: LiveData<List<Turma>> = turmaDao.getAllTurmas().asLiveData()

    fun getTurma(id: Int): LiveData<Turma> {
        return turmaDao.getTurma(id).asLiveData()
    }

    fun addNewTurma(turno: String, serie: String, nome: String) {
        val novaTurma = Turma(turno = turno, serie = serie, nome = nome)
        viewModelScope.launch {
            turmaDao.insert(novaTurma)
        }
    }

    fun updateTurma(id: Int, turno: String, serie: String, nome: String) {
        val turmaAtualizada = Turma(id = id, turno = turno, serie = serie, nome = nome)
        viewModelScope.launch {
            turmaDao.update(turmaAtualizada)
        }
    }

    fun deleteTurma(turma: Turma) {
        viewModelScope.launch {
            turmaDao.delete(turma)
        }
    }
    
    // Escola methods
    val allEscolas: LiveData<List<Escola>> = escolaDao.getAllEscolas().asLiveData()
    
    fun getEscola(id: Int): LiveData<Escola> {
        return escolaDao.getEscola(id).asLiveData()
    }
    
    fun addNewEscola(nome: String, endereco: String, numero: String, cep: String, diretor: String) {
        val novaEscola = Escola(nome = nome, endereco = endereco, numero = numero, cep = cep, diretor = diretor)
        viewModelScope.launch {
            escolaDao.insert(novaEscola)
        }
    }
    
    fun updateEscola(id: Int, nome: String, endereco: String, numero: String, cep: String, diretor: String) {
        val escolaAtualizada = Escola(id = id, nome = nome, endereco = endereco, numero = numero, cep = cep, diretor = diretor)
        viewModelScope.launch {
            escolaDao.update(escolaAtualizada)
        }
    }
    
    fun deleteEscola(escola: Escola) {
        viewModelScope.launch {
            escolaDao.delete(escola)
        }
    }

    // Condutor methods
    val allCondutores: LiveData<List<Condutor>> = condutorDao.getAllCondutores().asLiveData()

    fun getCondutor(id: Int): LiveData<Condutor> {
        return condutorDao.getCondutor(id).asLiveData()
    }

    fun addNewCondutor(nome: String, telefone: String, placaVeiculo: String) {
        val novoCondutor = Condutor(nome = nome, telefone = telefone, placaVeiculo = placaVeiculo)
        viewModelScope.launch {
            condutorDao.insert(novoCondutor)
        }
    }

    fun updateCondutor(id: Int, nome: String, telefone: String, placaVeiculo: String) {
        val condutorAtualizado = Condutor(id = id, nome = nome, telefone = telefone, placaVeiculo = placaVeiculo)
        viewModelScope.launch {
            condutorDao.update(condutorAtualizado)
        }
    }

    fun deleteCondutor(condutor: Condutor) {
        viewModelScope.launch {
            condutorDao.delete(condutor)
        }
    }
}

class SchoolViewModelFactory(
    private val alunoDao: AlunoDao,
    private val responsavelDao: ResponsavelDao,
    private val turmaDao: TurmaDao,
    private val escolaDao: EscolaDao,
    private val condutorDao: CondutorDao
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SchoolViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return SchoolViewModel(alunoDao, responsavelDao, turmaDao, escolaDao, condutorDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}