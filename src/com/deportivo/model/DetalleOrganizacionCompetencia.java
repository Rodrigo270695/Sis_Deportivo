package com.deportivo.model;

import java.util.List;

public class DetalleOrganizacionCompetencia {

    private Competencia competencia;
    private List<Pais> pais;

    public DetalleOrganizacionCompetencia() {
    }

    public DetalleOrganizacionCompetencia(Competencia competencia, List<Pais> pais) {

        this.competencia = competencia;
        this.pais = pais;
    }

    public Competencia getCompetencia() {
        return competencia;
    }

    public void setCompetencia(Competencia competencia) {
        this.competencia = competencia;
    }

    public List<Pais> getPais() {
        return pais;
    }

    public void setPais(List<Pais> pais) {
        this.pais = pais;
    }

}
