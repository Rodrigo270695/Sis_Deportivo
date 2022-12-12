package com.deportivo.controller;

import com.deportivo.interfac.CRUD;
import com.deportivo.model.TipoDocumentoIdentidad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import org.postgresql.util.PSQLException;

public class TipoDocumentoIdentidadController implements CRUD {

    Conexion estado = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    @Override
    public List listar() {

        List lista = new ArrayList();
        sql = "SELECT * FROM tipo_documento_identidad ORDER BY tipo_doc_identidad_id DESC";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                TipoDocumentoIdentidad tipoDocumento = new TipoDocumentoIdentidad();
                tipoDocumento.setTipo_doc_identidad_id(rs.getInt(1));
                tipoDocumento.setDescripcion_larga(rs.getString(2));
                tipoDocumento.setAbreviatura(rs.getString(3));
                lista.add(tipoDocumento);
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

        TipoDocumentoIdentidad tipoDocumento = (TipoDocumentoIdentidad) obj;
        sql = "INSERT INTO tipo_documento_identidad(descripcion_larga,abreviatura) VALUES(?,?)";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, tipoDocumento.getDescripcion_larga());
            ps.setString(2, tipoDocumento.getAbreviatura());
            ps.executeUpdate();

        } catch (PSQLException pe) {
            throw new Exception("Ya existe el Tipo documento de identidad");
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

        TipoDocumentoIdentidad tipoDocumento = (TipoDocumentoIdentidad) obj;
        sql = "UPDATE tipo_documento_identidad SET descripcion_larga=?,abreviatura=? WHERE tipo_doc_identidad_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, tipoDocumento.getDescripcion_larga());
            ps.setString(2, tipoDocumento.getAbreviatura());
            ps.setInt(3, tipoDocumento.getTipo_doc_identidad_id());
            ps.executeUpdate();

        } catch (PSQLException pe) {
            throw new Exception("Ya existe el Tipo documento identidad");
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

        sql = "DELETE FROM tipo_documento_identidad WHERE tipo_doc_identidad_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (PSQLException pe) {
            pe.printStackTrace(System.err);
            throw new Exception("El Tipo documento identidad no se puede eliminar, porque está siendo USADO");
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

        TipoDocumentoIdentidad tipoDocumento = new TipoDocumentoIdentidad();
        sql = "SELECT * FROM tipo_documento_identidad WHERE tipo_doc_identidad_id = " + id;

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                tipoDocumento.setTipo_doc_identidad_id(rs.getInt(1));
                tipoDocumento.setDescripcion_larga(rs.getString(2));
                tipoDocumento.setAbreviatura(rs.getString(3));
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

        return tipoDocumento;

    }

    @Override
    public List buscar(Object obj) {

        List lista = new ArrayList();
        sql = "SELECT * FROM tipo_documento_identidad WHERE descripcion_larga LIKE '%" + obj + "%' ";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                TipoDocumentoIdentidad tipoDocumento = new TipoDocumentoIdentidad();
                tipoDocumento.setTipo_doc_identidad_id(rs.getInt(1));
                tipoDocumento.setDescripcion_larga(rs.getString(2));
                tipoDocumento.setAbreviatura(rs.getString(3));
                lista.add(tipoDocumento);
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

        TipoDocumentoIdentidad tipoDocumento = new TipoDocumentoIdentidad();
        sql = "SELECT * FROM tipo_documento_identidad WHERE descripcion_larga = '" + nombre + "'";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                tipoDocumento.setTipo_doc_identidad_id(rs.getInt(1));
                tipoDocumento.setDescripcion_larga(rs.getString(2));
                tipoDocumento.setAbreviatura(rs.getString(3));

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

        return tipoDocumento;
    }

}
