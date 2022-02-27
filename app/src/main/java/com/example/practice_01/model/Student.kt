package com.example.practice_01.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

//Student Entity or Table that contains the relative Attributes..
@Parcelize
@Entity(tableName = "student_table")
data class Student(
   @PrimaryKey(autoGenerate = true)
    val id:Int,
    val name:String,
    val fname:String,
    val grade:String
) : Parcelable
