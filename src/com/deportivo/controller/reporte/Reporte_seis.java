package com.deportivo.controller.reporte;

import com.deportivo.controller.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Reporte_seis {

    Conexion estado = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    public ResultSet listarPosicionesFutbolistaPorEquipo(String futbolista, String equipo) {

        sql = "select pos.descripcion as posicion from detalle_equipo as det\n"
                + "inner join futbolista as fut on fut.futbolista_id = det.futbolista_id\n"
                + "inner join equipo as equ on equ.equipo_id = det.equipo_id\n"
                + "inner join posicion as pos on pos.posicion_id = det.posicion_id\n"
                + "where fut.nombre_completo = '" + futbolista + "' and equ.nombre_corto='" + equipo + "';";

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
