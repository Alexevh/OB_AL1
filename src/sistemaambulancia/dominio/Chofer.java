/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaambulancia.dominio;

public class Chofer {
    
    private String cedula;
    private String nombre;
    private Ambulancia ambulancia;
    
    public String getId(){
        return cedula;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public Ambulancia getAmbulancia(){
        return ambulancia;
    }
    
    
}
