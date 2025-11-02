package com.example.school.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface CondutorDao {

    @Insert
    suspend fun insert(condutor: Condutor)

    @Update
    suspend fun update(condutor: Condutor)

    @Delete
    suspend fun delete(condutor: Condutor)

    @Query("SELECT * FROM condutor ORDER BY nome ASC")
    suspend fun getAllCondutores(): List<Condutor>

    @Query("SELECT * FROM condutor WHERE id_condutor = :id")
    suspend fun getCondutorById(id: Int): Condutor?
}
