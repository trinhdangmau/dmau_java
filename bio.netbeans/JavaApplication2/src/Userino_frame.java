import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TrinhDang
 */
public class Userino_frame extends javax.swing.JFrame {
    Connection conn=null;
    ResultSet rs =null;
    PreparedStatement pst =null;
    

    /**
     * Creates new form Userino_frame
     */
    public Userino_frame() {
        initComponents();
        conn=javaconnect.ConnecrDb();
        Update_table();
        setIcon();
        
    }    
private void setIcon() {
        try {
        String decodedPath = URLDecoder.decode(javaconnect.class.getProtectionDomain().getCodeSource().getLocation().getPath(), "UTF-8");
        String purl = decodedPath.substring(0, decodedPath.lastIndexOf("/"));
        String Url = purl+"/Image/iconimage.png";
        setIconImage(Toolkit.getDefaultToolkit().getImage(Url));

        } catch (UnsupportedEncodingException e){
            JOptionPane.showMessageDialog(null, e);}
    }   
private void Update_table(){
    
    String tmp =(String)txt_locality.getText().toUpperCase();
    String sql ="SELECT Speciemen.specimentid, species.spname, speciemen.localityid, count50 as '50', count100 AS '100', count150 AS '150', count200 AS '200', count250 AS '250',"
            + "count300 AS '300', count400 AS '400', count500 AS '500', count700 AS '700', count1000 AS '1000' FROM speciemen INNER JOIN species ON species.speciesID = speciemen.specieID WHERE speciemen.LocalityID ='"+tmp+"' ORDER BY 'species'.spname ";
    //String sql ="SELECT Speciemen.specimentid, speciemen.localityid FROM speciemen WHERE speciemen.LocalityID ='"+tmp+"'";
    try{
       
    pst=conn.prepareStatement(sql);
    rs=pst.executeQuery();
    table_specimen.setModel(DbUtils.resultSetToTableModel(rs));
    table_specimen.setAutoResizeMode(table_specimen.AUTO_RESIZE_OFF);
    table_specimen.getColumnModel().getColumn(0).setPreferredWidth(50);
    table_specimen.getColumnModel().getColumn(1).setPreferredWidth(170);
    table_specimen.getColumnModel().getColumn(2).setPreferredWidth(60);
    table_specimen.getColumnModel().getColumn(3).setPreferredWidth(54);
    table_specimen.getColumnModel().getColumn(4).setPreferredWidth(54);
    table_specimen.getColumnModel().getColumn(5).setPreferredWidth(54);
    table_specimen.getColumnModel().getColumn(6).setPreferredWidth(54);
    table_specimen.getColumnModel().getColumn(7).setPreferredWidth(54);
    table_specimen.getColumnModel().getColumn(8).setPreferredWidth(54);
    table_specimen.getColumnModel().getColumn(9).setPreferredWidth(54);
    table_specimen.getColumnModel().getColumn(10).setPreferredWidth(54);
    table_specimen.getColumnModel().getColumn(11).setPreferredWidth(53);
    table_specimen.getColumnModel().getColumn(12).setPreferredWidth(53);
            }
    catch (Exception e){
        JOptionPane.showMessageDialog(null, e);
        
    }finally {try {rs.close();pst.close();}catch (Exception e){}}
    //
    String sql1="Select sum(count50) from Speciemen WHERE LocalityID ='"+tmp+"'";
        String sql2="Select count(specimentid) from Speciemen WHERE LocalityID ='"+tmp+"'";
        String sql100="Select sum(count100) from Speciemen WHERE LocalityID ='"+tmp+"'";
        String sql150="Select sum(count150) from Speciemen WHERE LocalityID ='"+tmp+"'";
        String sql200="Select sum(count200) from Speciemen WHERE LocalityID ='"+tmp+"'";
        String sql250="Select sum(count250) from Speciemen WHERE LocalityID ='"+tmp+"'";
        String sql300="Select sum(count300) from Speciemen WHERE LocalityID ='"+tmp+"'";
        String sql400="Select sum(count400) from Speciemen WHERE LocalityID ='"+tmp+"'";
        String sql500="Select sum(count500) from Speciemen WHERE LocalityID ='"+tmp+"'";
        String sql700="Select sum(count700) from Speciemen WHERE LocalityID ='"+tmp+"'";
        String sql1000="Select sum(count1000) from Speciemen WHERE LocalityID ='"+tmp+"'";
       
        try {
           pst =conn.prepareStatement(sql1);
           rs =pst.executeQuery();
           
           if (rs.next()){
               String sum50 = rs.getString("sum(count50)");
               txt_sum.setText(sum50);}
        }catch (Exception e){JOptionPane.showMessageDialog(null, e);}
            finally { try { rs.close(); pst.close();}catch (Exception e){  } }
        
        try {
           pst =conn.prepareStatement(sql100);
           rs =pst.executeQuery();
           
           if (rs.next()){
               String sum100 = rs.getString("sum(count100)");
               txt_sum100.setText(sum100);}
        }catch (Exception e){JOptionPane.showMessageDialog(null, e);}
            finally { try { rs.close(); pst.close();}catch (Exception e){  } }
        
        try {
           pst =conn.prepareStatement(sql150);
           rs =pst.executeQuery();
           
           if (rs.next()){
               String sum150 = rs.getString("sum(count150)");
               txt_sum150.setText(sum150);}
        }catch (Exception e){JOptionPane.showMessageDialog(null, e);}   
            finally { try { rs.close(); pst.close();}catch (Exception e){  } }
        
        try {
           pst =conn.prepareStatement(sql200);
           rs =pst.executeQuery();
           
           if (rs.next()){
               String sum200 = rs.getString("sum(count200)");
               txt_sum200.setText(sum200);}
        }catch (Exception e){JOptionPane.showMessageDialog(null, e);}
            finally { try { rs.close(); pst.close();}catch (Exception e){  } }
                            
        try {
           pst =conn.prepareStatement(sql250);
           rs =pst.executeQuery();
           
           if (rs.next()){
               String sum250 = rs.getString("sum(count250)");
               txt_sum250.setText(sum250);}
        }catch (Exception e){JOptionPane.showMessageDialog(null, e);}
            finally { try { rs.close(); pst.close();}catch (Exception e){  } }
        
        try {
           pst =conn.prepareStatement(sql300);
           rs =pst.executeQuery();
           
           if (rs.next()){
               String sum300 = rs.getString("sum(count300)");
               txt_sum300.setText(sum300);}
        }catch (Exception e){JOptionPane.showMessageDialog(null, e);}
            finally { try { rs.close(); pst.close();}catch (Exception e){  } }
        
        try {
           pst =conn.prepareStatement(sql400);
           rs =pst.executeQuery();
           
           if (rs.next()){
               String sum400 = rs.getString("sum(count400)");
               txt_sum400.setText(sum400);}
        }catch (Exception e){JOptionPane.showMessageDialog(null, e);}
            finally { try { rs.close(); pst.close();}catch (Exception e){  } }
        
        try {
           pst =conn.prepareStatement(sql500);
           rs =pst.executeQuery();
           
           if (rs.next()){
               String sum500 = rs.getString("sum(count500)");
               txt_sum500.setText(sum500);}
        }catch (Exception e){JOptionPane.showMessageDialog(null, e);}
            finally { try { rs.close(); pst.close();}catch (Exception e){  } }
        
        try {
           pst =conn.prepareStatement(sql700);
           rs =pst.executeQuery();
           
           if (rs.next()){
               String sum700 = rs.getString("sum(count700)");
               txt_sum700.setText(sum700);}
        }catch (Exception e){JOptionPane.showMessageDialog(null, e);}
            finally { try { rs.close(); pst.close();}catch (Exception e){  } }
        
        try {
           pst =conn.prepareStatement(sql1000);
           rs =pst.executeQuery();
           
           if (rs.next()){
               String sum1000 = rs.getString("sum(count1000)");
               txt_sum1000.setText(sum1000);}
        }catch (Exception e){JOptionPane.showMessageDialog(null, e);}
            finally { try { rs.close(); pst.close();}catch (Exception e){  } }
        
        try {
           pst =conn.prepareStatement(sql2);
           rs =pst.executeQuery();
           
           if (rs.next()){
               String count = rs.getString("count(specimentid)");
               txt_nosp.setText(count);
           }
        }catch (Exception e){JOptionPane.showMessageDialog(null, e); }
            finally { try { rs.close(); pst.close();}catch (Exception e){  } }
    
    
    
    //
    
} 
    
private void Fildcombo_spname(){
    
try {
    String sql ="SELECT spname FROM 'Species' ORDER BY spname ";
    pst=conn.prepareStatement(sql);
    rs=pst.executeQuery();
    //combo_genus.addItem("");
    combo_spname.setEditable(true);
    while(rs.next()){
        String name =rs.getString("spname");
        combo_spname.addItem(name);}
        AutoCompleteDecorator.decorate(this.combo_spname);
    }
    catch (Exception e){JOptionPane.showMessageDialog(null, e);}
    finally {try {rs.close();pst.close();}catch (Exception e){}}


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
        table_specimen = new javax.swing.JTable();
        txt_locality = new javax.swing.JTextField();
        txt_sum = new javax.swing.JTextField();
        txt_nosp = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_spname2 = new javax.swing.JTextField();
        txt_count50 = new javax.swing.JTextField();
        txt_count100 = new javax.swing.JTextField();
        txt_count150 = new javax.swing.JTextField();
        txt_count200 = new javax.swing.JTextField();
        txt_count250 = new javax.swing.JTextField();
        txt_sum100 = new javax.swing.JTextField();
        txt_sum150 = new javax.swing.JTextField();
        txt_sum200 = new javax.swing.JTextField();
        txt_sum250 = new javax.swing.JTextField();
        txt_count300 = new javax.swing.JTextField();
        txt_count400 = new javax.swing.JTextField();
        txt_count500 = new javax.swing.JTextField();
        txt_count700 = new javax.swing.JTextField();
        txt_count1000 = new javax.swing.JTextField();
        txt_sum300 = new javax.swing.JTextField();
        txt_sum400 = new javax.swing.JTextField();
        txt_sum500 = new javax.swing.JTextField();
        txt_sum700 = new javax.swing.JTextField();
        txt_sum1000 = new javax.swing.JTextField();
        cmd_countind = new javax.swing.JButton();
        cmd_setzero = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txt_localityid = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_location = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_note = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_time = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_spid = new javax.swing.JTextField();
        txt_speId = new javax.swing.JTextField();
        cmd_addnew = new javax.swing.JButton();
        cmd_save = new javax.swing.JButton();
        cmd_delete = new javax.swing.JButton();
        cmd_update = new javax.swing.JButton();
        combo_spname = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        cmd_exportxls = new javax.swing.JMenuItem();
        cmd_exportall = new javax.swing.JMenuItem();
        cmd_importall = new javax.swing.JMenuItem();
        cmd_deletealltable = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        cmd_copy = new javax.swing.JMenuItem();
        cmd_cut = new javax.swing.JMenuItem();
        cmd_paste = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        cmd_undo = new javax.swing.JMenuItem();
        cmd_redo = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        cmd_export = new javax.swing.JMenuItem();
        cmd_exportcsv = new javax.swing.JMenuItem();
        cmd_import = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        cmd_deleteall = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Count Number of Individual");

        table_specimen.setModel(new javax.swing.table.DefaultTableModel(
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
        table_specimen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_specimenMouseClicked(evt);
            }
        });
        table_specimen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                table_specimenKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(table_specimen);

