/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imcan_managment;

import java.awt.Color;
import java.awt.Toolkit;
import static java.lang.Thread.sleep;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Mahmoud Sherbeny
 */
public class MainMenu extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    //color
    Setting set = new Setting();

    //icon
    ImageIcon error = new ImageIcon("src/Image/cancel.png");
    ImageIcon confirm = new ImageIcon("src/Image/confirm.png");

    ImageIcon back = new ImageIcon("src/Image/back.png");
    ImageIcon eback = new ImageIcon("src/Image/eback.png");

    //conection
    private Connection conn = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    private String sql = null,
            x = null;

    Login log = new Login();

    String stu = "", ins= "", cour= "", empl= "", not= "", coun= "", plac= "", bofa= "";

    private String id = null;

    public MainMenu() {
        initComponents();

        //set color
        jPanel1.setBackground(set.color);
        stupanel.setBackground(set.color);
        courpanel.setBackground(set.color);
        trainpanel.setBackground(set.color);
        emppanel.setBackground(set.color);
        countpanel.setBackground(set.color);
        bofapanel.setBackground(set.color);
        placpanel.setBackground(set.color);
        agnpanel.setBackground(set.color);

        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.setLocationRelativeTo(null);

        txtposition.setText(log.postion);

        //connection with database
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/imcansystem", "root", "admin");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "خطأ في الاتصال بالداتا بايز", "خطا في الداتا بايز", 0, error);
        }

        //show current time
        CurrentTime();

        //flixability
        if (!log.postion.equals("guest")) {
            updata();
            set();
        }

        if (log.postion.equals("admin")) {
            btnsetting.setVisible(true);
        } else {
            btnsetting.setVisible(false);
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

    public void updata() {

        sql = "select * from postion where jop = '" + log.postion + "'";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                x = rs.getString("position_id");

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "خطأ في أجراء الداتا بايز", "خطا في الداتا بايز", 0, error);
        }
        try {
            sql = "select * from flixability where poistion_id = '" + x + "'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                stu = rs.getString("student");
                ins = rs.getString("trainer");
                cour = rs.getString("courses");
                empl = rs.getString("employee");
                not = rs.getString("note");
                plac = rs.getString("pleace");
                bofa = rs.getString("bofa");
                coun = rs.getString("counting");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "خطأ في أجراء الداتا بايز", "خطا في الداتا بايز", 0, error);
        }
    }

    public void set() {
        if (stu.equals("0")) {
            stupanel.setEnabled(false);
            stupanel1.setEnabled(false);
            stupanel2.setEnabled(false);
            panel.setEnabled(false);
        }
        if (ins.equals("0")) {
            trainpanel.setEnabled(false);
            trainpanel1.setEnabled(false);
            trainpanel2.setEnabled(false);
            panel2.setEnabled(false);
        }
        if (cour.equals("0")) {
            courpanel.setEnabled(false);
            courpanel1.setEnabled(false);
            courpanel2.setEnabled(false);
            panel1.setEnabled(false);
        }
        if (coun.equals("0")) {
            countpanel.setEnabled(false);
            countpanel1.setEnabled(false);
            countpanel2.setEnabled(false);
            panel5.setEnabled(false);
        }
        if (plac.equals("0")) {
            placpanel.setEnabled(false);
            placpanel1.setEnabled(false);
            placpanel2.setEnabled(false);
            panel6.setEnabled(false);
        }
        if (not.equals("0")) {
            agnpanel.setEnabled(false);
            agnpanel1.setEnabled(false);
            agnpanel2.setEnabled(false);
            panel4.setEnabled(false);
        }
        if (empl.equals("0")) {
            emppanel.setEnabled(false);
            emppanel1.setEnabled(false);
            emppanel2.setEnabled(false);
            panel3.setEnabled(false);
        }
        if (bofa.equals("0")) {
            bofapanel.setEnabled(false);
            bofapanel1.setEnabled(false);
            bofapanel2.setEnabled(false);
            panel7.setEnabled(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        currenttime = new javax.swing.JLabel();
        btnback = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtposition = new javax.swing.JLabel();
        btnsetting = new javax.swing.JLabel();
        panel = new javax.swing.JPanel();
        stupanel = new javax.swing.JPanel();
        stupanel1 = new javax.swing.JLabel();
        stupanel2 = new javax.swing.JLabel();
        panel1 = new javax.swing.JPanel();
        courpanel = new javax.swing.JPanel();
        courpanel1 = new javax.swing.JLabel();
        courpanel2 = new javax.swing.JLabel();
        panel2 = new javax.swing.JPanel();
        trainpanel = new javax.swing.JPanel();
        trainpanel1 = new javax.swing.JLabel();
        trainpanel2 = new javax.swing.JLabel();
        panel3 = new javax.swing.JPanel();
        emppanel = new javax.swing.JPanel();
        emppanel1 = new javax.swing.JLabel();
        emppanel2 = new javax.swing.JLabel();
        panel7 = new javax.swing.JPanel();
        bofapanel = new javax.swing.JPanel();
        bofapanel1 = new javax.swing.JLabel();
        bofapanel2 = new javax.swing.JLabel();
        panel6 = new javax.swing.JPanel();
        placpanel = new javax.swing.JPanel();
        placpanel1 = new javax.swing.JLabel();
        placpanel2 = new javax.swing.JLabel();
        panel5 = new javax.swing.JPanel();
        countpanel = new javax.swing.JPanel();
        countpanel1 = new javax.swing.JLabel();
        countpanel2 = new javax.swing.JLabel();
        panel4 = new javax.swing.JPanel();
        agnpanel = new javax.swing.JPanel();
        agnpanel1 = new javax.swing.JLabel();
        agnpanel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(15, 105, 100));
        jPanel2.setPreferredSize(new java.awt.Dimension(246, 25));

        currenttime.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        btnback.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnback.setText("تسجيل خروج");
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

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("القائمه الرئسيه");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(currenttime, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnback)
                .addGap(29, 29, 29))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(currenttime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnback, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        txtposition.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtposition.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtposition, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtposition, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        btnsetting.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnsetting.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnsetting.setText("Setting");
        btnsetting.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
        btnsetting.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnsettingMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnsettingMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnsettingMouseExited(evt);
            }
        });

        panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        stupanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
        stupanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stupanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                stupanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                stupanelMouseExited(evt);
            }
        });

        stupanel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Student Male_96px.png"))); // NOI18N
        stupanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stupanel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                stupanel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                stupanel1MouseExited(evt);
            }
        });

        stupanel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        stupanel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stupanel2.setText("الطلاب");
        stupanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stupanel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                stupanel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                stupanel2MouseExited(evt);
            }
        });

        javax.swing.GroupLayout stupanelLayout = new javax.swing.GroupLayout(stupanel);
        stupanel.setLayout(stupanelLayout);
        stupanelLayout.setHorizontalGroup(
            stupanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(stupanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(stupanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(stupanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(stupanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        stupanelLayout.setVerticalGroup(
            stupanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(stupanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(stupanel1)
                .addGap(18, 18, 18)
                .addComponent(stupanel2)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(stupanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(stupanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        courpanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
        courpanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                courpanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                courpanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                courpanelMouseExited(evt);
            }
        });

        courpanel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Note_96px.png"))); // NOI18N
        courpanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                courpanel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                courpanel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                courpanel1MouseExited(evt);
            }
        });

        courpanel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        courpanel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        courpanel2.setText("الكورسات");
        courpanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                courpanel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                courpanel2MouseExited(evt);
            }
        });

        javax.swing.GroupLayout courpanelLayout = new javax.swing.GroupLayout(courpanel);
        courpanel.setLayout(courpanelLayout);
        courpanelLayout.setHorizontalGroup(
            courpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(courpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(courpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(courpanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(courpanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        courpanelLayout.setVerticalGroup(
            courpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(courpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(courpanel1)
                .addGap(18, 18, 18)
                .addComponent(courpanel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(courpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(courpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        trainpanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
        trainpanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                trainpanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                trainpanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                trainpanelMouseExited(evt);
            }
        });

        trainpanel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/School Director_96px.png"))); // NOI18N
        trainpanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                trainpanel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                trainpanel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                trainpanel1MouseExited(evt);
            }
        });

        trainpanel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        trainpanel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        trainpanel2.setText("المدربين");
        trainpanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                trainpanel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                trainpanel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                trainpanel2MouseExited(evt);
            }
        });

        javax.swing.GroupLayout trainpanelLayout = new javax.swing.GroupLayout(trainpanel);
        trainpanel.setLayout(trainpanelLayout);
        trainpanelLayout.setHorizontalGroup(
            trainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(trainpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(trainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(trainpanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(trainpanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        trainpanelLayout.setVerticalGroup(
            trainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(trainpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(trainpanel1)
                .addGap(18, 18, 18)
                .addComponent(trainpanel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(trainpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(trainpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        emppanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
        emppanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                emppanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                emppanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                emppanelMouseExited(evt);
            }
        });

        emppanel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Customer Support_96px.png"))); // NOI18N
        emppanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                emppanel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                emppanel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                emppanel1MouseExited(evt);
            }
        });

        emppanel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        emppanel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        emppanel2.setText("الموظفين");
        emppanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                emppanel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                emppanel2MouseExited(evt);
            }
        });

        javax.swing.GroupLayout emppanelLayout = new javax.swing.GroupLayout(emppanel);
        emppanel.setLayout(emppanelLayout);
        emppanelLayout.setHorizontalGroup(
            emppanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(emppanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(emppanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(emppanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(emppanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        emppanelLayout.setVerticalGroup(
            emppanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(emppanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(emppanel1)
                .addGap(18, 18, 18)
                .addComponent(emppanel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(emppanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(emppanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bofapanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
        bofapanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bofapanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bofapanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bofapanelMouseExited(evt);
            }
        });

        bofapanel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Cup_96px.png"))); // NOI18N
        bofapanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bofapanel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bofapanel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bofapanel1MouseExited(evt);
            }
        });

        bofapanel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        bofapanel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bofapanel2.setText("البوفية");
        bofapanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bofapanel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bofapanel2MouseExited(evt);
            }
        });

        javax.swing.GroupLayout bofapanelLayout = new javax.swing.GroupLayout(bofapanel);
        bofapanel.setLayout(bofapanelLayout);
        bofapanelLayout.setHorizontalGroup(
            bofapanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bofapanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bofapanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(bofapanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bofapanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        bofapanelLayout.setVerticalGroup(
            bofapanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bofapanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bofapanel1)
                .addGap(18, 18, 18)
                .addComponent(bofapanel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panel7Layout = new javax.swing.GroupLayout(panel7);
        panel7.setLayout(panel7Layout);
        panel7Layout.setHorizontalGroup(
            panel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bofapanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panel7Layout.setVerticalGroup(
            panel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bofapanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        placpanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
        placpanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                placpanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                placpanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                placpanelMouseExited(evt);
            }
        });

        placpanel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Geo-fence_96px.png"))); // NOI18N
        placpanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                placpanel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                placpanel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                placpanel1MouseExited(evt);
            }
        });

        placpanel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        placpanel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        placpanel2.setText("المكان");
        placpanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                placpanel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                placpanel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                placpanel2MouseExited(evt);
            }
        });

        javax.swing.GroupLayout placpanelLayout = new javax.swing.GroupLayout(placpanel);
        placpanel.setLayout(placpanelLayout);
        placpanelLayout.setHorizontalGroup(
            placpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(placpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(placpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(placpanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(placpanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        placpanelLayout.setVerticalGroup(
            placpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(placpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(placpanel1)
                .addGap(18, 18, 18)
                .addComponent(placpanel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panel6Layout = new javax.swing.GroupLayout(panel6);
        panel6.setLayout(panel6Layout);
        panel6Layout.setHorizontalGroup(
            panel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(placpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panel6Layout.setVerticalGroup(
            panel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(placpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        countpanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
        countpanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                countpanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                countpanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                countpanelMouseExited(evt);
            }
        });

        countpanel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Bank_96px.png"))); // NOI18N
        countpanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                countpanel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                countpanel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                countpanel1MouseExited(evt);
            }
        });

        countpanel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        countpanel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        countpanel2.setText("الحسابات");
        countpanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                countpanel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                countpanel2MouseExited(evt);
            }
        });

        javax.swing.GroupLayout countpanelLayout = new javax.swing.GroupLayout(countpanel);
        countpanel.setLayout(countpanelLayout);
        countpanelLayout.setHorizontalGroup(
            countpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(countpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(countpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(countpanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(countpanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        countpanelLayout.setVerticalGroup(
            countpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(countpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(countpanel1)
                .addGap(18, 18, 18)
                .addComponent(countpanel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panel5Layout = new javax.swing.GroupLayout(panel5);
        panel5.setLayout(panel5Layout);
        panel5Layout.setHorizontalGroup(
            panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(countpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel5Layout.setVerticalGroup(
            panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(countpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        agnpanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
        agnpanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                agnpanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                agnpanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                agnpanelMouseExited(evt);
            }
        });

        agnpanel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Purchase Order_96px.png"))); // NOI18N
        agnpanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                agnpanel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                agnpanel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                agnpanel1MouseExited(evt);
            }
        });

        agnpanel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        agnpanel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        agnpanel2.setText("الااجنده");
        agnpanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                agnpanel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                agnpanel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                agnpanel2MouseExited(evt);
            }
        });

        javax.swing.GroupLayout agnpanelLayout = new javax.swing.GroupLayout(agnpanel);
        agnpanel.setLayout(agnpanelLayout);
        agnpanelLayout.setHorizontalGroup(
            agnpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(agnpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(agnpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(agnpanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(agnpanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        agnpanelLayout.setVerticalGroup(
            agnpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(agnpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(agnpanel1)
                .addGap(18, 18, 18)
                .addComponent(agnpanel2)
                .addContainerGap())
        );

        javax.swing.GroupLayout panel4Layout = new javax.swing.GroupLayout(panel4);
        panel4.setLayout(panel4Layout);
        panel4Layout.setHorizontalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(agnpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panel4Layout.setVerticalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(agnpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 795, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(panel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(100, 100, 100))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(360, Short.MAX_VALUE)
                .addComponent(btnsetting, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(360, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnsetting, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        Login log = new Login();
        log.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnbackMouseClicked

    private void btnbackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbackMouseEntered
        btnback.setBorder(new LineBorder(Color.black, 2));
    }//GEN-LAST:event_btnbackMouseEntered

    private void btnbackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbackMouseExited
        btnback.setBorder(new LineBorder(Color.black, 0));
    }//GEN-LAST:event_btnbackMouseExited

    private void btnsettingMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsettingMouseEntered
        btnsetting.setBorder(new LineBorder(Color.BLACK, 2));
    }//GEN-LAST:event_btnsettingMouseEntered

    private void btnsettingMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsettingMouseExited
        btnsetting.setBorder(new LineBorder(Color.BLACK, 0));
    }//GEN-LAST:event_btnsettingMouseExited

    private void btnsettingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsettingMouseClicked
        Setting set = new Setting();
        set.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btnsettingMouseClicked

    private void stupanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stupanelMouseEntered
        if (stu.equals("1") || log.postion.equals("guest")) {
            panel.setBackground(Color.black);
        }
    }//GEN-LAST:event_stupanelMouseEntered

    private void stupanel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stupanel1MouseEntered
        if (stu.equals("1") || log.postion.equals("guest")) {
            panel.setBackground(Color.black);
        }
    }//GEN-LAST:event_stupanel1MouseEntered

    private void stupanel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stupanel2MouseEntered
        if (stu.equals("1") || log.postion.equals("guest")) {
            panel.setBackground(Color.black);
        }
    }//GEN-LAST:event_stupanel2MouseEntered

    private void stupanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stupanelMouseExited
        panel.setBackground(new Color(240, 240, 240));
    }//GEN-LAST:event_stupanelMouseExited

    private void stupanel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stupanel1MouseExited
        panel.setBackground(new Color(240, 240, 240));
    }//GEN-LAST:event_stupanel1MouseExited

    private void stupanel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stupanel2MouseExited
        panel.setBackground(new Color(240, 240, 240));
    }//GEN-LAST:event_stupanel2MouseExited

    private void stupanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stupanelMouseClicked
        if (stu.equals("1") || log.postion.equals("guest")) {
            Student stu = new Student();
            stu.setVisible(true);
            setVisible(false);
        }
    }//GEN-LAST:event_stupanelMouseClicked

    private void courpanel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_courpanel1MouseEntered
        if (cour.equals("1") || log.postion.equals("guest")) {
            panel1.setBackground(Color.black);
        }
    }//GEN-LAST:event_courpanel1MouseEntered

    private void courpanel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_courpanel1MouseExited
        panel1.setBackground(new Color(240, 240, 240));
    }//GEN-LAST:event_courpanel1MouseExited

    private void courpanel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_courpanel2MouseEntered
        if (cour.equals("1") || log.postion.equals("guest")) {
            panel1.setBackground(Color.black);
        }
    }//GEN-LAST:event_courpanel2MouseEntered

    private void courpanel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_courpanel2MouseExited
        panel1.setBackground(new Color(240, 240, 240));
    }//GEN-LAST:event_courpanel2MouseExited

    private void courpanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_courpanelMouseClicked
        if (cour.equals("1") || log.postion.equals("guest")) {
            Courses cour = new Courses();
            cour.setVisible(true);
            setVisible(false);
        }
    }//GEN-LAST:event_courpanelMouseClicked

    private void courpanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_courpanelMouseEntered
        if (cour.equals("1") || log.postion.equals("guest")) {
            panel1.setBackground(Color.black);
        }
    }//GEN-LAST:event_courpanelMouseEntered

    private void courpanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_courpanelMouseExited
        panel1.setBackground(new Color(240, 240, 240));
    }//GEN-LAST:event_courpanelMouseExited

    private void courpanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_courpanel1MouseClicked
        if (cour.equals("1") || log.postion.equals("guest")) {
            Courses cour = new Courses();
            cour.setVisible(true);
            setVisible(false);
        }
    }//GEN-LAST:event_courpanel1MouseClicked

    private void stupanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stupanel1MouseClicked
        if (stu.equals("1") || log.postion.equals("guest")) {
            Student stu = new Student();
            stu.setVisible(true);
            setVisible(false);
        }
    }//GEN-LAST:event_stupanel1MouseClicked

    private void stupanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stupanel2MouseClicked
        if (stu.equals("1") || log.postion.equals("guest")) {
            Student stu = new Student();
            stu.setVisible(true);
            setVisible(false);
        }
    }//GEN-LAST:event_stupanel2MouseClicked

    private void courpanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_courpanel2MouseClicked
        if (cour.equals("1") || log.postion.equals("guest")) {
            Courses cour = new Courses();
            cour.setVisible(true);
            setVisible(false);
        }
    }//GEN-LAST:event_courpanel2MouseClicked

    private void trainpanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trainpanel1MouseClicked
       if (ins.equals("1") || log.postion.equals("guest")) {
            Instractor cour = new Instractor();
            cour.setVisible(true);
            setVisible(false);
       }
    }//GEN-LAST:event_trainpanel1MouseClicked

    private void trainpanel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trainpanel1MouseEntered
        if (ins.equals("1") || log.postion.equals("guest")) {
            panel2.setBackground(Color.black);
        }
    }//GEN-LAST:event_trainpanel1MouseEntered

    private void trainpanel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trainpanel1MouseExited
        panel2.setBackground(new Color(240, 240, 240));
    }//GEN-LAST:event_trainpanel1MouseExited

    private void trainpanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trainpanel2MouseClicked

    }//GEN-LAST:event_trainpanel2MouseClicked

    private void trainpanel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trainpanel2MouseEntered
        if (ins.equals("1") || log.postion.equals("guest")) {
            panel2.setBackground(Color.black);
        }
    }//GEN-LAST:event_trainpanel2MouseEntered

    private void trainpanel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trainpanel2MouseExited
        panel2.setBackground(new Color(240, 240, 240));
    }//GEN-LAST:event_trainpanel2MouseExited

    private void trainpanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trainpanelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_trainpanelMouseClicked

    private void trainpanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trainpanelMouseEntered
        if (ins.equals("1") || log.postion.equals("guest")) {
            panel2.setBackground(Color.black);
        }
    }//GEN-LAST:event_trainpanelMouseEntered

    private void trainpanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trainpanelMouseExited
        panel2.setBackground(new Color(240, 240, 240));
    }//GEN-LAST:event_trainpanelMouseExited

    private void emppanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emppanel1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_emppanel1MouseClicked

    private void emppanel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emppanel1MouseEntered
        if (empl.equals("1") || log.postion.equals("guest")) {
            panel3.setBackground(Color.black);
        }
    }//GEN-LAST:event_emppanel1MouseEntered

    private void emppanel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emppanel1MouseExited
        panel3.setBackground(new Color(240, 240, 240));
    }//GEN-LAST:event_emppanel1MouseExited

    private void emppanel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emppanel2MouseEntered
        if (empl.equals("1") || log.postion.equals("guest")) {
            panel3.setBackground(Color.black);
        }
    }//GEN-LAST:event_emppanel2MouseEntered

    private void emppanel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emppanel2MouseExited
        panel3.setBackground(new Color(240, 240, 240));
    }//GEN-LAST:event_emppanel2MouseExited

    private void emppanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emppanelMouseClicked

    }//GEN-LAST:event_emppanelMouseClicked

    private void emppanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emppanelMouseEntered
        if (empl.equals("1") || log.postion.equals("guest")) {
            panel3.setBackground(Color.black);
        }
    }//GEN-LAST:event_emppanelMouseEntered

    private void emppanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emppanelMouseExited
        panel3.setBackground(new Color(240, 240, 240));
    }//GEN-LAST:event_emppanelMouseExited

    private void agnpanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agnpanel1MouseClicked

    }//GEN-LAST:event_agnpanel1MouseClicked

    private void agnpanel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agnpanel1MouseEntered
        if (not.equals("1") || log.postion.equals("guest")) {
            panel4.setBackground(Color.black);
        }
    }//GEN-LAST:event_agnpanel1MouseEntered

    private void agnpanel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agnpanel1MouseExited
        panel4.setBackground(new Color(240, 240, 240));
    }//GEN-LAST:event_agnpanel1MouseExited

    private void agnpanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agnpanel2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_agnpanel2MouseClicked

    private void agnpanel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agnpanel2MouseEntered
        if (not.equals("1") || log.postion.equals("guest")) {
            panel4.setBackground(Color.black);
        }
    }//GEN-LAST:event_agnpanel2MouseEntered

    private void agnpanel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agnpanel2MouseExited
        panel4.setBackground(new Color(240, 240, 240));
    }//GEN-LAST:event_agnpanel2MouseExited

    private void agnpanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agnpanelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_agnpanelMouseClicked

    private void agnpanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agnpanelMouseEntered
        if (not.equals("1") || log.postion.equals("guest")) {
            panel4.setBackground(Color.black);
        }
    }//GEN-LAST:event_agnpanelMouseEntered

    private void agnpanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agnpanelMouseExited
        panel4.setBackground(new Color(240, 240, 240));
    }//GEN-LAST:event_agnpanelMouseExited

    private void countpanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_countpanel1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_countpanel1MouseClicked

    private void countpanel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_countpanel1MouseEntered
        if (coun.equals("1") || log.postion.equals("guest")) {
            panel5.setBackground(Color.black);
        }
    }//GEN-LAST:event_countpanel1MouseEntered

    private void countpanel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_countpanel1MouseExited
        panel5.setBackground(new Color(240, 240, 240));
    }//GEN-LAST:event_countpanel1MouseExited

    private void countpanel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_countpanel2MouseEntered
        if (coun.equals("1") || log.postion.equals("guest")) {
            panel5.setBackground(Color.black);
        }
    }//GEN-LAST:event_countpanel2MouseEntered

    private void countpanel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_countpanel2MouseExited
        panel5.setBackground(new Color(240, 240, 240));
    }//GEN-LAST:event_countpanel2MouseExited

    private void countpanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_countpanelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_countpanelMouseClicked

    private void countpanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_countpanelMouseEntered
        if (coun.equals("1") || log.postion.equals("guest")) {
            panel5.setBackground(Color.black);
        }
    }//GEN-LAST:event_countpanelMouseEntered

    private void countpanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_countpanelMouseExited
        panel5.setBackground(new Color(240, 240, 240));
    }//GEN-LAST:event_countpanelMouseExited

    private void placpanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_placpanel1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_placpanel1MouseClicked

    private void placpanel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_placpanel1MouseEntered
        if (plac.equals("1") || log.postion.equals("guest")) {
            panel6.setBackground(Color.black);
        }
    }//GEN-LAST:event_placpanel1MouseEntered

    private void placpanel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_placpanel1MouseExited
        panel6.setBackground(new Color(240, 240, 240));
    }//GEN-LAST:event_placpanel1MouseExited

    private void placpanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_placpanel2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_placpanel2MouseClicked

    private void placpanel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_placpanel2MouseEntered
        if (plac.equals("1") || log.postion.equals("guest")) {
            panel6.setBackground(Color.black);
        }
    }//GEN-LAST:event_placpanel2MouseEntered

    private void placpanel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_placpanel2MouseExited
        panel6.setBackground(new Color(240, 240, 240));
    }//GEN-LAST:event_placpanel2MouseExited

    private void placpanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_placpanelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_placpanelMouseClicked

    private void placpanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_placpanelMouseEntered
        if (plac.equals("1") || log.postion.equals("guest")) {
            panel6.setBackground(Color.black);
        }
    }//GEN-LAST:event_placpanelMouseEntered

    private void placpanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_placpanelMouseExited
        panel6.setBackground(new Color(240, 240, 240));
    }//GEN-LAST:event_placpanelMouseExited

    private void bofapanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bofapanel1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_bofapanel1MouseClicked

    private void bofapanel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bofapanel1MouseEntered
        if (bofa.equals("1") || log.postion.equals("guest")) {
            panel7.setBackground(Color.black);
        }
    }//GEN-LAST:event_bofapanel1MouseEntered

    private void bofapanel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bofapanel1MouseExited
        panel7.setBackground(new Color(240, 240, 240));
    }//GEN-LAST:event_bofapanel1MouseExited

    private void bofapanel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bofapanel2MouseEntered
        if (bofa.equals("1") || log.postion.equals("guest")) {
            panel7.setBackground(Color.black);
        }
    }//GEN-LAST:event_bofapanel2MouseEntered

    private void bofapanel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bofapanel2MouseExited
        panel7.setBackground(new Color(240, 240, 240));
    }//GEN-LAST:event_bofapanel2MouseExited

    private void bofapanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bofapanelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_bofapanelMouseClicked

    private void bofapanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bofapanelMouseEntered
        if (bofa.equals("1") || log.postion.equals("guest")) {
            panel7.setBackground(Color.black);
        }
    }//GEN-LAST:event_bofapanelMouseEntered

    private void bofapanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bofapanelMouseExited
        panel7.setBackground(new Color(240, 240, 240));
    }//GEN-LAST:event_bofapanelMouseExited

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
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel agnpanel;
    private javax.swing.JLabel agnpanel1;
    private javax.swing.JLabel agnpanel2;
    private javax.swing.JPanel bofapanel;
    private javax.swing.JLabel bofapanel1;
    private javax.swing.JLabel bofapanel2;
    private javax.swing.JLabel btnback;
    private javax.swing.JLabel btnsetting;
    private javax.swing.JPanel countpanel;
    private javax.swing.JLabel countpanel1;
    private javax.swing.JLabel countpanel2;
    private javax.swing.JPanel courpanel;
    private javax.swing.JLabel courpanel1;
    private javax.swing.JLabel courpanel2;
    private javax.swing.JLabel currenttime;
    private javax.swing.JPanel emppanel;
    private javax.swing.JLabel emppanel1;
    private javax.swing.JLabel emppanel2;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    private javax.swing.JPanel panel3;
    private javax.swing.JPanel panel4;
    private javax.swing.JPanel panel5;
    private javax.swing.JPanel panel6;
    private javax.swing.JPanel panel7;
    private javax.swing.JPanel placpanel;
    private javax.swing.JLabel placpanel1;
    private javax.swing.JLabel placpanel2;
    private javax.swing.JPanel stupanel;
    private javax.swing.JLabel stupanel1;
    private javax.swing.JLabel stupanel2;
    private javax.swing.JPanel stupanel3;
    private javax.swing.JLabel stupanel4;
    private javax.swing.JLabel stupanel5;
    private javax.swing.JPanel trainpanel;
    private javax.swing.JLabel trainpanel1;
    private javax.swing.JLabel trainpanel2;
    private javax.swing.JLabel txtposition;
    // End of variables declaration//GEN-END:variables
}
