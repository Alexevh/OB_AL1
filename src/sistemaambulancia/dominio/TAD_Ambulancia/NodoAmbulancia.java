/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaambulancia.dominio.TAD_Ambulancia;

import sistemaambulancia.dominio.Ambulancia;

public class NodoAmbulancia {

    private Ambulancia amb;
    private NodoAmbulancia siguiente;

    public Ambulancia getAmbulancia(){
        return amb;
    }
    
    public NodoAmbulancia getSiguiente(){
        return siguiente;
    }
    public void setSiguiente(NodoAmbulancia sig){
        this.siguiente = sig;
    }
    
    NodoAmbulancia(Ambulancia amb){
        this.amb=amb;
        this.siguiente=null;
    }
}
