package com.deportivo.controller;

import com.deportivo.interfac.CRUD;
import com.deportivo.model.TernaArbitral;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.postgresql.util.PSQLException;

public class TernaArbitralController implements CRUD {

    Conexion estado = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    @Override
    public List listar() {

        List lista = new ArrayList();
        sql = "SELECT * FROM terna_arbitral ORDER BY terna_arbitral_id DESC";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                TernaArbitral ternaArbitral = new TernaArbitral();
                ternaArbitral.setTerna_arbitral_id(rs.getInt(1));
                ternaArbitral.setNombre(rs.getString(2));

                lista.add(ternaArbitral);
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

        TernaArbitral ternaArbitral = (TernaArbitral) obj;
        sql = "INSERT INTO terna_arbitral(nombre) VALUES(?)";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, ternaArbitral.getNombre());
            ps.executeUpdate();

        } catch (PSQLException pe) {
            throw new Exception("Ya existe la terna arbitral");
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

        TernaArbitral ternaArbitral = (TernaArbitral) obj;
        sql = "UPDATE terna_arbitral SET nombre=?  WHERE terna_arbitral_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, ternaArbitral.getNombre());
            ps.setInt(2, ternaArbitral.getTerna_arbitral_id());
            ps.executeUpdate();

        } catch (PSQLException pe) {
            throw new Exception("Ya existe la terna arbitral");
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

        sql = "DELETE FROM terna_arbitral WHERE terna_arbitral_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (PSQLException pe) {
            pe.printStackTrace(System.err);
            throw new Exception("La terna arbitral no se puede eliminar, porque está siendo USADO");
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

        TernaArbitral ternaArbitral = new TernaArbitral();
        sql = "SELECT * FROM terna_arbitral WHERE terna_arbitral_id = " + id;

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                ternaArbitral.setTerna_arbitral_id(rs.getInt(1));
                ternaArbitral.setNombre(rs.getString(2));

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

        return ternaArbitral;
    }

    @Override
    public List buscar(Object obj) {

        List lista = new ArrayList();
        sql = "SELECT * FROM terna_arbitral WHERE nombre LIKE '%" + obj + "%'";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                TernaArbitral ternaArbitral = new TernaArbitral();
                ternaArbitral.setTerna_arbitral_id(rs.getInt(1));
                ternaArbitral.setNombre(rs.getString(2));
                lista.add(ternaArbitral);
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

        TernaArbitral ternaArbitral = new TernaArbitral();
        sql = "SELECT * FROM terna_arbitral WHERE nombre = '" + nombre + "'";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                ternaArbitral.setTerna_arbitral_id(rs.getInt(1));
                ternaArbitral.setNombre(rs.getString(2));

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

        return ternaArbitral;
    }

}
