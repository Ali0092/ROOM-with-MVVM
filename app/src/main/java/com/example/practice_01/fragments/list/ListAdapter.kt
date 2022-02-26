package com.example.practice_01.fragments.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practice_01.databinding.ItemLayoutBinding
import com.example.practice_01.db_Things.Student

class ListAdapter:RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var stuList= emptyList<Student>()

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
    }

    override fun getItemCount(): Int {
       return stuList.size-1
    }

    fun DataChanges(user:List<Student>){
        this.stuList=user
        notifyDataSetChanged()
    }
}