/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package leiloestdsa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ruan
 */
public class conectaDAO { 
  public Connection connectDB(){
        Connection conn = null;
        
        try {
              Class.forName("com.mysql.cj.jdbc.Driver");
              conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/uc11","root","8numeros");
              return conn;
              
        } catch (ClassNotFoundException | SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ConectaDAO" + ex.getMessage());
            return null;
        }
    
}
    
}
