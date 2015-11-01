/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Toolkit;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import static main.export_frame.txt_code_ex;
import net.proteanit.sql.DbUtils;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author dmautrinh
 */
public class order_form extends javax.swing.JFrame {
    Connection conn=null;
    ResultSet rs =null;
    PreparedStatement pst =null;
    ResultSet rs2 =null;
    PreparedStatement pst2 =null;
    /**
     * Creates new form order_form
     */
    public order_form() {
        initComponents();
        conn=javaconnect.ConnecrDb();
        Fildcombo_name_cust();
        Fildcombo_name_empl();
        setIcon();
    }

    private void setIcon() {
        String purl = function.lc2();
        String Url = purl+"/database/logo90.png";
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(Url));
    }
    
    private void Fildcombo_name_cust(){
    combo_name_cust.removeAllItems();
    try {
    String sql ="SELECT name_cust FROM customer ORDER BY name_cust ";
    pst=conn.prepareStatement(sql);
    rs=pst.executeQuery();
    //combo_genus.addItem("");
    combo_name_cust.setEditable(true);
    while(rs.next()){
        String name =rs.getString("name_cust");
        combo_name_cust.addItem(name);}
        AutoCompleteDecorator.decorate(this.combo_name_cust);
    }
    catch (Exception e){JOptionPane.showMessageDialog(null, e);}
    finally {try {rs.close();pst.close();}catch (Exception e){}}
}

private void Fildcombo_name_empl(){
    combo_name_empl.removeAllItems();
    try {
    String sql ="SELECT name_empl FROM employee ORDER BY name_empl ";
    pst=conn.prepareStatement(sql);
    rs=pst.executeQuery();
    //combo_genus.addItem("");
    combo_name_empl.setEditable(true);
    while(rs.next()){
        String name_empl =rs.getString("name_empl");
        combo_name_empl.addItem(name_empl);}
        AutoCompleteDecorator.decorate(this.combo_name_empl);
    }
    catch (Exception e){JOptionPane.showMessageDialog(null, e);}
    finally {try {rs.close();pst.close();}catch (Exception e){}}
}

private void Fildcombo_name_prod(){
    combo_name_prod.removeAllItems();
    try {
    String sql ="SELECT name_prod FROM product_information ORDER BY name_prod ";
    pst=conn.prepareStatement(sql);
    rs=pst.executeQuery();
    combo_name_prod.setEditable(true);
    while(rs.next()){
        String name =rs.getString("name_prod");
        combo_name_prod.addItem(name);}
        AutoCompleteDecorator.decorate(this.combo_name_prod);
    }
    catch (Exception e){JOptionPane.showMessageDialog(null, e);}
    finally {try {rs.close();pst.close();}catch (Exception e){}}
}

