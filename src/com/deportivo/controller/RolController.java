
package com.deportivo.controller;

import com.deportivo.interfac.CRUD;
import com.deportivo.model.Rol;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.postgresql.util.PSQLException;

public class RolController implements CRUD{
    
    Conexion estado = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    @Override
    public List listar() {
        
        List lista = new ArrayList();
        sql = "SELECT * FROM rol ORDER BY rol_id DESC";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Rol rol = new Rol();
                rol.setRolId(rs.getByte(1));
                rol.setNombre(rs.getString(2));
                lista.add(rol);
            }

        } catch (SQLException e) {
            e.printStackTrace(System.err);
        } finally {
            try {
                con.close();
                ps.close();
                rs.close();
            } catch (SQLException ex) {
                ex.printStackTrace(System.err);
            }
        }

        return lista;
        
    }

    @Override
    public void registrar(Object obj) throws Exception {
        
        Rol rol = (Rol) obj;
        sql = "INSERT INTO rol(nombre) VALUES(?)";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, rol.getNombre());
            ps.executeUpdate();

        } catch (PSQLException pe) {
            throw new Exception("Ya existe el rol");
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        } finally {
            try {
                con.close();
                ps.close();
            } catch (SQLException ex) {
                ex.printStackTrace(System.err);
            }
        }
        
    }

    @Override
    public void modificar(Object obj) throws Exception {
        
        Rol rol = (Rol) obj;
        sql = "UPDATE rol SET nombre=? WHERE rol_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, rol.getNombre());
            ps.setInt(2, rol.getRolId());
            ps.executeUpdate();

        } catch (PSQLException pe) {
            throw new Exception("Ya existe el rol");
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        } finally {
            try {
                con.close();
                ps.close();
            } catch (SQLException ex) {
                ex.printStackTrace(System.err);
            }
        }
        
    }

    @Override
    public void eliminar(int id) throws Exception {
        
        sql = "DELETE FROM rol WHERE rol_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (PSQLException pe) {
            pe.printStackTrace(System.err);
            throw new Exception("El rol no se puede eliminar, porque está siendo USADO");
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        } finally {
            try {
                con.close();
                ps.close();
            } catch (SQLException ex) {
                ex.printStackTrace(System.err);
            }
        }
        
    }

    @Override
    public Object obtenerdato(int id) {
        
        sql = "select * from rol where rol_id = "+id;
        
        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
               return new Rol(rs.getInt(1), rs.getString(2));
            }

        } catch (SQLException e) {
            e.printStackTrace(System.err);
        } finally {
            try {
                con.close();
                ps.close();
                rs.close();
            } catch (SQLException ex) {
                ex.printStackTrace(System.err);
            }
        }
        return new Rol();
    }

    @Override
    public List buscar(Object obj){
        
        List lista = new ArrayList();
        sql = " select * from rol where nombre like '%" + obj + "%'";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                Rol rol = new Rol();
                rol.setRolId(rs.getByte(1));
                rol.setNombre(rs.getString(2));
                lista.add(rol);
            }

        } catch (SQLException e) {
            e.printStackTrace(System.err);
        } finally {
            try {
                con.close();
                ps.close();
                rs.close();
            } catch (SQLException ex) {
                ex.printStackTrace(System.err);
            }
        }

        return lista;
        
    }
    
    public Object obtenerdato(String nombre) {
        
        sql = "select * from rol where nombre = '"+nombre+"'";
        
        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
               return new Rol(rs.getInt(1), rs.getString(2));
            }

        } catch (SQLException e) {
            e.printStackTrace(System.err);
        } finally {
            try {
                con.close();
                ps.close();
                rs.close();
            } catch (SQLException ex) {
                ex.printStackTrace(System.err);
            }
        }
        return new Rol();
    }
    
}
