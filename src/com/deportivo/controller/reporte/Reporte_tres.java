package com.deportivo.controller.reporte;

import com.deportivo.controller.Conexion;
import java.sql.*;

public class Reporte_tres {

    Conexion estado = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    public ResultSet listarEquiposCompetencia(String competencia) {

        sql = "select equi.nombre_corto from detalle_competencia_equipo as deta \n"
                + "inner join competencia as com on deta.competencia_id = com.competencia_id\n"
                + "inner join equipo as equi on deta.equipo_id = equi.equipo_id\n"
                + "where com.nombre='" + competencia + "';";

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
