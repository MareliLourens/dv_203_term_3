package com.example.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import com.example.finalproject.databinding.ActivityResultsBinding
import com.example.finalproject.databinding.HomepageBinding

class Results : AppCompatActivity() {

    lateinit var binding: ActivityResultsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityResultsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val username = intent.extras?.getString("username")
        val totalQuestions = intent?.extras?.getInt("totalQuestions") ?: 0
        val categoryName = intent?.extras?.getString("categoryName")
        val categoryPictureResourceId = intent?.extras?.getInt("categoryPicture")
        val defaultImageResourceId = resources.getIdentifier("inazuma_background", "drawable", packageName)

        var userscore = intent.extras?.getInt("userscore") ?: 0

        binding.username.text = username.toString()
        binding.score.text = userscore.toString() + "/" + totalQuestions.toString()

        binding.categoryName.text = categoryName.toString()
        binding.categoryPicture.setImageResource(categoryPictureResourceId ?: defaultImageResourceId)

        val sharedPref = getSharedPreferences("myPref", MODE_PRIVATE)
        val highestScore = sharedPref.getInt("highest_score", 0)
        if (userscore > highestScore) {
            val editor = sharedPref.edit()
            editor.putInt("highest_score", userscore)
            editor.apply()
            Log.d("Results", " AAA New Highest Score: $userscore")
        }


        // Set scoreImage based on userscore
        if (userscore > 3) {
            binding.scoreImage.setImageResource(R.drawable.fullpoints)
        } else {
            binding.scoreImage.setImageResource(R.drawable.nullpoints)
        }

        binding.resetToHome.setOnClickListener {
            val intent = Intent(this, Homepage::class.java)
            //intent.putExtra("username", username.toString())
            startActivity(intent)
        }
    }
}
