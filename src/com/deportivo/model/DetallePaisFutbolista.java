package com.deportivo.model;

import java.util.List;

public class DetallePaisFutbolista {

    private Futbolista futbolista;
    private List<Pais> pais;

    public DetallePaisFutbolista() {

    }

    public DetallePaisFutbolista(Futbolista futbolista) {
        this.futbolista = futbolista;

    }

    public DetallePaisFutbolista(Futbolista futbolista, List<Pais> pais) {
        this.futbolista = futbolista;
        this.pais = pais;

    }

    public Futbolista getFutbolista() {
        return futbolista;
    }

    public void setFutbolista(Futbolista futbolista) {
        this.futbolista = futbolista;
    }

    public List<Pais> getPais() {
        return pais;
    }

    public void setPais(List<Pais> pais) {
        this.pais = pais;
    }

}
