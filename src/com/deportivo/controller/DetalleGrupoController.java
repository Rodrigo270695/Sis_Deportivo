package com.deportivo.controller;

import com.deportivo.model.DetalleGrupo;
import com.deportivo.model.Grupo;
import com.deportivo.model.Equipo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import org.postgresql.util.PSQLException;

public class DetalleGrupoController {

    GrupoController grupoC = new GrupoController();
    EquipoController equipoC = new EquipoController();

    Conexion estado = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    public DetalleGrupo listar(int id) {

        DetalleGrupo detalleG = new DetalleGrupo();
        List equipos = new ArrayList<>();
        sql = "select * from detalle_grupo where grupo_id = " + id;

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                detalleG.setGrupo((Grupo) grupoC.obtenerdato(rs.getInt(1)));
                equipos.add(equipoC.obtenerdato(rs.getInt(2)));
                detalleG.setPartidos_jugados(rs.getInt(3));
                detalleG.setPartidos_ganados(rs.getInt(4));
                detalleG.setPartidos_empatados(rs.getInt(5));
                detalleG.setPartidos_perdidos(rs.getInt(6));
                detalleG.setGoles_favor(rs.getInt(7));
                detalleG.setGoles_contra(rs.getInt(8));
                detalleG.setDiferencia_goles(rs.getInt(9));
                detalleG.setPuntos(rs.getInt(10));
            }
            detalleG.setEquipo(equipos);

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

        return detalleG;
    }

    public void registrarDetalle(int idGrupo, int idEquipo, int partidos_jugados, int partidos_ganados, int partidos_empatados, int partidos_perdidos,
            int goles_favor, int goles_contra, int diferencia_goles, int puntos) throws Exception {

        sql = "insert into detalle_grupo(grupo_id,equipo_id,pj,g,e,p,gf,gc,df,pts) values(?,?,?,?,?,?,?,?,?,?) ";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idGrupo);
            ps.setInt(2, idEquipo);
            ps.setInt(3, partidos_jugados);
            ps.setInt(4, partidos_ganados);
            ps.setInt(5, partidos_empatados);
            ps.setInt(6, partidos_perdidos);
            ps.setInt(7, goles_favor);
            ps.setInt(8, goles_contra);
            ps.setInt(9, diferencia_goles);
            ps.setInt(10, puntos);
            ps.executeUpdate();

        } catch (PSQLException pe) {
            throw new Exception("Ya existe el Detalle para el grupo");
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

    public void eliminarDetalle(int idGrupo, int idEquipo) {

        sql = "delete from detalle_grupo where grupo_id =? and equipo_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idGrupo);
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
