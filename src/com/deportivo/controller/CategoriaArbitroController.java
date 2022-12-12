package com.deportivo.controller;

import com.deportivo.interfac.CRUD;
import com.deportivo.model.CategoriaArbitro;
import com.deportivo.model.TipoTernaArbitral;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.postgresql.util.PSQLException;

public class CategoriaArbitroController implements CRUD {

    TipoTernaArbitralController tipoTA = new TipoTernaArbitralController();
    Conexion estado = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    @Override
    public List listar() {

        List lista = new ArrayList();
        sql = "SELECT * FROM categoria_arbitro ORDER BY categoria_arbitro_id DESC";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                CategoriaArbitro categoriaArbitro = new CategoriaArbitro();
                categoriaArbitro.setCategoria_arbitro_id(rs.getInt(1));
                categoriaArbitro.setNombre(rs.getString(2));
                categoriaArbitro.setSigla(rs.getString(3));
                categoriaArbitro.setTipoTA((TipoTernaArbitral) tipoTA.obtenerdato(rs.getInt(4)));
                lista.add(categoriaArbitro);
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

        CategoriaArbitro categoriaArbitro = (CategoriaArbitro) obj;
        sql = "INSERT INTO categoria_arbitro(nombre,sigla, tipo_terna_arbitral_id) VALUES(?,?,?)";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, categoriaArbitro.getNombre());
            ps.setString(2, categoriaArbitro.getSigla());
            ps.setInt(3, categoriaArbitro.getTipoTA().getTipo_terna_arbitral_id());

            ps.executeUpdate();

        } catch (PSQLException pe) {
            throw new Exception("Ya existe la Categoriade Arbitro");
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

        CategoriaArbitro categoriaArbitro = (CategoriaArbitro) obj;
        sql = "UPDATE categoria_arbitro SET nombre=?,sigla=?, tipo_terna_arbitral_id=? WHERE categoria_arbitro_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, categoriaArbitro.getNombre());
            ps.setString(2, categoriaArbitro.getSigla());
            ps.setInt(3, categoriaArbitro.getTipoTA().getTipo_terna_arbitral_id());
            ps.setInt(4, categoriaArbitro.getCategoria_arbitro_id());
            ps.executeUpdate();

        } catch (PSQLException pe) {
            throw new Exception("Ya existe la Categoria de Arbitro");
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

        sql = "DELETE FROM categoria_arbitro WHERE categoria_arbitro_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (PSQLException pe) {
            pe.printStackTrace(System.err);
            throw new Exception("La Categoría de Árbitro no se puede eliminar, porque está siendo USADO");
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

        CategoriaArbitro categoriaArbitro = new CategoriaArbitro();
        sql = "SELECT * FROM categoria_arbitro WHERE categoria_arbitro_id = " + id;

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                categoriaArbitro.setCategoria_arbitro_id(rs.getInt(1));
                categoriaArbitro.setNombre(rs.getString(2));
                categoriaArbitro.setSigla(rs.getString(3));
                categoriaArbitro.setTipoTA((TipoTernaArbitral) tipoTA.obtenerdato(rs.getInt(4)));
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

        return categoriaArbitro;

    }

    @Override
    public List buscar(Object obj) {

        List lista = new ArrayList();
        sql = "select ca.categoria_arbitro_id, ca.nombre, ca.sigla, tipo.descripcion \n"
                + "from categoria_arbitro as ca inner join tipo_terna_arbitral as tipo\n"
                + " on ca.tipo_terna_arbitral_id = tipo.tipo_terna_arbitral_id\n"
                + " where ca.nombre like '%" + obj + "%'OR ca.sigla like '%" + obj + "%' "
                + " or tipo.descripcion like '%" + obj + "%'";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                CategoriaArbitro categoriaArbitro = new CategoriaArbitro();
                categoriaArbitro.setCategoria_arbitro_id(rs.getInt(1));
                categoriaArbitro.setNombre(rs.getString(2));
                categoriaArbitro.setSigla(rs.getString(3));
                categoriaArbitro.setTipoTA((TipoTernaArbitral) tipoTA.obtenerdato(rs.getString(4)));
                lista.add(categoriaArbitro);
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

        CategoriaArbitro categoriaArbitro = new CategoriaArbitro();
        sql = "SELECT * FROM categoria_arbitro WHERE nombre = '" + nombre + "'";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                categoriaArbitro.setCategoria_arbitro_id(rs.getInt(1));
                categoriaArbitro.setNombre(rs.getString(2));
                categoriaArbitro.setSigla(rs.getString(3));
                categoriaArbitro.setTipoTA((TipoTernaArbitral) tipoTA.obtenerdato(rs.getInt(4)));
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

        return categoriaArbitro;

    }

}
