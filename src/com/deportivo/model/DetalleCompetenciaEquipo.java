package com.deportivo.model;

import com.deportivo.model.Competencia;
import com.deportivo.model.Equipo;
import java.util.List;

public class DetalleCompetenciaEquipo {

    private Competencia competencia;
    private List<Equipo> equipo;

    public DetalleCompetenciaEquipo() {
    }

    public DetalleCompetenciaEquipo(Competencia competencia) {
        this.competencia = competencia;
    }

    public DetalleCompetenciaEquipo(Competencia competencia, List<Equipo> equipo) {
        this.competencia = competencia;
        this.equipo = equipo;
    }

    public Competencia getCompetencia() {
        return competencia;
    }

    public void setCompetencia(Competencia competencia) {
        this.competencia = competencia;
    }

    public List<Equipo> getEquipo() {
        return equipo;
    }

    public void setEquipo(List<Equipo> equipo) {
        this.equipo = equipo;
    }
    
    

}
