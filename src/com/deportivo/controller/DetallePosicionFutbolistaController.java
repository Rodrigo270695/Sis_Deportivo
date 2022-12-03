package com.deportivo.controller;

import com.deportivo.model.DetallePosicionFutbolista;
import com.deportivo.model.Futbolista;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import org.postgresql.util.PSQLException;

public class DetallePosicionFutbolistaController {

    FutbolistaController futbolistaC = new FutbolistaController();
    PosicionController posicionC = new PosicionController();

    Conexion estado = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    public DetallePosicionFutbolista listar(int id) {

        DetallePosicionFutbolista detalleP = new DetallePosicionFutbolista();
        List tipos = new ArrayList<>();
        sql = "select * from detalle_posicion_futbolista where futbolista_id = " + id;

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                detalleP.setFutbolista((Futbolista) futbolistaC.obtenerdato(rs.getInt(1)));
                tipos.add(posicionC.obtenerdato(rs.getInt(2)));
            }
            detalleP.setPosicionFutbolista(tipos);

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

        return detalleP;
    }

    public void registrarDetalle(int idFutbolista, int idPosicion) throws Exception {

        sql = "insert into detalle_posicion_futbolista(futbolista_id,posicion_id) values(?,?) ";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idFutbolista);
            ps.setInt(2, idPosicion);
            ps.executeUpdate();

        } catch (PSQLException pe) {
            throw new Exception("Ya existe la Posición para el futbolista");
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
            } catch (SQLException ex) {
                ex.printStackTrace(System.err);
            }
        }
    }
    
    
      public void eliminarDetalle(int idProfesional, int idTipo){
        
        sql = "delete from detalle_posicion_futbolista where futbolista_id =? and posicion_id = ?";
        
        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idProfesional);
            ps.setInt(2, idTipo);
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
