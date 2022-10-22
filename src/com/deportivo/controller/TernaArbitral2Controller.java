package com.deportivo.controller;

import com.deportivo.interfac.CRUD;
import com.deportivo.model.TernaArbitral2;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.postgresql.util.PSQLException;

public class TernaArbitral2Controller  implements CRUD{

    Conexion estado = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    @Override
    public List listar() {

        List lista = new ArrayList();
        sql = "SELECT * FROM terna_arbitral_2 ORDER BY terna_arb_id DESC";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                TernaArbitral2 ternaArbitral2 = new TernaArbitral2();
                ternaArbitral2.setTernaArbitral2Id(rs.getInt(1));
                ternaArbitral2.setNombre(rs.getString(2));
                ternaArbitral2.setEstado(rs.getString(3));
                lista.add(ternaArbitral2);
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

        TernaArbitral2 ternaArbitral2 = (TernaArbitral2) obj;
        sql = "INSERT INTO terna_arbitral_2(terna_arb_nombre, terna_arb_estado) VALUES(?,?)";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, ternaArbitral2.getNombre());
            ps.setString(2, ternaArbitral2.getEstado());
            ps.executeUpdate();

        } catch (PSQLException pe) {
            throw new Exception("Ya existe la terna arbitral");
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
        
        TernaArbitral2 grupo = (TernaArbitral2) obj;
        sql = "UPDATE terna_arbitral_2 SET terna_arb_nombre=?, terna_arb_estado=? WHERE terna_arb_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, grupo.getNombre());
            ps.setString(2, grupo.getEstado());
            ps.setInt(3, grupo.getTernaArbitral2Id());
            ps.executeUpdate();

        } catch (PSQLException pe) {
            throw new Exception("Ya existe la terna arbitral");
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
    public void eliminar(int id) throws Exception{
        
        sql = "DELETE FROM terna_arbitral_2 WHERE terna_arb_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (PSQLException pe) {
            pe.printStackTrace(System.err);
            throw new Exception("La terna arbitral no se puede eliminar, porque está siendo USADO");
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
        
        TernaArbitral2 ternaArbitral2 = new TernaArbitral2();
        sql = "SELECT * FROM terna_arbitral_2 WHERE terna_arb_id = "+id;

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                ternaArbitral2.setTernaArbitral2Id(rs.getInt(1));
                ternaArbitral2.setNombre(rs.getString(2));
                ternaArbitral2.setEstado(rs.getString(3));
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

        return ternaArbitral2;
    }

    @Override
    public List buscar(Object obj) {
        
        List lista = new ArrayList();
        sql = "SELECT * FROM terna_arbitral_2 WHERE terna_arb_nombre LIKE '%"+obj+"%' "
                + "OR terna_arb_estado LIKE '%"+obj+"%'";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                TernaArbitral2 ternaArbitral2 = new TernaArbitral2();
                ternaArbitral2.setTernaArbitral2Id(rs.getInt(1));
                ternaArbitral2.setNombre(rs.getString(2));
                ternaArbitral2.setEstado(rs.getString(3));
                lista.add(ternaArbitral2);
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
        
        TernaArbitral2 ternaArbitral2 = new TernaArbitral2();
        sql = "SELECT * FROM terna_arbitral_2 WHERE terna_arb_nombre = '"+nombre+"'";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                ternaArbitral2.setTernaArbitral2Id(rs.getInt(1));
                ternaArbitral2.setNombre(rs.getString(2));
                ternaArbitral2.setEstado(rs.getString(3));
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

        return ternaArbitral2;
    }

}
