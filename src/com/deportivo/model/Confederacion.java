
package com.deportivo.model;

import java.util.Date;


public class Confederacion {
    
    private int confederacion_id;
    private String nombre_oficial;
    private String acronimo;
    private String ubicaicon;
    private String sede;
    private Date fecha_fundacion;
    private int numero_federaciones_afiliadas;

    public int getConfederacion_id() {
        return confederacion_id;
    }

    public void setConfederacion_id(int confederacion_id) {
        this.confederacion_id = confederacion_id;
    }

    public String getNombre_oficial() {
        return nombre_oficial;
    }

    public void setNombre_oficial(String nombre_oficial) {
        this.nombre_oficial = nombre_oficial;
    }

    public String getAcronimo() {
        return acronimo;
    }

    public void setAcronimo(String acronimo) {
        this.acronimo = acronimo;
    }

    public String getUbicaicon() {
        return ubicaicon;
    }

    public void setUbicaicon(String ubicaicon) {
        this.ubicaicon = ubicaicon;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public Date getFecha_fundacion() {
        return fecha_fundacion;
    }

    public void setFecha_fundacion(Date fecha_fundacion) {
        this.fecha_fundacion = fecha_fundacion;
    }

    public int getNumero_federaciones_afiliadas() {
        return numero_federaciones_afiliadas;
    }

    public void setNumero_federaciones_afiliadas(int numero_federaciones_afiliadas) {
        this.numero_federaciones_afiliadas = numero_federaciones_afiliadas;
    }
    
    
    
}
