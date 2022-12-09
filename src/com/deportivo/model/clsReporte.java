package com.deportivo.model;

import com.deportivo.controller.Conexion;
import java.util.Map;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;

public class clsReporte {

    public String RUTA_REPORTE = "Sis_Deportivo\\src\\Reportes";

    public JRViewer reporteInterno(String archivoReporte, Map<String, Object> parametros) throws Exception {

        try {

            Conexion objConexion = new Conexion();
            objConexion.conectar();
            JasperPrint miReporte = JasperFillManager.fillReport(RUTA_REPORTE + archivoReporte, parametros, objConexion.conectar());
            JRViewer visorReporte = new JRViewer(miReporte);
            return visorReporte;

        } catch (Exception e) {

            e.printStackTrace(System.err);
            throw new Exception("Error al generar el reporte");
        }

    }

}
