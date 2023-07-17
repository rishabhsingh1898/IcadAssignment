package com.example.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment.R
import com.example.assignment.databinding.ListItemsBinding
import com.example.model.Student

class StudentAdapter : ListAdapter<Student, StudentAdapter.StudentViewHolder>(StudentDiffUtil) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        return StudentViewHolder(ListItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = getItem(position)
        holder.bind(student)
    }


    inner class StudentViewHolder(itemView: ListItemsBinding) : RecyclerView.ViewHolder(itemView.root) {
        fun bind(student: Student) {
            val name: TextView = itemView.findViewById(R.id.student_name)
            val schoolName: TextView = itemView.findViewById(R.id.school_name)
            name.text = student.name
            schoolName.text = student.schoolName
        }
    }

    companion object {
        object StudentDiffUtil : DiffUtil.ItemCallback<Student>() {
            override fun areItemsTheSame(oldItem: Student, newItem: Student): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Student, newItem: Student): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }

}