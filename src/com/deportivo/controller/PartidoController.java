
package com.deportivo.controller;

import com.deportivo.interfac.CRUD;
import com.deportivo.model.Competencia;
import com.deportivo.model.Estadio;
import com.deportivo.model.EtapaFixture;
import com.deportivo.model.Jornada;
import com.deportivo.model.Partido;
import com.deportivo.model.TernaArbitral;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.postgresql.util.PSQLException;

public class PartidoController implements CRUD{
    
    JornadaController jornadaC = new JornadaController();
    EstadioController estadioC = new EstadioController();
    EtapaFixtureController estapaC = new EtapaFixtureController();
    CompetenciaController competenciaC = new CompetenciaController();
    TernaArbitralController ternaC = new TernaArbitralController();
    Conexion estado = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    @Override
    public List listar(){
        
         List lista = new ArrayList();
        sql = "SELECT * FROM partido ORDER BY partido_id DESC";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Partido partido = new Partido();
                partido.setPartidoId(rs.getByte(1));
                partido.setHora(rs.getTime(2));
                partido.setJornada((Jornada) jornadaC.obtenerdato(rs.getInt(3)));
                partido.setEstadio((Estadio) estadioC.obtenerdato(rs.getInt(4)));
                partido.setEtapaFixture((EtapaFixture) estapaC.obtenerdato(rs.getInt(5)));
                partido.setCompetencia((Competencia) competenciaC.obtenerdato(rs.getInt(6)));
                partido.setTernaArbitral((TernaArbitral) ternaC.obtenerdato(rs.getInt(7)));
                partido.setEstado(rs.getBoolean(8));
                lista.add(partido);
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
        
        Partido partido = (Partido) obj;
        sql = "INSERT INTO partido(hora,jornada_id,estadio_id,etapa_fixture_id,competencia_id,terna_arbitral_id) "
                + "VALUES(?,?,?,?,?,?)";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setTime(1, partido.getHora());
            ps.setInt(2, partido.getJornada().getJornada_id());
            ps.setInt(3, partido.getEstadio().getEstadioId());
            ps.setInt(4, partido.getEtapaFixture().getEtapa_fixture_id());
            ps.setInt(5, partido.getCompetencia().getCompetenciaId());
            ps.setInt(6, partido.getTernaArbitral().getTerna_arbitral_id());
            ps.executeUpdate();

        } catch (PSQLException pe) {
            throw new Exception("Ya existe el partido");
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
        
        Partido partido = (Partido) obj;
        sql = "UPDATE partido SET hora=?,jornada_id=?,estadio_id=?,etapa_fixture_id=?,competencia_id=?,"
                + "terna_arbitral_id=? WHERE partido_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setTime(1, partido.getHora());
            ps.setInt(2, partido.getJornada().getJornada_id());
            ps.setInt(3, partido.getEstadio().getEstadioId());
            ps.setInt(4, partido.getEtapaFixture().getEtapa_fixture_id());
            ps.setInt(5, partido.getCompetencia().getCompetenciaId());
            ps.setInt(6, partido.getTernaArbitral().getTerna_arbitral_id());
            ps.setInt(7, partido.getPartidoId());
            ps.executeUpdate();

        } catch (PSQLException pe) {
            throw new Exception("Ya existe el partido");
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
        
        sql = "DELETE FROM partido WHERE partido_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (PSQLException pe) {
            pe.printStackTrace(System.err);
            throw new Exception("El partido no se puede eliminar, porque está siendo USADO");
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
        
        Partido partido = new Partido();
        sql = "SELECT * FROM partido WHERE partido_id = "+id;

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                partido.setPartidoId(rs.getByte(1));
                partido.setHora(rs.getTime(2));
                partido.setJornada((Jornada) jornadaC.obtenerdato(rs.getInt(3)));
                partido.setEstadio((Estadio) estadioC.obtenerdato(rs.getInt(4)));
                partido.setEtapaFixture((EtapaFixture) estapaC.obtenerdato(rs.getInt(5)));
                partido.setCompetencia((Competencia) competenciaC.obtenerdato(rs.getInt(6)));
                partido.setTernaArbitral((TernaArbitral) ternaC.obtenerdato(rs.getInt(7)));
                partido.setEstado(rs.getBoolean(8));
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

        return partido;
        
    }

    @Override
    public List buscar(Object obj){
        
        List lista = new ArrayList();
        sql = "SELECT * FROM partido WHERE descripcion LIKE '%"+obj+"%' ";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Partido partido = new Partido();
                partido.setPartidoId(rs.getByte(1));
                partido.setHora(rs.getTime(2));
                partido.setJornada((Jornada) jornadaC.obtenerdato(rs.getInt(3)));
                partido.setEstadio((Estadio) estadioC.obtenerdato(rs.getInt(4)));
                partido.setEtapaFixture((EtapaFixture) estapaC.obtenerdato(rs.getInt(5)));
                partido.setCompetencia((Competencia) competenciaC.obtenerdato(rs.getInt(6)));
                partido.setTernaArbitral((TernaArbitral) ternaC.obtenerdato(rs.getInt(7)));
                partido.setEstado(rs.getBoolean(8));
                lista.add(partido);
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
    
    public void acabarpartido(int idPartido){
        
        sql = "UPDATE partido SET estado = false WHERE partido_id = "+idPartido;

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();

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
