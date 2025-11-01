package com.example.school.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class SchoolViewModel(private val alunoDao: AlunoDao) : ViewModel() {

    fun addNewAluno(nome: String, idade: Int, serie: String, turma: String, professor: String) {
        val novoAluno = Aluno(nome = nome, idade = idade, serie = serie, turma = turma, professor = professor)
        viewModelScope.launch {
            alunoDao.insert(novoAluno)
        }
    }
}

class SchoolViewModelFactory(
    private val alunoDao: AlunoDao
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SchoolViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return SchoolViewModel(alunoDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}