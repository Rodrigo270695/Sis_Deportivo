package com.deportivo.controller;

import com.deportivo.interfac.CRUD;
import com.deportivo.model.Continente;
import com.deportivo.model.Pais;
import java.sql.*;
import java.util.*;
import org.postgresql.util.PSQLException;

public class PaisController implements CRUD {

    ContinenteController continenteC = new ContinenteController();
    Conexion estado = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    @Override
    public List listar() {

        List lista = new ArrayList();
        sql = "SELECT * FROM pais ORDER BY pais_id DESC";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Pais pais = new Pais();
                pais.setPaisId(rs.getInt(1));
                pais.setNombre(rs.getString(2));
                pais.setAbreviatura(rs.getString(3));
                pais.setContinente((Continente) continenteC.obtenerdato(rs.getInt(4)));
                lista.add(pais);
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

        Pais pais = (Pais) obj;
        sql = "INSERT INTO pais(nombre, codigo_iso, continente_id) VALUES(?,?,?)";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, pais.getNombre());
            ps.setString(2, pais.getAbreviatura());
            ps.setInt(3, pais.getContinente().getContinenteId());
            ps.executeUpdate();

        } catch (PSQLException pe) {
            throw new Exception("Ya existe el País");
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

        Pais pais = (Pais) obj;
        sql = "UPDATE pais SET nombre=?, codigo_iso=?, continente_id=? WHERE pais_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, pais.getNombre());
            ps.setString(2, pais.getAbreviatura());
            ps.setInt(3, pais.getContinente().getContinenteId());
            ps.setInt(4, pais.getPaisId());
            ps.executeUpdate();

        } catch (PSQLException pe) {
            throw new Exception("Ya existe el País");
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
        
        sql = "DELETE FROM pais WHERE pais_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (PSQLException pe) {
            pe.printStackTrace(System.err);
            throw new Exception("El PAÍS no se puede eliminar, porque está siendo USADO");
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

        Pais pais = new Pais();
        sql = "SELECT * FROM pais WHERE pais_id = " + id;

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                pais.setPaisId(rs.getInt(1));
                pais.setNombre(rs.getString(2));
                pais.setAbreviatura(rs.getString(3));
                pais.setContinente((Continente) continenteC.obtenerdato(rs.getInt(4)));
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

        return pais;

    }

    @Override
    public List buscar(Object obj) {

        List lista = new ArrayList();
        sql = "SELECT pa.pais_id, pa.nombre, pa.codigo_iso, pa.continente_id FROM pais pa\n "
                + "INNER JOIN continente co ON pa.continente_id = co.continente_id\n "
                + "WHERE pa.nombre LIKE '%"+obj+"%' \n"
                + "OR pa.codigo_iso LIKE '%"+obj+"%' \n"
                + "OR co.nombre LIKE '%"+obj+"%'";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Pais pais = new Pais();
                pais.setPaisId(rs.getInt(1));
                pais.setNombre(rs.getString(2));
                pais.setAbreviatura(rs.getString(3));
                pais.setContinente((Continente) continenteC.obtenerdato(rs.getInt(4)));
                lista.add(pais);
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

        Pais pais = new Pais();
        sql = "SELECT * FROM pais WHERE nombre = '"+nombre+"'";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                pais.setPaisId(rs.getInt(1));
                pais.setNombre(rs.getString(2));
                pais.setAbreviatura(rs.getString(3));
                pais.setContinente((Continente) continenteC.obtenerdato(rs.getInt(4)));
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

        return pais;

    }

}
