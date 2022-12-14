
package com.deportivo.model;

public class DetallePartido {
    
    private Partido partido;
    private Equipo equipo;
    private String tipo;
    private byte goles;
    private String posesionBalon;
    private short faltas;
    private byte tarjetasAmarillas;
    private byte tarjtetasRojas;
    private short tiros;
    private short tirosPuerta;
    private short fueraLugar;
    private byte tirosEquina;
    private short pasesCompletos;
    private String cambios;
    private String datoCurioso;
    private String distanciaRecorrida;
    private short balonesRecuperados;
    private FormacionEquipo formacion;

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public byte getGoles() {
        return goles;
    }

    public void setGoles(byte goles) {
        this.goles = goles;
    }

    public String getPosesionBalon() {
        return posesionBalon;
    }

    public void setPosesionBalon(String posesionBalon) {
        this.posesionBalon = posesionBalon;
    }

    public short getFaltas() {
        return faltas;
    }

    public void setFaltas(short faltas) {
        this.faltas = faltas;
    }

    public byte getTarjetasAmarillas() {
        return tarjetasAmarillas;
    }

    public void setTarjetasAmarillas(byte tarjetasAmarillas) {
        this.tarjetasAmarillas = tarjetasAmarillas;
    }

    public byte getTarjtetasRojas() {
        return tarjtetasRojas;
    }

    public void setTarjtetasRojas(byte tarjtetasRojas) {
        this.tarjtetasRojas = tarjtetasRojas;
    }

    public short getTiros() {
        return tiros;
    }

    public void setTiros(short tiros) {
        this.tiros = tiros;
    }

    public short getTirosPuerta() {
        return tirosPuerta;
    }

    public void setTirosPuerta(short tirosPuerta) {
        this.tirosPuerta = tirosPuerta;
    }

    public short getFueraLugar() {
        return fueraLugar;
    }

    public void setFueraLugar(short fueraLugar) {
        this.fueraLugar = fueraLugar;
    }

    public byte getTirosEquina() {
        return tirosEquina;
    }

    public void setTirosEquina(byte tirosEquina) {
        this.tirosEquina = tirosEquina;
    }

    public short getPasesCompletos() {
        return pasesCompletos;
    }

    public void setPasesCompletos(short pasesCompletos) {
        this.pasesCompletos = pasesCompletos;
    }

    public String getCambios() {
        return cambios;
    }

    public void setCambios(String cambios) {
        this.cambios = cambios;
    }

    public String getDatoCurioso() {
        return datoCurioso;
    }

    public void setDatoCurioso(String datoCurioso) {
        this.datoCurioso = datoCurioso;
    }

    public String getDistanciaRecorrida() {
        return distanciaRecorrida;
    }

    public void setDistanciaRecorrida(String distanciaRecorrida) {
        this.distanciaRecorrida = distanciaRecorrida;
    }

    public short getBalonesRecuperados() {
        return balonesRecuperados;
    }

    public void setBalonesRecuperados(short balonesRecuperados) {
        this.balonesRecuperados = balonesRecuperados;
    }

    public FormacionEquipo getFormacion() {
        return formacion;
    }

    public void setFormacion(FormacionEquipo formacion) {
        this.formacion = formacion;
    }
    
    
}
