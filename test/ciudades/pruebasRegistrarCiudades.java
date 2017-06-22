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
public class pruebasRegistrarCiudades {
    
    
     @Test
    public void testRegistrarCiudadNoExistente() {
    
        SistemaAmbulancia sistema = new SistemaAmbulancia();
        sistema.crearSistemaDeEmergencias(10);
        TipoRet retornoObtenido = sistema.agregarCiudad("Montevideo");
        TipoRet retornoEsperado = TipoRet.OK;
       
        Assert.assertEquals(retornoEsperado, retornoObtenido);
        
    }
    
      @Test
    public void testRegistrarCiudadExistente() {
    
        SistemaAmbulancia sistema = new SistemaAmbulancia();
        sistema.crearSistemaDeEmergencias(10);
        sistema.agregarCiudad("Montevideo");
        
        TipoRet retornoObtenido = sistema.agregarCiudad("Montevideo");
        TipoRet retornoEsperado = TipoRet.ERROR;
        sistema.destruirSistemaEmergencias();
        Assert.assertEquals(retornoEsperado, retornoObtenido);
        
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
       
        Assert.assertEquals(retornoEsperado, retornoObtenido);
        
    }    
}
