
package mapas;

import junit.framework.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import sistemaambulancia.ISistema;
import sistemaambulancia.SistemaAmbulancia;


public class pruebasAgregarRutasMapas {
    
    
    @Test
    public void testAgregarRutaAlMapa() {
    
        SistemaAmbulancia sistema = new SistemaAmbulancia();
        
        sistema.crearSistemaDeEmergencias(5);
        sistema.agregarCiudad("Montevideo");
        sistema.agregarCiudad("Panado");
        sistema.agregarCiudad("Las Piedras");
        
 
        ISistema.TipoRet retornoObtenido = sistema.agregarRuta(1, 2, 40);
        ISistema.TipoRet retornoEsperado = ISistema.TipoRet.OK;
       
        Assert.assertEquals(retornoObtenido, retornoEsperado);
    }
    
    
    @Test
    public void testAgregarRutaAlMapaCiudadOrigenInexistente() {
    
        SistemaAmbulancia sistema = new SistemaAmbulancia();
        
        sistema.crearSistemaDeEmergencias(5);
        sistema.agregarCiudad("Montevideo");
        sistema.agregarCiudad("Panado");
        sistema.agregarCiudad("Las Piedras");
        
 
        ISistema.TipoRet retornoObtenido = sistema.agregarRuta(4, 2, 40);
        ISistema.TipoRet retornoEsperado = ISistema.TipoRet.ERROR;
       
        Assert.assertEquals(retornoObtenido, retornoEsperado);
    }
    
    @Test
      public void testAgregarRutaAlMapaCiudadDestinoInexistente() {
    
        SistemaAmbulancia sistema = new SistemaAmbulancia();
        
        sistema.crearSistemaDeEmergencias(5);
        sistema.agregarCiudad("Montevideo");
        sistema.agregarCiudad("Panado");
        sistema.agregarCiudad("Las Piedras");
        
 
        ISistema.TipoRet retornoObtenido = sistema.agregarRuta(1, 9, 40);
        ISistema.TipoRet retornoEsperado = ISistema.TipoRet.ERROR;
       
        Assert.assertEquals(retornoObtenido, retornoEsperado);
    }
    
      @Test
      public void testAgregarRutaAlMapaMinutoscero() {
    
        SistemaAmbulancia sistema = new SistemaAmbulancia();
        
        sistema.crearSistemaDeEmergencias(5);
        sistema.agregarCiudad("Montevideo");
        sistema.agregarCiudad("Panado");
        sistema.agregarCiudad("Las Piedras");
        
 
        ISistema.TipoRet retornoObtenido = sistema.agregarRuta(1, 2, 0);
        ISistema.TipoRet retornoEsperado = ISistema.TipoRet.ERROR;
       
        Assert.assertEquals(retornoObtenido, retornoEsperado);
    }
    
      @Test
      public void testModificarrRutaAlMapaMinutoscero() {
    
        SistemaAmbulancia sistema = new SistemaAmbulancia();
        
        sistema.crearSistemaDeEmergencias(5);
        sistema.agregarCiudad("Montevideo");
        sistema.agregarCiudad("Panado");
        sistema.agregarCiudad("Las Piedras");
        
        //Primero generamos una ruta valida que luego vamos a modificar
        sistema.agregarRuta(1, 2, 50);
 
        //La modificamos a cero
        ISistema.TipoRet retornoObtenido = sistema.agregarRuta(1, 2, 0);
        ISistema.TipoRet retornoEsperado = ISistema.TipoRet.ERROR;
       
        Assert.assertEquals(retornoObtenido, retornoEsperado);
    }
      
      @Test
      public void testModificarDemoraAlMapaCiudadOrigenNoExiste() {
    
        SistemaAmbulancia sistema = new SistemaAmbulancia();
        
        sistema.crearSistemaDeEmergencias(5);
        sistema.agregarCiudad("Montevideo");
        sistema.agregarCiudad("Panado");
        sistema.agregarCiudad("Las Piedras");
        
        //Primero generamos una ruta valida que luego vamos a modificar
        sistema.agregarRuta(1, 2, 50);
 
        //La modificamos a cero
        ISistema.TipoRet retornoObtenido = sistema.agregarRuta(9, 2, 0);
        ISistema.TipoRet retornoEsperado = ISistema.TipoRet.ERROR;
       
        Assert.assertEquals(retornoObtenido, retornoEsperado);
    }
      
            @Test
      public void testModificarDemoraDestinoNoExiste() {
    
        SistemaAmbulancia sistema = new SistemaAmbulancia();
        
        sistema.crearSistemaDeEmergencias(5);
        sistema.agregarCiudad("Montevideo");
        sistema.agregarCiudad("Panado");
        sistema.agregarCiudad("Las Piedras");
        
        //Primero generamos una ruta valida que luego vamos a modificar
        sistema.agregarRuta(1, 2, 50);
 
        //La modificamos
        ISistema.TipoRet retornoObtenido = sistema.agregarRuta(1, 8, 0);
        ISistema.TipoRet retornoEsperado = ISistema.TipoRet.ERROR;
       
        Assert.assertEquals(retornoObtenido, retornoEsperado);
    }
      
      @Test
      public void testModificarDemoraAlMapa() {
    
        SistemaAmbulancia sistema = new SistemaAmbulancia();
        
        sistema.crearSistemaDeEmergencias(5);
        sistema.agregarCiudad("Montevideo");
        sistema.agregarCiudad("Panado");
        sistema.agregarCiudad("Las Piedras");
        
        //Primero generamos una ruta valida que luego vamos a modificar
        sistema.agregarRuta(1, 2, 50);
 
        //La modificamos 
        ISistema.TipoRet retornoObtenido = sistema.agregarRuta(1, 2, 45);
        ISistema.TipoRet retornoEsperado = ISistema.TipoRet.OK;
       
        Assert.assertEquals(retornoObtenido, retornoEsperado);
    }
      
      
    @Test
    public void testAgregarRutaConListaVaciaDeCiudades() {
        
        ISistema s = new SistemaAmbulancia();

        s.crearSistemaDeEmergencias(10);

        assertEquals(ISistema.TipoRet.ERROR, s.agregarRuta(1, 2, 10));

      

    }
      
}
