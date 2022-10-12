package com.deportivo.controller;

import com.deportivo.interfac.CRUD;
import com.deportivo.model.Futbolista;
import com.deportivo.model.Pais;
import java.sql.*;
import java.util.*;
import org.postgresql.util.PSQLException;

public class FutbolistaController implements CRUD {

    PaisController paisC = new PaisController();
    Conexion estado = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    @Override
    public List listar() {

        List lista = new ArrayList();
        sql = "SELECT * FROM futbolista ORDER BY futbolista_id DESC";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Futbolista futbolista = new Futbolista();
                futbolista.setFutbolistaId(rs.getInt(1));
                futbolista.setDocumentoIdentidad(rs.getString(2));
                futbolista.setNombreCompleto(rs.getString(3));
                futbolista.setNombreCorto(rs.getString(4));
                futbolista.setFechaNacimiento(rs.getDate(5));
                futbolista.setAltura(rs.getFloat(6));
                futbolista.setPeso(rs.getFloat(7));
                futbolista.setSexo(rs.getString(8).charAt(0));
                futbolista.setPieDominante(rs.getString(9));
                futbolista.setEmail(rs.getString(10));
                futbolista.setFoto(rs.getBinaryStream(11));
                futbolista.setEstado(rs.getString(12).charAt(0));
                futbolista.setPais((Pais) paisC.obtenerdato(rs.getInt(13)));
                lista.add(futbolista);
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
        
        Futbolista futbolista = (Futbolista) obj;
        sql = "INSERT INTO futbolista(documento_identidad, nombre_completo,nombre_corto,fecha_nacimiento,altura,peso,sexo,pie_dominante,email,foto,pais_id) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?)";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, futbolista.getDocumentoIdentidad());
            ps.setString(2, futbolista.getNombreCompleto());
            ps.setString(3, futbolista.getNombreCorto());
            ps.setDate(4, futbolista.getFechaNacimiento());
            ps.setFloat(5, futbolista.getAltura());
            ps.setFloat(6, futbolista.getPeso());
            ps.setString(7, ""+futbolista.getSexo());
            ps.setString(8, futbolista.getPieDominante());
            ps.setString(9, futbolista.getEmail());
            ps.setBinaryStream(10, futbolista.getFoto());
            ps.setInt(11, futbolista.getPais().getPaisId());
            ps.executeUpdate();

        } catch (PSQLException pe) {
            pe.printStackTrace(System.err);
            throw new Exception("Ya existe el Agente");
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
        
        Futbolista futbolista = (Futbolista) obj;
        sql = "UPDATE futbolista SET documento_identidad=?,nombre_completo=?,nombre_corto=?,fecha_nacimiento=?,altura=?,peso=?,sexo=?,"
                + "pie_dominante=?,email=?,foto=?,pais_id=? "
                + "WHERE futbolista_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, futbolista.getDocumentoIdentidad());
            ps.setString(2, futbolista.getNombreCompleto());
            ps.setString(3, futbolista.getNombreCorto());
            ps.setDate(4, futbolista.getFechaNacimiento());
            ps.setFloat(5, futbolista.getAltura());
            ps.setFloat(6, futbolista.getPeso());
            ps.setString(7, ""+futbolista.getSexo());
            ps.setString(8, futbolista.getPieDominante());
            ps.setString(9, futbolista.getEmail());
            ps.setBinaryStream(10, futbolista.getFoto());
            ps.setInt(11, futbolista.getPais().getPaisId());
            ps.setInt(12, futbolista.getFutbolistaId());
            ps.executeUpdate();

        } catch (PSQLException pe) {
            pe.printStackTrace(System.err);
            throw new Exception("Ya existe el Agente");
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
    public void eliminar(int id) throws Exception {

//        sql = "DELETE FROM futbolista WHERE futbolista_id = ?";
//
//        try {
//
//            con = estado.conectar();
//            ps = con.prepareStatement(sql);
//            ps.setInt(1, id);
//            ps.executeUpdate();
//
//        } catch (PSQLException pe) {
//            pe.printStackTrace(System.err);
//            throw new Exception("El continente no se puede eliminar, porque está siendo USADO");
//        } catch (SQLException e) {
//            e.printStackTrace(System.err);
//        } finally {
//            try {
//                con.close();
//                ps.close();
//            } catch (SQLException ex) {
//                ex.printStackTrace(System.err);
//            }
//        }

    }

    @Override
    public Object obtenerdato(int id) {

        Futbolista futbolista = new Futbolista();
        sql = "SELECT * FROM futbolista WHERE futbolista_id = " + id;

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                futbolista.setFutbolistaId(rs.getInt(1));
                futbolista.setDocumentoIdentidad(rs.getString(2));
                futbolista.setNombreCompleto(rs.getString(3));
                futbolista.setNombreCorto(rs.getString(4));
                futbolista.setFechaNacimiento(rs.getDate(5));
                futbolista.setAltura(rs.getFloat(6));
                futbolista.setPeso(rs.getFloat(7));
                futbolista.setSexo(rs.getString(8).charAt(0));
                futbolista.setPieDominante(rs.getString(9));
                futbolista.setEmail(rs.getString(10));
                futbolista.setFoto(rs.getBinaryStream(11));
                futbolista.setEstado(rs.getString(12).charAt(0));
                futbolista.setPais((Pais) paisC.obtenerdato(rs.getInt(13)));
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

        return futbolista;

    }

    @Override
    public List buscar(Object obj) {

        List lista = new ArrayList();
//        sql = "SELECT * FROM futbolista WHERE nombre_completo LIKE '%"+obj+"%'\n"
//                + "OR direccion LIKE '%"+obj+"%'\n"
//                + "OR correo LIKE '%"+obj+"%'";
//
//        try {
//
//            con = estado.conectar();
//            ps = con.prepareStatement(sql);
//            rs = ps.executeQuery();
//
//            while (rs.next()) {
//                Futbolista futbolista = new Futbolista();
//                futbolista.setFutbolistaId(rs.getInt(1));
//                futbolista.setNombreCompleto(rs.getString(2));
//                futbolista.setDireccion(rs.getString(3));
//                futbolista.setCorreo(rs.getString(4));
//                futbolista.setFoto(rs.getBinaryStream(5));
//                lista.add(futbolista);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace(System.err);
//        } finally {
//            try {
//                con.close();
//                ps.close();
//                rs.close();
//            } catch (SQLException ex) {
//                ex.printStackTrace(System.err);
//            }
//        }

        return lista;

    }

}
