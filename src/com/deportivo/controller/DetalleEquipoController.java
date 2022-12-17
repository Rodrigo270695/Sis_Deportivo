package com.deportivo.controller;

import com.deportivo.model.DetalleEquipo;
import com.deportivo.model.Equipo;
import com.deportivo.model.Futbolista;
import com.deportivo.model.Posicion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.postgresql.util.PSQLException;

public class DetalleEquipoController {

    FutbolistaController futbolistaC = new FutbolistaController();
    PosicionController posicionC = new PosicionController();
    EquipoController equipoC = new EquipoController();

    Conexion estado = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    public DetalleEquipo listar(int id) {

        List lista = new ArrayList();

        sql = "select * from detalle_equipo where equipo_id = " + id;

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                DetalleEquipo detalleP = new DetalleEquipo();
                detalleP.setEquipo_id((Equipo) equipoC.obtenerdato(rs.getInt(1)));
                detalleP.setFutbolista_id((Futbolista) futbolistaC.obtenerdato(rs.getInt(2)));
                detalleP.setPosicion_id((Posicion) posicionC.obtenerdato(rs.getInt(3)));
                lista.add(detalleP);

            }

        } catch (SQLException e) {
            e.printStackTrace(System.err);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.err);
            }
        }

        return (DetalleEquipo) lista;
    }

    public void registrar(Object obj) throws Exception {

        DetalleEquipo detalle = (DetalleEquipo) obj;

        sql = "INSERT INTO detalle_equipo(equipo_id, futbolista_id,posicion_id) VALUES(?,?,?)";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, detalle.getEquipo_id().getEquipoId());
            ps.setInt(2, detalle.getFutbolista_id().getFutbolistaId());
            ps.setInt(3, detalle.getPosicion_id().getPosicionId());
            ps.executeUpdate();

        } catch (PSQLException pe) {
            throw new Exception("Ya existe el detalle de equipo");
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
    
     public void eliminarDetalle(int idEquipo, int idFutbolista, int idPosicion ){
        
        sql = "delete from detalle_equipo where equipo_id =? and futbolista_id = ? and posicion_id=?" ;
        
        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idEquipo);
            ps.setInt(2, idFutbolista);
            ps.setInt(3, idPosicion);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.err);
            }
        }
        
    }

}
