package com.example.retrofit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.databinding.UseritemBinding
import com.example.retrofit.models.Users
import com.example.retrofit.models.UsersItem

class rvAdapter(private  val users: List<UsersItem>) : RecyclerView.Adapter<rvAdapter.ViewHolder> (){
    class ViewHolder(val binding: UseritemBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var currentItem = users[position]
        holder.binding.apply {
            idUsers.text = currentItem.id.toString()
            titleUsers.text = currentItem.title.toString()
            bodyUsers.text = currentItem.body.toString()
            UserIdUsers.text= currentItem.userId.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
      return  ViewHolder(UseritemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return  users.count()
    }
}