package com.deportivo.model;

public class CuerpoTecnico {

    private int cuerpoTecnicoId;
    private String nombre;
    private Profesional profesional;
    private TipoProfesional tipoProfesional;

    public int getCuerpoTecnicoId() {
        return cuerpoTecnicoId;
    }

    public void setCuerpoTecnicoId(int cuerpoTecnicoId) {
        this.cuerpoTecnicoId = cuerpoTecnicoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Profesional getProfesional() {
        return profesional;
    }

    public void setProfesional(Profesional profesional) {
        this.profesional = profesional;
    }

    public TipoProfesional getTipoProfesional() {
        return tipoProfesional;
    }

    public void setTipoProfesional(TipoProfesional tipoProfesional) {
        this.tipoProfesional = tipoProfesional;
    }

}
