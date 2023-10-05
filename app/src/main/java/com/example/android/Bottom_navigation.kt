package com.example.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import androidx.fragment.app.Fragment
import com.example.android.databinding.ActivityBottomNavigationBinding
import com.example.android.fragments.tab_frag1
import com.example.android.fragments.tab_frag2
import com.example.android.fragments.tab_frag3
import com.google.android.material.navigation.NavigationBarView
import com.google.android.material.navigation.NavigationView

class Bottom_navigation : AppCompatActivity() {
    lateinit var binding: ActivityBottomNavigationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityBottomNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction().replace(R.id.bottomNav_framelayout,tab_frag1()).commit()

        binding.bottomNavBNview.setOnItemSelectedListener(NavigationBarView.OnItemSelectedListener {
            var frag: Fragment? =null
            when(it.itemId){
                R.id.nav_menu_chat->{ frag=tab_frag1() }
                R.id.nav_menu_status->{frag= tab_frag2() }
                R.id.nav_menu_call->{frag=tab_frag3()}
            }
            if (frag != null) {
                supportFragmentManager.beginTransaction().replace(R.id.bottomNav_framelayout,frag).commit()
            }
            true
        })
    }
}