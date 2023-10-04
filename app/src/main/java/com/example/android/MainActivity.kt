package com.example.android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
//import com.example.myandroid.R
import com.example.android.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),OnClickListener {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mainRecyclerview.setOnClickListener(this)
        binding.mainTablayout.setOnClickListener(this)
        binding.mainNavigationDrawer.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        if (p0 != null) {
            when(p0.id){
                R.id.main_recyclerview->{
                    val intent = Intent(this,recyclerview::class.java)
                    startActivity(intent)
                }
                R.id.main_tablayout->{
                    val intent = Intent(this,TabLayout::class.java)
                    startActivity(intent)
                }
                R.id.main_navigationDrawer->{
                    val intent = Intent(this,NavDrawer::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}