package eu.tutorials.quizapp

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.widget.ContentLoadingProgressBar
import org.w3c.dom.Text
import java.lang.reflect.Type

class QuestionsActivity : AppCompatActivity(), View.OnClickListener {
    private var progressBar : ContentLoadingProgressBar? = null
    private var progressBarTV : TextView? = null
    private var questionTV : TextView? = null
    private var questionImage : ImageView? = null
    private var btnCheck : Button? = null

    private var optionOneTV : TextView? = null
    private var optionTwoTV : TextView? = null
    private var optionThreeTV : TextView? = null
    private var optionFourTV : TextView? = null

    private var position : Int = 1
    private var selectedPosition : Int = 0 // Match with correctAnswer
    private var questionList : ArrayList<QuestionSettings>? = null

    private var countCorrectAnswer : Int = 0
    private var countIncorrectAnswer : Int = 0


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        progressBar = findViewById(R.id.ProgressBarId)
        progressBarTV = findViewById(R.id.ProgressBarTextId)
        questionTV = findViewById(R.id.QuestionText)
        questionImage = findViewById(R.id.QuestionImage)
        btnCheck = findViewById(R.id.check_btn)

        optionOneTV = findViewById(R.id.option_one_tv)
        optionTwoTV = findViewById(R.id.option_two_tv)
        optionThreeTV = findViewById(R.id.option_three_tv)
        optionFourTV = findViewById(R.id.option_four_tv)

        questionList = Questions.getQuestion()

        setQuestion()

        optionOneTV?.setOnClickListener(this)
        optionTwoTV?.setOnClickListener(this)
        optionThreeTV?.setOnClickListener(this)
        optionFourTV?.setOnClickListener(this)

        btnCheck?.setOnClickListener (this)
    }

    private fun defaultOptionColor() {
        val options = ArrayList<TextView>()
        optionOneTV?.let {
            options.add(0, it)
        }
        optionTwoTV?.let {
            options.add(1, it)
        }
        optionThreeTV?.let {
            options.add(2, it)
        }
        optionFourTV?.let {
            options.add(3, it)
        }

        for (option in options) {
            option.setTextColor(Color.parseColor("#000000"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.borderoptions
            )
        }
    }

    private fun selectedOptionView(compareTV : TextView, selectedOptionNum : Int) {
        defaultOptionColor()
        selectedPosition = selectedOptionNum
        compareTV.setTextColor(Color.parseColor("#900020"))
        compareTV.setTypeface(compareTV.typeface, Typeface.BOLD)
        compareTV.background = ContextCompat.getDrawable(
            this@QuestionsActivity,
            R.drawable.selected_option_border
        )
    }

    private fun setQuestion() {
        val question: QuestionSettings =
            questionList!![position - 1]
        defaultOptionColor()

        // Start
        if (position == questionList!!.size) {
            btnCheck?.text = "Finish"
        } else {
            btnCheck?.text = "Submit"
        }
        // End
        progressBar?.progress =
            position
        progressBarTV?.text =
            "${position}/${progressBar?.max}"

        questionTV?.text = question.question
        questionImage?.setImageResource(question.image)
        optionOneTV?.text = question.optionOne
        optionTwoTV?.text = question.optionTwo
        optionThreeTV?.text = question.optionThree
        optionFourTV?.text = question.optionFour
    }

    override fun onClick(view : View?) {
        when (view?.id) {
            R.id.option_one_tv -> {
                optionOneTV?.let {
                    selectedOptionView(it, 1)
                }
            }

            R.id.option_two_tv -> {
                optionTwoTV?.let {
                    selectedOptionView(it, 2)
                }
            }

            R.id.option_three_tv -> {
                optionThreeTV?.let {
                    selectedOptionView(it, 3)
                }
            }

            R.id.option_four_tv -> {
                optionFourTV?.let {
                    selectedOptionView(it, 4)
                }
            }

            R.id.check_btn -> {
                if (selectedPosition == 0) {
                    position++

                    when {
                        position <= questionList!!.size -> {
                            setQuestion()
                        }
                        else -> {
                            btnCheck?.setOnClickListener {
                                val intent = Intent(this, score::class.java)
                                intent.putExtra("true", "$countCorrectAnswer")
                                intent.putExtra("false", "$countIncorrectAnswer")
                                startActivity(intent)
                            }
                        }
                    }
                } else {
                    val question = questionList?.get(position - 1)

                    if (question!!.correctAnswer != selectedPosition) {
                        answerView(selectedPosition, R.drawable.false_option_border)
                        countIncorrectAnswer++
                    }

                    if (question!!.correctAnswer == selectedPosition) {
                        countCorrectAnswer++
                    }

                    answerView(question.correctAnswer, R.drawable.true_option_border)

                    if (position == questionList!!.size) {
                        btnCheck?.text = "Finish"

                    } else {
                        btnCheck?.text = "Next Question"
                    }

                    selectedPosition = 0
                }
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int) {
        when (answer) {

            1 -> {
                optionOneTV?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            2 -> {
                optionTwoTV?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            3 -> {
                optionThreeTV?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            4 -> {
                optionFourTV?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
        }
    }
}

