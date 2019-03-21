
package cpjlaboratoriofinal;

import factories.Factory;
import factories.UtilitarioConexion;
import java.util.Scanner;
import mx.com.gm.peliculas.negocio.*;

public class Init {
    public static void main (String [] args) throws Exception{
        new UI(new Observer()).presentarUI();
    }
}