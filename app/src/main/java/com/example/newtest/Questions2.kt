package com.example.newtest

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

open class Questions2 : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOption: Int = 0
    private var mCorrectAnswer: Int = 0
    private var Answer: Int = 0
    private var mUserName: String? = null


    lateinit var option1: TextView
    lateinit var option2: TextView
    lateinit var option3: TextView
    lateinit var option4: TextView
    lateinit var tv_question: TextView
    lateinit var tvp: TextView
    lateinit var btn: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.testscreen)

        option1 = findViewById<TextView>(R.id.tv_ption1)
        option2 = findViewById<TextView>(R.id.tv_ption2)
        option3 = findViewById<TextView>(R.id.tv_ption3)
        option4 = findViewById<TextView>(R.id.tv_ption4)
        btn = findViewById<Button>(R.id.submitbtn)
        tv_question = findViewById<TextView>(R.id.tv_questionid)
        tvp = findViewById<TextView>(R.id.tv_progress)


        mUserName = intent.getStringExtra(Constants.Name)
        mQuestionList = Constants.getQuestions()


        setQuestion()

        option1.setOnClickListener(this)
        option2.setOnClickListener(this)
        option3.setOnClickListener(this)
        option4.setOnClickListener(this)
        btn.setOnClickListener(this)
    }

    private fun setQuestion() {
        val question = mQuestionList!![mCurrentPosition - 1]
        defaultOptions()
        val progress = findViewById<ProgressBar>(R.id.progressbar)
        if (mCurrentPosition == mQuestionList!!.size) {
            btn.text = "finish"
        } else {
            btn.text = "submit"
        }
        progress.progress = mCurrentPosition
        tvp.text = "${mCurrentPosition}" + "/" + progress.max
        tv_question.text = question!!.question
        option1.text = question.option1
        option2.text = question.option2
        option3.text = question.option3
        option4.text = question.option4
    }

    private fun defaultOptions() {
        val options = ArrayList<TextView>()
        options.add(0, option1)
        options.add(1, option2)
        options.add(2, option3)
        options.add(3, option4)
        for (option in options) {
            option.setTextColor(Color.parseColor("#000000"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.defaultbtn)
        }

    }

    override fun onClick(v: View?) {
        val btn = findViewById<Button>(R.id.submitbtn)
        when (v?.id) {
            R.id.tv_ption1 -> {

                selectedOptionView(option1, 1)
            }
            R.id.tv_ption2 -> {
                selectedOptionView(option2, 2)
            }
            R.id.tv_ption3 -> {
                selectedOptionView(option3, 3)
            }
            R.id.tv_ption4 -> {
                selectedOptionView(option4, 4)
            }
            R.id.submitbtn -> {
                if (mSelectedOption == 0) {
                    mCurrentPosition++

                    when {
                        mCurrentPosition <= mQuestionList!!.size -> {
                            setQuestion()
                        }
                        else -> {
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.Name, mUserName)
                            startActivity(intent)

                        }
                    }

                } else {
                    val question = mQuestionList?.get(mCurrentPosition - 1)
                    if (question!!.answer != mSelectedOption) {
                        mCorrectAnswer++
                        answerView(mSelectedOption, R.drawable.wronganswer)
                        Toast.makeText(this, "Wrong X", Toast.LENGTH_SHORT).show()
                    } else {


                        answerView(question!!.answer, R.drawable.correctanswer)
                        Toast.makeText(this, "Correct !", Toast.LENGTH_SHORT).show()
                    }
                    if (mCurrentPosition == mQuestionList!!.size) {
                        btn.text = "Finish"
                    } else {
                        btn.text = "Go to next question"

                    }
                    mSelectedOption = 0
                }
            }
        }
        Answer = (mQuestionList!!.size - mCorrectAnswer)
        val shared = getSharedPreferences("answer", Context.MODE_PRIVATE);
        var editor = shared.edit()
        editor.putInt("correctAnswer", Answer.toInt())
        editor.commit()

    }

    private fun answerView(answer: Int, drawableView: Int) {

        when (answer) {
            1 -> {
                option1.background = ContextCompat.getDrawable(this, drawableView)
            }
            2 -> {
                option2.background = ContextCompat.getDrawable(this, drawableView)
            }
            3 -> {
                option3.background = ContextCompat.getDrawable(this, drawableView)
            }
            4 -> {
                option4.background = ContextCompat.getDrawable(this, drawableView)
            }
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        defaultOptions()
        mSelectedOption = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this, R.drawable.selectedback)
    }
}

