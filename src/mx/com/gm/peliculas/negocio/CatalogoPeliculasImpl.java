/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.peliculas.negocio;

import java.util.*;
import mx.com.gm.peliculas.datos.*;
import mx.com.gm.peliculas.domain.*;
import mx.com.gm.peliculas.excepciones.*;
import mx.com.gm.peliculas.negocio.*;

public class CatalogoPeliculasImpl implements CatalogoPeliculas{
   
    private final AccesoDatos datos;

    public CatalogoPeliculasImpl(AccesoDatos datos) {
        this.datos = datos;
    }

    @Override
    public void agregarPelicula(String nombrePelicula) throws AccesoDatosEx{
        Pelicula peli = new Pelicula (
                java.util.UUID.randomUUID().toString(),
                nombrePelicula
        );
        boolean anexar = false;
        try{
            anexar = datos.existe();
            datos.escribir(peli, anexar);
        }catch (AccesoDatosEx ex){
            System.out.println("Error al agregar una pelicula");
            ex.printStackTrace();
        }
    }

    @Override
    public void listarPeliculas() throws AccesoDatosEx{
        try{
            List<Pelicula> pelis = datos.listar();
            for (Pelicula pelicula : pelis){
                System.out.println("Pelicula: " + pelicula);
            }
        }catch (AccesoDatosEx ex){
            System.out.println("Error de acceso de datos");
            ex.printStackTrace();
        }
    }

    @Override
    public void buscarPelicula(String buscar) throws AccesoDatosEx {
        String resultado = null;
        try{
            resultado = datos.buscar(buscar);
        }catch (AccesoDatosEx ex){
            System.out.println("Error al buscar la pelicula");
            ex.printStackTrace();
        }
        System.out.println("Resultado busqueda: " + resultado);
    }

    @Override
    public void inciarArchivo() throws AccesoDatosEx{
        try{
            if (datos.existe()){
                datos.borrar();
                datos.crear();
            } else{
                //se crea el archivo
                datos.crear();
            }
        }catch (AccesoDatosEx ex){
            System.out.println("Error de acceso de datos");
            ex.printStackTrace();
        }
    }
   
}
