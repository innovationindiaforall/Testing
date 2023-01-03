package com.example.bdd;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    Context mContext = LoginActivity.this;
    ProgressDialog progress;
    private Button submitBtn;
    public EditText etUserName, etPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUserName = findViewById(R.id.editTextTextPersonName);
        etPwd = findViewById(R.id.editTextNumberPassword);
        submitBtn = findViewById(R.id.button);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentObject = new Intent(LoginActivity.this, SecondActivity.class);
                startActivity(intentObject);
            }
        });
    }

}