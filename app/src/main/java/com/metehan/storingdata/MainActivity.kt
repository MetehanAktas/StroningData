package com.metehan.storingdata

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.metehan.storingdata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var sharedPref : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPref = this.getSharedPreferences("com.metehan.storingdata",Context.MODE_PRIVATE)
        val userAgePref = sharedPref.getInt("age",-1)
    }

    fun save(view: View){
        val myAge = binding.editText.toString().toIntOrNull()
        if (myAge != null){
            binding.textView1.text = "Your age: ${myAge}"
            sharedPref.edit().putInt("Age",myAge).apply()
        }
    }

    fun delete(view: View){
        sharedPref.edit().remove("age").apply()
    }

}