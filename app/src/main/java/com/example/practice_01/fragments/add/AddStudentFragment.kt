package com.example.practice_01.fragments.add

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.practice_01.R
import com.example.practice_01.databinding.FragmentAddStudentBinding
import com.example.practice_01.model.Student
import com.example.practice_01.viewModel.StudentViewModel

class AddStudentFragment : Fragment(R.layout.fragment_add_student) {

    private lateinit var binding: FragmentAddStudentBinding
    private lateinit var studentViewModel: StudentViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //initialization of the lateinit.. variables..
        binding= FragmentAddStudentBinding.inflate(inflater,container,false)
        studentViewModel=ViewModelProvider(this)[StudentViewModel::class.java]

        binding.add.setOnClickListener {
            addStudentDataInDB()
            this.findNavController().navigate(R.id.action_addStudentFragment_to_listFragment)
        }
        return binding.root
    }

    //Func. that adds the single student every times its been called..
    private fun addStudentDataInDB() {
     val id=binding.id.text
     val name=binding.name.text.toString()
     val fname=binding.fname.text.toString()
     val grade=binding.grade.text.toString()

     if(checkInput(id.toString(),name,fname,grade)){
         val s= Student(Integer.parseInt(id.toString()),name,fname,grade)
         studentViewModel.addStudent(s)
     }
     else{ Toast.makeText(context,"Fields must not be Empty..", Toast.LENGTH_LONG).show() }
    }
//Func. that returns true if all the fields are filled...
    private fun checkInput(id:String,name:String,fname:String,grade:String): Boolean{
        return !((TextUtils.isEmpty(id)) && (TextUtils.isEmpty(name)) && (TextUtils.isEmpty(fname)) && (TextUtils.isEmpty(grade)))
    }

}