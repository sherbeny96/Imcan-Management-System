/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imcan_managment;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import static java.lang.Thread.sleep;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Mahmoud Sherbeny
 */
public class Setting extends javax.swing.JFrame {

    /**
     * Creates new form Setting
     */
    //icon
    ImageIcon error = new ImageIcon("src/Image/cancel.png");
    ImageIcon confirm = new ImageIcon("src/Image/confirm.png");

    ImageIcon back = new ImageIcon("src/Image/back.png");
    ImageIcon eback = new ImageIcon("src/Image/eback.png");

    //conection
    private Connection conn = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null,
            rs1 = null;
    private String sql = null;

    private String id = null,
            id1 = null;

    //color
    public static Color color = new Color(40, 87, 137);

    //flixability
    int stu, ins, cour, empl, not, coun, plac, bofa;

    public Setting() {
        initComponents();
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.setLocationRelativeTo(null);

        //connection with database
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/imcansystem", "root", "admin");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "خطأ في الاتصال بالداتا بايز", "خطا في الداتا بايز", 0, error);
        }

        //show current time
        CurrentTime();
        //get position 
        UpdatePosition();
    }

    //get position 
    public void UpdatePosition() {
        try {
            sql = "select * from postion";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                String name = rs.getString("jop");
                cmbjop.addItem(name);
                cmbjop1.addItem(name);
                cmbjop2.addItem(name);
            }

        } catch (Exception ex) {

        }
    }

    //get current time
    private void CurrentTime() {

        Thread clock = new Thread() {
            public void run() {
                for (;;) {
                    Calendar cal = new GregorianCalendar();
                    int month = cal.get(Calendar.MONTH);
                    int year = cal.get(Calendar.YEAR);
                    int day = cal.get(Calendar.DAY_OF_MONTH);

                    int second = cal.get(Calendar.SECOND);
                    int mintes = cal.get(Calendar.MINUTE);
                    int hour = cal.get(Calendar.HOUR);

                    currenttime.setText(year + "/" + (month + 1) + "/" + day + "            " + hour + ":" + (mintes) + ":" + second);

                    try {
                        sleep(1000);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "خطأ في اجراء الوقت", "خطا", 0, error);
                    }
                }
            }
        };
        clock.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        currenttime = new javax.swing.JLabel();
        btnback = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        stucheck = new javax.swing.JCheckBox();
        courcheck = new javax.swing.JCheckBox();
        empcheck = new javax.swing.JCheckBox();
        inscheck = new javax.swing.JCheckBox();
        bofacheck = new javax.swing.JCheckBox();
        placcheck = new javax.swing.JCheckBox();
        countcheck = new javax.swing.JCheckBox();
        notcheck = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        cmbjop1 = new javax.swing.JComboBox();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnaddnew = new javax.swing.JButton();
        txtusername = new javax.swing.JTextField();
        txtpassword = new javax.swing.JPasswordField();
        txtpasswordconfirm = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        cmbjop = new javax.swing.JComboBox();
        jPanel8 = new javax.swing.JPanel();
        btnaddedit = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cmbjop2 = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        txtpassword1 = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        txtusername1 = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtpostionname = new javax.swing.JTextField();
        btnaddpos = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName(""); // NOI18N
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(40, 87, 137));

        jPanel2.setBackground(new java.awt.Color(15, 105, 100));

        currenttime.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnback.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/back.png"))); // NOI18N
        btnback.setToolTipText("رجوع");
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

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("الاعدادت");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(currenttime, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(334, 334, 334)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnback)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(currenttime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnback, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(40, 87, 137));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "تحديد الصلاحيات", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jPanel3.setToolTipText("تحديد صلاحيات الموظفين");
        jPanel3.setPreferredSize(new java.awt.Dimension(500, 290));

        stucheck.setBackground(new java.awt.Color(40, 87, 137));
        stucheck.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        stucheck.setText("الطلاب       ");
        stucheck.setToolTipText("فتح الصلاحيات");
        stucheck.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        stucheck.setHideActionText(true);
        stucheck.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        courcheck.setBackground(new java.awt.Color(40, 87, 137));
        courcheck.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        courcheck.setText("الكورسات   ");
        courcheck.setToolTipText("فتح الصلاحيات");
        courcheck.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        courcheck.setHideActionText(true);
        courcheck.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        empcheck.setBackground(new java.awt.Color(40, 87, 137));
        empcheck.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        empcheck.setText("الموظفين  ");
        empcheck.setToolTipText("فتح الصلاحيات");
        empcheck.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        empcheck.setHideActionText(true);
        empcheck.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        inscheck.setBackground(new java.awt.Color(40, 87, 137));
        inscheck.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        inscheck.setText("المدربين    ");
        inscheck.setToolTipText("فتح الصلاحيات");
        inscheck.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        inscheck.setHideActionText(true);
        inscheck.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        bofacheck.setBackground(new java.awt.Color(40, 87, 137));
        bofacheck.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bofacheck.setText("البوفيه      ");
        bofacheck.setToolTipText("فتح الصلاحيات");
        bofacheck.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bofacheck.setHideActionText(true);
        bofacheck.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        placcheck.setBackground(new java.awt.Color(40, 87, 137));
        placcheck.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        placcheck.setText("المكان       ");
        placcheck.setToolTipText("فتح الصلاحيات");
        placcheck.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        placcheck.setHideActionText(true);
        placcheck.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        countcheck.setBackground(new java.awt.Color(40, 87, 137));
        countcheck.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        countcheck.setText("الحسابات   ");
        countcheck.setToolTipText("فتح الصلاحيات");
        countcheck.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        countcheck.setHideActionText(true);
        countcheck.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        notcheck.setBackground(new java.awt.Color(40, 87, 137));
        notcheck.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        notcheck.setText("الاجنده       ");
        notcheck.setToolTipText("فتح الصلاحيات");
        notcheck.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        notcheck.setHideActionText(true);
        notcheck.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("تاكيد ");
        jButton1.setToolTipText("تاكيد صلاحيات الموظفين");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cmbjop1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbjop1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        cmbjop1.setToolTipText("اختار الوظيفه");
        cmbjop1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbjop1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(notcheck, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(placcheck, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bofacheck, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(countcheck, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(stucheck, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(courcheck, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inscheck, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(empcheck, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(206, 206, 206))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(cmbjop1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(130, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(cmbjop1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(notcheck)
                    .addComponent(stucheck))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(countcheck)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(placcheck)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bofacheck))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(courcheck)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(inscheck)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(empcheck)))
                .addGap(37, 37, 37)
                .addComponent(jButton1)
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(40, 87, 137));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "أضافة موظف جديد", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("الاسم :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("الرقم السري :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("تاكيد الرقم السري :");

        btnaddnew.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnaddnew.setText("أضافة");
        btnaddnew.setToolTipText("اضغط لتاكيد الاضافه");
        btnaddnew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddnewActionPerformed(evt);
            }
        });
        btnaddnew.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnaddnewKeyPressed(evt);
            }
        });

        txtusername.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtusername.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtusername.setToolTipText("ادخل اسم الموظف");
        txtusername.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtpassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtpassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtpassword.setToolTipText("ادخل الرقم السري ");
        txtpassword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtpasswordconfirm.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtpasswordconfirm.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtpasswordconfirm.setToolTipText("اعد ادخال الرقم السري");
        txtpasswordconfirm.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtpasswordconfirm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpasswordconfirmKeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("الوظيفة :");

        cmbjop.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbjop.setToolTipText("اختار الوظيفه");
        cmbjop.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbjopKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtpasswordconfirm)
                            .addComponent(txtpassword)
                            .addComponent(txtusername)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(cmbjop, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(btnaddnew)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtusername, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtpasswordconfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbjop, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnaddnew)
                .addContainerGap())
        );

        jPanel8.setBackground(new java.awt.Color(40, 87, 137));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "تعديل بيانات موظف", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jPanel8.setToolTipText("تعديل بيانات موظف");

        btnaddedit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnaddedit.setText("تعديل");
        btnaddedit.setToolTipText("اضغط لتاكيد التعديل");
        btnaddedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddeditActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("الوظيفة :");

        cmbjop2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbjop2.setToolTipText("اختار الوظيفه");
        cmbjop2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbjop2KeyPressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("الرقم السري :");

        txtpassword1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtpassword1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtpassword1.setToolTipText("ادخل الرقم السري ");
        txtpassword1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("الاسم :");

        txtusername1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtusername1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtusername1.setToolTipText("ادخل اسم الموظف");
        txtusername1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtusername1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtusername1KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbjop2, 0, 264, Short.MAX_VALUE)
                            .addComponent(txtpassword1))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(49, 49, 49))
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                            .addGap(141, 141, 141)
                            .addComponent(btnaddedit))
                        .addGroup(jPanel8Layout.createSequentialGroup()
                            .addGap(51, 51, 51)
                            .addComponent(txtusername1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 166, Short.MAX_VALUE)))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtpassword1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbjop2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(91, 91, 91))
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addGap(28, 28, 28)
                    .addComponent(txtusername1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(156, 156, 156)
                    .addComponent(btnaddedit)
                    .addContainerGap(28, Short.MAX_VALUE)))
        );

        jPanel9.setBackground(new java.awt.Color(40, 87, 137));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "أضافه وظيفه جديده", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jPanel9.setToolTipText("اضافه وضيفه جديده وتغير لون النظام");
        jPanel9.setPreferredSize(new java.awt.Dimension(500, 290));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("الاسم :");

        txtpostionname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtpostionname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtpostionname.setToolTipText("ادخل اسم الوظيفه الجديده");
        txtpostionname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtpostionname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpostionnameKeyPressed(evt);
            }
        });

        btnaddpos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnaddpos.setText("أضافة");
        btnaddpos.setToolTipText("اضغط لتاكيد الاضافه");
        btnaddpos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddposActionPerformed(evt);
            }
        });

        jPanel10.setBackground(new java.awt.Color(255, 192, 0));
        jPanel10.setToolTipText("قم بتغير لون النظام");
        jPanel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel10MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );

        jPanel11.setBackground(new java.awt.Color(46, 117, 182));
        jPanel11.setToolTipText("قم بتغير لون النظام");
        jPanel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel11MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );

        jPanel12.setBackground(new java.awt.Color(40, 87, 137));
        jPanel12.setToolTipText("قم بتغير لون النظام");
        jPanel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel12MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );

        jPanel13.setBackground(new java.awt.Color(192, 0, 0));
        jPanel13.setToolTipText("قم بتغير لون النظام");
        jPanel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel13MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );

        jPanel14.setBackground(new java.awt.Color(189, 128, 89));
        jPanel14.setToolTipText("قم بتغير لون النظام");
        jPanel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel14MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );

        jPanel16.setBackground(new java.awt.Color(89, 189, 89));
        jPanel16.setToolTipText("قم بتغير لون النظام");
        jPanel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel16MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );

        jPanel17.setBackground(new java.awt.Color(89, 89, 89));
        jPanel17.setToolTipText("قم بتغير لون النظام");
        jPanel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel17MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnaddpos)
                    .addComponent(txtpostionname, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtpostionname, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addComponent(btnaddpos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnbackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbackMouseEntered
        btnback.setIcon(eback);
    }//GEN-LAST:event_btnbackMouseEntered

    private void btnbackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbackMouseExited
        btnback.setIcon(back);
    }//GEN-LAST:event_btnbackMouseExited

    private void btnaddnewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddnewActionPerformed
        if (txtpassword.getText().equals(txtpasswordconfirm.getText())) {
            try {
                sql = "select position_id from postion where jop = '" + cmbjop1.getSelectedItem().toString() + "'";
                pst = conn.prepareStatement(sql);
                rs = pst.executeQuery();
                if (rs.next()) {
                    id = rs.getString("position_id");
                }
                sql = "insert into login (username , password , position_id) values (?,?,?)";
                pst = conn.prepareStatement(sql);
                pst.setString(1, txtusername.getText());
                pst.setString(2, txtpassword.getText());
                pst.setInt(3, Integer.parseInt(id));
                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "تم الاضافة بنجاح", "تاكيد", 0, confirm);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "خطأ في أجراء الداتا بايز", "خطا في الداتا بايز", 0, error);
            }
        } else {
            JOptionPane.showMessageDialog(this, "كلمه السر مختلفه", "خطا", 0, error);
        }
    }//GEN-LAST:event_btnaddnewActionPerformed

    private void cmbjopKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbjopKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txtpassword.getText().equals(txtpasswordconfirm.getText())) {
                try {
                    sql = "select position_id from postion where jop = '" + cmbjop1.getSelectedItem().toString() + "'";
                    pst = conn.prepareStatement(sql);
                    rs = pst.executeQuery();
                    if (rs.next()) {
                        id = rs.getString("position_id");
                    }
                    sql = "insert into login (username , password , position_id) values (?,?,?)";
                    pst = conn.prepareStatement(sql);
                    pst.setString(1, txtusername.getText());
                    pst.setString(2, txtpassword.getText());
                    pst.setInt(3, Integer.parseInt(id));
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(this, "تم الاضافة بنجاح", "تاكيد", 0, confirm);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "خطأ في أجراء الداتا بايز", "خطا في الداتا بايز", 0, error);
                }
            } else {
                JOptionPane.showMessageDialog(this, "كلمه السر مختلفه", "خطا", 0, error);
            }
        }
    }//GEN-LAST:event_cmbjopKeyPressed

    private void txtpasswordconfirmKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpasswordconfirmKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txtpassword.getText().equals(txtpasswordconfirm.getText())) {
                try {
                    sql = "select position_id from postion where jop = '" + cmbjop1.getSelectedItem().toString() + "'";
                    pst = conn.prepareStatement(sql);
                    rs = pst.executeQuery();
                    if (rs.next()) {
                        id = rs.getString("position_id");
                    }
                    sql = "insert into login (username , password , position_id) values (?,?,?)";
                    pst = conn.prepareStatement(sql);
                    pst.setString(1, txtusername.getText());
                    pst.setString(2, txtpassword.getText());
                    pst.setInt(3, Integer.parseInt(id));
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(this, "تم الاضافة بنجاح", "تاكيد", 0, confirm);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "خطأ في أجراء الداتا بايز", "خطا في الداتا بايز", 0, error);
                }
            } else {
                JOptionPane.showMessageDialog(this, "كلمه السر مختلفه", "خطا", 0, error);
            }
        }
    }//GEN-LAST:event_txtpasswordconfirmKeyPressed

    private void btnaddnewKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnaddnewKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txtpassword.getText().equals(txtpasswordconfirm.getText())) {
                try {
                    sql = "select position_id from postion where jop = '" + cmbjop1.getSelectedItem().toString() + "'";
                    pst = conn.prepareStatement(sql);
                    rs = pst.executeQuery();
                    if (rs.next()) {
                        id = rs.getString("position_id");
                    }
                    sql = "insert into login (username , password , position_id) values (?,?,?)";
                    pst = conn.prepareStatement(sql);
                    pst.setString(1, txtusername.getText());
                    pst.setString(2, txtpassword.getText());
                    pst.setInt(3, Integer.parseInt(id));
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(this, "تم الاضافة بنجاح", "تاكيد", 0, confirm);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "خطأ في أجراء الداتا بايز", "خطا في الداتا بايز", 0, error);
                }
            } else {
                JOptionPane.showMessageDialog(this, "كلمه السر مختلفه", "خطا", 0, error);
            }
        }
    }//GEN-LAST:event_btnaddnewKeyPressed

    private void txtusername1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtusername1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                sql = "select * from login where username = '" + txtusername1.getText() + "'";
                pst = conn.prepareStatement(sql);
                rs = pst.executeQuery();
                if (rs.next()) {
                    sql = "select jop from postion where position_id = '" + rs.getString("position_id") + "'";
                    pst = conn.prepareStatement(sql);
                    rs1 = pst.executeQuery();
                    if (rs1.next()) {
                        id = rs1.getString("jop");
                    }
                    txtpassword1.setText(rs.getString("password"));
                    cmbjop2.setSelectedItem(id);
                    id = rs.getString("id");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "خطأ في أجراء الداتا بايز", "خطا في الداتا بايز", 0, error);
            }
        }
    }//GEN-LAST:event_txtusername1KeyPressed

    private void btnaddeditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddeditActionPerformed
        try {
            sql = "select id from login where username = '" + txtusername1.getText() + "'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                id = rs.getString("id");
                sql = "select position_id from postion where jop = '" + cmbjop2.getSelectedItem().toString() + "'";
                pst = conn.prepareStatement(sql);
                rs = pst.executeQuery();
                if (rs.next()) {
                    id1 = rs.getString("position_id");
                }
                sql = "UPDATE login SET  username = '" + txtusername1.getText() + "', password = '" + txtpassword1.getText() + "', position_id = '" + id1 + "' WHERE `id` = '" + id + "'";
                pst = conn.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(this, "تم التعديل بنجاح", "تاكيد", 0, confirm);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "خطأ في أجراء الداتا بايز", "خطا في الداتا بايز", 0, error);
        }
    }//GEN-LAST:event_btnaddeditActionPerformed

    private void cmbjop2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbjop2KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                sql = "select id from login where username = '" + txtusername1.getText() + "'";
                pst = conn.prepareStatement(sql);
                rs = pst.executeQuery();
                if (rs.next()) {
                    id = rs.getString("id");
                    sql = "select position_id from postion where jop = '" + cmbjop2.getSelectedItem().toString() + "'";
                    pst = conn.prepareStatement(sql);
                    rs = pst.executeQuery();
                    if (rs.next()) {
                        id1 = rs.getString("position_id");
                    }
                    sql = "UPDATE login SET  username = '" + txtusername1.getText() + "', password = '" + txtpassword1.getText() + "', position_id = '" + id1 + "' WHERE `id` = '" + id + "'";
                    pst = conn.prepareStatement(sql);
                    pst.execute();
                    JOptionPane.showMessageDialog(this, "تم التعديل بنجاح", "تاكيد", 0, confirm);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "خطأ في أجراء الداتا بايز", "خطا في الداتا بايز", 0, error);
            }
        }
    }//GEN-LAST:event_cmbjop2KeyPressed

    private void btnaddposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddposActionPerformed
        try {
            sql = "select position_id from postion";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                id = rs.getString("position_id");
            }
            int x = Integer.parseInt(id) + 1;
            sql = "insert into postion (position_id , jop) values (?,?)";
            pst = conn.prepareStatement(sql);
            pst.setInt(1, x);
            pst.setString(2, txtpostionname.getText());
            pst.executeUpdate();
            //get position 
            UpdatePosition();
            sql = "insert into flixability (poistion_id , student,courses,trainer,employee,bofa,note,pleace,counting)VALUES(" + x + "," + 0 + "," + 0 + "," + 0 + "," + 0 + "," + 0 + "," + 0 + "," + 0 + "," + 0 + ")";
            pst = conn.prepareStatement(sql);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "تم الاضافة بنجاح", "تاكيد", 0, confirm);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "خطأ في أجراء الداتا بايز", "خطا في الداتا بايز", 0, error);
        }
    }//GEN-LAST:event_btnaddposActionPerformed

    private void txtpostionnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpostionnameKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                sql = "select position_id from postion";
                pst = conn.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    id = rs.getString("position_id");
                }
                int x = Integer.parseInt(id) + 1;
                sql = "insert into postion (position_id , jop) values (?,?)";
                pst = conn.prepareStatement(sql);
                pst.setInt(1, x);
                pst.setString(2, txtpostionname.getText());
                pst.executeUpdate();
                //get position 
                UpdatePosition();
                sql = "insert into flixability (poistion_id , student,courses,trainer,employee,bofa,note,pleace,counting)VALUES(" + x + "," + 0 + "," + 0 + "," + 0 + "," + 0 + "," + 0 + "," + 0 + "," + 0 + "," + 0 + ")";
                pst = conn.prepareStatement(sql);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "تم الاضافة بنجاح", "تاكيد", 0, confirm);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "خطأ في أجراء الداتا بايز", "خطا في الداتا بايز", 0, error);
            }
        }
    }//GEN-LAST:event_txtpostionnameKeyPressed

    private void jPanel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseClicked
        color = new Color(255, 192, 0);
        jPanel1.setBackground(color);
        jPanel3.setBackground(color);
        jPanel7.setBackground(color);
        jPanel8.setBackground(color);
        jPanel9.setBackground(color);
        stucheck.setBackground(color);
        inscheck.setBackground(color);
        courcheck.setBackground(color);
        countcheck.setBackground(color);
        notcheck.setBackground(color);
        empcheck.setBackground(color);
        placcheck.setBackground(color);
        bofacheck.setBackground(color);
    }//GEN-LAST:event_jPanel10MouseClicked

    private void jPanel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseClicked
        color = new Color(46, 117, 182);
        jPanel1.setBackground(color);
        jPanel3.setBackground(color);
        jPanel7.setBackground(color);
        jPanel8.setBackground(color);
        jPanel9.setBackground(color);
        stucheck.setBackground(color);
        inscheck.setBackground(color);
        courcheck.setBackground(color);
        countcheck.setBackground(color);
        notcheck.setBackground(color);
        empcheck.setBackground(color);
        placcheck.setBackground(color);
        bofacheck.setBackground(color);
    }//GEN-LAST:event_jPanel11MouseClicked

    private void jPanel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel13MouseClicked
        color = new Color(192, 0, 0);
        jPanel1.setBackground(color);
        jPanel3.setBackground(color);
        jPanel7.setBackground(color);
        jPanel8.setBackground(color);
        jPanel9.setBackground(color);
        stucheck.setBackground(color);
        inscheck.setBackground(color);
        courcheck.setBackground(color);
        countcheck.setBackground(color);
        notcheck.setBackground(color);
        empcheck.setBackground(color);
        placcheck.setBackground(color);
        bofacheck.setBackground(color);
    }//GEN-LAST:event_jPanel13MouseClicked

    private void jPanel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MouseClicked
        color = new Color(40, 87, 137);
        jPanel1.setBackground(color);
        jPanel3.setBackground(color);
        jPanel7.setBackground(color);
        jPanel8.setBackground(color);
        jPanel9.setBackground(color);
        stucheck.setBackground(color);
        inscheck.setBackground(color);
        courcheck.setBackground(color);
        countcheck.setBackground(color);
        notcheck.setBackground(color);
        empcheck.setBackground(color);
        placcheck.setBackground(color);
        bofacheck.setBackground(color);
    }//GEN-LAST:event_jPanel12MouseClicked

    private void jPanel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel17MouseClicked
        color = new Color(89, 89, 89);
        jPanel1.setBackground(color);
        jPanel3.setBackground(color);
        jPanel7.setBackground(color);
        jPanel8.setBackground(color);
        jPanel9.setBackground(color);
        stucheck.setBackground(color);
        inscheck.setBackground(color);
        courcheck.setBackground(color);
        countcheck.setBackground(color);
        notcheck.setBackground(color);
        empcheck.setBackground(color);
        placcheck.setBackground(color);
        bofacheck.setBackground(color);
    }//GEN-LAST:event_jPanel17MouseClicked

    private void jPanel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel16MouseClicked
        color = new Color(89, 189, 89);
        jPanel1.setBackground(color);
        jPanel3.setBackground(color);
        jPanel7.setBackground(color);
        jPanel8.setBackground(color);
        jPanel9.setBackground(color);
        stucheck.setBackground(color);
        inscheck.setBackground(color);
        courcheck.setBackground(color);
        countcheck.setBackground(color);
        notcheck.setBackground(color);
        empcheck.setBackground(color);
        placcheck.setBackground(color);
        bofacheck.setBackground(color);
    }//GEN-LAST:event_jPanel16MouseClicked

    private void jPanel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel14MouseClicked
        color = new Color(189, 128, 89);
        jPanel1.setBackground(color);
        jPanel3.setBackground(color);
        jPanel7.setBackground(color);
        jPanel8.setBackground(color);
        jPanel9.setBackground(color);
        stucheck.setBackground(color);
        inscheck.setBackground(color);
        courcheck.setBackground(color);
        countcheck.setBackground(color);
        notcheck.setBackground(color);
        empcheck.setBackground(color);
        placcheck.setBackground(color);
        bofacheck.setBackground(color);
    }//GEN-LAST:event_jPanel14MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            if (stucheck.isSelected()) {
                stu = 1;
            } else {
                stu = 0;
            }
            if (inscheck.isSelected()) {
                ins = 1;
            } else {
                ins = 0;
            }
            if (courcheck.isSelected()) {
                cour = 1;
            } else {
                cour = 0;
            }
            if (empcheck.isSelected()) {
                empl = 1;
            } else {
                empl = 0;
            }
            if (notcheck.isSelected()) {
                not = 1;
            } else {
                not = 0;
            }
            if (placcheck.isSelected()) {
                plac = 1;
            } else {
                plac = 0;
            }
            if (countcheck.isSelected()) {
                coun = 1;
            } else {
                coun = 0;
            }
            if (bofacheck.isSelected()) {
                bofa = 1;
            } else {
                bofa = 0;
            }

            sql = "select position_id from postion where jop = '" + cmbjop1.getSelectedItem().toString() + "'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                id = rs.getString("position_id");
            }
            sql = "update flixability set student = '" + stu + "' , trainer = '" + ins + "' "
                    + ", courses = '" + cour + "' , employee = '" + empl + "' , pleace = '" + plac + "' , note = '" + not + "'"
                    + " ,counting = '" + coun + "' , bofa = '" + bofa + "' "
                    + "where poistion_id = '" + id + "'";
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(this, "تم تحديد الصلاحيات بنجاح", "تاكيد", 0, confirm);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "خطأ في أجراء الداتا بايز", "خطا في الداتا بايز", 0, error);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cmbjop1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbjop1ActionPerformed
        try {
            sql = "select position_id from postion where jop = '" + cmbjop1.getSelectedItem().toString() + "'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                id = rs.getString("position_id");
            }
            sql = "select * from flixability where poistion_id = '" + id + "'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                if (rs.getString("student").equals("1")) {
                    stucheck.setSelected(true);
                } else {
                    stucheck.setSelected(false);
                }
                if (rs.getString("courses").equals("1")) {
                    courcheck.setSelected(true);
                } else {
                    courcheck.setSelected(false);
                }
                if (rs.getString("trainer").equals("1")) {
                    inscheck.setSelected(true);
                } else {
                    inscheck.setSelected(false);
                }
                if (rs.getString("employee").equals("1")) {
                    empcheck.setSelected(true);
                } else {
                    empcheck.setSelected(false);
                }
                if (rs.getString("bofa").equals("1")) {
                    bofacheck.setSelected(true);
                } else {
                    bofacheck.setSelected(false);
                }
                if (rs.getString("note").equals("1")) {
                    notcheck.setSelected(true);
                } else {
                    notcheck.setSelected(false);
                }
                if (rs.getString("pleace").equals("1")) {
                    placcheck.setSelected(true);
                } else {
                    placcheck.setSelected(false);
                }
                if (rs.getString("counting").equals("1")) {
                    countcheck.setSelected(true);
                } else {
                    countcheck.setSelected(false);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "خطأ في أجراء الداتا بايز", "خطا في الداتا بايز", 0, error);
        }
    }//GEN-LAST:event_cmbjop1ActionPerformed

    private void btnbackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbackMouseClicked
        JOptionPane.showMessageDialog(this, " لقد تم حفظ جميع البيانات المدخله كونك مدير لنظام ", "تاكيد", 0, confirm);
        Login log = new Login();
        log.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnbackMouseClicked

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
            java.util.logging.Logger.getLogger(Setting.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Setting.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Setting.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Setting.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Setting().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox bofacheck;
    private javax.swing.JButton btnaddedit;
    private javax.swing.JButton btnaddnew;
    private javax.swing.JButton btnaddpos;
    private javax.swing.JLabel btnback;
    private javax.swing.JComboBox cmbjop;
    private javax.swing.JComboBox cmbjop1;
    private javax.swing.JComboBox cmbjop2;
    private javax.swing.JCheckBox countcheck;
    private javax.swing.JCheckBox courcheck;
    private javax.swing.JLabel currenttime;
    private javax.swing.JCheckBox empcheck;
    private javax.swing.JCheckBox inscheck;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JCheckBox notcheck;
    private javax.swing.JCheckBox placcheck;
    private javax.swing.JCheckBox stucheck;
    private javax.swing.JPasswordField txtpassword;
    private javax.swing.JPasswordField txtpassword1;
    private javax.swing.JPasswordField txtpasswordconfirm;
    private javax.swing.JTextField txtpostionname;
    private javax.swing.JTextField txtusername;
    private javax.swing.JTextField txtusername1;
    // End of variables declaration//GEN-END:variables
}
