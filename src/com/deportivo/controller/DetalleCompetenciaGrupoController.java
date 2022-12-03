package com.deportivo.controller;

import com.deportivo.interfac.CRUD;
import com.deportivo.model.DetalleCompetenciaGrupo;
import com.deportivo.model.Competencia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import org.postgresql.util.PSQLException;

public class DetalleCompetenciaGrupoController {

    CompetenciaController arbitroC = new CompetenciaController();
    GrupoController tipoP = new GrupoController();

    Conexion estado = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    public DetalleCompetenciaGrupo listar(int id) {

        DetalleCompetenciaGrupo detalleP = new DetalleCompetenciaGrupo();
        List tipos = new ArrayList<>();
        sql = "select * from detalle_competencia_grupo where competencia_id= " + id;

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                detalleP.setCompetencia((Competencia) arbitroC.obtenerdato(rs.getInt(1)));
                tipos.add(tipoP.obtenerdato(rs.getInt(2)));
            }
            detalleP.setTipoGrupo(tipos);

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

        sql = "insert into detalle_competencia_grupo(grupo_id,competencia_id) values(?,?) ";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idProfesional);
            ps.setInt(2, idTipo);
            ps.executeUpdate();

        } catch (PSQLException pe) {
            throw new Exception("Ya existe el grupo");
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
        
        sql = "delete from detalle_competencia_grupo where grupo_id =? and competencia_id = ?";
        
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
