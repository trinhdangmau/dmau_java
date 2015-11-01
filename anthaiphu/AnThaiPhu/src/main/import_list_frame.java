/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import static main.function.lc2;
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

/**
 *
 * @author trinhdangmau
 */
public class import_list_frame extends javax.swing.JFrame {
    Connection conn=null;
    ResultSet rs =null;
    PreparedStatement pst =null;
    /**
     * Creates new form export_list_frame
     */
    public import_list_frame() {
        initComponents();
        conn=javaconnect.ConnecrDb();
        update_table();
        setIcon();
    }
    
    private void setIcon() {
        String purl = lc2();
        String Url = purl+"/database/logo90.png";
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(Url));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmd_close = new javax.swing.JButton();
        txt_search = new javax.swing.JTextField();
        cmd_search = new javax.swing.JButton();
        combo_item = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_import_list = new javax.swing.JTable();
        cmd_addnew = new javax.swing.JButton();
        cmd_open_change = new javax.swing.JButton();
        cmd_delete = new javax.swing.JButton();
        cmd_print_preview = new javax.swing.JButton();
        cmd_print = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menu_close = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Danh sách hóa đơn");

        cmd_close.setText("Đóng");
        cmd_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_closeActionPerformed(evt);
            }
        });

        txt_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_searchKeyReleased(evt);
            }
        });

        cmd_search.setText("Search !");
        cmd_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_searchActionPerformed(evt);
            }
        });

        combo_item.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Show_all", "Code_export", "Name_customer", "Time_export", "Province" }));

        tbl_import_list.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbl_import_list);

        cmd_addnew.setText("Thêm mới");
        cmd_addnew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_addnewActionPerformed(evt);
            }
        });

        cmd_open_change.setText("Mở/thay đổi");
        cmd_open_change.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_open_changeActionPerformed(evt);
            }
        });

        cmd_delete.setText("Xóa");
        cmd_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_deleteActionPerformed(evt);
            }
        });

        cmd_print_preview.setText("Print Preview");
        cmd_print_preview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_print_previewActionPerformed(evt);
            }
        });

        cmd_print.setText("Print");
        cmd_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_printActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        menu_close.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
        menu_close.setText("Close");
        menu_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_closeActionPerformed(evt);
            }
        });
        jMenu1.add(menu_close);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Tools");
        jMenuBar1.add(jMenu3);

        jMenu4.setText("Help");
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 714, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(cmd_addnew)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmd_open_change)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmd_print_preview, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmd_print, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmd_delete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmd_close))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(combo_item, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmd_search, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cmd_addnew, cmd_close, cmd_delete, cmd_open_change});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmd_search)
                    .addComponent(combo_item, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmd_addnew)
                    .addComponent(cmd_open_change)
                    .addComponent(cmd_delete)
                    .addComponent(cmd_close)
                    .addComponent(cmd_print_preview)
                    .addComponent(cmd_print))
                .addGap(7, 7, 7))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmd_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_closeActionPerformed
        try {rs.close();pst.close();dispose();}catch (Exception e){}
    }//GEN-LAST:event_cmd_closeActionPerformed

    private void cmd_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_searchActionPerformed
       update_table();
    }//GEN-LAST:event_cmd_searchActionPerformed

    private void cmd_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_deleteActionPerformed
        int p =JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa dữ liệu Đơn Hàng này không? \nDữ liệu sản phẩm trong đơn hàng sẻ được xóa theo", "Xóa Đơn hàng", JOptionPane.YES_NO_OPTION);
        if (p==0){
            int row=tbl_import_list.getSelectedRow();
            String Table_click=(tbl_import_list.getModel().getValueAt(row, 0).toString());
            try{
                String sql="DELETE FROM import_detail where code_im_imdt = ?";
                pst=conn.prepareStatement(sql);
                pst.setString(1, Table_click);
                pst.execute();
            }catch(Exception e){JOptionPane.showMessageDialog(null, e);}
            finally {try {rs.close();pst.close();}catch (Exception e){}}
            
            try{
                String sql="DELETE FROM import_tb where code_im = ?";
                pst=conn.prepareStatement(sql);
                pst.setString(1, Table_click);
                pst.execute();
            }catch(Exception e){JOptionPane.showMessageDialog(null, e);}
            finally {try {rs.close();pst.close();}catch (Exception e){}}
        }
        update_table();
    }//GEN-LAST:event_cmd_deleteActionPerformed

    private void cmd_open_changeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_open_changeActionPerformed
        import_frame import_form = new import_frame();
        //String code_ex = txt_code_ex.getText();
        int row=tbl_import_list.getSelectedRow();
        String code_ex=(tbl_import_list.getModel().getValueAt(row, 0).toString());
        import_frame.txt_code_im.setText(code_ex);
        import_form.setVisible(true);
    }//GEN-LAST:event_cmd_open_changeActionPerformed

    private void cmd_addnewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_addnewActionPerformed
        new import_frame().setVisible(true);
    }//GEN-LAST:event_cmd_addnewActionPerformed

    private void menu_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_closeActionPerformed
        try {rs.close();pst.close();dispose();}catch (Exception e){}
    }//GEN-LAST:event_menu_closeActionPerformed

    private void cmd_print_previewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_print_previewActionPerformed

        int row=tbl_import_list.getSelectedRow();
        String code_im=(tbl_import_list.getModel().getValueAt(row, 0).toString());
        try {
            JasperDesign jd=JRXmlLoader.load(getClass().getResourceAsStream("export.jrxml"));
            String sql = "SELECT * FROM import_tb "
                    + "LEFT JOIN import_detail ON code_im = code_im_imdt "
                    + "LEFT JOIN partner ON code_part = code_cust_im "
                    + "LEFT JOIN product_information ON import_detail.code_prod_imdt = product_information.code_prod "
                    + "WHERE code_im = '" + code_im+"'";
            JRDesignQuery newQuery= new JRDesignQuery();
            newQuery.setText(sql);
            jd.setQuery(newQuery);
            
            JasperReport jr=JasperCompileManager.compileReport(jd);
            JasperPrint jp=JasperFillManager.fillReport(jr, null, conn);
            JasperViewer jv = new JasperViewer(jp,false);
            jv.setVisible(true);
            //JasperViewer.viewReport(jp);
            
        } catch (JRException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }finally {try {rs.close();pst.close();}catch (Exception e){}}
    }//GEN-LAST:event_cmd_print_previewActionPerformed

    private void cmd_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_printActionPerformed
        int row=tbl_import_list.getSelectedRow();
        String code_im=(tbl_import_list.getModel().getValueAt(row, 0).toString());
        try {
            JasperDesign jd=JRXmlLoader.load(getClass().getResourceAsStream("export.jrxml"));
            String sql = "SELECT * FROM import_tb "
                    + "LEFT JOIN import_detail ON code_im = code_im_imdt "
                    + "LEFT JOIN partner ON code_part = code_cust_im "
                    + "LEFT JOIN product_information ON import_detail.code_prod_imdt = product_information.code_prod "
                    + "WHERE code_im = '" + code_im+"'";
            JRDesignQuery newQuery= new JRDesignQuery();
            newQuery.setText(sql);
            jd.setQuery(newQuery);
            
            JasperReport jr=JasperCompileManager.compileReport(jd);
            JasperPrint jp=JasperFillManager.fillReport(jr, null, conn);
            //JasperViewer jv = new JasperViewer(jp,false);
            //jv.setVisible(true);
            JasperPrintManager.printReport(jp,true);
            
        } catch (JRException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }finally {try {rs.close();pst.close();}catch (Exception e){}}
    }//GEN-LAST:event_cmd_printActionPerformed

    private void txt_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchKeyReleased
        String search = "%"+txt_search.getText() + "%";
    
        String sql = "SELECT code_im AS 'ID', name_part As 'Tên DT', province_part AS 'Tỉnh', date_im As 'Thời gian', "
                + "total_im as 'Tổng', paid_im as 'Thanh toán', own_im As 'Nợ' " 
                + "FROM import_tb LEFT Join partner on import_tb.code_cust_im = partner.code_part "
                + "WHERE (code_im || name_part || province_part || date_im) LIKE '"+search+"' ORDER BY date_im DESC  ";
        try{
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            tbl_import_list.setModel(DbUtils.resultSetToTableModel(rs));
            DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
            rightRenderer.setHorizontalAlignment( JLabel.RIGHT );
            tbl_import_list.getColumnModel().getColumn(4).setCellRenderer( rightRenderer );
            tbl_import_list.getColumnModel().getColumn(5).setCellRenderer( rightRenderer );
            tbl_import_list.getColumnModel().getColumn(6).setCellRenderer( rightRenderer );
        }
        catch (Exception e){JOptionPane.showMessageDialog(null, e);}
        finally {try {rs.close(); pst.close();}catch (Exception e){}}
    }//GEN-LAST:event_txt_searchKeyReleased

    private void update_table(){
    try{
            String tmp = txt_search.getText();
            String temp= (String)combo_item.getSelectedItem();
            if (temp.equals("Show_all")){
                String sql = "SELECT code_im AS 'ID', name_part As 'Tên KH', province_part AS 'Tỉnh', date_im As 'Thời gian', "
                        + "total_im as 'Tổng', paid_im as 'Thanh toán', own_im As 'Nợ' "
                        + "FROM import_tb LEFT Join partner on import_tb.code_cust_im = partner.code_part ORDER BY date_im DESC";
                
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
                tbl_import_list.setModel(DbUtils.resultSetToTableModel(rs));
                DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
                rightRenderer.setHorizontalAlignment( JLabel.RIGHT );
                tbl_import_list.getColumnModel().getColumn(4).setCellRenderer( rightRenderer );
                tbl_import_list.getColumnModel().getColumn(5).setCellRenderer( rightRenderer );
                tbl_import_list.getColumnModel().getColumn(6).setCellRenderer( rightRenderer );
            
            }else if (temp.equals("Code_export")){
                String sql = "SELECT code_im AS 'ID', name_part As 'Tên KH', province_part AS 'Tỉnh', date_im As 'Thời gian', "
                        + "total_im as 'Tổng', paid_im as 'Thanh toán', own_im As 'Nợ' "
                        + "FROM import_tb LEFT Join partner on import_tb.code_cust_im = partner.code_part "
                        + "WHERE code_im = '"+tmp+"' COLLATE utf8_unicode_ci ORDER BY date_im DESC";
                
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
                tbl_import_list.setModel(DbUtils.resultSetToTableModel(rs));
                DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
                rightRenderer.setHorizontalAlignment( JLabel.RIGHT );
                tbl_import_list.getColumnModel().getColumn(4).setCellRenderer( rightRenderer );
                tbl_import_list.getColumnModel().getColumn(5).setCellRenderer( rightRenderer );
                tbl_import_list.getColumnModel().getColumn(6).setCellRenderer( rightRenderer );
            } 
        }catch (Exception e){JOptionPane.showMessageDialog(null, e); }
        finally { try { rs.close(); pst.close();}catch (Exception e){  } }
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
            java.util.logging.Logger.getLogger(import_list_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(import_list_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(import_list_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(import_list_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new import_list_frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmd_addnew;
    private javax.swing.JButton cmd_close;
    private javax.swing.JButton cmd_delete;
    private javax.swing.JButton cmd_open_change;
    private javax.swing.JButton cmd_print;
    private javax.swing.JButton cmd_print_preview;
    private javax.swing.JButton cmd_search;
    private javax.swing.JComboBox combo_item;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem menu_close;
    private javax.swing.JTable tbl_import_list;
    private javax.swing.JTextField txt_search;
    // End of variables declaration//GEN-END:variables
}
