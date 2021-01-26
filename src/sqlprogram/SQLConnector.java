/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlprogram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Korisnik
 */
public class SQLConnector {
    
    public static void connectSQL(String name,String surname,String language,String gender,int salary) throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
       Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
       String query = "INSERT INTO user(`name`, `surname`, `language`, `gender`, `salary`) VALUES(?,?,?,?,?);";
       PreparedStatement ps = conn.prepareStatement(query);
       ps.setString(1, name);
       ps.setString(2, surname);
       ps.setString(3, language);
       ps.setString(4, gender);
       ps.setInt(5, salary);
       ps.execute();
       conn.close();
        
    }
}
