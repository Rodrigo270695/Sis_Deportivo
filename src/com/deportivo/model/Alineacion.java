
package com.deportivo.model;

public class Alineacion {
    
    private Partido partido;
    private Equipo equipo;
    private Futbolista futbolista;
    private TipoJugador tipoJugador;
    private Posicion posicion;

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Futbolista getFutbolista() {
        return futbolista;
    }

    public void setFutbolista(Futbolista futbolista) {
        this.futbolista = futbolista;
    }

    public TipoJugador getTipoJugador() {
        return tipoJugador;
    }

    public void setTipoJugador(TipoJugador tipoJugador) {
        this.tipoJugador = tipoJugador;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }
    
}
