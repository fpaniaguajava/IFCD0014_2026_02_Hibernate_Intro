package com.cursogetafe;

import jakarta.persistence.*;

@Entity
public class Ave {

    // Atributos
    @Id
    private String especie;
    private String color;
    private double envergadura; // en metros
    private boolean puedeVolar;

    public Ave() {
    }

    // Constructor
    public Ave(String especie, String color, double envergadura, boolean puedeVolar) {
        this.especie = especie;
        this.color = color;
        this.envergadura = envergadura;
        this.puedeVolar = puedeVolar;
    }

    // Getters y Setters
    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getEnvergadura() {
        return envergadura;
    }

    public void setEnvergadura(double envergadura) {
        this.envergadura = envergadura;
    }

    public boolean isPuedeVolar() {
        return puedeVolar;
    }

    public void setPuedeVolar(boolean puedeVolar) {
        this.puedeVolar = puedeVolar;
    }

    @Override
    public String toString() {
        return "Ave{" +
                "especie='" + especie + '\'' +
                ", color='" + color + '\'' +
                ", envergadura=" + envergadura +
                ", puedeVolar=" + puedeVolar +
                '}';
    }
}
