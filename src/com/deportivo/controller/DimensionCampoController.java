package com.deportivo.controller;

import com.deportivo.interfac.CRUD;
import com.deportivo.model.DimensionCampo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import org.postgresql.util.PSQLException;

public class DimensionCampoController implements CRUD {

    Conexion estado = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    @Override
    public List listar() {

        List lista = new ArrayList();
        sql = "SELECT * FROM dimension_campo ORDER BY dimension_id DESC";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                DimensionCampo dimension = new DimensionCampo();
                dimension.setDimension_id(rs.getInt(1));
                dimension.setDescripcion(rs.getString(2));
                lista.add(dimension);
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

        DimensionCampo dimension = (DimensionCampo) obj;
        sql = "INSERT INTO dimension_campo(descripcion) VALUES(?)";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, dimension.getDescripcion());
            ps.executeUpdate();

        } catch (PSQLException pe) {
            throw new Exception("Ya existe la dimension campo");
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

        DimensionCampo dimension = (DimensionCampo) obj;
        sql = "UPDATE dimension_campo SET descripcion=? WHERE dimension_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, dimension.getDescripcion());
            ps.setInt(2, dimension.getDimension_id());
            ps.executeUpdate();

        } catch (PSQLException pe) {
            throw new Exception("Ya existe la dimension");
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

        sql = "DELETE FROM dimension_campo WHERE dimension_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (PSQLException pe) {
            pe.printStackTrace(System.err);
            throw new Exception("La dimensión campo no se puede eliminar, porque está siendo USADO");
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

        DimensionCampo dimension = new DimensionCampo();
        sql = "SELECT * FROM dimension_campo WHERE dimension_id = " + id;

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                dimension.setDimension_id(rs.getByte(1));
                dimension.setDescripcion(rs.getString(2));
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

        return dimension;
    }
    
     @Override
    public List buscar(Object obj) {
        
        List lista = new ArrayList();
        sql = "SELECT * FROM dimension_campo WHERE descripcion LIKE '%"+obj+"%' ";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                DimensionCampo dimension = new DimensionCampo();
                dimension.setDimension_id(rs.getByte(1));
                dimension.setDescripcion(rs.getString(2));
                lista.add(dimension);
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
        
        DimensionCampo dimension = new DimensionCampo();
        sql = "SELECT * FROM dimension_campo WHERE descripcion = '"+nombre+"'";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                dimension.setDimension_id(rs.getByte(1));
                dimension.setDescripcion(rs.getString(2));
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

        return dimension;
    }

}
