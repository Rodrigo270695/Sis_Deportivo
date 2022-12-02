package com.deportivo.controller;

import com.deportivo.interfac.CRUD;
import com.deportivo.model.TipoJugador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import org.postgresql.util.PSQLException;

public class TipoJugadorController implements CRUD {

    Conexion estado = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    @Override
    public List listar() {

        List lista = new ArrayList();
        sql = "SELECT * FROM tipo_jugador ORDER BY tipo_jugador_id DESC";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                TipoJugador tipoJugador = new TipoJugador();
                tipoJugador.setTipo_jugador_id(rs.getInt(1));
                tipoJugador.setDescripcion(rs.getString(2));
                tipoJugador.setSigla(rs.getString(3).charAt(0));
                lista.add(tipoJugador);
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

        TipoJugador tipoJugador = (TipoJugador) obj;
        sql = "INSERT INTO tipo_jugador(descripcion,sigla) VALUES(?,?)";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, tipoJugador.getDescripcion());
            ps.setString(2, "" + tipoJugador.getSigla());
            ps.executeUpdate();

        } catch (PSQLException pe) {
            throw new Exception("Ya existe el Tipo de Jugador");
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

        TipoJugador tipoJugador = (TipoJugador) obj;
        sql = "UPDATE tipo_jugador SET descripcion=?,sigla=? WHERE tipo_jugador_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, tipoJugador.getDescripcion());
            ps.setString(2, "" + tipoJugador.getSigla());
            ps.setInt(3, tipoJugador.getTipo_jugador_id());
            ps.executeUpdate();

        } catch (PSQLException pe) {
            throw new Exception("Ya existe la Tipo deJugador");
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

        sql = "DELETE FROM tipo_jugador WHERE tipo_jugador_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (PSQLException pe) {
            pe.printStackTrace(System.err);
            throw new Exception("El Tipo de Jugador no se puede eliminar, porque está siendo USADO");
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

        TipoJugador tipoJugador = new TipoJugador();
        sql = "SELECT * FROM tipo_jugador WHERE tipo_jugador_id = " + id;

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                tipoJugador.setTipo_jugador_id(rs.getInt(1));
                tipoJugador.setDescripcion(rs.getString(2));
                tipoJugador.setSigla(rs.getString(3).charAt(0));
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

        return tipoJugador;

    }

    @Override
    public List buscar(Object obj) {

        List lista = new ArrayList();
        sql = "SELECT * FROM tipo_jugador WHERE descripcion LIKE '%" + obj + "%' ";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                TipoJugador tipoJugador = new TipoJugador();
                tipoJugador.setTipo_jugador_id(rs.getInt(1));
                tipoJugador.setDescripcion(rs.getString(2));
                tipoJugador.setSigla(rs.getString(3).charAt(0));
                lista.add(tipoJugador);
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

        TipoJugador tipoJugador = new TipoJugador();
        sql = "SELECT * FROM tipo_jugador WHERE descripcion = '" + nombre + "'";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                tipoJugador.setTipo_jugador_id(rs.getByte(1));
                tipoJugador.setDescripcion(rs.getString(2));
                tipoJugador.setSigla(rs.getString(2).charAt(0));
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

        return tipoJugador;
    }

}
