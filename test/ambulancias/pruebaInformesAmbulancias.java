/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ambulancias;

import org.junit.Assert;
import org.junit.Test;
import sistemaambulancia.ISistema;
import sistemaambulancia.ISistema.TipoRet;
import sistemaambulancia.SistemaAmbulancia;
import sistemaambulancia.dominio.Ambulancia;

/**
 *
 * @author alex
 */
public class pruebaInformesAmbulancias {
    
    @Test
    public void testInformeAmbulancias(){
        
        
        
        SistemaAmbulancia sistema = new SistemaAmbulancia();
        sistema.crearSistemaDeEmergencias(10);
        sistema.agregarCiudad("Montevideo");
        sistema.registrarAmbulancia("MON123", 1);
        sistema.registrarAmbulancia("MON145", 1);
        sistema.registrarAmbulancia("MON721", 1);
        sistema.registrarAmbulancia("MON101", 1);
        sistema.registrarAmbulancia("AAA101", 1);
        //Asignamos la ambulancia a un viaje
        sistema.getListaAmbulancias().buscar("MON123").setEstado(Ambulancia.TipoEstado.ATENDIENDO);
        
       TipoRet retornoObtenido = sistema.informeAmbulancia();
       TipoRet retornoEsperado = TipoRet.OK;
        Assert.assertEquals(retornoObtenido,retornoEsperado);
    }
    
    
        @Test
    public void testInformeAmbulanciasSinAmbulanciasRegistradas(){
        
        
        
        SistemaAmbulancia sistema = new SistemaAmbulancia();
        sistema.crearSistemaDeEmergencias(10);
        sistema.agregarCiudad("Montevideo");
       
        
       TipoRet retornoObtenido = sistema.informeAmbulancia();
       TipoRet retornoEsperado = TipoRet.OK;
       Assert.assertEquals(retornoObtenido,retornoEsperado);
    }
    
    
    
    @Test
    public void testInformeAmbulanciasPorCiudad(){
        
        
        
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
        
       TipoRet retornoObtenido = sistema.informeAmbulancia(1);
       TipoRet retornoEsperado = TipoRet.OK;
        Assert.assertEquals(retornoObtenido,retornoEsperado);
    }
    
    
        @Test
    public void testInformeAmbulanciasPorCiudadNoExiste(){
        
        
        
        SistemaAmbulancia sistema = new SistemaAmbulancia();
        sistema.crearSistemaDeEmergencias(10);
        sistema.agregarCiudad("Montevideo");        
        sistema.registrarAmbulancia("MON123", 1);
        sistema.registrarAmbulancia("MON145", 1);
        sistema.registrarAmbulancia("MON721", 1);
        sistema.registrarAmbulancia("MON101", 1);
        sistema.registrarAmbulancia("AAA101", 1);
        //Asignamos la ambulancia a un viaje
        sistema.getListaAmbulancias().buscar("MON123").setEstado(Ambulancia.TipoEstado.ATENDIENDO);
        
       TipoRet retornoObtenido = sistema.informeAmbulancia(2);
       TipoRet retornoEsperado = TipoRet.ERROR;
       Assert.assertEquals(retornoObtenido,retornoEsperado);
    }
    
}
