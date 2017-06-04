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
public class pruebasHabilitarAmbulancias {
    
      @Test
    public void testHabilitarUnaAmbulanciaDeshabilidatada(){
        
        SistemaAmbulancia sistema = new SistemaAmbulancia();
        sistema.crearSistemaDeEmergencias(10);
        sistema.agregarCiudad("Montevideo");
        sistema.registrarAmbulancia("MON123", 1);
        
        Ambulancia amb = sistema.getListaAmbulancias().buscar("MON123");
        amb.setEstado(Ambulancia.TipoEstado.NO_DISPONIBLE);
        
      
        //Habilitamos la abulancia deshablitada
        ISistema.TipoRet retornoObtenido = sistema.habilitarAmbulancia("MON123");
        ISistema.TipoRet retornoEsperado = ISistema.TipoRet.OK;
        
        Assert.assertEquals(retornoObtenido,retornoEsperado);
    }
    
    
        @Test
    public void testHabilitarUnaAmbulanciaYahabilidatada(){
        
        SistemaAmbulancia sistema = new SistemaAmbulancia();
        sistema.crearSistemaDeEmergencias(10);
        sistema.agregarCiudad("Montevideo");
        sistema.registrarAmbulancia("MON123", 1);
        
        Ambulancia amb = sistema.getListaAmbulancias().buscar("MON123");
        amb.setEstado(Ambulancia.TipoEstado.DISPONIBLE);
        
      
        //Habilitamos la abulancia deshablitada
        ISistema.TipoRet retornoObtenido = sistema.habilitarAmbulancia("MON123");
        ISistema.TipoRet retornoEsperado = ISistema.TipoRet.ERROR;
        
        Assert.assertEquals(retornoObtenido,retornoEsperado);
    }
    
        @Test
    public void testHabilitarUnaAmbulanciaInexistente(){
        
        SistemaAmbulancia sistema = new SistemaAmbulancia();
        sistema.crearSistemaDeEmergencias(10);
        sistema.agregarCiudad("Montevideo");
       

      
        //Habilitamos la abulancia que no existe
        ISistema.TipoRet retornoObtenido = sistema.habilitarAmbulancia("MON123");
        ISistema.TipoRet retornoEsperado = ISistema.TipoRet.ERROR;
        
        Assert.assertEquals(retornoObtenido,retornoEsperado);
    }
}
