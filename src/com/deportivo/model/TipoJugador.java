
package com.deportivo.model;


public class TipoJugador {
    
    private int tipo_jugador_id;
    private String descripcion;
    private char sigla;

    public int getTipo_jugador_id() {
        return tipo_jugador_id;
    }

    public void setTipo_jugador_id(int tipo_jugador_id) {
        this.tipo_jugador_id = tipo_jugador_id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public char getSigla() {
        return sigla;
    }

    public void setSigla(char sigla) {
        this.sigla = sigla;
    }
    
    
}
