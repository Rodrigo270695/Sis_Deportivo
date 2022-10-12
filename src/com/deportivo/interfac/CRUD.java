
package com.deportivo.interfac;

import java.util.List;

public interface CRUD {
    
    public List listar() throws Exception;
    
    public void registrar(Object obj) throws Exception;
    
    public void modificar(Object obj) throws Exception;
    
    public void eliminar(int id) throws Exception;
    
    public Object obtenerdato(int id) throws Exception;
    
    public List buscar(Object obj) throws Exception;
    
    
}
