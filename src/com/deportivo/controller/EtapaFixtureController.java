package com.deportivo.controller;

import com.deportivo.interfac.CRUD;
import com.deportivo.model.EtapaFixture;
import com.deportivo.model.Fixture;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.postgresql.util.PSQLException;

public class EtapaFixtureController implements CRUD {

    FixtureController fixtureC = new FixtureController();
    Conexion estado = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    @Override
    public List listar() {

        List lista = new ArrayList();
        sql = "SELECT * FROM etapa_fixture ORDER BY etapa_fixture_id DESC";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                EtapaFixture etapaFix = new EtapaFixture();
                etapaFix.setEtapa_fixture_id(rs.getInt(1));
                etapaFix.setDescripcion(rs.getString(2));
                etapaFix.setFixtureId((Fixture) fixtureC.obtenerdato(rs.getInt(3)));
                lista.add(etapaFix);
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

        EtapaFixture etapaFix = (EtapaFixture) obj;
        sql = "INSERT INTO etapa_fixture(descripcion, fixture_id) VALUES(?,?)";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, etapaFix.getDescripcion());
            ps.setInt(2, etapaFix.getFixtureId().getFixture_id());
            ps.executeUpdate();

        } catch (PSQLException pe) {
            throw new Exception("Ya existe la Etapa Fixture");
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

        EtapaFixture etapaFix = (EtapaFixture) obj;
        sql = "UPDATE etapa_fixture SET descripcion=?, fixture_id=? WHERE etapa_fixture_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, etapaFix.getDescripcion());
            ps.setInt(2, etapaFix.getFixtureId().getFixture_id());
            ps.setInt(3, etapaFix.getEtapa_fixture_id());
            ps.executeUpdate();

        } catch (PSQLException pe) {
            throw new Exception("Ya existe la Etapa Fixture");
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

        sql = "DELETE FROM etapa_fixture WHERE etapa_fixture_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (PSQLException pe) {
            pe.printStackTrace(System.err);
            throw new Exception("La Etapa Fixture no se puede eliminar, porque está siendo USADO");
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

        EtapaFixture etapaFix = new EtapaFixture();
        sql = "SELECT * FROM etapa_fixture WHERE etapa_fixture_id = " + id;

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                etapaFix.setEtapa_fixture_id(rs.getInt(1));
                etapaFix.setDescripcion(rs.getString(2));
                etapaFix.setFixtureId((Fixture) fixtureC.obtenerdato(rs.getInt(3)));
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

        return etapaFix;

    }

    @Override
    public List buscar(Object obj) {

        List lista = new ArrayList();
        sql = "select eta.etapa_fixture_id, eta.descripcion, fix.fixture_id  \n"
                + "from etapa_fixture as eta "
                + "inner join fixture as fix on eta.fixture_id= fix.fixture_id\n"
                + "where eta.descripcion LIKE '%" + obj + "%'";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                EtapaFixture etapaFix = new EtapaFixture();
                etapaFix.setEtapa_fixture_id(rs.getInt(1));
                etapaFix.setDescripcion(rs.getString(2));
                etapaFix.setFixtureId((Fixture) fixtureC.obtenerdato(rs.getInt(3)));
                lista.add(etapaFix);
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

        EtapaFixture etapaFix = new EtapaFixture();
        sql = "SELECT * FROM etapa_fixture_id WHERE descripcion = '" + nombre + "'";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                etapaFix.setEtapa_fixture_id(rs.getInt(1));
                etapaFix.setDescripcion(rs.getString(2));
                etapaFix.setFixtureId((Fixture) fixtureC.obtenerdato(rs.getInt(3)));
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

        return etapaFix;

    }

}
