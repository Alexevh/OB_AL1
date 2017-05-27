/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaambulancia.dominio.TAD_Chofer;

import static java.util.Objects.isNull;
import sistemaambulancia.dominio.Chofer;
import sistemaambulancia.dominio.TAD_Chofer.ListaChofer;
import sistemaambulancia.dominio.TAD_Chofer.NodoChofer;

public class ListaChofer {
    
    private NodoChofer inicio;

    ListaChofer() {
        inicio = null;
    }

    boolean esVacia() {
        return inicio == null;
    }

    void insertarInicio(Chofer cho) {
        NodoChofer nodo = new NodoChofer(cho);
        if (this.esVacia()) {
            this.inicio = nodo;
        } else {
            nodo.setSiguiente(inicio);
            this.inicio = nodo;
        }
    }

    public void setInicio(NodoChofer nodo) {
        this.inicio = nodo;
    }

    public Chofer head() {
        return inicio.getChofer();
    }

    public ListaChofer tail() {
        ListaChofer tail = new ListaChofer();
        tail.setInicio(this.inicio.getSiguiente());
        return tail;
    }

    public boolean contains(String id) {
        boolean encontre = false;
        Chofer cho;
        ListaChofer listaAux = this;
        while (!listaAux.esVacia() && !encontre) {
            cho = listaAux.head();
            if (cho.getId().equals(id)) {
                encontre = true;
            }else{
                listaAux = listaAux.tail();
            }            
        }
        return encontre;
    }
    
    public Chofer Buscar(String id){
        Chofer cho;
        Chofer resCho = null;
        ListaChofer listaAux = this;
        while (!listaAux.esVacia() && isNull(resCho)) {
            cho = listaAux.head();
            if (cho.getId().equals(id)) {
                resCho = cho;                
            }else{
                listaAux = listaAux.tail();
            }            
        }
        return resCho;
    }
    
    public void insertarOrdenado(Chofer cho){
        if(this.esVacia()){
            this.insertarInicio(cho);
        }else{
            NodoChofer nodoAux = inicio;
            while(nodoAux.getSiguiente()!=null && nodoAux.getSiguiente().getChofer().getId().compareTo(cho.getId()) == -1){
                nodoAux=nodoAux.getSiguiente();
            }
            NodoChofer nodo = new NodoChofer(cho);
            nodo.setSiguiente(nodoAux.getSiguiente());
            nodoAux.setSiguiente(nodo);    
        }
    }
    
}
