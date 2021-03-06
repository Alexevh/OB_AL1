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
    private Integer cantidad;

    public Integer getCantidad() {
        return cantidad;
    }

    public ListaAmbulancia() {
        inicio = null;
        cantidad = 0;
    }

    public boolean esVacia() {
        return inicio == null;
    }

    public void insertarInicio(Ambulancia amb) {
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
        tail.cantidad = this.cantidad - 1;
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
            } else {
                listaAux = listaAux.tail();
            }
        }
        return encontre;
    }

    public Ambulancia buscar(String id) {
        Ambulancia amb;
        Ambulancia resAmb = null;
        ListaAmbulancia listaAux = this;
        while (!listaAux.esVacia() && isNull(resAmb)) {
            amb = listaAux.head();
            if (amb.getId().equals(id)) {
                resAmb = amb;
            } else {
                listaAux = listaAux.tail();
            }
        }
        return resAmb;
    }
    
    public Ambulancia buscarUnaAmbulanciaDisponible() {
        Ambulancia amb = null;
        ListaAmbulancia listaAux = this;
        while (!listaAux.esVacia() && isNull(amb)) {
            if(listaAux.head().getEstado()==Ambulancia.TipoEstado.DISPONIBLE)
                amb=listaAux.head();
            listaAux = listaAux.tail();
        }
        return amb;
    }

    public void insertarOrdenado(Ambulancia amb) {
        if (this.esVacia()) {
            this.insertarInicio(amb);
        } else {
            NodoAmbulancia nodoAux = inicio;
            while (nodoAux.getSiguiente() != null && nodoAux.getSiguiente().getAmbulancia().getId().compareTo(amb.getId()) == -1) {
                nodoAux = nodoAux.getSiguiente();
            }
            NodoAmbulancia nodo = new NodoAmbulancia(amb);
            nodo.setSiguiente(nodoAux.getSiguiente());
            nodoAux.setSiguiente(nodo);
        }
        this.cantidad++;
    }

    public void eliminarAmbulancia(Ambulancia amb) {
        if (!this.esVacia() && this.contains(amb.getId())) {

            NodoAmbulancia nodoAux = inicio;
            if (nodoAux.getAmbulancia().equals(amb)) {
                this.inicio = nodoAux.getSiguiente();
            } else {
                while (!nodoAux.getSiguiente().getAmbulancia().equals(amb)) {
                    nodoAux = nodoAux.getSiguiente();
                }
                NodoAmbulancia nodoEliminado = nodoAux.getSiguiente();
                nodoAux.setSiguiente(nodoAux.getSiguiente().getSiguiente());                
                nodoEliminado.setSiguiente(null);
            }
            this.cantidad--;
        }
    }
    
    public Integer cantidadDisponibles(){
        Ambulancia amb;        
        ListaAmbulancia listaAux = this;
        int cantAmb = 0;
        while (!listaAux.esVacia()) {
            amb = listaAux.head();
            if (amb.getEstado()==Ambulancia.TipoEstado.DISPONIBLE) {
                cantAmb++;
            }
            listaAux = listaAux.tail();
        }
        return cantAmb;   
    }
    
    public Integer cantidadNoDisponibles(){
        Ambulancia amb;        
        ListaAmbulancia listaAux = this;
        int cantAmb = 0;
        while (!listaAux.esVacia()) {
            amb = listaAux.head();
            if (amb.getEstado()==Ambulancia.TipoEstado.NO_DISPONIBLE) {
                cantAmb++;
            }
            listaAux = listaAux.tail();
        }
        return cantAmb;   
    }

    public void destroy() {
        ListaAmbulancia lista = this;
        while (!lista.esVacia()) {            
            lista.head().destroy();            
            lista = lista.tail();
        }
        this.inicio=null;
        this.cantidad=null;
    }
    
    @Override
    public String toString() {
        ListaAmbulancia lista = this;
        String listaStr = "";
        while (!lista.esVacia()) {
            listaStr += lista.head().toString()+"\n";
            lista = lista.tail();
        }
        return listaStr;
    }
    
}
