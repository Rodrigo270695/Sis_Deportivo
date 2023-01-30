package com.deportivo.controller;

import com.deportivo.interfac.CRUD;
import com.deportivo.model.Confederacion;
import com.deportivo.model.CuerpoTecnico;
import com.deportivo.model.Equipo;
import com.deportivo.model.Pais;
import java.sql.*;
import java.util.*;
import org.postgresql.util.PSQLException;

public class EquipoController implements CRUD {

    CuerpoTecnicoController cuerpoC = new CuerpoTecnicoController();
    ConfederacionController confederacionC = new ConfederacionController();
    PaisController paisC = new PaisController();
    Conexion estado = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    @Override
    public List listar() {

        List lista = new ArrayList();
        sql = "SELECT * FROM equipo ORDER BY equipo_id DESC";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Equipo equipo = new Equipo();
                equipo.setEquipoId(rs.getInt(1));
                equipo.setNombreOficial(rs.getString(2));
                equipo.setNombreCorto(rs.getString(3));
                equipo.setSeudonimo(rs.getString(4));
                equipo.setCodigoFifa(rs.getString(5));
                equipo.setFundacion(rs.getDate(6));
                equipo.setUbicacion(rs.getString(7));
                equipo.setNumSocios(rs.getInt(8));
                equipo.setNumTitulosGandos(rs.getInt(9));
                equipo.setParticipacionesCopas(rs.getInt(10));
                equipo.setNumFinalesJugadas(rs.getInt(11));
                equipo.setCuerpoTecnico((CuerpoTecnico) cuerpoC.obtenerdato(rs.getInt(12)));
                equipo.setConfederacion((Confederacion) confederacionC.obtenerdato(rs.getInt(13)));
                equipo.setPais((Pais) paisC.obtenerdato(rs.getInt(14)));
                equipo.setFoto(rs.getBinaryStream(15));
                lista.add(equipo);
            }

        } catch (SQLException e) {
            e.printStackTrace(System.err);
        } finally {
            try {
                con.close();
                ps.close();
                rs.close();
            } catch (SQLException ex) {
                ex.printStackTrace(System.err);
            }
        }

        return lista;

    }

    @Override
    public void eliminar(int id) throws Exception {

        sql = "DELETE FROM equipo WHERE equipo_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (PSQLException pe) {
            pe.printStackTrace(System.err);
            throw new Exception("El continente no se puede eliminar, porque está siendo USADO");
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        } finally {
            try {
                con.close();
                ps.close();
            } catch (SQLException ex) {
                ex.printStackTrace(System.err);
            }
        }

    }

    @Override
    public Object obtenerdato(int id) {

        Equipo equipo = new Equipo();
        sql = "SELECT * FROM equipo WHERE equipo_id = " + id;

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                equipo.setEquipoId(rs.getInt(1));
                equipo.setNombreOficial(rs.getString(2));
                equipo.setNombreCorto(rs.getString(3));
                equipo.setSeudonimo(rs.getString(4));
                equipo.setCodigoFifa(rs.getString(5));
                equipo.setFundacion(rs.getDate(6));
                equipo.setUbicacion(rs.getString(7));
                equipo.setNumSocios(rs.getInt(8));
                equipo.setNumTitulosGandos(rs.getInt(9));
                equipo.setParticipacionesCopas(rs.getInt(10));
                equipo.setNumFinalesJugadas(rs.getInt(11));
                equipo.setCuerpoTecnico((CuerpoTecnico) cuerpoC.obtenerdato(rs.getInt(12)));
                equipo.setConfederacion((Confederacion) confederacionC.obtenerdato(rs.getInt(13)));
                equipo.setPais((Pais) paisC.obtenerdato(rs.getInt(14)));
                equipo.setFoto(rs.getBinaryStream(15));
            }

        } catch (SQLException e) {
            e.printStackTrace(System.err);
        } finally {
            try {
                con.close();
                ps.close();
                rs.close();
            } catch (SQLException ex) {
                ex.printStackTrace(System.err);
            }
        }

        return equipo;

    }
    
    public Object obtenerdato(String nombreCorto) {

        Equipo equipo = new Equipo();
        sql = "SELECT * FROM equipo WHERE nombre_corto = '" + nombreCorto+"'";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                equipo.setEquipoId(rs.getInt(1));
                equipo.setNombreOficial(rs.getString(2));
                equipo.setNombreCorto(rs.getString(3));
                equipo.setSeudonimo(rs.getString(4));
                equipo.setCodigoFifa(rs.getString(5));
                equipo.setFundacion(rs.getDate(6));
                equipo.setUbicacion(rs.getString(7));
                equipo.setNumSocios(rs.getInt(8));
                equipo.setNumTitulosGandos(rs.getInt(9));
                equipo.setParticipacionesCopas(rs.getInt(10));
                equipo.setNumFinalesJugadas(rs.getInt(11));
                equipo.setCuerpoTecnico((CuerpoTecnico) cuerpoC.obtenerdato(rs.getInt(12)));
                equipo.setConfederacion((Confederacion) confederacionC.obtenerdato(rs.getInt(13)));
                equipo.setPais((Pais) paisC.obtenerdato(rs.getInt(14)));
                equipo.setFoto(rs.getBinaryStream(15));
            }

        } catch (SQLException e) {
            e.printStackTrace(System.err);
        } finally {
            try {
                con.close();
                ps.close();
                rs.close();
            } catch (SQLException ex) {
                ex.printStackTrace(System.err);
            }
        }

        return equipo;

    }

    @Override
    public List buscar(Object obj) {

        List lista = new ArrayList();
        sql = "SELECT * FROM equipo WHERE nombre_completo LIKE '%"+obj+"%'\n"
                + "OR nombre_corto LIKE '%"+obj+"%'\n"
                + "OR apodo LIKE '%"+obj+"%'";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Equipo equipo = new Equipo();
                equipo.setEquipoId(rs.getInt(1));
                equipo.setNombreOficial(rs.getString(2));
                equipo.setNombreCorto(rs.getString(3));
                equipo.setSeudonimo(rs.getString(4));
                equipo.setCodigoFifa(rs.getString(5));
                equipo.setFundacion(rs.getDate(6));
                equipo.setUbicacion(rs.getString(7));
                equipo.setNumSocios(rs.getInt(8));
                equipo.setNumTitulosGandos(rs.getInt(9));
                equipo.setParticipacionesCopas(rs.getInt(10));
                equipo.setNumFinalesJugadas(rs.getInt(11));
                equipo.setCuerpoTecnico((CuerpoTecnico) cuerpoC.obtenerdato(rs.getInt(12)));
                equipo.setConfederacion((Confederacion) confederacionC.obtenerdato(rs.getInt(13)));
                equipo.setPais((Pais) paisC.obtenerdato(rs.getInt(14)));
                equipo.setFoto(rs.getBinaryStream(15));
                lista.add(equipo);
            }

        } catch (SQLException e) {
            e.printStackTrace(System.err);
        } finally {
            try {
                con.close();
                ps.close();
                rs.close();
            } catch (SQLException ex) {
                ex.printStackTrace(System.err);
            }
        }

        return lista;

    }

    @Override
    public void registrar(Object obj) throws Exception {

        Equipo equipo = (Equipo) obj;
        sql = "insert into equipo(nombre_oficial,nombre_corto,seudonimo,codigo_fifa,fecha_fundacion,ubicacion, " 
                +"numero_socios,cuerpo_tecnico_id,confederacion_id,pais_id,foto) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?)";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, equipo.getNombreOficial());
            ps.setString(2, equipo.getNombreCorto());
            ps.setString(3, equipo.getSeudonimo());
            ps.setString(4, equipo.getCodigoFifa());
            ps.setDate(5, equipo.getFundacion());
            ps.setString(6, equipo.getUbicacion());
            ps.setInt(7, equipo.getNumSocios());
            ps.setInt(8, equipo.getCuerpoTecnico().getCuerpoTecnicoId());
            ps.setInt(9, equipo.getConfederacion().getConfederacion_id());
            ps.setInt(10, equipo.getPais().getPaisId());
            ps.setBinaryStream(11, equipo.getFoto());
            ps.executeUpdate();

        } catch (PSQLException pe) {
            pe.printStackTrace(System.err);
            throw new Exception("Ya existe el Equipo");
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        } finally {
            try {
                con.close();
                ps.close();
            } catch (SQLException ex) {
                ex.printStackTrace(System.err);
            }
        }

    }

    @Override
    public void modificar(Object obj) throws Exception {

        Equipo equipo = (Equipo) obj;
        sql = "UPDATE equipo SET nombre_oficial=?,nombre_corto=?,seudonimo=?,codigo_fifa=?,fecha_fundacion=?,ubicacion=?, "
                + "numero_socios=?,cuerpo_tecnico_id=?,confederacion_id=?,pais_id=?,foto=?"
                + "WHERE equipo_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, equipo.getNombreOficial());
            ps.setString(2, equipo.getNombreCorto());
            ps.setString(3, equipo.getSeudonimo());
            ps.setString(4, equipo.getCodigoFifa());
            ps.setDate(5, equipo.getFundacion());
            ps.setString(6, equipo.getUbicacion());
            ps.setInt(7, equipo.getNumSocios());
            ps.setInt(8, equipo.getCuerpoTecnico().getCuerpoTecnicoId());
            ps.setInt(9, equipo.getConfederacion().getConfederacion_id());
            ps.setInt(10, equipo.getPais().getPaisId());
            ps.setBinaryStream(11, equipo.getFoto());
            ps.setInt(12, equipo.getEquipoId());
            ps.executeUpdate();

        } catch (PSQLException pe) {
            pe.printStackTrace(System.err);
            throw new Exception("Ya existe el Equipo");
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        } finally {
            try {
                con.close();
                ps.close();
            } catch (SQLException ex) {
                ex.printStackTrace(System.err);
            }
        }

    }
    
    public int obtenerIdEquipo(String nombreCorto){
        
        sql = "SELECT equipo_id FROM equipo WHERE nombre_corto = '" + nombreCorto+"'";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace(System.err);
        } finally {
            try {
                con.close();
                ps.close();
                rs.close();
            } catch (SQLException ex) {
                ex.printStackTrace(System.err);
            }
        }

        return 0;
        
    }
    
}
