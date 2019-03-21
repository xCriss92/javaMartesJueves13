/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factories;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author EducaciónIT
 */
public class UtilitarioConexion {
    public static java.sql.Connection getConnection() throws Exception {
        try {
            return __getConnection();
        }
        catch (java.lang.ClassNotFoundException ex) {
            System.out.println("Cuidado que hay que importar el Driver de MYSQL");
        }
        return null;
    }
    private static java.sql.Connection __getConnection() throws Exception {
        String driver = "com.mysql.cj.jdbc.Driver";
        String connection = "jdbc:mysql://localhost/infopeliculas?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        
        String user = "root";
        String password = "";
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(connection, user, password);
               
        return conn;
    }
}
