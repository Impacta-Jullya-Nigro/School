package com.example.school.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
<<<<<<< HEAD
import kotlinx.coroutines.flow.Flow
=======
>>>>>>> 32522647552eaf3437a1ad301fed80a1ea22492c

@Dao
interface CondutorDao {

    @Insert
    suspend fun insert(condutor: Condutor)

    @Update
    suspend fun update(condutor: Condutor)

    @Delete
    suspend fun delete(condutor: Condutor)

<<<<<<< HEAD
    @Query("SELECT * from condutor ORDER BY nome ASC")
    fun getAllCondutores(): Flow<List<Condutor>>

    @Query("SELECT * from condutor WHERE id_condutor = :id")
    fun getCondutor(id: Int): Flow<Condutor>
}
=======
    @Query("SELECT * FROM condutor ORDER BY nome ASC")
    suspend fun getAllCondutores(): List<Condutor>

    @Query("SELECT * FROM condutor WHERE id_condutor = :id")
    suspend fun getCondutorById(id: Int): Condutor?
}
>>>>>>> 32522647552eaf3437a1ad301fed80a1ea22492c
