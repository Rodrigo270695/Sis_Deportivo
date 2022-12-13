
package com.deportivo.model;

import com.deportivo.model.Ciudad;
import com.deportivo.model.DimensionCampo;
import java.io.InputStream;
import java.sql.*;

public class Estadio {
    
    private int estadioId;
    private String nombreOficial;
    private String nombreConocido;
    private int capacidad;
    private String direccion;
    private Date fechaFundacion;
    private byte tribunas;
    private InputStream foto;
    private double costo;
    private String equipoPropietario;
    private DimensionCampo dimensionCampo;
    private Ciudad ciudad;

    public int getEstadioId() {
        return estadioId;
    }

    public void setEstadioId(int estadioId) {
        this.estadioId = estadioId;
    }

    public String getNombreOficial() {
        return nombreOficial;
    }

    public void setNombreOficial(String nombreOficial) {
        this.nombreOficial = nombreOficial;
    }

    public String getNombreConocido() {
        return nombreConocido;
    }

    public void setNombreConocido(String nombreConocido) {
        this.nombreConocido = nombreConocido;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaFundacion() {
        return fechaFundacion;
    }

    public void setFechaFundacion(Date fechaFundacion) {
        this.fechaFundacion = fechaFundacion;
    }

    public byte getTribunas() {
        return tribunas;
    }

    public void setTribunas(byte tribunas) {
        this.tribunas = tribunas;
    }

    public InputStream getFoto() {
        return foto;
    }

    public void setFoto(InputStream foto) {
        this.foto = foto;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getEquipoPropietario() {
        return equipoPropietario;
    }

    public void setEquipoPropietario(String equipoPropietario) {
        this.equipoPropietario = equipoPropietario;
    }

    public DimensionCampo getDimensionCampo() {
        return dimensionCampo;
    }

    public void setDimensionCampo(DimensionCampo dimensionCampo) {
        this.dimensionCampo = dimensionCampo;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }
    
}
