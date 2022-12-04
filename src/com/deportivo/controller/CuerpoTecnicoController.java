
package com.deportivo.controller;

import com.deportivo.interfac.CRUD;
import com.deportivo.model.CuerpoTecnico;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.postgresql.util.PSQLException;

public class CuerpoTecnicoController implements CRUD{
    
    Conexion estado = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    @Override
    public List listar(){
        
         List lista = new ArrayList();
        sql = "SELECT * FROM cuerpo_tecnico ORDER BY cuerpo_tecnico_id DESC";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                CuerpoTecnico cuerpoTecnico = new CuerpoTecnico();
                cuerpoTecnico.setCuerpoTecnicoId(rs.getInt(1));
                cuerpoTecnico.setNombre(rs.getString(2));
                lista.add(cuerpoTecnico);
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
        
        CuerpoTecnico cuerpoTecnico = (CuerpoTecnico) obj;
        sql = "INSERT INTO cuerpo_tecnico(nombre) VALUES(?)";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, cuerpoTecnico.getNombre());
            ps.executeUpdate();

        } catch (PSQLException pe) {
           
            throw new Exception("Ya existe el cuerpoTecnico");
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
        
        CuerpoTecnico cuerpoTecnico = (CuerpoTecnico) obj;
        sql = "UPDATE cuerpo_tecnico SET nombre=? WHERE cuerpo_tecnico_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, cuerpoTecnico.getNombre());
            ps.setInt(2, cuerpoTecnico.getCuerpoTecnicoId());
            ps.executeUpdate();

        } catch (PSQLException pe) {
            throw new Exception("Ya existe el cuerpoTecnico");
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
        
        sql = "DELETE FROM cuerpo_tecnico WHERE cuerpo_tecnico_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (PSQLException pe) {
            pe.printStackTrace(System.err);
            throw new Exception("El cuerpoTecnico no se puede eliminar, porque está siendo USADO");
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
        
        CuerpoTecnico cuerpoTecnico = new CuerpoTecnico();
        sql = "SELECT * FROM cuerpo_tecnico WHERE cuerpo_tecnico_id = "+id;

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                cuerpoTecnico.setCuerpoTecnicoId(rs.getInt(1));
                cuerpoTecnico.setNombre(rs.getString(2));
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

        return cuerpoTecnico;
        
    }

    public Object obtenerdato(String nombre)  {
        
        CuerpoTecnico cuerpoTecnico = new CuerpoTecnico();
        sql = "SELECT * FROM cuerpo_tecnico WHERE nombre = '"+nombre+"'";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                cuerpoTecnico.setCuerpoTecnicoId(rs.getInt(1));
                cuerpoTecnico.setNombre(rs.getString(2));
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

        return cuerpoTecnico;
        
    }
    
    @Override
    public List buscar(Object obj){
        
        List lista = new ArrayList();
        sql = "SELECT * FROM cuerpo_tecnico WHERE nombre LIKE '%"+obj+"%' ";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                CuerpoTecnico cuerpoTecnico = new CuerpoTecnico();
                cuerpoTecnico.setCuerpoTecnicoId(rs.getInt(1));
                cuerpoTecnico.setNombre(rs.getString(2));
                lista.add(cuerpoTecnico);
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
