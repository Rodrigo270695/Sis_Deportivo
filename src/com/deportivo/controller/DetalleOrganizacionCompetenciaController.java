package com.deportivo.controller;

import com.deportivo.model.Competencia;
import com.deportivo.model.DetalleOrganizacionCompetencia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import org.postgresql.util.PSQLException;

public class DetalleOrganizacionCompetenciaController {

    PaisController paisC = new PaisController();
    CompetenciaController competenciaC = new CompetenciaController();

    Conexion estado = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    public DetalleOrganizacionCompetencia listar(int id) {

        DetalleOrganizacionCompetencia detalleCom = new DetalleOrganizacionCompetencia();
        List paises = new ArrayList<>();
        sql = "select * from detalle_organizacion_competencia where competencia_id = " + id;

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                detalleCom.setCompetencia((Competencia) competenciaC.obtenerdato(rs.getInt(1)));
                paises.add(paisC.obtenerdato(rs.getInt(2)));
            }
            detalleCom.setPais(paises);

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

        return detalleCom;
    }

    public void registrarDetalleOrganizacionCompetencia(int idPais, int idCompetencia) throws Exception {

        sql = "insert into detalle_organizacion_competencia(pais_id,competencia_id) values(?,?) ";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idPais);
            ps.setInt(2, idCompetencia);
            ps.executeUpdate();

        } catch (PSQLException pe) {
            throw new Exception("Ya existe el Detalle Competencia");
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

    public void eliminarDetalle(int idPais, int idCompetencia) {

        sql = "delete from detalle_organizacion_competencia where pais_id =? and competencia_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idPais);
            ps.setInt(2, idCompetencia);
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
