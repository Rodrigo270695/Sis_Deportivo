package com.deportivo.controller;

import com.deportivo.interfac.CRUD;
import com.deportivo.model.Pais;
import com.deportivo.model.Profesional;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import org.postgresql.util.PSQLException;

public class ProfesionalController implements CRUD {

    PaisController paisC = new PaisController();
    Conexion estado = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    @Override
    public List listar() {

        List lista = new ArrayList();
        sql = "SELECT * FROM profesional ORDER BY profesional_id DESC";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Profesional profesional = new Profesional();
                profesional.setProfesional_id(rs.getInt(1));
                profesional.setNombre_completo(rs.getString(2));
                profesional.setFecha_nacimiento(rs.getDate(3));
                profesional.setEstado(rs.getString(4).charAt(0));
                profesional.setSeudonimo(rs.getString(5));
                profesional.setFecha_debut(rs.getDate(6));
                profesional.setPalmares(rs.getString(7));
                profesional.setRecords(rs.getString(8));
                profesional.setPais((Pais) paisC.obtenerdato(rs.getInt(9)));
                lista.add(profesional);
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

        Profesional profesional = (Profesional) obj;
        sql = "INSERT INTO profesional(nombre_completo,fecha_nacimiento,estado,seudonimo,fecha_debut,palmares,records,pais_id) "
                + "VALUES(?,?,?,?,?,?,?,?)";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, profesional.getNombre_completo());
            ps.setDate(2, (Date) profesional.getFecha_nacimiento());
            ps.setInt(3, profesional.getEstado());
            ps.setString(4, profesional.getSeudonimo());
            ps.setDate(5, (Date) profesional.getFecha_debut());
            ps.setString(6, profesional.getPalmares());
            ps.setString(7, profesional.getRecords());
            ps.setInt(8, profesional.getPais().getPaisId());
            ps.executeUpdate();

        } catch (PSQLException pe) {
            pe.printStackTrace(System.err);
            throw new Exception("Ya existe el Profesional");
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

        Profesional profesional = (Profesional) obj;
        sql = "UPDATE profesional SET nombre_completo=?,fecha_nacimiento=?,estado=?,seudonimo=?,fecha_debut=?,"
                + "palmares=?,records=?,pais_id=? "
                + "WHERE profesional_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, profesional.getNombre_completo());
            ps.setDate(2, (Date) profesional.getFecha_nacimiento());
            ps.setInt(3, profesional.getEstado());
            ps.setString(4, profesional.getSeudonimo());
            ps.setDate(5, (Date) profesional.getFecha_debut());
            ps.setString(6, profesional.getPalmares());
            ps.setString(7, profesional.getRecords());
            ps.setInt(11, profesional.getPais().getPaisId());
            ps.setInt(12, profesional.getProfesional_id());
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
