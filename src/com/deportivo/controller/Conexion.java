
package com.deportivo.controller;

import java.sql.*;

public class Conexion {
    
    private final String URL = "jdbc:postgresql://localhost:5400/bd_deportivo";
    private final String USER = "postgres";
    private final String PASS = "AmySellene2020";
    
    public Connection conectar(){
        
        Connection con = null;
        
        try {
            
            con = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
        
        return con;
        
    }
}
