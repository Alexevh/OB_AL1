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

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import pruebasMichel.sistemaGeneral.pruebaCrearSistema;
import pruebasMichel.sistemaGeneral.pruebaDestruirSistema;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    pruebaCrearSistema.class,
    pruebaDestruirSistema.class
 })
public class ejecutarTodasLasPruebasDeSistema {
    //normally, this is an empty class
}
