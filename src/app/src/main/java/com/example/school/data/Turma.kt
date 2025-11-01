package com.example.school.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "turma",
    foreignKeys = [
        ForeignKey(
            entity = Escola::class,
            parentColumns = ["id_escola"],
            childColumns = ["id_escola"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Turma(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_turma")
    val id: Int = 0,
    val nome: String,
    @ColumnInfo(name = "horario_entrada")
    val horarioEntrada: String, // Room doesn't have a TIME type, so we use String or Long
    @ColumnInfo(name = "horario_saida")
    val horarioSaida: String,   // Room doesn't have a TIME type, so we use String or Long
    @ColumnInfo(name = "id_escola")
    val idEscola: Int,
    @ColumnInfo(name = "criado_em")
    val criadoEm: Long = System.currentTimeMillis()
)
