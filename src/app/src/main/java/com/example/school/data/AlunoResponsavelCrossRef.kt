package com.example.school.data

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(
    tableName = "aluno_responsavel",
    primaryKeys = ["id_aluno", "id_responsavel"]
)
data class AlunoResponsavelCrossRef(
    @ColumnInfo(name = "id_aluno")
    val alunoId: Int,
    @ColumnInfo(name = "id_responsavel")
    val responsavelId: Int,
    @ColumnInfo(name = "criado_em")
    val criadoEm: Long = System.currentTimeMillis()
)
