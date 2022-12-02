package com.deportivo.controller;

import com.deportivo.interfac.CRUD;
import com.deportivo.model.Arbitro;
import com.deportivo.model.Pais;
import java.sql.*;
import java.util.*;
import org.postgresql.util.PSQLException;

public class ArbitroController implements CRUD {

    PaisController paisC =new  PaisController();
    Conexion estado = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    @Override
    public List listar() {

        List lista = new ArrayList();
        sql = "SELECT * FROM arbitro ORDER BY arbitro_id DESC";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Arbitro arbitro = new Arbitro();
                arbitro.setArbitro_id(rs.getInt(1));
                arbitro.setArbitro_nombre(rs.getString(2));
                arbitro.setEstado_arbitro(rs.getString(3).charAt(0));
                arbitro.setPais((Pais) paisC.obtenerdato(rs.getInt(4)));
                lista.add(arbitro);
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

        Arbitro arbitro = (Arbitro) obj;
        sql = "INSERT INTO arbitro(arbitro_nombre, estado_arbitro,pais_id) VALUES(?,?,?)";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, arbitro.getArbitro_nombre());
            ps.setString(2, ""+arbitro.getEstado_arbitro());
            ps.setInt(3, arbitro.getPais().getPaisId());
            ps.executeUpdate();

        } catch (PSQLException pe) {
            throw new Exception("Ya existe el arbitro");
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

        Arbitro arbitro = (Arbitro) obj;
        sql = "UPDATE arbitro SET arbitro_nombre=?, estado_arbitro=?, pais_id = ? WHERE arbitro_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, arbitro.getArbitro_nombre());
            ps.setString(2, ""+arbitro.getEstado_arbitro());
            ps.setInt(3, arbitro.getPais().getPaisId());
            ps.setInt(4, arbitro.getArbitro_id());
            ps.executeUpdate();

        } catch (PSQLException pe) {
            pe.printStackTrace(System.err);
            throw new Exception("Ya existe el Árbitro");
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

        sql = "DELETE FROM arbitro WHERE arbitro_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (PSQLException pe) {
            pe.printStackTrace(System.err);
            throw new Exception("El árbitro no se puede eliminar, porque está siendo USADO");
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

        Arbitro arbitro = new Arbitro();
        sql = "SELECT * FROM arbitro WHERE arbitro_id = " + id;

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                arbitro.setArbitro_id(rs.getInt(1));
                arbitro.setArbitro_nombre(rs.getString(2));
                arbitro.setEstado_arbitro(rs.getString(3).charAt(0));
                arbitro.setPais((Pais) paisC.obtenerdato(rs.getInt(4)));

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

        return arbitro;

    }

    @Override
    public List buscar(Object obj) {

         List lista = new ArrayList();
        sql = "SELECT * FROM arbitro WHERE arbitro_nombre LIKE '%"+obj+"%' "
                + "OR estado_arbitro LIKE '%"+obj+"%'";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Arbitro arbitro = new Arbitro();
                arbitro.setArbitro_id(rs.getInt(1));
                arbitro.setArbitro_nombre(rs.getString(2));
                arbitro.setEstado_arbitro(rs.getString(3).charAt(0));
                arbitro.setPais((Pais) paisC.obtenerdato(rs.getInt(4)));
                lista.add(arbitro);
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