        txt_locality.setToolTipText("Enter the Locality ");
        txt_locality.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_localityActionPerformed(evt);
            }
        });
        txt_locality.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_localityKeyReleased(evt);
            }
        });

        jLabel1.setText("No. Species:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Locality ID:");

        txt_sum300.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N

        cmd_countind.setText("Count IND.");
        cmd_countind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_countindActionPerformed(evt);
            }
        });

        cmd_setzero.setText("Set Zero");
        cmd_setzero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_setzeroActionPerformed(evt);
            }
        });

        jLabel6.setText("Locality ID:");

        txt_localityid.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txt_localityidInputMethodTextChanged(evt);
            }
        });

        jLabel7.setText("Location:");

        txt_note.setColumns(10);
        txt_note.setRows(3);
        txt_note.setTabSize(3);
        jScrollPane2.setViewportView(txt_note);

        jLabel3.setText("Specimen ID:");

        jLabel9.setText("Note:");

        jLabel4.setText("Species Name:");

        jLabel8.setText("Time:");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        jLabel5.setText("Species ID:");

        cmd_addnew.setText("Add New");
        cmd_addnew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_addnewActionPerformed(evt);
            }
        });

        cmd_save.setText("Save");
        cmd_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_saveActionPerformed(evt);
            }
        });

        cmd_delete.setText("Delete");
        cmd_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_deleteActionPerformed(evt);
            }
        });

        cmd_update.setText("Update");
        cmd_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_updateActionPerformed(evt);
            }
        });

        combo_spname.setEditable(true);
        combo_spname.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        combo_spname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                combo_spnameFocusLost(evt);
            }
        });
        combo_spname.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                combo_spnamePopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        combo_spname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                combo_spnameKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_speId, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_localityid)
                            .addComponent(txt_spid)))
                    .addComponent(txt_location, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(24, 24, 24)
                        .addComponent(txt_time))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmd_addnew, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                            .addComponent(cmd_update, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmd_save, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmd_delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(0, 23, Short.MAX_VALUE))
                    .addComponent(combo_spname, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_speId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(combo_spname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_spid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_localityid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_location, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmd_addnew)
                    .addComponent(cmd_save))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmd_delete)
                    .addComponent(cmd_update)))
        );

        jLabel10.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel10.setText("Specimens Detail");

        jMenu1.setText("File");

        cmd_exportxls.setText("Export to .xls");
        cmd_exportxls.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_exportxlsActionPerformed(evt);
            }
        });
        jMenu1.add(cmd_exportxls);

        cmd_exportall.setText("Export all .csv");
        cmd_exportall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_exportallActionPerformed(evt);
            }
        });
        jMenu1.add(cmd_exportall);

        cmd_importall.setText("Import from .csv");
        cmd_importall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_importallActionPerformed(evt);
            }
        });
        jMenu1.add(cmd_importall);

        cmd_deletealltable.setText("Delete all table");
        cmd_deletealltable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_deletealltableActionPerformed(evt);
            }
        });
        jMenu1.add(cmd_deletealltable);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Print");
        jMenu1.add(jMenuItem3);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Close");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        cmd_copy.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        cmd_copy.setText("Copy");
        jMenu2.add(cmd_copy);

        cmd_cut.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        cmd_cut.setText("Cut");
        jMenu2.add(cmd_cut);

        cmd_paste.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        cmd_paste.setText("Paste");
        jMenu2.add(cmd_paste);
        jMenu2.add(jSeparator1);

        cmd_undo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        cmd_undo.setText("Undo");
        jMenu2.add(cmd_undo);

        cmd_redo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_MASK));
        cmd_redo.setText("Redo");
        jMenu2.add(cmd_redo);

        jMenuBar1.add(jMenu2);

        jMenu4.setText("Tools");

        cmd_export.setText("Export to .xls");
        cmd_export.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_exportActionPerformed(evt);
            }
        });
        jMenu4.add(cmd_export);

        cmd_exportcsv.setText("Export tbl to .csv");
        cmd_exportcsv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_exportcsvActionPerformed(evt);
            }
        });
        jMenu4.add(cmd_exportcsv);

        cmd_import.setText("Import from .csv");
        cmd_import.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_importActionPerformed(evt);
            }
        });
        jMenu4.add(cmd_import);
        jMenu4.add(jSeparator2);

        cmd_deleteall.setText("Delete all");
        cmd_deleteall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_deleteallActionPerformed(evt);
            }
        });
        jMenu4.add(cmd_deleteall);

        jMenuBar1.add(jMenu4);

        jMenu3.setText("Help");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jMenuItem2.setText("About");
        jMenu3.add(jMenuItem2);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_locality, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txt_nosp, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_spname2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmd_countind)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmd_setzero)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_sum)
                            .addComponent(txt_count50, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt_count100, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_count150, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_count200, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_count250, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_count300, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_count400, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_count500, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_count700, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_count1000, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt_sum100, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_sum150, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_sum200, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_sum250, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_sum300, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_sum400, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_sum500, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_sum700, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_sum1000, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 824, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(14, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_locality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_nosp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_spname2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_count50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_count100, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_count150, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_count200, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_count250, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_count300, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_count400, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_count500, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_count700, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_count1000, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_sum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_sum100, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_sum150, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_sum200, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_sum250, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_sum300, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_sum400, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_sum500, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_sum700, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_sum1000, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmd_setzero)
                    .addComponent(cmd_countind))
                .addGap(27, 27, 27))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_localityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_localityKeyReleased

    }//GEN-LAST:event_txt_localityKeyReleased

    private void table_specimenKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_table_specimenKeyReleased
        if(evt.getKeyCode()==KeyEvent.VK_DOWN || evt.getKeyCode()==KeyEvent.VK_UP){
        
        try{
        int row=table_specimen.getSelectedRow();
        String Table_click=(table_specimen.getModel().getValueAt(row, 0).toString());
            
            String sql="SELECT * FROM speciemen INNER JOIN species ON species.speciesID = speciemen.specieID WHERE speciemen.specimentid ='"+Table_click+"'   ";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            
            if(rs.next()){
                String add1 =rs.getString("specimentid");
                txt_speId.setText(add1);
                String add2 =rs.getString("spname");
                combo_spname.setSelectedItem(add2);
                txt_spname2.setText(add2);
                String add3 =rs.getString("specieid");
                txt_spid.setText(add3);
                String add4 =rs.getString("localityid");
                txt_localityid.setText(add4);
                String add5 =rs.getString("time");
                txt_time.setText(add5);
                String add6 =rs.getString("note");
                txt_note.setText(add6);
                
                String add7 =rs.getString("count50");
                txt_count50.setText(add7);
                String add8 =rs.getString("count100");
                txt_count100.setText(add8);
                String add9 =rs.getString("count150");
                txt_count150.setText(add9);
                String add10 =rs.getString("count200");
                txt_count200.setText(add10);
                String add11 =rs.getString("count250");
                txt_count250.setText(add11);
                String add12 =rs.getString("count300");
                txt_count300.setText(add12);
                String add13 =rs.getString("count400");
                txt_count400.setText(add13);
                String add14 =rs.getString("count500");
                txt_count500.setText(add14);
                String add15 =rs.getString("count700");
                txt_count700.setText(add15);
                String add16 =rs.getString("count1000");
                txt_count1000.setText(add16);
                
                
            }
        }catch(Exception e){ JOptionPane.showMessageDialog(null, e);}
            finally { try { rs.close(); pst.close();}catch (Exception e){  } }
        
        }
    }//GEN-LAST:event_table_specimenKeyReleased

    private void table_specimenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_specimenMouseClicked
        try{
        int row=table_specimen.getSelectedRow();
        String Table_click=(table_specimen.getModel().getValueAt(row, 0).toString());
            
            String sql="SELECT * FROM speciemen INNER JOIN species ON species.speciesID = speciemen.specieID WHERE speciemen.specimentid ='"+Table_click+"'   ";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            
            if(rs.next()){
                String add1 =rs.getString("specimentid");
                txt_speId.setText(add1);
                String add2 =rs.getString("spname");
                combo_spname.setSelectedItem(add2);
                txt_spname2.setText(add2);
                String add3 =rs.getString("specieid");
                txt_spid.setText(add3);
                String add4 =rs.getString("localityid");
                txt_localityid.setText(add4);
                String add5 =rs.getString("time");
                txt_time.setText(add5);
                String add6 =rs.getString("note");
                txt_note.setText(add6);
                
                String add7 =rs.getString("count50");
                txt_count50.setText(add7);
                String add8 =rs.getString("count100");
                txt_count100.setText(add8);
                String add9 =rs.getString("count150");
                txt_count150.setText(add9);
                String add10 =rs.getString("count200");
                txt_count200.setText(add10);
                String add11 =rs.getString("count250");
                txt_count250.setText(add11);
                String add12 =rs.getString("count300");
                txt_count300.setText(add12);
                String add13 =rs.getString("count400");
                txt_count400.setText(add13);
                String add14 =rs.getString("count500");
                txt_count500.setText(add14);
                String add15 =rs.getString("count700");
                txt_count700.setText(add15);
                String add16 =rs.getString("count1000");
                txt_count1000.setText(add16);
                
                
            }
        }catch(Exception e){ JOptionPane.showMessageDialog(null, e);}
            finally { try { rs.close(); pst.close();}catch (Exception e){  } }
    }//GEN-LAST:event_table_specimenMouseClicked

    private void cmd_countindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_countindActionPerformed
            
        if(txt_count50.getText().isEmpty()){JOptionPane.showMessageDialog(null, "This is blank field, please set zero first");}
        else{
            int s50 = Integer.parseInt(txt_sum.getText());
            int s100 = Integer.parseInt(txt_sum100.getText());
            int s150 = Integer.parseInt(txt_sum150.getText());
            int s200 = Integer.parseInt(txt_sum200.getText());
            int s250 = Integer.parseInt(txt_sum250.getText());
            int s300 = Integer.parseInt(txt_sum300.getText());
            int s400 = Integer.parseInt(txt_sum400.getText());
            int s500 = Integer.parseInt(txt_sum500.getText());
            int s700 = Integer.parseInt(txt_sum700.getText());
            int s1000 = Integer.parseInt(txt_sum1000.getText());

            int c50 = Integer.parseInt(txt_count50.getText());
            int c100=Integer.parseInt(txt_count100.getText());
            int c150=Integer.parseInt(txt_count150.getText());
            int c200=Integer.parseInt(txt_count200.getText());
            int c250=Integer.parseInt(txt_count250.getText());
            int c300=Integer.parseInt(txt_count300.getText());
            int c400=Integer.parseInt(txt_count400.getText());
            int c500=Integer.parseInt(txt_count500.getText());
            int c700=Integer.parseInt(txt_count700.getText());
            int c1000=Integer.parseInt(txt_count1000.getText());
            
            if (s50<50){
                String specid =txt_speId.getText();
                String temp = String.valueOf(c50+1);
            txt_count50.setText(temp);
                try{
                    String sql ="UPDATE speciemen SET  count50 ='"+temp+"' WHERE specimentid ='"+specid+"' ";
                    pst=conn.prepareStatement(sql);
                    pst.execute();
                }catch(Exception e){JOptionPane.showMessageDialog(null, e);}
                    finally { try { rs.close(); pst.close();}catch (Exception e){  } }
            Update_table();
            }else if (s100<50){
                    String specid =txt_speId.getText();
                    String temp = String.valueOf(c100+1);
                txt_count100.setText(temp);
                    try{
                        String sql ="UPDATE speciemen SET  count100 ='"+temp+"' WHERE specimentid ='"+specid+"' ";
                        pst=conn.prepareStatement(sql);
                        pst.execute();
                    }catch(Exception e){JOptionPane.showMessageDialog(null, e);}
                        finally { try { rs.close(); pst.close();}catch (Exception e){  } }
                Update_table();
                }else if (s150<50){
                    String specid =txt_speId.getText();
                    String temp = String.valueOf(c150+1);
                    txt_count150.setText(temp);
                    try{
                        String sql ="UPDATE speciemen SET  count150 ='"+temp+"' WHERE specimentid ='"+specid+"' ";
                        pst=conn.prepareStatement(sql);
                        pst.execute();
                    }catch(Exception e){JOptionPane.showMessageDialog(null, e);}
                        finally { try { rs.close(); pst.close();}catch (Exception e){  } }
                    Update_table();
                    }else if (s200<50){
                            String specid =txt_speId.getText();
                            String temp = String.valueOf(c200+1);
                        txt_count200.setText(temp);
                            try{
                                String sql ="UPDATE speciemen SET  count200 ='"+temp+"' WHERE specimentid ='"+specid+"' ";
                                pst=conn.prepareStatement(sql);
                                pst.execute();
                            }catch(Exception e){JOptionPane.showMessageDialog(null, e);}
                                finally { try { rs.close(); pst.close();}catch (Exception e){  } }
                        Update_table();
                        }else if (s250<50){
                            String specid =txt_speId.getText();
                            String temp = String.valueOf(c250+1);
                            txt_count250.setText(temp);
                            try{
                                String sql ="UPDATE speciemen SET  count250 ='"+temp+"' WHERE specimentid ='"+specid+"' ";
                                pst=conn.prepareStatement(sql);
                                pst.execute();
                            }catch(Exception e){JOptionPane.showMessageDialog(null, e);}
                                finally { try { rs.close(); pst.close();}catch (Exception e){  } }
                            Update_table();
                            }else if (s300<50){
                                String specid =txt_speId.getText();
                                String temp = String.valueOf(c300+1);
                                txt_count300.setText(temp);
                                try{
                                    String sql ="UPDATE speciemen SET  count300 ='"+temp+"' WHERE specimentid ='"+specid+"' ";
                                    pst=conn.prepareStatement(sql);
                                    pst.execute();
                                }catch(Exception e){JOptionPane.showMessageDialog(null, e);}
                                    finally { try { rs.close(); pst.close();}catch (Exception e){  } }
                                Update_table();
                                }else if (s400<100){
                                    String specid =txt_speId.getText();
                                    String temp = String.valueOf(c400+1);
                                    txt_count400.setText(temp);
                                    try{
                                        String sql ="UPDATE speciemen SET  count400 ='"+temp+"' WHERE specimentid ='"+specid+"' ";
                                        pst=conn.prepareStatement(sql);
                                        pst.execute();
                                    }catch(Exception e){JOptionPane.showMessageDialog(null, e);}
                                        finally { try { rs.close(); pst.close();}catch (Exception e){  } }
                                    Update_table();
                                    }else if (s500<100){
                                        String specid =txt_speId.getText();
                                        String temp = String.valueOf(c500+1);
                                        txt_count500.setText(temp);
                                        try{
                                            String sql ="UPDATE speciemen SET  count500 ='"+temp+"' WHERE specimentid ='"+specid+"' ";
                                            pst=conn.prepareStatement(sql);
                                            pst.execute();
                                        }catch(Exception e){JOptionPane.showMessageDialog(null, e);}
                                            finally { try { rs.close(); pst.close();}catch (Exception e){  } }
                                        Update_table();
                                        }else if (s700<200){
                                            String specid =txt_speId.getText();
                                            String temp = String.valueOf(c700+1);
                                            txt_count700.setText(temp);
                                            try{
                                                String sql ="UPDATE speciemen SET  count700 ='"+temp+"' WHERE specimentid ='"+specid+"' ";
                                                pst=conn.prepareStatement(sql);
                                                pst.execute();
                                            }catch(Exception e){JOptionPane.showMessageDialog(null, e);}
                                                finally { try { rs.close(); pst.close();}catch (Exception e){  } }
                                            Update_table();
                                            }else{
                                                if (s1000<300){
                                                String specid =txt_speId.getText();
                                                String temp = String.valueOf(c1000+1);
                                                txt_count1000.setText(temp);
                                                try{
                                                    String sql ="UPDATE speciemen SET  count1000 ='"+temp+"' WHERE specimentid ='"+specid+"' ";
                                                    pst=conn.prepareStatement(sql);
                                                    pst.execute();
                                                }catch(Exception e){JOptionPane.showMessageDialog(null, e);}
                                                    finally { try { rs.close(); pst.close();}catch (Exception e){  } }
                                                Update_table();
                                                }else{JOptionPane.showMessageDialog(null, "The number of individual reached to 1000");}
                                                }   
        }
    }//GEN-LAST:event_cmd_countindActionPerformed

    private void cmd_setzeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_setzeroActionPerformed

        String tem = "SELECT * FROM speciemen WHERE localityid =?";
        String specid =txt_speId.getText();
        
        try {
            pst =conn.prepareStatement(tem);
            pst.setString(1, txt_locality.getText().toUpperCase());
            
            rs =pst.executeQuery();
            if(rs.next()){
                String c50 = txt_count50.getText();
                String c100 = txt_count100.getText();
                String c150 = txt_count150.getText();
                String c200 = txt_count200.getText();
                String c250 = txt_count250.getText();
                String c300 = txt_count300.getText();
                //String c400 = txt_count400.getText();
               // String c500 = txt_count500.getText();
               // String c700 = txt_count700.getText();
               // String c1000 = txt_count1000.getText();
                String zero = "0";
                
                if (c50.equals("") && c100.equals("") && c150.equals("") && c200.equals("") &&  c250.equals("")&& c300.equals("") ) {
                    int p =JOptionPane.showConfirmDialog(null, "This is the blank field. Do you want to set them to 0?", "Set Zero Confirm", JOptionPane.YES_NO_OPTION);
                        if (p==0){
                            txt_count50.setText(zero);
                            txt_count100.setText(zero);
                            txt_count150.setText(zero);
                            txt_count200.setText(zero);
                            txt_count250.setText(zero);
                            txt_count300.setText(zero);
                            txt_count400.setText(zero);
                            txt_count500.setText(zero);
                            txt_count700.setText(zero);
                            txt_count1000.setText(zero);
                            
                            try {
                                String sql ="UPDATE speciemen SET count50 ='"+zero+"', count100 ='"+zero+"',count150 ='"+zero+"', count200 ='"+zero+"', count250 ='"+zero+"',"
                                        +"count300 ='"+zero+"', count400 ='"+zero+"', count500 ='"+zero+"', count700 ='"+zero+"', count1000 ='"+zero+"' WHERE specimentid ='"+specid+"'    ";
                                pst = conn.prepareStatement(sql);
                                pst.execute();
                                
                                //JOptionPane.showMessageDialog(null, "Updated");
                            }catch(Exception e){JOptionPane.showMessageDialog(null, e);}
                                finally { try { rs.close(); pst.close();}catch (Exception e){  } }
                            Update_table();
                        }
                }
                else{
                int p =JOptionPane.showConfirmDialog(null, "This is the blank field. Do you want to set them to 0?", "Set Zero Confirm", JOptionPane.YES_NO_OPTION);
                        if (p==0){
                            txt_count50.setText(zero);
                            txt_count100.setText(zero);
                            txt_count150.setText(zero);
                            txt_count200.setText(zero);
                            txt_count250.setText(zero);
                            txt_count300.setText(zero);
                            txt_count400.setText(zero);
                            txt_count500.setText(zero);
                            txt_count700.setText(zero);
                            txt_count1000.setText(zero);
                            
                            try {
                                String sql ="UPDATE speciemen SET count50 ='"+zero+"', count100 ='"+zero+"',count150 ='"+zero+"', count200 ='"+zero+"', count250 ='"+zero+"',"
                                        +"count300 ='"+zero+"', count400 ='"+zero+"', count500 ='"+zero+"', count700 ='"+zero+"', count1000 ='"+zero+"' WHERE specimentid ='"+specid+"'    ";
                                pst = conn.prepareStatement(sql);
                                pst.execute();

                                //JOptionPane.showMessageDialog(null, "Updated");
                            }catch(Exception e){JOptionPane.showMessageDialog(null, e);}
                                finally { try { rs.close(); pst.close();}catch (Exception e){  } }
                            Update_table();
                }
            
            }
            }else{JOptionPane.showMessageDialog(null, "The LoCaLiTy not set");}
             
        }catch(Exception e){JOptionPane.showMessageDialog(null, e);}
            finally { try { rs.close(); pst.close();}catch (Exception e){  } }
                   
    }//GEN-LAST:event_cmd_setzeroActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        try {
        rs.close();
        pst.close();
        dispose();
        }catch (Exception e){}
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void txt_localityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_localityActionPerformed
    
        Update_table();
    
    String tmp =(String)txt_locality.getText().toUpperCase();
    //kiem tra neu locality chua ton tai thi hoi xem co them locality khong
    String check = "SELECT count(localityid) FROM locality WHERE localityid = '"+tmp+"'";
    try{
    pst=conn.prepareStatement(check);
    rs=pst.executeQuery();
    if (rs.next()){
        final int count = rs.getInt(1);
        if (count < 1){
            int p =JOptionPane.showConfirmDialog(null, "The Locality not Exist! Do you want to add new Locality?", "Delete", JOptionPane.YES_NO_OPTION);
            if (p==0){
                 new Locality_Frame().setVisible(true);
            }
        }
    }
    }catch (Exception e){JOptionPane.showMessageDialog(null, e);
        }finally {try {rs.close();pst.close();}catch (Exception e){}}
