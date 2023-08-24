package com.example.finalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.finalproject.databinding.HomepageBinding
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.widget.EditText
import android.widget.Toast

class Homepage : AppCompatActivity() {

    lateinit var binding: HomepageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = HomepageBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)

        binding.SettingsButton.setOnClickListener {
            val intent = Intent(this, SettingsScreen::class.java)
            startActivity(intent)
        }

        binding.PlayButton.setOnClickListener {
            val username = binding.NameInputText.text.toString()


            if (username.isBlank()) {
                val alertDialogBuilder = AlertDialog.Builder(this)
                alertDialogBuilder.setTitle("No Name has been entered")
                alertDialogBuilder.setMessage("Please fill in your username.")

                // Add an EditText input field to the AlertDialog
                val inputEditText = EditText(this)
                alertDialogBuilder.setView(inputEditText)

                alertDialogBuilder.setPositiveButton("OK") { _, _ ->
                    val newName = inputEditText.text.toString()
                    Log.d("AAA New Username: ", newName)
                    if (newName.isNotBlank()) {
                        val intent = Intent(this, CategoryScreen::class.java)
                        intent.putExtra("username", newName)
                        startActivity(intent)
                    }
                }
                alertDialogBuilder.setNegativeButton("Cancel") { _, _ ->
                    // This block will be executed when the user clicks the "Cancel" button
                }
                val alertDialog = alertDialogBuilder.create()
                alertDialog.show()

                Toast.makeText(this, "Please enter your name", Toast.LENGTH_LONG).show()
            }else{
                Log.d("AAA Captured Username: ", username)


                val categoryIntent = Intent(this, CategoryScreen::class.java)
                categoryIntent.putExtra("username", username.toString())

                startActivity(categoryIntent)

            }

        }

    }
    override fun onResume() {
        super.onResume()

        val sharedPref = getSharedPreferences("myPref", MODE_PRIVATE)
        val lastScore = sharedPref.getInt("last_score", 0)
        val highestScore = sharedPref.getInt("highest_score", 0)

        binding.ScoreText.text = highestScore.toString()

        Log.d("Homepage", "AAA Retrieved Highest Score: $highestScore")

        if (lastScore > highestScore) {
            // Update the highest score in SharedPreferences
            val editor = sharedPref.edit()
            editor.putInt("highest_score", lastScore)
            editor.apply()

            Log.d("Homepage", "AAA New Highest Score: $lastScore")
        }

    }

}
