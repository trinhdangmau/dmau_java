/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

/**
 *
 * @author dmautrinh
 */
public class function {
    public static void addTextAndSelectToTextFieldToRest(JTextField textField, String nevDato){
    String datoBuscado = "";
    int nroActual = textField.getText().length();
    datoBuscado = nevDato.substring(nroActual, nevDato.length());
    if(nevDato.isEmpty()|| datoBuscado.isEmpty())
        return;
    try {
        textField.getDocument().insertString(textField.getCaretPosition(), datoBuscado, null);
    } catch(Exception e){}
    textField.select(nroActual, textField.getText().length());
    }
    
    
    //
    public static String getTexttoApartirVector(String datoBuscar, String[]veDatos){
    int nroPosicion = getPositionVectorBusSemi(datoBuscar, veDatos);
    if(nroPosicion ==-1){
        return datoBuscar;
        }
        return veDatos[nroPosicion];
    }
    
    //
    public static int getPositionVectorBusSemi(String datasearch, String[]veDatos)
    {
        try{
            for (int i=0;i<veDatos.length; i++){
            if(datasearch.equals(veDatos[i].substring(0,datasearch.length())))
                return i;
            }
        }catch(Exception e){}
        return -1;
    }
    
    public static String fromdate(String month, String year){
        String date = debt_date();
        int moth = Integer.parseInt(month);
        if(moth ==1){
            String m = "12";
            int y1 = Integer.parseInt(year);
            String y = Integer.toString(y1-1);
            String out = y+'-'+m+'-'+date;
            return out;
        }else{
            if(moth < 11){
                int tem = moth -1;
                String m = "0"+tem;
                String out = year+'-'+m+'-'+date;
                return out;
            }else{
                int tem = moth - 1;
                String m = Integer.toString(tem);
                String out = year+'-'+m+'-'+date;
                return out;
            }
        }
    
    }
    
    
    public static String debt_date(){
        String purl = location();
        Properties p = new Properties();
        try {
            p.load(new FileInputStream(purl + "/database/export_setting.ini"));
        } catch (IOException ex) {
            Logger.getLogger(debt_cust_frame.class.getName()).log(Level.SEVERE, null, ex);
        }
        String date = p.getProperty("date_of_check");
        return date;
    }
    
    public static String MCH(){
        String purl = location();
        Properties p = new Properties();
        try {
            p.load(new FileInputStream(purl + "/database/proj_setup.ini"));
        } catch (IOException ex) {
            Logger.getLogger(debt_cust_frame.class.getName()).log(Level.SEVERE, null, ex);
        }
        String mch = p.getProperty("code_brach");
        return mch;
    }
    
    public static String location(){
            try {
                String decodedPath = URLDecoder.decode(function.class.getProtectionDomain().getCodeSource().getLocation().getPath(), "UTF-8");
                String purl = decodedPath.substring(0, decodedPath.lastIndexOf("/"));
                return purl;
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(debt_cust_frame.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
    }
    
    public static String lc2(){
        String purl = location();
        return purl;
    }
    public static String currentdata(){
        String purl = location();
        Properties p = new Properties();
        try{
            p.load(new FileInputStream(purl + "/database/proj_setup.ini"));
        }catch(IOException ex){return null;}
    
        String dbname = p.getProperty("Database");
        String out = purl+"/database/"+dbname+".db";
        return out;
    }
}
