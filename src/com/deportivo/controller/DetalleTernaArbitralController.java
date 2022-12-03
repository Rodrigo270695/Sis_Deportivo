package com.deportivo.controller;

import com.deportivo.interfac.CRUD;
import com.deportivo.model.DetalleTernaArbitral;
import com.deportivo.model.TernaArbitral;
import com.deportivo.model.TipoTernaArbitral;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import org.postgresql.util.PSQLException;

public class DetalleTernaArbitralController {

    ProfesionalController profesionalC = new ProfesionalController();
    TipoProfesionalController tipoP = new TipoProfesionalController();

    Conexion estado = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    public DetalleTernaArbitral listar(int id) {

        DetalleTernaArbitral detalleP = new DetalleTernaArbitral();
        List tipos = new ArrayList<>();
        sql = "select * from detalle_terna_arbitral where terna_arbitral_id = " + id;

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                detalleP.setTernaArbitral((TernaArbitral) profesionalC.obtenerdato(rs.getInt(1)));
                tipos.add(tipoP.obtenerdato(rs.getInt(2)));
            }
            detalleP.setTipoTernaArbitral(tipos);

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

    public void registrarDetalle(int idProfesional, int idTipo) throws Exception {

        sql = "insert into detalle_terna_arbitral(terna_arbitral_id,tipo_terna_arbitral_id) values(?,?) ";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idProfesional);
            ps.setInt(2, idTipo);
            ps.executeUpdate();

        } catch (PSQLException pe) {
            throw new Exception("Ya existe el Tipo para el tipo de terna arbitral");
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

    public void eliminarDetalle(int idProfesional, int idTipo){
        
        sql = "delete from detalle_terna_arbitral where terna_arbitral_id =? and tipo_terna_arbitral_id = ?";
        
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
