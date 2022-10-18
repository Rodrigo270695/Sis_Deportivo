
package com.deportivo.controller;

import com.deportivo.interfac.CRUD;
import com.deportivo.model.TipoContrato;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.postgresql.util.PSQLException;

public class TipoContratoController implements CRUD{
    
    Conexion estado = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    @Override
    public List listar(){
        
         List lista = new ArrayList();
        sql = "SELECT * FROM tipo_contrato ORDER BY tipo_contrato_id DESC";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                TipoContrato tipoContrato = new TipoContrato();
                tipoContrato.setTipoContratoId(rs.getByte(1));
                tipoContrato.setDescripcion(rs.getString(2));
                lista.add(tipoContrato);
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
        
        TipoContrato tipoContrato = (TipoContrato) obj;
        sql = "INSERT INTO tipo_contrato(descripcion) VALUES(?)";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, tipoContrato.getDescripcion());
            ps.executeUpdate();

        } catch (PSQLException pe) {
            throw new Exception("Ya existe el tipoContrato");
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
        
        TipoContrato tipoContrato = (TipoContrato) obj;
        sql = "UPDATE tipo_contrato SET descripcion=? WHERE tipo_contrato_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, tipoContrato.getDescripcion());
            ps.setInt(2, tipoContrato.getTipoContratoId());
            ps.executeUpdate();

        } catch (PSQLException pe) {
            throw new Exception("Ya existe el tipoContrato");
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
        
        sql = "DELETE FROM tipo_contrato WHERE tipo_contrato_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (PSQLException pe) {
            pe.printStackTrace(System.err);
            throw new Exception("El tipoContrato no se puede eliminar, porque está siendo USADO");
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
    public Object obtenerdato(int id)  {
        
        TipoContrato tipoContrato = new TipoContrato();
        sql = "SELECT * FROM tipo_contrato WHERE tipo_contrato_id = "+id;

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                tipoContrato.setTipoContratoId(rs.getInt(1));
                tipoContrato.setDescripcion(rs.getString(2));
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

        return tipoContrato;
        
    }

    @Override
    public List buscar(Object obj){
        
        List lista = new ArrayList();
        sql = "SELECT * FROM tipo_contrato WHERE descripcion LIKE '%"+obj+"%' ";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                TipoContrato tipoContrato = new TipoContrato();
                tipoContrato.setTipoContratoId(rs.getInt(1));
                tipoContrato.setDescripcion(rs.getString(2));
                lista.add(tipoContrato);
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
    
}
