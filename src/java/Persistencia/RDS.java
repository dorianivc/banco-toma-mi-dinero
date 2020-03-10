/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author dorianivc
 */
public class RDS {
    public Connection conexion;
    
    public RDS(){
     try {
        Class.forName("com.mysql.cj.jdbc.Driver");
                } catch (ClassNotFoundException e) {
                    System.out.println("Where is your MySQL JDBC Driver?");
                    return ;
                }
        System.out.println("MySQL JDBC Driver Registered!");
        this.conexion=null;
         try {
        conexion = DriverManager.
                getConnection("jdbc:mysql://" + "dorian-database.cy1hmbiynvfm.us-east-1.rds.amazonaws.com" + ":" +"3306", "banco", "banco");
             System.out.println("Conecction Granted");
         } catch (SQLException e) {
        System.out.println("Connection Failed!:\n" + e.getMessage());
            }
        
            }
}

