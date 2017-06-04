/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ambulancias;

import org.junit.Assert;
import org.junit.Test;
import sistemaambulancia.ISistema;
import sistemaambulancia.SistemaAmbulancia;
import sistemaambulancia.dominio.Ambulancia;

/**
 *
 * @author alex
 */
public class pruebasCambiarUbicacionAmbulancia {
    
    @Test
    public void testCambiarUbicacionAMbulancia(){
        
        
        
        SistemaAmbulancia sistema = new SistemaAmbulancia();
        sistema.crearSistemaDeEmergencias(10);
        sistema.agregarCiudad("Montevideo");
        sistema.agregarCiudad("Pando");
        sistema.agregarCiudad("La Floresta");
        sistema.agregarCiudad("Las Piedras");
        sistema.registrarAmbulancia("MON123", 1);
        sistema.registrarAmbulancia("MON145", 1);
        sistema.registrarAmbulancia("MON721", 1);
        sistema.registrarAmbulancia("MON101", 1);
        sistema.registrarAmbulancia("AAA101", 1);
        //Asignamos la ambulancia a un viaje
        sistema.getListaAmbulancias().buscar("MON123").setEstado(Ambulancia.TipoEstado.ATENDIENDO);
        
       ISistema.TipoRet retornoObtenido = sistema.cambiarUbicacion("MON123", 2);
       ISistema.TipoRet retornoEsperado = ISistema.TipoRet.OK;
       Assert.assertEquals(retornoObtenido,retornoEsperado);
    }
    
    
        @Test
    public void testCambiarUbicacionAMbulancianciaNoExistente(){
        
        
        
        SistemaAmbulancia sistema = new SistemaAmbulancia();
        sistema.crearSistemaDeEmergencias(10);
        sistema.agregarCiudad("Montevideo");
        sistema.agregarCiudad("Pando");
        sistema.agregarCiudad("La Floresta");
        sistema.agregarCiudad("Las Piedras");
        sistema.registrarAmbulancia("MON123", 1);
        sistema.registrarAmbulancia("MON145", 1);
        sistema.registrarAmbulancia("MON721", 1);
        sistema.registrarAmbulancia("MON101", 1);
        sistema.registrarAmbulancia("AAA101", 1);
        //Asignamos la ambulancia a un viaje
        sistema.getListaAmbulancias().buscar("MON123").setEstado(Ambulancia.TipoEstado.ATENDIENDO);
        
       ISistema.TipoRet retornoObtenido = sistema.cambiarUbicacion("MON125", 2);
       ISistema.TipoRet retornoEsperado = ISistema.TipoRet.ERROR;
       Assert.assertEquals(retornoObtenido,retornoEsperado);
    }
    
    
    
    
        @Test
    public void testCambiarUbicacionAMbulanciaCiudadNoExistente(){
        
        
        
        SistemaAmbulancia sistema = new SistemaAmbulancia();
        sistema.crearSistemaDeEmergencias(10);
        sistema.agregarCiudad("Montevideo");
        sistema.agregarCiudad("Pando");
        sistema.agregarCiudad("La Floresta");
        sistema.agregarCiudad("Las Piedras");
        sistema.registrarAmbulancia("MON123", 1);
        sistema.registrarAmbulancia("MON145", 1);
        sistema.registrarAmbulancia("MON721", 1);
        sistema.registrarAmbulancia("MON101", 1);
        sistema.registrarAmbulancia("AAA101", 1);
        //Asignamos la ambulancia a un viaje
        sistema.getListaAmbulancias().buscar("MON123").setEstado(Ambulancia.TipoEstado.ATENDIENDO);
        
       ISistema.TipoRet retornoObtenido = sistema.cambiarUbicacion("MON123", 9);
       ISistema.TipoRet retornoEsperado = ISistema.TipoRet.ERROR;
       Assert.assertEquals(retornoObtenido,retornoEsperado);
    }
}
