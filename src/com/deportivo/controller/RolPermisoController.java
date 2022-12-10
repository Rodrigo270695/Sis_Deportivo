package com.deportivo.controller;

import com.deportivo.model.RolPermiso;
import com.deportivo.model.Permiso;
import com.deportivo.model.Rol;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RolPermisoController {

    RolController rolC = new RolController();
    Conexion estado = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    public RolPermiso listar(String documento) {

        RolPermiso rolP = new RolPermiso();
        List lista = new ArrayList<>();
        sql = "select r.rol_id, r.nombre, pe.permiso_id, pe.descripcion from usuario us\n"
                + "inner join rol r on r.rol_id = us.rol_id\n"
                + "inner join rol_permiso dp on dp.rol_id = r.rol_id\n"
                + "inner join permiso pe on pe.permiso_id = dp.permiso_id\n"
                + "where us.documento_identidad = '"+documento+"'";
        
        try {
            
            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                rolP.setRol(new Rol(rs.getInt(1), rs.getString(2)));
                lista.add(new Permiso(rs.getInt(3),rs.getString(4)));
            }
            rolP.setPermisos(lista);
            
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }finally {
            try {
                if(con != null)con.close();
                if(ps != null)ps.close();
                if(rs != null)rs.close();
            } catch (SQLException e) {
                e.printStackTrace(System.err);
            }
        }
        
        return rolP;

    }
    
    public void RegistrarPermisos(int idRol, int idPermiso){
        
        sql = "INSERT INTO rol_permiso(rol_id,permiso_id) values(?,?)";
        
        try {
            
            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idRol);
            ps.setInt(2, idPermiso);
            ps.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }finally {
            try {
                if(con != null)con.close();
                if(ps != null)ps.close();
            } catch (SQLException e) {
                e.printStackTrace(System.err);
            }
        }
    }

    public void eliminarPermisos(int idRol){
        
        sql = "DELETE FROM rol_permiso WHERE rol_id = ?";
        
        try {
            
            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idRol);
            ps.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }finally {
            try {
                if(con != null)con.close();
                if(ps != null)ps.close();
            } catch (SQLException e) {
                e.printStackTrace(System.err);
            }
        }
    }
    
    public RolPermiso listar(int idRol) {

        RolPermiso rolP = new RolPermiso();
        List lista = new ArrayList<>();
        sql = "SELECT * FROM rol_permiso WHERE rol_id = "+idRol;
        
        try {
            
            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                rolP.setRol((Rol) rolC.obtenerdato(rs.getInt(1)));
                lista.add(new Permiso(rs.getInt(2)));
            }
            rolP.setPermisos(lista);
            
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }finally {
            try {
                if(con != null)con.close();
                if(ps != null)ps.close();
                if(rs != null)rs.close();
            } catch (SQLException e) {
                e.printStackTrace(System.err);
            }
        }
        
        return rolP;

    }

}
