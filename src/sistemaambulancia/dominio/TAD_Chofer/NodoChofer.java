/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaambulancia.dominio.TAD_Chofer;

import sistemaambulancia.dominio.Chofer;
import sistemaambulancia.dominio.TAD_Chofer.NodoChofer;

public class NodoChofer {
    
    private Chofer cho;
    private NodoChofer siguiente;

    public Chofer getChofer(){
        return cho;
    }
    
    public NodoChofer getSiguiente(){
        return siguiente;
    }
    public void setSiguiente(NodoChofer sig){
        this.siguiente = sig;
    }
    
    NodoChofer(Chofer cho){
        this.cho=cho;
        this.siguiente=null;
    }
    
    public void destroy(){
        this.cho.destroy();
        this.siguiente=null;
    }
}
