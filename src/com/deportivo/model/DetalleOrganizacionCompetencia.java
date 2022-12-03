
package com.deportivo.model;

import java.util.List;


public class DetalleOrganizacionCompetencia {
    
    private Pais pais;
    private List<Competencia> tipoCompetencia;

    public DetalleOrganizacionCompetencia() {
    }

    public DetalleOrganizacionCompetencia(Pais pais) {
        this.pais = pais;
    }
    
    public DetalleOrganizacionCompetencia(Pais pais, List<Competencia> tipoCompetencia) {
        this.pais = pais;
        this.tipoCompetencia = tipoCompetencia;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public List<Competencia> getTipoCompetencia() {
        return tipoCompetencia;
    }

    public void setTipoCompetencia(List<Competencia> tipoCompetencia) {
        this.tipoCompetencia = tipoCompetencia;
    }

    

    
}
