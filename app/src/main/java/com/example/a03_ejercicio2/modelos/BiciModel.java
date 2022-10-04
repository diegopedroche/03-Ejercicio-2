package com.example.a03_ejercicio2.modelos;

import java.io.Serializable;

public class BiciModel implements Serializable {
    private String marca;
    private float pulgadas;

    public BiciModel(String marca, float pulgadas) {
        this.marca = marca;
        this.pulgadas = pulgadas;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public float getPulgadas() {
        return pulgadas;
    }

    public void setPulgadas(float pulgadas) {
        this.pulgadas = pulgadas;
    }

    @Override
    public String toString() {
        return "Bici{" +
                "marca='" + marca + '\'' +
                ", pulgadas=" + pulgadas +
                '}';
    }
}
