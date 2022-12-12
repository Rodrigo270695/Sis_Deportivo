
package com.deportivo.model;

import java.sql.Date;

public class Competencia {
    
    private int competenciaId;
    private String nombre;
    private Date fechaInicio;
    private Date fechaFin;
    private Fixture fixture;

    public int getCompetenciaId() {
        return competenciaId;
    }

    public void setCompetenciaId(int competenciaId) {
        this.competenciaId = competenciaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Fixture getFixture() {
        return fixture;
    }

    public void setFixture(Fixture fixture) {
        this.fixture = fixture;
    }
    
}
