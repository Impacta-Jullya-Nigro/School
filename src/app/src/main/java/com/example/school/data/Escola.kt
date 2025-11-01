package com.example.school.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "escola")
data class Escola(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_escola")
    val id: Int = 0,
    val nome: String,
    val endereco: String,
    val telefone: String,
    @ColumnInfo(name = "criado_em")
    val criadoEm: Long = System.currentTimeMillis()
)
