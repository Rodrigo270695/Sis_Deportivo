package com.deportivo.controller;

import com.deportivo.interfac.CRUD;
import com.deportivo.model.Contrato;
import com.deportivo.model.Futbolista;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.postgresql.util.PSQLException;

public class ContratoController implements CRUD {

    Conexion estado = new Conexion();
    FutbolistaController futbolistaC = new FutbolistaController();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    @Override
    public List listar() {

        List lista = new ArrayList();
        sql = "SELECT * FROM contrato_futbol ORDER BY contrato_id DESC";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Contrato contrato = new Contrato();
                contrato.setContratoId(rs.getInt(1));
                contrato.setFechaInicio(rs.getDate(2));
                contrato.setFechaFin(rs.getDate(3));
                contrato.setRemuneracion(rs.getDouble(4));
                contrato.setDescripcion(rs.getString(5));
                contrato.setFutbolista((Futbolista) futbolistaC.obtenerdato(rs.getInt(6)));
                lista.add(contrato);
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

        Contrato contrato = (Contrato) obj;
        sql = "INSERT INTO contrato_futbol(fecha_inicio,fecha_fin,remuneracion,descripcion,futbolista_id) "
                + "VALUES(?,?,?,?,?)";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setDate(1, contrato.getFechaInicio());
            ps.setDate(2, contrato.getFechaFin());
            ps.setDouble(3, contrato.getRemuneracion());
            ps.setString(4, contrato.getDescripcion());
            ps.setInt(5, contrato.getFutbolista().getFutbolistaId());
            ps.executeUpdate();

        } catch (PSQLException pe) {

            throw new Exception("Ya existe la contrato");
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

        Contrato contrato = (Contrato) obj;
        sql = "UPDATE contrato_futbol SET fecha_inicio=?,fecha_fin=?,remuneracion=?,descripcion=?,futbolista_id=? "
                + "WHERE contrato_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setDate(1, contrato.getFechaInicio());
            ps.setDate(2, contrato.getFechaFin());
            ps.setDouble(3, contrato.getRemuneracion());
            ps.setString(4, contrato.getDescripcion());
            ps.setInt(5, contrato.getFutbolista().getFutbolistaId());
            ps.setInt(6, contrato.getContratoId());
            ps.executeUpdate();

        } catch (PSQLException pe) {
            throw new Exception("Ya existe el contrato");
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

        sql = "DELETE FROM contrato_futbol WHERE contrato_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (PSQLException pe) {
            pe.printStackTrace(System.err);
            throw new Exception("El contrato no se puede eliminar, porque está siendo USADO");
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

        Contrato contrato = new Contrato();
        sql = "SELECT * FROM contrato_futbol WHERE contrato_id = " + id;

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                contrato.setContratoId(rs.getInt(1));
                contrato.setFechaInicio(rs.getDate(2));
                contrato.setFechaFin(rs.getDate(3));
                contrato.setRemuneracion(rs.getDouble(4));
                contrato.setDescripcion(rs.getString(5));
                contrato.setFutbolista((Futbolista) futbolistaC.obtenerdato(rs.getInt(6)));
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

        return contrato;

    }

    @Override
    public List buscar(Object obj) {

        List lista = new ArrayList();
        sql = "SELECT co.contrato_id,co.fecha_inicio,co.fecha_fin,co.remuneracion,co.descripcion,co.futbolista_id FROM contrato_futbol co \n"
                + "inner join futbolista fu on fu.futbolista_id = co.futbolista_id \n"
                + "WHERE fu.nombre_completo LIKE '%"+obj+"%' ";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Contrato contrato = new Contrato();
                contrato.setContratoId(rs.getInt(1));
                contrato.setFechaInicio(rs.getDate(2));
                contrato.setFechaFin(rs.getDate(3));
                contrato.setRemuneracion(rs.getDouble(4));
                contrato.setDescripcion(rs.getString(5));
                contrato.setFutbolista((Futbolista) futbolistaC.obtenerdato(rs.getInt(6)));
                lista.add(contrato);
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

}
