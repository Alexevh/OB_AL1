/*
 * To change this license header, ciuose License Headers in Project Properties.
 * To change this template file, ciuose Tools | Templates
 * and open the template in the editor.
 */
package sistemaambulancia.dominio.TAD_Ciudad;

import sistemaambulancia.dominio.TAD_Ciudad.*;
import static java.util.Objects.isNull;
import sistemaambulancia.dominio.Ciudad;
import sistemaambulancia.dominio.TAD_Ciudad.ListaCiudad;
import sistemaambulancia.dominio.TAD_Ciudad.NodoCiudad;

public class ListaCiudad {

    private NodoCiudad inicio;
    private Integer cantidad;

    public Integer getCantidad() {
        return cantidad;
    }

    public ListaCiudad() {
        inicio = null;
        cantidad = 0;
    }

    public boolean esVacia() {
        return inicio == null;
    }

    public void insertarInicio(Ciudad ciu) {
        NodoCiudad nodo = new NodoCiudad(ciu);
        if (this.esVacia()) {
            this.inicio = nodo;
        } else {
            nodo.setSiguiente(inicio);
            this.inicio = nodo;
        }
        this.cantidad++;
    }

    public void setInicio(NodoCiudad nodo) {
        this.inicio = nodo;
    }

    public Ciudad head() {
        return inicio.getCiudad();
    }

    public ListaCiudad tail() {
        ListaCiudad tail = new ListaCiudad();
        tail.setInicio(this.inicio.getSiguiente());
        tail.cantidad = this.cantidad - 1;
        return tail;
    }

    public boolean contains(String nombre) {
        boolean encontre = false;
        Ciudad ciu;
        ListaCiudad listaAux = this;
        while (!listaAux.esVacia() && !encontre) {
            ciu = listaAux.head();
            if (ciu.getNombre().equals(nombre)) {
                encontre = true;
            } else {
                listaAux = listaAux.tail();
            }
        }
        return encontre;
    }

    public Ciudad buscar(Integer id) {
        Ciudad ciu;
        Ciudad resCiu = null;
        ListaCiudad listaAux = this;
        while (!listaAux.esVacia() && isNull(resCiu)) {
            ciu = listaAux.head();
            if (ciu.getId().equals(id)) {
                resCiu = ciu;
            } else {
                listaAux = listaAux.tail();
            }
        }
        return resCiu;
    }

    public void insertarOrdenado(Ciudad ciu) {
        if (this.esVacia()) {
            this.insertarInicio(ciu);
        } else {
            NodoCiudad nodoAux = inicio;
            while (nodoAux.getSiguiente() != null && nodoAux.getSiguiente().getCiudad().getId().compareTo(ciu.getId()) == -1) {
                nodoAux = nodoAux.getSiguiente();
            }
            NodoCiudad nodo = new NodoCiudad(ciu);
            nodo.setSiguiente(nodoAux.getSiguiente());
            nodoAux.setSiguiente(nodo);
        }
        this.cantidad++;
    }
    
    public void eliminarCiudad(Ciudad ciu) {
        if (!this.esVacia() && this.contains(ciu.getNombre())) {
            NodoCiudad nodoAux = inicio;
            if (nodoAux.getCiudad().equals(ciu)) {
                this.inicio = nodoAux.getSiguiente();
            } else {
                while (!nodoAux.getSiguiente().getCiudad().equals(ciu)) {
                    nodoAux=nodoAux.getSiguiente();
                }
                nodoAux.setSiguiente(nodoAux.getSiguiente().getSiguiente());
                
                NodoCiudad nodoEliminado = nodoAux.getSiguiente();                
                nodoEliminado.setSiguiente(null);
            }
            this.cantidad--;
        }
    }

    public Integer getIdNoAsignado() {
        Integer idMenor = cantidad;
        Integer i = 0;
        Ciudad ciu;
        boolean encontre = false;
        ListaCiudad listaAux = this;
        while (!listaAux.esVacia() && !encontre) {
            ciu = listaAux.head();
            if (ciu.getId().equals(i)) {
                listaAux = listaAux.tail();
                i++;
            } else {
                encontre = true;
                idMenor=i;
            }
        }
        return idMenor;
    }
    
    public void destroy() {
        ListaCiudad lista = this;
        while (!lista.esVacia()) {            
            lista.head().destroy();            
            lista = lista.tail();
        }
        this.inicio=null;
        this.cantidad=null;
    }

}
