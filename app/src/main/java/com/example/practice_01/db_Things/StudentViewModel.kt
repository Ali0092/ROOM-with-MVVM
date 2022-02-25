package com.example.practice_01.db_Things

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class StudentViewModel(application: Application):AndroidViewModel(application) {
   /* //Implementing Later
    private val getAllData:List<Student>
    val repository:StudentRepository

    init {
       val studentDAO=StudentDataBase.getDatabase(application).getDao()
       repository= StudentRepository(studentDAO)
       getAllData=repository.getAllStudent
    }

    suspend fun addStudent(student: Student){
        viewModelScope.launch { Dispatchers.IO }
        repository.addStudents(student)
    }
    */
}