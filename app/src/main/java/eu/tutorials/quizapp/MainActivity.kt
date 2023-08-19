package eu.tutorials.quizapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startBtn : Button = findViewById(R.id.main_start_btn)
        val nameEditText : EditText = findViewById(R.id.name_text)

        startBtn.setOnClickListener {
            if (nameEditText.text.isEmpty()) {
                nameEditText.setText("NameLess")
                Toast.makeText(this, "Your name is ${nameEditText.text}." , Toast.LENGTH_SHORT).show()
            }

            val intent = Intent(this, QuestionsActivity::class.java)
            startActivity(intent)
            finish()
        }

    }


}