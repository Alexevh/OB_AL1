/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaambulancia;

import static java.util.Objects.isNull;
import sistemaambulancia.dominio.*;
import sistemaambulancia.dominio.TAD_Ambulancia.ListaAmbulancia;
import sistemaambulancia.dominio.TAD_Chofer.ListaChofer;
import sistemaambulancia.dominio.TAD_Ciudad.ListaCiudad;

public class SistemaAmbulancia implements ISistema {

    private Integer cantCiudades;
    private ListaAmbulancia listaAmbulancias;
    private ListaChofer listaChoferes;
    private ListaCiudad listaCiudades;
    private Integer[][] MapaCiudades;

    public Integer[][] getMapaCiudades() {
        return MapaCiudades;
    }

    public void setMapaCiudades(Integer[][] MapaCiudades) {
        this.MapaCiudades = MapaCiudades;
    }
    
    
    

    @Override
    public Integer getCantCiudades() {
        return cantCiudades;
    }

    @Override
    public ListaAmbulancia getListaAmbulancias() {
        return listaAmbulancias;
    }

    @Override
    public ListaChofer getListaChoferes() {
        return listaChoferes;
    }

    @Override
    public ListaCiudad getListaCiudades() {
        return listaCiudades;
    }
    
    public SistemaAmbulancia() {
        this.cantCiudades = null;
        this.listaAmbulancias = new ListaAmbulancia();
        this.listaChoferes = new ListaChofer();
        this.listaCiudades = new ListaCiudad();
    }
    
    //NO DEBERÍA SER STATIC?
    @Override
    public TipoRet crearSistemaDeEmergencias(int cantCiudades) {
        TipoRet ret = TipoRet.NO_IMPLEMENTADA;

        if (cantCiudades <= 0) {
            ret = TipoRet.ERROR;
            System.out.println("La cantidad de ciudades es inferior a 1.");
        } else {
            this.cantCiudades = cantCiudades;
            MapaCiudades = new Integer[cantCiudades][cantCiudades];
            ret = TipoRet.OK;
        }
        return ret;
    }

    //NO DEBERÍA SER STATIC?
    //LIBERA TODA LA MEMORIA UTILIZADA?
    @Override
    public TipoRet destruirSistemaEmergencias() {
        TipoRet ret = TipoRet.OK;
        listaAmbulancias = null;
        listaCiudades = null;
        listaChoferes = null;
        cantCiudades = null;
        return ret;
    }
    
    

    @Override
    public TipoRet eliminarAmbulancia(String ambulanciaID) {
        TipoRet ret = TipoRet.NO_IMPLEMENTADA;

        Ambulancia amb = listaAmbulancias.buscar(ambulanciaID);
        if (isNull(amb)) {
            ret = TipoRet.ERROR;
            System.out.println("No existe una ambulancia con identificador " + ambulanciaID + ".");
        } else if (amb.getEstado() == Ambulancia.TipoEstado.ATENDIENDO) {
            ret = TipoRet.ERROR;
            System.out.println("No es posible eliminar la ambulancia " + ambulanciaID + ".");
        } else {
            ListaChofer choferesAmbulanciaEliminada = amb.getChoferes();
            Ciudad ciu = amb.getCiudad();
            ciu.getAmbulancias().eliminarAmbulancia(amb);
            listaAmbulancias.eliminarAmbulancia(amb);
            
            while (!choferesAmbulanciaEliminada.esVacia()) {
                Chofer cho = choferesAmbulanciaEliminada.head();
                cho.setAmbulancia(null);
                choferesAmbulanciaEliminada = choferesAmbulanciaEliminada.tail();
            }
            ret = TipoRet.OK;
        }
        return ret;
    }

    @Override
    public TipoRet registrarAmbulancia(String ambulanciaID, int ciudadID) {
        TipoRet ret = TipoRet.NO_IMPLEMENTADA;
        Ciudad ciu = listaCiudades.buscar(ciudadID);
        if (isNull(ciu)) {
            ret = TipoRet.ERROR;
            System.out.println("La ciudad " + ciudadID + " no existe.");
        } else if (listaAmbulancias.contains(ambulanciaID)) {
            ret = TipoRet.ERROR;
            System.out.println("Ya existe una ambulancia con identificador " + ambulanciaID + ".");
        } else {
            Ambulancia amb = new Ambulancia(ambulanciaID, ciu);
            listaAmbulancias.insertarOrdenado(amb);
            ciu.getAmbulancias().insertarOrdenado(amb);
            ret = TipoRet.OK;
        }
        return ret;
    }

