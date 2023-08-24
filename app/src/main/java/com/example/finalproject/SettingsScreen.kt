package com.example.finalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.finalproject.databinding.ActivitySettingsBinding

class SettingsScreen : AppCompatActivity() {
    lateinit var binding: ActivitySettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Handle the reset button click
        binding.reset.setOnClickListener {
            clearUserScore()
        }
    }

    private fun clearUserScore() {
        val sharedPref = getSharedPreferences("myPref", MODE_PRIVATE)
        val editor = sharedPref.edit()

        // Clear the stored user score
        editor.remove("last_user")
        editor.remove("last_score")
        editor.remove("highest_score")
        editor.apply()

        // Log the cleared values
        val lastUser = sharedPref.getString("last_user", null)
        val lastScore = sharedPref.getInt("last_score", 0)
        Log.d("SettingsScreen", "AAA Cleared User: $lastUser, Cleared Score: $lastScore")
    }
}
