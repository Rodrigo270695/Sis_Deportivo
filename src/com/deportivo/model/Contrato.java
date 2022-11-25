
package com.deportivo.model;

import java.sql.Date;

public class Contrato {
    
    private int contratoId;
    private Date fechaInicio;
    private Date fechaFin;
    private double remuneracion;
    private String descripcion;
    private Futbolista futbolista;

    public int getContratoId() {
        return contratoId;
    }

    public void setContratoId(int contratoId) {
        this.contratoId = contratoId;
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

    public double getRemuneracion() {
        return remuneracion;
    }

    public void setRemuneracion(double remuneracion) {
        this.remuneracion = remuneracion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Futbolista getFutbolista() {
        return futbolista;
    }

    public void setFutbolista(Futbolista futbolista) {
        this.futbolista = futbolista;
    }

}
