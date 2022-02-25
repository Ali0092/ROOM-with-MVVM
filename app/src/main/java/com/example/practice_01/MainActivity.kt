package com.example.practice_01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.DocumentsContract
import android.widget.Toast
import androidx.room.Room
import com.example.practice_01.databinding.ActivityMainBinding
import com.example.practice_01.db_Things.Student
import com.example.practice_01.db_Things.StudentDataBase
import java.math.RoundingMode.valueOf

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db=StudentDataBase.getDatabase(applicationContext)
        binding.save.setOnClickListener {   addStudentInDB(db) }
        binding.load.setOnClickListener { getAllStudents(db) }

    }

    private fun getAllStudents(db: StudentDataBase) {
        val s1=db.getDao().getAllData()
        binding.getId.text=s1.id.toString()
        binding.getName.text=s1.name.toString()
        binding.getFName.text=s1.fname.toString()
        binding.getGrade.text=s1.grade.toString()
    }

    private fun addStudentInDB(db:StudentDataBase) {
        val id=binding.setId.text.toString().toInt()
        val name=binding.setName.text.toString()
        val fname=binding.setFName.text.toString()
        val grade=binding.setGrade.text.toString()

        val s1=Student(id,name,fname,grade)

        db.getDao().addStudent(s1)
        Toast.makeText(this.applicationContext,"Student Added",Toast.LENGTH_LONG).show()
    }
}