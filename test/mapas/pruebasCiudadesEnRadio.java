/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapas;

import junit.framework.Assert;
import org.junit.Test;
import sistemaambulancia.ISistema.TipoRet;
import sistemaambulancia.SistemaAmbulancia;
import sistemaambulancia.dominio.Ambulancia;

/**
 *
 * @author alex
 */
public class pruebasCiudadesEnRadio {

    @Test
    public void testCiudadesEnRadioConCiudadADosConexionesDeDistancia() {

        SistemaAmbulancia sistema = new SistemaAmbulancia();
        sistema.crearSistemaDeEmergencias(10);
        sistema.agregarCiudad("Montevideo");
        sistema.agregarCiudad("Pando");
        sistema.agregarCiudad("La Floresta");
        sistema.agregarCiudad("Las Piedras");
        sistema.agregarCiudad("Minas");
        sistema.agregarCiudad("Treinta y Tres");
        
        sistema.agregarRuta(0, 1, 110);
        sistema.agregarRuta(1, 2, 40);
        sistema.agregarRuta(2, 3, 40);
        sistema.agregarRuta(3, 4, 10);
        sistema.agregarRuta(1, 5, 95);
        
        TipoRet retornoEsperado = TipoRet.OK;

        Assert.assertEquals(retornoEsperado, sistema.ciudadesEnRadio(1,100));

    }
    
    @Test
    public void testCiudadesEnRadioSinRutasCreadas() {

        SistemaAmbulancia sistema = new SistemaAmbulancia();
        sistema.crearSistemaDeEmergencias(10);
        sistema.agregarCiudad("Montevideo");
        sistema.agregarCiudad("Pando");
        sistema.agregarCiudad("La Floresta");
        sistema.agregarCiudad("Las Piedras");
        sistema.agregarCiudad("Minas");
        sistema.agregarCiudad("Treinta y Tres");        
        
        TipoRet retornoEsperado = TipoRet.OK;

        Assert.assertEquals(retornoEsperado, sistema.ciudadesEnRadio(1,100));

    }
    
    @Test
    public void testCiudadesEnRadioConCiudadNoExistente() {

        SistemaAmbulancia sistema = new SistemaAmbulancia();
        sistema.crearSistemaDeEmergencias(10);
        sistema.agregarCiudad("Montevideo");
        sistema.agregarCiudad("Pando");
        sistema.agregarCiudad("La Floresta");
        sistema.agregarCiudad("Las Piedras");
        sistema.agregarCiudad("Minas");
        sistema.agregarCiudad("Treinta y Tres");        
        
        TipoRet retornoEsperado = TipoRet.ERROR;

        Assert.assertEquals(retornoEsperado, sistema.ciudadesEnRadio(8,100));

    }
    
    @Test
    public void testCiudadesEnRadioConDuracionEnCero() {

        SistemaAmbulancia sistema = new SistemaAmbulancia();
        sistema.crearSistemaDeEmergencias(10);
        sistema.agregarCiudad("Montevideo");
        sistema.agregarCiudad("Pando");
        sistema.agregarCiudad("La Floresta");
        sistema.agregarCiudad("Las Piedras");
        sistema.agregarCiudad("Minas");
        sistema.agregarCiudad("Treinta y Tres");        
        
        TipoRet retornoEsperado = TipoRet.ERROR;

        Assert.assertEquals(retornoEsperado, sistema.ciudadesEnRadio(1,0));

    }
    
    @Test
    public void testCiudadesEnRadioConDuracionMenorQueCero() {

        SistemaAmbulancia sistema = new SistemaAmbulancia();
        sistema.crearSistemaDeEmergencias(10);
        sistema.agregarCiudad("Montevideo");
        sistema.agregarCiudad("Pando");
        sistema.agregarCiudad("La Floresta");
        sistema.agregarCiudad("Las Piedras");
        sistema.agregarCiudad("Minas");
        sistema.agregarCiudad("Treinta y Tres");        
        
        TipoRet retornoEsperado = TipoRet.ERROR;

        Assert.assertEquals(retornoEsperado, sistema.ciudadesEnRadio(1,-10));

    }

}
