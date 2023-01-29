
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
    
    public ResultSet listarGrupos(String nombre) {

        sql = "select equi.nombre_corto as equipo, deta.pj, deta.g,deta.e,deta.p,deta.gf,deta.gc,deta.df,deta.pts from detalle_grupo as deta inner join equipo as equi on deta.equipo_id = equi.equipo_id\n"
                + "inner join grupo as gru on deta.grupo_id=gru.grupo_id\n"
                + "where gru.abreviatura='"+nombre+"'\n"
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
