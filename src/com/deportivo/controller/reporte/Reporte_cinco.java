package com.deportivo.controller.reporte;

import com.deportivo.controller.Conexion;
import java.sql.*;

public class Reporte_cinco {

    Conexion estado = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    public ResultSet listarPais(String pais) {

        sql = "select fut.nombre_completo as nombre, pai.nombre as pais from detalle_pais_futbolista as det\n" +
                "inner join futbolista as fut on fut.futbolista_id = det.futbolista_id\n" +
                "inner join pais as pai on pai.pais_id = det.pais_id\n" +
                "where pai.nombre ='" + pais + "';";

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
