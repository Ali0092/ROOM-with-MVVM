package com.example.practice_01.db_Things

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface DAO {
    //Functions that are used to retrieve and set data in DB

    @Insert(onConflict = OnConflictStrategy.IGNORE)
     fun addStudent(student: Student)

    @Query("SELECT*FROM student_table ORDER BY id ASC")
    fun getAllData():LiveData<List<Student>>
}