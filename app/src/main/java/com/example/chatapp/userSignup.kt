package com.example.chatapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class userSignup : AppCompatActivity() {

    private lateinit var user_email: EditText
    private lateinit var user_name: EditText
    private lateinit var user_password: EditText
    private lateinit var btn_signup: Button
    private lateinit var btn_registered: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_signup)
        //userSignup
        user_email=findViewById(R.id.user_email)
        user_name=findViewById(R.id.user_name)
        user_password=findViewById(R.id.user_password)

        //buttons
        btn_signup=findViewById(R.id.button_1)//signup
        btn_registered=findViewById(R.id.button_2)//login button reverts to login page


        btn_registered.setOnClickListener{
            val newIntent =Intent(this,userLogin::class.java)
            startActivity(newIntent)
        }



    }
}