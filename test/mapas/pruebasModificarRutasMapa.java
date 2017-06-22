
package mapas;

import junit.framework.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import sistemaambulancia.ISistema;
import sistemaambulancia.SistemaAmbulancia;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertEquals;


public class pruebasModificarRutasMapa {
    
      @Test
      public void testModificarRutaAlMapaMinutosCero() {
    
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
       
        Assert.assertEquals(retornoEsperado, retornoObtenido);
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
       
        Assert.assertEquals(retornoEsperado, retornoObtenido);
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
       
        Assert.assertEquals(retornoEsperado, retornoObtenido);
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
       
        Assert.assertEquals(retornoEsperado, retornoObtenido);
    }

     
}
