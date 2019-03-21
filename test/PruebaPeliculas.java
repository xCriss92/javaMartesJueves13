/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import factories.Factory;
import mx.com.gm.peliculas.datos.AccesoDatosSQL;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.AccesoDatosEx;
import mx.com.gm.peliculas.negocio.CatalogoPeliculas;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author EducaciónIT
 */
public class PruebaPeliculas {
    
    public PruebaPeliculas() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testearPelis() throws Exception {
        AccesoDatosSQL accesoDatos = Factory.crearAccesoSQL();
        Pelicula p = new Pelicula(java.util.UUID.randomUUID().toString(), "HAY QUE METER ALGO RANDOM");
        accesoDatos.escribir(p, true);
        String resultado = accesoDatos.buscar("METER");
        System.out.println("--------------");
        System.out.println(resultado);
        System.out.println("--------------");
        Assert.assertEquals("HAY QUE METER ALGO RANDOM", resultado);
        accesoDatos.borrar();
    }
}
