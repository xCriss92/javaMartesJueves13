/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.peliculas.negocio;

import mx.com.gm.peliculas.excepciones.*;

/**
 *
 * @author ariag
 */
public interface CatalogoPeliculas{
    public void agregarPelicula (String nombrePelicula) throws AccesoDatosEx;
    public void listarPeliculas() throws AccesoDatosEx;
    public void buscarPelicula (String buscar) throws AccesoDatosEx;
    public void inciarArchivo () throws AccesoDatosEx;
}
