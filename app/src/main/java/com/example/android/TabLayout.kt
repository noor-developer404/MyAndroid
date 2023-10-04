package com.example.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.ActionBar
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.example.android.databinding.ActivityTabLayoutBinding
import com.example.android.others.tab_pageAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayoutMediator
import java.util.Objects

class TabLayout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityTabLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var items = arrayOf("Tab1","Tab2","Tab3")
        binding.viewPager.adapter=tab_pageAdapter(this)
        binding.tablayout.addOnTabSelectedListener(object: OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab!=null){
                    binding.viewPager.currentItem=tab.position
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
//                TODO("Not yet implemented")
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
//                TODO("Not yet implemented")
            }

        })

        TabLayoutMediator(binding.tablayout,binding.viewPager){ tab,position ->
            tab.text=items[position]
        }.attach()


//        var items = arrayOf("Tab1","Tab2","Tab3")
//        binding.viewPager.adapter = tab_pageAdapter(this)
//
//        binding.tablayout.addOnTabSelectedListener(object: OnTabSelectedListener{
//            override fun onTabSelected(tab: TabLayout.Tab?) {
//                if (tab != null) {
//                    binding.viewPager.currentItem=tab.position
//                }
//            }
//
//            override fun onTabUnselected(tab: TabLayout.Tab?) {
////                TODO("Not yet implemented")
//            }
//
//            override fun onTabReselected(tab: TabLayout.Tab?) {
////                TODO("Not yet implemented")
//            }
//
//        })

//        TabLayoutMediator(binding.tablayout,binding.viewPager){ tab,position->
//            tab.text=items[position]
//
//        }.attach()
    }
}