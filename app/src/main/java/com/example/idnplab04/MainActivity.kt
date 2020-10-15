package com.example.idnplab04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var listStudents:MutableList<Student>
    private lateinit var adapter: StudentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listStudents = mutableListOf(
            Student("20160396", "Dean", "Winchester Fall"),
            Student("20161548", "Jean Steven", "Smith Dalas")
        )

        adapter = StudentAdapter(this, listStudents)

        listViewStudents.adapter = adapter

        listViewStudents.setOnItemClickListener { adapterView, view, i, l ->
            val intentEditStudent = Intent(this, UpdateStudentActivity::class.java)

            intentEditStudent.putExtra("student", listStudents[i])

            startActivity(intentEditStudent)
        }

        buttonEnrollStudent.setOnClickListener {
            val intentEnrollStudent = Intent(this,EnrollStudentActivity::class.java)

            startActivityForResult(intentEnrollStudent, 12)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == RESULT_OK && data != null ){
            val newStudent = data.getSerializableExtra("newStudent") as Student
            listStudents.add(newStudent)
            adapter.notifyDataSetChanged()

        }
    }
}