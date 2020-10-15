package com.example.idnplab04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_update_student.*

class UpdateStudentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_student)

        val student = intent.getSerializableExtra("student") as Student

        editTextName.setText(student.name)
        editTextSurname.setText(student.surname)
        editTextCui.setText(student.cui)

        buttonUpdateStudent.setOnClickListener {

            student.name = editTextName.text.toString()
            student.surname = editTextName.text.toString()
            student.cui = editTextCui.text.toString()

            finish()
        }

    }

}