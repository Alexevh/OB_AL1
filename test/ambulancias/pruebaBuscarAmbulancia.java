/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ambulancias;

import org.junit.Assert;
import org.junit.Test;
import sistemaambulancia.ISistema.TipoRet;
import sistemaambulancia.SistemaAmbulancia;
import sistemaambulancia.dominio.Ambulancia;
import sistemaambulancia.dominio.Ciudad;

/**
 *
 * @author docenteFI
 */
public class pruebaBuscarAmbulancia {
    
   

    @Test
    public void testBuscarAmbulanciaConAmbulanciaIdExistente() {
    
        SistemaAmbulancia sistema = new SistemaAmbulancia();
        sistema.crearSistemaDeEmergencias(10);
        sistema.agregarCiudad("Montevideo");
        
        //Registro una ambulancia
        sistema.registrarAmbulancia("MON123", 0);
        
        //Busco la ambulancia con ID MON123
        TipoRet retornoObtenido = sistema.buscarAmbulancia("MON123");
        TipoRet retornoEsperado = TipoRet.OK;
        
        Assert.assertEquals(retornoEsperado, retornoObtenido);
    }
    
    @Test
    public void testBuscarAmbulanciaConAmbulanciaIdNoExistente() {
    
        SistemaAmbulancia sistema = new SistemaAmbulancia();
        sistema.crearSistemaDeEmergencias(10);
        
        //Busco  la ambulancia con ID MON224
        TipoRet retornoObtenido = sistema.buscarAmbulancia("MON224");
        TipoRet retornoEsperado = TipoRet.ERROR;
        
        Assert.assertEquals(retornoEsperado, retornoObtenido);
        
    }
    
    @Test
    public void testBuscarUltimaAmbulanciaAgregada() {
        SistemaAmbulancia sistema = new SistemaAmbulancia();
        sistema.crearSistemaDeEmergencias(10);
        sistema.agregarCiudad("Montevideo");
        sistema.agregarCiudad("Canelones");
        
        //Registro una ambulancia
        sistema.registrarAmbulancia("MON123", 0);
        sistema.registrarAmbulancia("CAN123", 1);
        
        TipoRet retornoObtenido = sistema.buscarAmbulancia("CAN123");
        TipoRet retornoEsperado = TipoRet.OK;
        
        Assert.assertEquals(retornoObtenido,retornoEsperado);
    }
    
    @Test
    public void testBuscarPrimeraAmbulanciaAgregada() {
        SistemaAmbulancia sistema = new SistemaAmbulancia();
        sistema.crearSistemaDeEmergencias(10);
        sistema.agregarCiudad("Montevideo");
        sistema.agregarCiudad("Canelones");
        
        //Registro una ambulancia
        sistema.registrarAmbulancia("MON123", 0);
        sistema.registrarAmbulancia("CAN123", 1);
        
        TipoRet retornoObtenido = sistema.buscarAmbulancia("MON123");
        TipoRet retornoEsperado = TipoRet.OK;
        
        Assert.assertEquals(retornoObtenido,retornoEsperado);
    }
    
    @Test
    public void testBuscarAmbulanciaConUnaSolaAmbulanciaEnLaLista() {
    SistemaAmbulancia sistema = new SistemaAmbulancia();
        sistema.crearSistemaDeEmergencias(10);
        sistema.agregarCiudad("Montevideo");
        
        //Registro una ambulancia
        sistema.registrarAmbulancia("MON123", 0);
        
        TipoRet retornoObtenido = sistema.buscarAmbulancia("MON123");
        TipoRet retornoEsperado = TipoRet.OK;
        
        Assert.assertEquals(retornoObtenido,retornoEsperado);
    }
    
    @Test
    public void testBuscarAmbulanciaConLaListaVacia() {
    SistemaAmbulancia sistema = new SistemaAmbulancia();
        sistema.crearSistemaDeEmergencias(10);
        sistema.agregarCiudad("Montevideo");
        sistema.agregarCiudad("Canelones");
        
        TipoRet retornoObtenido = sistema.buscarAmbulancia("CAN123");
        TipoRet retornoEsperado = TipoRet.ERROR;
        
        Assert.assertEquals(retornoObtenido,retornoEsperado);
    }
}
