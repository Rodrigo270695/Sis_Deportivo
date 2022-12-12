
package com.deportivo.controller;

import com.deportivo.interfac.CRUD;
import com.deportivo.model.TipoProfesional;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.postgresql.util.PSQLException;

public class TipoProfesionalController implements CRUD{
    
    Conexion estado = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    @Override
    public List listar(){
        
         List lista = new ArrayList();
        sql = "SELECT * FROM tipo_profesional ORDER BY tipo_profesional_id DESC";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                TipoProfesional tipoProfesional = new TipoProfesional();
                tipoProfesional.setTipoProfesionalId(rs.getInt(1));
                tipoProfesional.setNombre(rs.getString(2));
                tipoProfesional.setAbreviatura(rs.getString(3));
                lista.add(tipoProfesional);
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
        
        TipoProfesional tipoProfesional = (TipoProfesional) obj;
        sql = "INSERT INTO tipo_profesional(nombre,abreviatura) VALUES(?,?)";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, tipoProfesional.getNombre());
            ps.setString(2, tipoProfesional.getAbreviatura());
            ps.executeUpdate();

        } catch (PSQLException pe) {
            throw new Exception("Ya existe el tipo Profesional");
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
        
        TipoProfesional tipoProfesional = (TipoProfesional) obj;
        sql = "UPDATE tipo_profesional SET nombre=?,abreviatura=? WHERE tipo_profesional_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, tipoProfesional.getNombre());
            ps.setString(2, tipoProfesional.getAbreviatura());
            ps.setInt(3, tipoProfesional.getTipoProfesionalId());
            ps.executeUpdate();

        } catch (PSQLException pe) {
            throw new Exception("Ya existe el tipo Profesional");
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
        
        sql = "DELETE FROM tipo_profesional WHERE tipo_profesional_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (PSQLException pe) {
            pe.printStackTrace(System.err);
            throw new Exception("El tipoProfesional no se puede eliminar, porque está siendo USADO");
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
    public Object obtenerdato(int id)  {
        
        TipoProfesional tipoProfesional = new TipoProfesional();
        sql = "SELECT * FROM tipo_profesional WHERE tipo_profesional_id = "+id;

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                tipoProfesional.setTipoProfesionalId(rs.getInt(1));
                tipoProfesional.setNombre(rs.getString(2));
                tipoProfesional.setAbreviatura(rs.getString(3));
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

        return tipoProfesional;
        
    }

    @Override
    public List buscar(Object obj){
        
        List lista = new ArrayList();
        sql = "SELECT * FROM tipo_profesional WHERE nombre LIKE '%"+obj+"%' ";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                TipoProfesional tipoProfesional = new TipoProfesional();
                tipoProfesional.setTipoProfesionalId(rs.getInt(1));
                tipoProfesional.setNombre(rs.getString(2));
                tipoProfesional.setAbreviatura(rs.getString(3));
                lista.add(tipoProfesional);
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

        TipoProfesional tipoProfesional = new TipoProfesional();
        sql = "SELECT * FROM tipo_profesional WHERE nombre = '" + nombre + "'";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                tipoProfesional.setTipoProfesionalId(rs.getInt(1));
                tipoProfesional.setNombre(rs.getString(2));
                tipoProfesional.setAbreviatura(rs.getString(3));
              
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

        return tipoProfesional;
    }

    
}
