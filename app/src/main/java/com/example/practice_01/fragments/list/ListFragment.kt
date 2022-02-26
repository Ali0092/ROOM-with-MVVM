package com.example.practice_01.fragments.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practice_01.R
import com.example.practice_01.databinding.FragmentListBinding
import com.example.practice_01.db_Things.StudentViewModel

class ListFragment : Fragment(R.layout.fragment_list) {

    private lateinit var binding: FragmentListBinding
    private lateinit var studentViewModel: StudentViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //initialization of the Variables..
        binding= FragmentListBinding.inflate(inflater,container,false)

        //RecyclerView Adapter Initialization..
        val adapter=ListAdapter()
        binding.recView.adapter=adapter
        binding.recView.layoutManager=LinearLayoutManager(requireContext())

        studentViewModel= ViewModelProvider(this)[StudentViewModel::class.java]
        studentViewModel.readAllData.observe(viewLifecycleOwner, Observer { user->
            adapter.DataChanges(user)
        })

        binding.floatingActionButton.setOnClickListener {
            this.findNavController().navigate(R.id.action_listFragment_to_addStudentFragment2)
        }

        return binding.root
    }

}