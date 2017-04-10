package com.example.moksleivis.kavine;

import android.content.Intent;
import android.content.pm.Signature;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Signup extends AppCompatActivity {

    Button registr1;
    private EditText regUsername;
    private EditText regPassword;
    private EditText regEmail;


    //jj
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        reg1();
    }

    public void reg1() {

        registr1 = (Button) findViewById(R.id.regbtn);
        regUsername = (EditText) findViewById(R.id.regusr);
        regPassword = (EditText) findViewById(R.id.regpass);
        regEmail = (EditText) findViewById(R.id.regmail);

        regUsername.setError(null);
        regPassword.setError(null);
        regEmail.setError(null);

        registr1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

        String username = regUsername.getText().toString();
        String password = regPassword.getText().toString();
        String email = regEmail.getText().toString();


        boolean cancel = false;
        View focusView = null;

        /*Toast.makeText(Signup.this, username + "" + password + "" + email,
                Toast.LENGTH_SHORT).show();*/

        if (!isValid(username)) {
            regUsername.setError("Neteisingai įvestas vardas");
            focusView = regUsername;
            cancel = true;
        }
        if (!isValid(password)) {
            regPassword.setError("Neteisingas slaptažodis");
            focusView = regPassword;
            cancel = true;
        }
        if (!isEmailValid(email)) {
            regEmail.setError("Neteisingai įvestas e-paštas");
            focusView = regEmail;
            cancel = true;
        }

        if (cancel) {
            focusView.requestFocus();
        } else {
            Intent intent = new Intent(Signup.this, MainActivity.class);
            Signup.this.startActivity(intent);

            Vartotojas user = new Vartotojas(username, email, password);

            Toast.makeText(Signup.this,
                    user.getVardas() + "\n" +
                    user.getSlaptazodis() + "\n" +
                    user.getEpastas() + "\n", Toast.LENGTH_LONG).show();
        }
            }

        });
    }

    private boolean isValid(String credentials){
        final String CREDENTIALS_PATTERN = "^([A-Za-z0-9]{3,15})+$";
        Pattern pattern = Pattern.compile(CREDENTIALS_PATTERN);

        Matcher matcher = pattern.matcher(credentials);
        return matcher.matches();
    }
    public boolean isEmailValid(String email) {
        String regExpn =
                "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                        +"((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        +"[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                        +"([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        +"[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                        +"([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";

        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(regExpn,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);

        if(matcher.matches())
            return true;
        else
            return false;
    }

}










