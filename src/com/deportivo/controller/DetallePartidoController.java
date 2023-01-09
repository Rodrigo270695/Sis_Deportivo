package com.deportivo.controller;

import com.deportivo.model.DetallePartido;
import com.deportivo.model.Equipo;
import com.deportivo.model.FormacionEquipo;
import com.deportivo.model.Partido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import org.postgresql.util.PSQLException;

public class DetallePartidoController {

    EquipoController equipoC = new EquipoController();
    PartidoController partidoC = new PartidoController();
    FormacionEquipoController formacionC = new FormacionEquipoController();
    Conexion estado = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    public List listar(int id) {

        List lista = new ArrayList<>();
        sql = "select partido_id,equipo_id,tipo,formacion_id from detalle_partido where partido_id= " + id;

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                DetallePartido detalleP = new DetallePartido();
                detalleP.setPartido((Partido) partidoC.obtenerdato(rs.getInt(1)));
                detalleP.setEquipo((Equipo) equipoC.obtenerdato(rs.getInt(2)));
                detalleP.setTipo(rs.getString(3));
                detalleP.setFormacion((FormacionEquipo) formacionC.obtenerdato(rs.getInt(4)));
                lista.add(detalleP);
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

    public void registrarDetalle(int idPartido, int idEquipo, String tipo, int idFormacion) throws Exception {

        sql = "insert into detalle_partido(partido_id,equipo_id,tipo,formacion_id) values(?,?,?,?) ";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idPartido);
            ps.setInt(2, idEquipo);
            ps.setString(3, tipo);
            ps.setInt(4, idFormacion);
            ps.executeUpdate();

        } catch (PSQLException pe) {
            throw new Exception("Ya existe el equipo del partido");
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

    public void eliminarDetalle(int idPartido, int idEquipo) {

        sql = "delete from detalle_partido where partido_id =? and equipo_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idPartido);
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
        sql = "select partido_id,equipo_id,tipo,formacion_id from detalle_partido" ;

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                DetallePartido detalleP = new DetallePartido();
                detalleP.setPartido((Partido) partidoC.obtenerdato(rs.getInt(1)));
                detalleP.setEquipo((Equipo) equipoC.obtenerdato(rs.getInt(2)));
                detalleP.setTipo(rs.getString(3));
                detalleP.setFormacion((FormacionEquipo) formacionC.obtenerdato(rs.getInt(4)));
                lista.add(detalleP);
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
    
    public void actualizarDetalle(DetallePartido detallePartido){
        
        sql = "update detalle_partido set goles=?,numero_faltas=?,tarjetas_amarillas=?,tarjetas_rojas=?,"
                + "tiros=?,fuera_de_lugar=?,tiros_esquina=?,cambios=? "
                + "where partido_id =? and equipo_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, detallePartido.getGoles());
            ps.setInt(2, detallePartido.getFaltas());
            ps.setInt(3, detallePartido.getTarjetasAmarillas());
            ps.setInt(4, detallePartido.getTarjtetasRojas());
            ps.setInt(5, detallePartido.getTiros());
            ps.setInt(6, detallePartido.getFueraLugar());
            ps.setInt(7, detallePartido.getTirosEquina());
            ps.setString(8, detallePartido.getCambios());
            ps.setInt(9, detallePartido.getPartido().getPartidoId());
            ps.setInt(10, detallePartido.getEquipo().getEquipoId());
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
