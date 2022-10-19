package com.deportivo.controller;

import com.deportivo.interfac.CRUD;
import com.deportivo.model.Grupo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.postgresql.util.PSQLException;

public class GrupoController  implements CRUD{

    Conexion estado = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    @Override
    public List listar() {

        List lista = new ArrayList();
        sql = "SELECT * FROM grupo ORDER BY grupo_id DESC";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Grupo grupo = new Grupo();
                grupo.setGrupoId(rs.getInt(1));
                grupo.setNombre(rs.getString(2));
                grupo.setAbreviatura(rs.getString(3));
                lista.add(grupo);
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

        Grupo grupo = (Grupo) obj;
        sql = "INSERT INTO grupo(nombre, abreviatura) VALUES(?,?)";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, grupo.getNombre());
            ps.setString(2, grupo.getAbreviatura());
            ps.executeUpdate();

        } catch (PSQLException pe) {
            throw new Exception("Ya existe el grupo");
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
        
        Grupo grupo = (Grupo) obj;
        sql = "UPDATE grupo SET nombre=?, abreviatura=? WHERE grupo_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, grupo.getNombre());
            ps.setString(2, grupo.getAbreviatura());
            ps.setInt(3, grupo.getGrupoId());
            ps.executeUpdate();

        } catch (PSQLException pe) {
            throw new Exception("Ya existe el grupo");
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
    public void eliminar(int id) throws Exception{
        
        sql = "DELETE FROM grupo WHERE grupo_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (PSQLException pe) {
            pe.printStackTrace(System.err);
            throw new Exception("El grupo no se puede eliminar, porque está siendo USADO");
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
        
        Grupo grupo = new Grupo();
        sql = "SELECT * FROM grupo WHERE grupo_id = "+id;

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                grupo.setGrupoId(rs.getInt(1));
                grupo.setNombre(rs.getString(2));
                grupo.setAbreviatura(rs.getString(3));
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

        return grupo;
    }

    @Override
    public List buscar(Object obj) {
        
        List lista = new ArrayList();
        sql = "SELECT * FROM grupo WHERE nombre LIKE '%"+obj+"%' "
                + "OR abreviatura LIKE '%"+obj+"%'";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Grupo grupo = new Grupo();
                grupo.setGrupoId(rs.getInt(1));
                grupo.setNombre(rs.getString(2));
                grupo.setAbreviatura(rs.getString(3));
                lista.add(grupo);
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
        
        Grupo grupo = new Grupo();
        sql = "SELECT * FROM grupo WHERE nombre = '"+nombre+"'";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                grupo.setGrupoId(rs.getInt(1));
                grupo.setNombre(rs.getString(2));
                grupo.setAbreviatura(rs.getString(3));
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

        return grupo;
    }

}
