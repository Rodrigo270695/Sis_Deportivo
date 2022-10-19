
package com.deportivo.controller;

import com.deportivo.interfac.CRUD;
import com.deportivo.model.Posicion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.postgresql.util.PSQLException;

public class PosicionController implements CRUD{
    
    Conexion estado = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    @Override
    public List listar(){
        
         List lista = new ArrayList();
        sql = "SELECT * FROM posicion ORDER BY posicion_id DESC";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Posicion posicion = new Posicion();
                posicion.setPosicionId(rs.getInt(1));
                posicion.setAbreviatura(rs.getString(2));
                posicion.setDescripcion(rs.getString(3));
                lista.add(posicion);
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
        
        Posicion posicion = (Posicion) obj;
        sql = "INSERT INTO posicion(abreviatura,descripcion) VALUES(?,?)";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, posicion.getAbreviatura());
            ps.setString(2, posicion.getDescripcion());
            ps.executeUpdate();

        } catch (PSQLException pe) {
            throw new Exception("Ya existe la posicion");
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
        
        Posicion posicion = (Posicion) obj;
        sql = "UPDATE posicion SET abreviatura=?,descripcion=? WHERE posicion_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, posicion.getAbreviatura());
            ps.setString(2, posicion.getDescripcion());
            ps.setInt(3, posicion.getPosicionId());
            ps.executeUpdate();

        } catch (PSQLException pe) {
            throw new Exception("Ya existe la posicion");
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
        
        sql = "DELETE FROM posicion WHERE posicion_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (PSQLException pe) {
            pe.printStackTrace(System.err);
            throw new Exception("El posicion no se puede eliminar, porque está siendo USADO");
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
        
        Posicion posicion = new Posicion();
        sql = "SELECT * FROM posicion WHERE posicion_id = "+id;

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                posicion.setPosicionId(rs.getInt(1));
                posicion.setAbreviatura(rs.getString(2));
                posicion.setDescripcion(rs.getString(3));
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

        return posicion;
        
    }

    @Override
    public List buscar(Object obj){
        
        List lista = new ArrayList();
        sql = "SELECT * FROM posicion WHERE descripcion LIKE '%"+obj+"%' ";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Posicion posicion = new Posicion();
                posicion.setPosicionId(rs.getInt(1));
                posicion.setAbreviatura(rs.getString(2));
                posicion.setDescripcion(rs.getString(3));
                lista.add(posicion);
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
