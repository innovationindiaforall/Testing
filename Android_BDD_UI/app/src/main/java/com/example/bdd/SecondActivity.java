package com.example.bdd;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    Context mContext = SecondActivity.this;
    ProgressDialog progress;
    TextView txtview_SecondBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Showprogress();

        SystemClock.sleep(1000);

        //hideprogress();

        txtview_SecondBtn = findViewById(R.id.txtview_SecondBtn);

        txtview_SecondBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentObject = new Intent(SecondActivity.this, ThirdPageActivity.class);
                startActivity(intentObject);
            }
        });
    }

    private void hideprogress() {

        if (progress != null) {
            if (progress.isShowing()) {
                progress.dismiss();
            }
        }
    }

    void Showprogress() {
        progress = CustomProgressDialog.pd(mContext);
        progress.show();
    }

}