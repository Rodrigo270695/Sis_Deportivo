package com.deportivo.controller;

import com.deportivo.interfac.CRUD;
import com.deportivo.model.Ciudad;
import com.deportivo.model.DimensionCampo;
import com.deportivo.model.Estadio;
import java.sql.*;
import java.util.*;
import org.postgresql.util.PSQLException;

public class EstadioController implements CRUD {

    DimensionCampoController dimensionC = new DimensionCampoController();
    CiudadController ciudadC = new CiudadController();
    Conexion estado = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    @Override
    public List listar() {

        List lista = new ArrayList();
        sql = "SELECT * FROM estadio ORDER BY estadio_id DESC";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Estadio estadio = new Estadio();
                estadio.setEstadioId(rs.getInt(1));
                estadio.setNombreOficial(rs.getString(2));
                estadio.setNombreConocido(rs.getString(3));
                estadio.setCapacidad(rs.getInt(4));
                estadio.setDireccion(rs.getString(5));
                estadio.setFechaFundacion(rs.getDate(6));
                estadio.setTribunas(rs.getByte(7));
                estadio.setFoto(rs.getBinaryStream(8));
                estadio.setCosto(rs.getDouble(9));
                estadio.setEquipoPropietario(rs.getString(10));
                estadio.setDimensionCampo((DimensionCampo) dimensionC.obtenerdato(rs.getInt(11)));
                estadio.setCiudad((Ciudad) ciudadC.obtenerdato(rs.getInt(12)));
                lista.add(estadio);
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

        sql = "DELETE FROM estadio WHERE estadio_id = ?";

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

        Estadio estadio = new Estadio();
        sql = "SELECT * FROM estadio WHERE estadio_id = " + id;

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                estadio.setEstadioId(rs.getInt(1));
                estadio.setNombreOficial(rs.getString(2));
                estadio.setNombreConocido(rs.getString(3));
                estadio.setCapacidad(rs.getInt(4));
                estadio.setDireccion(rs.getString(5));
                estadio.setFechaFundacion(rs.getDate(6));
                estadio.setTribunas(rs.getByte(7));
                estadio.setFoto(rs.getBinaryStream(8));
                estadio.setCosto(rs.getDouble(9));
                estadio.setEquipoPropietario(rs.getString(10));
                estadio.setDimensionCampo((DimensionCampo) dimensionC.obtenerdato(rs.getInt(11)));
                estadio.setCiudad((Ciudad) ciudadC.obtenerdato(rs.getInt(12)));
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

        return estadio;

    }

    @Override
    public List buscar(Object obj) {

        List lista = new ArrayList();
        sql = "SELECT * FROM estadio WHERE nombre_oficial LIKE '%"+obj+"%'\n"
                + "OR nombre_conocido LIKE '%"+obj+"%'";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Estadio estadio = new Estadio();
                estadio.setEstadioId(rs.getInt(1));
                estadio.setNombreOficial(rs.getString(2));
                estadio.setNombreConocido(rs.getString(3));
                estadio.setCapacidad(rs.getInt(4));
                estadio.setDireccion(rs.getString(5));
                estadio.setFechaFundacion(rs.getDate(6));
                estadio.setTribunas(rs.getByte(7));
                estadio.setFoto(rs.getBinaryStream(8));
                estadio.setCosto(rs.getDouble(9));
                estadio.setEquipoPropietario(rs.getString(10));
                estadio.setDimensionCampo((DimensionCampo) dimensionC.obtenerdato(rs.getInt(11)));
                estadio.setCiudad((Ciudad) ciudadC.obtenerdato(rs.getInt(12)));
                lista.add(estadio);
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

        Estadio estadio = (Estadio) obj;
        sql = "insert into estadio(nombre_oficial,nombre_conocido,capacidad,direccion,fecha_fundacion,numero_tribunas,foto,"
                + "costo,equipo_propietario,dimension_id,ciudad_id)"
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?)";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, estadio.getNombreOficial());
            ps.setString(2, estadio.getNombreConocido());
            ps.setInt(3, estadio.getCapacidad());
            ps.setString(4, estadio.getDireccion());
            ps.setDate(5, estadio.getFechaFundacion());
            ps.setByte(6, estadio.getTribunas());
            ps.setBinaryStream(7, estadio.getFoto());
            ps.setDouble(8, estadio.getCosto());
            ps.setString(9, estadio.getEquipoPropietario());
            ps.setInt(10, estadio.getDimensionCampo().getDimension_id());
            ps.setInt(11, estadio.getCiudad().getCiudad_id());
            ps.executeUpdate();

        } catch (PSQLException pe) {
            pe.printStackTrace(System.err);
            throw new Exception("Ya existe el Estadio");
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

        Estadio estadio = (Estadio) obj;
        sql = "UPDATE estadio SET nombre_oficial=?,nombre_conocido=?,capacidad=?,direccion=?,fecha_fundacion=?,numero_tribunas=?,foto=?,"
                + "costo=?,equipo_propietario=?,dimension_id=?,ciudad_id=?"
                + "WHERE estadio_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, estadio.getNombreOficial());
            ps.setString(2, estadio.getNombreConocido());
            ps.setInt(3, estadio.getCapacidad());
            ps.setString(4, estadio.getDireccion());
            ps.setDate(5, estadio.getFechaFundacion());
            ps.setByte(6, estadio.getTribunas());
            ps.setBinaryStream(7, estadio.getFoto());
            ps.setDouble(8, estadio.getCosto());
            ps.setString(9, estadio.getEquipoPropietario());
            ps.setInt(10, estadio.getDimensionCampo().getDimension_id());
            ps.setInt(11, estadio.getCiudad().getCiudad_id());
            ps.setInt(12, estadio.getEstadioId());
            ps.executeUpdate();

        } catch (PSQLException pe) {
            pe.printStackTrace(System.err);
            throw new Exception("Ya existe el Estadio");
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

}
