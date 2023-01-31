package com.deportivo.controller.reporte;

import com.deportivo.controller.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Reporte_uno {

    Conexion estado = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    public ResultSet listarGrupos(String nombre, String competencia) {

        sql = "select equi.nombre_corto as equipo, deta.pj, deta.g,deta.e,deta.p,deta.gf,deta.gc,deta.df,deta.pts from detalle_grupo as deta inner join equipo as equi on deta.equipo_id = equi.equipo_id\n"
                + "inner join grupo as gru on deta.grupo_id=gru.grupo_id\n"
                + "inner join equipo eq on eq.equipo_id = deta.equipo_id\n"
                + "inner join detalle_partido dp on dp.equipo_id = eq.equipo_id\n"
                + "inner join partido pa on pa.partido_id = dp.partido_id\n"
                + "inner join competencia co on co.competencia_id = pa.competencia_id\n"
                + "where gru.abreviatura= '"+nombre+"' and co.nombre = 'MUNDIAL DE FÚTBOL QATAR 2022'\n"
                + "order by pts DESC;";

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
