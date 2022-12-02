package com.deportivo.controller;

import com.deportivo.interfac.CRUD;
import com.deportivo.model.Jornada;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import org.postgresql.util.PSQLException;

public class JornadaController implements CRUD {

    Conexion estado = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    @Override
    public List listar() {

        List lista = new ArrayList();
        sql = "SELECT * FROM jornada ORDER BY jornada_id DESC";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Jornada jornada = new Jornada();
                jornada.setJornada_id(rs.getInt(1));
                jornada.setNombre_jornada(rs.getString(2));
                jornada.setFecha_larga(rs.getString(3));
                jornada.setFecha_corta(rs.getDate(4));
                lista.add(jornada);
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

        Jornada jornada = (Jornada) obj;
        sql = "INSERT INTO jornada(nombre_jornada, fecha_larga,fecha_corta) VALUES(?,?,?)";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, jornada.getNombre_jornada());
            ps.setString(2, jornada.getFecha_larga());
            ps.setDate(3, jornada.getFecha_corta());
            ps.executeUpdate();

        } catch (PSQLException pe) {
            throw new Exception("Ya existe la jornada");
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

        Jornada jornada = (Jornada) obj;
        sql = "UPDATE jornada SET nombre_jornada=?, fecha_larga=?, fecha_corta=? WHERE jornada_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, jornada.getNombre_jornada());
            ps.setString(2, jornada.getFecha_larga());
            ps.setDate(3, jornada.getFecha_corta());
            ps.setInt(4, jornada.getJornada_id());
            ps.executeUpdate();

        } catch (PSQLException pe) {
            throw new Exception("Ya existe la jornada");
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

        sql = "DELETE FROM jornada WHERE jornada_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (PSQLException pe) {
            pe.printStackTrace(System.err);
            throw new Exception("El jornada no se puede eliminar, porque está siendo USADO");
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

        Jornada jornada = new Jornada();
        sql = "SELECT * FROM jornada WHERE jornada_id = " + id;

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                jornada.setJornada_id(rs.getInt(1));
                jornada.setNombre_jornada(rs.getString(2));
                jornada.setFecha_larga(rs.getString(3));
                jornada.setFecha_corta(rs.getDate(4));
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

        return jornada;
    }

    @Override
    public List buscar(Object obj) {

        List lista = new ArrayList();
        sql = "SELECT * FROM jornada WHERE nombre_jornada LIKE '%" + obj + "%' ";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Jornada jornada = new Jornada();
                jornada.setJornada_id(rs.getInt(1));
                jornada.setNombre_jornada(rs.getString(2));
                jornada.setFecha_larga(rs.getString(3));
                jornada.setFecha_corta(rs.getDate(4));
                lista.add(jornada);
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

        Jornada jornada = new Jornada();
        sql = "SELECT * FROM jornada WHERE nombre_jornada = '" + nombre + "'";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                jornada.setJornada_id(rs.getInt(1));
                jornada.setNombre_jornada(rs.getString(2));
                jornada.setFecha_larga(rs.getString(3));
                jornada.setFecha_corta(rs.getDate(4));
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

        return jornada;
    }

}
