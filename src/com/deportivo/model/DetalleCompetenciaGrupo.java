package com.deportivo.model;

import java.util.List;

public class DetalleCompetenciaGrupo {

    private Competencia competencia;
    private List<Grupo> tipoGrupo;

    public DetalleCompetenciaGrupo() {
    }

    public DetalleCompetenciaGrupo(Competencia competencia) {
        this.competencia = competencia;
    }

    public DetalleCompetenciaGrupo(Competencia competencia, List<Grupo> tipoGrupo) {
        this.competencia = competencia;
        this.tipoGrupo = tipoGrupo;
    }

    public Competencia getCompetencia() {
        return competencia;
    }

    public void setCompetencia(Competencia competencia) {
        this.competencia = competencia;
    }

    public List<Grupo> getTipoGrupo() {
        return tipoGrupo;
    }

    public void setTipoGrupo(List<Grupo> tipoGrupo) {
        this.tipoGrupo = tipoGrupo;
    }

}
