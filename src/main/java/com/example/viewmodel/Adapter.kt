package com.example.viewmodel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.viewmodel.databinding.ItemViewBinding

class Adapter(val users: List<Users>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

//    private lateinit var binding: ItemViewBinding

    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context,)
        val view = inflater.inflate(R.layout.item_view,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = users[position].name
        holder.age.text = users[position].age.toString()
    }

    override fun getItemCount(): Int {
        return users.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val name = itemView.findViewById<TextView>(R.id.txtName)
        val age = itemView.findViewById<TextView>(R.id.txtAge)


    }
}

