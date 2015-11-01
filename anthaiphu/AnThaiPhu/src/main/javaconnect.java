package main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TrinhDang
 */
import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;
import javax.swing.*;
import static main.function.lc2;
import static main.function.location;

public class javaconnect {
    
    Connection conn= null;
    Connection connlg = null;
    Connection connsy = null;
    ResultSet rs =null;
    PreparedStatement pst =null;
    
    public static Connection ConnecrDb() {

    try {
        //String decodedPath = URLDecoder.decode(javaconnect.class.getProtectionDomain().getCodeSource().getLocation().getPath(), "UTF-8");
        //String purl = decodedPath.substring(0, decodedPath.lastIndexOf("/"));
        //String purl = location();
        String purl = lc2();
        Properties p = new Properties();
        p.load(new FileInputStream(purl + "/database/proj_setup.ini"));
        //String hostname = p.getProperty("Hostname");
        //String port = p.getProperty("Port");
        String database = p.getProperty("Database");
        //String unicode= "?useUnicode=yes&characterEncoding=UTF-8";
        
        //String host = "jdbc:mysql://"+hostname+":"+port+"/"+database+unicode;
        //String uname = Login_frame.txt_username.getText();
        //String pass = Login_frame.txt_password.getText();
        
        String Url = "jdbc:sqlite:"+purl+"/database/"+database+".db";
        Class.forName("org.sqlite.JDBC");
        Connection conn =DriverManager.getConnection(Url);//host, uname, pass
        return conn;
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
            return null;}
    }
    
    public static Connection ConnecrLg() {

    try {
        String purl = location();        
        String name = "anthaiphu_01";
        String Url = "jdbc:sqlite:"+purl+"/database/"+name+".db.sqlite";
        
        Class.forName("org.sqlite.JDBC");
        Connection connlg =DriverManager.getConnection(Url);
        return connlg;
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
            return null;}
    }
    
    public static Connection Connect_sync() {

    try {
        String purl = location();        
        String name = "sync.db";
        String Url = "jdbc:sqlite:"+purl+"/database/"+name;
        
        Class.forName("org.sqlite.JDBC");
        Connection connsy =DriverManager.getConnection(Url);
        return connsy;
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
            return null;}
    }
    
}
