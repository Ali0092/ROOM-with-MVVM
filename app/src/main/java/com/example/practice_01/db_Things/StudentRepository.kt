package com.example.practice_01.db_Things

import androidx.lifecycle.LiveData

class StudentRepository(private val dao: DAO) {

    //Repository's logic is to abstract(limited) the access of dat
    //so we don`t have to access id directly from the DAO now we use reposit..

    val getAllStudent: LiveData<List<Student>> = dao.getAllData()

     fun addStudents(student: Student){
        dao.addStudent(student)
    }

}