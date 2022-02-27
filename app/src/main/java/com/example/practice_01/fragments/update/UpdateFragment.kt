package com.example.practice_01.fragments.update


import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.practice_01.R
import com.example.practice_01.databinding.FragmentUpdateBinding
import com.example.practice_01.model.Student
import com.example.practice_01.viewModel.StudentViewModel

class UpdateFragment : Fragment(R.layout.fragment_update) {

    private lateinit var binding:FragmentUpdateBinding
    private lateinit var studentViewModel:StudentViewModel
    private val args by navArgs<UpdateFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //Initialization of variables..
        binding= FragmentUpdateBinding.inflate(inflater,container,false)
        studentViewModel=ViewModelProvider(this)[StudentViewModel::class.java]

        //Enabling OptionMenu Displaying on Screen..
        setHasOptionsMenu(true)

        //Assigning data to the fields respectively..
        binding.updateId.setText(args.currentItem.id.toString())
        binding.updateName.setText(args.currentItem.name)
        binding.updateFname.setText(args.currentItem.fname)
        binding.updateGrade.setText(args.currentItem.grade)

        binding.updateBtn.setOnClickListener {
            Toast.makeText(context,"Updation Done..", Toast.LENGTH_LONG).show()
            updateStudent()
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        }

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.option_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==R.id.delete_icon){
            Toast.makeText(context,"Clicked..",Toast.LENGTH_LONG).show()
            deleteStudentData()
        }
        return super.onOptionsItemSelected(item)
    }

    fun updateStudent(){
        val id=Integer.parseInt(binding.updateId.text.toString())
        val name=binding.updateName.text.toString()
        val fname=binding.updateFname.text.toString()
        val grade=binding.updateGrade.text.toString()

        val updated=Student(id,name,fname,grade)
        studentViewModel.updateStudent(updated)
    }

    fun deleteStudentData(){

        //Deletion and AlertDialog creation....
        val builder=AlertDialog.Builder(context)

        builder.setPositiveButton("Yes"){_,_->
           studentViewModel.deleteStudent(args.currentItem)
            Toast.makeText(context,"Deleted",Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        }

        builder.setNegativeButton("NO"){_,_->
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        }

        builder.setTitle("Delete ${args.currentItem.name}")
        builder.setMessage("Are you sure you want to Delete this..?")
        builder.create().show()

    }

}