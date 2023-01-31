package com.deportivo.controller.reporte;

import com.deportivo.controller.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Reporte_dos {

    Conexion estado = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    public ResultSet listarGoleadores(String nombre) {

        sql = "select equ.nombre_corto, fut.nombre_corto as futbolista, count(eve.nombre) as goles_anotados from incidencia_partido as inci \n"
                + "inner join evento as eve on inci.evento_id = eve.evento_id\n"
                + "inner join futbolista as fut on inci.futbolista_id = fut.futbolista_id\n"
                + "inner join detalle_equipo deq on deq.futbolista_id = fut.futbolista_id\n"
                + "inner join equipo equ on equ.equipo_id = deq.equipo_id\n"
                + "where eve.nombre='"+nombre+"' group by eve.nombre, equ.nombre_corto, fut.nombre_corto\n"
                + "order by count(eve.nombre) desc limit 5";

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
