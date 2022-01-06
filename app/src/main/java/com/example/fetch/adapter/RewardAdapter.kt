package com.example.fetch.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fetch.R
import com.example.fetch.model.FetchDataItem

class RewardAdapter (val context: Context) : RecyclerView.Adapter<RewardAdapter.MyViewHolder>() {


    var itemList : List<FetchDataItem> = listOf()
    val sortedList = itemList.sortedWith(compareBy(FetchDataItem::listId, FetchDataItem::name))

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.recyclerview_adapter,
            parent,
            false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.listId.text = itemList[position].listId.toString()
        holder.name.text = itemList[position].name
    }

    override fun getItemCount(): Int {
       return itemList.size
    }

    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

        val listId: TextView = itemView!!.findViewById(R.id.listId)
        val name: TextView = itemView!!.findViewById(R.id.itemName)
    }

    fun setFetchData(itemList: List<FetchDataItem>) {
        this.itemList = itemList
        notifyDataSetChanged()
    }
}