//gan Location toi txt_location
    String sql ="SELECT 'location'.name FROM 'Location' INNER JOIN 'Locality' ON 'location'.locationid = 'locality'.locationidi WHERE 'locality'.LocalityID ='"+tmp+"'";
    try{  
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
        if (rs.next()){
        String locationname =rs.getString("Name");
        txt_location.setText(locationname);
        }
        }catch (Exception e){JOptionPane.showMessageDialog(null, e);
        }finally {try {rs.close();pst.close();}catch (Exception e){}}
        
    }//GEN-LAST:event_txt_localityActionPerformed

    private void txt_localityidInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txt_localityidInputMethodTextChanged
  
    }//GEN-LAST:event_txt_localityidInputMethodTextChanged

    private void cmd_addnewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_addnewActionPerformed
        try{
            String sql="SELECT max(specimentid) FROM 'Speciemen'";
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
                if(rs.next()){
                    int classidmax = rs.getInt("max(specimentid)");
                    String classidnext = String.valueOf(classidmax + 1);
                    txt_speId.setText(classidnext);
                }
            combo_spname.setSelectedItem("");
            txt_spid.setText("");
            txt_time.setText("");
            txt_note.setText("");
        }catch(Exception e){JOptionPane.showMessageDialog(null, e);}
            finally {try {rs.close();pst.close();}catch (Exception e){}}

        String tmp =(String)txt_locality.getText().toUpperCase();
        String sql ="SELECT 'location'.name FROM 'Location' INNER JOIN 'Locality' ON 'location'.locationid = 'locality'.locationidi WHERE 'locality'.LocalityID ='"+tmp+"'";
        try{

        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
        if (rs.next()){
            String locationname =rs.getString("Name");
            txt_location.setText(locationname);
        }
        txt_localityid.setText(tmp);
        }catch (Exception e){JOptionPane.showMessageDialog(null, e);   
            }finally {try {rs.close();pst.close();}catch (Exception e){}}
    
    Fildcombo_spname();
    }//GEN-LAST:event_cmd_addnewActionPerformed

    private void cmd_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_saveActionPerformed
        try{
            String sql ="INSERT INTO Speciemen (specimentID, specieid, LocalityID, time, note) values (?,?,?,?,?)";

                pst =conn.prepareStatement(sql);
                pst.setString(1, txt_speId.getText());
                pst.setString(2, txt_spid.getText());
                pst.setString(3, txt_localityid.getText());
                pst.setString(4, txt_time.getText());
                pst.setString(5, txt_note.getText());
                pst.execute();

            JOptionPane.showMessageDialog(null, "One new Speciemen was added");

        }catch(Exception e){ JOptionPane.showMessageDialog(null, e);}
        finally {try {rs.close(); pst.close();}catch (Exception e){ }}
         Update_table();
    }//GEN-LAST:event_cmd_saveActionPerformed

    private void cmd_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_updateActionPerformed
        try{
            String speid=txt_speId.getText();
            String spid =txt_spid.getText();
            String localityid = txt_localityid.getText();
            String time = txt_time.getText();
            String note =txt_note.getText();
            
            String sql ="UPDATE Speciemen SET specieid ='"+spid+"', LocalityID='"+localityid+"', time ='"+time+"', note='"+note+"' WHERE specimentID ='"+speid+"'  ";
            pst=conn.prepareStatement(sql);
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Updated");
        
        }catch(Exception e){JOptionPane.showMessageDialog(null, e);}
                finally {try {rs.close();pst.close();}catch (Exception e){}}
        
        Update_table();
        
    }//GEN-LAST:event_cmd_updateActionPerformed

    private void cmd_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_deleteActionPerformed
    int p =JOptionPane.showConfirmDialog(null, "Do you want to DELETE this data?", "Delete", JOptionPane.YES_NO_OPTION);
    if (p==0){
        try{
            String sql="DELETE from Speciemen where specimentID = ?";
            pst=conn.prepareStatement(sql);
            pst.setString(1, txt_speId.getText());
            pst.execute();
        }catch(Exception e){JOptionPane.showMessageDialog(null, e);}
                finally {try {rs.close();pst.close();}catch (Exception e){}}
        
        Update_table();
        }
        
    }//GEN-LAST:event_cmd_deleteActionPerformed

    private void cmd_exportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_exportActionPerformed
    
    String tmp =(String)txt_locality.getText().toUpperCase();
    JFileChooser chooser = new JFileChooser();
    chooser.setDialogTitle("Export specimens "+tmp+" to .xls file");
    int retval = chooser.showSaveDialog(null);
    File f = chooser.getSelectedFile();
    String outputDirPath=f.getAbsolutePath();
    
    if (retval==JFileChooser.APPROVE_OPTION){
        if(f.exists()) {
            int p =JOptionPane.showConfirmDialog(null, "File are exist! Do you want to over write?", "Delete", JOptionPane.YES_NO_OPTION);
            if (p==1){
            return;
            }
        }

            Workbook wb = new HSSFWorkbook();
            Sheet personSheet = wb.createSheet(tmp);

            Row titlerow = personSheet.createRow(0);
            Cell nametitle = titlerow.createCell(0);
            nametitle.setCellValue("Specimens Information");

            Row headerRow = personSheet.createRow(1);
                Cell specimenid = headerRow.createCell(0); specimenid.setCellValue("Specimen ID");
                Cell speciesid = headerRow.createCell(1); speciesid.setCellValue("Species ID");
                Cell speciesname = headerRow.createCell(2); speciesname.setCellValue("Species Name");
                Cell localityid = headerRow.createCell(3); localityid.setCellValue("Locality ID");
                Cell time = headerRow.createCell(4); time.setCellValue("Time");
                Cell note = headerRow.createCell(5); note.setCellValue("Note");
                Cell c50 = headerRow.createCell(6); c50.setCellValue("Count50");
                Cell c100 = headerRow.createCell(7); c100.setCellValue("Count100");
                Cell c150 = headerRow.createCell(8); c150.setCellValue("Count150");
                Cell c200 = headerRow.createCell(9); c200.setCellValue("Count200");
                Cell c250 = headerRow.createCell(10); c250.setCellValue("Count250");
                Cell c300 = headerRow.createCell(11); c300.setCellValue("Count300");
                Cell c400 = headerRow.createCell(12); c400.setCellValue("Count400");
                Cell c500 = headerRow.createCell(13); c500.setCellValue("Count500");
                Cell c700 = headerRow.createCell(14); c700.setCellValue("Count700");
                Cell c1000 = headerRow.createCell(15); c1000.setCellValue("Count1000");

            try{
            String sql = "SELECT 'Speciemen'.specimentid, 'Speciemen'.specieid, 'Species'.spname, 'Speciemen'.localityid, "
                    + "'Speciemen'.time, 'Speciemen'.note, 'Speciemen'.count50, 'Speciemen'.count100, "
                    + "'Speciemen'.count150, 'Speciemen'.count200, 'Speciemen'.count250, 'Speciemen'.count300, "
                    + "'Speciemen'.count400, 'Speciemen'.count500, 'Speciemen'.count700, 'Speciemen'.count1000 FROM 'Speciemen'  "
                    + "INNER JOIN 'Species' On 'Speciemen'.specieid = 'Species'.speciesid WHERE 'speciemen'.LocalityID = '"+tmp+"' ORDER BY 'Speciemen'.specimentid, 'Species'.spname ";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery(); 

            int row = 2;
            while(rs.next()) {
                Row dataRow = personSheet.createRow(row);
                
            Cell specimenidcell = dataRow.createCell(0); specimenidcell.setCellValue(rs.getString("SpecimentID"));
            Cell speciesidcell = dataRow.createCell(1); speciesidcell.setCellValue(rs.getString("specieid"));
            Cell speciesnamecell = dataRow.createCell(2); speciesnamecell.setCellValue(rs.getString("spname"));
            Cell localityidcell = dataRow.createCell(3); localityidcell.setCellValue(rs.getString("localityid"));
            Cell timecell = dataRow.createCell(4); timecell.setCellValue(rs.getString("time"));
            Cell notecell = dataRow.createCell(5); notecell.setCellValue(rs.getString("note"));
            Cell c50cell = dataRow.createCell(6); c50cell.setCellValue(rs.getString("count50"));
            Cell c100cell = dataRow.createCell(7); c100cell.setCellValue(rs.getString("count100"));
            Cell c150cell = dataRow.createCell(8); c150cell.setCellValue(rs.getString("count150"));
            Cell c200cell = dataRow.createCell(9); c200cell.setCellValue(rs.getString("count200"));
            Cell c250cell = dataRow.createCell(10); c250cell.setCellValue(rs.getString("count250"));
            Cell c300cell = dataRow.createCell(11); c300cell.setCellValue(rs.getString("count300"));
            Cell c400cell = dataRow.createCell(12); c400cell.setCellValue(rs.getString("count400"));
            Cell c500cell = dataRow.createCell(13); c500cell.setCellValue(rs.getString("count500"));
            Cell c700cell = dataRow.createCell(14); c700cell.setCellValue(rs.getString("count700"));
            Cell c1000cell = dataRow.createCell(15); c1000cell.setCellValue(rs.getString("count1000"));
                row = row + 1;
            }


            FileOutputStream fileOut = new FileOutputStream(outputDirPath);
            wb.write(fileOut);
            fileOut.close();
            JOptionPane.showMessageDialog(null, "The Specimens list was exported to " + outputDirPath);
            } catch(Exception e){JOptionPane.showMessageDialog(null, e);}
        
    }else {return;}
        
    }//GEN-LAST:event_cmd_exportActionPerformed

    private void cmd_exportcsvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_exportcsvActionPerformed
    String tmp =(String)txt_locality.getText().toUpperCase(); //get locality
    
    JFileChooser chooser = new JFileChooser();
    chooser.setDialogTitle("Export specimen "+tmp+" to .csv file");
    int retval = chooser.showSaveDialog(null);
    File f = chooser.getSelectedFile();
    String outputDirPath=f.getAbsolutePath();

    if (retval==JFileChooser.APPROVE_OPTION){
    if(f.exists()) {
        int p =JOptionPane.showConfirmDialog(null, "File is existed! Do you want to over write?", "Delete", JOptionPane.YES_NO_OPTION);
        if (p==1){
        return;
        }
    }
        try{
        FileWriter fw = new FileWriter(outputDirPath);
        String sql = " SELECT * FROM 'Speciemen' WHERE 'speciemen'.LocalityID = '"+tmp+"' ORDER BY 'Speciemen'.specimentid ";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery(); 

        while(rs.next()) {
            fw.append('"'); fw.append(rs.getString("SpecimentID")); fw.append('"'); fw.append(',');
            fw.append('"');fw.append(rs.getString("SpecieID"));fw.append('"'); fw.append(',');
            fw.append('"');fw.append(rs.getString("LocalityID"));fw.append('"'); fw.append(',');
            fw.append('"');fw.append(rs.getString("Time"));fw.append('"'); fw.append(',');
            fw.append('"');fw.append(rs.getString("Note"));fw.append('"'); fw.append(',');
            fw.append('"');fw.append(rs.getString("count50"));fw.append('"'); fw.append(',');
            fw.append('"');fw.append(rs.getString("count100"));fw.append('"'); fw.append(',');
            fw.append('"');fw.append(rs.getString("count150"));fw.append('"'); fw.append(',');
            fw.append('"');fw.append(rs.getString("count200"));fw.append('"'); fw.append(',');
            fw.append('"');fw.append(rs.getString("count250"));fw.append('"'); fw.append(',');
            fw.append('"');fw.append(rs.getString("count300"));fw.append('"'); fw.append(',');
            fw.append('"');fw.append(rs.getString("count400"));fw.append('"'); fw.append(',');
            fw.append('"');fw.append(rs.getString("count500"));fw.append('"'); fw.append(',');
            fw.append('"');fw.append(rs.getString("count700"));fw.append('"'); fw.append(',');
            fw.append('"');fw.append(rs.getString("count1000"));fw.append('"'); fw.append('\n');
        }
        fw.flush();
        fw.close();

        JOptionPane.showMessageDialog(null, "Table Speciemen was exported to " + outputDirPath);
        } catch(Exception e){JOptionPane.showMessageDialog(null, e);}
        finally {try {rs.close();pst.close();}catch (Exception e){}}

    }
    Update_table();
    }//GEN-LAST:event_cmd_exportcsvActionPerformed

    private void cmd_importActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_importActionPerformed
    int p =JOptionPane.showConfirmDialog(null, "Do you want to IMPORT data to Specimen?", "Import Specimen", JOptionPane.YES_NO_OPTION);
    if (p==0){
    try{
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        String filename1 = f.getAbsolutePath();

        BufferedReader br = new BufferedReader(new FileReader(filename1));
        String line;

        while((line = br.readLine())!=null){
        line = line.substring(1, line.length() - 1);
        line=line.replace("null", "0");
        String[]value=line.split("\",\""); //seperator
        String sql = "INSERT INTO 'Speciemen' (SpecimentID, SpecieID, LocalityID, Time, Note, count50, count100, count150, count200, count250, count300, count400, count500, count700, count1000) "
                + "values ('"+value[0]+"', '"+value[1]+"', '"+value[2]+"', '"+value[3]+"', '"+value[4]+"', '"+value[5]+"', '"+value[6]+"', '"+value[7]+"', '"+value[8]+"', '"+value[9]+"', '"+value[10]+"', '"+value[11]+"', '"+value[12]+"', '"+value[13]+"', '"+value[14]+"')";
        pst=conn.prepareStatement(sql);
        pst.executeUpdate();
        }
        br.close();
    }catch(Exception e){JOptionPane.showMessageDialog(null, e);}
            finally {try {rs.close();pst.close();}catch (Exception e){}}
    }

    Update_table();
    }//GEN-LAST:event_cmd_importActionPerformed

    private void cmd_deleteallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_deleteallActionPerformed
    String tmp =(String)txt_locality.getText().toUpperCase();
    int p =JOptionPane.showConfirmDialog(null, "Do you want to DELETE ALL data in" + tmp+"?", "Delete All Specimens", JOptionPane.YES_NO_OPTION);
    if (p==0){
    try{
        
        String sql="DELETE FROM 'Speciemen' WHERE 'speciemen'.LocalityID = '"+tmp+"'";
        pst=conn.prepareStatement(sql);
        pst.execute();
    }catch(Exception e){JOptionPane.showMessageDialog(null, e);}
            finally {try {rs.close();pst.close();}catch (Exception e){}}
    }

    Update_table();
    }//GEN-LAST:event_cmd_deleteallActionPerformed

    private void cmd_exportxlsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_exportxlsActionPerformed

    JFileChooser chooser = new JFileChooser();
    chooser.setDialogTitle("Export all Specimens to .xls file");
    int retval = chooser.showSaveDialog(null);
    File f = chooser.getSelectedFile();
    String outputDirPath=f.getAbsolutePath();
    
    if (retval==JFileChooser.APPROVE_OPTION){
        if(f.exists()) {
            int p =JOptionPane.showConfirmDialog(null, "File are exist! Do you want to over write?", "Over-write", JOptionPane.YES_NO_OPTION);
            if (p==1){
            return;
            }
        }

            Workbook wb = new HSSFWorkbook();
            Sheet personSheet = wb.createSheet("Specimens");

            Row titlerow = personSheet.createRow(0);
            Cell nametitle = titlerow.createCell(0);
            nametitle.setCellValue("Specimens Information");

            Row headerRow = personSheet.createRow(1);
                Cell specimenid = headerRow.createCell(0); specimenid.setCellValue("Specimen ID");
                Cell speciesid = headerRow.createCell(1); speciesid.setCellValue("Species ID");
                Cell speciesname = headerRow.createCell(2); speciesname.setCellValue("Species Name");
                Cell localityid = headerRow.createCell(3); localityid.setCellValue("Locality ID");
                Cell time = headerRow.createCell(4); time.setCellValue("Time");
                Cell note = headerRow.createCell(5); note.setCellValue("Note");
                Cell c50 = headerRow.createCell(6); c50.setCellValue("Count50");
                Cell c100 = headerRow.createCell(7); c100.setCellValue("Count100");
                Cell c150 = headerRow.createCell(8); c150.setCellValue("Count150");
                Cell c200 = headerRow.createCell(9); c200.setCellValue("Count200");
                Cell c250 = headerRow.createCell(10); c250.setCellValue("Count250");
                Cell c300 = headerRow.createCell(11); c300.setCellValue("Count300");
                Cell c400 = headerRow.createCell(12); c400.setCellValue("Count400");
                Cell c500 = headerRow.createCell(13); c500.setCellValue("Count500");
                Cell c700 = headerRow.createCell(14); c700.setCellValue("Count700");
                Cell c1000 = headerRow.createCell(15); c1000.setCellValue("Count1000");

            try{
            String sql = "SELECT 'Speciemen'.specimentid, 'Speciemen'.specieid, 'Species'.spname, 'Speciemen'.localityid, "
                    + "'Speciemen'.time, 'Speciemen'.note, 'Speciemen'.count50, 'Speciemen'.count100, "
                    + "'Speciemen'.count150, 'Speciemen'.count200, 'Speciemen'.count250, 'Speciemen'.count300, "
                    + "'Speciemen'.count400, 'Speciemen'.count500, 'Speciemen'.count700, 'Speciemen'.count1000 FROM 'Speciemen'  "
                    + "INNER JOIN 'Species' On 'Speciemen'.specieid = 'Species'.speciesid ORDER BY 'Speciemen'.specimentid, 'Species'.spname ";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery(); 

            int row = 2;
            while(rs.next()) {
                Row dataRow = personSheet.createRow(row);
                
            Cell specimenidcell = dataRow.createCell(0); specimenidcell.setCellValue(rs.getString("SpecimentID"));
            Cell speciesidcell = dataRow.createCell(1); speciesidcell.setCellValue(rs.getString("specieid"));
            Cell speciesnamecell = dataRow.createCell(2); speciesnamecell.setCellValue(rs.getString("spname"));
            Cell localityidcell = dataRow.createCell(3); localityidcell.setCellValue(rs.getString("localityid"));
            Cell timecell = dataRow.createCell(4); timecell.setCellValue(rs.getString("time"));
            Cell notecell = dataRow.createCell(5); notecell.setCellValue(rs.getString("note"));
            Cell c50cell = dataRow.createCell(6); c50cell.setCellValue(rs.getString("count50"));
            Cell c100cell = dataRow.createCell(7); c100cell.setCellValue(rs.getString("count100"));
            Cell c150cell = dataRow.createCell(8); c150cell.setCellValue(rs.getString("count150"));
            Cell c200cell = dataRow.createCell(9); c200cell.setCellValue(rs.getString("count200"));
            Cell c250cell = dataRow.createCell(10); c250cell.setCellValue(rs.getString("count250"));
            Cell c300cell = dataRow.createCell(11); c300cell.setCellValue(rs.getString("count300"));
            Cell c400cell = dataRow.createCell(12); c400cell.setCellValue(rs.getString("count400"));
            Cell c500cell = dataRow.createCell(13); c500cell.setCellValue(rs.getString("count500"));
            Cell c700cell = dataRow.createCell(14); c700cell.setCellValue(rs.getString("count700"));
            Cell c1000cell = dataRow.createCell(15); c1000cell.setCellValue(rs.getString("count1000"));
                row = row + 1;
            }


            FileOutputStream fileOut = new FileOutputStream(outputDirPath);
            wb.write(fileOut);
            fileOut.close();
            JOptionPane.showMessageDialog(null, "The Specimens list was exported to " + outputDirPath);
            } catch(Exception e){JOptionPane.showMessageDialog(null, e);}
        
    }else {return;}
    }//GEN-LAST:event_cmd_exportxlsActionPerformed

    private void cmd_exportallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_exportallActionPerformed
   
    JFileChooser chooser = new JFileChooser();
    chooser.setDialogTitle("Export all specimen to .csv file");
    int retval = chooser.showSaveDialog(null);
    File f = chooser.getSelectedFile();
    String outputDirPath=f.getAbsolutePath();

    if (retval==JFileChooser.APPROVE_OPTION){
    if(f.exists()) {
        int p =JOptionPane.showConfirmDialog(null, "File is existed! Do you want to over write?", "Over-write", JOptionPane.YES_NO_OPTION);
        if (p==1){
        return;
        }
    }
        try{
        FileWriter fw = new FileWriter(outputDirPath);
        String sql = " SELECT * FROM 'Speciemen' ORDER BY 'Speciemen'.specimentid ";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery(); 

        while(rs.next()) {
            fw.append('"'); fw.append(rs.getString("SpecimentID")); fw.append('"'); fw.append(',');
            fw.append('"');fw.append(rs.getString("SpecieID"));fw.append('"'); fw.append(',');
            fw.append('"');fw.append(rs.getString("LocalityID"));fw.append('"'); fw.append(',');
            fw.append('"');fw.append(rs.getString("Time"));fw.append('"'); fw.append(',');
            fw.append('"');fw.append(rs.getString("Note"));fw.append('"'); fw.append(',');
            fw.append('"');fw.append(rs.getString("count50"));fw.append('"'); fw.append(',');
            fw.append('"');fw.append(rs.getString("count100"));fw.append('"'); fw.append(',');
            fw.append('"');fw.append(rs.getString("count150"));fw.append('"'); fw.append(',');
            fw.append('"');fw.append(rs.getString("count200"));fw.append('"'); fw.append(',');
            fw.append('"');fw.append(rs.getString("count250"));fw.append('"'); fw.append(',');
            fw.append('"');fw.append(rs.getString("count300"));fw.append('"'); fw.append(',');
            fw.append('"');fw.append(rs.getString("count400"));fw.append('"'); fw.append(',');
            fw.append('"');fw.append(rs.getString("count500"));fw.append('"'); fw.append(',');
            fw.append('"');fw.append(rs.getString("count700"));fw.append('"'); fw.append(',');
            fw.append('"');fw.append(rs.getString("count1000"));fw.append('"'); fw.append('\n');
        }
        fw.flush();
        fw.close();

        JOptionPane.showMessageDialog(null, "Table Speciemen was exported to " + outputDirPath);
        } catch(Exception e){JOptionPane.showMessageDialog(null, e);}
        finally {try {rs.close();pst.close();}catch (Exception e){}}

    }
    Update_table();
    }//GEN-LAST:event_cmd_exportallActionPerformed

    private void cmd_importallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_importallActionPerformed
    int p =JOptionPane.showConfirmDialog(null, "Do you want to IMPORT data to Specimen?", "Import Specimen", JOptionPane.YES_NO_OPTION);
    if (p==0){
    try{
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        String filename1 = f.getAbsolutePath();

        BufferedReader br = new BufferedReader(new FileReader(filename1));
        String line;

        while((line = br.readLine())!=null){
        line = line.substring(1, line.length() - 1);
        line=line.replace("null", "0");
        String[]value=line.split("\",\""); //seperator
        String sql = "INSERT INTO 'Speciemen' (SpecimentID, SpecieID, LocalityID, Time, Note, count50, count100, count150, count200, count250, count300, count400, count500, count700, count1000) "
                + "values ('"+value[0]+"', '"+value[1]+"', '"+value[2]+"', '"+value[3]+"', '"+value[4]+"', '"+value[5]+"', '"+value[6]+"', '"+value[7]+"', '"+value[8]+"', '"+value[9]+"', '"+value[10]+"', '"+value[11]+"', '"+value[12]+"', '"+value[13]+"', '"+value[14]+"')";
        pst=conn.prepareStatement(sql);
        pst.executeUpdate();
        }
        br.close();
    }catch(Exception e){JOptionPane.showMessageDialog(null, e);}
            finally {try {rs.close();pst.close();}catch (Exception e){}}
    }

    Update_table();
    }//GEN-LAST:event_cmd_importallActionPerformed

    private void cmd_deletealltableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_deletealltableActionPerformed
    
    int p =JOptionPane.showConfirmDialog(null, "Do you want to DELETE ALL data in Species table?", "Delete All Specimens", JOptionPane.YES_NO_OPTION);
    if (p==0){
    try{
        
        String sql="DELETE FROM 'Speciemen'";
        pst=conn.prepareStatement(sql);
        pst.execute();
    }catch(Exception e){JOptionPane.showMessageDialog(null, e);}
            finally {try {rs.close();pst.close();}catch (Exception e){}}
    }

    Update_table();
    }//GEN-LAST:event_cmd_deletealltableActionPerformed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        //JOptionPane.showMessageDialog(null, "Click to get time");
        SimpleDateFormat sdfDate = new SimpleDateFormat("MM/dd/yyyy");//dd/MM/yyyy
        Date now = new Date();
        String strDate = sdfDate.format(now);
        txt_time.setText(strDate);
        
    }//GEN-LAST:event_jLabel8MouseClicked

    private void combo_spnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_combo_spnameFocusLost

    }//GEN-LAST:event_combo_spnameFocusLost

    private void combo_spnamePopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_combo_spnamePopupMenuWillBecomeInvisible
        String temp= (String)combo_spname.getSelectedItem();
        //kiem tra neu locality chua ton tai thi hoi xem co them locality khong
        if(temp.isEmpty()){return;}
        String check = "SELECT count(spname) FROM Species WHERE spname = '"+temp+"'";
        try{
        pst=conn.prepareStatement(check);
        rs=pst.executeQuery();
        if (rs.next()){
            final int count = rs.getInt(1);
            if (count < 1){
                int p =JOptionPane.showConfirmDialog(null, "The Species not Exist! Do you want to add new Species?", "Delete", JOptionPane.YES_NO_OPTION);
                if (p==0){
                     new Species_list_frame().setVisible(true);
                }
            }
        }
        }catch (Exception e){JOptionPane.showMessageDialog(null, e);
            }finally {try {rs.close();pst.close();}catch (Exception e){}}
        
    //gan species id toi txt   
    try{    
        String sql="SELECT * FROM Species WHERE species.spname ='"+temp+"' ";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            
            if(rs.next()){
                String add1 =rs.getString("speciesID");
                txt_spid.setText(add1);
            }
        }catch(Exception e){ JOptionPane.showMessageDialog(null, e);}
            finally { try { rs.close(); pst.close();}catch (Exception e){  } }
    }//GEN-LAST:event_combo_spnamePopupMenuWillBecomeInvisible

    private void combo_spnameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combo_spnameKeyReleased

    }//GEN-LAST:event_combo_spnameKeyReleased

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
            java.util.logging.Logger.getLogger(Userino_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Userino_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Userino_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Userino_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Userino_frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmd_addnew;
    private javax.swing.JMenuItem cmd_copy;
    private javax.swing.JButton cmd_countind;
    private javax.swing.JMenuItem cmd_cut;
    private javax.swing.JButton cmd_delete;
    private javax.swing.JMenuItem cmd_deleteall;
    private javax.swing.JMenuItem cmd_deletealltable;
    private javax.swing.JMenuItem cmd_export;
    private javax.swing.JMenuItem cmd_exportall;
    private javax.swing.JMenuItem cmd_exportcsv;
    private javax.swing.JMenuItem cmd_exportxls;
    private javax.swing.JMenuItem cmd_import;
    private javax.swing.JMenuItem cmd_importall;
    private javax.swing.JMenuItem cmd_paste;
    private javax.swing.JMenuItem cmd_redo;
    private javax.swing.JButton cmd_save;
    private javax.swing.JButton cmd_setzero;
    private javax.swing.JMenuItem cmd_undo;
    private javax.swing.JButton cmd_update;
    private javax.swing.JComboBox combo_spname;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JTable table_specimen;
    private javax.swing.JTextField txt_count100;
    private javax.swing.JTextField txt_count1000;
    private javax.swing.JTextField txt_count150;
    private javax.swing.JTextField txt_count200;
    private javax.swing.JTextField txt_count250;
    private javax.swing.JTextField txt_count300;
    private javax.swing.JTextField txt_count400;
    private javax.swing.JTextField txt_count50;
    private javax.swing.JTextField txt_count500;
    private javax.swing.JTextField txt_count700;
    private javax.swing.JTextField txt_locality;
    private javax.swing.JTextField txt_localityid;
    private javax.swing.JTextField txt_location;
    private javax.swing.JTextField txt_nosp;
    private javax.swing.JTextArea txt_note;
    private javax.swing.JTextField txt_speId;
    private javax.swing.JTextField txt_spid;
    private javax.swing.JTextField txt_spname2;
    private javax.swing.JTextField txt_sum;
    private javax.swing.JTextField txt_sum100;
    private javax.swing.JTextField txt_sum1000;
    private javax.swing.JTextField txt_sum150;
    private javax.swing.JTextField txt_sum200;
    private javax.swing.JTextField txt_sum250;
    private javax.swing.JTextField txt_sum300;
    private javax.swing.JTextField txt_sum400;
    private javax.swing.JTextField txt_sum500;
    private javax.swing.JTextField txt_sum700;
    private javax.swing.JTextField txt_time;
    // End of variables declaration//GEN-END:variables

    
    /// txt complete
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
}
