package com.deportivo.controller;

import com.deportivo.interfac.CRUD;
import com.deportivo.model.Rol;
import com.deportivo.model.Usuario;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import org.postgresql.util.PSQLException;

public class UsuarioController implements CRUD {

    RolController rolC = new RolController();
    Conexion estado = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    @Override
    public List listar(){
        
        List lista = new ArrayList();
        sql = "SELECT * FROM usuario ORDER BY usuario_id DESC";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setUsuarioId(rs.getInt(1));
                usuario.setRolId((Rol)rolC.obtenerdato(rs.getInt(2)));
                usuario.setNombre(rs.getString(3));
                usuario.setDocumento(rs.getString(4));
                usuario.setPassword(rs.getString(5));
                usuario.setFechaCreacion(rs.getDate(6));
                lista.add(usuario);
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
        
        Usuario usuario = (Usuario) obj;
        sql = "INSERT INTO usuario( usuario_id,rol_id,nombre,documento_identidad,password,fecha_creacion) VALUES((select max(usuario_id)+1 from usuario),?,?,?,?,now())";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, usuario.getRolId().getRolId());
            ps.setString(2, usuario.getNombre());
            ps.setString(3, usuario.getDocumento());
            ps.setString(4, usuario.getPassword());
            ps.executeUpdate();

        } catch (PSQLException pe) {
            pe.printStackTrace(System.err);
            throw new Exception("Ya existe usuario");
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
        
        Usuario usuario = (Usuario) obj;
        sql = "UPDATE usuario SET rol_id=?,nombre=?,"
                + "documento_identidad=?,password=? "
                + "WHERE usuario_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, usuario.getRolId().getRolId());
            ps.setString(2, usuario.getNombre());
            ps.setString(3, usuario.getDocumento());
            ps.setString(4, usuario.getPassword());
            ps.setInt(5, usuario.getUsuarioId());
            ps.executeUpdate();

        } catch (PSQLException pe) {
            pe.printStackTrace(System.err);
            throw new Exception("Ya existe usuario");
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
        
        sql = "DELETE FROM usuario WHERE usuario_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (PSQLException pe) {
            pe.printStackTrace(System.err);
            throw new Exception("El usuario no se puede eliminar, porque está siendo USADO");
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
        
        Usuario usuario = new Usuario();
        sql = "SELECT * FROM usuario where usuario_id = "+id;

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                
                usuario.setUsuarioId(rs.getInt(1));
                usuario.setRolId((Rol)rolC.obtenerdato(rs.getInt(2)));
                usuario.setNombre(rs.getString(3));
                usuario.setDocumento(rs.getString(4));
                usuario.setPassword(rs.getString(5));
                usuario.setFechaCreacion(rs.getDate(6));
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

        return usuario;
        
    }

    @Override
    public List buscar(Object obj) {
        
        List lista = new ArrayList();
        sql = "SELECT * FROM usuario where nombre like '%"+obj.toString()+"%' or documento_identidad like '%"+obj.toString()+"%' "
                + "ORDER BY usuario_id DESC";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setUsuarioId(rs.getInt(1));
                usuario.setRolId((Rol)rolC.obtenerdato(rs.getInt(2)));
                usuario.setNombre(rs.getString(3));
                usuario.setDocumento(rs.getString(4));
                usuario.setPassword(rs.getString(5));
                usuario.setFechaCreacion(rs.getDate(6));
                lista.add(usuario);
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

    public Usuario Logear(String documento, String password, int rol) {

        sql = "select * from usuario where documento_identidad = ? and password = ? and rol_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareCall(sql);
            ps.setString(1, documento);
            ps.setString(2, password);
            ps.setInt(3, rol);
            rs = ps.executeQuery();

            if (rs.next()) {
                return new Usuario(
                        rs.getInt(1),
                        (Rol) rolC.obtenerdato(rs.getInt(2)),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(6)
                );
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

        return new Usuario();
    }
    
    public Usuario Logear(String documento, int rol) {

        sql = "select * from usuario where documento_identidad = ? and rol_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareCall(sql);
            ps.setString(1, documento);
            ps.setInt(2, rol);
            rs = ps.executeQuery();

            if (rs.next()) {
                return new Usuario(
                        rs.getInt(1),
                        (Rol) rolC.obtenerdato(rs.getInt(2)),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(6)
                );
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

        return new Usuario();
    }
    
}
