package com.deportivo.model;

import java.util.List;

public class DetallePosicionFutbolista {

    private Futbolista futbolista;
    private List<Posicion> posicionFutbolista;

    public DetallePosicionFutbolista() {

    }

    public DetallePosicionFutbolista(Futbolista futbolista) {
        this.futbolista = futbolista;

    }

    public DetallePosicionFutbolista(Futbolista futbolista, List<Posicion> posicion) {

        this.futbolista = futbolista;
        this.posicionFutbolista = posicion;
    }

    public Futbolista getFutbolista() {
        return futbolista;
    }

    public void setFutbolista(Futbolista futbolista) {
        this.futbolista = futbolista;
    }

    public List<Posicion> getPosicionFutbolista() {
        return posicionFutbolista;
    }

    public void setPosicionFutbolista(List<Posicion> posicionFutbolista) {
        this.posicionFutbolista = posicionFutbolista;
    }

}
