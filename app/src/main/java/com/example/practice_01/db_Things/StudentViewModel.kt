package com.example.practice_01.db_Things

import android.app.Application
import android.os.Build.VERSION_CODES.S
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class StudentViewModel(application: Application):AndroidViewModel(application) {

//ViewModel that connects the data and the UI elements

    var readAllData:LiveData<List<Student>>
    private  var repository:StudentRepository

    init {
        val studentDao=StudentDataBase.getDatabase(application).getDao()
        repository= StudentRepository(studentDao)
        readAllData=repository.getAllStudent
    }

    fun addStudent(student: Student){
      viewModelScope.launch { Dispatchers.IO }
        repository.addStudents(student)
    }

}