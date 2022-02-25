package com.example.practice_01.db_Things

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student_table")
data class Student(
   @PrimaryKey(autoGenerate = true)
    val id:Int,
    val name:String,
    val fname:String,
    val grade:String
)
