/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaambulancia.dominio;

import static java.util.Objects.isNull;
import sistemaambulancia.dominio.TAD_Chofer.ListaChofer;

public class Ambulancia {

    public enum TipoEstado {
        NO_DISPONIBLE, DISPONIBLE, ATENDIENDO
    }

    private String id;
    private TipoEstado estado;
    private Ciudad ciudad;
    private ListaChofer choferes;
    private Integer emergencias;

    public String getId() {
        return id;
    }

    public TipoEstado getEstado() {
        return estado;
    }

    public void setEstado(TipoEstado estado) {
        this.estado = estado;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public ListaChofer getChoferes() {
        return choferes;
    }

    public Integer getEmergencias() {
        return emergencias;
    }

    public void incrementarEmergencias() {
        this.emergencias++;
    }

    public Ambulancia(String id, Ciudad ciudad) {
        this.id = id;
        this.ciudad = ciudad;
        this.estado = TipoEstado.DISPONIBLE;
        this.emergencias = 0;
        this.choferes = new ListaChofer();
    }

    public void destroy() {
        if (!isNull(this.choferes)) {
            this.choferes.destroy();
            this.choferes=null;
        }
            this.id = null;
            this.estado = null;
            this.emergencias = null;        
    }
    
    @Override
    public String toString() {
        return this.getId();
    }
    
}
