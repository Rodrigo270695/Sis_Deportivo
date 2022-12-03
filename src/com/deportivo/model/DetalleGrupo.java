package com.deportivo.model;

import java.util.List;

public class DetalleGrupo {

    private Grupo grupo;
    private List<Equipo> equipo;
    private int partidos_jugados;
    private int partidos_ganados;
    private int partidos_empatados;
    private int partidos_perdidos;
    private int goles_favor;
    private int goles_contra;
    private int diferencia_goles;
    private int puntos;

    public DetalleGrupo() {

    }

    public DetalleGrupo(Grupo grupo) {
        this.grupo = grupo;

    }

    public DetalleGrupo(Grupo grupo, List<Equipo> equipo) {
        this.grupo = grupo;
        this.equipo = equipo;
    }

    public DetalleGrupo(Grupo grupo, List<Equipo> equipo, int partidos_jugados, int partidos_ganados, int partidos_empatados, int partidos_perdidos, int goles_favor,
            int goles_contra, int diferencia_goles, int puntos) {
        this.grupo = grupo;
        this.equipo = equipo;
        this.partidos_jugados = partidos_jugados;
        this.partidos_ganados = partidos_ganados;
        this.partidos_empatados = partidos_empatados;
        this.partidos_perdidos = partidos_perdidos;
        this.goles_favor = goles_favor;
        this.goles_contra = goles_contra;
        this.diferencia_goles = diferencia_goles;
        this.puntos = puntos;

    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public List<Equipo> getEquipo() {
        return equipo;
    }

    public void setEquipo(List<Equipo> equipo) {
        this.equipo = equipo;
    }

    public int getPartidos_jugados() {
        return partidos_jugados;
    }

    public void setPartidos_jugados(int partidos_jugados) {
        this.partidos_jugados = partidos_jugados;
    }

    public int getPartidos_ganados() {
        return partidos_ganados;
    }

    public void setPartidos_ganados(int partidos_ganados) {
        this.partidos_ganados = partidos_ganados;
    }

    public int getPartidos_empatados() {
        return partidos_empatados;
    }

    public void setPartidos_empatados(int partidos_empatados) {
        this.partidos_empatados = partidos_empatados;
    }

    public int getPartidos_perdidos() {
        return partidos_perdidos;
    }

    public void setPartidos_perdidos(int partidos_perdidos) {
        this.partidos_perdidos = partidos_perdidos;
    }

    public int getGoles_favor() {
        return goles_favor;
    }

    public void setGoles_favor(int goles_favor) {
        this.goles_favor = goles_favor;
    }

    public int getGoles_contra() {
        return goles_contra;
    }

    public void setGoles_contra(int goles_contra) {
        this.goles_contra = goles_contra;
    }

    public int getDiferencia_goles() {
        return diferencia_goles;
    }

    public void setDiferencia_goles(int diferencia_goles) {
        this.diferencia_goles = diferencia_goles;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

}
