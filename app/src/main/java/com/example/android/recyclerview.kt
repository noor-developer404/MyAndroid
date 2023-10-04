package com.example.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.android.databinding.ActivityRecyclerviewBinding
import com.example.android.interfaces.rcv_interface
import com.example.android.others.rcv_adapter

class recyclerview : AppCompatActivity(),rcv_interface {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityRecyclerviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rcv.layoutManager = LinearLayoutManager(this)
        binding.rcv.adapter = rcv_adapter(this)
    }

    override fun onclick() {
        Toast.makeText(this,"clicked",Toast.LENGTH_SHORT).show()
    }

    override fun long_click() {
        Toast.makeText(this,"pressed",Toast.LENGTH_SHORT).show()

    }
}