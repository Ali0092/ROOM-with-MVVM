package com.example.practice_01.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.practice_01.db_Things.StudentDataBase
import com.example.practice_01.repository.StudentRepository
import com.example.practice_01.model.Student
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class StudentViewModel(application: Application):AndroidViewModel(application) {

//ViewModel that connects the data and the UI elements

    var readAllData:LiveData<List<Student>>
    private  var repository: StudentRepository

    init {
        //Assigning DAO
        val studentDao= StudentDataBase.getDatabase(application).getDao()
        //initialization of the Repository Variable...
        repository= StudentRepository(studentDao)
        readAllData=repository.getAllStudent
    }

   //Func. Declaration and Definitions...
    fun addStudent(student: Student){
      viewModelScope.launch(Dispatchers.IO) {
          repository.addStudents(student)
      }
    }

    fun updateStudent(student: Student){
        viewModelScope.launch (Dispatchers.IO){
            repository.updateStudnet(student)
        }
    }

    fun deleteStudent(student: Student){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteStudent(student)
        }
    }
}