    @Override
    public TipoRet deshabilitarAmbulancia(String ambulanciaID) {
        TipoRet ret = TipoRet.NO_IMPLEMENTADA;

        Ambulancia amb = listaAmbulancias.buscar(ambulanciaID);
        if (isNull(amb)) {
            ret = TipoRet.ERROR;
            System.out.println("No existe una ambulancia con identificador " + ambulanciaID + ".");
        } else if (amb.getEstado() == Ambulancia.TipoEstado.NO_DISPONIBLE) {
            ret = TipoRet.ERROR;
            System.out.println("La ambulancia " + ambulanciaID + " ya está en estado NO_DISPONIBLE.");
        } else if (amb.getEstado() == Ambulancia.TipoEstado.ATENDIENDO) {
            ret = TipoRet.ERROR;
            System.out.println("No es posible deshabilitar la ambulancia " + ambulanciaID + ".");
        } else {
            amb.setEstado(Ambulancia.TipoEstado.NO_DISPONIBLE);
            ret = TipoRet.OK;
        }
        return ret;
    }

    @Override
    public TipoRet habilitarAmbulancia(String ambulanciaID) {
        TipoRet ret = TipoRet.NO_IMPLEMENTADA;

        Ambulancia amb = listaAmbulancias.buscar(ambulanciaID);
        if (isNull(amb)) {
            ret = TipoRet.ERROR;
            System.out.println("No existe una ambulancia con identificador " + ambulanciaID + ".");
        } else if (amb.getEstado() == Ambulancia.TipoEstado.DISPONIBLE) {
            ret = TipoRet.ERROR;
            System.out.println("La ambulancia " + ambulanciaID + " ya está habilitada.");
        } else {
            amb.setEstado(Ambulancia.TipoEstado.DISPONIBLE);
            ret = TipoRet.OK;
        }
        return ret;
    }

    @Override
    public TipoRet buscarAmbulancia(String ambulanciaID) {
        TipoRet ret = TipoRet.NO_IMPLEMENTADA;

        Ambulancia amb = listaAmbulancias.buscar(ambulanciaID);
        if (isNull(amb)) {
            ret = TipoRet.ERROR;
            System.out.println("No existe una ambulancia con identificador " + ambulanciaID + ".");
        } else {
            System.out.println("Datos ambulancia: " + amb.getId());
            System.out.println("Estado: " + amb.getEstado());
            System.out.println("Ciudad: " + amb.getCiudad().getNombre());
            System.out.println("#Emergencias: " + amb.getEmergencias());
            ret = TipoRet.OK;
        }
        return ret;
    }

    @Override
    public TipoRet informeAmbulancia() {
        TipoRet ret = TipoRet.NO_IMPLEMENTADA;

        ListaAmbulancia listaAux = listaAmbulancias;
        if (listaAux.esVacia()) {
            ret = TipoRet.OK;
            System.out.println("No se han registrado ambulancias.");
        } else {
            Ambulancia amb;
            while (!listaAux.esVacia()) {
                amb = listaAux.head();
                System.out.println(amb.getId() + " - " + amb.getEstado() + " - " + amb.getCiudad().getNombre());
                listaAux = listaAux.tail();
            }
            ret = TipoRet.OK;
        }
        return ret;
    }

    @Override
    public TipoRet informeAmbulancia(int ciudadID) {
        TipoRet ret = TipoRet.NO_IMPLEMENTADA;

        Ciudad ciu = listaCiudades.buscar(ciudadID);
        if (isNull(ciu)) {
            ret = TipoRet.ERROR;
            System.out.println("La ciudad " + ciudadID + " no existe.");
        } else {
            ListaAmbulancia listaAux = ciu.getAmbulancias();
            if (listaAux.esVacia()) {
                ret = TipoRet.ERROR;
                System.out.println("No se han registrado ambulancias.");
            } else {
                Ambulancia amb;
                Integer totalDisponibles = 0;
                System.out.println("Informe de ambulancias en: " + ciu.getId() + " - " + ciu.getNombre());
                while (!listaAux.esVacia()) {
                    amb = listaAux.head();
                    if (amb.getEstado() == Ambulancia.TipoEstado.DISPONIBLE) {
                        System.out.println("Ambulancia: " + amb.getId());
                        totalDisponibles++;
                    }
                    listaAux = listaAux.tail();
                }
                System.out.println("Total Ambulancias disponibles: " + totalDisponibles);
                ret = TipoRet.OK;
            }
        }
        return ret;
    }

