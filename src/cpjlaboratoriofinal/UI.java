/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpjlaboratoriofinal;

import java.util.Scanner;

public class UI {
    private Scanner scan = new Scanner (System.in);
    private Observer observador;
    
    public UI(Observer observador) {
        this.observador = observador;
    }
    public void presentarUI() {
        int opcion = -1;  
        while (opcion != 0){
            try{
                System.out.println("Elige una opción: \n"
                                  + "1.- Iniciar catalogo peliculas\n"
                                  + "2.-Agregar pelicula\n"
                                  + "3.-Listar peliculas\n"
                                  + "4.-Buscar pelicula\n"
                                  + "0.-Salir\n");
                
                
                try {
                    opcion = Integer.parseInt(scan.nextLine());
                }
                catch (NumberFormatException ex) {
                    System.out.println("======================================");
                    System.out.println("ATENCION INGRESAR [1-4] o 0 para salir");
                    System.out.println("======================================");
                }
                
                //ahora sale un switch para la diferentes opciones mencionada anteriormente
                
                switch(opcion){
                    case 1:
                        //1. Creamos el objeto que administra el catalogo de personas
                        //La creacion del archivo es opcional, de todas maneras se creara 
                        //al escribir por primera vez en el archivo
                        
                        observador.onIniciar();
                        break;
                    case 2:
                        //2. agregar informacion archivo
                        System.out.println("Introduce el nombre de la pelicula que queres agregar: \n");
                        String nombre = scan.nextLine();
                        
                        observador.onAgregar(nombre);
                        break;
                    case 3:
                        //3. listar catalogo completo                        
                        observador.onListar();
                        break;
                    case 4:
                        //4. Buscar pelicula
                        System.out.println("Introduce la pelicula que deseas buscar: \n");
                        String buscar = scan.nextLine();
                        
                        observador.onBuscar(buscar);
                        break;
                    case 0: 
                        System.out.println("Hasta pronto!!!");
                        break;
                    default:    
                        System.out.println("Opcion no reconocida");
                        break;
                }
                System.out.println("\n");
            }catch(Exception e){
                System.out.println("ERROR!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                e.printStackTrace();
            }
        }
    }
}
