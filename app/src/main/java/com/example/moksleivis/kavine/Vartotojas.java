package com.example.moksleivis.kavine;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Asus on 2017.04.09.
 */

public class Vartotojas {
    private String vardas;
    private String epastas;
    private String slaptazodis;


    private static final String PREFERENCES_FILE_NAME = "com.example.moksleivis.kavine";
    private static final String USERNAME_KEY = "username";
    private static final String PASSWORD_KEY = "password";
    private static final String REMEMBER_ME_KEY = "rememberMe";

    private SharedPreferences sharedPrefs;


    public Vartotojas(String vardas, String epastas, String slaptazodis) {
        this.vardas = vardas;
        this.epastas = epastas;
        this.slaptazodis = slaptazodis;
    }

    public Vartotojas (Context context) {
        this.sharedPrefs = context.getSharedPreferences(Vartotojas.PREFERENCES_FILE_NAME, Context.MODE_PRIVATE);
    }


    public String getVardas() {
        return this.sharedPrefs.getString(USERNAME_KEY, "");
    }

    public void setVardas(String vardas) {
        this.sharedPrefs.edit().putString(USERNAME_KEY, vardas).commit();
    }

    public String getEpastas() {
        return epastas;
    }

    public void setEpastas(String epastas) {
        this.epastas = epastas;
    }

    public String getSlaptazodis() {
        return this.sharedPrefs.getString(PASSWORD_KEY, "");
    }
    public void setSlaptazodis(String slaptazodis) {
        this.sharedPrefs.edit().putString(PASSWORD_KEY, slaptazodis).commit();
    }

    public boolean isRemembered() {
        return this.sharedPrefs.getBoolean(REMEMBER_ME_KEY, false);
    }

    public void setRemembered(boolean remembered) {
        this.sharedPrefs.edit().putBoolean(REMEMBER_ME_KEY, remembered).commit();
    }
}
