package com.deportivo.controller.reporte;

import com.deportivo.controller.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Reporte_nueve {

    Conexion estado = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    public ResultSet valorPlantillaEquipo( String equipo) {

        sql = "select sum(fut.valor_mercado) as valor_plantilla from futbolista as fut inner join detalle_equipo as deta on fut.futbolista_id = deta.futbolista_id\n"
                + "inner join equipo as equi on deta.equipo_id = equi.equipo_id\n"
                + "where equi.nombre_corto='"+equipo+"' ";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace(System.err);
        } finally {
//            try {
//                con.close();
//                ps.close();
//                rs.close();
//            } catch (SQLException ex) {
//                ex.printStackTrace(System.err);
//            }
        }

        return rs;

    }

}
