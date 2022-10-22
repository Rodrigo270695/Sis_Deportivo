
package com.deportivo.controller;

import com.deportivo.interfac.CRUD;
import com.deportivo.model.TipoTerna;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.postgresql.util.PSQLException;

public class TipoTernaController implements CRUD{
    
    Conexion estado = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    @Override
    public List listar(){
        
         List lista = new ArrayList();
        sql = "SELECT * FROM tipo_terna ORDER BY tipo_terna_id DESC";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                TipoTerna tipoTerna = new TipoTerna();
                tipoTerna.setTipoTernaId(rs.getInt(1));
                tipoTerna.setNombre(rs.getString(2));
                tipoTerna.setSigla(rs.getString(3));
                lista.add(tipoTerna);
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
        
        TipoTerna tipoTerna = (TipoTerna) obj;
        sql = "INSERT INTO tipo_terna(tipo_terna_nombre, tipo_terna_sigla) VALUES(?,?)";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, tipoTerna.getNombre());
            ps.setString(2, tipoTerna.getSigla());
            ps.executeUpdate();

        } catch (PSQLException pe) {
           
            throw new Exception("Ya existe el TipoTerna");
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
        
        TipoTerna tipoTerna = (TipoTerna) obj;
        sql = "UPDATE tipo_terna SET tipo_terna_nombre=?, tipo_terna_sigla=? WHERE tipo_terna_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, tipoTerna.getNombre());
            ps.setString(2, tipoTerna.getSigla());
            ps.setInt(3, tipoTerna.getTipoTernaId());
            ps.executeUpdate();

        } catch (PSQLException pe) {
            throw new Exception("Ya existe el Tipo Terna");
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
        
        sql = "DELETE FROM tipo_terna WHERE tipo_terna_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (PSQLException pe) {
            pe.printStackTrace(System.err);
            throw new Exception("El tipo terna no se puede eliminar, porque está siendo USADO");
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
        
        TipoTerna tipoTerna = new TipoTerna();
        sql = "SELECT * FROM tipo_terna WHERE tipo_terna_id = "+id;

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                tipoTerna.setTipoTernaId(rs.getInt(1));
                tipoTerna.setNombre(rs.getString(2));
                tipoTerna.setSigla(rs.getString(3));
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

        return tipoTerna;
        
    }

    @Override
    public List buscar(Object obj){
        
        List lista = new ArrayList();
        sql = "SELECT * FROM tipo_terna WHERE tipo_terna_nombre LIKE '%"+obj+"%' ";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                TipoTerna tipoTerna = new TipoTerna();
                tipoTerna.setTipoTernaId(rs.getInt(1));
                tipoTerna.setNombre(rs.getString(2));
                tipoTerna.setSigla(rs.getString(3));
                lista.add(tipoTerna);
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
    
}
