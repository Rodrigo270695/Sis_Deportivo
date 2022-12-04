
package com.deportivo.model;

import java.io.InputStream;
import java.sql.Date;

public class Equipo {
    
    private int equipoId;
    private String nombreOficial;
    private String nombreCorto;
    private String seudonimo;
    private String codigoFifa;
    private Date fundacion;
    private String ubicacion;
    private int numSocios;
    private int numTitulosGandos;
    private int participacionesCopas;
    private int numFinalesJugadas;
    private CuerpoTecnico cuerpoTecnico;
    private Confederacion confederacion;
    private Pais pais;
    private InputStream foto;

    public int getEquipoId() {
        return equipoId;
    }

    public void setEquipoId(int equipoId) {
        this.equipoId = equipoId;
    }

    public String getNombreOficial() {
        return nombreOficial;
    }

    public void setNombreOficial(String nombreOficial) {
        this.nombreOficial = nombreOficial;
    }

    public String getNombreCorto() {
        return nombreCorto;
    }

    public void setNombreCorto(String nombreCorto) {
        this.nombreCorto = nombreCorto;
    }

    public String getSeudonimo() {
        return seudonimo;
    }

    public void setSeudonimo(String seudonimo) {
        this.seudonimo = seudonimo;
    }

    public String getCodigoFifa() {
        return codigoFifa;
    }

    public void setCodigoFifa(String codigoFifa) {
        this.codigoFifa = codigoFifa;
    }

    public Date getFundacion() {
        return fundacion;
    }

    public void setFundacion(Date fundacion) {
        this.fundacion = fundacion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getNumSocios() {
        return numSocios;
    }

    public void setNumSocios(int numSocios) {
        this.numSocios = numSocios;
    }

    public int getNumTitulosGandos() {
        return numTitulosGandos;
    }

    public void setNumTitulosGandos(int numTitulosGandos) {
        this.numTitulosGandos = numTitulosGandos;
    }

    public int getParticipacionesCopas() {
        return participacionesCopas;
    }

    public void setParticipacionesCopas(int participacionesCopas) {
        this.participacionesCopas = participacionesCopas;
    }

    public int getNumFinalesJugadas() {
        return numFinalesJugadas;
    }

    public void setNumFinalesJugadas(int numFinalesJugadas) {
        this.numFinalesJugadas = numFinalesJugadas;
    }

    public CuerpoTecnico getCuerpoTecnico() {
        return cuerpoTecnico;
    }

    public void setCuerpoTecnico(CuerpoTecnico cuerpoTecnico) {
        this.cuerpoTecnico = cuerpoTecnico;
    }

    public Confederacion getConfederacion() {
        return confederacion;
    }

    public void setConfederacion(Confederacion confederacion) {
        this.confederacion = confederacion;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public InputStream getFoto() {
        return foto;
    }

    public void setFoto(InputStream foto) {
        this.foto = foto;
    }
    

}
