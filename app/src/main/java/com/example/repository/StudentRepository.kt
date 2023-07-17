package com.example.repository

import android.util.Log
import com.example.db.FirebaseDatabase
import com.example.model.Student
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async

class StudentRepository {
    private val studentDatabase = FirebaseDatabase()
    var data = ArrayList<Student>()


     fun getAllStudent(): ArrayList<Student> {
        return studentDatabase.getStudentList()
    }
}