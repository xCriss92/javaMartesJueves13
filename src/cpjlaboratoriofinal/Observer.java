package cpjlaboratoriofinal;

import factories.Factory;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.com.gm.peliculas.excepciones.AccesoDatosEx;
import mx.com.gm.peliculas.negocio.CatalogoPeliculas;

public class Observer {
    private static CatalogoPeliculas catalogo = null;
    
    public Observer() {
        try {
            catalogo = Factory.obtenerCatalogoPeliculas();
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void onIniciar() {
        try {
            catalogo.inciarArchivo();
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void onAgregar(String nombre) {
        try {
            catalogo.agregarPelicula(nombre);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void onBuscar(String strBuscar) {
        try {
            catalogo.buscarPelicula(strBuscar);
        } catch (AccesoDatosEx ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void onListar() {
        try {
            catalogo.listarPeliculas();
        } catch (AccesoDatosEx ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void onSalir() {
        System.exit(0);
    }
}
