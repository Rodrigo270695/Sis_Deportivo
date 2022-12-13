
package com.deportivo.controller;

import java.sql.*;

public class Conexion {
    
    private final String URL = "jdbc:postgresql://localhost:5432/bd_deportivo";
    private final String USER = "postgres";
    private final String PASS = "admin";
    
    public Connection conectar(){
        
        Connection con = null;
        
        try {
            
            Class.forName("org.postgresql.Driver");
            
            con = DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace(System.err);
        }
        
        return con;
        
    }
}
