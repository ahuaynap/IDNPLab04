package com.example.idnplab04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_enroll_student.*

class EnrollStudentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enroll_student)

        buttonAddStudent.setOnClickListener {
            val newStudent = Student(
                editTextEnrollCui.text.toString(),
                editTextEnrollName.text.toString(),
                editTextEnrollSurname.text.toString())

            val returnItent = Intent()
            returnItent.putExtra("newStudent", newStudent)

            setResult(RESULT_OK, returnItent)
            finish()
        }
    }
}