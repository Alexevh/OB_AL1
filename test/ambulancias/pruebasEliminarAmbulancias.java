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
public class pruebasEliminarAmbulancias {
    
    @Test
    public void testEliminarUnaAmbulancia(){
        
        SistemaAmbulancia sistema = new SistemaAmbulancia();
        sistema.crearSistemaDeEmergencias(10);
        sistema.agregarCiudad("Montevideo");
        sistema.registrarAmbulancia("MON123", 1);
  
     
        //Eliminamos la ambulancia
        ISistema.TipoRet retornoObtenido = sistema.eliminarAmbulancia("MON123");
        ISistema.TipoRet retornoEsperado = ISistema.TipoRet.OK;
        
        Assert.assertEquals(retornoObtenido,retornoEsperado);
    }
    
    @Test
    public void testEliminarUnaAmbulanciaNoExistente(){
        
        SistemaAmbulancia sistema = new SistemaAmbulancia();
        sistema.crearSistemaDeEmergencias(10);
        sistema.agregarCiudad("Montevideo");
        sistema.registrarAmbulancia("MON123", 1);
  
        //Asignamos la ambulancia a un viaje
        sistema.getListaAmbulancias().buscar("MON123").setEstado(Ambulancia.TipoEstado.ATENDIENDO);
        
        //Eliminamos la ambulancia asignada a un viaje
        ISistema.TipoRet retornoObtenido = sistema.eliminarAmbulancia("MON123");
        ISistema.TipoRet retornoEsperado = ISistema.TipoRet.ERROR;
        
        Assert.assertEquals(retornoObtenido,retornoEsperado);
    }
    
          @Test
    public void testEliminarUnaAmbulanciaAsignadaViaje(){
        
        SistemaAmbulancia sistema = new SistemaAmbulancia();
        sistema.crearSistemaDeEmergencias(10);
       
  
     
        //Eliminamos la ambulancia que no existe
        ISistema.TipoRet retornoObtenido = sistema.eliminarAmbulancia("MON123");
        ISistema.TipoRet retornoEsperado = ISistema.TipoRet.ERROR;
        
        Assert.assertEquals(retornoObtenido,retornoEsperado);
    }
    
}
