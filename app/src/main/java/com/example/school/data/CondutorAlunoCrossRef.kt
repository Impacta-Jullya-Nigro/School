package com.example.school.data

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(
    tableName = "condutor_aluno",
    primaryKeys = ["id_condutor", "id_aluno"]
)
data class CondutorAlunoCrossRef(
    @ColumnInfo(name = "id_condutor")
    val condutorId: Int,
    @ColumnInfo(name = "id_aluno")
    val alunoId: Int,
    @ColumnInfo(name = "criado_em")
    val criadoEm: Long = System.currentTimeMillis()
)
