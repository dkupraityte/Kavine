package com.example.moksleivis.kavine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.support.v7.widget.ViewStubCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private EditText mUsernameView;
    private EditText mPasswordView;

    private String username;
    private String password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUsernameView = (EditText) findViewById(R.id.usr);
        mPasswordView = (EditText) findViewById(R.id.psd);

        mUsernameView.setError(null);
        mPasswordView.setError(null);

        Button mygtPrisijungti = (Button) findViewById(R.id.btn);
        mygtPrisijungti.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View arg0) {
                  veikla();
              }
    });
    }

    public void veikla() {
        username = mUsernameView.getText().toString();
        password = mPasswordView.getText().toString();


        boolean cancel = false;
        View focusView = null;

        Toast.makeText(MainActivity.this, username + "" + password,
                Toast.LENGTH_SHORT).show();

        if (!isValid(username)) {
            mUsernameView.setError("Neteisingas prisijungimo vardas");
            focusView = mUsernameView;
            cancel = true;
        }
        if (!isValid(password)) {
            mPasswordView.setError("Neteisingas slaptažodis");
            focusView = mPasswordView;
            cancel = true;
        }

        if (cancel) {
            focusView.requestFocus();
        } else {
            Intent intent = new Intent(MainActivity.this, LoggedActivity.class);
            startActivity(intent);
        }
    }
    public void reg(View v) {
        Intent intent = new Intent(MainActivity.this, Signup.class);
        startActivity(intent);

    }

    private boolean isValid(String credentials){
        final String CREDENTIALS_PATTERN = "^([A-Za-z0-9]{3,15})+$";
        Pattern pattern = Pattern.compile(CREDENTIALS_PATTERN);

        Matcher matcher = pattern.matcher(credentials);
        return matcher.matches();
    }

}
