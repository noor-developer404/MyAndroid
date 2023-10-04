package com.example.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast

class ui : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val data = intent.getIntExtra("ui_id",0)
        setContentView(data)

//        setting background light i dark mode
        window.setBackgroundDrawableResource(R.color.white)

//        setting dropdown
        var languages = arrayOf("English","Hindi","Urdu","Arbi")
        var dropdown = findViewById<AutoCompleteTextView>(R.id.ui_edittext_dropdown)
        var arrayAdapter = ArrayAdapter(this,R.layout.ui_edittext_dropdown_item,languages)
        dropdown.setAdapter(arrayAdapter)
        dropdown.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->
            Toast.makeText(this,languages[i],Toast.LENGTH_SHORT).show()
        }


    }
}