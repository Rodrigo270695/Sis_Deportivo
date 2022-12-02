
package com.deportivo.model;


public class CategoriaArbitro {
    
    private int categoria_arbitro_id;
    private String nombre;
    private String sigla;
    private TipoTernaArbitral tipoTA;

    public int getCategoria_arbitro_id() {
        return categoria_arbitro_id;
    }

    public void setCategoria_arbitro_id(int categoria_arbitro_id) {
        this.categoria_arbitro_id = categoria_arbitro_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public TipoTernaArbitral getTipoTA() {
        return tipoTA;
    }

    public void setTipoTA(TipoTernaArbitral tipoTA) {
        this.tipoTA = tipoTA;
    }
    
    
    
    
    
    
    
}
