package com.example.practice_01.db_Things

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.practice_01.model.Student

//DataBase that contains the main Object(Instance) of the DataBase..

@Database(entities = [Student::class], version = 1, exportSchema = false)
abstract class StudentDataBase:RoomDatabase() {

    //that will return DAO
    abstract fun getDao():DAO

    //Means a static Object..that guarantees single instance existence at a time
    companion object{
        @Volatile
        private var INSTANCE:StudentDataBase?=null

        //func. that creates the instance of DB if it is not in existence..
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