/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

/**
 *
 * @author dmautrinh
 */
public class backupdata {
    public static void databk(String output){
    FTPClient client = new FTPClient();
        FileInputStream fis = null;
    try{
        client.connect("ftp.anthaiphusteel.com");
        client.login("dmautrinh@anthaiphusteel.com", "0905436189");
        
        String decodedPath = URLDecoder.decode(javaconnect.class.getProtectionDomain().getCodeSource().getLocation().getPath(), "UTF-8");
        String purl = decodedPath.substring(0, decodedPath.lastIndexOf("/"))+"/database/atp_01.db";
        File inputFile = new File(purl);
        //encrypt
        File encryptedFile = new File(output);
        CryptoUtils.encrypt("QA562002", inputFile, encryptedFile);
        
        fis = new FileInputStream(encryptedFile);
        client.setFileType(FTP.BINARY_FILE_TYPE);
        
        int p =JOptionPane.showConfirmDialog(null, "Bạn có muốn sao lưu cơ sở dữ liệu này không?", "Backup Database", JOptionPane.YES_NO_OPTION);
        if (p==1){return;}

        if (!client.storeFile(output, fis)) {
            JOptionPane.showMessageDialog(null, "Tiến trình sao lưu gặp lỗi!");
          } 
            int reply = client.getReplyCode();

            if(!FTPReply.isPositiveCompletion(reply)) {
                JOptionPane.showMessageDialog(null, "Tiến trình sao lưu gặp lỗi!");
            } else{JOptionPane.showMessageDialog(null, encryptedFile.getName()+", Sao lưu thành công...");}
        client.logout();
        fis.close();
    }catch (IOException ex) {
            Logger.getLogger(dashboard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CryptoException ex) {
            Logger.getLogger(dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
