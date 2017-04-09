package com.example.moksleivis.kavine;

/**
 * Created by Asus on 2017.04.09.
 */

public class Vartotojas {
    private String vardas;
    private String epastas;
    private String slaptazodis;

    public Vartotojas(String vardas, String epastas, String slaptazodis) {
        this.vardas = vardas;
        this.epastas = epastas;
        this.slaptazodis = slaptazodis;
    }

    public String getVardas() {
        return vardas;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    public String getEpastas() {
        return epastas;
    }

    public void setEpastas(String epastas) {
        this.epastas = epastas;
    }

    public String getSlaptazodis() {
        return slaptazodis;
    }

    public void setSlaptazodis(String slaptazodis) {
        this.slaptazodis = slaptazodis;
    }
}
