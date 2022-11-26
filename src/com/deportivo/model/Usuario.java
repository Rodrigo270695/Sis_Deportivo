
package com.deportivo.model;

import java.sql.*;

public class Usuario {
    
    private int usuarioId;
    private Rol rolId;
    private String nombre;
    private String documento;
    private String password;
    private Date fechaCreacion;

    public Usuario() {
    }

    public Usuario(int usuarioId, Rol rolId, String nombre, String documento, String password, Date fechaCreacion) {
        this.usuarioId = usuarioId;
        this.rolId = rolId;
        this.nombre = nombre;
        this.documento = documento;
        this.password = password;
        this.fechaCreacion = fechaCreacion;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Rol getRolId() {
        return rolId;
    }

    public void setRolId(Rol rolId) {
        this.rolId = rolId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    
}
