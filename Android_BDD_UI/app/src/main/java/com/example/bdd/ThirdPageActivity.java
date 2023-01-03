package com.example.bdd;

import android.content.Context;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ThirdPageActivity extends AppCompatActivity {

    Context mContext = ThirdPageActivity.this;
    WebView webview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Toast.makeText(mContext, "Hi Hello All", Toast.LENGTH_SHORT).show();

        webview = findViewById(R.id.webview1);

        //webview.loadUrl("https://www.google.com"); //Sign in - button
          webview.loadUrl("https://login.salesforce.com/?locale=eu"); // working fine
        //webview.loadUrl("https://test.salesforce.com/");
        //https://stackoverflow.com/questions/29144310/match-a-view-in-webview-from-espresso-in-android
    }

}