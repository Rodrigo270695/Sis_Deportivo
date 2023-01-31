package com.deportivo.controller.reporte;

import com.deportivo.controller.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Reporte_siete {

    Conexion estado = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    public ResultSet listarPartidosPorJornada(String jornada) {

        sql = "select pa.partido_id , equi.nombre_corto as equipo, es.nombre_oficial as estadio from partido as pa inner join jornada as jor on pa.jornada_id=jor.jornada_id\n"
                + "inner join detalle_partido as deta on pa.partido_id=deta.partido_id\n"
                + "inner join equipo as equi on deta.equipo_id=equi.equipo_id\n"
                + "inner join estadio as es on pa.estadio_id=es.estadio_id\n"
                + "where jor.nombre_jornada='" + jornada + "'\n"
                + "group by deta.partido_id, equi.nombre_corto, es.nombre_oficial,pa.partido_id;";

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