public void Update_tbl_order_detail(){
    String tmp = txt_code_or.getText().toUpperCase();
    try{
        String sql = "SELECT code_ordt AS 'ID', name_prod AS 'Tên SP', specification_ordt AS 'Quy cách', "
                + "no_ordt AS 'No.', eweight_ordt AS 'TL ước tính', unit_ordt AS 'Unit', "
                + "price_ordt AS 'Đơn giá', monetize_ordt AS 'Thành tiền'"
                + "FROM order_detail "
                + "LEFT JOIN product_information ON code_prod_ordt = code_prod "
                + "WHERE code_or_ordt = '"+tmp+"' ";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
        table_order_detail.setModel(DbUtils.resultSetToTableModel(rs));
        table_order_detail.getColumnModel().getColumn(3).setPreferredWidth(12);
        table_order_detail.getColumnModel().getColumn(1).setPreferredWidth(30);
        table_order_detail.getColumnModel().getColumn(5).setPreferredWidth(12);
                }
        catch (Exception e){JOptionPane.showMessageDialog(null, e);}
        finally {try {rs.close(); pst.close();}catch (Exception e){}}
    
    try {
        String sql1="SELECT count(code_ordt) FROM order_detail WHERE code_or_ordt ='"+tmp+"' ";
           pst =conn.prepareStatement(sql1);
           rs =pst.executeQuery();
           
           if (rs.next()){
               String count = rs.getString("count(code_ordt)");
               lable_no_product.setText("No. :"+count);
           }
        }catch (Exception e){JOptionPane.showMessageDialog(null, e); }
            finally { try { rs.close(); pst.close();}catch (Exception e){  } }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table_order_detail = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txt_code_cust = new javax.swing.JTextField();
        txt_date_or = new com.toedter.calendar.JDateChooser();
        txt_note_or = new javax.swing.JTextField();
        txt_add_cust = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cmd_look_ex = new javax.swing.JButton();
        combo_name_cust = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        txt_phone_cust = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmd_delete_dt = new javax.swing.JButton();
        lable_total = new javax.swing.JLabel();
        cmd_check = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        cmd_pdate_dt = new javax.swing.JButton();
        cmd_save_dt = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txt_monetize_ordt = new javax.swing.JTextField();
        txt_unit_ordt = new javax.swing.JTextField();
        txt_specification_ordt = new javax.swing.JTextField();
        txt_no_ordt = new javax.swing.JTextField();
        combo_name_prod = new javax.swing.JComboBox();
        txt_code_ordt = new javax.swing.JTextField();
        txt_eweight_ordt = new javax.swing.JTextField();
        txt_price_ordt = new javax.swing.JTextField();
        lable_no_product = new javax.swing.JLabel();
        cmd_refresh_dt = new javax.swing.JButton();
        cmd_add_dt = new javax.swing.JButton();
        combo_name_empl = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txt_code_empl_or = new javax.swing.JTextField();
        txt_date_delivery_or = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        txt_code_prod_ordt = new javax.swing.JLabel();
        cmd_addnew = new javax.swing.JButton();
        cmd_save = new javax.swing.JButton();
        cmd_update = new javax.swing.JButton();
        cmd_delete = new javax.swing.JButton();
        cmd_close = new javax.swing.JButton();
        cmd_print = new javax.swing.JButton();
        cmd_status = new javax.swing.JButton();
        lable_intext = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Đơn đặt hàng");

        table_order_detail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table_order_detail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_order_detailMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_order_detail);

        jLabel3.setText("Địa chỉ :");

        txt_date_or.setDateFormatString("yyyy-MM-dd");

        txt_note_or.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_note_orActionPerformed(evt);
            }
        });

        jLabel4.setText("Phone:");

        cmd_look_ex.setIcon(new javax.swing.ImageIcon(getClass().getResource("/database/look-icon_2-512.png"))); // NOI18N
        cmd_look_ex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_look_exActionPerformed(evt);
            }
        });

        combo_name_cust.setEditable(true);
        combo_name_cust.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                combo_name_custPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jLabel2.setText("Tên khách hàng :");

        jLabel1.setText("Mã đặt hàng  :");

        jLabel11.setText("ID : ");
        jLabel11.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jLabel6.setText("Ghi chú :");

        jLabel5.setText("Ngày đặt :");

        cmd_delete_dt.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cmd_delete_dt.setText("Xóa sp");
        cmd_delete_dt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_delete_dtActionPerformed(evt);
            }
        });

        lable_total.setText("+(total)");

        cmd_check.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cmd_check.setText("Thanh toán");
        cmd_check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_checkActionPerformed(evt);
            }
        });

        jLabel17.setText("Tổng ước tính cần thanh toán :");

        cmd_pdate_dt.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cmd_pdate_dt.setText("Cập nhật");
        cmd_pdate_dt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_pdate_dtActionPerformed(evt);
            }
        });

        cmd_save_dt.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cmd_save_dt.setText("Lưu");
        cmd_save_dt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_save_dtActionPerformed(evt);
            }
        });

        jPanel2.setPreferredSize(new java.awt.Dimension(707, 35));

        txt_monetize_ordt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_monetize_ordtFocusGained(evt);
            }
        });

        txt_unit_ordt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_unit_ordtFocusGained(evt);
            }
        });

        txt_specification_ordt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_specification_ordtFocusGained(evt);
            }
        });

        txt_no_ordt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_no_ordtFocusGained(evt);
            }
        });

        combo_name_prod.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                combo_name_prodPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        txt_code_ordt.setToolTipText("Mã xuất SP");

        txt_eweight_ordt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_eweight_ordtFocusGained(evt);
            }
        });

        txt_price_ordt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_price_ordtFocusGained(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(txt_code_ordt, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(combo_name_prod, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_specification_ordt, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_no_ordt, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_eweight_ordt, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_unit_ordt, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_price_ordt, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_monetize_ordt, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_code_ordt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_name_prod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_specification_ordt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_no_ordt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_eweight_ordt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_unit_ordt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_price_ordt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_monetize_ordt))
                .addGap(3, 3, 3))
        );

        lable_no_product.setText("+(no. )");

        cmd_refresh_dt.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cmd_refresh_dt.setText("Refresh");
        cmd_refresh_dt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_refresh_dtActionPerformed(evt);
            }
        });

        cmd_add_dt.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cmd_add_dt.setText("Thêm mới");
        cmd_add_dt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_add_dtActionPerformed(evt);
            }
        });

        combo_name_empl.setEditable(true);
        combo_name_empl.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        combo_name_empl.setSelectedIndex(-1);
        combo_name_empl.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                combo_name_emplPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jLabel14.setText("Nhân viên xuất :");

        jLabel15.setText("Mã NV : ");

        txt_date_delivery_or.setDateFormatString("yyyy-MM-dd");

        jLabel7.setText("Ngày hẹn giao :");

        txt_code_prod_ordt.setText("+code");

        cmd_addnew.setText("Tạo mới");
        cmd_addnew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_addnewActionPerformed(evt);
            }
        });

        cmd_save.setText("Lưu");
        cmd_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_saveActionPerformed(evt);
            }
        });

        cmd_update.setText("Cập nhật");
        cmd_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_updateActionPerformed(evt);
            }
        });

        cmd_delete.setText("Xóa");
        cmd_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_deleteActionPerformed(evt);
            }
        });

        cmd_close.setText("Đóng");
        cmd_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_closeActionPerformed(evt);
            }
        });

        cmd_print.setText("Print");
        cmd_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_printActionPerformed(evt);
            }
        });

        cmd_status.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        cmd_status.setText("Status");
        cmd_status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_statusActionPerformed(evt);
            }
        });

        lable_intext.setText("(bằng chữ)");

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Tools");
        jMenuBar1.add(jMenu3);

        jMenu4.setText("Advance");
        jMenuBar1.add(jMenu4);

        jMenu5.setText("Help");
        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmd_add_dt, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmd_save_dt, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmd_pdate_dt, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmd_delete_dt)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmd_refresh_dt, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmd_check)
                                .addGap(53, 53, 53)
                                .addComponent(lable_no_product, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 658, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(combo_name_cust, 0, 189, Short.MAX_VALUE)
                                            .addComponent(txt_code_or))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cmd_look_ex, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_add_cust, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_date_or, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txt_date_delivery_or, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_code_cust, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                                    .addComponent(cmd_status, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_phone_cust)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lable_intext, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lable_total, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(combo_name_empl, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel15)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(320, 320, 320)
                                .addComponent(txt_code_empl_or, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_note_or)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(cmd_addnew, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmd_save, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmd_update, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmd_print, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmd_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmd_close, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_code_prod_ordt, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_code_or, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmd_look_ex, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cmd_status))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel1)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(combo_name_cust, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_code_cust, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel11))))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_add_cust, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_phone_cust, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel3)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_date_or, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_date_delivery_or, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel5))))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)))
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmd_add_dt)
                        .addComponent(cmd_save_dt)
                        .addComponent(cmd_pdate_dt)
                        .addComponent(cmd_delete_dt)
                        .addComponent(cmd_refresh_dt)
                        .addComponent(cmd_check))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lable_no_product)))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(lable_total))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lable_intext)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(combo_name_empl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(txt_code_empl_or, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txt_note_or, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmd_addnew)
                    .addComponent(cmd_save)
                    .addComponent(cmd_update)
                    .addComponent(cmd_delete)
                    .addComponent(cmd_close)
                    .addComponent(cmd_print)
                    .addComponent(txt_code_prod_ordt))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_note_orActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_note_orActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_note_orActionPerformed

    private void cmd_look_exActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_look_exActionPerformed
        String tmp = txt_code_or.getText().toUpperCase();
        try{

            String sql = "SELECT * FROM order_tb INNER JOIN customer ON code_cust_or = code_cust "
            + "INNER JOIN employee ON code_empl_or = code_empl WHERE code_or ='"+tmp+"' ";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();

            if(rs.next()){
                String date_or = rs.getString("date_or");
                java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(date_or);
                txt_date_or.setDate(date);
                String date_delivery_or = rs.getString("date_delivery_or");
                java.util.Date date_delivery = new SimpleDateFormat("yyyy-MM-dd").parse(date_delivery_or);
                txt_date_delivery_or.setDate(date_delivery);
                
                txt_note_or.setText((String)rs.getString("note_or"));

                txt_code_cust.setText((String)rs.getString("code_cust"));
                String company_cust =rs.getString("company_cust");
                String add_cust =rs.getString("add_cust");
                String district_cust =rs.getString("district_cust");
                String province_cust =rs.getString("province_cust");
                txt_add_cust.setText(company_cust+"-"+add_cust+", "+district_cust+", "+province_cust);
                txt_phone_cust.setText(rs.getString("phone_cust"));
                combo_name_cust.setSelectedItem(rs.getString("name_cust"));

                combo_name_empl.setSelectedItem(rs.getString("name_empl"));
                txt_code_empl_or.setText(rs.getString("code_empl"));
                cmd_status.setText(rs.getString("status_or"));
            }
        }
        catch (SQLException | ParseException e){JOptionPane.showMessageDialog(null, e);}
        finally {try {rs.close(); pst.close();}catch (Exception e){}}
        Update_tbl_order_detail();
    }//GEN-LAST:event_cmd_look_exActionPerformed

    private void combo_name_custPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_combo_name_custPopupMenuWillBecomeInvisible
        String temp= (String)combo_name_cust.getSelectedItem();
        //kiem tra neu locality chua ton tai thi hoi xem co them locality khong
        if(temp.isEmpty()){return;}
        String check = "SELECT count(name_cust) FROM customer WHERE name_cust = '"+temp+"'";
        try{
            pst=conn.prepareStatement(check);
            rs=pst.executeQuery();
            if (rs.next()){
                final int count = rs.getInt(1);
                if (count < 1){
                    int p =JOptionPane.showConfirmDialog(null, "Tên khách hàng không tồn tại ! \nBạn có muốn tạo mới tên khách hàng này?", "Noop inform", JOptionPane.YES_NO_OPTION);
                    if (p==0){
                        new add_customer_frame().setVisible(true);
                    }
                }
            }
        }catch (Exception e){JOptionPane.showMessageDialog(null, e);
        }finally {try {rs.close();pst.close();}catch (Exception e){}}

        //gan species id toi txt
        try{
            String sql="SELECT * FROM customer WHERE customer.name_cust ='"+temp+"' ";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();

            if(rs.next()){
                String code_cust =rs.getString("code_cust");
                txt_code_cust.setText(code_cust);
                String company_cust =rs.getString("company_cust");
                String add_cust =rs.getString("add_cust");
                String district_cust =rs.getString("district_cust");
                String province_cust =rs.getString("province_cust");
                txt_add_cust.setText(company_cust+"-"+add_cust+", "+district_cust+", "+province_cust);
                String phone_cust =rs.getString("phone_cust");
                txt_phone_cust.setText(phone_cust);
            }
        }catch(Exception e){ JOptionPane.showMessageDialog(null, e);}
        finally { try { rs.close(); pst.close();}catch (Exception e){  } }

        txt_date_or.requestFocusInWindow();
    }//GEN-LAST:event_combo_name_custPopupMenuWillBecomeInvisible

    private void cmd_delete_dtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_delete_dtActionPerformed
        int p =JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa dữ liệu SP này không?", "Delete SP", JOptionPane.YES_NO_OPTION);
        if (p==0){
            try{
                String sql="DELETE FROM order_detail where code_ordt = ?";
                int row=table_order_detail.getSelectedRow();
                String code_exdt =(table_order_detail.getModel().getValueAt(row, 0).toString());
                pst=conn.prepareStatement(sql);
                pst.setString(1, code_exdt);
                pst.execute();
            }catch(Exception e){JOptionPane.showMessageDialog(null, e);}
            finally {try {rs.close();pst.close();}catch (Exception e){}}
        }

        Update_tbl_order_detail();
    }//GEN-LAST:event_cmd_delete_dtActionPerformed

    private void cmd_checkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_checkActionPerformed
        try {
             String tmp = txt_code_or.getText().toUpperCase();
             String sql1="SELECT sum(monetize_ordt) FROM order_detail WHERE code_or_ordt ='"+tmp+"' ";
             pst =conn.prepareStatement(sql1);
             rs =pst.executeQuery();

             if (rs.next()){
                 String sum = rs.getString("sum(monetize_ordt)");
                 lable_total.setText(sum);
                 
                 long number = Long.parseLong(sum);
                 String text = (convertnumbertostring.convert(number));
                 String out = Character.toString(text.charAt(0)).toUpperCase()+text.substring(1);
                 lable_intext.setText(out);
             }
        }catch (SQLException | NumberFormatException e){JOptionPane.showMessageDialog(null, e); }
        finally { try { rs.close(); pst.close();}catch (Exception e){  } }
    }//GEN-LAST:event_cmd_checkActionPerformed

    private void cmd_pdate_dtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_pdate_dtActionPerformed
        try{
            String code_ordt = txt_code_ordt.getText();
            String code_prod_ordt = txt_code_prod_ordt.getText();
            String specification_ordt = txt_specification_ordt.getText();
            String no_ordt = txt_no_ordt.getText();
            String eweight_ordt = txt_eweight_ordt.getText();
            String unit_ordt = txt_unit_ordt.getText();
            String monetize_ordt = txt_monetize_ordt.getText();
            String price_ordt = txt_price_ordt.getText();
            String user_ordt = dashboard.lable_user.getText();

            String sql ="UPDATE order_detail SET code_prod_ordt = '"+code_prod_ordt+"', specification_ordt = '"+specification_ordt+"', "
            + "no_ordt = '"+no_ordt+"', eweight_ordt = '"+eweight_ordt+"', unit_ordt = '"+unit_ordt+"', "
            + "monetize_ordt = '"+monetize_ordt+"', price_ordt = '"+price_ordt+"', user_ordt = '"+user_ordt+"' WHERE code_ordt ='"+code_ordt+"'  ";
            pst=conn.prepareStatement(sql);
            pst.execute();

            JOptionPane.showMessageDialog(null, "Một thông SP vừa được cập nhật !");

        }catch(Exception e){JOptionPane.showMessageDialog(null, e);}
        finally {try {rs.close();pst.close();}catch (Exception e){}}

        Update_tbl_order_detail();
    }//GEN-LAST:event_cmd_pdate_dtActionPerformed

    private void cmd_save_dtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_save_dtActionPerformed
        try{
            String sql ="INSERT INTO order_detail (code_ordt, code_or_ordt, code_prod_ordt, specification_ordt, no_ordt, "
            + "eweight_ordt, unit_ordt, price_ordt, monetize_ordt, user_ordt) values (?,?,?,?,?,?,?,?,?,?)";

            pst =conn.prepareStatement(sql);
            pst.setString(1, txt_code_ordt.getText());
            pst.setString(2, txt_code_or.getText());
            pst.setString(3, txt_code_prod_ordt.getText());
            pst.setString(4, txt_specification_ordt.getText());
            pst.setString(5, txt_no_ordt.getText());
            pst.setString(6, txt_eweight_ordt.getText());
            pst.setString(7, txt_unit_ordt.getText());
            pst.setString(8, txt_price_ordt.getText());
            pst.setString(9, txt_monetize_ordt.getText());
            pst.setString(10, dashboard.lable_user.getText());
            pst.execute();

            JOptionPane.showMessageDialog(null, "Một Sản phẩm mới vừa được thêm vào!");

        }catch(Exception e){JOptionPane.showMessageDialog(null, e);}
        finally {try {rs.close();pst.close();}catch (Exception e){}}

        Update_tbl_order_detail();
        addnew_dt();
    }//GEN-LAST:event_cmd_save_dtActionPerformed

    private void addnew_dt(){
    String sql = "SELECT * FROM order_detail ORDER BY code_ordt DESC LIMIT 1";
        try {
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            String mch = function.MCH();
            if(rs.next()){
                String code_part =rs.getString("code_ordt").substring(6);
                int code = Integer.parseInt(code_part);
                String code_up = Integer.toString(code+1);
                int n = 12 - 6 - code_up.length();
                String zero = new String(new char[n]).replace("\0", "0");
                String code_2 = "ORDT"+mch +zero + code_up;
                txt_code_ordt.setText(code_2);
            }else{
                txt_code_ordt.setText("ORDT"+mch+"000001");
            }
        } catch (Exception e){ JOptionPane.showMessageDialog(null, e);}
        finally { try { rs.close(); pst.close();}catch (Exception e){  } }

        Fildcombo_name_prod();

        txt_code_prod_ordt.setText("");
        txt_specification_ordt.setText("");
        txt_no_ordt.setText("1");
        txt_eweight_ordt.setText("0");
        txt_unit_ordt.setText("kg");
        txt_price_ordt.setText("0");
        txt_monetize_ordt.setText("0");
        combo_name_prod.setSelectedItem("");
        combo_name_prod.requestFocusInWindow();
    }
    
    public void check_close(){
        String temp= (String)txt_code_or.getText();
        if(temp.isEmpty()){dispose();return;}
        try{
            String check = "SELECT count(code_or) FROM order_tb WHERE code_or = '"+temp+"'";
            
            pst=conn.prepareStatement(check);
            rs=pst.executeQuery();

            if (rs.next()){
                final int count = rs.getInt(1);
                if (count < 1){
                    check_exdt();
                }
            }
        }catch (Exception e){JOptionPane.showMessageDialog(null, e);}
        finally {try {rs.close();pst.close();}catch (Exception e){}}
        //try {rs.close();pst.close();}catch (Exception e){};
    }
    
    public void check_exdt(){
        String temp= (String)txt_code_or.getText();
        String check_exdt = "SELECT count(code_or_ordt) FROM order_detail WHERE code_or_ordt = '"+temp+"'";
        try{
            pst2=conn.prepareStatement(check_exdt);
            rs2=pst2.executeQuery();
            if(rs2.next()){
                final int count2 = rs2.getInt(1);
                if (count2 > 0){
                    int p =JOptionPane.showConfirmDialog(null, "Đơn Đặt Hàng chưa được lưu ! \nBạn cần xóa hết SP trong bảng trên?", "Noop inform", JOptionPane.YES_NO_OPTION);
                    if (p==0){
                        try{
                            String sql="DELETE FROM order_detail where code_or_ordt = ?";
                            pst=conn.prepareStatement(sql);
                            pst.setString(1, txt_code_or.getText());
                            pst.execute();
                        }catch(Exception e){JOptionPane.showMessageDialog(null, e);}
                        finally {try {pst.close();}catch (Exception e){}}
                    }
                }
            }
        }catch(Exception e){JOptionPane.showMessageDialog(null, e);}
        finally {try {rs2.close();pst2.close();}catch (Exception e){}}
    }
    
    private void txt_monetize_ordtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_monetize_ordtFocusGained
        double price_exdt = Double.parseDouble(txt_price_ordt.getText());
        double eweight_exdt = Double.parseDouble(txt_eweight_ordt.getText());
        double monetize = (double)price_exdt * (double)eweight_exdt;
        long j=Math.round(monetize);
        String z = Long.toString(j);
        txt_monetize_ordt.setText(z);
    }//GEN-LAST:event_txt_monetize_ordtFocusGained

    private void txt_unit_ordtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_unit_ordtFocusGained
        txt_unit_ordt.selectAll();
    }//GEN-LAST:event_txt_unit_ordtFocusGained

    private void txt_specification_ordtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_specification_ordtFocusGained
        txt_specification_ordt.selectAll();
    }//GEN-LAST:event_txt_specification_ordtFocusGained

    private void txt_no_ordtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_no_ordtFocusGained
        txt_no_ordt.selectAll();
    }//GEN-LAST:event_txt_no_ordtFocusGained

    private void combo_name_prodPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_combo_name_prodPopupMenuWillBecomeInvisible
        String temp= (String)combo_name_prod.getSelectedItem();

        if(temp.isEmpty()){return;}
        String check = "SELECT count(name_prod) FROM product_information WHERE name_prod = '"+temp+"'";
        try{
            pst=conn.prepareStatement(check);
            rs=pst.executeQuery();
            if (rs.next()){
                final int count = rs.getInt(1);
                if (count < 1){
                    int p =JOptionPane.showConfirmDialog(null, "Tên Sản phẩm không tồn tại ! Bạn có muốn tạo mới tên SP này?", "Noop inform", JOptionPane.YES_NO_OPTION);
                    if (p==0){
                        new product_frame().setVisible(true);
                    }else{combo_name_prod.setSelectedItem(null);}
                }
            }
        }catch (Exception e){JOptionPane.showMessageDialog(null, e);
        }finally {try {rs.close();pst.close();}catch (Exception e){}}

        //gan species id toi txt
        try{
            String sql="SELECT * FROM product_information WHERE name_prod ='"+temp+"' ";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();

            if(rs.next()){
                String code_prod =rs.getString("code_prod");
                txt_code_prod_ordt.setText(code_prod);
            }
        }catch(Exception e){ JOptionPane.showMessageDialog(null, e);}
        finally { try { rs.close(); pst.close();}catch (Exception e){  } }

        txt_specification_ordt.requestFocusInWindow();
    }//GEN-LAST:event_combo_name_prodPopupMenuWillBecomeInvisible

    private void txt_eweight_ordtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_eweight_ordtFocusGained
        txt_eweight_ordt.selectAll();
        String specification_ordt = txt_specification_ordt.getText();
        double no = Double.parseDouble(txt_no_ordt.getText());
        double tron = 0.00000625;
        double tam = 0.00000785;
        DecimalFormat df = new DecimalFormat("#.###");
        df.setRoundingMode(RoundingMode.CEILING);
        if (specification_ordt.contains("*")) {
            String[] parts = specification_ordt.split("\\*");
            int k = parts.length;
            if(k==3){
                double a = Double.parseDouble(parts[0]);
                double b = Double.parseDouble(parts[1]);
                double c = Double.parseDouble(parts[2]);
                double eweight = a*b*c*no*tam;
                txt_eweight_ordt.setText(df.format(eweight));
            }else{
                if(k==2){
                    double a = Double.parseDouble(parts[0]);
                    double b = Double.parseDouble(parts[1]);
                    double eweight = a*a*b*no*tron;
                    txt_eweight_ordt.setText(df.format(eweight));
                }
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập hàng theo quy cách \na*b*c!");
            txt_price_ordt.requestFocusInWindow();
        }
    }//GEN-LAST:event_txt_eweight_ordtFocusGained

    private void txt_price_ordtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_price_ordtFocusGained
        txt_price_ordt.selectAll();
    }//GEN-LAST:event_txt_price_ordtFocusGained

    private void cmd_refresh_dtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_refresh_dtActionPerformed
        Update_tbl_order_detail();
    }//GEN-LAST:event_cmd_refresh_dtActionPerformed

    private void cmd_add_dtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_add_dtActionPerformed
        addnew_dt();
    }//GEN-LAST:event_cmd_add_dtActionPerformed

    private void combo_name_emplPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_combo_name_emplPopupMenuWillBecomeInvisible
        String temp= (String)combo_name_empl.getSelectedItem();
        //kiem tra neu locality chua ton tai thi hoi xem co them locality khong
        if(temp.isEmpty()){return;}
        String check = "SELECT count(name_empl) FROM employee WHERE name_empl = '"+temp+"'";
        try{
            pst=conn.prepareStatement(check);
            rs=pst.executeQuery();
            if (rs.next()){
                final int count = rs.getInt(1);
                if (count < 1){
                    int p =JOptionPane.showConfirmDialog(null, "Tên Nhân Viên không tồn tại ! \nBạn có muốn tạo mới tên khách hàng này?", "Noop inform", JOptionPane.YES_NO_OPTION);
                    if (p==0){
                        new employee_frame().setVisible(true);
                    }
                }
            }
        }catch (Exception e){JOptionPane.showMessageDialog(null, e);
        }finally {try {rs.close();pst.close();}catch (Exception e){}}

        //gan species id toi txt
        try{
            String sql="SELECT * FROM employee WHERE employee.name_empl ='"+temp+"' ";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();

            if(rs.next()){
                String code_empl =rs.getString("code_empl");
                txt_code_empl_or.setText(code_empl);
            }
        }catch(Exception e){ JOptionPane.showMessageDialog(null, e);}
        finally { try { rs.close(); pst.close();}catch (Exception e){  } }

        txt_code_empl_or.requestFocusInWindow();
    }//GEN-LAST:event_combo_name_emplPopupMenuWillBecomeInvisible

    private void cmd_addnewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_addnewActionPerformed
        String sql = "SELECT * FROM order_tb ORDER BY code_or DESC LIMIT 1";
        try {
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            String mch = function.MCH();
            int year = Calendar.getInstance().get(Calendar.YEAR); String year2 = Integer.toString(year);
            if(rs.next()){
                String code_part =rs.getString("code_or").substring(6);
                int code = Integer.parseInt(code_part);
                String code_up = Integer.toString(code+1);
                int n = 11 - 6 - code_up.length();
                String zero = new String(new char[n]).replace("\0", "0");
                String code_2 = "OR"+ year2.substring(2)+mch+zero + code_up;
                txt_code_or.setText(code_2);
            }else{
                String tem = "OR"+ year2.substring(2)+mch+"00001";
                txt_code_or.setText(tem);
            }
        } catch (Exception e){ JOptionPane.showMessageDialog(null, e);}
        finally { try { rs.close(); pst.close();}catch (Exception e){  } }

        Fildcombo_name_cust();
        Fildcombo_name_empl();
        Fildcombo_name_prod();
        Update_tbl_order_detail();

        txt_add_cust.setText("");
        txt_code_cust.setText("");
        txt_date_or.setDate(null);
        txt_date_delivery_or.setDate(null);
        txt_phone_cust.setText("");
        txt_note_or.setText("0");
        cmd_status.setText("Đang cắt");
        combo_name_cust.setSelectedItem("");
        combo_name_empl.setSelectedItem("");
        combo_name_cust.requestFocusInWindow();
    }//GEN-LAST:event_cmd_addnewActionPerformed

    private void cmd_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_saveActionPerformed
        try{
            String sql ="INSERT INTO order_tb (code_or, code_cust_or, date_or, date_delivery_or, "
            + "status_or, code_empl_or, note_or, user_or) values (?,?,?,?,?,?,?,?)";

            pst =conn.prepareStatement(sql);
            pst.setString(1, txt_code_or.getText());
            pst.setString(2, txt_code_cust.getText());
            pst.setString(3, ((JTextField)txt_date_or.getDateEditor().getUiComponent()).getText());
            pst.setString(4, ((JTextField)txt_date_delivery_or.getDateEditor().getUiComponent()).getText());
            pst.setString(5, cmd_status.getText());
            pst.setString(6, txt_code_empl_or.getText());
            pst.setString(7, txt_note_or.getText());
            pst.setString(8, dashboard.lable_user.getText());
            pst.execute();

            JOptionPane.showMessageDialog(null, "Một Đơn Đặt hàng mới vừa được thêm vào!");

        }catch(Exception e){JOptionPane.showMessageDialog(null, e);}
        finally {try {rs.close();pst.close();}catch (Exception e){}}
    }//GEN-LAST:event_cmd_saveActionPerformed

    private void cmd_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_updateActionPerformed
        try{
            String code_or = txt_code_or.getText();
            String code_cust_or = txt_code_cust.getText();
            String date_or = ((JTextField)txt_date_or.getDateEditor().getUiComponent()).getText();
            String date_delivery_or = ((JTextField)txt_date_delivery_or.getDateEditor().getUiComponent()).getText();
            String status_or = cmd_status.getText();
            String code_empl_or = txt_code_empl_or.getText();
            String note_or = txt_note_or.getText();
            String user_or = dashboard.lable_user.getText();

            String sql ="UPDATE order_tb SET code_cust_or = '"+code_cust_or+"', date_or = '"+date_or+"',  "
                    + "date_delivery_or = '"+date_delivery_or+"',  status_or = '"+status_or+"', "
                    + "code_empl_or = '"+code_empl_or+"', note_or = '"+note_or+"', user_or = '"+user_or+"' "
                    + "WHERE code_or ='"+code_or+"'  ";
            pst=conn.prepareStatement(sql);
            pst.execute();

            JOptionPane.showMessageDialog(null, "Một Đơn Đặt hàng vừa được cập nhật !");

        }catch(Exception e){JOptionPane.showMessageDialog(null, e);}
        finally {try {rs.close();pst.close();}catch (Exception e){}}
    }//GEN-LAST:event_cmd_updateActionPerformed

    private void cmd_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_deleteActionPerformed
        int p =JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa dữ liệu Đơn Hàng này không? \nDữ liệu sản phẩm trong đơn hàng sẻ được xóa theo", "Xóa Đơn hàng", JOptionPane.YES_NO_OPTION);
        if (p==0){
            try{
                String sql="DELETE FROM order_detail where code_or_ordt = ?";
                pst=conn.prepareStatement(sql);
                pst.setString(1, txt_code_or.getText());
                pst.execute();
            }catch(Exception e){JOptionPane.showMessageDialog(null, e);}
            finally {try {rs.close();pst.close();}catch (Exception e){}}

            try{
                String sql="DELETE FROM order_tb where code_or = ?";
                pst=conn.prepareStatement(sql);
                pst.setString(1, txt_code_or.getText());
                pst.execute();
            }catch(Exception e){JOptionPane.showMessageDialog(null, e);}
            finally {try {rs.close();pst.close();}catch (Exception e){}}
        }
    }//GEN-LAST:event_cmd_deleteActionPerformed

    private void cmd_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_closeActionPerformed
        check_close();
        try {rs.close();pst.close();dispose();}catch (Exception e){}
    }//GEN-LAST:event_cmd_closeActionPerformed

    
    
    private void cmd_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_printActionPerformed
        String code_or = txt_code_or.getText();
        try {
            JasperDesign jd=JRXmlLoader.load(getClass().getResourceAsStream("order_print.jrxml"));
            String sql = "SELECT * FROM order_tb "
                    + "LEFT JOIN order_detail ON code_or = code_or_ordt "
                    + "LEFT JOIN product_information ON code_prod_ordt = code_prod "
                    + "WHERE code_or = '" + code_or+"'";
            JRDesignQuery newQuery= new JRDesignQuery();
            newQuery.setText(sql);
            jd.setQuery(newQuery);

            JasperReport jr=JasperCompileManager.compileReport(jd);
            JasperPrint jp=JasperFillManager.fillReport(jr, null, conn);
            JasperViewer jv = new JasperViewer(jp,false);
            jv.setVisible(true);
            //JasperPrintManager.printReport(jp,true);

        } catch (JRException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }finally {try {rs.close();pst.close();}catch (Exception e){}}
    }//GEN-LAST:event_cmd_printActionPerformed

    private void cmd_statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_statusActionPerformed
        String current = cmd_status.getText();
        String code_or = txt_code_or.getText();
        if(current.equals(status_number[0])){
            cmd_status.setText(status_number[1]);
            savestatus(1, code_or);
        }else{
            if(current.equals(status_number[1])){
                cmd_status.setText(status_number[2]);
                savestatus(2, code_or);
            }else{
                if(current.equals(status_number[2])){
                    cmd_status.setText(status_number[3]);
                    savestatus(3, code_or);
                }else{
                    cmd_status.setText(status_number[0]);
                    savestatus(0, code_or);
                }
            }
        }
    }//GEN-LAST:event_cmd_statusActionPerformed

    private void table_order_detailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_order_detailMouseClicked
        try{
            int row=table_order_detail.getSelectedRow();
            String Table_click=(table_order_detail.getModel().getValueAt(row, 0).toString());

            String sql="SELECT *  FROM order_detail "
            + "LEFT JOIN product_information ON code_prod_ordt = code_prod "
            + "WHERE order_detail.code_ordt ='"+Table_click+"'";

            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();

            if(rs.next()){
                String code_ordt =rs.getString("code_ordt"); txt_code_ordt.setText(code_ordt);
                String code_prod_ordt =rs.getString("code_prod_ordt"); txt_code_prod_ordt.setText(code_prod_ordt);
                String specification_ordt =rs.getString("specification_ordt"); txt_specification_ordt.setText(specification_ordt);
                String name_prod =rs.getString("name_prod"); combo_name_prod.setSelectedItem(name_prod);
                String no_ordt =rs.getString("no_ordt"); txt_no_ordt.setText(no_ordt);
                String eweight_ordt =rs.getString("eweight_ordt"); txt_eweight_ordt.setText(eweight_ordt);
                String unit_ordt =rs.getString("unit_ordt"); txt_unit_ordt.setText(unit_ordt);
                String price_ordt =rs.getString("price_ordt"); txt_price_ordt.setText(price_ordt);
                String monetize_ordt =rs.getString("monetize_ordt"); txt_monetize_ordt.setText(monetize_ordt);
            }
        }catch(Exception e){ JOptionPane.showMessageDialog(null, e);}
        finally { try { rs.close(); pst.close();}catch (Exception e){  } }
    }//GEN-LAST:event_table_order_detailMouseClicked

    private static final String[] status_number = {
        "Đợi báo giá",
        "Đang cắt",
        "Cắt xong",
        "Đã giao"
    };
    
    private void savestatus(int status, String id){
        try{
            String status_or = status_number[status];
            String sql ="UPDATE order_tb SET status_or = '"+status_or+"' WHERE code_or ='"+id+"'  ";
            pst=conn.prepareStatement(sql);
            pst.execute();
        }catch(Exception e){JOptionPane.showMessageDialog(null, e);}
        finally {try {rs.close();pst.close();}catch (Exception e){}}
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(order_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(order_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(order_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(order_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new order_form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmd_add_dt;
    private javax.swing.JButton cmd_addnew;
    private javax.swing.JButton cmd_check;
    private javax.swing.JButton cmd_close;
    private javax.swing.JButton cmd_delete;
    private javax.swing.JButton cmd_delete_dt;
    private javax.swing.JButton cmd_look_ex;
    private javax.swing.JButton cmd_pdate_dt;
    private javax.swing.JButton cmd_print;
    private javax.swing.JButton cmd_refresh_dt;
    private javax.swing.JButton cmd_save;
    private javax.swing.JButton cmd_save_dt;
    private javax.swing.JButton cmd_status;
    private javax.swing.JButton cmd_update;
    private javax.swing.JComboBox combo_name_cust;
    private javax.swing.JComboBox combo_name_empl;
    private javax.swing.JComboBox combo_name_prod;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lable_intext;
    private javax.swing.JLabel lable_no_product;
    private javax.swing.JLabel lable_total;
    private javax.swing.JTable table_order_detail;
    private javax.swing.JTextField txt_add_cust;
    private javax.swing.JTextField txt_code_cust;
    private javax.swing.JTextField txt_code_empl_or;
    public static final javax.swing.JTextField txt_code_or = new javax.swing.JTextField();
    private javax.swing.JTextField txt_code_ordt;
    private javax.swing.JLabel txt_code_prod_ordt;
    private com.toedter.calendar.JDateChooser txt_date_delivery_or;
    private com.toedter.calendar.JDateChooser txt_date_or;
    private javax.swing.JTextField txt_eweight_ordt;
    private javax.swing.JTextField txt_monetize_ordt;
    private javax.swing.JTextField txt_no_ordt;
    private javax.swing.JTextField txt_note_or;
    private javax.swing.JTextField txt_phone_cust;
    private javax.swing.JTextField txt_price_ordt;
    private javax.swing.JTextField txt_specification_ordt;
    private javax.swing.JTextField txt_unit_ordt;
    // End of variables declaration//GEN-END:variables
}
