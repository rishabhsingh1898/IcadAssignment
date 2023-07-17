package com.example.assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.adapter.StudentAdapter
import com.example.assignment.databinding.ActivityMainBinding
import com.example.db.FirebaseDatabase
import com.example.model.Student
import com.example.repository.StudentRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        val repository = StudentRepository()
        val data = repository.getAllStudent()
        val adapter = StudentAdapter()
        val recyclerView = binding.rvRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        adapter.submitList(data)
    }
}