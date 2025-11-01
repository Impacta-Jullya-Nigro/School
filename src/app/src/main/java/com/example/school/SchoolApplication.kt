package com.example.school

import android.app.Application
import com.example.school.data.AppDatabase

class SchoolApplication : Application() {
    val database: AppDatabase by lazy { AppDatabase.getDatabase(this) }
}