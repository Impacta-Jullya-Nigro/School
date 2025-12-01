package com.example.school.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "aluno",
    foreignKeys = [
        ForeignKey(
            entity = Turma::class,
            parentColumns = ["id_turma"],
            childColumns = ["turma_id"],
            onDelete = ForeignKey.SET_NULL
        ),
        ForeignKey(
            entity = Responsavel::class,
            parentColumns = ["id_responsavel"],
            childColumns = ["responsavel_id"],
            onDelete = ForeignKey.SET_NULL
        ),
        ForeignKey(
            entity = Condutor::class,
            parentColumns = ["id_condutor"],
            childColumns = ["condutor_id"],
            onDelete = ForeignKey.SET_NULL
        )
    ]
)
data class Aluno(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nome: String,
    val idade: Int,
    val professor: String,
    @ColumnInfo(name = "turma_id", index = true)
    val turmaId: Int? = null,
    @ColumnInfo(name = "responsavel_id", index = true)
    val responsavelId: Int? = null,
    @ColumnInfo(name = "condutor_id", index = true)
    val condutorId: Int? = null
)
