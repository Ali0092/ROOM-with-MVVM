package com.example.practice_01.fragments.list

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.practice_01.databinding.ItemLayoutBinding
import com.example.practice_01.model.Student

//List RecyclerView Adapter that connects UI and Data...
class ListAdapter:RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var stuList= emptyList<Student>()

    //Inner Class (MyViewHolder)
    class MyViewHolder(val binding:ItemLayoutBinding):RecyclerView.ViewHolder(binding.root){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       val currentItem=stuList[position]

        holder.binding.apply {
            this.setId.text=currentItem.id.toString()
            this.setName.text=currentItem.name
            this.setFname.text=currentItem.fname
            this.setGrade.text=currentItem.grade
        }

        //when the certain item is being selected..
        holder.binding.itemLayoutConst.setOnClickListener {
            val action=ListFragmentDirections.actionListFragmentToUpdateFragment(currentItem)
            it.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
       return stuList.size
    }

    //that notifies that the data set is changed...
    @SuppressLint("NotifyDataSetChanged")
    fun DataChanges(user:List<Student>){
        this.stuList=user
        this.notifyDataSetChanged()
    }
}