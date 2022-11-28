package com.deportivo.controller;

import com.deportivo.interfac.CRUD;
import com.deportivo.model.TipoTernaArbitral;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import org.postgresql.util.PSQLException;

public class TipoTernaArbitralController implements CRUD {

    Conexion estado = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    @Override
    public List listar() {

        List lista = new ArrayList();
        sql = "SELECT * FROM tipo_terna_arbitral ORDER BY tipo_terna_arbitral_id DESC";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                TipoTernaArbitral tipoTernaArbitral = new TipoTernaArbitral();
                tipoTernaArbitral.setTipo_terna_arbitral_id(rs.getInt(1));
                tipoTernaArbitral.setDescripcion(rs.getString(2));
                lista.add(tipoTernaArbitral);
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

        TipoTernaArbitral tipoTernaArbitral = (TipoTernaArbitral) obj;
        sql = "INSERT INTO tipo_terna_arbitral(descripcion) VALUES(?)";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, tipoTernaArbitral.getDescripcion());
            ps.executeUpdate();

        } catch (PSQLException pe) {
            throw new Exception("Ya existe el Tipo de Terna Arbitral");
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

        TipoTernaArbitral tipoTernaArbitral = (TipoTernaArbitral) obj;
        sql = "UPDATE tipo_terna_arbitral SET descripcion=? WHERE tipo_terna_arbitral_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, tipoTernaArbitral.getDescripcion());
            ps.setInt(2, tipoTernaArbitral.getTipo_terna_arbitral_id());
            ps.executeUpdate();

        } catch (PSQLException pe) {
            throw new Exception("Ya existe el Tipo de Terna Arbitral");
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

        sql = "DELETE FROM tipo_terna_arbitral WHERE tipo_terna_arbitral_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (PSQLException pe) {
            pe.printStackTrace(System.err);
            throw new Exception("El Tipo de Terna Arbitral no se puede eliminar, porque está siendo USADO");
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

        TipoTernaArbitral tipoTernaArbitral = new TipoTernaArbitral();
        sql = "SELECT * FROM tipo_terna_arbitral WHERE tipo_terna_arbitral_id = " + id;

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                tipoTernaArbitral.setTipo_terna_arbitral_id(rs.getInt(1));
                tipoTernaArbitral.setDescripcion(rs.getString(2));

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

        return tipoTernaArbitral;
    }

    @Override
    public List buscar(Object obj) {

        List lista = new ArrayList();
        sql = "SELECT * FROM tipo_terna_arbitral WHERE descripcion LIKE '%" + obj + "%'";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                TipoTernaArbitral tipoTernaArbitral = new TipoTernaArbitral();
                tipoTernaArbitral.setTipo_terna_arbitral_id(rs.getInt(1));
                tipoTernaArbitral.setDescripcion(rs.getString(2));
                lista.add(tipoTernaArbitral);
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

        TipoTernaArbitral tipoTernaArbitral = new TipoTernaArbitral();
        sql = "SELECT * FROM tipo_terna_arbitral WHERE descripcion = '" + nombre + "'";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                tipoTernaArbitral.setTipo_terna_arbitral_id(rs.getInt(1));
                tipoTernaArbitral.setDescripcion(rs.getString(2));
              
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

        return tipoTernaArbitral;
    }

}
