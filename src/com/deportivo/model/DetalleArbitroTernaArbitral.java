
package com.deportivo.model;

import java.util.List;

public class DetalleArbitroTernaArbitral {
    
    private TernaArbitral ternaArbitral;
    private List<Arbitro> arbitro;
    private List<CategoriaArbitro> categoriaArbitro;
 
    public DetalleArbitroTernaArbitral() {

    }

    public DetalleArbitroTernaArbitral(List<Arbitro> arbi) {
        this.arbitro = arbi;
    }

    public DetalleArbitroTernaArbitral(TernaArbitral terna) {
        this.ternaArbitral = terna;
    }


    public DetalleArbitroTernaArbitral(List<Arbitro> arbitro, TernaArbitral ternaArbitral, List<CategoriaArbitro> categoriaArbitro) {

        this.arbitro = arbitro;
        this.ternaArbitral = ternaArbitral;
        this.categoriaArbitro = categoriaArbitro;

    }

    public TernaArbitral getTernaArbitral() {
        return ternaArbitral;
    }

    public void setTernaArbitral(TernaArbitral ternaArbitral) {
        this.ternaArbitral = ternaArbitral;
    }

    public List<Arbitro> getArbitro() {
        return arbitro;
    }

    public void setArbitro(List<Arbitro> arbitro) {
        this.arbitro = arbitro;
    }

    public List<CategoriaArbitro> getCategoriaArbitro() {
        return categoriaArbitro;
    }

    public void setCategoriaArbitro(List<CategoriaArbitro> categoriaArbitro) {
        this.categoriaArbitro = categoriaArbitro;
    }
    
}