    @Override
    public TipoRet cambiarUbicacion(String ambulanciaID, int ciudadID) {
        TipoRet ret = TipoRet.NO_IMPLEMENTADA;

        Ciudad ciu = listaCiudades.buscar(ciudadID);
        Ambulancia amb = listaAmbulancias.buscar(ambulanciaID);
        if (isNull(ciu)) {
            ret = TipoRet.ERROR;
            System.out.println("La ciudad " + ciudadID + " no existe.");
        } else if (isNull(amb)) {
            System.out.println("No existe una ambulancia con identificador " + ambulanciaID + ".");
            ret = TipoRet.ERROR;
        } else {
            Ciudad ciuAnterior = amb.getCiudad();
            ciuAnterior.getAmbulancias().eliminarAmbulancia(amb);
            amb.setCiudad(ciu);
            ret = TipoRet.OK;
        }
        return ret;
    }

    @Override
    public TipoRet agregarCiudad(String ciudadNombre) {
        TipoRet ret = TipoRet.NO_IMPLEMENTADA;

        Integer idLibre = listaCiudades.getIdNoAsignado();
        if (idLibre >= cantCiudades) {
            ret = TipoRet.ERROR;
            System.out.println("No se puede ingresar la ciudad '" + ciudadNombre + "' al sistema por no tener más capacidad.");
        } else if (listaCiudades.contains(ciudadNombre)) {
            ret = TipoRet.ERROR;
            System.out.println("La ciudad '" + ciudadNombre + "' ya existe en el sistema.");
        } else {
            Ciudad ciu = new Ciudad(idLibre, ciudadNombre);
            listaCiudades.insertarOrdenado(ciu);
            ret = TipoRet.OK;
        }
        return ret;
    }

    @Override
    public TipoRet listarCiudades() {
        TipoRet ret = TipoRet.NO_IMPLEMENTADA;

        ListaCiudad listaAux = listaCiudades;
        if (listaAux.esVacia()) {
            System.out.println("No existen ciudades en el mapa.");
            ret = TipoRet.OK;
        } else {
            Ciudad ciu;
            while (!listaAux.esVacia()) {
                ciu = listaAux.head();
                System.out.println(ciu.getId() + " - " + ciu.getNombre());
                listaAux = listaAux.tail();
            }
            ret = TipoRet.OK;
        }
        return ret;
    }

    @Override
    public TipoRet agregarRuta(int ciudadOrigen, int ciudadDestino, int minutosViaje) {
        TipoRet ret = TipoRet.OK;

        if (this.listaCiudades.buscar(ciudadOrigen) ==null)
        {
            
            System.out.println("La ciudad "+ciudadOrigen+" no existe");
            ret = TipoRet.ERROR;
            return ret;
        } else if (this.listaCiudades.buscar(ciudadDestino) ==null)
        {
            System.out.println("La ciudad "+ciudadDestino+" no existe");
            ret = TipoRet.ERROR;
            return ret;
            
        } else if (minutosViaje <=0)
        {
            System.out.println("La duracion del viaje debe ser mayor que 0.");
            ret = TipoRet.ERROR;
            return ret;
        } else {
            
            this.MapaCiudades[ciudadOrigen][ciudadDestino] = minutosViaje;
            this.MapaCiudades[ciudadDestino][ciudadOrigen] = minutosViaje;
            ret = TipoRet.OK;
        
            return ret;
        }
            
            
        
    }

    @Override
    public TipoRet modificarDemora(int ciudadOrigen, int ciudadDestino, int minutosViaje) {
       
           TipoRet ret = TipoRet.OK;

        if (this.listaCiudades.buscar(ciudadOrigen) ==null)
        {
            
            System.out.println("La ciudad "+ciudadOrigen+" no existe");
            ret = TipoRet.ERROR;
            return ret;
        } else if (this.listaCiudades.buscar(ciudadDestino) ==null)
        {
            System.out.println("La ciudad "+ciudadDestino+" no existe");
            ret = TipoRet.ERROR;
            return ret;
            
        } else if (minutosViaje <=0)
        {
            System.out.println("La duracion del viaje debe ser mayor que 0.");
            ret = TipoRet.ERROR;
            return ret;
        } else {
            
            this.MapaCiudades[ciudadOrigen][ciudadDestino] = minutosViaje;
            this.MapaCiudades[ciudadDestino][ciudadOrigen] = minutosViaje;
            ret = TipoRet.OK;
        
            return ret;
        
    }
        
    }

