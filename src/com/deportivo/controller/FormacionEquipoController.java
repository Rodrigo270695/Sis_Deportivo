package com.deportivo.controller;

import com.deportivo.interfac.CRUD;
import com.deportivo.model.FormacionEquipo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import org.postgresql.util.PSQLException;

public class FormacionEquipoController implements CRUD {

    Conexion estado = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    @Override
    public List listar() {

        List lista = new ArrayList();
        sql = "SELECT * FROM formacion_equipo ORDER BY formacion_id DESC";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                FormacionEquipo formacionEquipo = new FormacionEquipo();
                formacionEquipo.setFormacion_id(rs.getInt(1));
                formacionEquipo.setDescripcion(rs.getString(2));

                lista.add(formacionEquipo);
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

        FormacionEquipo formacionEquipo = (FormacionEquipo) obj;
        sql = "INSERT INTO formacion_equipo(descripcion) VALUES(?)";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, formacionEquipo.getDescripcion());

            ps.executeUpdate();

        } catch (PSQLException pe) {
            throw new Exception("Ya existe la formación ");
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

        FormacionEquipo formacionEquipo = (FormacionEquipo) obj;
        sql = "UPDATE formacion_equipo SET descripcion=? WHERE formacion_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, formacionEquipo.getDescripcion());

            ps.setInt(2, formacionEquipo.getFormacion_id());
            ps.executeUpdate();

        } catch (PSQLException pe) {
            throw new Exception("Ya existe la Formación");
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

        sql = "DELETE FROM formacion_equipo WHERE formacion_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (PSQLException pe) {
            pe.printStackTrace(System.err);
            throw new Exception("La formación no se puede eliminar, porque está siendo USADO");
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

        FormacionEquipo formacionEquipo = new FormacionEquipo();
        sql = "SELECT * FROM formacion_equipo WHERE formacion_id = " + id;

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                formacionEquipo.setFormacion_id(rs.getInt(1));
                formacionEquipo.setDescripcion(rs.getString(2));

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

        return formacionEquipo;
    }

    @Override
    public List buscar(Object obj) {

        List lista = new ArrayList();
        sql = "SELECT * FROM formacion_equipo WHERE descripcion LIKE '%" + obj + "%' ";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                FormacionEquipo formacionEquipo = new FormacionEquipo();
                formacionEquipo.setFormacion_id(rs.getInt(1));
                formacionEquipo.setDescripcion(rs.getString(2));

                lista.add(formacionEquipo);
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

        FormacionEquipo formacionEquipo = new FormacionEquipo();
        sql = "SELECT * FROM formacion_equipo WHERE descripcion = '" + nombre + "'";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                formacionEquipo.setFormacion_id(rs.getByte(1));
                formacionEquipo.setDescripcion(rs.getString(2));
               
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

        return formacionEquipo;
    }

}
