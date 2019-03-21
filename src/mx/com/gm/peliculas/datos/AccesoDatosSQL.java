/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.peliculas.datos;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.AccesoDatosEx;
import mx.com.gm.peliculas.excepciones.EscrituraDatosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;

/**
 *
 * @author EducaciónIT
 */
public class AccesoDatosSQL implements AccesoDatos {

    private java.sql.Connection connSQL = null;

    public AccesoDatosSQL(java.sql.Connection connSQL) {
        this.connSQL = connSQL;
    }
            
    @Override
    public boolean existe() throws AccesoDatosEx {
        // Si la conexion esta abierta
        return true;
    }

    @Override
    public List<Pelicula> listar() throws LecturaDatosEx {
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        StringBuilder strSQL = new StringBuilder()
            .append("SELECT id, nombre from peliculas;");
            
        try {
            System.out.println("Creando statement");
            Statement stm = connSQL.createStatement();            
            System.out.println("Ejecutando");
            ResultSet rs = stm.executeQuery(strSQL.toString());
            while (rs.next()) {
                peliculas.add(
                        new Pelicula(
                            java.util.UUID.randomUUID().toString(),
                            rs.getString("nombre")
                        )
                );
                System.out.println(rs.getString("id"));
                System.out.println(rs.getString("nombre")); 
            }
            rs.close();
            stm.close();
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println("Exception");
            System.out.println(strSQL.toString());
        }
        return peliculas;
    }

    @Override
    public void escribir(Pelicula pelicula, boolean anexar) throws EscrituraDatosEx {
        StringBuilder strSQL = new StringBuilder()
            .append("INSERT peliculas (id, nombre) values (")
            .append("'")
            .append(java.util.UUID.randomUUID().toString())
            .append("','")
            .append(pelicula.getNombre())
            .append("');");
            
        try {
            System.out.println("Creando statement");
            Statement stm = connSQL.createStatement();            
            System.out.println("Ejecutando");
            stm.execute(strSQL.toString());
            System.out.println("listo");
            stm.close();
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println("Exception");
            System.out.println(strSQL.toString());
        }
    }

    @Override
    public String buscar(String buscar) throws AccesoDatosEx {
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        StringBuilder strSQL = new StringBuilder()
            .append("SELECT id, nombre from peliculas ")
            .append("where nombre like '%" + buscar + "%'");
            
        try {
            System.out.println("Creando statement");
            Statement stm = connSQL.createStatement();            
            System.out.println("Ejecutando");
            ResultSet rs = stm.executeQuery(strSQL.toString());
            while (rs.next()) {
                peliculas.add(
                        new Pelicula(
                            java.util.UUID.randomUUID().toString(),
                            rs.getString("nombre")
                        )
                );
                System.out.println(rs.getString("id"));
                System.out.println(rs.getString("nombre")); 
            }
            rs.close();
            stm.close();
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println("Exception");
            System.out.println(strSQL.toString());
        }
        
        if (peliculas.size() > 0) {
            return peliculas.get(0).getNombre();
        }
        
        return "";
    }

    @Override
    public void crear() throws AccesoDatosEx {
        // N/A la implementacion
    }

    @Override
    public void borrar() throws AccesoDatosEx {
        // delete from peliculas where 1 = 1;
    }
    
}
