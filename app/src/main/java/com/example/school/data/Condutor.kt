package com.example.school.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "condutor")
data class Condutor(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_condutor")
    val id: Int = 0,
    val nome: String,
    val telefone: String,
    @ColumnInfo(name = "placa_veiculo")
    val placaVeiculo: String,
    @ColumnInfo(name = "criado_em")
    val criadoEm: Long = System.currentTimeMillis()
)
