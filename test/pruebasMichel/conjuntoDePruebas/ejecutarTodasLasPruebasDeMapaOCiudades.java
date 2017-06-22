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
import pruebasMichel.mapa.caminos.pruebaAmbulanciaMasCercana;
import pruebasMichel.mapa.caminos.pruebaCiudadesEnRadio;
import pruebasMichel.mapa.caminos.pruebaRutaMasRapida;
import pruebasMichel.mapa.pruebaAgregarCiudad;
import pruebasMichel.mapa.pruebaAgregarRutaAlMapa;
import pruebasMichel.mapa.pruebaInformeCiudades;
import pruebasMichel.mapa.pruebaListarCiudades;
import pruebasMichel.mapa.pruebaModificarDemoraDeViaje;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    pruebaAgregarCiudad.class,
    pruebaAgregarRutaAlMapa.class,
    pruebaInformeCiudades.class,
    pruebaListarCiudades.class,
    pruebaModificarDemoraDeViaje.class,
    pruebaAmbulanciaMasCercana.class,
    pruebaCiudadesEnRadio.class,
    pruebaRutaMasRapida.class})
public class ejecutarTodasLasPruebasDeMapaOCiudades {
    //normally, this is an empty class
}
