package com.example.idnplab04

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.list_item_student.view.*

class StudentAdapter(private val myContext: Context, private val listStudent: List<Student>)
    : ArrayAdapter<Student>(myContext, 0, listStudent) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout = LayoutInflater.from(myContext).inflate(R.layout.list_item_student, parent, false)

        val student = listStudent[position]

        layout.textViewName.text = student.name
        layout.textViewSurname.text = student.surname
        layout.textViewCui.text = student.cui

        return layout
    }
}