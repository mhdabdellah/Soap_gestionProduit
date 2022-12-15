/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author chouaib
 */
public class DBConnection {

    // Librería de MySQL
//    public String driver = "com.mysql.jdbc.Driver";
//    private String jdbcURL = "jdbc:mysql://localhost:3306/soap_webservice_tp?useSSL=false";
    // Nombre de la base de datos
    public String database = "gestionproduits?autoReconnect=true&useSSL=false";
    // Host
    public String hostname = "localhost";
    // Puerto
    public String port = "3306";
    // Ruta de nuestra base de datos
    public String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database;
    // Nombre de usuario
    public String username = "root";
    // Clave de usuario
    public String password = "sidi1212";

    public Connection conector() {
//        try {
//            Class.forName(driver);
//            connection = DriverManager.getConnection(url, username, password);
//            System.out.println("CONECTED");
//        } catch (ClassNotFoundException | SQLException e) {
//            System.out.println("Erreur de connection avec conector: " + e.getMessage());
//        }
//
//        return connection;
                Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
                
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
    }   
    
//    public static void main(String[] args){
//        DBConnection  con = new DBConnection();
//        
//        System.out.println("la connection " + con.conector());
//    }
}
