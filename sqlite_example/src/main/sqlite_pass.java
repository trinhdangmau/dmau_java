/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author dmautrinh
 */
public class sqlite_pass {
    public static void main( String args[] )
  {
    Connection c = null;
    Statement stmt = null;
    try {
        String decodedPath = URLDecoder.decode(javaconnect.class.getProtectionDomain().getCodeSource().getLocation().getPath(), "UTF-8");
        String purl = decodedPath.substring(0, decodedPath.lastIndexOf("/"));
        
        Class.forName("org.sqlite.JDBC");
        String name = "atp_01";
        //String url = "jdbc:sqlite:" + name;
        String url = "jdbc:sqlite:"+purl+"/database/"+name+".db";
        c = DriverManager.getConnection(url);
        System.out.println("Opened database successfully");
        System.out.println(url);

        //main table
        stmt = c.createStatement();     
        String login_atp = "CREATE TABLE IF NOT EXISTS login_atp ("
                + "idlogin_atp INT NOT NULL, "
                + "first_name_logi VARCHAR(45) NULL, "
                + "last_name_logi VARCHAR(45) NULL,"
                + "username_logi VARCHAR(45) NOT NULL,"
                + "password_logi VARCHAR(45) NOT NULL,"
                + "address_logi VARCHAR(45) NULL,"
                + "email_logi VARCHAR(45) NULL,"
                + "phone_logi VARCHAR(45) NULL,"
                + "PRIMARY KEY (idlogin_atp))";
        stmt.executeUpdate(login_atp);
        
        String sql = "INSERT INTO login_atp (idlogin_atp,first_name_logi,last_name_logi,"
                + "username_logi,password_logi) VALUES (1, 'Trinh', 'Mau', 'dmautrinh',"
                + " '123')";
        stmt.executeUpdate(sql);

        stmt.close();
        c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    System.out.println("Table created successfully");
  }
}
