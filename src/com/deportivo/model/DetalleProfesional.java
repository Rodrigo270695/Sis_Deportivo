
package com.deportivo.model;

import java.util.List;


public class DetalleProfesional {
    
    private Profesional profesional;
    private List<TipoProfesional> tipoProfesional;

    public DetalleProfesional() {
    }

    public DetalleProfesional(Profesional profesional) {
        this.profesional = profesional;
    }
    
    public DetalleProfesional(Profesional profesional, List<TipoProfesional> tipoProfesional) {
        this.profesional = profesional;
        this.tipoProfesional = tipoProfesional;
    }


    public Profesional getProfesional() {
        return profesional;
    }

    public void setProfesional(Profesional profesional) {
        this.profesional = profesional;
    }

    public List<TipoProfesional> getTipoProfesional() {
        return tipoProfesional;
    }

    public void setTipoProfesional(List<TipoProfesional> tipoProfesional) {
        this.tipoProfesional = tipoProfesional;
    }
    
    
}
