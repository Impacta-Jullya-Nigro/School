package com.example.school.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [
    User::class, 
    Aluno::class, 
    Condutor::class, 
    Responsavel::class, 
    Escola::class, 
    Turma::class,
    CondutorAlunoCrossRef::class,
    AlunoResponsavelCrossRef::class
], version = 4)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun alunoDao(): AlunoDao
    abstract fun condutorDao(): CondutorDao
    abstract fun responsavelDao(): ResponsavelDao
    abstract fun escolaDao(): EscolaDao
    abstract fun turmaDao(): TurmaDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "school_database"
                )
                .fallbackToDestructiveMigration()
                .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
