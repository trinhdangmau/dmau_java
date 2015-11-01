/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.net.URLDecoder;
import java.sql.*;
import javax.swing.JOptionPane;

public class SQLiteJDBC{
  public static void create_table(String databasename)  {
    Connection c = null;
    Statement stmt = null;
    try {
        String decodedPath = URLDecoder.decode(javaconnect.class.getProtectionDomain().getCodeSource().getLocation().getPath(), "UTF-8");
        String purl = decodedPath.substring(0, decodedPath.lastIndexOf("/"));
        
        Class.forName("org.sqlite.JDBC");
        //String name = "atp_01";
        //String url = "jdbc:sqlite:" + name;
        String url = "jdbc:sqlite:"+purl+"/database/"+databasename+".db";
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
        
        String employee = "CREATE TABLE IF NOT EXISTS employee ("
                + "code_empl VARCHAR(8) NOT NULL,"
                + "name_empl VARCHAR(45) NOT NULL,"
                + "birthdate_empl DATE NULL,"
                + "gender_empl VARCHAR(5) NULL,"
                + "maritalstatus_empl VARCHAR(5) NULL,"
                + "salariedflag_empl VARCHAR(5) NULL,"
                + "hometown_empl VARCHAR(45) NULL,"
                + "enrolltime_empl DATE NULL,"
                + "position_empl VARCHAR(45) NULL,"
                + "user_empl VARCHAR(45) NULL,"
                + "PRIMARY KEY (code_empl))";
        stmt.executeUpdate(employee);
        
        String customer = "CREATE TABLE IF NOT EXISTS customer ("
                + "code_cust VARCHAR(8) NOT NULL,"
                + "name_cust VARCHAR(45) NULL,"
                + "add_cust VARCHAR(145) NULL,"
                + "district_cust VARCHAR(45) NULL,"
                + "province_cust VARCHAR(45) NULL,"
                + "company_cust VARCHAR(45) NULL,"
                + "phone_cust VARCHAR(45) NULL,"
                + "fax_cust VARCHAR(45) NULL,"
                + "email_cust VARCHAR(45) NULL,"
                + "note_cust VARCHAR(45) NULL,"
                + "user_cust VARCHAR(45) NULL,"
                + "PRIMARY KEY (code_cust))";
        stmt.executeUpdate(customer);
        
        String product_information = "CREATE TABLE IF NOT EXISTS product_information ("
                + "code_prod VARCHAR(8) NOT NULL,"
                + "name_prod VARCHAR(45) NULL,"
                + "original_prod VARCHAR(45) NULL,"
                + "unit_prod VARCHAR(5) NULL,"
                + "descript_prod TEXT NULL,"
                + "price_prod DECIMAL(10,0) NULL,"
                + "note_prod TEXT NULL,"
                + "user_prod VARCHAR(45) NULL,"
                + "PRIMARY KEY (code_prod))";
        stmt.executeUpdate(product_information);
        
        String partner = "CREATE TABLE IF NOT EXISTS partner ("
                + "code_part VARCHAR(8) NOT NULL,"
                + "name_part VARCHAR(45) NULL,"
                + "add_part VARCHAR(45) NULL,"
                + "district_part VARCHAR(45) NULL,"
                + "province_part VARCHAR(45) NULL,"
                + "company_part VARCHAR(45) NULL,"
                + "phone_part VARCHAR(45) NULL,"
                + "fax_part VARCHAR(45) NULL,"
                + "email_part VARCHAR(45) NULL,"
                + "note_part TEXT NULL,"
                + "user_part VARCHAR(45) NULL,"
                + "PRIMARY KEY (code_part))";
        stmt.executeUpdate(partner);
        
        String export_detail = "CREATE TABLE IF NOT EXISTS export_detail ("
                + "code_exdt VARCHAR(12) NOT NULL,"
                + "code_ex_exdt VARCHAR(11) NULL,"
                + "code_prod_exdt VARCHAR(8) NULL,"
                + "specification_exdt VARCHAR(45) NULL,"
                + "no_exdt DECIMAL(10,0) NULL,"
                + "weight_exdt DECIMAL(10,0) NULL,"
                + "unit_exdt VARCHAR(5) NULL,"
                + "price_exdt DECIMAL(10,0) NULL,"
                + "monetize_exdt DECIMAL(10,0) NULL,"
                + "user_exdt VARCHAR(45) NULL,"
                + "PRIMARY KEY (code_exdt))";
        stmt.executeUpdate(export_detail);
        
        String export = "CREATE TABLE IF NOT EXISTS export ("
                + "code_ex VARCHAR(11) NOT NULL,"
                + "code_cust_ex VARCHAR(8) NULL,"
                + "date_ex DATETIME NULL,"
                + "tax_ex DECIMAL(10,0) NULL,"
                + "total_ex DECIMAL(10,0) NULL,"
                + "paid_ex DECIMAL(10,0) NULL,"
                + "own_ex DECIMAL(10,0) NULL,"
                + "total_text_ex VARCHAR(45) NULL,"
                + "code_empl_ex VARCHAR(8) NULL,"
                + "note_ex TEXT NULL,"
                + "user_ex VARCHAR(45) NULL,"
                + "PRIMARY KEY (code_ex))";
        stmt.executeUpdate(export);
        
        String order_detail = "CREATE TABLE IF NOT EXISTS order_detail ("
                + "code_ordt VARCHAR(12) NOT NULL,"
                + "code_or_ordt VARCHAR(11) NULL,"
                + "code_prod_ordt VARCHAR(8) NULL,"
                + "specification_ordt VARCHAR(45) NULL,"
                + "no_ordt DECIMAL(10,0) NULL,"
                + "eweight_ordt DECIMAL(10,0) NULL,"
                + "unit_ordt VARCHAR(5) NULL,"
                + "price_ordt DECIMAL(10,0) NULL,"
                + "monetize_ordt DECIMAL(10,0) NULL,"
                + "user_ordt VARCHAR(45) NULL,"
                + "PRIMARY KEY (code_ordt))";
        stmt.executeUpdate(order_detail);
        
        String order_tb = "CREATE TABLE IF NOT EXISTS order_tb ("
                + "code_or VARCHAR(11) NOT NULL,"
                + "code_cust_or VARCHAR(8) NULL,"
                + "date_or DATETIME NULL, "
                + "date_delivery_or DATETIME NULL, "
                + "status_or VARCHAR(45) NULL,"
                + "code_empl_or VARCHAR(8) NULL,"
                + "note_or TEXT NULL,"
                + "user_or VARCHAR(45) NULL,"
                + "PRIMARY KEY (code_or))";
        stmt.executeUpdate(order_tb);
        
        String import_tb = "CREATE TABLE IF NOT EXISTS import_tb ("
                + "code_im VARCHAR(11) NOT NULL,"
                + "code_cust_im VARCHAR(8) NULL,"
                + "date_im DATETIME NULL,"
                + "tax_im DECIMAL(10,0) NULL,"
                + "total_im DECIMAL(10,0) NULL,"
                + "paid_im DECIMAL(10,0) NULL,"
                + "own_im DECIMAL(10,0) NULL,"
                + "total_text_im VARCHAR(45) NULL,"
                + "code_empl_im VARCHAR(8) NULL,"
                + "note_im TEXT NULL,"
                + "user_im VARCHAR(45) NULL,"
                + "PRIMARY KEY (code_im))";
        stmt.executeUpdate(import_tb);

        String import_detail = "CREATE TABLE IF NOT EXISTS import_detail ("
                + "code_imdt VARCHAR(12) NOT NULL,"
                + "code_im_imdt VARCHAR(11) NULL,"
                + "code_prod_imdt VARCHAR(8) NULL,"
                + "specification_imdt VARCHAR(45) NULL,"
                + "no_imdt DECIMAL(10,0) NULL,"
                + "weight_imdt DECIMAL(10,0) NULL,"
                + "unit_imdt VARCHAR(5) NULL,"
                + "price_imdt DECIMAL(10,0) NULL,"
                + "monetize_imdt DECIMAL(10,0) NULL,"
                + "user_imdt VARCHAR(45) NULL,"
                + "PRIMARY KEY (code_imdt))";
        stmt.executeUpdate(import_detail);
        
        
        //backup table
        stmt = c.createStatement();     
        String login_atp_bk = "CREATE TABLE IF NOT EXISTS login_atp_bk ("
                + "idlogin_atp INT NOT NULL, "
                + "first_name_logi VARCHAR(45) NULL, "
                + "last_name_logi VARCHAR(45) NULL,"
                + "username_logi VARCHAR(45) NOT NULL,"
                + "password_logi VARCHAR(45) NOT NULL,"
                + "address_logi VARCHAR(45) NULL,"
                + "email_logi VARCHAR(45) NULL,"
                + "phone_logi VARCHAR(45) NULL,"
                + "changedon DATETIME NULL, status VARCHAR(45) NULL)";
        stmt.executeUpdate(login_atp_bk);
        
        String employee_bk = "CREATE TABLE IF NOT EXISTS employee_bk ("
                + "code_empl VARCHAR(8) NOT NULL,"
                + "name_empl VARCHAR(45) NOT NULL,"
                + "birthdate_empl DATE NULL,"
                + "gender_empl VARCHAR(5) NULL,"
                + "maritalstatus_empl VARCHAR(5) NULL,"
                + "salariedflag_empl VARCHAR(5) NULL,"
                + "hometown_empl VARCHAR(45) NULL,"
                + "enrolltime_empl DATE NULL,"
                + "position_empl VARCHAR(45) NULL,"
                + "user_empl VARCHAR(45) NULL,"
                + "changedon DATETIME NULL, status VARCHAR(45) NULL)";
        stmt.executeUpdate(employee_bk);
        
        String customer_bk = "CREATE TABLE IF NOT EXISTS customer_bk ("
                + "code_cust VARCHAR(8) NOT NULL,"
                + "name_cust VARCHAR(45) NULL,"
                + "add_cust VARCHAR(145) NULL,"
                + "district_cust VARCHAR(45) NULL,"
                + "province_cust VARCHAR(45) NULL,"
                + "company_cust VARCHAR(45) NULL,"
                + "phone_cust VARCHAR(45) NULL,"
                + "fax_cust VARCHAR(45) NULL,"
                + "email_cust VARCHAR(45) NULL,"
                + "note_cust VARCHAR(45) NULL,"
                + "user_cust VARCHAR(45) NULL,"
                + "changedon DATETIME NULL, status VARCHAR(45) NULL)";
        stmt.executeUpdate(customer_bk);
        
        String product_information_bk = "CREATE TABLE IF NOT EXISTS product_information_bk ("
                + "code_prod VARCHAR(8) NOT NULL,"
                + "name_prod VARCHAR(45) NULL,"
                + "original_prod VARCHAR(45) NULL,"
                + "unit_prod VARCHAR(5) NULL,"
                + "descript_prod TEXT NULL,"
                + "price_prod DECIMAL(10,0) NULL,"
                + "note_prod TEXT NULL,"
                + "user_prod VARCHAR(45) NULL,"
                + "changedon DATETIME NULL, status VARCHAR(45) NULL)";
        stmt.executeUpdate(product_information_bk);
        
        String partner_bk = "CREATE TABLE IF NOT EXISTS partner_bk ("
                + "code_part VARCHAR(8) NOT NULL,"
                + "name_part VARCHAR(45) NULL,"
                + "add_part VARCHAR(45) NULL,"
                + "district_part VARCHAR(45) NULL,"
                + "province_part VARCHAR(45) NULL,"
                + "company_part VARCHAR(45) NULL,"
                + "phone_part VARCHAR(45) NULL,"
                + "fax_part VARCHAR(45) NULL,"
                + "email_part VARCHAR(45) NULL,"
                + "note_part TEXT NULL,"
                + "user_part VARCHAR(45) NULL,"
                + "changedon DATETIME NULL, status VARCHAR(45) NULL)";
        stmt.executeUpdate(partner_bk);
        
        String export_detail_bk = "CREATE TABLE IF NOT EXISTS export_detail_bk ("
                + "code_exdt VARCHAR(12) NOT NULL,"
                + "code_ex_exdt VARCHAR(11) NULL,"
                + "code_prod_exdt VARCHAR(8) NULL,"
                + "specification_exdt VARCHAR(45) NULL,"
                + "no_exdt DECIMAL(10,0) NULL,"
                + "weight_exdt DECIMAL(10,0) NULL,"
                + "unit_exdt VARCHAR(5) NULL,"
                + "price_exdt DECIMAL(10,0) NULL,"
                + "monetize_exdt DECIMAL(10,0) NULL,"
                + "user_exdt VARCHAR(45) NULL,"
                + "changedon DATETIME NULL, status VARCHAR(45) NULL)";
        stmt.executeUpdate(export_detail_bk);
        
        String export_bk = "CREATE TABLE IF NOT EXISTS export_bk ("
                + "code_ex VARCHAR(11) NOT NULL,"
                + "code_cust_ex VARCHAR(8) NULL,"
                + "date_ex DATETIME NULL,"
                + "tax_ex DECIMAL(10,0) NULL,"
                + "total_ex DECIMAL(10,0) NULL,"
                + "paid_ex DECIMAL(10,0) NULL,"
                + "own_ex DECIMAL(10,0) NULL,"
                + "total_text_ex VARCHAR(45) NULL,"
                + "code_empl_ex VARCHAR(8) NULL,"
                + "note_ex TEXT NULL,"
                + "user_ex VARCHAR(45) NULL,"
                + "changedon DATETIME NULL, status VARCHAR(45) NULL)";
        stmt.executeUpdate(export_bk);
        
        String order_detail_bk = "CREATE TABLE IF NOT EXISTS order_detail_bk ("
                + "code_ordt VARCHAR(12) NOT NULL,"
                + "code_or_ordt VARCHAR(11) NULL,"
                + "code_prod_ordt VARCHAR(8) NULL,"
                + "specification_ordt VARCHAR(45) NULL,"
                + "no_ordt DECIMAL(10,0) NULL,"
                + "eweight_ordt DECIMAL(10,0) NULL,"
                + "unit_ordt VARCHAR(5) NULL,"
                + "price_ordt DECIMAL(10,0) NULL,"
                + "monetize_ordt DECIMAL(10,0) NULL,"
                + "user_ordt VARCHAR(45) NULL,"
                + "changedon DATETIME NULL, status VARCHAR(45) NULL)";
        stmt.executeUpdate(order_detail_bk);
        
        String order_tb_bk = "CREATE TABLE IF NOT EXISTS order_tb_bk ("
                + "code_or VARCHAR(11) NOT NULL,"
                + "code_cust_or VARCHAR(8) NULL,"
                + "date_or DATETIME NULL, "
                + "date_delivery_or DATETIME NULL, "
                + "status_or VARCHAR(45) NULL,"
                + "code_empl_or VARCHAR(8) NULL,"
                + "note_or TEXT NULL,"
                + "user_or VARCHAR(45) NULL,"
                + "changedon DATETIME NULL, status VARCHAR(45) NULL)";
        stmt.executeUpdate(order_tb_bk);
        
        String import_tb_bk = "CREATE TABLE IF NOT EXISTS import_tb_bk ("
                + "code_im VARCHAR(11) NOT NULL,"
                + "code_cust_im VARCHAR(8) NULL,"
                + "date_im DATETIME NULL,"
                + "tax_im DECIMAL(10,0) NULL,"
                + "total_im DECIMAL(10,0) NULL,"
                + "paid_im DECIMAL(10,0) NULL,"
                + "own_im DECIMAL(10,0) NULL,"
                + "total_text_im VARCHAR(45) NULL,"
                + "code_empl_im VARCHAR(8) NULL,"
                + "note_im TEXT NULL,"
                + "user_im VARCHAR(45) NULL,"
                + "changedon DATETIME NULL, status VARCHAR(45) NULL)";
        stmt.executeUpdate(import_tb_bk);

        String import_detail_bk = "CREATE TABLE IF NOT EXISTS import_detail_bk ("
                + "code_imdt VARCHAR(12) NOT NULL,"
                + "code_im_imdt VARCHAR(11) NULL,"
                + "code_prod_imdt VARCHAR(8) NULL,"
                + "specification_imdt VARCHAR(45) NULL,"
                + "no_imdt DECIMAL(10,0) NULL,"
                + "weight_imdt DECIMAL(10,0) NULL,"
                + "unit_imdt VARCHAR(5) NULL,"
                + "price_imdt DECIMAL(10,0) NULL,"
                + "monetize_imdt DECIMAL(10,0) NULL,"
                + "user_imdt VARCHAR(45) NULL,"
                + "changedon DATETIME NULL, status VARCHAR(45) NULL)";
        stmt.executeUpdate(import_detail_bk);
        
        //Track change table
        String track_change = "CREATE TABLE IF NOT EXISTS track_change ("
                + "ID_T INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "table_name VARCHAR(45) NULL,"
                + "id VARCHAR(45),"
                + "changedon DATETIME NULL,"
                + "status VARCHAR(45) NULL)";
        stmt.executeUpdate(track_change);
        
        stmt.close();
        c.close();
    } catch ( Exception e ) {
      JOptionPane.showMessageDialog(null, e.getClass().getName() + ": " + e.getMessage() );
      //System.exit(0);
    }
    System.out.println("Table created successfully");
  }
  
  
  public static void trigger(String databasename){
    Connection c = null;
    Statement stmt = null;
    try {
        String decodedPath = URLDecoder.decode(javaconnect.class.getProtectionDomain().getCodeSource().getLocation().getPath(), "UTF-8");
        String purl = decodedPath.substring(0, decodedPath.lastIndexOf("/"));
        
        Class.forName("org.sqlite.JDBC");
        //String name = "atp_01";
        //String url = "jdbc:sqlite:" + name;
        String url = "jdbc:sqlite:"+purl+"/database/"+databasename+".db";
        c = DriverManager.getConnection(url);
        System.out.println("Opened database successfully");
        System.out.println(url);

        //main table
        stmt = c.createStatement();
        
        String sql = "INSERT INTO login_atp (idlogin_atp,first_name_logi,last_name_logi,"
                + "username_logi,password_logi) VALUES (1, 'Trinh', 'Mau', 'dmautrinh',"
                + " '123')";
        stmt.executeUpdate(sql);
        
        //trigger
        String produc_bef_del = "CREATE TRIGGER produc_bef_del BEFORE DELETE ON product_information "
                + "FOR EACH ROW " 
                + "BEGIN "
                + "INSERT INTO track_change (table_name, id, changedon, status) "
                + "VALUES ('product_information', OLD.code_prod, strftime('%Y-%m-%d %H:%M:%S','now', 'localtime'),'delete');"
                + "INSERT INTO product_information_bk (code_prod, name_prod, original_prod, unit_prod, descript_prod, price_prod, note_prod, user_prod, changedon, status) "
                + "VALUES (OLD.code_prod, OLD.name_prod, OLD.original_prod, OLD.unit_prod, OLD.descript_prod, OLD.price_prod, OLD.note_prod, OLD.user_prod, strftime('%Y-%m-%d %H:%M:%S','now', 'localtime'), 'delete');"
                + "END";
        stmt.executeUpdate(produc_bef_del);
        
        String customer_bef_del = "CREATE TRIGGER customer_bef_del BEFORE DELETE ON customer "
                + "FOR EACH ROW " 
                + "BEGIN "
                + "INSERT INTO track_change (table_name, id, changedon, status) "
                + "VALUES ('customer', OLD.code_cust, strftime('%Y-%m-%d %H:%M:%S','now', 'localtime'),'delete');"
                + "INSERT INTO customer_bk (code_cust,name_cust,add_cust,district_cust,province_cust,company_cust,phone_cust,fax_cust,email_cust,note_cust,user_cust, changedon, status) "
                + "VALUES (OLD.code_cust,OLD.name_cust,OLD.add_cust,OLD.district_cust,OLD.province_cust,OLD.company_cust,OLD.phone_cust,OLD.fax_cust,OLD.email_cust,OLD.note_cust,OLD.user_cust, strftime('%Y-%m-%d %H:%M:%S','now', 'localtime'), 'delete');"
                + "END";
        stmt.executeUpdate(customer_bef_del);
        
        String employee_bef_del = "CREATE TRIGGER employee_bef_del BEFORE DELETE ON employee "
                + "FOR EACH ROW " 
                + "BEGIN "
                + "INSERT INTO track_change (table_name, id, changedon, status) "
                + "VALUES ('employee',OLD.code_empl, strftime('%Y-%m-%d %H:%M:%S','now', 'localtime'),'delete');"
                + "INSERT INTO employee_bk (code_empl,name_empl,birthdate_empl,gender_empl,maritalstatus_empl,salariedflag_empl,hometown_empl,enrolltime_empl,position_empl,user_empl, changedon, status) "
                + "VALUES (OLD.code_empl,OLD.name_empl,OLD.birthdate_empl,OLD.gender_empl,OLD.maritalstatus_empl,OLD.salariedflag_empl,OLD.hometown_empl,OLD.enrolltime_empl,OLD.position_empl,OLD.user_empl, strftime('%Y-%m-%d %H:%M:%S','now', 'localtime'), 'delete');"
                + "END";
        stmt.executeUpdate(employee_bef_del);
        
        String export_bef_del = "CREATE TRIGGER export_bef_del BEFORE DELETE ON export "
                + "FOR EACH ROW " 
                + "BEGIN "
                + "INSERT INTO track_change (table_name, id, changedon, status) "
                + "VALUES ('export',OLD.code_ex, strftime('%Y-%m-%d %H:%M:%S','now', 'localtime'),'delete');"
                + "INSERT INTO export_bk (code_ex,code_cust_ex,date_ex,tax_ex,total_ex,paid_ex,own_ex,total_text_ex,code_empl_ex,note_ex,user_ex, changedon, status) "
                + "VALUES (OLD.code_ex,OLD.code_cust_ex,OLD.date_ex,OLD.tax_ex,OLD.total_ex,OLD.paid_ex,OLD.own_ex,OLD.total_text_ex,OLD.code_empl_ex,OLD.note_ex,OLD.user_ex, strftime('%Y-%m-%d %H:%M:%S','now', 'localtime'), 'delete');"
                + "END";
        stmt.executeUpdate(export_bef_del);
        
        String export_detail_bef_del = "CREATE TRIGGER export_detail_bef_del BEFORE DELETE ON export_detail "
                + "FOR EACH ROW " 
                + "BEGIN "
                + "INSERT INTO track_change (table_name, id, changedon, status) "
                + "VALUES ('export_detail', OLD.code_exdt, strftime('%Y-%m-%d %H:%M:%S','now', 'localtime'),'delete');"
                + "INSERT INTO export_detail_bk (code_exdt,code_ex_exdt,code_prod_exdt,specification_exdt,no_exdt,weight_exdt,unit_exdt,price_exdt,monetize_exdt,user_exdt, changedon, status) "
                + "VALUES (OLD.code_exdt,OLD.code_ex_exdt,OLD.code_prod_exdt,OLD.specification_exdt,OLD.no_exdt,OLD.weight_exdt,OLD.unit_exdt,OLD.price_exdt,OLD.monetize_exdt,OLD.user_exdt, strftime('%Y-%m-%d %H:%M:%S','now', 'localtime'), 'delete');"
                + "END";
        stmt.executeUpdate(export_detail_bef_del);
        
        //
        String order_detail_bef_del = "CREATE TRIGGER order_detail_bef_del BEFORE DELETE ON order_detail "
                + "FOR EACH ROW " 
                + "BEGIN "
                + "INSERT INTO track_change (table_name, id, changedon, status) "
                + "VALUES ('order_detail', OLD.code_ordt, strftime('%Y-%m-%d %H:%M:%S','now', 'localtime'),'delete');"
                + "INSERT INTO order_detail_bk (code_ordt,code_or_ordt, code_prod_ordt, specification_ordt, no_ordt, "
                + "eweight_ordt, unit_ordt, price_ordt, monetize_ordt, user_ordt, changedon, status) "
                + "VALUES (OLD.code_ordt,OLD.code_or_ordt, OLD.code_prod_ordt, OLD.specification_ordt, OLD.no_ordt, "
                + "OLD.eweight_ordt, OLD.unit_ordt, OLD.price_ordt, OLD.monetize_ordt, OLD.user_ordt, strftime('%Y-%m-%d %H:%M:%S','now', 'localtime'), 'delete');"
                + "END";
        stmt.executeUpdate(order_detail_bef_del);
        
        String order_tb_bef_del = "CREATE TRIGGER order_tb_bef_del BEFORE DELETE ON order_tb "
                + "FOR EACH ROW " 
                + "BEGIN "
                + "INSERT INTO track_change (table_name, id, changedon, status) "
                + "VALUES ('order_tb',OLD.code_or, strftime('%Y-%m-%d %H:%M:%S','now', 'localtime'),'delete');"
                + "INSERT INTO order_tb_bk (code_or, code_cust_or, date_or, date_delivery_or, status_or, "
                + "code_empl_or, note_or, user_or, changedon, status) "
                + "VALUES (OLD.code_or, OLD.code_cust_or, OLD.date_or, OLD.date_delivery_or, OLD.status_or, "
                + "OLD.code_empl_or, OLD.note_or, OLD.user_or, strftime('%Y-%m-%d %H:%M:%S','now', 'localtime'), 'delete');"
                + "END";
        stmt.executeUpdate(order_tb_bef_del);
        //
        
        String import_detail_bef_del = "CREATE TRIGGER import_detail_bef_del BEFORE DELETE ON import_detail "
                + "FOR EACH ROW " 
                + "BEGIN "
                + "INSERT INTO track_change (table_name, id, changedon, status) "
                + "VALUES ('import_detail', OLD.code_imdt, strftime('%Y-%m-%d %H:%M:%S','now', 'localtime'),'delete');"
                + "INSERT INTO import_detail_bk (code_imdt,code_im_imdt,code_prod_imdt,specification_imdt,no_imdt,weight_imdt,unit_imdt,price_imdt,monetize_imdt,user_imdt, changedon, status) "
                + "VALUES (OLD.code_imdt,OLD.code_im_imdt,OLD.code_prod_imdt,OLD.specification_imdt,OLD.no_imdt,OLD.weight_imdt,OLD.unit_imdt,OLD.price_imdt,OLD.monetize_imdt,OLD.user_imdt, strftime('%Y-%m-%d %H:%M:%S','now', 'localtime'), 'delete');"
                + "END";
        stmt.executeUpdate(import_detail_bef_del);
        
        String import_tb_bef_del = "CREATE TRIGGER import_tb_bef_del BEFORE DELETE ON import_tb "
                + "FOR EACH ROW " 
                + "BEGIN "
                + "INSERT INTO track_change (table_name, id, changedon, status) "
                + "VALUES ('import_tb', OLD.code_im, strftime('%Y-%m-%d %H:%M:%S','now', 'localtime'),'delete');"
                + "INSERT INTO import_tb_bk (code_im,code_cust_im,date_im,tax_im,total_im,paid_im,own_im,total_text_im,code_empl_im,note_im,user_im, changedon, status) "
                + "VALUES (OLD.code_im,OLD.code_cust_im,OLD.date_im,OLD.tax_im,OLD.total_im,OLD.paid_im,OLD.own_im,OLD.total_text_im,OLD.code_empl_im,OLD.note_im,OLD.user_im, strftime('%Y-%m-%d %H:%M:%S','now', 'localtime'), 'delete');"
                + "END";
        stmt.executeUpdate(import_tb_bef_del);
        
        String login_atp_bef_del = "CREATE TRIGGER login_atp_bef_del BEFORE DELETE ON login_atp "
                + "FOR EACH ROW " 
                + "BEGIN "
                + "INSERT INTO track_change (table_name, id, changedon, status) "
                + "VALUES ('login_atp', OLD.idlogin_atp, strftime('%Y-%m-%d %H:%M:%S','now', 'localtime'),'delete');"
                + "INSERT INTO login_atp_bk (idlogin_atp, first_name_logi, last_name_logi,username_logi,password_logi,address_logi,email_logi,phone_logi, changedon, status) "
                + "VALUES (OLD.idlogin_atp, OLD.first_name_logi, OLD.last_name_logi,OLD.username_logi,OLD.password_logi,OLD.address_logi,OLD.email_logi,OLD.phone_logi, strftime('%Y-%m-%d %H:%M:%S','now', 'localtime'), 'delete');"
                + "END";
        stmt.executeUpdate(login_atp_bef_del);
        
        String partner_bef_del = "CREATE TRIGGER partner_bef_del BEFORE DELETE ON partner "
                + "FOR EACH ROW " 
                + "BEGIN "
                + "INSERT INTO track_change (table_name, id, changedon, status) "
                + "VALUES ('partner', OLD.code_part, strftime('%Y-%m-%d %H:%M:%S','now', 'localtime'),'delete');"
                + "INSERT INTO partner_bk (code_part,name_part,add_part,district_part,province_part,company_part,phone_part,fax_part,email_part,note_part,user_part, changedon, status) "
                + "VALUES (OLD.code_part,OLD.name_part,OLD.add_part,OLD.district_part,OLD.province_part,OLD.company_part,OLD.phone_part,OLD.fax_part,OLD.email_part,OLD.note_part,OLD.user_part, strftime('%Y-%m-%d %H:%M:%S','now', 'localtime'), 'delete');"
                + "END";
        stmt.executeUpdate(partner_bef_del);
        
        //trigger for update
        String produc_bef_update = "CREATE TRIGGER produc_bef_update BEFORE UPDATE ON product_information "
                + "FOR EACH ROW " 
                + "BEGIN "
                + "INSERT INTO track_change (table_name, id, changedon, status) "
                + "VALUES ('product_information', OLD.code_prod, strftime('%Y-%m-%d %H:%M:%S','now', 'localtime'),'update');"
                + "INSERT INTO product_information_bk (code_prod, name_prod, original_prod, unit_prod, descript_prod, price_prod, note_prod, user_prod, changedon, status) "
                + "VALUES (OLD.code_prod, OLD.name_prod, OLD.original_prod, OLD.unit_prod, OLD.descript_prod, OLD.price_prod, OLD.note_prod, OLD.user_prod, strftime('%Y-%m-%d %H:%M:%S','now', 'localtime'), 'update');"
                + "END";
        stmt.executeUpdate(produc_bef_update);
        
        String customer_bef_update = "CREATE TRIGGER customer_bef_update BEFORE UPDATE ON customer "
                + "FOR EACH ROW " 
                + "BEGIN "
                + "INSERT INTO track_change (table_name, id, changedon, status) "
                + "VALUES ('customer', OLD.code_cust, strftime('%Y-%m-%d %H:%M:%S','now', 'localtime'),'update');"
                + "INSERT INTO customer_bk (code_cust,name_cust,add_cust,district_cust,province_cust,company_cust,phone_cust,fax_cust,email_cust,note_cust,user_cust, changedon, status) "
                + "VALUES (OLD.code_cust,OLD.name_cust,OLD.add_cust,OLD.district_cust,OLD.province_cust,OLD.company_cust,OLD.phone_cust,OLD.fax_cust,OLD.email_cust,OLD.note_cust,OLD.user_cust, strftime('%Y-%m-%d %H:%M:%S','now', 'localtime'), 'update');"
                + "END";
        stmt.executeUpdate(customer_bef_update);
        
        String employee_bef_update = "CREATE TRIGGER employee_bef_update BEFORE UPDATE ON employee "
                + "FOR EACH ROW " 
                + "BEGIN "
                + "INSERT INTO track_change (table_name, id, changedon, status) "
                + "VALUES ('employee', OLD.code_empl, strftime('%Y-%m-%d %H:%M:%S','now', 'localtime'),'update');"
                + "INSERT INTO employee_bk (code_empl,name_empl,birthdate_empl,gender_empl,maritalstatus_empl,salariedflag_empl,hometown_empl,enrolltime_empl,position_empl,user_empl, changedon, status) "
                + "VALUES (OLD.code_empl,OLD.name_empl,OLD.birthdate_empl,OLD.gender_empl,OLD.maritalstatus_empl,OLD.salariedflag_empl,OLD.hometown_empl,OLD.enrolltime_empl,OLD.position_empl,OLD.user_empl, strftime('%Y-%m-%d %H:%M:%S','now', 'localtime'), 'update');"
                + "END";
        stmt.executeUpdate(employee_bef_update);
        
        String export_bef_update = "CREATE TRIGGER export_bef_update BEFORE UPDATE ON export "
                + "FOR EACH ROW " 
                + "BEGIN "
                + "INSERT INTO track_change (table_name, id, changedon, status) "
                + "VALUES ('export',OLD.code_ex, strftime('%Y-%m-%d %H:%M:%S','now', 'localtime'),'update');"
                + "INSERT INTO export_bk (code_ex,code_cust_ex,date_ex,tax_ex,total_ex,paid_ex,own_ex,total_text_ex,code_empl_ex,note_ex,user_ex, changedon, status) "
                + "VALUES (OLD.code_ex,OLD.code_cust_ex,OLD.date_ex,OLD.tax_ex,OLD.total_ex,OLD.paid_ex,OLD.own_ex,OLD.total_text_ex,OLD.code_empl_ex,OLD.note_ex,OLD.user_ex, strftime('%Y-%m-%d %H:%M:%S','now', 'localtime'), 'update');"
                + "END";
        stmt.executeUpdate(export_bef_update);
        
        String export_detail_bef_update = "CREATE TRIGGER export_detail_bef_update BEFORE UPDATE ON export_detail "
                + "FOR EACH ROW " 
                + "BEGIN "
                + "INSERT INTO track_change (table_name, id, changedon, status) "
                + "VALUES ('export_detail', OLD.code_exdt, strftime('%Y-%m-%d %H:%M:%S','now', 'localtime'),'update');"
                + "INSERT INTO export_detail_bk (code_exdt,code_ex_exdt,code_prod_exdt,specification_exdt,no_exdt,weight_exdt,unit_exdt,price_exdt,monetize_exdt,user_exdt, changedon, status) "
                + "VALUES (OLD.code_exdt,OLD.code_ex_exdt,OLD.code_prod_exdt,OLD.specification_exdt,OLD.no_exdt,OLD.weight_exdt,OLD.unit_exdt,OLD.price_exdt,OLD.monetize_exdt,OLD.user_exdt, strftime('%Y-%m-%d %H:%M:%S','now', 'localtime'), 'update');"
                + "END";
        stmt.executeUpdate(export_detail_bef_update);
        
        //
        String order_detail_bef_update = "CREATE TRIGGER order_detail_bef_update BEFORE UPDATE ON order_detail "
                + "FOR EACH ROW " 
                + "BEGIN "
                + "INSERT INTO track_change (table_name, id, changedon, status) "
                + "VALUES ('order_detail', OLD.code_ordt, strftime('%Y-%m-%d %H:%M:%S','now', 'localtime'),'update');"
                + "INSERT INTO order_detail_bk (code_ordt,code_or_ordt, code_prod_ordt, specification_ordt, no_ordt, "
                + "eweight_ordt, unit_ordt, price_ordt, monetize_ordt, user_ordt, changedon, status) "
                + "VALUES (OLD.code_ordt,OLD.code_or_ordt, OLD.code_prod_ordt, OLD.specification_ordt, OLD.no_ordt, "
                + "OLD.eweight_ordt, OLD.unit_ordt, OLD.price_ordt, OLD.monetize_ordt, OLD.user_ordt, strftime('%Y-%m-%d %H:%M:%S','now', 'localtime'), 'update');"
                + "END";
        stmt.executeUpdate(order_detail_bef_update);
        
        String order_tb_bef_update = "CREATE TRIGGER order_tb_bef_update BEFORE UPDATE ON order_tb "
                + "FOR EACH ROW " 
                + "BEGIN "
                + "INSERT INTO track_change (table_name, id, changedon, status) "
                + "VALUES ('order_tb',OLD.code_or, strftime('%Y-%m-%d %H:%M:%S','now', 'localtime'),'update');"
                + "INSERT INTO order_tb_bk (code_or, code_cust_or, date_or, date_delivery_or, status_or, "
                + "code_empl_or, note_or, user_or, changedon, status) "
                + "VALUES (OLD.code_or, OLD.code_cust_or, OLD.date_or, OLD.date_delivery_or, OLD.status_or, "
                + "OLD.code_empl_or, OLD.note_or, OLD.user_or, strftime('%Y-%m-%d %H:%M:%S','now', 'localtime'), 'update');"
                + "END";
        stmt.executeUpdate(order_tb_bef_update);
        //
        
        String import_detail_bef_update = "CREATE TRIGGER import_detail_bef_update BEFORE UPDATE ON import_detail "
                + "FOR EACH ROW " 
                + "BEGIN "
                + "INSERT INTO track_change (table_name, id, changedon, status) "
                + "VALUES ('import_detail', OLD.code_imdt, strftime('%Y-%m-%d %H:%M:%S','now', 'localtime'),'update');"
                + "INSERT INTO import_detail_bk (code_imdt,code_im_imdt,code_prod_imdt,specification_imdt,no_imdt,weight_imdt,unit_imdt,price_imdt,monetize_imdt,user_imdt, changedon, status) "
                + "VALUES (OLD.code_imdt,OLD.code_im_imdt,OLD.code_prod_imdt,OLD.specification_imdt,OLD.no_imdt,OLD.weight_imdt,OLD.unit_imdt,OLD.price_imdt,OLD.monetize_imdt,OLD.user_imdt, strftime('%Y-%m-%d %H:%M:%S','now', 'localtime'), 'update');"
                + "END";
        stmt.executeUpdate(import_detail_bef_update);
        
        String import_tb_bef_update = "CREATE TRIGGER import_tb_bef_update BEFORE UPDATE ON import_tb "
                + "FOR EACH ROW " 
                + "BEGIN "
                + "INSERT INTO track_change (table_name, id, changedon, status) "
                + "VALUES ('import_tb',OLD.code_im, strftime('%Y-%m-%d %H:%M:%S','now', 'localtime'),'update');"
                + "INSERT INTO import_tb_bk (code_im,code_cust_im,date_im,tax_im,total_im,paid_im,own_im,total_text_im,code_empl_im,note_im,user_im, changedon, status) "
                + "VALUES (OLD.code_im,OLD.code_cust_im,OLD.date_im,OLD.tax_im,OLD.total_im,OLD.paid_im,OLD.own_im,OLD.total_text_im,OLD.code_empl_im,OLD.note_im,OLD.user_im, strftime('%Y-%m-%d %H:%M:%S','now', 'localtime'), 'update');"
                + "END";
        stmt.executeUpdate(import_tb_bef_update);
        
        String login_atp_bef_update = "CREATE TRIGGER login_atp_bef_update BEFORE UPDATE ON login_atp "
                + "FOR EACH ROW " 
                + "BEGIN "
                + "INSERT INTO track_change (table_name, id, changedon, status) "
                + "VALUES ('login_atp', OLD.idlogin_atp, strftime('%Y-%m-%d %H:%M:%S','now', 'localtime'),'update');"
                + "INSERT INTO login_atp_bk (idlogin_atp, first_name_logi, last_name_logi,username_logi,password_logi,address_logi,email_logi,phone_logi, changedon, status) "
                + "VALUES (OLD.idlogin_atp, OLD.first_name_logi, OLD.last_name_logi,OLD.username_logi,OLD.password_logi,OLD.address_logi,OLD.email_logi,OLD.phone_logi, strftime('%Y-%m-%d %H:%M:%S','now', 'localtime'), 'update');"
                + "END";
        stmt.executeUpdate(login_atp_bef_update);
        
        String partner_bef_update = "CREATE TRIGGER partner_bef_update BEFORE UPDATE ON partner "
                + "FOR EACH ROW " 
                + "BEGIN "
                + "INSERT INTO track_change (table_name, id, changedon, status) "
                + "VALUES ('partner', OLD.code_part, strftime('%Y-%m-%d %H:%M:%S','now', 'localtime'),'update');"
                + "INSERT INTO partner_bk (code_part,name_part,add_part,district_part,province_part,company_part,phone_part,fax_part,email_part,note_part,user_part, changedon, status) "
                + "VALUES (OLD.code_part,OLD.name_part,OLD.add_part,OLD.district_part,OLD.province_part,OLD.company_part,OLD.phone_part,OLD.fax_part,OLD.email_part,OLD.note_part,OLD.user_part, strftime('%Y-%m-%d %H:%M:%S','now', 'localtime'), 'update');"
                + "END";
        stmt.executeUpdate(partner_bef_update);
        
        //triger for add new
        String produc_aft_insert = "CREATE TRIGGER produc_aft_insert AFTER INSERT ON product_information "
                + "FOR EACH ROW " 
                + "BEGIN "
                + "INSERT INTO track_change (table_name, id, changedon, status) "
                + "VALUES ('product_information',NEW.code_prod, strftime('%Y-%m-%d %H:%M:%S','now', 'localtime'),'insert');"
                + "INSERT INTO product_information_bk (code_prod, name_prod, original_prod, unit_prod, descript_prod, price_prod, note_prod, user_prod, changedon, status) "
                + "VALUES (NEW.code_prod, NEW.name_prod, NEW.original_prod, NEW.unit_prod, NEW.descript_prod, NEW.price_prod, NEW.note_prod, NEW.user_prod, strftime('%Y-%m-%d %H:%M:%S','now', 'localtime'), 'insert');"
                + "END";
        stmt.executeUpdate(produc_aft_insert);
        
        String customer_aft_insert = "CREATE TRIGGER customer_aft_insert AFTER INSERT ON customer "
                + "FOR EACH ROW " 
                + "BEGIN "
                + "INSERT INTO track_change (table_name, id, changedon, status) "
                + "VALUES ('customer', NEW.code_cust, strftime('%Y-%m-%d %H:%M:%S','now', 'localtime'),'insert');"
                + "INSERT INTO customer_bk (code_cust,name_cust,add_cust,district_cust,province_cust,company_cust,phone_cust,fax_cust,email_cust,note_cust,user_cust, changedon, status) "
                + "VALUES (NEW.code_cust,NEW.name_cust,NEW.add_cust,NEW.district_cust,NEW.province_cust,NEW.company_cust,NEW.phone_cust,NEW.fax_cust,NEW.email_cust,NEW.note_cust,NEW.user_cust, strftime('%Y-%m-%d %H:%M:%S','now', 'localtime'), 'insert');"
                + "END";
        stmt.executeUpdate(customer_aft_insert);
        
        String employee_aft_insert = "CREATE TRIGGER employee_aft_insert AFTER INSERT ON employee "
                + "FOR EACH ROW " 
                + "BEGIN "
                + "INSERT INTO track_change (table_name, id, changedon, status) "
                + "VALUES ('employee', NEW.code_empl, strftime('%Y-%m-%d %H:%M:%S','now', 'localtime'),'insert');"
                + "INSERT INTO employee_bk (code_empl,name_empl,birthdate_empl,gender_empl,maritalstatus_empl,salariedflag_empl,hometown_empl,enrolltime_empl,position_empl,user_empl, changedon, status) "
                + "VALUES (NEW.code_empl,NEW.name_empl,NEW.birthdate_empl,NEW.gender_empl,NEW.maritalstatus_empl,NEW.salariedflag_empl,NEW.hometown_empl,NEW.enrolltime_empl,NEW.position_empl,NEW.user_empl, strftime('%Y-%m-%d %H:%M:%S','now', 'localtime'), 'insert');"
                + "END";
        stmt.executeUpdate(employee_aft_insert);
        
        String export_aft_insert = "CREATE TRIGGER export_aft_insert AFTER INSERT ON export "
                + "FOR EACH ROW " 
                + "BEGIN "
                + "INSERT INTO track_change (table_name, id, changedon, status) "
                + "VALUES ('export', NEW.code_ex, strftime('%Y-%m-%d %H:%M:%S','now', 'localtime'),'insert');"
                + "INSERT INTO export_bk (code_ex,code_cust_ex,date_ex,tax_ex,total_ex,paid_ex,own_ex,total_text_ex,code_empl_ex,note_ex,user_ex, changedon, status) "
                + "VALUES (NEW.code_ex,NEW.code_cust_ex,NEW.date_ex,NEW.tax_ex,NEW.total_ex,NEW.paid_ex,NEW.own_ex,NEW.total_text_ex,NEW.code_empl_ex,NEW.note_ex,NEW.user_ex, strftime('%Y-%m-%d %H:%M:%S','now', 'localtime'), 'insert');"
                + "END";
        stmt.executeUpdate(export_aft_insert);
        
        String export_detail_aft_insert = "CREATE TRIGGER export_detail_aft_insert AFTER INSERT ON export_detail "
                + "FOR EACH ROW " 
                + "BEGIN "
                + "INSERT INTO track_change (table_name, id, changedon, status) "
                + "VALUES ('export_detail', NEW.code_exdt, strftime('%Y-%m-%d %H:%M:%S','now', 'localtime'),'insert');"
                + "INSERT INTO export_detail_bk (code_exdt,code_ex_exdt,code_prod_exdt,specification_exdt,no_exdt,weight_exdt,unit_exdt,price_exdt,monetize_exdt,user_exdt, changedon, status) "
                + "VALUES (NEW.code_exdt,NEW.code_ex_exdt,NEW.code_prod_exdt,NEW.specification_exdt,NEW.no_exdt,NEW.weight_exdt,NEW.unit_exdt,NEW.price_exdt,NEW.monetize_exdt,NEW.user_exdt, strftime('%Y-%m-%d %H:%M:%S','now', 'localtime'), 'insert');"
                + "END";
        stmt.executeUpdate(export_detail_aft_insert);
        
        //
        String order_detail_aft_insert = "CREATE TRIGGER order_detail_aft_insert AFTER INSERT ON order_detail "
                + "FOR EACH ROW " 
                + "BEGIN "
                + "INSERT INTO track_change (table_name, id, changedon, status) "
                + "VALUES ('order_detail', NEW.code_ordt, strftime('%Y-%m-%d %H:%M:%S','now', 'localtime'),'insert');"
                + "INSERT INTO order_detail_bk (code_ordt,code_or_ordt, code_prod_ordt, specification_ordt, no_ordt, "
                + "eweight_ordt, unit_ordt, price_ordt, monetize_ordt, user_ordt, changedon, status) "
                + "VALUES (NEW.code_ordt,NEW.code_or_ordt, NEW.code_prod_ordt, NEW.specification_ordt, NEW.no_ordt, "
                + "NEW.eweight_ordt, NEW.unit_ordt, NEW.price_ordt, NEW.monetize_ordt, NEW.user_ordt, strftime('%Y-%m-%d %H:%M:%S','now', 'localtime'), 'insert');"
                + "END";
        stmt.executeUpdate(order_detail_aft_insert);
        
        String order_tb_aft_insert = "CREATE TRIGGER order_tb_aft_insert AFTER INSERT ON order_tb "
                + "FOR EACH ROW " 
                + "BEGIN "
                + "INSERT INTO track_change (table_name, id, changedon, status) "
                + "VALUES ('order_tb',NEW.code_or, strftime('%Y-%m-%d %H:%M:%S','now', 'localtime'),'insert');"
                + "INSERT INTO order_tb_bk (code_or, code_cust_or, date_or, date_delivery_or, status_or, "
                + "code_empl_or, note_or, user_or, changedon, status) "
                + "VALUES (NEW.code_or, NEW.code_cust_or, NEW.date_or, NEW.date_delivery_or, NEW.status_or, "
                + "NEW.code_empl_or, NEW.note_or, NEW.user_or, strftime('%Y-%m-%d %H:%M:%S','now', 'localtime'), 'insert');"
                + "END";
        stmt.executeUpdate(order_tb_aft_insert);
        //
        
        String import_detail_aft_insert = "CREATE TRIGGER import_detail_aft_insert AFTER INSERT ON import_detail "
                + "FOR EACH ROW " 
                + "BEGIN "
                + "INSERT INTO track_change (table_name, id, changedon, status) "
                + "VALUES ('import_detail', NEW.code_imdt, strftime('%Y-%m-%d %H:%M:%S','now', 'localtime'),'insert');"
                + "INSERT INTO import_detail_bk (code_imdt,code_im_imdt,code_prod_imdt,specification_imdt,no_imdt,weight_imdt,unit_imdt,price_imdt,monetize_imdt,user_imdt, changedon, status) "
                + "VALUES (NEW.code_imdt,NEW.code_im_imdt,NEW.code_prod_imdt,NEW.specification_imdt,NEW.no_imdt,NEW.weight_imdt,NEW.unit_imdt,NEW.price_imdt,NEW.monetize_imdt,NEW.user_imdt, strftime('%Y-%m-%d %H:%M:%S','now', 'localtime'), 'insert');"
                + "END";
        stmt.executeUpdate(import_detail_aft_insert);
        
        String import_tb_aft_insert = "CREATE TRIGGER import_tb_aft_insert AFTER INSERT ON import_tb "
                + "FOR EACH ROW " 
                + "BEGIN "
                + "INSERT INTO track_change (table_name, id, changedon, status) "
                + "VALUES ('import_tb', NEW.code_im, strftime('%Y-%m-%d %H:%M:%S','now', 'localtime'),'insert');"
                + "INSERT INTO import_tb_bk (code_im,code_cust_im,date_im,tax_im,total_im,paid_im,own_im,total_text_im,code_empl_im,note_im,user_im, changedon, status) "
                + "VALUES (NEW.code_im,NEW.code_cust_im,NEW.date_im,NEW.tax_im,NEW.total_im,NEW.paid_im,NEW.own_im,NEW.total_text_im,NEW.code_empl_im,NEW.note_im,NEW.user_im, strftime('%Y-%m-%d %H:%M:%S','now', 'localtime'), 'insert');"
                + "END";
        stmt.executeUpdate(import_tb_aft_insert);
        
        String login_atp_aft_insert = "CREATE TRIGGER login_atp_aft_insert AFTER INSERT ON login_atp "
                + "FOR EACH ROW " 
                + "BEGIN "
                + "INSERT INTO track_change (table_name, id, changedon, status) "
                + "VALUES ('login_atp', NEW.idlogin_atp, strftime('%Y-%m-%d %H:%M:%S','now', 'localtime'),'insert');"
                + "INSERT INTO login_atp_bk (idlogin_atp, first_name_logi, last_name_logi,username_logi,password_logi,address_logi,email_logi,phone_logi, changedon, status) "
                + "VALUES (NEW.idlogin_atp, NEW.first_name_logi, NEW.last_name_logi,NEW.username_logi,NEW.password_logi,NEW.address_logi,NEW.email_logi,NEW.phone_logi, strftime('%Y-%m-%d %H:%M:%S','now', 'localtime'), 'insert');"
                + "END";
        stmt.executeUpdate(login_atp_aft_insert);
        
        String partner_aft_insert = "CREATE TRIGGER partner_aft_insert AFTER INSERT ON partner "
                + "FOR EACH ROW " 
                + "BEGIN "
                + "INSERT INTO track_change (table_name, id, changedon, status) "
                + "VALUES ('partner',NEW.code_part, strftime('%Y-%m-%d %H:%M:%S','now', 'localtime'),'insert');"
                + "INSERT INTO partner_bk (code_part,name_part,add_part,district_part,province_part,company_part,phone_part,fax_part,email_part,note_part,user_part, changedon, status) "
                + "VALUES (NEW.code_part,NEW.name_part,NEW.add_part,NEW.district_part,NEW.province_part,NEW.company_part,NEW.phone_part,NEW.fax_part,NEW.email_part,NEW.note_part,NEW.user_part, strftime('%Y-%m-%d %H:%M:%S','now', 'localtime'), 'insert');"
                + "END";
        stmt.executeUpdate(partner_aft_insert);
        
        //View
        String export_view = "CREATE VIEW export_view AS select * from export "
                + "LEFT JOIN export_detail on code_ex = code_ex_exdt "
                + "LEFT JOIN customer on code_cust = code_cust_ex "
                + "LEFT JOIN product_information on code_prod = code_prod_exdt ";
        stmt.executeUpdate(export_view);

        stmt.close();
        c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    System.out.println("TRIGGER created successfully");
  }
  
}
