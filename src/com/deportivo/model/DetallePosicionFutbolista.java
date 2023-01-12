package com.deportivo.model;

import java.util.List;

public class DetallePosicionFutbolista {

    private Futbolista futbolista;
    private List<Posicion> posicion;

    public DetallePosicionFutbolista() {
    }

    public DetallePosicionFutbolista(Futbolista futbolista) {
        this.futbolista = futbolista;
    }

    public DetallePosicionFutbolista(Futbolista futbolista, List<Posicion> posicion) {
        this.futbolista = futbolista;
        this.posicion = posicion;
    }

    public Futbolista getFutbolista() {
        return futbolista;
    }

    public void setFutbolista(Futbolista futbolista) {
        this.futbolista = futbolista;
    }

    public List<Posicion> getPosicion() {
        return posicion;
    }

    public void setPosicion(List<Posicion> posicion) {
        this.posicion = posicion;
    }

}
