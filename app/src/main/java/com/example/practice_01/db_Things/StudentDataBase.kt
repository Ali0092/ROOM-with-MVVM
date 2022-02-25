package com.example.practice_01.db_Things

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Student::class], version = 1, exportSchema = false)
abstract class StudentDataBase:RoomDatabase() {

    //that will return DAO
    abstract fun getDao():DAO

    companion object{
        @Volatile
        private var INSTANCE:StudentDataBase?=null

        fun getDatabase(context:Context):StudentDataBase{
            val tempInstance= INSTANCE
            if(tempInstance!=null) return tempInstance
            synchronized(this){
                val inst= Room.databaseBuilder(
                    context,
                    StudentDataBase::class.java,
                    "student_database"
                ).allowMainThreadQueries().build()
                INSTANCE=inst
                return inst
            }
        }

    }

}