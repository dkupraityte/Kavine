package com.example.moksleivis.kavine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LoggedActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged);
    }
    public void irasas (View v){
        Intent intent = new Intent (LoggedActivity.this, NewPost.class);
        startActivity(intent);

    }

    public void paieska (View v){
        Intent intent = new Intent (LoggedActivity.this, Search.class);
        startActivity(intent);

    }
}
