
package com.deportivo.model;

import java.util.List;

public class RolPermiso {
    
    private Rol rol;
    private List<Permiso> permisos;

    public RolPermiso() {
    }

    public RolPermiso(Rol rol, List<Permiso> permisos) {
        this.rol = rol;
        this.permisos = permisos;
    }

    public RolPermiso(Rol rol) {
        this.rol = rol;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public List<Permiso> getPermisos() {
        return permisos;
    }

    public void setPermisos(List<Permiso> permisos) {
        this.permisos = permisos;
    }
    
}
