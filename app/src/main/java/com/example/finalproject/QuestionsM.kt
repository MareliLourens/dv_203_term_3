package com.example.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.RadioButton
import android.widget.Toast
import com.example.finalproject.databinding.ActivityQuestionsMBinding
import com.example.finalproject.models.ConstantsM.Mondstadt_Questions
import com.example.finalproject.models.ConstantsM.getAllQuestionsM

class QuestionsM : AppCompatActivity() {
    private lateinit var binding: ActivityQuestionsMBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions_m)

        binding = ActivityQuestionsMBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        val questionNumber = intent?.extras?.getInt("questionNumber", 1)

        val username = intent?.extras?.getString("username")

        Log.d("AAA Welcomeq:", username.toString())

        var userscore = intent.extras?.getInt("userscore") ?: 0


        Log.d("AAA USER SCORE: ", userscore.toString())

        Log.d( "AAA Test", questionNumber.toString())

        if(questionNumber == 1) {

            getAllQuestionsM()
            Log.d( "AAA Test", "yes")
        }
        val listOfQuestions = Mondstadt_Questions

        Log.d( "AAA Test", listOfQuestions.count().toString())


        val currentQuestion = listOfQuestions[questionNumber!! -1]

        Log.d("AAA First Question: ", currentQuestion.questionText)
        binding.QuestionText.text = currentQuestion.questionText
        binding.answer1.text = currentQuestion.optionOne
        binding.answer2.text = currentQuestion.optionTwo
        binding.answer3.text = currentQuestion.optionThree
        binding.answer4.text = currentQuestion.optionFour
        binding.progressBar.progress = currentQuestion.id
        binding.ProgressText.text = "${questionNumber}/${listOfQuestions.count()}"

        binding.nextButton.setOnClickListener {
            var selectedAnswer: Int = binding.RadioGroup.checkedRadioButtonId

            Log.d("AAA Answer:", selectedAnswer.toString())

            if(selectedAnswer != -1) {
                var selectedAnswerValue = findViewById<RadioButton>(selectedAnswer)
                Log.d("AAA Answer Selected:", selectedAnswerValue.text.toString())
                if (selectedAnswerValue.text == currentQuestion.correctAnswer) {
                    userscore += 1
                }



                if (questionNumber == listOfQuestions.count()) {
                    Log.d("AAA Result:", userscore.toString());
                    val intent = Intent(this, Results::class.java)
                    intent.putExtra("userscore", userscore)
                    intent.putExtra("username", username)
                    intent.putExtra("totalQuestions", listOfQuestions.count())
                    intent.putExtra("categoryName", "Mondstadt")
                    val categoryPictureResourceId = resources.getIdentifier("mondstadt_background", "drawable", packageName)

                    intent.putExtra("categoryPicture", categoryPictureResourceId)

                    startActivity(intent)
                    finish()
                } else {
                    val intent = Intent(this, QuestionsM::class.java)
                    if (questionNumber != null) {
                        intent.putExtra("questionNumber", questionNumber + 1)
                    }
                    intent.putExtra("username", username)
                    intent.putExtra("userscore", userscore)
                    startActivity(intent)
                    finish()
            }
            }else{
                Toast.makeText(this, "Please select an answer", Toast.LENGTH_LONG).show()
            }
        }
    }
}