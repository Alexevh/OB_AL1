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
public class pruebasInformeCiudades {

    @Test
    public void testInformeCiudadesConAmbulanciasEnVariosEstados() {

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
        //Las ambulancias que están atendiendo no aparecerán en el informe.
        sistema.getListaAmbulancias().buscar("MON123").setEstado(Ambulancia.TipoEstado.ATENDIENDO);
        sistema.getListaAmbulancias().buscar("PAN721").setEstado(Ambulancia.TipoEstado.ATENDIENDO);
        sistema.getListaAmbulancias().buscar("PAN231").setEstado(Ambulancia.TipoEstado.NO_DISPONIBLE);

        TipoRet retornoEsperado = TipoRet.OK;

        Assert.assertEquals(retornoEsperado, sistema.informeCiudades());

    }

    @Test
    public void testInformeCiudadesSinCiudades() {

        SistemaAmbulancia sistema = new SistemaAmbulancia();
        sistema.crearSistemaDeEmergencias(10);

        //Es precondición que existan ciudades, así que el resultado será OK.
        TipoRet retornoEsperado = TipoRet.OK;

        Assert.assertEquals(retornoEsperado, sistema.informeCiudades());

    }

    @Test
    public void testInformeCiudadesSinAmbulancias() {

        SistemaAmbulancia sistema = new SistemaAmbulancia();
        sistema.crearSistemaDeEmergencias(10);
        sistema.agregarCiudad("Montevideo");
        sistema.agregarCiudad("Pando");
        sistema.agregarCiudad("La Floresta");
        sistema.agregarCiudad("Las Piedras");

        TipoRet retornoEsperado = TipoRet.OK;

        Assert.assertEquals(retornoEsperado, sistema.informeCiudades());

    }

}
