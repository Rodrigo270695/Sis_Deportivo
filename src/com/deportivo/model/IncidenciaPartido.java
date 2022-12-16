
package com.deportivo.model;

public class IncidenciaPartido {
    
    private Evento evento;
    private Partido partido;
    private Futbolista futbolista;
    private InstanciaPartido instanciaPartido;
    private byte minuto;
    private Equipo equipo;
    private String detalle;

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public Futbolista getFutbolista() {
        return futbolista;
    }

    public void setFutbolista(Futbolista futbolista) {
        this.futbolista = futbolista;
    }

    public InstanciaPartido getInstanciaPartido() {
        return instanciaPartido;
    }

    public void setInstanciaPartido(InstanciaPartido instanciaPartido) {
        this.instanciaPartido = instanciaPartido;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public byte getMinuto() {
        return minuto;
    }

    public void setMinuto(byte minuto) {
        this.minuto = minuto;
    }
    
    
}
