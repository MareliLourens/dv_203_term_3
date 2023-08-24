package com.example.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.finalproject.databinding.CategoryScreenBinding

class CategoryScreen : AppCompatActivity() {

    lateinit var binding: CategoryScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = CategoryScreenBinding.inflate(layoutInflater)
        setContentView(binding.root) // Set the content view to the inflated layout

        val username = intent?.extras?.getString("username")

        Log.d("AAA Welcome: ", username.toString())

        binding.button2.setOnClickListener {
            val intent = Intent(this, QuestionsM::class.java)
            intent.putExtra("username", username.toString())
            startActivity(intent)
        }

        binding.Liyue.setOnClickListener {
            val intent2 = Intent(this, QuestionsL::class.java)
            startActivity(intent2)
        }

        binding.button3.setOnClickListener {
            val intent3 = Intent(this, QuestionsI::class.java)
            startActivity(intent3)
        }

    }
}