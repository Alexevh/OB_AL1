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
    private Integer cantidad;
    
    public Integer getCantidad(){
        return cantidad;
    }

    public ListaChofer() {
        inicio = null;
        cantidad = 0;
    }

    public boolean esVacia() {
        return inicio == null;
    }

    public void insertarInicio(Chofer cho) {
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
        tail.cantidad = this.cantidad - 1;
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
    
    public Chofer buscar(String id){
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
        this.cantidad++;
    }
    
    public void eliminarChofer(Chofer cho) {
        if (!this.esVacia() && this.contains(cho.getId())) {

            NodoChofer nodoAux = inicio;
            if (nodoAux.getChofer().equals(cho)) {
                this.inicio = nodoAux.getSiguiente();
            } else {
                while (!nodoAux.getSiguiente().getChofer().equals(cho)) {
                    nodoAux=nodoAux.getSiguiente();
                }
                nodoAux.setSiguiente(nodoAux.getSiguiente().getSiguiente());
                
                NodoChofer nodoEliminado = nodoAux.getSiguiente();                
                nodoEliminado.setSiguiente(null);
            }
            this.cantidad--;
        }
    }
    
    public void destroy() {
        ListaChofer lista = this;
        while (!lista.esVacia()) {            
            lista.head().destroy();            
            lista = lista.tail();
        }
        this.inicio=null;
        this.cantidad=null;
    }
    
}
