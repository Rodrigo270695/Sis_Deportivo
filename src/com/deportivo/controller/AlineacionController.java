
package com.deportivo.controller;

import com.deportivo.interfac.CRUD;
import com.deportivo.model.Alineacion;
import com.deportivo.model.Equipo;
import com.deportivo.model.Futbolista;
import com.deportivo.model.Partido;
import com.deportivo.model.Posicion;
import com.deportivo.model.TipoJugador;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.postgresql.util.PSQLException;

public class AlineacionController implements CRUD{
    
    PartidoController partidoC = new PartidoController();
    EquipoController equipoC = new EquipoController();
    FutbolistaController futbolistaC = new FutbolistaController();
    TipoJugadorController tipoJC = new TipoJugadorController();
    PosicionController posicionC = new PosicionController();
    Conexion estado = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    @Override
    public List listar(){
        
         List lista = new ArrayList();
        sql = "SELECT * FROM alineacion ORDER BY partido_id DESC ";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Alineacion alineacion = new Alineacion();
                alineacion.setPartido((Partido) partidoC.obtenerdato(rs.getInt(1)));
                alineacion.setEquipo((Equipo) equipoC.obtenerdato(rs.getInt(2)));
                alineacion.setFutbolista((Futbolista) futbolistaC.obtenerdato(rs.getInt(3)));
                alineacion.setTipoJugador((TipoJugador) tipoJC.obtenerdato(rs.getInt(4)));
                alineacion.setPosicion((Posicion) posicionC.obtenerdato(rs.getInt(5)));
                lista.add(alineacion);
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
        
        Alineacion alineacion = (Alineacion) obj;
        sql = "INSERT INTO alineacion(partido_id,equipo_id,futbolista_id,tipo_jugador_id,posicion_id) "
                + "VALUES(?,?,?,?,?)";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, alineacion.getPartido().getPartidoId());
            ps.setInt(2, alineacion.getEquipo().getEquipoId());
            ps.setInt(3, alineacion.getFutbolista().getFutbolistaId());
            ps.setInt(4, alineacion.getTipoJugador().getTipo_jugador_id());
            ps.setInt(5, alineacion.getPosicion().getPosicionId());
            ps.executeUpdate();

        } catch (PSQLException pe) {
            throw new Exception("Ya existe Jugador");
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
        
    }

    @Override
    public void eliminar(int id) throws Exception {
        
        sql = "DELETE FROM alineacion WHERE alineacion_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (PSQLException pe) {
            pe.printStackTrace(System.err);
            throw new Exception("El alineacion no se puede eliminar, porque está siendo USADO");
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
        
        return null;
        
    }

    @Override
    public List buscar(Object obj){
        
        return null;
        
    }
    
    public List listar(int idPartido, int idEquipo){
        
         List lista = new ArrayList();
        sql = "SELECT * FROM alineacion where partido_id = "+idPartido
                +" and equipo_id = "+idEquipo+" ORDER BY partido_id DESC";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Alineacion alineacion = new Alineacion();
                alineacion.setPartido((Partido) partidoC.obtenerdato(rs.getInt(1)));
                alineacion.setEquipo((Equipo) equipoC.obtenerdato(rs.getInt(2)));
                alineacion.setFutbolista((Futbolista) futbolistaC.obtenerdato(rs.getInt(3)));
                alineacion.setTipoJugador((TipoJugador) tipoJC.obtenerdato(rs.getInt(4)));
                alineacion.setPosicion((Posicion) posicionC.obtenerdato(rs.getInt(5)));
                lista.add(alineacion);
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
    
    public void eliminar(int idPartido, int idEquipo, int idFutbolista) throws Exception {
        
        sql = "DELETE FROM alineacion WHERE partido_id = ? and equipo_id = ? and futbolista_id =?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idPartido);
            ps.setInt(2, idEquipo);
            ps.setInt(3, idFutbolista);
            ps.executeUpdate();

        } catch (PSQLException pe) {
            pe.printStackTrace(System.err);
            throw new Exception("El alineacion no se puede eliminar, porque está siendo USADO");
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
