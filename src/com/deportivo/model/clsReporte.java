package com.deportivo.model;

import com.deportivo.controller.Conexion;
import java.util.Map;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;
import java.sql.*;
import net.sf.jasperreports.engine.JRException;

public class clsReporte {

    Connection con;
    public String RUTA_REPORTE="src\\Reportes\\";
    
    public JRViewer reporteInterno (String archivoReporte, Map<String,Object> parametros) throws Exception{
        try {
            Conexion estado = new Conexion();
            con = estado.conectar();
            
            JasperPrint miReporte = JasperFillManager.fillReport(RUTA_REPORTE+archivoReporte, parametros, con);
            JRViewer visorReporte= new JRViewer(miReporte);
            return visorReporte;
        } catch (JRException e) {
            throw new Exception ("Error al generar reporte!");
        }
    }

}
