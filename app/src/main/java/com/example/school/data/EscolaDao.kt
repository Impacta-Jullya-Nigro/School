package com.example.school.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface EscolaDao {

    @Insert
    suspend fun insert(escola: Escola)

    @Update
    suspend fun update(escola: Escola)

    @Delete
    suspend fun delete(escola: Escola)

    @Query("SELECT * from escola ORDER BY nome ASC")
    fun getAllEscolas(): Flow<List<Escola>>

    @Query("SELECT * from escola WHERE id_escola = :id")
    fun getEscola(id: Int): Flow<Escola>
}