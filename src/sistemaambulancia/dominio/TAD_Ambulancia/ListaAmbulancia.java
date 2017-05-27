/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaambulancia.dominio.TAD_Ambulancia;

import static java.util.Objects.isNull;
import sistemaambulancia.dominio.Ambulancia;

public class ListaAmbulancia {

    private NodoAmbulancia inicio;

    ListaAmbulancia() {
        inicio = null;
    }

    boolean esVacia() {
        return inicio == null;
    }

    void insertarInicio(Ambulancia amb) {
        NodoAmbulancia nodo = new NodoAmbulancia(amb);
        if (this.esVacia()) {
            this.inicio = nodo;
        } else {
            nodo.setSiguiente(inicio);
            this.inicio = nodo;
        }
    }

    public void setInicio(NodoAmbulancia nodo) {
        this.inicio = nodo;
    }

    public Ambulancia head() {
        return inicio.getAmbulancia();
    }

    public ListaAmbulancia tail() {
        ListaAmbulancia tail = new ListaAmbulancia();
        tail.setInicio(this.inicio.getSiguiente());
        return tail;
    }

    public boolean contains(String id) {
        boolean encontre = false;
        Ambulancia amb;
        ListaAmbulancia listaAux = this;
        while (!listaAux.esVacia() && !encontre) {
            amb = listaAux.head();
            if (amb.getId().equals(id)) {
                encontre = true;
            }else{
                listaAux = listaAux.tail();
            }            
        }
        return encontre;
    }
    
    public Ambulancia Buscar(String id){
        Ambulancia amb;
        Ambulancia resAmb = null;
        ListaAmbulancia listaAux = this;
        while (!listaAux.esVacia() && isNull(resAmb)) {
            amb = listaAux.head();
            if (amb.getId().equals(id)) {
                resAmb = amb;                
            }else{
                listaAux = listaAux.tail();
            }            
        }
        return resAmb;
    }
    
    public void insertarOrdenado(Ambulancia amb){
        if(this.esVacia()){
            this.insertarInicio(amb);
        }else{
            NodoAmbulancia nodoAux = inicio;
            while(nodoAux.getSiguiente()!=null && nodoAux.getSiguiente().getAmbulancia().getId().compareTo(amb.getId()) == -1){
                nodoAux=nodoAux.getSiguiente();
            }
            NodoAmbulancia nodo = new NodoAmbulancia(amb);
            nodo.setSiguiente(nodoAux.getSiguiente());
            nodoAux.setSiguiente(nodo);    
        }
    }
    
}
