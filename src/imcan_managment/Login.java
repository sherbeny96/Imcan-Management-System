/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imcan_managment;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

/**
 *
 * @author Mahmoud Sherbeny
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    //color
    Setting set = new Setting();

    //icon
    ImageIcon error = new ImageIcon("src/Image/cancel.png");
    ImageIcon admin = new ImageIcon("src/Image/icon1.png");
    ImageIcon employee = new ImageIcon("src/Image/servant-outline.png");
    ImageIcon guest = new ImageIcon("src/Image/user.png");

    //conection
    private Connection conn = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    private String sql = null;

    //Position
    public static String postion = null;

    public Login() {
        initComponents();

        //set color
        jPanel1.setBackground(set.color);

        this.setLocationRelativeTo(null);

        //connection with database
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/imcansystem", "root", "admin");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "خطأ في الاتصال بالداتا بايز", "خطا في الداتا بايز", 0, error);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtusername = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtpassword = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnback = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        txtusername.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtusername.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtusername.setToolTipText("ادخل اسم الخاص بك");
        txtusername.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtusername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtusernameKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("الاسم :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("الرقم السري :");

        txtpassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtpassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtpassword.setToolTipText("ادخل الرقم السري  الخاص بك");
        txtpassword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtpassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpasswordKeyPressed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("دخول");
        jButton1.setToolTipText("اضغط لدخول لنظام ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(15, 105, 100));

        btnback.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnback.setText(" X ");
        btnback.setToolTipText("اغلق");
        btnback.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
        btnback.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnbackMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnbackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnbackMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 642, Short.MAX_VALUE)
                .addComponent(btnback))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnback, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(145, 145, 145)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(txtusername, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(29, 29, 29)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton1)
                                .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(29, 29, 29)
                            .addComponent(jLabel3)))
                    .addContainerGap(146, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 432, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(171, 171, 171)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtusername, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(5, 5, 5)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(5, 5, 5)
                            .addComponent(jLabel3)))
                    .addGap(18, 18, 18)
                    .addComponent(jButton1)
                    .addContainerGap(171, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnbackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbackMouseClicked
        System.exit(0);
    }//GEN-LAST:event_btnbackMouseClicked

    private void btnbackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbackMouseEntered
        btnback.setBorder(new LineBorder(Color.black, 2));
    }//GEN-LAST:event_btnbackMouseEntered

    private void btnbackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbackMouseExited
        btnback.setBorder(new LineBorder(Color.black, 0));
    }//GEN-LAST:event_btnbackMouseExited

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (txtusername.getText().equals("admin") && txtpassword.getText().equals("admin")) {
            postion = "guest";
            JOptionPane.showMessageDialog(this, "سيتم فتح البرنامج لتجريب مميزاته فقط\nولن يتم حفظ البيانات", "الدخول كضيف", 0, guest);
            MainMenu home = new MainMenu();
            setVisible(false);
            home.setVisible(true);
        } else {
            sql = "select * from login where username = ? and password = ?";
            try {
                pst = conn.prepareStatement(sql);
                pst.setString(1, txtusername.getText());
                pst.setString(2, txtpassword.getText());
                rs = pst.executeQuery();
                if (rs.next()) {
                    postion = rs.getString("position_id");
                    sql = "select * from postion where position_id = '" + postion + "'";
                    pst = conn.prepareStatement(sql);
                    rs = pst.executeQuery();
                    if (rs.next()) {
                        postion = rs.getString("jop");
                        if (postion.equals("admin")) {
                            JOptionPane.showMessageDialog(this, "تم فتح جميع الصلاحيات لدخول كمدير النظام", "الدخول كمدير", 0, admin);
                        } else {
                            JOptionPane.showMessageDialog(this, "تم فتح الصلاحيات لدخولك " + postion + " للنظام", "الدخول كموظف", 0, employee);
                        }
                        MainMenu home = new MainMenu();
                        setVisible(false);
                        home.setVisible(true);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "خطا في البيانات المدخله \n  لعمل تجربه للبرنامج استخدم admin", "خطأ في التسجيل", 0, error);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "خطأ في أجراء الداتا بايز", "خطا في الداتا بايز", 0, error);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtpasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpasswordKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txtusername.getText().equals("admin") && txtpassword.getText().equals("admin")) {
                postion = "guest";
                JOptionPane.showMessageDialog(this, "سيتم فتح البرنامج لتجريب مميزاته فقط\nولن يتم حفظ البيانات", "الدخول كضيف", 0, guest);
                MainMenu home = new MainMenu();
                setVisible(false);
                home.setVisible(true);
            } else {
                sql = "select * from login where username = ? and password = ?";
                try {
                    pst = conn.prepareStatement(sql);
                    pst.setString(1, txtusername.getText());
                    pst.setString(2, txtpassword.getText());
                    rs = pst.executeQuery();
                    if (rs.next()) {
                        postion = rs.getString("position_id");
                        sql = "select * from postion where position_id = '" + postion + "'";
                        pst = conn.prepareStatement(sql);
                        rs = pst.executeQuery();
                        if (rs.next()) {
                            postion = rs.getString("jop");
                            if (postion.equals("admin")) {
                                JOptionPane.showMessageDialog(this, "تم فتح جميع الصلاحيات لدخول كمدير النظام", "الدخول كمدير", 0, admin);
                            } else {
                                JOptionPane.showMessageDialog(this, "تم فتح الصلاحيات لدخولك " + postion + " للنظام", "الدخول كموظف", 0, employee);
                            }
                            MainMenu home = new MainMenu();
                            setVisible(false);
                            home.setVisible(true);
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "خطا في البيانات المدخله \n  لعمل تجربه للبرنامج استخدم admin", "خطأ في التسجيل", 0, error);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "خطأ في أجراء الداتا بايز", "خطا في الداتا بايز", 0, error);
                }
            }
        }
    }//GEN-LAST:event_txtpasswordKeyPressed

    private void txtusernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtusernameKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txtusername.getText().equals("admin") && txtpassword.getText().equals("admin")) {
                postion = "guest";
                JOptionPane.showMessageDialog(this, "سيتم فتح البرنامج لتجريب مميزاته فقط\nولن يتم حفظ البيانات", "الدخول كضيف", 0, guest);
                MainMenu home = new MainMenu();
                setVisible(false);
                home.setVisible(true);
            } else {
                sql = "select * from login where username = ? and password = ?";
                try {
                    pst = conn.prepareStatement(sql);
                    pst.setString(1, txtusername.getText());
                    pst.setString(2, txtpassword.getText());
                    rs = pst.executeQuery();
                    if (rs.next()) {
                        postion = rs.getString("position_id");
                        sql = "select * from postion where position_id = '" + postion + "'";
                        pst = conn.prepareStatement(sql);
                        rs = pst.executeQuery();
                        if (rs.next()) {
                            postion = rs.getString("jop");
                            if (postion.equals("admin")) {
                                JOptionPane.showMessageDialog(this, "تم فتح جميع الصلاحيات لدخول كمدير النظام", "الدخول كمدير", 0, admin);
                            } else {
                                JOptionPane.showMessageDialog(this, "تم فتح الصلاحيات لدخولك " + postion + " للنظام", "الدخول كموظف", 0, employee);
                            }
                            MainMenu home = new MainMenu();
                            setVisible(false);
                            home.setVisible(true);
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "خطا في البيانات المدخله \n  لعمل تجربه للبرنامج استخدم admin", "خطأ في التسجيل", 0, error);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "خطأ في أجراء الداتا بايز", "خطا في الداتا بايز", 0, error);
                }
            }
        }
    }//GEN-LAST:event_txtusernameKeyPressed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnback;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField txtpassword;
    private javax.swing.JTextField txtusername;
    // End of variables declaration//GEN-END:variables
}
