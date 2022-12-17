package com.deportivo.controller;

import com.deportivo.interfac.CRUD;
import com.deportivo.model.Equipo;
import com.deportivo.model.Evento;
import com.deportivo.model.Futbolista;
import com.deportivo.model.IncidenciaPartido;
import com.deportivo.model.InstanciaPartido;
import com.deportivo.model.Partido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import org.postgresql.util.PSQLException;

public class IncidenciaPartidoController implements CRUD {

    PartidoController partidoC = new PartidoController();
    FutbolistaController futbolistaC = new FutbolistaController();
    EquipoController equipoC = new EquipoController();
    EventoController eventoC = new EventoController();
    InstanciaPartidoController instanciaC = new InstanciaPartidoController();
    Conexion estado = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    @Override
    public List listar() {

        List lista = new ArrayList();
        sql = "SELECT * FROM incidencia_partido ORDER BY minuto ASC";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                IncidenciaPartido incidenciaPartido = new IncidenciaPartido();
//                incidenciaPartido.setIncidencia_partido_id(rs.getInt(1));
//                incidenciaPartido.setDescripcion(rs.getString(2));

                lista.add(incidenciaPartido);
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
    
    public List listar(int idPartido) {

        List lista = new ArrayList();
        sql = "select * from incidencia_partido where partido_id  = ?  order by  minuto asc";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idPartido);
            rs = ps.executeQuery();

            while (rs.next()) {
                IncidenciaPartido incidenciaPartido = new IncidenciaPartido();
                incidenciaPartido.setEvento((Evento) eventoC.obtenerdato(rs.getInt(1)));
                incidenciaPartido.setPartido((Partido) partidoC.obtenerdato(rs.getInt(2)));
                incidenciaPartido.setFutbolista((Futbolista) futbolistaC.obtenerdato(rs.getInt(3)));
                incidenciaPartido.setInstanciaPartido((InstanciaPartido) instanciaC.obtenerdato(rs.getInt(4)));
                incidenciaPartido.setMinuto(rs.getByte(5));
                incidenciaPartido.setEquipo((Equipo) equipoC.obtenerdato(rs.getInt(6)));
                incidenciaPartido.setDetalle(rs.getString(7));

                lista.add(incidenciaPartido);
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

        IncidenciaPartido incidenciaPartido = (IncidenciaPartido) obj;
        sql = "INSERT INTO incidencia_partido(descripcion) VALUES(?)";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
//            ps.setString(1, incidenciaPartido.getDescripcion());
            ps.executeUpdate();

        } catch (PSQLException pe) {
            throw new Exception("Ya existe la  Incidencia de Partido");
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

        IncidenciaPartido incidenciaPartido = (IncidenciaPartido) obj;
        sql = "UPDATE incidencia_partido SET descripcion=? WHERE incidencia_partido_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
//            ps.setString(1, incidenciaPartido.getDescripcion());
//            ps.setInt(2, incidenciaPartido.getIncidencia_partido_id());
            ps.executeUpdate();

        } catch (PSQLException pe) {
            pe.printStackTrace(System.err);
            throw new Exception("Ya existe la  incidencia de Partido");
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

        sql = "DELETE FROM incidencia_partido WHERE incidencia_partido_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (PSQLException pe) {
            pe.printStackTrace(System.err);
            throw new Exception("La Incidencia de Partido no se puede eliminar, porque está siendo USADO");
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

        IncidenciaPartido incidenciaPartido = new IncidenciaPartido();
        sql = "SELECT * FROM incidencia_partido WHERE incidencia_partido_id = " + id;

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
//                incidenciaPartido.setIncidencia_partido_id(rs.getInt(1));
//                incidenciaPartido.setDescripcion(rs.getString(2));

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

        return incidenciaPartido;
    }

    @Override
    public List buscar(Object obj) {

        List lista = new ArrayList();
        sql = "SELECT * FROM incidencia_partido WHERE descripcion LIKE '%" + obj + "%' ";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                IncidenciaPartido incidenciaPartido = new IncidenciaPartido();
//                incidenciaPartido.setIncidencia_partido_id(rs.getInt(1));
//                incidenciaPartido.setDescripcion(rs.getString(2));

                lista.add(incidenciaPartido);
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

        IncidenciaPartido incidenciaPartido = new IncidenciaPartido();
        sql = "SELECT * FROM incidencia_partido WHERE descripcion = '" + nombre + "'";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
//                incidenciaPartido.setIncidencia_partido_id(rs.getByte(1));
//                incidenciaPartido.setDescripcion(rs.getString(2));

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

        return incidenciaPartido;
    }

}
