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
import sistemaambulancia.dominio.Ciudad;


/**
 *
 * @author docenteFI
 */
public class pruebaRegistrarAmbulancia {
    
  

    @Test
    public void testAgregarUnaAmbulancia(){
        
        SistemaAmbulancia sistema = new SistemaAmbulancia();
        sistema.crearSistemaDeEmergencias(10);
        sistema.agregarCiudad("Montevideo");
       
        //Registro una ambulancia      
        TipoRet retornoObtenido = sistema.registrarAmbulancia("MON123", 1);
        TipoRet retornoEsperado = TipoRet.OK;
        
        Assert.assertEquals(retornoObtenido,retornoEsperado);
    }
    
    
        @Test
    public void testAgregarUnaAmbulanciaExistente(){
        
        SistemaAmbulancia sistema = new SistemaAmbulancia();
        sistema.crearSistemaDeEmergencias(10);
        sistema.agregarCiudad("Montevideo");
        sistema.registrarAmbulancia("MON123", 1);
        
        //Registro una ambulancia existente
        TipoRet retornoObtenido = sistema.registrarAmbulancia("MON123", 1);
        TipoRet retornoEsperado = TipoRet.ERROR;
        
        Assert.assertEquals(retornoObtenido,retornoEsperado);
    }
    
            @Test
    public void testAgregarUnaAmbulanciaCiudadNoexiste(){
        
        SistemaAmbulancia sistema = new SistemaAmbulancia();
        sistema.crearSistemaDeEmergencias(10);
       
        
        //Registro una ambulancia en una ciudad que no existe
        TipoRet retornoObtenido = sistema.registrarAmbulancia("MON123", 1);
        TipoRet retornoEsperado = TipoRet.ERROR;
        
        Assert.assertEquals(retornoObtenido,retornoEsperado);
    }
    
    

    
    
    @Test
    public void testAgregarDiezAmbulancia(){
        SistemaAmbulancia sistema = new SistemaAmbulancia();
        sistema.crearSistemaDeEmergencias(10);
       
        sistema.agregarCiudad("Montevideo");
        
        sistema.registrarAmbulancia("MON123", 1);
        sistema.registrarAmbulancia("MON124", 1);
        sistema.registrarAmbulancia("MON121", 1);
        sistema.registrarAmbulancia("MON125", 1);
        sistema.registrarAmbulancia("MON126", 1);
        sistema.registrarAmbulancia("MON127", 1);
       
    }
    
            
}
