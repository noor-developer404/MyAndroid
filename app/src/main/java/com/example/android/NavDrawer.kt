package com.example.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.ActionBarDrawerToggle
import com.example.android.databinding.ActivityNavDrawerBinding
import com.google.android.material.navigation.NavigationView

class NavDrawer : AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityNavDrawerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.navDrawerToolbar)


        toggle = ActionBarDrawerToggle(this,binding.navDrawer,R.string.open,R.string.close)
        binding.navDrawer.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.navView.setNavigationItemSelectedListener {
            when (it.itemId){
                R.id.nav_menu_item1 -> Toast.makeText(this,"item1",Toast.LENGTH_SHORT).show()
                R.id.nav_menu_item2 ->Toast.makeText(this,"item2",Toast.LENGTH_SHORT).show()
                R.id.nav_menu_item3 ->Toast.makeText(this,"item3",Toast.LENGTH_SHORT).show()

            }
            true
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return toggle.onOptionsItemSelected(item)
    }

}