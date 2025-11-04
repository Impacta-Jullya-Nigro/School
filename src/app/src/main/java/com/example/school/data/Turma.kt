package com.example.school.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "turma")
data class Turma(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_turma")
    val id: Int = 0,
    val turno: String, // Manhã, Tarde, Noite
    val serie: String, // 1º ano, 2º ano, etc.
    val nome: String,  // A, B, C
    @ColumnInfo(name = "criado_em")
    val criadoEm: Long = System.currentTimeMillis()
)
