package com.example.school.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface CondutorDao {

    @Insert
    suspend fun insert(condutor: Condutor)

    @Update
    suspend fun update(condutor: Condutor)

    @Delete
    suspend fun delete(condutor: Condutor)

    @Query("SELECT * from condutor ORDER BY nome ASC")
    fun getAllCondutores(): Flow<List<Condutor>>

    @Query("SELECT * from condutor WHERE id_condutor = :id")
    fun getCondutor(id: Int): Flow<Condutor>
}