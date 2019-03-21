
package mx.com.gm.peliculas.datos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import mx.com.gm.peliculas.domain.*;
import mx.com.gm.peliculas.excepciones.*;


public class AccesoDatosTxt implements AccesoDatos{

    private String nombreArchivo;

    public AccesoDatosTxt(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }
    
    @Override
    public boolean existe() throws AccesoDatosEx{
        File existe = new File (nombreArchivo);
        return existe.exists();
    }

    @Override
    public List<Pelicula> listar() throws LecturaDatosEx {
        File list = new File (nombreArchivo);
        List <Pelicula> pelis = new ArrayList();
        try{
            BufferedReader br = new BufferedReader (new FileReader (list));
            String linea = null;
            linea = br.readLine();
            while (linea != null){
                Pelicula pelicula = 
                        new Pelicula(
                            java.util.UUID.randomUUID().toString(),
                            linea
                );
                pelis.add(pelicula);
                linea = br.readLine();
            }
            br.close();
        }catch (IOException ex){
            ex.printStackTrace();
        }
        
        return pelis;
    }

    @Override
    public void escribir(Pelicula pelicula, boolean anexar) throws EscrituraDatosEx{
        File escribir = new File (nombreArchivo);
        try{
            PrintWriter pw = new PrintWriter (new FileWriter(escribir, anexar));
            pw.println(pelicula.toString());
            pw.close();
            System.out.println("Se ha escrito correcatmente");
            
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public String buscar(String buscar) throws AccesoDatosEx {
        File archivo = new File (nombreArchivo);
        String resultado = null;
        try{
            BufferedReader br = new BufferedReader (new FileReader (archivo));
            String linea = null;
            int i = 0;
            linea = br.readLine();
            while (linea != null){                
                if (buscar != null && linea.indexOf(buscar) >= 0){
                    resultado = "Pelicula: " + linea + " encontrada en el indice: " + i;
                    break;
                }
                linea = br.readLine();
                i++;
            }
            br.close();
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return resultado;
    }

    @Override
    public void crear() throws AccesoDatosEx{
        File crear = new File (nombreArchivo);
        try{
            PrintWriter pw = new PrintWriter (new FileWriter(crear));
            pw.close();
            System.out.println("Se ha creado el archivo correctamente");
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void borrar() throws AccesoDatosEx{
        File borrar = new File (nombreArchivo);
        borrar.delete();
        System.out.println("Se ha borrado el archivo correctamente");
    }
    
}
