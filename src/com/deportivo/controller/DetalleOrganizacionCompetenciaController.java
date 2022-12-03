package com.deportivo.controller;

import com.deportivo.interfac.CRUD;
import com.deportivo.model.DetalleOrganizacionCompetencia;
import com.deportivo.model.Pais;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import org.postgresql.util.PSQLException;

public class DetalleOrganizacionCompetenciaController {

    PaisController profesionalC = new PaisController();
    CompetenciaController tipoP = new CompetenciaController();

    Conexion estado = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    public DetalleOrganizacionCompetencia listar(int id) {

        DetalleOrganizacionCompetencia detalleP = new DetalleOrganizacionCompetencia();
        List tipos = new ArrayList<>();
        sql = "select * from detalle_organizacion_competencia where pais_id = " + id;

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                detalleP.setPais((Pais) profesionalC.obtenerdato(rs.getInt(1)));
                tipos.add(tipoP.obtenerdato(rs.getInt(2)));
            }
            detalleP.setTipoCompetencia(tipos);

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

        sql = "insert into detalle_organizacion_competencia(pais_id,competencia_id) values(?,?) ";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idProfesional);
            ps.setInt(2, idTipo);
            ps.executeUpdate();

        } catch (PSQLException pe) {
            throw new Exception("Ya existe el Tipo para la organizacion competencia");
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

    public void eliminarDetalle(int idProfesional, int idTipo) {

        sql = "delete from detalle_organizacion_competencia where pais_id =? and competencia_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idProfesional);
            ps.setInt(2, idTipo);
            ps.executeUpdate();

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
}
