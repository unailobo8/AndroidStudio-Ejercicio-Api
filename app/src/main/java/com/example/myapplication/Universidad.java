package com.example.myapplication;

import android.os.Bundle;

public class Universidad {
    private String pais;
    private String pWeb;
    private String nombre;

    public Universidad(String pais, String pWeb, String nombre) {
        this.pais = pais;
        this.pWeb = pWeb;
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getpWeb() {
        return pWeb;
    }

    public void setpWeb(String pWeb) {
        this.pWeb = pWeb;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
