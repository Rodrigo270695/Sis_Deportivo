package com.deportivo.controller.reporte;

import com.deportivo.controller.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Reporte_cuatro {

    Conexion estado = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    public ResultSet listarEquiposPorCompetencia(String grupo, String competencia) {

        sql = "select equi.nombre_corto as equipo from grupo as gru\n"
                + "inner join detalle_grupo as det on det.grupo_id = gru.grupo_id\n"
                + "inner join equipo as equi on equi.equipo_id = det.equipo_id\n"
                + "inner join detalle_competencia_equipo as com on equi.equipo_id = com.equipo_id\n"
                + "inner join competencia as cp on com.competencia_id = cp.competencia_id\n"
                + "where gru.abreviatura='"+grupo+"' and cp.nombre='"+competencia+"'";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace(System.err);
        } 
//        finally {
////            try {
////                con.close();
////                ps.close();
////                rs.close();
////            } catch (SQLException ex) {
////                ex.printStackTrace(System.err);
////            }
//        }

        return rs;

    }

}
