package com.work.instrumentation.view;

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.work.instrumentation.R

class MainActivity : AppCompatActivity() {

    private lateinit var btnLogin: Button
    private lateinit var txtSignUpLink: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_signup_layout)

        initialization()
        setOnClickListener()

    }

    private fun initialization() {

        btnLogin = findViewById(R.id.btnLogin)
        txtSignUpLink = findViewById(R.id.txtSignUpLink)
    }

    private fun setOnClickListener() {

        btnLogin.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, LandingActivity::class.java)
            startActivity(intent)
        })

    }

}