package com.deportivo.controller;

import com.deportivo.interfac.CRUD;
import com.deportivo.model.Equipo;
import java.sql.*;
import java.util.*;
import org.postgresql.util.PSQLException;

public class EquipoController implements CRUD {

    Conexion estado = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    @Override
    public List listar() {

        List lista = new ArrayList();
        sql = "SELECT * FROM equipo ORDER BY equipo_id DESC";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Equipo equipo = new Equipo();
                equipo.setEquipoId(rs.getInt(1));
                equipo.setNombreCompleto(rs.getString(2));
                equipo.setNombrecorto(rs.getString(3));
                equipo.setFundacion(rs.getDate(4));
                equipo.setApodo(rs.getString(5));
                equipo.setUbicacion(rs.getString(6));
                equipo.setNumeroSocios(rs.getByte(7));
                equipo.setFoto(rs.getBinaryStream(8));
                lista.add(equipo);
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

        sql = "DELETE FROM equipo WHERE equipo_id = ?";

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

        Equipo equipo = new Equipo();
        sql = "SELECT * FROM equipo WHERE equipo_id = " + id;

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                equipo.setEquipoId(rs.getInt(1));
                equipo.setNombreCompleto(rs.getString(2));
                equipo.setNombrecorto(rs.getString(3));
                equipo.setFundacion(rs.getDate(4));
                equipo.setApodo(rs.getString(5));
                equipo.setUbicacion(rs.getString(6));
                equipo.setNumeroSocios(rs.getByte(7));
                equipo.setFoto(rs.getBinaryStream(8));
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

        return equipo;

    }

    @Override
    public List buscar(Object obj) {

        List lista = new ArrayList();
        sql = "SELECT * FROM equipo WHERE nombre_completo LIKE '%"+obj+"%'\n"
                + "OR nombre_corto LIKE '%"+obj+"%'\n"
                + "OR apodo LIKE '%"+obj+"%'";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Equipo equipo = new Equipo();
                equipo.setEquipoId(rs.getInt(1));
                equipo.setNombreCompleto(rs.getString(2));
                equipo.setNombrecorto(rs.getString(3));
                equipo.setFundacion(rs.getDate(4));
                equipo.setApodo(rs.getString(5));
                equipo.setUbicacion(rs.getString(6));
                equipo.setNumeroSocios(rs.getByte(7));
                equipo.setFoto(rs.getBinaryStream(8));
                lista.add(equipo);
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

        Equipo equipo = (Equipo) obj;
        sql = "INSERT INTO equipo(nombre_completo, nombre_corto, fecha_fundacion, apodo, ubicacion, numero_socios, foto) VALUES(?,?,?,?,?,?,?)";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, equipo.getNombreCompleto());
            ps.setString(2, equipo.getNombrecorto());
            ps.setDate(3, equipo.getFundacion());
            ps.setString(4, equipo.getApodo());
            ps.setString(5, equipo.getUbicacion());
            ps.setByte(6, equipo.getNumeroSocios());
            ps.setBinaryStream(7, equipo.getFoto());
            ps.executeUpdate();

        } catch (PSQLException pe) {
            pe.printStackTrace(System.err);
            throw new Exception("Ya existe el Equipo");
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

        Equipo equipo = (Equipo) obj;
        sql = "UPDATE equipo SET nombre_completo=?, nombre_corto=?, fecha_fundacion=?, apodo=?, ubicacion=?, numero_socios=?, foto=? WHERE equipo_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, equipo.getNombreCompleto());
            ps.setString(2, equipo.getNombrecorto());
            ps.setDate(3, equipo.getFundacion());
            ps.setString(4, equipo.getApodo());
            ps.setString(5, equipo.getUbicacion());
            ps.setByte(6, equipo.getNumeroSocios());
            ps.setBinaryStream(7, equipo.getFoto());
            ps.setInt(8, equipo.getEquipoId());
            ps.executeUpdate();

        } catch (PSQLException pe) {
            pe.printStackTrace(System.err);
            throw new Exception("Ya existe el Equipo");
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
