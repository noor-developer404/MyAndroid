package com.example.android.others

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.R
import com.example.android.interfaces.rcv_interface


class rcv_adapter(var face: rcv_interface) : RecyclerView.Adapter<rcv_adapter.holder>() {


    class holder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_rcv,parent,false)
        return holder(view)
    }

    override fun getItemCount(): Int {
        return 20
    }

    override fun onBindViewHolder(holder: holder, position: Int) {
        holder.itemView.setOnClickListener(View.OnClickListener {
            face.onclick()
        })
        holder.itemView.setOnLongClickListener {
            face.long_click()
            return@setOnLongClickListener true
        }
    }
}