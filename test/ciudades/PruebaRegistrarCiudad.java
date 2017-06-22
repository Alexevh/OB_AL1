/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ciudades;

import junit.framework.Assert;
import org.junit.Test;
import sistemaambulancia.ISistema.TipoRet;
import sistemaambulancia.SistemaAmbulancia;

/**
 *
 * @author alex
 */
public class PruebaRegistrarCiudad {
    
    
     @Test
    public void testRegistrarCiudadNoExistente() {
    
        SistemaAmbulancia sistema = new SistemaAmbulancia();
        sistema.crearSistemaDeEmergencias(10);
        TipoRet retornoObtenido = sistema.agregarCiudad("Montevideo");
        TipoRet retornoEsperado = TipoRet.OK;
       
        Assert.assertEquals(retornoObtenido, retornoEsperado);
        
    }
    
      @Test
    public void testRegistrarCiudadExistente() {
    
        SistemaAmbulancia sistema = new SistemaAmbulancia();
        sistema.crearSistemaDeEmergencias(10);
        sistema.agregarCiudad("Montevideo");
        
        TipoRet retornoObtenido = sistema.agregarCiudad("Montevideo");
        TipoRet retornoEsperado = TipoRet.ERROR;
        sistema.destruirSistemaEmergencias();
        Assert.assertEquals(retornoObtenido, retornoEsperado);
        
    }
    
    @Test
    public void testRegistrarCiudadSinCapacidadenSistema() {
    
        SistemaAmbulancia sistema = new SistemaAmbulancia();
        
        sistema.crearSistemaDeEmergencias(3);
        sistema.agregarCiudad("Montevideo");
        sistema.agregarCiudad("Paanado");
        sistema.agregarCiudad("Las Piedras");
        
        //Esta dara el error
        TipoRet retornoObtenido = sistema.agregarCiudad("Las toscas");
        TipoRet retornoEsperado = TipoRet.ERROR;
       
        Assert.assertEquals(retornoObtenido, retornoEsperado);
        
    }
    
       @Test
    public void testListarCiudades() {
    
        SistemaAmbulancia sistema = new SistemaAmbulancia();
        
        sistema.crearSistemaDeEmergencias(5);
        sistema.agregarCiudad("Montevideo");
        sistema.agregarCiudad("Panado");
        sistema.agregarCiudad("Las Piedras");
        
 
        TipoRet retornoObtenido = sistema.listarCiudades();
        TipoRet retornoEsperado = TipoRet.OK;
       
        Assert.assertEquals(retornoObtenido, retornoEsperado);
        
    }
    
    @Test
    public void testListarCiudadesMapaVacio() {
    
        SistemaAmbulancia sistema = new SistemaAmbulancia();
        
        sistema.crearSistemaDeEmergencias(5);
       
        TipoRet retornoObtenido = sistema.listarCiudades();
        TipoRet retornoEsperado = TipoRet.OK;
       
        Assert.assertEquals(retornoObtenido, retornoEsperado);
        
    }
}
