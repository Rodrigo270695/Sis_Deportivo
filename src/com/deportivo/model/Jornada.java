package com.deportivo.model;

import java.sql.Date;

public class Jornada {

    private int jornada_id;
    private String nombre_jornada;
    private String fecha_larga;
    private Date fecha_corta;

    public int getJornada_id() {
        return jornada_id;
    }

    public void setJornada_id(int jornada_id) {
        this.jornada_id = jornada_id;
    }

    public String getNombre_jornada() {
        return nombre_jornada;
    }

    public void setNombre_jornada(String nombre_jornada) {
        this.nombre_jornada = nombre_jornada;
    }

    public String getFecha_larga() {
        return fecha_larga;
    }

    public void setFecha_larga(String fecha_larga) {
        this.fecha_larga = fecha_larga;
    }

    public Date getFecha_corta() {
        return fecha_corta;
    }

    public void setFecha_corta(Date fecha_corta) {
        this.fecha_corta = fecha_corta;
    }

    
    
    
    
    

}
