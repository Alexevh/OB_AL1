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

public class pruebaInformesAmbulancias {

    @Test
    public void testInformeAmbulancias() {

        SistemaAmbulancia sistema = new SistemaAmbulancia();
        sistema.crearSistemaDeEmergencias(10);
        sistema.agregarCiudad("Montevideo");
        sistema.agregarCiudad("Pando");
        sistema.agregarCiudad("La Floresta");
        sistema.agregarCiudad("Las Piedras");
        sistema.registrarAmbulancia("MON123", 0);
        sistema.registrarAmbulancia("MON145", 0);
        sistema.registrarAmbulancia("PAN721", 1);
        sistema.registrarAmbulancia("PAN231", 1);
        sistema.registrarAmbulancia("PAN112", 1);
        sistema.registrarAmbulancia("PAN155", 1);
        sistema.registrarAmbulancia("FLO101", 2);
        sistema.registrarAmbulancia("PIE101", 3);      
        //Asignamos la ambulancia a un viaje
        sistema.getListaAmbulancias().buscar("MON123").setEstado(Ambulancia.TipoEstado.ATENDIENDO);
        sistema.getListaAmbulancias().buscar("PAN721").setEstado(Ambulancia.TipoEstado.ATENDIENDO);
        sistema.getListaAmbulancias().buscar("PAN231").setEstado(Ambulancia.TipoEstado.NO_DISPONIBLE);

        TipoRet retornoObtenido = sistema.informeAmbulancia();
        TipoRet retornoEsperado = TipoRet.OK;
        Assert.assertEquals(retornoEsperado, retornoObtenido);
    }

    @Test
    public void testInformeAmbulanciasSinAmbulanciasRegistradas() {

        SistemaAmbulancia sistema = new SistemaAmbulancia();
        sistema.crearSistemaDeEmergencias(10);
        sistema.agregarCiudad("Montevideo");

        TipoRet retornoObtenido = sistema.informeAmbulancia();
        TipoRet retornoEsperado = TipoRet.OK;
        Assert.assertEquals(retornoEsperado, retornoObtenido);
    }

    @Test
    public void testInformeAmbulanciasPorCiudadConAmbulanciasEnVariosEstados() {

        SistemaAmbulancia sistema = new SistemaAmbulancia();
        sistema.crearSistemaDeEmergencias(10);
        sistema.agregarCiudad("Montevideo");
        sistema.agregarCiudad("Pando");
        sistema.agregarCiudad("La Floresta");
        sistema.agregarCiudad("Las Piedras");
        sistema.registrarAmbulancia("MON123", 0);
        sistema.registrarAmbulancia("MON145", 0);
        sistema.registrarAmbulancia("PAN721", 1);
        sistema.registrarAmbulancia("PAN231", 1);
        sistema.registrarAmbulancia("PAN112", 1);
        sistema.registrarAmbulancia("PAN155", 1);
        sistema.registrarAmbulancia("FLO101", 2);
        sistema.registrarAmbulancia("PIE101", 3);
        
        //Solo dos ambulancias estarán disponibles
        sistema.getListaAmbulancias().buscar("PAN721").setEstado(Ambulancia.TipoEstado.ATENDIENDO);
        sistema.getListaAmbulancias().buscar("PAN231").setEstado(Ambulancia.TipoEstado.NO_DISPONIBLE);

        TipoRet retornoObtenido = sistema.informeAmbulancia(1);
        TipoRet retornoEsperado = TipoRet.OK;
        Assert.assertEquals(retornoEsperado, retornoObtenido);
    }
    
    @Test
    public void testInformeAmbulanciasPorCiudadSinAmbulancias() {

        SistemaAmbulancia sistema = new SistemaAmbulancia();
        sistema.crearSistemaDeEmergencias(10);
        sistema.agregarCiudad("Montevideo");
        sistema.agregarCiudad("Canelones");
        sistema.registrarAmbulancia("MON123", 0);
        sistema.registrarAmbulancia("MON145", 0);
        sistema.registrarAmbulancia("MON721", 0);

        TipoRet retornoObtenido = sistema.informeAmbulancia(1);
        TipoRet retornoEsperado = TipoRet.OK;
        Assert.assertEquals(retornoEsperado, retornoObtenido);
    }

    @Test
    public void testInformeAmbulanciasPorCiudadNoExiste() {

        SistemaAmbulancia sistema = new SistemaAmbulancia();
        sistema.crearSistemaDeEmergencias(10);
        sistema.agregarCiudad("Montevideo");
        sistema.registrarAmbulancia("MON123", 0);
        sistema.registrarAmbulancia("MON145", 0);
        sistema.registrarAmbulancia("MON721", 0);

        TipoRet retornoObtenido = sistema.informeAmbulancia(2);
        TipoRet retornoEsperado = TipoRet.ERROR;
        Assert.assertEquals(retornoEsperado, retornoObtenido);
    }

}
