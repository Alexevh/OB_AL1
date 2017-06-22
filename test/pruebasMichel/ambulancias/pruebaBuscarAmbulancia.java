/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebasMichel.ambulancias;

import sistemaambulancia.ISistema;
import sistemaambulancia.SistemaAmbulancia;
import pruebasMichel.utils.FuncionalidadesComunes;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import sistemaambulancia.dominio.Ambulancia;

/**
 *
 * @author docenteFI
 */
public class pruebaBuscarAmbulancia {

    /**
     * Si la ambulancia ambulanciaID no existe en el sistema de emergencias,
     * deberá imprimir en pantalla: “No existe una ambulancia con identificador
     * ambulanciaID.”
     */
     @Test
    public void testBuscarUnaAmbulanciaInexisteConNingunaAmbulanciaEnElSistema() {
        FuncionalidadesComunes.ImprimirComienzoDeTest();

        ISistema s = new SistemaAmbulancia();

        s.crearSistemaDeEmergencias(10);

        s.agregarCiudad("Ciudad1");
        s.agregarCiudad("Ciudad2");
        s.agregarCiudad("Ciudad2");

        assertEquals(ISistema.TipoRet.ERROR, s.buscarAmbulancia("SBA1232"));

        FuncionalidadesComunes.ImprimirFinDeTest();

    }

    @Test
    public void testBuscarUnaAmbulanciaInexisteConAlMenosUnaAmbulanciaEnElSistema() {
        FuncionalidadesComunes.ImprimirComienzoDeTest();

        ISistema s = new SistemaAmbulancia();

        s.crearSistemaDeEmergencias(10);

        s.agregarCiudad("Ciudad1");
        s.agregarCiudad("Ciudad2");
        s.agregarCiudad("Ciudad2");

        s.registrarAmbulancia("SBA1234", 2);
        assertEquals(ISistema.TipoRet.ERROR, s.buscarAmbulancia("SBA1232"));

        FuncionalidadesComunes.ImprimirFinDeTest();

    }
    
    @Test
    public void testBuscarUnaAmbulanciaQueEsteDeshabilitadaEnElSistema() {
        FuncionalidadesComunes.ImprimirComienzoDeTest();

        ISistema s = new SistemaAmbulancia();

        s.crearSistemaDeEmergencias(10);

        s.agregarCiudad("Ciudad1");
        s.agregarCiudad("Ciudad2");
        s.agregarCiudad("Ciudad3");

        s.registrarAmbulancia("SBA1234", 2);
        s.registrarAmbulancia("SBA1233", 2);
        s.registrarAmbulancia("SBA1236", 2);
        s.registrarAmbulancia("SBA1237", 2);
        
        assertEquals(ISistema.TipoRet.OK, s.deshabilitarAmbulancia("SBA1234"));
        assertEquals(ISistema.TipoRet.OK, s.buscarAmbulancia("SBA1234"));

        FuncionalidadesComunes.ImprimirFinDeTest();

    }

    @Test
    public void testBuscarUnaAmbulanciaValidaConVariasAmbulanciaEnElSistema() {
        FuncionalidadesComunes.ImprimirComienzoDeTest();

        ISistema s = new SistemaAmbulancia();

        s.crearSistemaDeEmergencias(10);

        s.agregarCiudad("Ciudad1");
        s.agregarCiudad("Ciudad2");
        s.agregarCiudad("Ciudad2");

        s.registrarAmbulancia("SBA1234", 1);
        s.registrarAmbulancia("SBA1235", 1);
        s.registrarAmbulancia("SBA1236", 1);
        s.registrarAmbulancia("SBA1237", 1);
        s.registrarAmbulancia("SBA1238", 1);
        s.registrarAmbulancia("SBA1239", 1);
        s.registrarAmbulancia("SBA1210", 1);
        s.registrarAmbulancia("SBA1211", 1);
        s.registrarAmbulancia("SBA1212", 2);
        s.registrarAmbulancia("SBA1213", 2);
        assertEquals(ISistema.TipoRet.OK, s.buscarAmbulancia("SBA1234"));


        FuncionalidadesComunes.ImprimirFinDeTest();

    }

    @Test
    public void testBuscarVariasAmbulanciasValidasConVariasAmbulanciaEnElSistema() {
        FuncionalidadesComunes.ImprimirComienzoDeTest();

        ISistema s = new SistemaAmbulancia();

        s.crearSistemaDeEmergencias(10);

        s.agregarCiudad("Ciudad1");
        s.agregarCiudad("Ciudad2");
        s.agregarCiudad("Ciudad2");

        s.registrarAmbulancia("SBA1234", 1);
        s.registrarAmbulancia("SBA1235", 1);
        s.registrarAmbulancia("SBA1236", 1);
        s.registrarAmbulancia("SBA1237", 1);
        s.registrarAmbulancia("SBA1238", 1);
        s.registrarAmbulancia("SBA1239", 1);
        s.registrarAmbulancia("SBA1210", 1);
        s.registrarAmbulancia("SBA1211", 1);
        s.registrarAmbulancia("SBA1212", 2);
        s.registrarAmbulancia("SBA1213", 2);
        assertEquals(ISistema.TipoRet.OK, s.buscarAmbulancia("SBA1235"));
        assertEquals(ISistema.TipoRet.OK, s.buscarAmbulancia("SBA1236"));
 

        FuncionalidadesComunes.ImprimirFinDeTest();

    }
    
    
}
