package com.example.school.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "aluno")
data class Aluno(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nome: String,
    val idade: Int,
    val serie: String,
    val turma: String,
    val professor: String
)