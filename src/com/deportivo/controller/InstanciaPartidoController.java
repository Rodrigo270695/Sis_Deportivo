package com.deportivo.controller;

import com.deportivo.interfac.CRUD;
import com.deportivo.model.InstanciaPartido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import org.postgresql.util.PSQLException;

public class InstanciaPartidoController implements CRUD {

    Conexion estado = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    @Override
    public List listar() {

        List lista = new ArrayList();
        sql = "SELECT * FROM instancia_partido ORDER BY instancia_partido_id ";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                InstanciaPartido instanciaPartido = new InstanciaPartido();
                instanciaPartido.setInstancia_partido_id(rs.getInt(1));
                instanciaPartido.setDescripcion(rs.getString(2));

                lista.add(instanciaPartido);
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

        InstanciaPartido instanciaPartido = (InstanciaPartido) obj;
        sql = "INSERT INTO instancia_partido(descripcion) VALUES(?)";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, instanciaPartido.getDescripcion());
            ps.executeUpdate();

        } catch (PSQLException pe) {
            throw new Exception("Ya existe la  Instancia de Partido");
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

        InstanciaPartido instanciaPartido = (InstanciaPartido) obj;
        sql = "UPDATE instancia_partido SET descripcion=? WHERE instancia_partido_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, instanciaPartido.getDescripcion());
            ps.setInt(2, instanciaPartido.getInstancia_partido_id());
            ps.executeUpdate();

        } catch (PSQLException pe) {
            pe.printStackTrace(System.err);
            throw new Exception("Ya existe la  instancia de Partido");
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

        sql = "DELETE FROM instancia_partido WHERE instancia_partido_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (PSQLException pe) {
            pe.printStackTrace(System.err);
            throw new Exception("La Instancia de Partido no se puede eliminar, porque está siendo USADO");
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

        InstanciaPartido instanciaPartido = new InstanciaPartido();
        sql = "SELECT * FROM instancia_partido WHERE instancia_partido_id = " + id;

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                instanciaPartido.setInstancia_partido_id(rs.getInt(1));
                instanciaPartido.setDescripcion(rs.getString(2));

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

        return instanciaPartido;
    }

    @Override
    public List buscar(Object obj) {

        List lista = new ArrayList();
        sql = "SELECT * FROM instancia_partido WHERE descripcion LIKE '%" + obj + "%' ";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                InstanciaPartido instanciaPartido = new InstanciaPartido();
                instanciaPartido.setInstancia_partido_id(rs.getInt(1));
                instanciaPartido.setDescripcion(rs.getString(2));

                lista.add(instanciaPartido);
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

        InstanciaPartido instanciaPartido = new InstanciaPartido();
        sql = "SELECT * FROM instancia_partido WHERE descripcion = '" + nombre + "'";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                instanciaPartido.setInstancia_partido_id(rs.getByte(1));
                instanciaPartido.setDescripcion(rs.getString(2));

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

        return instanciaPartido;
    }

}
