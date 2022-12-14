
package com.deportivo.model;

import java.sql.*;

public class Partido {
    
    private int partidoId;
    private Time hora;
    private Jornada jornada;
    private Estadio estadio;
    private EtapaFixture etapaFixture;
    private Competencia competencia;
    private TernaArbitral ternaArbitral;

    public int getPartidoId() {
        return partidoId;
    }

    public void setPartidoId(int partidoId) {
        this.partidoId = partidoId;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public Jornada getJornada() {
        return jornada;
    }

    public void setJornada(Jornada jornada) {
        this.jornada = jornada;
    }

    public Estadio getEstadio() {
        return estadio;
    }

    public void setEstadio(Estadio estadio) {
        this.estadio = estadio;
    }

    public EtapaFixture getEtapaFixture() {
        return etapaFixture;
    }

    public void setEtapaFixture(EtapaFixture etapaFixture) {
        this.etapaFixture = etapaFixture;
    }

    public Competencia getCompetencia() {
        return competencia;
    }

    public void setCompetencia(Competencia competencia) {
        this.competencia = competencia;
    }

    public TernaArbitral getTernaArbitral() {
        return ternaArbitral;
    }

    public void setTernaArbitral(TernaArbitral ternaArbitral) {
        this.ternaArbitral = ternaArbitral;
    }
    
}
