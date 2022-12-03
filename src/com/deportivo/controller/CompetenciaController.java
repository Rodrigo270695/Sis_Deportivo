
package com.deportivo.controller;

import com.deportivo.interfac.CRUD;
import com.deportivo.model.Competencia;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.postgresql.util.PSQLException;

public class CompetenciaController implements CRUD{
    
    Conexion estado = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    @Override
    public List listar(){
        
         List lista = new ArrayList();
        sql = "SELECT * FROM competencia ORDER BY competencia_id DESC";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Competencia competencia = new Competencia();
                competencia.setCompetenciaId(rs.getInt(1));
                competencia.setNombre(rs.getString(2));
                competencia.setFechaInicio(rs.getDate(3));
                competencia.setFechaFin(rs.getDate(4));
                lista.add(competencia);
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
        
        Competencia competencia = (Competencia) obj;
        sql = "INSERT INTO competencia(nombre,fecha_inicio,fecha_fin) VALUES(?,?,?)";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, competencia.getNombre());
            ps.setDate(2, competencia.getFechaInicio());
            ps.setDate(3, competencia.getFechaFin());
            ps.executeUpdate();

        } catch (PSQLException pe) {
           
            throw new Exception("Ya existe la competencia");
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
        
        Competencia competencia = (Competencia) obj;
        sql = "UPDATE competencia SET nombre=?,fecha_inicio=?,fecha_fin=? WHERE competencia_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, competencia.getNombre());
            ps.setDate(2, competencia.getFechaInicio());
            ps.setDate(3, competencia.getFechaFin());
            ps.setInt(4, competencia.getCompetenciaId());
            ps.executeUpdate();

        } catch (PSQLException pe) {
            throw new Exception("Ya existe la competencia");
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
        
        sql = "DELETE FROM competencia WHERE competencia_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (PSQLException pe) {
            pe.printStackTrace(System.err);
            throw new Exception("El competencia no se puede eliminar, porque está siendo USADO");
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
        
        Competencia competencia = new Competencia();
        sql = "SELECT * FROM competencia WHERE competencia_id = "+id;

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                competencia.setCompetenciaId(rs.getInt(1));
                competencia.setNombre(rs.getString(2));
                competencia.setFechaInicio(rs.getDate(3));
                competencia.setFechaFin(rs.getDate(4));
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

        return competencia;
        
    }

    @Override
    public List buscar(Object obj){
        
        List lista = new ArrayList();
        sql = "SELECT * FROM competencia WHERE nombre LIKE '%"+obj+"%' ";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Competencia competencia = new Competencia();
                competencia.setCompetenciaId(rs.getInt(1));
                competencia.setNombre(rs.getString(2));
                competencia.setFechaInicio(rs.getDate(3));
                competencia.setFechaFin(rs.getDate(4));
                lista.add(competencia);
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
        
  
        Competencia competencia = new Competencia();
        sql = "SELECT * FROM competencia WHERE nombre = '" + nombre + "'";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                competencia.setCompetenciaId(rs.getInt(1));
                competencia.setNombre(rs.getString(2));
                competencia.setFechaInicio(rs.getDate(3));
                competencia.setFechaFin(rs.getDate(4));
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

        return competencia;
        

    }
    
    
    
    
    
    
    
}
