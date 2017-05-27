/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaambulancia.dominio;

import sistemaambulancia.dominio.TAD_Chofer.ListaChofer;

public class Ambulancia {
    private enum TipoEstado{
        NO_DISPONIBLE, DISPONIBLE, ATENDIENDO
    }
    
    private String id;    
    private TipoEstado estado;
    private Ciudad ciudad;
    private ListaChofer choferes;
    
    public String getId(){
        return id;
    }
    
    public TipoEstado getEstado(){
        return estado;
    }
    
    public Ciudad getCiudad(){
        return ciudad;
    }
    
    public ListaChofer getChoferes(){
        return choferes;
    }
    
    
    
    
    
}
