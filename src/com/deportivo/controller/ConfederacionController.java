package com.deportivo.controller;

import com.deportivo.interfac.CRUD;
import com.deportivo.model.Confederacion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.postgresql.util.PSQLException;

public class ConfederacionController implements CRUD {

    Conexion estado = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    @Override
    public List listar() {

        List lista = new ArrayList();
        sql = "SELECT * FROM confederacion_futbol ORDER BY confederacion_id DESC";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Confederacion confederacion = new Confederacion();
                confederacion.setConfederacion_id(rs.getInt(1));
                confederacion.setNombre_oficial(rs.getString(2));
                confederacion.setAcronimo(rs.getString(3));
//                confederacion.setUbicaicon(rs.getString(4));
//                confederacion.setSede(rs.getString(5));
//                confederacion.setNumero_federaciones_afiliadas(rs.getInt(6));
                lista.add(confederacion);
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

        Confederacion confederacion = (Confederacion) obj;
        sql = "INSERT INTO confederacion_futbol(nombre_oficial, acronimo,ubicacion,sede,fecha_fundacion,numero_federaciones_afiliadas) VALUES(?,?,?,?,?,?)";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, confederacion.getNombre_oficial());
            ps.setString(2, confederacion.getAcronimo());
            ps.setString(3, confederacion.getUbicaicon());
            ps.setString(4, confederacion.getSede());
            ps.setDate(5, (Date) confederacion.getFecha_fundacion());
            ps.setInt(6, confederacion.getNumero_federaciones_afiliadas());
            ps.executeUpdate();

        } catch (PSQLException pe) {
            throw new Exception("Ya existe la confederacion");
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

        Confederacion confederacion = (Confederacion) obj;
        sql = "UPDATE confederacion_futbol SET nombre_oficial=?, acronimo=? ,ubicacion=?,sede=?,fecha_fundacion=?,numero_federaciones_afiliadas=? WHERE confederacion_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, confederacion.getNombre_oficial());
            ps.setString(2, confederacion.getAcronimo());
            ps.setString(3, confederacion.getUbicaicon());
            ps.setString(4, confederacion.getSede());
            ps.setDate(5, (Date) confederacion.getFecha_fundacion());
            ps.setInt(6, confederacion.getNumero_federaciones_afiliadas());
            ps.setInt(7, confederacion.getConfederacion_id());
            ps.executeUpdate();

        } catch (PSQLException pe) {
            throw new Exception("Ya existe la confederacion");
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

        sql = "DELETE FROM confederacion_futbol WHERE confederacion_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (PSQLException pe) {
            pe.printStackTrace(System.err);
            throw new Exception("La confederacion no se puede eliminar, porque está siendo USADO");
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

        Confederacion confederacion = new Confederacion();
        sql = "SELECT * FROM confederacion_futbol WHERE confederacion_id = " + id;

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                confederacion.setConfederacion_id(rs.getInt(1));
                confederacion.setNombre_oficial(rs.getString(2));
                confederacion.setAcronimo(rs.getString(3));
                confederacion.setUbicaicon(rs.getString(4));
                confederacion.setSede(rs.getString(5));
                confederacion.setFecha_fundacion(rs.getDate(6));
                confederacion.setNumero_federaciones_afiliadas(rs.getInt(7));
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

        return confederacion;
    }

    @Override
    public List buscar(Object obj) {

        List lista = new ArrayList();
        sql = "SELECT * FROM confederacion_futbol WHERE nombre_oficial LIKE '%" + obj + "%' "
                + "OR acronimo LIKE '%" + obj + "%'";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Confederacion confederacion = new Confederacion();
                confederacion.setConfederacion_id(rs.getInt(1));
                confederacion.setNombre_oficial(rs.getString(2));
                confederacion.setAcronimo(rs.getString(3));
                confederacion.setUbicaicon(rs.getString(4));
                confederacion.setSede(rs.getString(5));
                confederacion.setFecha_fundacion(rs.getDate(6));
                confederacion.setNumero_federaciones_afiliadas(rs.getInt(7));
                lista.add(confederacion);
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

        Confederacion confederacion = new Confederacion();
        sql = "SELECT * FROM confederacion_futbol WHERE nombre = '" + nombre + "'";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                confederacion.setConfederacion_id(rs.getInt(1));
                confederacion.setNombre_oficial(rs.getString(2));
                confederacion.setAcronimo(rs.getString(3));
                confederacion.setUbicaicon(rs.getString(4));
                confederacion.setSede(rs.getString(5));
                confederacion.setFecha_fundacion(rs.getDate(6));
                confederacion.setNumero_federaciones_afiliadas(rs.getInt(7));
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

        return confederacion;
    }

}
