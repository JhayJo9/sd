/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.login_form;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.table.JTableHeader;

/**
 *
 * @author JhayJTheGosu
 */
public class MainForm extends javax.swing.JFrame {
    String path;
    String path2;
    int userClick;
    int userSelectedRow;
    // DATABASE
    Connection conmain = null;
    PreparedStatement pstmain = null;
    ResultSet rs = null;
    /**
     * Creates new form MainForm
     */
    public MainForm() {
        initComponents();
        
        // jframe bg color
        Color kulay = new Color(67,118,108);
        getContentPane().setBackground(kulay);
        
        JTableHeader table = jTable1.getTableHeader();
        table.setFont(new Font("Roboto Ligth", Font.PLAIN, 14));
        
        // disable the textbox
        txt_studno.setEnabled(false);
        txt_last.setEnabled(false);
        txt_first.setEnabled(false);
        txt_middle.setEnabled(false);
        txt_add.setEnabled(false);
        txt_bday.setEnabled(false);
        jc_dept.setEnabled(false);
        jc_course.setEnabled(false);
        
        btn_AddUp.setEnabled(false);
        btn_save.setEnabled(false);
        btn_update.setEnabled(false);
    }
      public void tableupdate(){
        // 
        jTable1.getTableHeader().setResizingAllowed(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        int c;
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            conmain = DriverManager.getConnection("jdbc:ucanaccess://JavaLoginClone.accdb");

            String sql = "SELECT * FROM StudInfoTbl";
            pstmain = conmain.prepareStatement(sql);
            rs = pstmain.executeQuery();
            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();
            DefaultTableModel dft = (DefaultTableModel) jTable1.getModel();
            dft.setRowCount(0);
            while(rs.next()){
                Vector v2 = new Vector();
                for(int i =1; i<=c;i++){
                    v2.add(rs.getString("Student"));
                    v2.add(rs.getString("Last-name"));
                    v2.add(rs.getString("First-name"));
                    v2.add(rs.getString("Middle-name"));
                    v2.add(rs.getString("Address"));
                    v2.add(rs.getString("Birthday"));
                    v2.add(rs.getString("Department"));
                    v2.add(rs.getString("Course"));
                    // image column
                    v2.add(rs.getBlob("StudentProfile"));
                }
                dft.addRow(v2);
            }
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }
     
     public void addnewrecord(){
         btn_delete.setEnabled(false);
        btn_update.setEnabled(false);
        btn_edit.setEnabled(false);
        btn_view.setEnabled(false);
        
        btn_AddUp.setEnabled(true);
        btn_save.setEnabled(true);
        // enable textbox
        txt_studno.setEnabled(true);
        txt_last.setEnabled(true);
        txt_first.setEnabled(true);
        txt_middle.setEnabled(true);
        txt_add.setEnabled(true);
        txt_bday.setEnabled(true);
        jc_dept.setEnabled(true);
        jc_course.setEnabled(true);
        
        // set to empty string
        txt_studno.setText("");
        txt_last.setText("");
        txt_first.setText("");
        txt_middle.setText("");
        txt_add.setText("");
        txt_bday.setText("");
        jc_dept.setSelectedItem("------------Select Department----------");
        txt_studno.requestFocus();
        picture.setIcon(null);
    }
     public void disabletextbox(){
        txt_studno.setEnabled(false);
        txt_last.setEnabled(false);
        txt_first.setEnabled(false);
        txt_middle.setEnabled(false);
        txt_add.setEnabled(false);
        txt_bday.setEnabled(false);
        jc_dept.setEnabled(false);
        jc_course.setEnabled(false);
        
        btn_save.setEnabled(false);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_studno = new javax.swing.JTextField();
        txt_last = new javax.swing.JTextField();
        txt_first = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_middle = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_add = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_bday = new javax.swing.JTextField();
        jc_course = new javax.swing.JComboBox<>();
        picture = new javax.swing.JLabel();
        jc_dept = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        btn_add = new javax.swing.JButton();
        btn_exit = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        btn_save = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        btn_view = new javax.swing.JButton();
        btn_AddUp = new javax.swing.JButton();
        btn_reset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(67, 118, 108));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(979, 613));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(67, 83, 61));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(248, 250, 229));
        jLabel1.setFont(new java.awt.Font("Roboto Medium", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(250, 240, 230));
        jLabel1.setText("STUDENT FORM WITH MS ACCESS ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 820, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 140));

        jTable1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable1.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jTable1.setForeground(new java.awt.Color(53, 48, 68));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Student no.", "Last Name", "First Name", "Middle Name", "Address", "Birthday", "Department", "Course", "Student Profile"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setToolTipText("");
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable1.setGridColor(new java.awt.Color(53, 48, 68));
        jTable1.setShowGrid(true);
        jTable1.setSurrendersFocusOnKeystroke(true);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTable1MouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 940, 190));

        jPanel3.setBackground(new java.awt.Color(67, 118, 108));
        jPanel3.setAutoscrolls(true);
        jPanel3.setPreferredSize(new java.awt.Dimension(1003, 167));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(250, 240, 230));
        jLabel5.setText("Student no.:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 70, -1));

        jLabel6.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(250, 240, 230));
        jLabel6.setText("Last name:");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jLabel7.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(250, 240, 230));
        jLabel7.setText("First name:");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        txt_studno.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        txt_studno.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txt_studno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studnoActionPerformed(evt);
            }
        });
        jPanel3.add(txt_studno, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 240, -1));

        txt_last.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        txt_last.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.add(txt_last, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 240, -1));

        txt_first.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        txt_first.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.add(txt_first, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 240, -1));

        jLabel8.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(250, 240, 230));
        jLabel8.setText("Middle Name:");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        txt_middle.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        txt_middle.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.add(txt_middle, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 240, -1));

        jLabel9.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(250, 240, 230));
        jLabel9.setText("Address");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, -1, -1));

        jLabel10.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(250, 240, 230));
        jLabel10.setText("Birthday:");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, -1, -1));

        txt_add.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        txt_add.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.add(txt_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 288, -1));

        jLabel12.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(250, 240, 230));
        jLabel12.setText("Course:");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, -1, -1));

        jLabel11.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(250, 240, 230));
        jLabel11.setText("Department:");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 100, 70, -1));

        txt_bday.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        txt_bday.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.add(txt_bday, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, 288, -1));

        jc_course.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jc_course.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.add(jc_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, 290, -1));

        picture.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        picture.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        picture.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        picture.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        picture.setPreferredSize(new java.awt.Dimension(170, 149));
        picture.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pictureMouseClicked(evt);
            }
        });
        jPanel3.add(picture, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 10, -1, -1));

        jc_dept.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jc_dept.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "School of Computer Studies", "School of Education", "School of Business Management", "School of Hospitality and Tourism Management", "------------Select Department----------" }));
        jc_dept.setSelectedIndex(4);
        jc_dept.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jc_dept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jc_deptActionPerformed(evt);
            }
        });
        jPanel3.add(jc_dept, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, 290, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 960, 170));

        jPanel2.setBackground(new java.awt.Color(67, 118, 108));
        jPanel2.setForeground(new java.awt.Color(53, 48, 68));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_add.setBackground(new java.awt.Color(0, 169, 255));
        btn_add.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        btn_add.setForeground(new java.awt.Color(250, 240, 230));
        btn_add.setText("Add new record");
        btn_add.setBorder(null);
        btn_add.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_add.setPreferredSize(new java.awt.Dimension(100, 35));
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });
        jPanel2.add(btn_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, -1, -1));

        btn_exit.setBackground(new java.awt.Color(0, 169, 255));
        btn_exit.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        btn_exit.setForeground(new java.awt.Color(250, 240, 230));
        btn_exit.setText("Exit");
        btn_exit.setAutoscrolls(true);
        btn_exit.setBorder(null);
        btn_exit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_exit.setPreferredSize(new java.awt.Dimension(80, 35));
        btn_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exitActionPerformed(evt);
            }
        });
        jPanel2.add(btn_exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 20, -1, -1));

        btn_delete.setBackground(new java.awt.Color(0, 169, 255));
        btn_delete.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        btn_delete.setForeground(new java.awt.Color(250, 240, 230));
        btn_delete.setText("Delete");
        btn_delete.setAutoscrolls(true);
        btn_delete.setBorder(null);
        btn_delete.setBorderPainted(false);
        btn_delete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_delete.setIconTextGap(2);
        btn_delete.setPreferredSize(new java.awt.Dimension(80, 35));
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });
        jPanel2.add(btn_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, -1, -1));

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton4.setText("jButton1");
        jPanel4.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, -1, -1));

        jButton5.setText("jButton1");
        jPanel4.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jButton6.setText("jButton1");
        jPanel4.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, -1, -1));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, 960, 90));

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton7.setText("jButton1");
        jPanel5.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, -1, -1));

        jButton8.setText("jButton1");
        jPanel5.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jButton9.setText("jButton1");
        jPanel5.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, -1, -1));

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton10.setText("jButton1");
        jPanel6.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, -1, -1));

        jButton11.setText("jButton1");
        jPanel6.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jButton12.setText("jButton1");
        jPanel6.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, -1, -1));

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, 960, 90));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, 960, 90));

        btn_save.setBackground(new java.awt.Color(0, 169, 255));
        btn_save.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        btn_save.setForeground(new java.awt.Color(250, 240, 230));
        btn_save.setText("Save");
        btn_save.setAutoscrolls(true);
        btn_save.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_save.setBorderPainted(false);
        btn_save.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_save.setIconTextGap(1);
        btn_save.setPreferredSize(new java.awt.Dimension(80, 35));
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });
        jPanel2.add(btn_save, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, -1));

        btn_update.setBackground(new java.awt.Color(0, 169, 255));
        btn_update.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        btn_update.setForeground(new java.awt.Color(250, 240, 230));
        btn_update.setText("Update");
        btn_update.setAutoscrolls(true);
        btn_update.setBorder(null);
        btn_update.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_update.setPreferredSize(new java.awt.Dimension(80, 35));
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });
        jPanel2.add(btn_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, -1, -1));

        btn_edit.setBackground(new java.awt.Color(0, 169, 255));
        btn_edit.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        btn_edit.setForeground(new java.awt.Color(250, 240, 230));
        btn_edit.setText("Edit ");
        btn_edit.setAutoscrolls(true);
        btn_edit.setBorder(null);
        btn_edit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_edit.setPreferredSize(new java.awt.Dimension(80, 35));
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });
        jPanel2.add(btn_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, -1, -1));

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton16.setText("jButton1");
        jPanel7.add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, -1, -1));

        jButton17.setText("jButton1");
        jPanel7.add(jButton17, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, -1, -1));

        jButton18.setText("jButton1");
        jPanel7.add(jButton18, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, -1, -1));

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton19.setText("jButton1");
        jPanel8.add(jButton19, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, -1, -1));

        jButton20.setText("jButton1");
        jPanel8.add(jButton20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jButton21.setText("jButton1");
        jPanel8.add(jButton21, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, -1, -1));

        jPanel7.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, 960, 90));

        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton22.setText("jButton1");
        jPanel9.add(jButton22, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, -1, -1));

        jButton23.setText("jButton1");
        jPanel9.add(jButton23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jButton24.setText("jButton1");
        jPanel9.add(jButton24, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, -1, -1));

        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton25.setText("jButton1");
        jPanel10.add(jButton25, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, -1, -1));

        jButton26.setText("jButton1");
        jPanel10.add(jButton26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jButton27.setText("jButton1");
        jPanel10.add(jButton27, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, -1, -1));

        jPanel9.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, 960, 90));

        jPanel7.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, 960, 90));

        jButton28.setText("jButton1");
        jPanel7.add(jButton28, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jButton29.setText("jButton1");
        jPanel7.add(jButton29, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, -1, -1));

        jButton30.setText("jButton1");
        jPanel7.add(jButton30, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, -1, -1));

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, 960, 90));

        btn_view.setBackground(new java.awt.Color(0, 169, 255));
        btn_view.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        btn_view.setForeground(new java.awt.Color(250, 240, 230));
        btn_view.setText("View");
        btn_view.setAutoscrolls(true);
        btn_view.setBorder(null);
        btn_view.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_view.setPreferredSize(new java.awt.Dimension(80, 35));
        btn_view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_viewActionPerformed(evt);
            }
        });
        jPanel2.add(btn_view, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 20, -1, -1));

        btn_AddUp.setBackground(new java.awt.Color(0, 169, 255));
        btn_AddUp.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        btn_AddUp.setForeground(new java.awt.Color(250, 240, 230));
        btn_AddUp.setText("Upload image");
        btn_AddUp.setAutoscrolls(true);
        btn_AddUp.setBorder(null);
        btn_AddUp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_AddUp.setPreferredSize(new java.awt.Dimension(100, 35));
        btn_AddUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AddUpActionPerformed(evt);
            }
        });
        jPanel2.add(btn_AddUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 20, -1, -1));

        btn_reset.setBackground(new java.awt.Color(0, 169, 255));
        btn_reset.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        btn_reset.setForeground(new java.awt.Color(250, 240, 230));
        btn_reset.setText("Reset");
        btn_reset.setAutoscrolls(true);
        btn_reset.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_reset.setPreferredSize(new java.awt.Dimension(80, 35));
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });
        jPanel2.add(btn_reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 960, 80));

        setSize(new java.awt.Dimension(960, 579));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
        userSelectedRow = 1;
        
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int selectedIndex = jTable1.getSelectedRow();

        txt_studno.setText(model.getValueAt(selectedIndex, 0).toString());
        txt_last.setText(model.getValueAt(selectedIndex, 1).toString());
        txt_first.setText(model.getValueAt(selectedIndex, 2).toString());
        txt_middle.setText(model.getValueAt(selectedIndex, 3).toString());
        txt_add.setText(model.getValueAt(selectedIndex, 4).toString());
        txt_bday.setText(model.getValueAt(selectedIndex, 5).toString());
        jc_dept.setSelectedItem(model.getValueAt(selectedIndex, 6));
        jc_course.setSelectedItem(model.getValueAt(selectedIndex, 7));

        Blob imageBlob = (Blob) model.getValueAt(selectedIndex, 8);
        byte[] imageBytes;
        try {
            try {
                imageBytes = imageBlob.getBinaryStream().readAllBytes();
                ImageIcon imageIcon = new ImageIcon(imageBytes);
                picture.setIcon(imageIcon);

                //GET THE CURRENT WIDTH AND HEIGHT TO MATCH IN IMAGE
                int labelWidth = picture.getWidth();
                int labelHeight = picture.getHeight();

                Image scaledImage = imageIcon.getImage().getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);
                ImageIcon scaledIcon = new ImageIcon(scaledImage);
                picture.setIcon(scaledIcon);

            } catch (IOException ex) {
                Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (SQLException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jTable1MouseClicked

    private void txt_studnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studnoActionPerformed

    private void pictureMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pictureMouseClicked

        // TODO add your handling code here:
    }//GEN-LAST:event_pictureMouseClicked

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
         System.out.println("fggf");

        if(txt_studno.getText().equals("") || txt_last.getText().equals("") || txt_first.getText().equals("") || txt_middle.getText().equals("") || txt_add.getText().equals("")
            || txt_bday.getText().equals("") || jc_dept.getSelectedItem().equals("------------Select Department----------") || jc_course.getSelectedItem().equals("") || path2 == null){
            JOptionPane.showMessageDialog(rootPane, "Please enter requeried fields or image not found");
        }
        else {

            try {
                String urlmain = "jdbc:ucanaccess://JavaLoginClone.accdb";
                conmain = DriverManager.getConnection(urlmain);
                String studentNumber, lastName, firstName, middleName, address, birthDate, department, course;

                studentNumber = txt_studno.getText();
                lastName = txt_last.getText();
                firstName = txt_first.getText();
                middleName = txt_middle.getText();
                address = txt_add.getText();
                birthDate = txt_bday.getText();
                department = (String) jc_dept.getSelectedItem();
                course = (String) jc_course.getSelectedItem();
                try{
                    InputStream s = new FileInputStream(new File(path));

                    String sql = "INSERT into StudInfoTbl([Student], [LAST-NAME], [FIRST-NAME], [MIDDLE-NAME], Address, Birthday, Department, Course, StudentProfile) VALUES (?, ?, ?, ?, ?, ?, ?, ?,?)";
                    pstmain = conmain.prepareStatement(sql);

                    System.out.println(studentNumber);
                    System.out.println(lastName);
                    System.out.println(firstName);
                    System.out.println(middleName);
                    System.out.println(address);
                    System.out.println(birthDate);
                    System.out.println(department);
                    System.out.println(course);
                    System.out.println(s);

                    pstmain.setString(1, studentNumber);   // STUD-NO
                    pstmain.setString(2, lastName);        // LAST-NAME
                    pstmain.setString(3, firstName);       // FIRST-NAME
                    pstmain.setString(4, middleName);      // MIDDLE-NAME
                    pstmain.setString(5, address);         // Address
                    pstmain.setString(6, birthDate);       // Birthday
                    pstmain.setString(7, department);      // Department
                    pstmain.setString(8, course);          // Course
                    pstmain.setBlob(9, s);
                    pstmain.executeUpdate();
                    JOptionPane.showMessageDialog(rootPane, "Inserted Successfully!");

                    // set to empty string
                    txt_studno.setText("");
                    txt_last.setText("");
                    txt_first.setText("");
                    txt_middle.setText("");
                    txt_add.setText("");
                    txt_bday.setText("");
                    jc_dept.setSelectedItem("------------Select Department----------");
                    txt_studno.requestFocus();
                    picture.setIcon(null);

                    tableupdate();
                    // disable the textbox
                    disabletextbox();
                    btn_save.setEnabled(false);
                    btn_AddUp.setEnabled(false);

                    btn_delete.setEnabled(true);
                    btn_edit.setEnabled(true);
                    btn_view.setEnabled(true);
                }catch(HeadlessException | FileNotFoundException | SQLException e){
                    System.out.println("Error in query " + e);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "The student id is already given");
            }

        }
    }//GEN-LAST:event_btn_saveActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
       userClick = 2;
        btn_AddUp.setText("Update Image");
        if(jTable1.getSelectedRowCount() == 0){
            JOptionPane.showMessageDialog(null, "Please select you want to edit");
        }
        else if (jTable1.getSelectedRowCount() > 1){
             JOptionPane.showMessageDialog(null, "Please select only one record");
        }
        else {
             txt_studno.setEnabled(false);
        txt_last.setEnabled(true);
        txt_first.setEnabled(true);
        txt_middle.setEnabled(true);
        txt_add.setEnabled(true);
        txt_bday.setEnabled(true);
        jc_dept.setEnabled(true);
        jc_course.setEnabled(true);


        btn_save.setEnabled(false);
        btn_delete.setEnabled(false);
        btn_add.setEnabled(false);
        btn_AddUp.setEnabled(true);
        btn_update.setEnabled(true);
        }
       
        
    }//GEN-LAST:event_btn_editActionPerformed
     public void UpdateImage(){
        Connection conUpdate = null;
        PreparedStatement pstUpdate = null;
        ResultSet rsUpdate = null;
         try {
      String urlmain = "jdbc:ucanaccess://JavaLoginClone.accdb";
      conUpdate = DriverManager.getConnection(urlmain);

      String studentNumber = txt_studno.getText();

      // Choose a file for the new image
      JFileChooser fileChooser = new JFileChooser();
      fileChooser.setDialogTitle("Choose Image File");
      fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

      if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
        File selectedFile = fileChooser.getSelectedFile();
        InputStream imageStream = new FileInputStream(selectedFile);

        // UPDATE FOR IMAGE COLUMN
        String sql = "UPDATE StudInfoTbl SET `Student`=?, StudentProfile=? WHERE `Student`=?";
        pstUpdate = conUpdate.prepareStatement(sql);

        // PARAMETER FOR IMAGE COLUMN AND CONDITION FOR PRIMARY KEY
        pstUpdate.setString(1, studentNumber);
        pstUpdate.setBinaryStream(2, imageStream); // PASSING DATA
        pstUpdate.setString(3, studentNumber); // WHERE condition

         int k = JOptionPane.showConfirmDialog(rootPane, "Confirm to Update?", "Update", JOptionPane.YES_NO_OPTION);
            if (k == JOptionPane.YES_OPTION) {
          pstUpdate.executeUpdate();
          JOptionPane.showMessageDialog(rootPane, "Updated Successfully!");
        
          txt_studno.setText("");
          txt_last.setText("");
          txt_first.setText("");
          txt_middle.setText("");
          txt_add.setText("");
          txt_bday.setText("");
          jc_dept.setSelectedItem("------------Select Department----------");
          jc_course.removeAllItems();
          picture.setIcon(null);
          txt_studno.requestFocus();
          disabletextbox();
                    
          btn_delete.setEnabled(true);
          btn_add.setEnabled(true);
       
        btn_AddUp.setEnabled(false);
        btn_save.setEnabled(false);
        btn_update.setEnabled(false);
         tableupdate();
        }else {
                JOptionPane.showMessageDialog(null, "Data not updated");
            }
      }
    } catch (HeadlessException | FileNotFoundException | SQLException e) {
      System.out.println("UPDATE : "+e);
    }
    }
   
   public void UploadImage(){
        JFileChooser imagePicked = new JFileChooser();
        imagePicked.showOpenDialog(null);
        File file = imagePicked.getSelectedFile();
        path = file.getAbsolutePath();
        try{
            BufferedImage Bimage = ImageIO.read(new File(path));
            Image img = Bimage.getScaledInstance(149, 170, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(img);
            picture.setIcon(icon);
            path2 = path;
        }catch(IOException e){
            System.out.println(e);
        }
   }
    private void btn_AddUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AddUpActionPerformed
       switch (userClick) {
            case 2 -> { //WHEN UPDATE BTN IS CLICKED
                btn_AddUp.setText("Update Image");
                UpdateImage();
            }
            case 1 -> { // WHEN ADD BTN IS CLICKED
                btn_AddUp.setText("Upload Image");
                UploadImage();

            }
            default -> {
            }
        }
    }//GEN-LAST:event_btn_AddUpActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        tableupdate();
    }//GEN-LAST:event_formWindowActivated

    private void jc_deptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jc_deptActionPerformed
        if(jc_dept.getSelectedItem().equals("School of Computer Studies")){
            jc_course.removeAllItems();
            jc_course.addItem("BS. Information Technology");
            jc_course.addItem("BS. Computer Science");
        }
        else if(jc_dept.getSelectedItem().equals("School of Business Management")){
            jc_course.removeAllItems();
            jc_course.addItem("BS. Marketing Management");
            jc_course.addItem("BS. Human Resources and Development");
            jc_course.addItem("BS. Office administration");
        }
        else if(jc_dept.getSelectedItem().equals("School of Hospitality and Tourism Management")){
            jc_course.removeAllItems();
            jc_course.addItem("BS. in Hotel Management");
            jc_course.addItem("BS. in Tourism Management");
        }
        else if(jc_dept.getSelectedItem().equals("School of Education")){
            jc_course.removeAllItems();
            jc_course.addItem("B.S.E Major in English");
            jc_course.addItem("B.S.E Major in Mathematics");
            jc_course.addItem("B.S.E Major in Social Studies");
            jc_course.addItem("B.S.E Major in Filipino");
        }
        else if(jc_dept.getSelectedItem().equals("------------Select Department----------")){
            jc_course.removeAllItems();
        }
    }//GEN-LAST:event_jc_deptActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
         
       if(jTable1.getSelectedRowCount() == 0){
            JOptionPane.showMessageDialog(null, "Please select you want to delete");
        }
        else if (jTable1.getSelectedRowCount() > 1){
             JOptionPane.showMessageDialog(null, "Please select only one record");
        }
        else {
            if(jTable1.getSelectedRowCount() == 1){
                try {
                    String urlmain = "jdbc:ucanaccess://JavaLoginClone.accdb";
                    conmain = DriverManager.getConnection(urlmain);
                    String sql = "DELETE FROM StudInfoTbl WHERE Student = ?";
                    pstmain = conmain.prepareStatement(sql);
                    int confirmed = JOptionPane.showConfirmDialog(null,"Do you want to delete?", "Question" , JOptionPane.YES_NO_OPTION);
                    if(confirmed == JOptionPane.YES_OPTION){ // check if the user click the ( YES )
                        pstmain.setString(1, txt_studno.getText());   // STUD-NO
                        pstmain.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Recored Deleted");
                        
                        txt_studno.setText("");
                        txt_last.setText("");
                        txt_first.setText("");
                        txt_middle.setText("");
                        txt_add.setText("");
                        txt_bday.setText("");
                        jc_dept.setSelectedItem("------------Select Department----------");
                        picture.setIcon(null);
                        txt_studno.requestFocus();
                    }
                    else{
                        txt_studno.setText("");
                        txt_last.setText("");
                        txt_first.setText("");
                        txt_middle.setText("");
                        txt_add.setText("");
                        txt_bday.setText("");
                        jc_dept.setSelectedItem("------------Select Department----------");
                        picture.setIcon(null);
                        txt_studno.requestFocus();
                    }
                }catch(HeadlessException | SQLException e){
                    System.out.println(e);
                }
            }
        }
        userSelectedRow = 0;
        
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        // btn_save.setEnabled(true);
        btn_AddUp.setText("Add Image");
        userClick = 1;
        addnewrecord();
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
       
        if(jTable1.getSelectedRowCount() == 0){
            JOptionPane.showMessageDialog(null, "Please select you want to update");
        }
        else if (jTable1.getSelectedRowCount() > 1){
             JOptionPane.showMessageDialog(null, "Please select only one record");
        }
        else {
             try {
            String urlmain = "jdbc:ucanaccess://JavaLoginClone.accdb";
            conmain = DriverManager.getConnection(urlmain);
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            int selectedRow = jTable1.getSelectedRow();
            String id = model.getValueAt(selectedRow, 0).toString();

            String studentNumber, lastName, firstName, middleName, address, birthDate, department, course;
            studentNumber = txt_studno.getText();
            lastName = txt_last.getText();
            firstName = txt_first.getText();
            middleName = txt_middle.getText();
            address = txt_add.getText();
            birthDate = txt_bday.getText();
            department = jc_dept.getSelectedItem().toString();
            course = jc_course.getSelectedItem().toString();

            // Update the SQL statement to include the image column
            String sql = "UPDATE StudInfoTbl SET `Student`=?, `Last-name`=?, `First-name`=?, `Middle-name`=?, Address=?, Birthday=?, Department=?, Course=? WHERE `Student`=?";
            pstmain = conmain.prepareStatement(sql);

            // Set values in the prepared statement
            pstmain.setString(1, studentNumber);
            pstmain.setString(2, lastName);
            pstmain.setString(3, firstName);
            pstmain.setString(4, middleName);
            pstmain.setString(5, address);
            pstmain.setString(6, birthDate);
            pstmain.setString(7, department);
            pstmain.setString(8, course);
            pstmain.setString(9, id);
            //UploadImage();
            int k = JOptionPane.showConfirmDialog(rootPane, "Confirm to Update?", "Update", JOptionPane.YES_NO_OPTION);
            if (k == JOptionPane.YES_OPTION) {
                pstmain.executeUpdate();
                JOptionPane.showMessageDialog(rootPane, "Updated Successfully!");
                txt_studno.setText("");
                txt_last.setText("");
                txt_first.setText("");
                txt_middle.setText("");
                txt_add.setText("");
                txt_bday.setText("");
                jc_dept.setSelectedItem("------------Select Department----------");
                picture.setIcon(null);
                txt_studno.requestFocus();
                userSelectedRow = 0;
                disabletextbox();

                btn_save.setEnabled(false);
                btn_update.setEnabled(false);

                btn_delete.setEnabled(true);
                btn_add.setEnabled(true);
                btn_AddUp.setEnabled(false);
                tableupdate();
                
               
            } else {
                JOptionPane.showMessageDialog(rootPane, "Data not Updated!");
            }

        } catch (HeadlessException | SQLException e) {
            System.out.println(e);
        }
        }
        
       
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_viewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_viewActionPerformed
       
        if(jTable1.getSelectedRowCount() == 0){
            JOptionPane.showMessageDialog(null, "Please select you want to view");
        }
        else if (jTable1.getSelectedRowCount() > 1){
             JOptionPane.showMessageDialog(null, "Please select only one record");
        }
        else {
            DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        int selectedIndex = jTable1.getSelectedRow();

        txt_studno.setText(model.getValueAt(selectedIndex, 0).toString());
        txt_last.setText(model.getValueAt(selectedIndex, 1).toString());
        txt_first.setText(model.getValueAt(selectedIndex, 2).toString());
        txt_middle.setText(model.getValueAt(selectedIndex, 3).toString());
        txt_add.setText(model.getValueAt(selectedIndex, 4).toString());
        txt_bday.setText(model.getValueAt(selectedIndex, 5).toString());
        jc_dept.setSelectedItem(model.getValueAt(selectedIndex, 6));
        jc_course.setSelectedItem(model.getValueAt(selectedIndex, 7));

        String studentNumber, lastName, firstName, middleName, address, birthDate, department, course;

        studentNumber = model.getValueAt(selectedIndex, 0).toString();
        lastName = model.getValueAt(selectedIndex, 1).toString();
        firstName = model.getValueAt(selectedIndex, 2).toString();
        middleName = model.getValueAt(selectedIndex, 3).toString();
        address = model.getValueAt(selectedIndex, 4).toString();
        birthDate = model.getValueAt(selectedIndex, 5).toString();
        department = model.getValueAt(selectedIndex, 6).toString();
        course = model.getValueAt(selectedIndex, 7).toString();
         Blob imageBlob = (Blob) model.getValueAt(selectedIndex, 8);
        byte[] imageBytes;
        try {
            ImageIcon imgIcon = null;
            try {
                imageBytes = imageBlob.getBinaryStream().readAllBytes();
                imgIcon = new ImageIcon(imageBytes);
                picture.setIcon(imgIcon);
                
                //GET THE CURRENT WIDTH AND HEIGHT TO MATCH IN IMAGE
                int labelWidth = picture.getWidth();
                int labelHeight = picture.getHeight();
                
                Image scaledImage = imgIcon.getImage().getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);
                ImageIcon scaledIcon = new ImageIcon(scaledImage);
                picture.setIcon(scaledIcon);
                viewform vf = new viewform();
                vf.getInfo(studentNumber, lastName, firstName, middleName, address, birthDate, department, course, imgIcon);
                vf.setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        //userSelectedRow = 0;
        
    }//GEN-LAST:event_btn_viewActionPerformed

    private void btn_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exitActionPerformed
        int ask = JOptionPane.showConfirmDialog(null ,"Do you want to exit?", "Exit", JOptionPane.OK_CANCEL_OPTION);
        if(ask == JOptionPane.YES_NO_OPTION){
            Loginf frame5 = new Loginf();
            frame5.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_btn_exitActionPerformed

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed

        userSelectedRow = 0;
         // disable the textbox
        txt_studno.setEnabled(false);
        txt_last.setEnabled(false);
        txt_first.setEnabled(false);
        txt_middle.setEnabled(false);
        txt_add.setEnabled(false);
        txt_bday.setEnabled(false);
        jc_dept.setEnabled(false);
        jc_course.setEnabled(false);
        
        btn_AddUp.setEnabled(false);
        btn_save.setEnabled(false);
        btn_update.setEnabled(false);
        
        
        btn_delete.setEnabled(true);
        btn_add.setEnabled(true);
        btn_edit.setEnabled(true);
        btn_view.setEnabled(true);
        
        txt_studno.setText("");
        txt_last.setText("");
        txt_first.setText("");
        txt_middle.setText("");
        txt_add.setText("");
        txt_bday.setText("");
        jc_dept.setSelectedItem("------------Select Department----------");
        picture.setIcon(null);
        txt_studno.requestFocus();
    }//GEN-LAST:event_btn_resetActionPerformed

    private void jTable1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseEntered

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
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_AddUp;
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_exit;
    private javax.swing.JButton btn_reset;
    private javax.swing.JButton btn_save;
    private javax.swing.JButton btn_update;
    private javax.swing.JButton btn_view;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> jc_course;
    private javax.swing.JComboBox<String> jc_dept;
    private javax.swing.JLabel picture;
    private javax.swing.JTextField txt_add;
    private javax.swing.JTextField txt_bday;
    private javax.swing.JTextField txt_first;
    private javax.swing.JTextField txt_last;
    private javax.swing.JTextField txt_middle;
    private javax.swing.JTextField txt_studno;
    // End of variables declaration//GEN-END:variables
}
