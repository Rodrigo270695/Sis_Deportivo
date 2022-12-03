package com.deportivo.controller;

import com.deportivo.model.DetalleCategoriaArbitro;
import com.deportivo.model.Arbitro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import org.postgresql.util.PSQLException;

public class DetalleCategoriaArbitroController {

    ArbitroController arbitroC = new ArbitroController();
    CategoriaArbitroController tipoP = new CategoriaArbitroController();

    Conexion estado = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    public DetalleCategoriaArbitro listar(int id) {

        DetalleCategoriaArbitro detalleP = new DetalleCategoriaArbitro();
        List tipos = new ArrayList<>();
        sql = "select * from detalle_categoria_arbitro where arbitro_id= " + id;

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                detalleP.setArbitro((Arbitro) arbitroC.obtenerdato(rs.getInt(1)));
                tipos.add(tipoP.obtenerdato(rs.getInt(2)));
            }
            detalleP.setTipoCategoriaArbitro(tipos);

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

        sql = "insert into detalle_categoria_arbitro(arbitro_id,categoria_arbitro_id) values(?,?) ";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idProfesional);
            ps.setInt(2, idTipo);
            ps.executeUpdate();

        } catch (PSQLException pe) {
            throw new Exception("Ya existe el Tipo para el arbitro");
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
        
        sql = "delete from detalle_categoria_arbitro where arbitro_id =? and categoria_arbitro_id = ?";
        
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
