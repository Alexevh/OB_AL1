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
        Ciudad c = sistema.getListaCiudades().buscar(1);
        //Registro una ambulancia
        sistema.registrarAmbulancia("MON123", 1);
        
        //Registro nuevamente la ambulancia con ID MON123
        TipoRet retornoObtenido = sistema.registrarAmbulancia("MON123", 1);
        TipoRet retornoEsperado = TipoRet.ERROR;
        
        Assert.assertEquals(retornoObtenido,retornoEsperado );
        
        
    
    }
    
    @Test
    public void testBuscarAmbulanciaConAmbulanciaIdNoExistente() {
    
        SistemaAmbulancia sistema = new SistemaAmbulancia();
        sistema.crearSistemaDeEmergencias(10);
        
        //Busco  la ambulancia con ID MON224
        TipoRet retornoObtenido = sistema.buscarAmbulancia("MON224");
        TipoRet retornoEsperado = TipoRet.ERROR;
        
        Assert.assertEquals(retornoObtenido,retornoEsperado );
        
    }
    
    @Test
    public void testBuscarUltimaAmbulanciaAgregada() {
    }
    
    @Test
    public void testBuscarPrimeraAmbulanciaAgregada() {}
    
    @Test
    public void testBuscarAmbulanciaConUnaSolaAmbulanciaEnLaLista() {}
    
    @Test
    public void testBuscarAmbulanciaConLaListaVacia() {}
}
