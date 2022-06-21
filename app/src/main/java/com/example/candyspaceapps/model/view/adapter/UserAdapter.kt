package com.example.candyspaceapps.model.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.candyspaceapps.databinding.LayoutItemBinding
import com.example.candyspaceapps.model.data.UserDetails
import com.example.candyspaceapps.util.getTimeChange
import com.example.candyspaceapps.util.loadImagefromUrl

class UserAdapter (
    //Private List of Users
    private val listUsers:MutableList<UserDetails> = mutableListOf()

): RecyclerView.Adapter<UserViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(LayoutItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    //load data function
    fun loadData(listNotify: MutableList<UserDetails>){
        this.listUsers.clear()
        this.listUsers.addAll(listNotify)
        notifyDataSetChanged()
    }

    //Get count of list of users
    override fun getItemCount(): Int {
        return listUsers.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.setNotifyInfo(listUsers[position])
    }

}

class UserViewHolder(itemView: LayoutItemBinding) : RecyclerView.ViewHolder(itemView.root) {

    val sEBinding=itemView
    //Method with if conditions to display user details like image, creation date and badge info.
    fun setNotifyInfo(userItem: UserDetails) {

        sEBinding.name.text=userItem.displayName+"(${userItem.userId})"
        userItem.profileImage?.let {
            sEBinding.imageView.loadImagefromUrl(it)
        }
        userItem.creationDate?.let {
            sEBinding.memberFrom.text = getTimeChange(it)
        }

        //Bronze badge info
        if(userItem.badgeCounts.bronze>0){
            sEBinding.badgeBro.visibility= View.VISIBLE
            sEBinding.badgeB.visibility= View.VISIBLE
            sEBinding.badgeB.text=userItem.badgeCounts.bronze.toString()
        }
        else{
            sEBinding.badgeB.visibility= View.GONE
            sEBinding.badgeBro.visibility= View.GONE
        }

        //Silver badge info
        if(userItem.badgeCounts.silver>0){
            sEBinding.badgeSil.visibility= View.VISIBLE
            sEBinding.badgeS.visibility= View.VISIBLE
            sEBinding.badgeS.text=userItem.badgeCounts.silver.toString()
        }
        else{
            sEBinding.badgeS.visibility= View.GONE
            sEBinding.badgeSil.visibility= View.GONE
        }
        //Gold badge info
        if(userItem.badgeCounts.gold>0){
            sEBinding.badgeGol.visibility= View.VISIBLE
            sEBinding.badgeG.visibility= View.VISIBLE
            sEBinding.badgeG.text=userItem.badgeCounts.gold.toString()
        }
        else{
            sEBinding.badgeGol.visibility= View.GONE
            sEBinding.badgeG.visibility= View.GONE
        }
    }
}