package com.example.moksleivis.kavine;

/**
 * Created by moksleivis on 2017-04-06.
 */

public class Patiekalas {
    private String pavadinimas;
    private String rusis;
    private int kiekis;
    private String garnyras;
    private String padazas;

    public Patiekalas(String pavadinimas, String rusis, int kiekis, String garnyras, String padazas) {
        this.pavadinimas = pavadinimas;
        this.rusis = rusis;
        this.kiekis = kiekis;
        this.garnyras = garnyras;
        this.padazas = padazas;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    public String getRusis() {
        return rusis;
    }

    public void setRusis(String rusis) {
        this.rusis = rusis;
    }

    public int getKiekis() {
        return kiekis;
    }

    public void setKiekis(int kiekis) {
        this.kiekis = kiekis;
    }

    public String getGarnyras() {
        return garnyras;
    }

    public void setGarnyras(String garnyras) {
        this.garnyras = garnyras;
    }

    public String getPadazas() {
        return padazas;
    }

    public void setPadazas(String padazas) {
        this.padazas = padazas;
    }
}
