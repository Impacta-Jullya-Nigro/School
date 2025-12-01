package com.example.school.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface TurmaDao {

    @Insert
    suspend fun insert(turma: Turma)

    @Update
    suspend fun update(turma: Turma)

    @Delete
    suspend fun delete(turma: Turma)

    @Query("SELECT * from turma ORDER BY serie ASC, nome ASC")
    fun getAllTurmas(): Flow<List<Turma>>

    @Query("SELECT * from turma WHERE id_turma = :id")
    fun getTurma(id: Int): Flow<Turma>
}