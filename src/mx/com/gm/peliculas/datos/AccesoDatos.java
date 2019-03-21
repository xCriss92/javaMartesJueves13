/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.peliculas.datos;

import java.util.List;
import mx.com.gm.peliculas.domain.*;
import mx.com.gm.peliculas.excepciones.*;

/**
 *
 * @author ariag
 */
public interface AccesoDatos {
    public boolean existe () throws AccesoDatosEx;
    public List<Pelicula> listar () throws LecturaDatosEx;
    public void escribir (Pelicula pelicula, boolean anexar)throws EscrituraDatosEx;
    public String buscar (String buscar) throws AccesoDatosEx;
    public void crear () throws AccesoDatosEx;
    public void borrar () throws AccesoDatosEx;    
}
