/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factories;

import mx.com.gm.peliculas.datos.AccesoDatos;
import mx.com.gm.peliculas.datos.AccesoDatosSQL;
import mx.com.gm.peliculas.datos.AccesoDatosTxt;
import mx.com.gm.peliculas.negocio.CatalogoPeliculas;
import mx.com.gm.peliculas.negocio.CatalogoPeliculasImpl;

/**
 *
 * @author EducaciónIT
 */
public class Factory {
    public static AccesoDatos crearAccesoDatos() {
        String nombreArchivo = "C:\\Clase12\\catalogoPelis.txt";
        return new AccesoDatosTxt(nombreArchivo);
    }
    public static AccesoDatosSQL crearAccesoSQL() throws Exception {
        return new AccesoDatosSQL(
                UtilitarioConexion.getConnection()
        );
    }
    public static CatalogoPeliculas obtenerCatalogoPeliculas() throws Exception {
        // return new CatalogoPeliculasImpl(crearAccesoDatos());
        return new CatalogoPeliculasImpl(
            new AccesoDatosSQL(
                UtilitarioConexion.getConnection()
            )
        );
    }
}
