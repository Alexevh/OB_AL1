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
public class pruebasDeshabilitarAmbulancias {
    
        @Test
    public void testDesHabilitarUnaAmbulanciaExistente(){
        
        SistemaAmbulancia sistema = new SistemaAmbulancia();
        sistema.crearSistemaDeEmergencias(10);
        sistema.agregarCiudad("Montevideo");
        sistema.registrarAmbulancia("MON123", 1);
    
        ISistema.TipoRet retornoObtenido = sistema.deshabilitarAmbulancia("MON123");
        ISistema.TipoRet retornoEsperado = ISistema.TipoRet.OK;
        
        Assert.assertEquals(retornoObtenido,retornoEsperado);
    }
    
    
    @Test
    public void testDesHabilitarUnaAmbulanciaNoExistente(){
        
        SistemaAmbulancia sistema = new SistemaAmbulancia();
        sistema.crearSistemaDeEmergencias(10);
       
    
        ISistema.TipoRet retornoObtenido = sistema.deshabilitarAmbulancia("MON123");
        ISistema.TipoRet retornoEsperado = ISistema.TipoRet.ERROR;
        
        Assert.assertEquals(retornoObtenido,retornoEsperado);
    }
    
        @Test
    public void testDesHabilitarUnaAmbulanciaYaNoDisponible(){
        
        SistemaAmbulancia sistema = new SistemaAmbulancia();
        sistema.crearSistemaDeEmergencias(10);
        sistema.agregarCiudad("Montevideo");
        sistema.registrarAmbulancia("MON123", 1);
    
        //Deshabilito la ambulancia
        sistema.deshabilitarAmbulancia("MON123");
        
        //Deshabilutamos la ambulancia ya deshabilitada
        ISistema.TipoRet retornoObtenido = sistema.deshabilitarAmbulancia("MON123");
        ISistema.TipoRet retornoEsperado = ISistema.TipoRet.ERROR;
        
        Assert.assertEquals(retornoObtenido,retornoEsperado);
    }
    
    @Test
    public void testDesHabilitarUnaAmbulanciaAsignadaAunVIaje(){
        
        SistemaAmbulancia sistema = new SistemaAmbulancia();
        sistema.crearSistemaDeEmergencias(10);
        sistema.agregarCiudad("Montevideo");
        sistema.registrarAmbulancia("MON123", 1);
        
        Ambulancia amb = sistema.getListaAmbulancias().buscar("MON123");
        amb.setEstado(Ambulancia.TipoEstado.ATENDIENDO);
        
      
        //Deshabilutamos la ambulancia asignada a un viaje
        ISistema.TipoRet retornoObtenido = sistema.deshabilitarAmbulancia("MON123");
        ISistema.TipoRet retornoEsperado = ISistema.TipoRet.ERROR;
        
        Assert.assertEquals(retornoObtenido,retornoEsperado);
    }
    
    
}
