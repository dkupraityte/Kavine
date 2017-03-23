package com.example.moksleivis.kavine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void veikla(View v) {
        Intent intent = new Intent(MainActivity.this, LoggedActivity.class);
        startActivity(intent);

    }

    public void reg(View v) {
        Intent intent = new Intent(MainActivity.this, Signup.class);
        startActivity(intent);

    }
}
