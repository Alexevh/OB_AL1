/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaEmergencias;

/**
 *
 * @author alex
 */
import junit.framework.Assert;
import org.junit.Test;
import sistemaambulancia.ISistema.TipoRet;
import sistemaambulancia.SistemaAmbulancia;
public class PruebasSistemaEmergencia {
    
       @Test
    public void testRegistrarCiudadNOExistente() {
    
        SistemaAmbulancia sistema = new SistemaAmbulancia();
        sistema.crearSistemaDeEmergencias(10);
        TipoRet retornoObtenido = sistema.destruirSistemaEmergencias();
        TipoRet retornoEsperado = TipoRet.OK;
       
        Assert.assertEquals(retornoObtenido, retornoEsperado);
        
    }
    
}
