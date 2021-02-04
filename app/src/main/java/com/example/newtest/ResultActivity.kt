package com.example.newtest

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.util.jar.Attributes

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val shared=getSharedPreferences("user", Context.MODE_PRIVATE);
        val shared2=getSharedPreferences("answer", Context.MODE_PRIVATE);


        val userName = findViewById<TextView>(R.id.userNameLast)
        val correctAnswer = findViewById<TextView>(R.id.correctAnswer)

      //  val name = intent.getStringArrayExtra(Constants.Name)

        userName.text=shared.getString("username", "not found")
        correctAnswer.text= shared2.getInt("correctAnswer",0).toString()





        val btnFinish = findViewById<Button>(R.id.finishbtn)
        btnFinish.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}