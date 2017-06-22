package mapas;

import junit.framework.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import sistemaambulancia.ISistema;
import sistemaambulancia.SistemaAmbulancia;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertEquals;

public class pruebasAgregarRutasMapa {

    @Test
    public void testAgregarRutaAlMapa() {

        SistemaAmbulancia sistema = new SistemaAmbulancia();

        sistema.crearSistemaDeEmergencias(5);
        sistema.agregarCiudad("Montevideo");
        sistema.agregarCiudad("Panado");
        sistema.agregarCiudad("Las Piedras");

        ISistema.TipoRet retornoObtenido = sistema.agregarRuta(1, 2, 40);
        ISistema.TipoRet retornoEsperado = ISistema.TipoRet.OK;

        Assert.assertEquals(retornoEsperado, retornoObtenido);
    }

    @Test
    public void testAgregarRutaAlMapaCiudadOrigenInexistente() {

        SistemaAmbulancia sistema = new SistemaAmbulancia();

        sistema.crearSistemaDeEmergencias(5);
        sistema.agregarCiudad("Montevideo");
        sistema.agregarCiudad("Panado");
        sistema.agregarCiudad("Las Piedras");

        ISistema.TipoRet retornoObtenido = sistema.agregarRuta(4, 2, 40);
        ISistema.TipoRet retornoEsperado = ISistema.TipoRet.ERROR;

        Assert.assertEquals(retornoEsperado, retornoObtenido);
    }

    @Test
    public void testAgregarRutaAlMapaCiudadDestinoInexistente() {

        SistemaAmbulancia sistema = new SistemaAmbulancia();

        sistema.crearSistemaDeEmergencias(5);
        sistema.agregarCiudad("Montevideo");
        sistema.agregarCiudad("Panado");
        sistema.agregarCiudad("Las Piedras");

        ISistema.TipoRet retornoObtenido = sistema.agregarRuta(1, 9, 40);
        ISistema.TipoRet retornoEsperado = ISistema.TipoRet.ERROR;

        Assert.assertEquals(retornoEsperado, retornoObtenido);
    }

    @Test
    public void testAgregarRutaAlMapaMinutosCero() {

        SistemaAmbulancia sistema = new SistemaAmbulancia();

        sistema.crearSistemaDeEmergencias(5);
        sistema.agregarCiudad("Montevideo");
        sistema.agregarCiudad("Panado");
        sistema.agregarCiudad("Las Piedras");

        ISistema.TipoRet retornoObtenido = sistema.agregarRuta(1, 2, 0);
        ISistema.TipoRet retornoEsperado = ISistema.TipoRet.ERROR;

        Assert.assertEquals(retornoEsperado, retornoObtenido);
    }

    @Test
    public void testAgregarRutaConListaVaciaDeCiudades() {

        ISistema s = new SistemaAmbulancia();

        s.crearSistemaDeEmergencias(10);

        assertEquals(ISistema.TipoRet.ERROR, s.agregarRuta(1, 2, 10));

    }

}
