package com.example.db

import android.util.Log
import com.example.model.Student
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class FirebaseDatabase {

    private val database = Firebase.firestore
    private val TAG = "FirebaseDatabase";
    val data = ArrayList<Student>()


    fun getAllStudents() {
        database.collection("student")
            .get()
            .addOnSuccessListener {
                for (document in it){
                    data.add(
                        Student(
                            document.id,
                            document.data?.get("name") as String,
                            document.data?.get("school_name") as String
                    )
                    )
                }
            }
            .addOnFailureListener {
                Log.d(TAG, "network call failed")
            }
    }

    fun getStudentList():ArrayList<Student>{
        getAllStudents().also { return data }
    }
}