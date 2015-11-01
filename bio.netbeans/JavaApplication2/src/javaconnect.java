/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TrinhDang
 */
import java.net.URLDecoder;
import java.sql.*;
import javax.swing.*;

public class javaconnect {
    
    Connection conn= null;
    Connection connlg = null;
    ResultSet rs =null;
    PreparedStatement pst =null;
    
    public static Connection ConnecrDb() {

    try {
        String decodedPath = URLDecoder.decode(javaconnect.class.getProtectionDomain().getCodeSource().getLocation().getPath(), "UTF-8");
        String purl = decodedPath.substring(0, decodedPath.lastIndexOf("/"));
        //String name = Main_form.txt_project.getText();
        String name = "VnRotifera";
        String Url = "jdbc:sqlite:"+purl+"/Image/"+name+".db.sqlite";
        
        Class.forName("org.sqlite.JDBC");
        Connection conn =DriverManager.getConnection(Url);
            //JOptionPane.showMessageDialog(null, "Connection Established");//"jdbc:sqlite:/mnt/01CF3E5C87626680/Analysis SAMPLES/DATABASE 2012/SqliteBase/VnRotifera.db.sqlite"
        return conn;
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
            return null;}
    }
    
    public static Connection ConnecrLg() {

    try {
        String decodedPath = URLDecoder.decode(javaconnect.class.getProtectionDomain().getCodeSource().getLocation().getPath(), "UTF-8");
        String purl = decodedPath.substring(0, decodedPath.lastIndexOf("/"));
        String Url = "jdbc:sqlite:"+purl+"/Image/mornitor.db.sqlite";
        
        Class.forName("org.sqlite.JDBC");
        Connection connlg =DriverManager.getConnection(Url);
            //JOptionPane.showMessageDialog(null, "Connection Established");//"jdbc:sqlite:/mnt/01CF3E5C87626680/Analysis SAMPLES/DATABASE 2012/SqliteBase/VnRotifera.db.sqlite"
        return connlg;
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
            return null;}
    }
    
}
