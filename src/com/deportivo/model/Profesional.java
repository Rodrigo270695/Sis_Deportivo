package com.deportivo.model;

import java.util.Date;

public class Profesional {

    private int profesional_id;
    private String nombre_completo;
    private Date fecha_nacimiento;
    private char estado;
    private String seudonimo;
    private Date fecha_debut;
    private String palmares;
    private String records;
    private Pais pais;

    public int getProfesional_id() {
        return profesional_id;
    }

    public void setProfesional_id(int profesional_id) {
        this.profesional_id = profesional_id;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public String getSeudonimo() {
        return seudonimo;
    }

    public void setSeudonimo(String seudonimo) {
        this.seudonimo = seudonimo;
    }

    public Date getFecha_debut() {
        return fecha_debut;
    }

    public void setFecha_debut(Date fecha_debut) {
        this.fecha_debut = fecha_debut;
    }

    public String getPalmares() {
        return palmares;
    }

    public void setPalmares(String palmares) {
        this.palmares = palmares;
    }

    public String getRecords() {
        return records;
    }

    public void setRecords(String records) {
        this.records = records;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    
    
    
    
}
