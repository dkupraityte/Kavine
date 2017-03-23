package com.example.moksleivis.kavine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }

    public void reg1 (View v){
        Intent intent = new Intent (Signup.this, MainActivity.class);
        startActivity(intent);
    }
}
