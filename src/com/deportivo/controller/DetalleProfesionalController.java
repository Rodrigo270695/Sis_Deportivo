package com.deportivo.controller;

import com.deportivo.interfac.CRUD;
import com.deportivo.model.DetalleProfesional;
import com.deportivo.model.Profesional;
import com.deportivo.model.TipoProfesional;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import org.postgresql.util.PSQLException;

public class DetalleProfesionalController implements CRUD {

    ProfesionalController profesionalC = new ProfesionalController();
    TipoProfesionalController tipoP = new TipoProfesionalController();

    Conexion estado = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    @Override
    public List listar() {

        List lista = new ArrayList();
        sql = "SELECT * FROM detalle_profesional ORDER BY profesional_id DESC";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                DetalleProfesional detallePro = new DetalleProfesional();
                detallePro.setProfesional((Profesional) profesionalC.obtenerdato(rs.getInt(1)));
                detallePro.setTipoProfesional((TipoProfesional) tipoP.obtenerdato(rs.getInt(2)));
                lista.add(detallePro);
            }

        } catch (SQLException e) {
            e.printStackTrace(System.err);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.err);
            }
        }

        return lista;

    }

    @Override
    public void registrar(Object obj) throws Exception {

        DetalleProfesional detallePro = (DetalleProfesional) obj;
        sql = "INSERT INTO detalle_profesional(profesional_id, tipo_profesional_id) VALUES(?,?)";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);

            ps.setInt(1, detallePro.getProfesional().getProfesional_id());
            ps.setInt(2, detallePro.getTipoProfesional().getTipoProfesionalId());
            ps.executeUpdate();

        } catch (PSQLException pe) {
            throw new Exception("Ya existe el Detalle de Profesional");
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.err);
            }
        }

    }

    @Override
    public void modificar(Object obj) throws Exception {

        DetalleProfesional detallePro = (DetalleProfesional) obj;
        sql = "UPDATE detalle_profesional SET tipo_profesional_id=? WHERE profesional_id=?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, detallePro.getTipoProfesional().getTipoProfesionalId());
            ps.setInt(2, detallePro.getProfesional().getProfesional_id());
            ps.executeUpdate();

        } catch (PSQLException pe) {
            throw new Exception("Ya existe el Detalle de Profesional");
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.err);
            }
        }

    }

    @Override
    public void eliminar(int id) throws Exception {

        sql = "DELETE FROM detalle_profesional WHERE profesional_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (PSQLException pe) {
            pe.printStackTrace(System.err);
            throw new Exception("El detalle de profesional no se puede eliminar, porque está siendo USADO");
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.err);
            }
        }

    }

    @Override
    public Object obtenerdato(int id) {

        DetalleProfesional detallePro = new DetalleProfesional();
        sql = "SELECT * FROM detalle_profesional WHERE profesional_id = " + id;

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {

                detallePro.setProfesional((Profesional) profesionalC.obtenerdato(rs.getInt(1)));
                detallePro.setTipoProfesional((TipoProfesional) tipoP.obtenerdato(rs.getInt(2)));
            }

        } catch (SQLException e) {
            e.printStackTrace(System.err);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.err);
            }
        }

        return detallePro;

    }

    @Override
    public List buscar(Object obj) {

        List lista = new ArrayList();
        sql = "select pro.nombre_completo , tipo.nombre from detalle_profesional as de inner join \n"
                + "profesional as pro on de.profesional_id = pro.profesional_id\n"
                + "inner join tipo_profesional as tipo on de.tipo_profesional_id= tipo.tipo_profesional_id\n"
                + "where pro.nombre_completo LIKE '%" + obj + "%'\n"
                + "OR tipo.nombre LIKE '%" + obj + "%'";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                DetalleProfesional detallePro = new DetalleProfesional();
                detallePro.setProfesional((Profesional) profesionalC.obtenerdato(rs.getInt(1)));
                detallePro.setTipoProfesional((TipoProfesional) tipoP.obtenerdato(rs.getInt(2)));
                lista.add(detallePro);
            }

        } catch (SQLException e) {
            e.printStackTrace(System.err);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.err);
            }
        }

        return lista;

    }

//    public Object obtenerdato(String nombre) {
//
//        DetalleProfesional detallePro = new DetalleProfesional();
//        sql = "SELECT * FROM detalle_profesional WHERE nombre = '" + nombre + "'";
//
//        try {
//
//            con = estado.conectar();
//            ps = con.prepareStatement(sql);
//            rs = ps.executeQuery();
//
//            if (rs.next()) {
//                pais.setPaisId(rs.getInt(1));
//                pais.setNombre(rs.getString(2));
//                pais.setAbreviatura(rs.getString(3));
//                pais.setContinente((Continente) continenteC.obtenerdato(rs.getInt(4)));
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace(System.err);
//        } finally {
//            try {
//                if (con != null) {
//                    con.close();
//                }
//                if (ps != null) {
//                    ps.close();
//                }
//                if (rs != null) {
//                    rs.close();
//                }
//            } catch (SQLException ex) {
//                ex.printStackTrace(System.err);
//            }
//        }
//
//        return pais;
//
//    }

}
