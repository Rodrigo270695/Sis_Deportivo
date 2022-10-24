
package com.deportivo.controller;

import com.deportivo.interfac.CRUD;
import com.deportivo.model.Agente;
import com.deportivo.model.Contrato;
import com.deportivo.model.Equipo;
import com.deportivo.model.Futbolista;
import com.deportivo.model.TipoContrato;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.postgresql.util.PSQLException;

public class ContratoController implements CRUD{
    
    Conexion estado = new Conexion();
    AgenteController agenteC = new AgenteController();
    FutbolistaController futbolistaC = new FutbolistaController();
    EquipoController equipoC = new EquipoController();
    TipoContratoController tipoContratoC = new TipoContratoController();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    @Override
    public List listar(){
        
         List lista = new ArrayList();
        sql = "SELECT * FROM contrato ORDER BY contrato_id DESC";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Contrato contrato = new Contrato();
                contrato.setContratoId(rs.getInt(1));
                contrato.setFechaInicio(rs.getDate(2));
                contrato.setFechaFin(rs.getDate(3));
                contrato.setRemuneracion(rs.getDouble(4));
                contrato.setDescripcion(rs.getString(5));
                contrato.setAgente((Agente) agenteC.obtenerdato(rs.getInt(6)));
                contrato.setFutbolista((Futbolista) futbolistaC.obtenerdato(rs.getInt(7)));
                contrato.setEquipo((Equipo) equipoC.obtenerdato(rs.getInt(8)));
                contrato.setTipoContrato((TipoContrato) tipoContratoC.obtenerdato(rs.getInt(9)));
                lista.add(contrato);
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
        
        Contrato contrato = (Contrato) obj;
        sql = "INSERT INTO contrato(fecha_inicio,fecha_fin,remuneracion_por_temporada,descripcion,agente_id,futbolista_id,equipo_id,tipo_contrato_id) "
                + "VALUES(?,?,?,?,?,?,?,?)";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setDate(1, contrato.getFechaInicio());
            ps.setDate(2, contrato.getFechaFin());
            ps.setDouble(3, contrato.getRemuneracion());
            ps.setString(4, contrato.getDescripcion());
            ps.setInt(5, contrato.getAgente().getAgenteId());
            ps.setInt(6, contrato.getFutbolista().getFutbolistaId());
            ps.setInt(7, contrato.getEquipo().getEquipoId());
            ps.setInt(8, contrato.getTipoContrato().getTipoContratoId());
            ps.executeUpdate();

        } catch (PSQLException pe) {
           
            throw new Exception("Ya existe la contrato");
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
        
        Contrato contrato = (Contrato) obj;
        sql = "UPDATE contrato SET fecha_inicio=?,fecha_fin=?,remuneracion_por_temporada=?,descripcion=?,agente_id=?,futbolista_id=?,equipo_id=?,tipo_contrato_id=? "
                + "WHERE contrato_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setDate(1, contrato.getFechaInicio());
            ps.setDate(2, contrato.getFechaFin());
            ps.setDouble(3, contrato.getRemuneracion());
            ps.setString(4, contrato.getDescripcion());
            ps.setInt(5, contrato.getAgente().getAgenteId());
            ps.setInt(6, contrato.getFutbolista().getFutbolistaId());
            ps.setInt(7, contrato.getEquipo().getEquipoId());
            ps.setInt(8, contrato.getTipoContrato().getTipoContratoId());
            ps.setInt(9, contrato.getContratoId());
            ps.executeUpdate();

        } catch (PSQLException pe) {
            throw new Exception("Ya existe el contrato");
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
        
        sql = "DELETE FROM contrato WHERE contrato_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (PSQLException pe) {
            pe.printStackTrace(System.err);
            throw new Exception("El contrato no se puede eliminar, porque está siendo USADO");
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
        
        Contrato contrato = new Contrato();
        sql = "SELECT * FROM contrato WHERE contrato_id = "+id;

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                contrato.setContratoId(rs.getInt(1));
                contrato.setFechaInicio(rs.getDate(2));
                contrato.setFechaFin(rs.getDate(3));
                contrato.setRemuneracion(rs.getDouble(4));
                contrato.setDescripcion(rs.getString(5));
                contrato.setAgente((Agente) agenteC.obtenerdato(rs.getInt(6)));
                contrato.setFutbolista((Futbolista) futbolistaC.obtenerdato(rs.getInt(7)));
                contrato.setEquipo((Equipo) equipoC.obtenerdato(rs.getInt(8)));
                contrato.setTipoContrato((TipoContrato) tipoContratoC.obtenerdato(rs.getInt(9)));
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

        return contrato;
        
    }

    @Override
    public List buscar(Object obj){
        
        List lista = new ArrayList();
        sql = "SELECT * FROM contrato WHERE nombre LIKE '%"+obj+"%' ";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Contrato contrato = new Contrato();
                contrato.setContratoId(rs.getInt(1));
                contrato.setFechaInicio(rs.getDate(2));
                contrato.setFechaFin(rs.getDate(3));
                contrato.setRemuneracion(rs.getDouble(4));
                contrato.setDescripcion(rs.getString(5));
                contrato.setAgente((Agente) agenteC.obtenerdato(rs.getInt(6)));
                contrato.setFutbolista((Futbolista) futbolistaC.obtenerdato(rs.getInt(7)));
                contrato.setEquipo((Equipo) equipoC.obtenerdato(rs.getInt(8)));
                contrato.setTipoContrato((TipoContrato) tipoContratoC.obtenerdato(rs.getInt(9)));
                lista.add(contrato);
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
