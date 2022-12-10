
package com.deportivo.model;

public class Permiso {
    
    private int permisoId;
    private String descripcion;

    public Permiso() {
    }

    public Permiso(int permisoId) {
        this.permisoId = permisoId;
    }

    public Permiso(int permisoId, String descripcion) {
        this.permisoId = permisoId;
        this.descripcion = descripcion;
    }

    public int getPermisoId() {
        return permisoId;
    }

    public void setPermisoId(int permisoId) {
        this.permisoId = permisoId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
