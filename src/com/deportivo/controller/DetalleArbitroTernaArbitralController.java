
package com.deportivo.controller;

import com.deportivo.model.DetalleArbitroTernaArbitral;
import com.deportivo.model.TernaArbitral;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.postgresql.util.PSQLException;

public class DetalleArbitroTernaArbitralController {
    
    ArbitroController arbitroC = new ArbitroController();
    TernaArbitralController ternaC = new TernaArbitralController();
    CategoriaArbitroController categoriaC = new CategoriaArbitroController();

    Conexion estado = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    public DetalleArbitroTernaArbitral listar(int id) {

        DetalleArbitroTernaArbitral detalleP = new DetalleArbitroTernaArbitral();
        List tipos = new ArrayList<>();
        List tipos2 = new ArrayList<>();
        sql = "select * from detalle_arbitro_terna_arbitral where terna_arbitral_id= " + id;

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                detalleP.setTernaArbitral((TernaArbitral) ternaC.obtenerdato(rs.getInt(2)));
                tipos.add(arbitroC.obtenerdato(rs.getInt(1)));
                tipos2.add(categoriaC.obtenerdato(rs.getInt(3)));

            }
            detalleP.setArbitro(tipos);
            detalleP.setCategoriaArbitro(tipos2);

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

    public void registrarDetalle(int idarbitro, int idTerna, int idcategoria) throws Exception {

        sql = "insert into detalle_arbitro_terna_arbitral(arbitro_id,terna_arbitral_id,categoria_arbitro_id) values(?,?,?) ";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idarbitro);
            ps.setInt(2, idTerna);
            ps.setInt(3, idcategoria);
            ps.executeUpdate();

        } catch (PSQLException pe) {
            pe.printStackTrace(System.err);
            throw new Exception("Ya existe el Detalle ");
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

    public void eliminarDetalle(int idarbitro, int idTerna, int idcategoria) {

        sql = "delete from detalle_arbitro_terna_arbitral where arbitro_id =? and terna_arbitral_id=? and categoria_arbitro_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idarbitro);
            ps.setInt(2, idTerna);
            ps.setInt(3, idcategoria);
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
