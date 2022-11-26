package com.deportivo.model;

public class Arbitro {

    private int arbitro_id;
    private String arbitro_nombre;
    private char estado_arbitro;
    private Pais pais;

    public int getArbitro_id() {
        return arbitro_id;
    }

    public void setArbitro_id(int arbitro_id) {
        this.arbitro_id = arbitro_id;
    }

    public String getArbitro_nombre() {
        return arbitro_nombre;
    }

    public void setArbitro_nombre(String arbitro_nombre) {
        this.arbitro_nombre = arbitro_nombre;
    }

    public char getEstado_arbitro() {
        return estado_arbitro;
    }

    public void setEstado_arbitro(char estado_arbitro) {
        this.estado_arbitro = estado_arbitro;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
    

   

}
