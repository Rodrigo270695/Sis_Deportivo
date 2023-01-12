package com.deportivo.controller;

import com.deportivo.interfac.CRUD;
import com.deportivo.model.DetallePaisFutbolista;
import com.deportivo.model.DetalleProfesional;
import com.deportivo.model.Futbolista;
import com.deportivo.model.Profesional;
import com.deportivo.model.TipoProfesional;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import org.postgresql.util.PSQLException;

public class DetallePaisFutbolistaController {

    FutbolistaController futbolistalC = new FutbolistaController();
    PaisController tipoP = new PaisController();

    Conexion estado = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    public DetallePaisFutbolista listar(int id) {

        DetallePaisFutbolista detalleP = new DetallePaisFutbolista();
        List tipos = new ArrayList<>();
        sql = "select * from detalle_pais_futbolista where futbolista_id = " + id;

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                detalleP.setFutbolista((Futbolista) futbolistalC.obtenerdato(rs.getInt(1)));
                tipos.add(tipoP.obtenerdato(rs.getInt(2)));
            }
            detalleP.setPais(tipos);

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

    public void registrarDetalle(int futbolista_id, int pais_id) throws Exception {

        sql = "insert into detalle_pais_futbolista(futbolista_id,pais_id) values(?,?) ";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, futbolista_id);
            ps.setInt(2, pais_id);
            ps.executeUpdate();

        } catch (PSQLException pe) {
            throw new Exception("Ya existe el País para el futbolista");
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

    public void eliminarDetalle(int futbolista_id, int pais_id){
        
        sql = "delete from detalle_pais_futbolista where futbolista_id =? and pais_id = ?";
        
        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, futbolista_id);
            ps.setInt(2, pais_id);
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
