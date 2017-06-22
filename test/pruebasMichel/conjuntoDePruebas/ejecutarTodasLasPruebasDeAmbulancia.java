/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebasMichel.conjuntoDePruebas;

/**
 *
 * @author michel.camarotta
 */
import pruebasMichel.ambulancias.pruebaBuscarAmbulancia;
import pruebasMichel.ambulancias.pruebaCambiarUbicacionAmbulancia;
import pruebasMichel.ambulancias.pruebaDeshabilitarAmbulancia;
import pruebasMichel.ambulancias.pruebaEliminarAmbulancia;
import pruebasMichel.ambulancias.pruebaHabilitarAmbulancia;
import pruebasMichel.ambulancias.pruebaInformeAmbulancia;
import pruebasMichel.ambulancias.pruebaInformeAmbulanciaPorCiudad;
import pruebasMichel.ambulancias.pruebaRegistrarAmbulancia;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    pruebaRegistrarAmbulancia.class,
    pruebaEliminarAmbulancia.class,
    pruebaDeshabilitarAmbulancia.class,
    pruebaHabilitarAmbulancia.class,
    pruebaBuscarAmbulancia.class,
    pruebaCambiarUbicacionAmbulancia.class,
    pruebaInformeAmbulancia.class,
    pruebaInformeAmbulanciaPorCiudad.class,})
public class ejecutarTodasLasPruebasDeAmbulancia {
    //normally, this is an empty class
}
