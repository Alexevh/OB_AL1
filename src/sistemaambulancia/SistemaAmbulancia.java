/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaambulancia;

public class SistemaAmbulancia implements ISistema {
    
    

    @Override
    public TipoRet eliminarAmbulancia(String ambulanciaID) {
        return TipoRet.NO_IMPLEMENTADA;
    }

    @Override
    public TipoRet crearSistemaDeEmergencias(int cantidadCiudades) {
        return TipoRet.NO_IMPLEMENTADA;
    }

    @Override
    public TipoRet destruirSistemaEmergencias() {
        return TipoRet.NO_IMPLEMENTADA;
    }

    @Override
    public TipoRet registrarAmbulancia(String ambulanciaId, int ciudadID) {
        return TipoRet.NO_IMPLEMENTADA;
    }

    @Override
    public TipoRet deshabilitarAmbulancia(String ambulanciaId) {
        return TipoRet.NO_IMPLEMENTADA;
    }

    @Override
    public TipoRet habilitarAmbulancia(String ambulanciaID) {
        return TipoRet.NO_IMPLEMENTADA;
    }

    @Override
    public TipoRet buscarAmbulancia(String ambulanciaID) {
        return TipoRet.NO_IMPLEMENTADA;
    }

    @Override
    public TipoRet informeAmbulancia() {
        return TipoRet.NO_IMPLEMENTADA;
    }

    @Override
    public TipoRet informeAmbulancia(int ciudadID) {
        return TipoRet.NO_IMPLEMENTADA;
    }

    @Override
    public TipoRet cambiarUbicacion(String ambulanciaID, int ciudadID) {
        return TipoRet.NO_IMPLEMENTADA;
    }

    @Override
    public TipoRet agregarCiudad(String ciudadNombre) {
        return TipoRet.NO_IMPLEMENTADA;
    }

    @Override
    public TipoRet listarCiudades() {
        return TipoRet.NO_IMPLEMENTADA;
    }

    @Override
    public TipoRet agregarRuta(int ciudadOrigen, int ciudadDestino, int minutosViaje) {
        return TipoRet.NO_IMPLEMENTADA;
    }

    @Override
    public TipoRet modificarDemora(int ciudadOrigen, int ciudadDestino, int minutosViaje) {
        return TipoRet.NO_IMPLEMENTADA;
    }

    @Override
    public TipoRet ambulanciaMasCercana(int ciudadID) {
        return TipoRet.NO_IMPLEMENTADA;
    }

    @Override
    public TipoRet rutaMasRapida(int ciudadOrigen, int ciudadDestino) {
        return TipoRet.NO_IMPLEMENTADA;
    }

    @Override
    public TipoRet informeCiudades() {
        return TipoRet.NO_IMPLEMENTADA;
    }

    @Override
    public TipoRet ciudadesEnRadio(int ciudadID, int duracionViaje) {
        return TipoRet.NO_IMPLEMENTADA;
    }

    @Override
    public TipoRet registrarChofer(String ambulanciaID, String nombre, String cedula) {
        return TipoRet.NO_IMPLEMENTADA;
    }

    @Override
    public TipoRet eliminarChofer(String ambulanciaID, String cedula) {
        return TipoRet.NO_IMPLEMENTADA;
    }

    @Override
    public TipoRet informeChoferes(String ambulanciaID) {
        return TipoRet.NO_IMPLEMENTADA;
    }

    
    
}
