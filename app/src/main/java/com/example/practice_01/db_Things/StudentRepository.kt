package com.example.practice_01.db_Things

class StudentRepository(private val dao: DAO) {

    //Repository's logic is to abstract(limited) the access of dat
    //so we don`t have to access id directly from the DAO now we use reposit..

    val getAllStudent: List<Student> = dao.getAllData()

    suspend fun addStudents(student: Student){
        dao.addStudent(student)
    }

}