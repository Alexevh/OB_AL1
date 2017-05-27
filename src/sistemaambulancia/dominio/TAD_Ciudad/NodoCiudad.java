/*
 * To change this license header, ciuose License Headers in Project Properties.
 * To change this template file, ciuose Tools | Templates
 * and open the template in the editor.
 */
package sistemaambulancia.dominio.TAD_Ciudad;

import sistemaambulancia.dominio.TAD_Ciudad.*;
import sistemaambulancia.dominio.Ciudad;
import sistemaambulancia.dominio.TAD_Ciudad.NodoCiudad;

public class NodoCiudad {
    
    private Ciudad ciu;
    private NodoCiudad siguiente;

    public Ciudad getCiudad(){
        return ciu;
    }
    
    public NodoCiudad getSiguiente(){
        return siguiente;
    }
    public void setSiguiente(NodoCiudad sig){
        this.siguiente = sig;
    }
    
    NodoCiudad(Ciudad ciu){
        this.ciu=ciu;
        this.siguiente=null;
    }
}
