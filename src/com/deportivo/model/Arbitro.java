package com.deportivo.model;

public class Arbitro {

    private int arbitroId;
    private String nombreCompleto;
    private char estado;

    public int getArbitroId() {
        return arbitroId;
    }

    public void setArbitroId(int arbitroId) {
        this.arbitroId = arbitroId;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

}
