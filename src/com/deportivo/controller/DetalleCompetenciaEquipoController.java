package com.deportivo.controller;

import com.deportivo.model.Competencia;
import com.deportivo.model.DetalleCompetenciaEquipo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import org.postgresql.util.PSQLException;

public class DetalleCompetenciaEquipoController {

    EquipoController equipoC = new EquipoController();
    CompetenciaController competenciaC = new CompetenciaController();

    Conexion estado = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    public DetalleCompetenciaEquipo listar(int id) {

        DetalleCompetenciaEquipo detalleP = new DetalleCompetenciaEquipo();
        List equipos = new ArrayList<>();
        sql = "select * from detalle_competencia_equipo where competencia_id = " + id;

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                detalleP.setCompetencia((Competencia) competenciaC.obtenerdato(rs.getInt(1)));
                equipos.add(equipoC.obtenerdato(rs.getInt(2)));

            }
            detalleP.setEquipo(equipos);

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

    public void registrarDetalle(int idCompetencia, int idEquipo) throws Exception {

        sql = "insert into detalle_competencia_equipo(competencia_id, equipo_id) values(?,?) ";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idCompetencia);
            ps.setInt(2, idEquipo);
            ps.executeUpdate();

        } catch (PSQLException pe) {
            throw new Exception("Ya existe el Equipo para la competencia");
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

    public void eliminarDetalle( int idCompetencia, int idEquipo) {

        sql = "delete from detalle_competencia_equipo where competencia_id = ? and equipo_id= ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idCompetencia);
            ps.setInt(2, idEquipo);
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
