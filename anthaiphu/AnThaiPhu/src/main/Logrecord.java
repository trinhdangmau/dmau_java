/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.File;
import java.io.FileWriter;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import static main.Login_frame.txt_username;

/**
 *
 * @author trinhdangmau
 */
class Logrecord {
    
    Logrecord login = null;
    
    
    public static void log_in(String status){
    
        try{
            String decodedPath = URLDecoder.decode(Login_frame.class.getProtectionDomain().getCodeSource().getLocation().getPath(), "UTF-8");
            File log_file = new File(decodedPath + "logger.log");
            String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
            String uname = txt_username.getText();
            String logln = timeStamp + ", " + uname + ", " + status + " - Login\n";
            
            if(log_file.exists()){
                FileWriter log1 = new FileWriter(log_file, true);
                log1.write(logln);
                log1.close();
            }else{
                FileWriter log1 = new FileWriter(log_file, true);
                log1.write("The first database was created on" + timeStamp + "\n");
                log1.write(logln);
                log1.close();
            }
        }catch (Exception e) { 
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public static void log_out(){
    
        try{
            String decodedPath = URLDecoder.decode(Login_frame.class.getProtectionDomain().getCodeSource().getLocation().getPath(), "UTF-8");
            File log_file = new File(decodedPath + "logger.log");
            String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
            String uname = txt_username.getText();
            String logln = timeStamp + ", " + uname + " - Logout\n";
            
            if(log_file.exists()){
                FileWriter log1 = new FileWriter(log_file, true);
                log1.write(logln);
                log1.close();
            }else{
                FileWriter log1 = new FileWriter(log_file, true);
                log1.write("The first database was created on" + timeStamp + "\n");
                log1.write(logln);
                log1.close();
            }
        }catch (Exception e) { 
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
}
