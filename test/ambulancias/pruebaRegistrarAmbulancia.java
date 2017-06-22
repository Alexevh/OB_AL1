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

public class pruebaRegistrarAmbulancia {

    @Test
    public void testAgregarUnaAmbulancia() {

        SistemaAmbulancia sistema = new SistemaAmbulancia();
        sistema.crearSistemaDeEmergencias(10);
        sistema.agregarCiudad("Montevideo");

        //Registro una ambulancia      
        TipoRet retornoObtenido = sistema.registrarAmbulancia("MON123", 1);
        TipoRet retornoEsperado = TipoRet.OK;

        Assert.assertEquals(retornoEsperado, retornoObtenido);
    }

    @Test
    public void testAgregarUnaAmbulanciaExistente() {

        SistemaAmbulancia sistema = new SistemaAmbulancia();
        sistema.crearSistemaDeEmergencias(10);
        sistema.agregarCiudad("Montevideo");
        sistema.registrarAmbulancia("MON123", 1);

        //Registro una ambulancia existente
        TipoRet retornoObtenido = sistema.registrarAmbulancia("MON123", 1);
        TipoRet retornoEsperado = TipoRet.ERROR;

        Assert.assertEquals(retornoEsperado, retornoObtenido);
    }

    @Test
    public void testAgregarUnaAmbulanciaCiudadNoExistente() {

        SistemaAmbulancia sistema = new SistemaAmbulancia();
        sistema.crearSistemaDeEmergencias(10);

        //Registro una ambulancia en una ciudad que no existe
        TipoRet retornoObtenido = sistema.registrarAmbulancia("MON123", 1);
        TipoRet retornoEsperado = TipoRet.ERROR;

        Assert.assertEquals(retornoEsperado, retornoObtenido);
    }

    @Test
    public void testAgregarDiezAmbulancias() {
        SistemaAmbulancia sistema = new SistemaAmbulancia();
        sistema.crearSistemaDeEmergencias(10);

        sistema.agregarCiudad("Montevideo");
        
        TipoRet retornoEsperado = TipoRet.OK;
        
        Assert.assertEquals(retornoEsperado, sistema.registrarAmbulancia("MON101", 0));
        Assert.assertEquals(retornoEsperado, sistema.registrarAmbulancia("MON102", 0));
        Assert.assertEquals(retornoEsperado, sistema.registrarAmbulancia("MON103", 0));
        Assert.assertEquals(retornoEsperado, sistema.registrarAmbulancia("MON104", 0));
        Assert.assertEquals(retornoEsperado, sistema.registrarAmbulancia("MON105", 0));
        Assert.assertEquals(retornoEsperado, sistema.registrarAmbulancia("MON106", 0));
        Assert.assertEquals(retornoEsperado, sistema.registrarAmbulancia("MON107", 0));
        Assert.assertEquals(retornoEsperado, sistema.registrarAmbulancia("MON108", 0));
        Assert.assertEquals(retornoEsperado, sistema.registrarAmbulancia("MON109", 0));
        Assert.assertEquals(retornoEsperado, sistema.registrarAmbulancia("MON110", 0));
    }

}