    @Override
    public TipoRet ambulanciaMasCercana(int ciudadID) {
        TipoRet ret = TipoRet.NO_IMPLEMENTADA;

        int filas = this.MapaCiudades.length;
        int columnas = this.MapaCiudades[0].length;
        int ciudadCercana = 0;
        
        //Recorro las filas
        for (int i=0; i<filas; i++)
        {
          
        }
        
        
        
        return ret;
    }

    @Override
    public TipoRet rutaMasRapida(int ciudadOrigen, int ciudadDestino) {
        TipoRet ret = TipoRet.NO_IMPLEMENTADA;

        return ret;
    }

    @Override
    public TipoRet informeCiudades() {
        TipoRet ret = TipoRet.NO_IMPLEMENTADA;

        return ret;
    }

    @Override
    public TipoRet ciudadesEnRadio(int ciudadID, int duracionViaje) {
        TipoRet ret = TipoRet.NO_IMPLEMENTADA;

        return ret;
    }

    //PRE: No existe un chofer con cedula=choferID habilitado para conducir la ambulanciaID.
    //POR QUÉ NO HACER UN CONTAINS DENTRO E INFORMAR CON UN MENSAJE EN CASO DE QUE YA EXISTE? (COMO EN ELIMINARCHOFER)
    @Override
    public TipoRet registrarChofer(String ambulanciaID, String nombre, String cedula) {
        TipoRet ret = TipoRet.NO_IMPLEMENTADA;

        Ambulancia amb = listaAmbulancias.buscar(ambulanciaID);
        if (isNull(amb)) {
            System.out.println("No existe una ambulancia con identificador " + ambulanciaID + ".");
            ret = TipoRet.ERROR;
        } else {
            Chofer cho = new Chofer(cedula, nombre, amb);
            listaChoferes.insertarOrdenado(cho);
            amb.getChoferes().insertarOrdenado(cho);
            ret = TipoRet.OK;
        }
        return ret;
    }

    @Override
    public TipoRet eliminarChofer(String ambulanciaID, String cedula) {
        TipoRet ret = TipoRet.NO_IMPLEMENTADA;

        Ambulancia amb = listaAmbulancias.buscar(ambulanciaID);
        Chofer cho = listaChoferes.buscar(cedula);
        if (isNull(amb)) {
            ret = TipoRet.ERROR;
            System.out.println("No existe una ambulancia con identificador " + ambulanciaID + ".");
        } else if (isNull(cho)) {
            ret = TipoRet.ERROR;
            System.out.println("No existe un chofer con cedula " + cedula + ".");
        } else if (!amb.getChoferes().contains(cedula)) {
            ret = TipoRet.ERROR;
            System.out.println("La ambulancia " + ambulanciaID + " no tiene asignado al chofer de cedula " + cedula + ".");
        } else {
            ret = TipoRet.OK;
            amb.getChoferes().eliminarChofer(cho);
        }
        return ret;
    }

    @Override
    public TipoRet informeChoferes(String ambulanciaID) {
        TipoRet ret = TipoRet.NO_IMPLEMENTADA;

        Ambulancia amb = listaAmbulancias.buscar(ambulanciaID);
        if (isNull(amb)) {
            ret = TipoRet.ERROR;
            System.out.println("No existe una ambulancia con identificador " + ambulanciaID + ".");
        } else {
            Chofer cho;
            ListaChofer listaAux = amb.getChoferes();
            if (listaAux.esVacia()) {
                System.out.println("No hay choferes asignados a la ambulancia con identificador " + ambulanciaID + ".");
            }
            while (!listaAux.esVacia()) {
                cho = listaAux.head();
                System.out.println("Nombre: " + cho.getNombre() + ", Cédula: " + cho.getId());
                listaAux = listaAux.tail();
            }
            ret = TipoRet.OK;
        }
        return ret;
    }
    
    
    public void poblarCiudades()
    {
     
       this.agregarCiudad("Montevideo");
       this.agregarCiudad("Canelones");
       this.agregarCiudad("Las Piedras");
       
       
        
        
    }        

    
    
}
