package com.example.practice_01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.DocumentsContract
import android.widget.Toast
import androidx.room.Room
import com.example.practice_01.databinding.ActivityMainBinding
import com.example.practice_01.db_Things.Student
import com.example.practice_01.db_Things.StudentDataBase
import java.math.RoundingMode.valueOf

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }

}