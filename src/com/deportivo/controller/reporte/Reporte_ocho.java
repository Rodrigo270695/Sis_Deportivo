package com.deportivo.controller.reporte;

import com.deportivo.controller.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Reporte_ocho {

    Conexion estado = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    public ResultSet listarEstadios() {

        sql = "select nombre_oficial, nombre_conocido, capacidad, ciu.nombre_completo as ciudad from estadio as es inner join ciudad as ciu on ciu.ciudad_id=es.ciudad_id;";

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
