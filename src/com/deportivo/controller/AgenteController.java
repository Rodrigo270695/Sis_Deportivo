package com.deportivo.controller;

import com.deportivo.interfac.CRUD;
import com.deportivo.model.Agente;
import java.sql.*;
import java.util.*;
import org.postgresql.util.PSQLException;

public class AgenteController implements CRUD {

    Conexion estado = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    @Override
    public List listar() {

        List lista = new ArrayList();
        sql = "SELECT * FROM agente ORDER BY agente_id DESC";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Agente agente = new Agente();
                agente.setAgenteId(rs.getInt(1));
                agente.setNombreCompleto(rs.getString(2));
                agente.setDireccion(rs.getString(3));
                agente.setCorreo(rs.getString(4));
                agente.setFoto(rs.getBinaryStream(5));
                lista.add(agente);
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
    public void eliminar(int id) throws Exception {

        sql = "DELETE FROM agente WHERE agente_id = ?";

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

        Agente agente = new Agente();
        sql = "SELECT * FROM agente WHERE agente_id = " + id;

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                agente.setAgenteId(rs.getInt(1));
                agente.setNombreCompleto(rs.getString(2));
                agente.setDireccion(rs.getString(3));
                agente.setCorreo(rs.getString(4));
                agente.setFoto(rs.getBinaryStream(5));
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

        return agente;

    }

    @Override
    public List buscar(Object obj) {

        List lista = new ArrayList();
        sql = "SELECT * FROM agente WHERE nombre_completo LIKE '%"+obj+"%'\n"
                + "OR direccion LIKE '%"+obj+"%'\n"
                + "OR correo LIKE '%"+obj+"%'";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Agente agente = new Agente();
                agente.setAgenteId(rs.getInt(1));
                agente.setNombreCompleto(rs.getString(2));
                agente.setDireccion(rs.getString(3));
                agente.setCorreo(rs.getString(4));
                agente.setFoto(rs.getBinaryStream(5));
                lista.add(agente);
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

        Agente agente = (Agente) obj;
        sql = "INSERT INTO agente(nombre_completo, direccion, correo, foto) VALUES(?,?,?,?)";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, agente.getNombreCompleto());
            ps.setString(2, agente.getDireccion());
            ps.setString(3, agente.getCorreo());
            ps.setBinaryStream(4, agente.getFoto());
            ps.executeUpdate();

        } catch (PSQLException pe) {
            pe.printStackTrace(System.err);
            throw new Exception("Ya existe el Agente");
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

        Agente agente = (Agente) obj;
        sql = "UPDATE agente SET nombre_completo=?, direccion=?, correo=?, foto=? WHERE agente_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, agente.getNombreCompleto());
            ps.setString(2, agente.getDireccion());
            ps.setString(3, agente.getCorreo());
            ps.setBinaryStream(4, agente.getFoto());
            ps.setInt(5, agente.getAgenteId());
            ps.executeUpdate();

        } catch (PSQLException pe) {
            pe.printStackTrace(System.err);
            throw new Exception("Ya existe el Agente");
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

}
