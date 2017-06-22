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
public class pruebasListarCiudades {

    @Test
    public void testListarCiudades() {

        SistemaAmbulancia sistema = new SistemaAmbulancia();

        sistema.crearSistemaDeEmergencias(5);
        sistema.agregarCiudad("Montevideo");
        sistema.agregarCiudad("Panado");
        sistema.agregarCiudad("Las Piedras");

        TipoRet retornoObtenido = sistema.listarCiudades();
        TipoRet retornoEsperado = TipoRet.OK;

        Assert.assertEquals(retornoEsperado, retornoObtenido);

    }

    @Test
    public void testListarCiudadesSinCiudadesAgregadas() {

        SistemaAmbulancia sistema = new SistemaAmbulancia();

        sistema.crearSistemaDeEmergencias(5);

        TipoRet retornoObtenido = sistema.listarCiudades();
        TipoRet retornoEsperado = TipoRet.OK;

        Assert.assertEquals(retornoEsperado, retornoObtenido);

    }
}
