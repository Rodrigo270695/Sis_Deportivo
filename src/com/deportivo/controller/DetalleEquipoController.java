package com.deportivo.controller;

import com.deportivo.model.DetalleEquipo;
import com.deportivo.model.Equipo;
import com.deportivo.model.Futbolista;
import com.deportivo.model.Posicion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import org.postgresql.util.PSQLException;

public class DetalleEquipoController {

    EquipoController equipoC = new EquipoController();
    FutbolistaController futbolistaC = new FutbolistaController();
    PosicionController posicionC = new PosicionController();
    Conexion estado = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    public List listar(int id) {

        List lista = new ArrayList<>();
        sql = "select * from detalle_equipo where equipo_id= " + id;

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                DetalleEquipo detalle = new DetalleEquipo();
                detalle.setEquipo((Equipo) equipoC.obtenerdato(rs.getInt(1)));
                detalle.setFutbolista((Futbolista) futbolistaC.obtenerdato(rs.getInt(2)));
                detalle.setPosicion((Posicion) posicionC.obtenerdato(rs.getInt(3)));
                
                lista.add(detalle);
                
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

        return lista;
    }

    public void registrarDetalle(int idEquipo, int idFutbolista,int idPosicion) throws Exception {

        sql = "insert into detalle_equipo(equipo_id,futbolista_id, posicion_id) values(?,?,?) ";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idEquipo);
            ps.setInt(2, idFutbolista);
            ps.setInt(3, idPosicion);
            ps.executeUpdate();

        } catch (PSQLException pe) {
            pe.printStackTrace(System.err);
            throw new Exception("Ya existe el Tipo para el equipo");
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

    public void eliminarDetalle(int idEquipo, int idFutbolista){
        
        sql = "delete from detalle_equipo where equipo_id =? and futbolista_id = ?";
        
        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idEquipo);
            ps.setInt(2, idFutbolista);
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
