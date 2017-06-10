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
import sistemaambulancia.ISistema;
import sistemaambulancia.ISistema.TipoRet;
import sistemaambulancia.SistemaAmbulancia;

public class PruebasAmbulanciasMasCercanas {

    SistemaAmbulancia sistema = Crear_Cargar();

    public SistemaAmbulancia Crear_Cargar() {
        SistemaAmbulancia sistema = new SistemaAmbulancia();
        sistema.crearSistemaDeEmergencias(5);
        sistema.agregarCiudad("Montevideo");
        sistema.agregarCiudad("Canelones");
        sistema.agregarCiudad("Pando");
        sistema.agregarCiudad("Las Piedras");
        sistema.agregarCiudad("Maldonado");
        sistema.agregarRuta(0, 1, 60);
        sistema.agregarRuta(0, 3, 160);
        sistema.agregarRuta(0, 4, 220);
        sistema.agregarRuta(1, 2, 20);
        sistema.agregarRuta(1, 3, 30);
        sistema.agregarRuta(2, 3, 40);
        sistema.agregarRuta(2, 4, 50);
        sistema.agregarRuta(3, 4, 15);
        
        //sistema.registrarAmbulancia("MON001", 0);
        //sistema.registrarAmbulancia("CAN001", 1);
        //sistema.registrarAmbulancia("PAN001", 2);
        sistema.registrarAmbulancia("PIE001", 3);
        sistema.registrarAmbulancia("MAL001", 4);
        
        return sistema;
    }

    @Test
    public void testBuscarAmbulanciaMasCercana() {

        ISistema.TipoRet retornoObtenido = sistema.ambulanciaMasCercana(0);
        ISistema.TipoRet retornoEsperado = ISistema.TipoRet.OK;

        Assert.assertEquals(retornoEsperado, retornoObtenido);

    }

}
