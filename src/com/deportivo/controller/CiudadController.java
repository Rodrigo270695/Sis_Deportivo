package com.deportivo.controller;

import com.deportivo.interfac.CRUD;
import com.deportivo.model.Ciudad;
import com.deportivo.model.Pais;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import org.postgresql.util.PSQLException;

public class CiudadController implements CRUD {

    PaisController paisC = new PaisController();
    Conexion estado = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    @Override
    public List listar() {

        List lista = new ArrayList();
        sql = "SELECT * FROM ciudad ORDER BY ciudad_id DESC";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Ciudad ciudad = new Ciudad();
                ciudad.setCiudad_id(rs.getInt(1));
                ciudad.setNombre_completo(rs.getString(2));
                ciudad.setPais((Pais) paisC.obtenerdato(rs.getInt(3)));
                lista.add(ciudad);
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

        Ciudad ciudad = (Ciudad) obj;
        sql = "INSERT INTO ciudad(nombre_completo, pais_id) VALUES(?,?)";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, ciudad.getNombre_completo());
            ps.setInt(2, ciudad.getPais().getPaisId());

            ps.executeUpdate();

        } catch (PSQLException pe) {
            throw new Exception("Ya existe la Ciudad");
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

        Ciudad ciudad = (Ciudad) obj;
        sql = "UPDATE ciudad SET nombre_completo=?, pais_id=? WHERE ciudad_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, ciudad.getNombre_completo());
            ps.setInt(2, ciudad.getPais().getPaisId());
            ps.setInt(3, ciudad.getCiudad_id());
            ps.executeUpdate();

        } catch (PSQLException pe) {
            throw new Exception("Ya existe la ciudad");
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

        sql = "DELETE FROM ciudad WHERE ciudad_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (PSQLException pe) {
            pe.printStackTrace(System.err);
            throw new Exception("LA CIUDAD no se puede eliminar, porque está siendo USADO");
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

        Ciudad ciudad = new Ciudad();
        sql = "SELECT * FROM ciudad WHERE ciudad_id = " + id;

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                ciudad.setCiudad_id(rs.getInt(1));
                ciudad.setNombre_completo(rs.getString(2));
                ciudad.setPais((Pais) paisC.obtenerdato(rs.getInt(3)));
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

        return ciudad;

    }

    @Override
    public List buscar(Object obj) {

        List lista = new ArrayList();
        sql = "SELECT ciu.ciudad_id, ciu.nombre_completo,pa.nombre FROM ciudad ciu\n"
                + "INNER JOIN pais pa ON ciu.pais_id= pa.pais_id\n"
                + "WHERE ciu.nombre_completo LIKE '%" + obj + "%'; ";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Ciudad ciudad = new Ciudad();
                ciudad.setCiudad_id(rs.getInt(1));
                ciudad.setNombre_completo(rs.getString(2));
                ciudad.setPais((Pais) paisC.obtenerdato(rs.getString(3)));
                lista.add(ciudad);
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

    public Object obtenerdato(String nombre) {

        Ciudad ciudad = new Ciudad();
        sql = "SELECT * FROM ciudad WHERE nombre_completo = '" + nombre + "'";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                ciudad.setCiudad_id(rs.getInt(1));
                ciudad.setNombre_completo(rs.getString(2));
                ciudad.setPais((Pais) paisC.obtenerdato(rs.getInt(3)));
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

        return ciudad;

    }

}
