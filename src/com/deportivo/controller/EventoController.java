package com.deportivo.controller;

import com.deportivo.interfac.CRUD;
import com.deportivo.model.Evento;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.postgresql.util.PSQLException;

public class EventoController  implements CRUD{

    Conexion estado = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    @Override
    public List listar() {

        List lista = new ArrayList();
        sql = "SELECT * FROM evento ORDER BY evento_id DESC";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Evento evento = new Evento();
                evento.setEventoId(rs.getByte(1));
                evento.setNombre(rs.getString(2));
                lista.add(evento);
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

        Evento evento = (Evento) obj;
        sql = "INSERT INTO evento(nombre) VALUES(?)";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, evento.getNombre());
            ps.executeUpdate();

        } catch (PSQLException pe) {
            throw new Exception("Ya existe el evento");
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
        
        Evento evento = (Evento) obj;
        sql = "UPDATE evento SET nombre=? WHERE evento_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, evento.getNombre());
            ps.setInt(2, evento.getEventoId());
            ps.executeUpdate();

        } catch (PSQLException pe) {
            throw new Exception("Ya existe el evento");
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
        
        sql = "DELETE FROM evento WHERE evento_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (PSQLException pe) {
            pe.printStackTrace(System.err);
            throw new Exception("El evento no se puede eliminar, porque está siendo USADO");
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
        
        Evento evento = new Evento();
        sql = "SELECT * FROM evento WHERE evento_id = "+id;

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                evento.setEventoId(rs.getByte(1));
                evento.setNombre(rs.getString(2));
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

        return evento;
    }

    @Override
    public List buscar(Object obj) {
        
        List lista = new ArrayList();
        sql = "SELECT * FROM evento WHERE nombre LIKE '%"+obj+"%' ";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Evento evento = new Evento();
                evento.setEventoId(rs.getByte(1));
                evento.setNombre(rs.getString(2));
                lista.add(evento);
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
        
        Evento evento = new Evento();
        sql = "SELECT * FROM evento WHERE nombre = '"+nombre+"'";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                evento.setEventoId(rs.getByte(1));
                evento.setNombre(rs.getString(2));
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

        return evento;
    }

}
