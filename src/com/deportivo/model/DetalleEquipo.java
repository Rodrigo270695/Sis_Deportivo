package com.deportivo.model;

public class DetalleEquipo {

    private Equipo equipo_id;
    private Futbolista futbolista_id;
    private Posicion posicion_id;


    public Equipo getEquipo_id() {
        return equipo_id;
    }

    public void setEquipo_id(Equipo equipo_id) {
        this.equipo_id = equipo_id;
    }

    public Futbolista getFutbolista_id() {
        return futbolista_id;
    }

    public void setFutbolista_id(Futbolista futbolista_id) {
        this.futbolista_id = futbolista_id;
    }

    public Posicion getPosicion_id() {
        return posicion_id;
    }

    public void setPosicion_id(Posicion posicion_id) {
        this.posicion_id = posicion_id;
    }

}
