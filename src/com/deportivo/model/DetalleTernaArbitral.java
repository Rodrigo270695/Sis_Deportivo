package com.deportivo.model;

import java.util.List;

public class DetalleTernaArbitral {

    private TernaArbitral ternaArbitral;
    private List<TipoTernaArbitral> tipoTernaArbitral;

    public DetalleTernaArbitral() {
    }

    public DetalleTernaArbitral(TernaArbitral ternaArbitral) {
        this.ternaArbitral = ternaArbitral;
    }

    public DetalleTernaArbitral(TernaArbitral ternaArbitral, List<TipoTernaArbitral> tipoTernaArbitral) {
        this.ternaArbitral = ternaArbitral;
        this.tipoTernaArbitral = tipoTernaArbitral;
    }

    public TernaArbitral getTernaArbitral() {
        return ternaArbitral;
    }

    public void setTernaArbitral(TernaArbitral ternaArbitral) {
        this.ternaArbitral = ternaArbitral;
    }

    public List<TipoTernaArbitral> getTipoTernaArbitral() {
        return tipoTernaArbitral;
    }

    public void setTipoTernaArbitral(List<TipoTernaArbitral> tipoTernaArbitral) {
        this.tipoTernaArbitral = tipoTernaArbitral;
    }

}
