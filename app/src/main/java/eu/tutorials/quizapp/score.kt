package eu.tutorials.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class score : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        val correct = findViewById<TextView>(R.id.correctId)
        val inCorrect = findViewById<TextView>(R.id.incorrectId)
        val btnTv = findViewById<TextView>(R.id.tryagainbtn)

        val countCorrect = intent.getStringExtra("true")
        val countIncorrect = intent.getStringExtra("false")

        correct.text = "Correct: ${countCorrect}"
        inCorrect.text = "Incorrect: ${countIncorrect}"

        btnTv.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finishAffinity()
        }
    }
}