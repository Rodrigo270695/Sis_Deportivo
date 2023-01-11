package com.deportivo.controller;

import com.deportivo.interfac.CRUD;
import com.deportivo.model.Continente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.postgresql.util.PSQLException;

public class ContinenteController implements CRUD {

    Conexion estado = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";
    
    @Override
    public List listar() {

        List lista = new ArrayList();
        sql = "SELECT * FROM continente ORDER BY continente_id DESC";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Continente continente = new Continente();
                continente.setContinenteId(rs.getByte(1));
                continente.setNombre(rs.getString(2));
                continente.setAbreviatura(rs.getString(3));
                lista.add(continente);
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

        Continente continente = (Continente) obj;
        sql = "INSERT INTO continente(nombre, abreviatura) VALUES(?,?)";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, continente.getNombre());
            ps.setString(2, continente.getAbreviatura());
            ps.executeUpdate();

        } catch (PSQLException pe) {
            throw new Exception("Ya existe el continente");
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

        Continente continente = (Continente) obj;
        sql = "UPDATE continente SET nombre=?, abreviatura=? WHERE continente_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, continente.getNombre());
            ps.setString(2, continente.getAbreviatura());
            ps.setInt(3, continente.getContinenteId());
            ps.executeUpdate();

        } catch (PSQLException pe) {
            throw new Exception("Ya existe el continente");
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

        sql = "DELETE FROM continente WHERE continente_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (PSQLException pe) {
            pe.printStackTrace(System.err);
            throw new Exception("El continente no se puede eliminar, porque está siendo USADO");
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

        Continente continente = new Continente();
        sql = "SELECT * FROM continente WHERE continente_id = " + id;

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                continente.setContinenteId(rs.getByte(1));
                continente.setNombre(rs.getString(2));
                continente.setAbreviatura(rs.getString(3));
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

        return continente;
    }

    @Override
    public List buscar(Object obj) {

        List lista = new ArrayList();
        sql = "select * from continente where nombre like '%" + obj + "%' and abreviatura like '%"+obj+"%'";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                Continente continente = new Continente();
                continente.setContinenteId(rs.getByte(1));
                continente.setNombre(rs.getString(2));
                continente.setAbreviatura(rs.getString(3));
                lista.add(continente);
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

        Continente continente = new Continente();
        sql = "SELECT * FROM continente WHERE nombre = '" + nombre + "'";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                continente.setContinenteId(rs.getByte(1));
                continente.setNombre(rs.getString(2));
                continente.setAbreviatura(rs.getString(3));
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

        return continente;
    }

}
