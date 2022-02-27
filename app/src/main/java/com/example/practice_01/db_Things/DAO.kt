package com.example.practice_01.db_Things

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.practice_01.model.Student


@Dao
interface DAO {
    //Functions that are used to retrieve and set data in DB (QUERIES)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
     fun addStudent(student: Student)

     @Update
     fun updateStudent(student: Student)

     //For deleting all the students data we have to make the Query
     @Delete
      fun deleteStudent(student: Student)

    @Query("SELECT*FROM student_table")
    fun getAllData():LiveData<List<Student>>
}