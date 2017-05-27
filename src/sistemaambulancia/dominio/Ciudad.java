/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaambulancia.dominio;

import sistemaambulancia.dominio.TAD_Ambulancia.ListaAmbulancia;

public class Ciudad {

    private Integer id;
    private String nombre;
    ListaAmbulancia ambulancias;

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public ListaAmbulancia getAmbulancias() {
        return ambulancias;
    }

    public Ciudad(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.ambulancias = new ListaAmbulancia();
    }

    
}
