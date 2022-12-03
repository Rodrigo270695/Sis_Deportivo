
package com.deportivo.model;

import java.util.List;


public class DetalleCategoriaArbitro {
    
    private Arbitro arbitro;
    private List<CategoriaArbitro> tipoCategoriaArbitro;

    public DetalleCategoriaArbitro() {
    }

    public DetalleCategoriaArbitro(Arbitro arbitro) {
        this.arbitro = arbitro;
    }
    
    public DetalleCategoriaArbitro(Arbitro arbitro, List<CategoriaArbitro> tipoCategoriaArbitro) {
        this.arbitro = arbitro;
        this.tipoCategoriaArbitro = tipoCategoriaArbitro;
    }

    public Arbitro getArbitro() {
        return arbitro;
    }

    public void setArbitro(Arbitro arbitro) {
        this.arbitro = arbitro;
    }

    public List<CategoriaArbitro> getTipoCategoriaArbitro() {
        return tipoCategoriaArbitro;
    }

    public void setTipoCategoriaArbitro(List<CategoriaArbitro> tipoCategoriaArbitro) {
        this.tipoCategoriaArbitro = tipoCategoriaArbitro;
    }



    
    
}
