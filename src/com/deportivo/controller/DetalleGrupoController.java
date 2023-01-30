package com.deportivo.controller;

import com.deportivo.model.DetalleGrupo;
import com.deportivo.model.Equipo;
import com.deportivo.model.Grupo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import org.postgresql.util.PSQLException;

public class DetalleGrupoController {

    EquipoController equipoC = new EquipoController();
    GrupoController grupoC = new GrupoController();
    FormacionEquipoController formacionC = new FormacionEquipoController();
    Conexion estado = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    public List listar(int id) {

        List lista = new ArrayList<>();
        sql = "select * from detalle_grupo where grupo_id= " + id;

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                DetalleGrupo detalleG = new DetalleGrupo();
                detalleG.setGrupo((Grupo) grupoC.obtenerdato(rs.getInt(1)));
                detalleG.setEquipo((Equipo) equipoC.obtenerdato(rs.getInt(2)));
                detalleG.setPj(rs.getShort(3));
                detalleG.setG(rs.getShort(4));
                detalleG.setE(rs.getShort(5));
                detalleG.setP(rs.getShort(6));
                detalleG.setGf(rs.getShort(7));
                detalleG.setGc(rs.getShort(8));
                detalleG.setDf(rs.getShort(9));
                detalleG.setPts(rs.getShort(10));
                lista.add(detalleG);
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

    public void registrarDetalle(int idGrupo, int idEquipo) throws Exception {

        sql = "insert into detalle_grupo(grupo_id,equipo_id) values(?,?) ";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idGrupo);
            ps.setInt(2, idEquipo);
            ps.executeUpdate();

        } catch (PSQLException pe) {
            throw new Exception("Ya existe el equipo del grupo");
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

    public List listar() {

        List lista = new ArrayList<>();
        sql = "select * from detalle_grupo";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                DetalleGrupo detalleG = new DetalleGrupo();
                detalleG.setGrupo((Grupo) grupoC.obtenerdato(rs.getInt(1)));
                detalleG.setEquipo((Equipo) equipoC.obtenerdato(rs.getInt(2)));
                detalleG.setPj(rs.getShort(3));
                detalleG.setG(rs.getShort(4));
                detalleG.setE(rs.getShort(5));
                detalleG.setP(rs.getShort(6));
                detalleG.setGf(rs.getShort(7));
                detalleG.setGc(rs.getShort(8));
                detalleG.setDf(rs.getShort(9));
                detalleG.setPts(rs.getShort(10));
                lista.add(detalleG);
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

    public DetalleGrupo listarEquipoGrupo(String nombre) {

        DetalleGrupo detalleG = new DetalleGrupo();
        sql = "select detg.grupo_id,detg.equipo_id,detg.pj,detg.g,detg.e,detg.p,detg.gf,detg.gc,detg.df,detg.pts \n"
                + "from detalle_grupo detg\n"
                + "inner join equipo equi on equi.equipo_id = detg.equipo_id\n"
                + "where equi.nombre_corto =  '"+nombre+"'";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {

                detalleG.setGrupo((Grupo) grupoC.obtenerdato(rs.getInt(1)));
                detalleG.setEquipo((Equipo) equipoC.obtenerdato(rs.getInt(2)));
                detalleG.setPj(rs.getShort(3));
                detalleG.setG(rs.getShort(4));
                detalleG.setE(rs.getShort(5));
                detalleG.setP(rs.getShort(6));
                detalleG.setGf(rs.getShort(7));
                detalleG.setGc(rs.getShort(8));
                detalleG.setDf(rs.getShort(9));
                detalleG.setPts(rs.getShort(10));
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

        return detalleG;

    }

    public void actualizarDetalle(DetalleGrupo detalleGrupo){
        
        sql = "update detalle_grupo set pj=?,g=?,e=?,p=?,"
                + "gf=?,gc=?,df=?,pts=? "
                + "where equipo_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, detalleGrupo.getPj());
            ps.setInt(2, detalleGrupo.getG());
            ps.setInt(3, detalleGrupo.getE());
            ps.setInt(4, detalleGrupo.getP());
            ps.setInt(5, detalleGrupo.getGf());
            ps.setInt(6, detalleGrupo.getGc());
            ps.setInt(7, detalleGrupo.getDf());
            ps.setInt(8, detalleGrupo.getPts());
            ps.setInt(9, detalleGrupo.getEquipo().getEquipoId());
            ps.executeUpdate();

        }  catch (SQLException e) {
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
