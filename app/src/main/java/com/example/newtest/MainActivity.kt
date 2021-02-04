package com.example.newtest

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.start)
        val text = findViewById<EditText>(R.id.nameText)

        btn.setOnClickListener() {
            if (text.text.toString().isEmpty())
                Toast.makeText(this, "Please input your name", Toast.LENGTH_SHORT).show()
            else {

                val intent = Intent(this, Questions2::class.java)

                val shared=getSharedPreferences("user", Context.MODE_PRIVATE);
                var editor = shared.edit()
                editor.putString("username",text.text.toString())
                editor.commit()

                //intent.putExtra(Constants.Name,text.text.toString())
                startActivity(intent)
                finish()
            }

        }
    }




}