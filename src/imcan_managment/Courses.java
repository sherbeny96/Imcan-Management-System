/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imcan_managment;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import static java.lang.Thread.sleep;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Mahmoud Sherbeny
 */
public class Courses extends javax.swing.JFrame {

    /**
     * Creates new form Courses
     */
    //icon
    ImageIcon error = new ImageIcon("src/Image/cancel.png");
    ImageIcon confirm = new ImageIcon("src/Image/confirm.png");

    ImageIcon back = new ImageIcon("src/Image/back.png");
    ImageIcon eback = new ImageIcon("src/Image/eback.png");

    //color
    Setting set = new Setting();

    //connection
    private Connection conn = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null, rs1 = null;
    private String sql = null;

    String id, name, course, lab, cost, proid, hour, day;

    public Courses() {
        initComponents();
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.setLocationRelativeTo(null);

        //set color
        jPanel1.setBackground(set.color);
        jPanel4.setBackground(set.color);

        //connection with database
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/imcansystem", "root", "admin");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "خطأ في الاتصال بالداتا بايز", "خطا في الداتا بايز", 0, error);
        }

        //show current time
        CurrentTime();

        //show student
        Show_Courses();

        //show student number
        number();

        //show trainer
        showtrainer();
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

    //show courses
    private void Show_Courses() {
        try {
            sql = "select  proid as 'الفتره' , cost as 'السعر' , name as 'الاسم' , course_id as 'الرقم' from courses";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            courtable.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "خطأ في اجراء بالداتا بايز", "خطا في الداتا بايز", 0, error);
        }
    }

    //show courses number
    private void number() {
        sql = "SELECT count(course_id) FROM courses";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                String sum = rs.getString("count(course_id)");
                txtnumbercourses.setText(sum);
            }
        } catch (SQLException ex) {

        }

    }

    //get data
    private void getdata() {
        id = txtid.getText();
        name = txtname.getText();
        lab = cmbplac.getSelectedItem().toString();
        course = cmbcours.getSelectedItem().toString();
        cost = txtprice.getText();
        hour = txthour.getText();
        day = txtstartday.getText();
        proid = txtproid.getText();
    }

    //get data edit
    private void getdataedit() {
        id = txtid1.getText();
        name = txtname1.getText();
        lab = cmbplac1.getSelectedItem().toString();
        course = cmbcours1.getSelectedItem().toString();
        cost = txtprice1.getText();
        hour = txthour1.getText();
        day = txtstartday1.getText();
        proid = txtproid1.getText();
    }

    //get data show
    private void getdatashow() {
        id = txtid2.getText();
        name = txtname2.getText();
        lab = cmbplac2.getSelectedItem().toString();
        course = cmbcours2.getSelectedItem().toString();
        cost = txtprice2.getText();
        hour = txthour2.getText();
        day = txtstartday2.getText();
        proid = txtproid2.getText();
    }

    //show trainer
    private void showtrainer() {
        sql = "select * from instractor";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                String cour = rs.getString("name");
                cmbcours.addItem(cour);
                cmbcours1.addItem(cour);
                cmbcours2.addItem(cour);
            }
        } catch (SQLException ex) {

        }

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
        jPanel2 = new javax.swing.JPanel();
        currenttime = new javax.swing.JLabel();
        btnback = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        txtnumbercourses = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        courtable = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        rdid = new javax.swing.JRadioButton();
        rdname = new javax.swing.JRadioButton();
        txtsearch = new javax.swing.JTextField();
        btnaddnew = new javax.swing.JButton();
        btnedit = new javax.swing.JButton();
        btnprint = new javax.swing.JButton();
        btnreport = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        add = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        txtname = new javax.swing.JTextField();
        txtprice = new javax.swing.JTextField();
        txthour = new javax.swing.JTextField();
        txtstartday = new javax.swing.JTextField();
        txtproid = new javax.swing.JTextField();
        btnadd = new javax.swing.JButton();
        cmbplac = new javax.swing.JComboBox();
        cmbcours = new javax.swing.JComboBox();
        cmbhour = new javax.swing.JComboBox();
        edit = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtid1 = new javax.swing.JTextField();
        txtname1 = new javax.swing.JTextField();
        txtprice1 = new javax.swing.JTextField();
        txthour1 = new javax.swing.JTextField();
        txtstartday1 = new javax.swing.JTextField();
        txtproid1 = new javax.swing.JTextField();
        btnadd1 = new javax.swing.JButton();
        cmbplac1 = new javax.swing.JComboBox();
        cmbcours1 = new javax.swing.JComboBox();
        cmbhour1 = new javax.swing.JComboBox();
        show = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtid2 = new javax.swing.JTextField();
        txtname2 = new javax.swing.JTextField();
        txtprice2 = new javax.swing.JTextField();
        txthour2 = new javax.swing.JTextField();
        txtstartday2 = new javax.swing.JTextField();
        txtproid2 = new javax.swing.JTextField();
        btnadd2 = new javax.swing.JButton();
        cmbplac2 = new javax.swing.JComboBox();
        cmbcours2 = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(15, 105, 100));
        jPanel2.setPreferredSize(new java.awt.Dimension(246, 25));

        currenttime.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        btnback.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnback.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/back.png"))); // NOI18N
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
        jLabel1.setText("الكورسات");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(currenttime, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(331, 331, 331)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnback)
                .addContainerGap())
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

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("عدد الكورسات :");
        jLabel3.setPreferredSize(new java.awt.Dimension(74, 20));

        txtnumbercourses.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtnumbercourses.setPreferredSize(new java.awt.Dimension(74, 20));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(txtnumbercourses, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnumbercourses, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        courtable.setModel(new javax.swing.table.DefaultTableModel(
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
        courtable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                courtableMouseClicked(evt);
            }
        });
        courtable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                courtableKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(courtable);

        rdid.setText("كود الكورس");
        rdid.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        rdid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdidActionPerformed(evt);
            }
        });

        rdname.setText("أسم الكورس");
        rdname.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        rdname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdnameActionPerformed(evt);
            }
        });

        txtsearch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtsearch.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtsearch.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)), "بحث", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.ABOVE_TOP));
        txtsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtsearchKeyPressed(evt);
            }
        });

        btnaddnew.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnaddnew.setText("أضافة جديد");
        btnaddnew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddnewActionPerformed(evt);
            }
        });

        btnedit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnedit.setText("تعديل");
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });

        btnprint.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnprint.setText("طباعة");
        btnprint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprintActionPerformed(evt);
            }
        });

        btnreport.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnreport.setText("تقرير");
        btnreport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreportActionPerformed(evt);
            }
        });

        btndelete.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btndelete.setText("حذف");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        jPanel6.setLayout(new java.awt.CardLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel4.setText("كود الكورس :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel5.setText("أسم الكورس :");

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel30.setText("المكان :");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel7.setText("المدرب :");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel8.setText("تكليف :");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel10.setText("الساعه :");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel11.setText("بدايت الكورس :");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("مده الكورس :");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Add Property_48px.png"))); // NOI18N

        txtid.setBackground(new java.awt.Color(240, 240, 240));
        txtid.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtid.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtid.setToolTipText("كود الطالب");
        txtid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtname.setBackground(new java.awt.Color(240, 240, 240));
        txtname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtname.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtname.setToolTipText("كود الطالب");
        txtname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtprice.setBackground(new java.awt.Color(240, 240, 240));
        txtprice.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtprice.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtprice.setText("0");
        txtprice.setToolTipText("كود الطالب");
        txtprice.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtprice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtpriceKeyTyped(evt);
            }
        });

        txthour.setBackground(new java.awt.Color(240, 240, 240));
        txthour.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txthour.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txthour.setToolTipText("كود الطالب");
        txthour.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtstartday.setBackground(new java.awt.Color(240, 240, 240));
        txtstartday.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtstartday.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtstartday.setToolTipText("كود الطالب");
        txtstartday.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtproid.setBackground(new java.awt.Color(240, 240, 240));
        txtproid.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtproid.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtproid.setToolTipText("كود الطالب");
        txtproid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnadd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnadd.setText("أضافة");
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });

        cmbplac.setBackground(new java.awt.Color(240, 240, 240));
        cmbplac.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbplac.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "lab1", "lab2", "Area" }));
        cmbplac.setToolTipText("اختر الكورس");
        cmbplac.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cmbplac.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cmbplac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbplacActionPerformed(evt);
            }
        });

        cmbcours.setBackground(new java.awt.Color(240, 240, 240));
        cmbcours.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbcours.setToolTipText("اختر الكورس");
        cmbcours.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cmbcours.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cmbcours.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbcoursActionPerformed(evt);
            }
        });

        cmbhour.setBackground(new java.awt.Color(240, 240, 240));
        cmbhour.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbhour.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "am", "pm" }));
        cmbhour.setToolTipText("اختر الكورس");
        cmbhour.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cmbhour.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cmbhour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbhourActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addLayout = new javax.swing.GroupLayout(add);
        add.setLayout(addLayout);
        addLayout.setHorizontalGroup(
            addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addLayout.createSequentialGroup()
                .addGroup(addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addLayout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(jLabel2))
                    .addGroup(addLayout.createSequentialGroup()
                        .addContainerGap(23, Short.MAX_VALUE)
                        .addGroup(addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtid)
                            .addComponent(txtname, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cmbplac, javax.swing.GroupLayout.Alignment.TRAILING, 0, 233, Short.MAX_VALUE)
                            .addComponent(cmbcours, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(addLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel5))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addLayout.createSequentialGroup()
                                        .addGap(59, 59, 59)
                                        .addComponent(jLabel30)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addLayout.createSequentialGroup()
                                    .addGap(27, 27, 27)
                                    .addComponent(jLabel4)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addLayout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(jLabel7))))
                    .addGroup(addLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addLayout.createSequentialGroup()
                                .addComponent(txtstartday, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel11))
                            .addGroup(addLayout.createSequentialGroup()
                                .addGroup(addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(addLayout.createSequentialGroup()
                                        .addComponent(txthour)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cmbhour, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtprice, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(addLayout.createSequentialGroup()
                                        .addGap(62, 62, 62)
                                        .addComponent(jLabel8))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addLayout.createSequentialGroup()
                                        .addGap(52, 52, 52)
                                        .addComponent(jLabel10))))))
                    .addGroup(addLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnadd)
                            .addComponent(txtproid, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        addLayout.setVerticalGroup(
            addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel2)
                .addGap(39, 39, 39)
                .addGroup(addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(addLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel5)))
                .addGap(18, 18, 18)
                .addGroup(addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbplac, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cmbcours, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtprice, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txthour, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbhour, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtstartday, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtproid, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnadd)
                .addGap(18, 18, 18))
        );

        jPanel6.add(add, "card2");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel6.setText("كود الكورس :");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel9.setText("أسم الكورس :");

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel31.setText("المكان :");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel13.setText("المدرب :");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel14.setText("تكليف :");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel15.setText("الساعه :");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel16.setText("بدايت الكورس :");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("مده الكورس :");

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Edit Property_48px.png"))); // NOI18N

        txtid1.setBackground(new java.awt.Color(240, 240, 240));
        txtid1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtid1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtid1.setToolTipText("كود الطالب");
        txtid1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtid1.setEnabled(false);

        txtname1.setBackground(new java.awt.Color(240, 240, 240));
        txtname1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtname1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtname1.setToolTipText("كود الطالب");
        txtname1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtprice1.setBackground(new java.awt.Color(240, 240, 240));
        txtprice1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtprice1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtprice1.setText("0");
        txtprice1.setToolTipText("كود الطالب");
        txtprice1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtprice1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtprice1KeyTyped(evt);
            }
        });

        txthour1.setBackground(new java.awt.Color(240, 240, 240));
        txthour1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txthour1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txthour1.setToolTipText("كود الطالب");
        txthour1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtstartday1.setBackground(new java.awt.Color(240, 240, 240));
        txtstartday1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtstartday1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtstartday1.setToolTipText("كود الطالب");
        txtstartday1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtproid1.setBackground(new java.awt.Color(240, 240, 240));
        txtproid1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtproid1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtproid1.setToolTipText("كود الطالب");
        txtproid1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnadd1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnadd1.setText("تعديل");
        btnadd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnadd1ActionPerformed(evt);
            }
        });

        cmbplac1.setBackground(new java.awt.Color(240, 240, 240));
        cmbplac1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbplac1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "lab1", "lab2", "Area" }));
        cmbplac1.setToolTipText("اختر الكورس");
        cmbplac1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cmbplac1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cmbplac1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbplac1ActionPerformed(evt);
            }
        });

        cmbcours1.setBackground(new java.awt.Color(240, 240, 240));
        cmbcours1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbcours1.setToolTipText("اختر الكورس");
        cmbcours1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cmbcours1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cmbcours1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbcours1ActionPerformed(evt);
            }
        });

        cmbhour1.setBackground(new java.awt.Color(240, 240, 240));
        cmbhour1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbhour1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "am", "pm" }));
        cmbhour1.setToolTipText("اختر الكورس");
        cmbhour1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cmbhour1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cmbhour1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbhour1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout editLayout = new javax.swing.GroupLayout(edit);
        edit.setLayout(editLayout);
        editLayout.setHorizontalGroup(
            editLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editLayout.createSequentialGroup()
                .addGroup(editLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editLayout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(jLabel18))
                    .addGroup(editLayout.createSequentialGroup()
                        .addContainerGap(23, Short.MAX_VALUE)
                        .addGroup(editLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtid1)
                            .addComponent(txtname1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cmbplac1, javax.swing.GroupLayout.Alignment.TRAILING, 0, 233, Short.MAX_VALUE)
                            .addComponent(cmbcours1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(editLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(editLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(editLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(editLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel9))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editLayout.createSequentialGroup()
                                        .addGap(59, 59, 59)
                                        .addComponent(jLabel31)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editLayout.createSequentialGroup()
                                    .addGap(27, 27, 27)
                                    .addComponent(jLabel6)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editLayout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(jLabel13))))
                    .addGroup(editLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(editLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(editLayout.createSequentialGroup()
                                .addComponent(txtstartday1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel16))
                            .addGroup(editLayout.createSequentialGroup()
                                .addComponent(txthour1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbhour1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(jLabel15))
                            .addGroup(editLayout.createSequentialGroup()
                                .addComponent(txtprice1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62)
                                .addComponent(jLabel14))))
                    .addGroup(editLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(editLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnadd1)
                            .addComponent(txtproid1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        editLayout.setVerticalGroup(
            editLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel18)
                .addGap(39, 39, 39)
                .addGroup(editLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtid1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(editLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtname1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(editLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel9)))
                .addGap(18, 18, 18)
                .addGroup(editLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbplac1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(editLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(cmbcours1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(editLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtprice1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(editLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addGroup(editLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txthour1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbhour1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(editLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtstartday1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(editLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtproid1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnadd1)
                .addGap(18, 18, 18))
        );

        jPanel6.add(edit, "card2");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel19.setText("كود الكورس :");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel20.setText("أسم الكورس :");

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel32.setText("المكان :");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel21.setText("المدرب :");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel22.setText("تكليف :");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel23.setText("الساعه :");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel24.setText("بدايت الكورس :");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel25.setText("مده الكورس :");

        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Page Overview 2_48px.png"))); // NOI18N

        txtid2.setBackground(new java.awt.Color(240, 240, 240));
        txtid2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtid2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtid2.setToolTipText("كود الطالب");
        txtid2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtid2.setEnabled(false);

        txtname2.setBackground(new java.awt.Color(240, 240, 240));
        txtname2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtname2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtname2.setToolTipText("كود الطالب");
        txtname2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtname2.setEnabled(false);

        txtprice2.setBackground(new java.awt.Color(240, 240, 240));
        txtprice2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtprice2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtprice2.setText("0");
        txtprice2.setToolTipText("كود الطالب");
        txtprice2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtprice2.setEnabled(false);
        txtprice2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtprice2KeyTyped(evt);
            }
        });

        txthour2.setBackground(new java.awt.Color(240, 240, 240));
        txthour2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txthour2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txthour2.setToolTipText("كود الطالب");
        txthour2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txthour2.setEnabled(false);

        txtstartday2.setBackground(new java.awt.Color(240, 240, 240));
        txtstartday2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtstartday2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtstartday2.setToolTipText("كود الطالب");
        txtstartday2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtstartday2.setEnabled(false);

        txtproid2.setBackground(new java.awt.Color(240, 240, 240));
        txtproid2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtproid2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtproid2.setToolTipText("كود الطالب");
        txtproid2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtproid2.setEnabled(false);

        btnadd2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnadd2.setText("طباعه");

        cmbplac2.setBackground(new java.awt.Color(240, 240, 240));
        cmbplac2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbplac2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "lab1", "lab2", "Area" }));
        cmbplac2.setToolTipText("اختر الكورس");
        cmbplac2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cmbplac2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cmbplac2.setEnabled(false);
        cmbplac2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbplac2ActionPerformed(evt);
            }
        });

        cmbcours2.setBackground(new java.awt.Color(240, 240, 240));
        cmbcours2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbcours2.setToolTipText("اختر الكورس");
        cmbcours2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cmbcours2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cmbcours2.setEnabled(false);
        cmbcours2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbcours2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout showLayout = new javax.swing.GroupLayout(show);
        show.setLayout(showLayout);
        showLayout.setHorizontalGroup(
            showLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showLayout.createSequentialGroup()
                .addGroup(showLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(showLayout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(jLabel26))
                    .addGroup(showLayout.createSequentialGroup()
                        .addContainerGap(23, Short.MAX_VALUE)
                        .addGroup(showLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtid2)
                            .addComponent(txtname2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cmbplac2, javax.swing.GroupLayout.Alignment.TRAILING, 0, 233, Short.MAX_VALUE)
                            .addComponent(cmbcours2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(showLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(showLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(showLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(showLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel20))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, showLayout.createSequentialGroup()
                                        .addGap(59, 59, 59)
                                        .addComponent(jLabel32)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, showLayout.createSequentialGroup()
                                    .addGap(27, 27, 27)
                                    .addComponent(jLabel19)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, showLayout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(jLabel21))))
                    .addGroup(showLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(showLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(showLayout.createSequentialGroup()
                                .addComponent(txtstartday2, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel24))
                            .addGroup(showLayout.createSequentialGroup()
                                .addComponent(txthour2, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addComponent(jLabel23))
                            .addGroup(showLayout.createSequentialGroup()
                                .addComponent(txtprice2, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62)
                                .addComponent(jLabel22))))
                    .addGroup(showLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(showLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnadd2)
                            .addComponent(txtproid2, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        showLayout.setVerticalGroup(
            showLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel26)
                .addGap(39, 39, 39)
                .addGroup(showLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtid2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addGap(18, 18, 18)
                .addGroup(showLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtname2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(showLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel20)))
                .addGap(18, 18, 18)
                .addGroup(showLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbplac2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(showLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(cmbcours2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(showLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txtprice2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(showLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(txthour2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(showLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(txtstartday2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(showLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtproid2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnadd2)
                .addGap(18, 18, 18))
        );

        jPanel6.add(show, "card2");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdid, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(rdname, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtsearch))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btndelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnreport)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnprint)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnedit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnaddnew))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(rdid)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdname)))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnreport)
                    .addComponent(btndelete)
                    .addComponent(btnaddnew)
                    .addComponent(btnedit)
                    .addComponent(btnprint))
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1350, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 925, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void btnbackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbackMouseClicked
        MainMenu log = new MainMenu();
        log.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnbackMouseClicked

    private void btnbackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbackMouseEntered
        btnback.setIcon(eback);
    }//GEN-LAST:event_btnbackMouseEntered

    private void btnbackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbackMouseExited
        btnback.setIcon(back);
    }//GEN-LAST:event_btnbackMouseExited

    private void rdidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdidActionPerformed
        if (rdid.isSelected()) {
            rdid.setSelected(true);
            rdname.setSelected(false);
        }
    }//GEN-LAST:event_rdidActionPerformed

    private void rdnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdnameActionPerformed
        if (rdname.isSelected()) {
            rdid.setSelected(false);
            rdname.setSelected(true);
        }
    }//GEN-LAST:event_rdnameActionPerformed

    private void txtsearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (rdname.isSelected()) {
                sql = "select  proid as 'الفتره' , cost as 'السعر' , name as 'الاسم' , course_id as 'الرقم' from courses where name = '" + txtsearch.getText() + "'";
                try {
                    pst = conn.prepareStatement(sql);
                    rs = pst.executeQuery();
                    courtable.setModel(DbUtils.resultSetToTableModel(rs));
                    sql = "select * from courses where name = '" + txtsearch.getText() + "'";
                    pst = conn.prepareStatement(sql);
                    rs = pst.executeQuery();
                    if (rs.next()) {
                        sql = "select name from instractor where instractor_id = '" + rs.getString("instractor_id") + "'";
                        pst = conn.prepareStatement(sql);
                        rs1 = pst.executeQuery();
                        if (rs1.next()) {
                            txtid2.setText(rs.getString("id"));
                            txtname2.setText(rs.getString("name"));
                            cmbplac2.setSelectedItem(rs.getString("lab"));
                            cmbcours2.setSelectedItem(rs1.getString("name"));
                            txtprice2.setText(rs.getString("cost"));
                            txthour2.setText(rs.getString("hour"));
                            txtstartday2.setText(rs.getString("startday"));
                            txtproid2.setText(rs.getString("proid"));
                        }
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "خطأ في أجراء الداتا بايز" + ex.toString(), "خطا في الداتا بايز", 0, error);
                }
            } else {
                sql = "select  proid as 'الفتره' , cost as 'السعر' , name as 'الاسم' , course_id as 'الرقم' from courses where id = '" + txtsearch.getText() + "'";
                try {
                    pst = conn.prepareStatement(sql);
                    rs = pst.executeQuery();
                    courtable.setModel(DbUtils.resultSetToTableModel(rs));
                    sql = "select * from courses where id = '" + txtsearch.getText() + "'";
                    pst = conn.prepareStatement(sql);
                    rs = pst.executeQuery();
                    if (rs.next()) {
                        sql = "select name from instractor where instractor_id = '" + rs.getString("instractor_id") + "'";
                        pst = conn.prepareStatement(sql);
                        rs1 = pst.executeQuery();
                        if (rs1.next()) {
                            txtid2.setText(rs.getString("id"));
                            txtname2.setText(rs.getString("name"));
                            cmbplac2.setSelectedItem(rs.getString("lab"));
                            cmbcours2.setSelectedItem(rs1.getString("name"));
                            txtprice2.setText(rs.getString("cost"));
                            txthour2.setText(rs.getString("hour"));
                            txtstartday2.setText(rs.getString("startday"));
                            txtproid2.setText(rs.getString("proid"));
                        }
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "خطأ في أجراء الداتا بايز" + ex.toString(), "خطا في الداتا بايز", 0, error);
                }
            }

            add.setVisible(false);
            edit.setVisible(false);
            show.setVisible(true);
        }

        if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            if (txtsearch.getText().equals("")) {
                Show_Courses();
                txtid2.setText(null);
                txtname2.setText(null);
                cmbplac2.setSelectedItem(null);
                cmbcours2.setSelectedItem(null);
                txtprice2.setText(null);
                txthour2.setText(null);
                txtstartday2.setText(null);
                txtproid2.setText(null);
            }
        }
    }//GEN-LAST:event_txtsearchKeyPressed

    private void courtableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_courtableKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            sql = "delete from courses where course_id = ?";
            try {
                pst = conn.prepareStatement(sql);
                pst.setString(1, txtsearch.getText());
                pst.execute();
                JOptionPane.showMessageDialog(this, "تم حذف الكورس بنجاح", "تاكيد", 0, confirm);
                Show_Courses();
                number();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "خطأ في أجراء الداتا بايز", "خطا في الداتا بايز", 0, error);
            }
        }
    }//GEN-LAST:event_courtableKeyPressed

    private void cmbplacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbplacActionPerformed

    }//GEN-LAST:event_cmbplacActionPerformed

    private void cmbcoursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbcoursActionPerformed

    }//GEN-LAST:event_cmbcoursActionPerformed

    private void txtpriceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpriceKeyTyped
        char c = evt.getKeyChar();
        if (!((c >= '0') && (c <= '9')
                || (c == KeyEvent.VK_BACK_SPACE)
                || (c == KeyEvent.VK_DELETE))) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtpriceKeyTyped

    private void txtprice1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprice1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtprice1KeyTyped

    private void cmbplac1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbplac1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbplac1ActionPerformed

    private void cmbcours1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbcours1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbcours1ActionPerformed

    private void txtprice2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprice2KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtprice2KeyTyped

    private void cmbplac2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbplac2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbplac2ActionPerformed

    private void cmbcours2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbcours2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbcours2ActionPerformed

    private void courtableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_courtableMouseClicked
        int row = courtable.getSelectedRow();
        String t_click = (courtable.getModel().getValueAt(row, 3).toString());
        txtsearch.setText(t_click);
        add.setVisible(false);
        show.setVisible(true);
        edit.setVisible(false);
        sql = "select * from courses where course_id = '" + t_click + "'";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                sql = "select name from instractor where instractor_id = '" + rs.getString("instractor_id") + "'";
                pst = conn.prepareStatement(sql);
                rs1 = pst.executeQuery();
                if (rs1.next()) {
                    txtid2.setText(rs.getString("id"));
                    txtname2.setText(rs.getString("name"));
                    cmbplac2.setSelectedItem(rs.getString("lab"));
                    cmbcours2.setSelectedItem(rs1.getString("name"));
                    txtprice2.setText(rs.getString("cost"));
                    txthour2.setText(rs.getString("hour") + " " + rs.getString("h"));
                    txtstartday2.setText(rs.getString("startday"));
                    txtproid2.setText(rs.getString("proid"));
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "خطأ في أجراء الداتا بايز", "خطا في الداتا بايز", 0, error);
        }
    }//GEN-LAST:event_courtableMouseClicked

    private void cmbhourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbhourActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbhourActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        sql = "delete from courses where course_id = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, txtsearch.getText());
            pst.execute();
            JOptionPane.showMessageDialog(this, "تم حذف الكورس بنجاح", "تاكيد", 0, confirm);
            Show_Courses();
            number();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "خطأ في أجراء الداتا بايز", "خطا في الداتا بايز", 0, error);
        }

    }//GEN-LAST:event_btndeleteActionPerformed

    private void btnprintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprintActionPerformed
        MessageFormat header = new MessageFormat("Student Data");
        MessageFormat footer = new MessageFormat("page 1");
        try {
            courtable.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "خطأ في أجراء الداتا بايز", "خطا في الداتا بايز", 0, error);
        }
    }//GEN-LAST:event_btnprintActionPerformed

    private void btnreportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreportActionPerformed
        sql = "SELECT startday,proid ,cost ,name,id  FROM courses";

        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("Report1.pdf"));

            document.open();
            Image image = Image.getInstance("src/Image/Page Overview 2_48px.png");
            document.add(image);
            document.add(new Paragraph("Imcan Courses\n", FontFactory.getFont(FontFactory.TIMES_BOLD, 18, Font.BOLD, BaseColor.RED)));
            document.add(new Paragraph(new Date().toString()));
            document.add(new Paragraph("\t\t\t\t\t\t----------------------------------------------------------------------------------------- \n\n"));
            PdfPTable table = new PdfPTable(5);
            PdfPCell cell = new PdfPCell(new Paragraph("id"));
            PdfPCell cell1 = new PdfPCell(new Paragraph("name"));
            PdfPCell cell2 = new PdfPCell(new Paragraph("cost"));
            PdfPCell cell3 = new PdfPCell(new Paragraph("proid"));
            PdfPCell cell4 = new PdfPCell(new Paragraph("startday"));
            cell.setColspan(1);
            cell1.setColspan(1);
            cell2.setColspan(1);
            cell3.setColspan(1);
            cell4.setColspan(1);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell.setBackgroundColor(BaseColor.WHITE);
            cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell1.setBackgroundColor(BaseColor.WHITE);
            cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell2.setBackgroundColor(BaseColor.WHITE);
            cell3.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell3.setBackgroundColor(BaseColor.WHITE);
            cell4.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell4.setBackgroundColor(BaseColor.WHITE);
            table.addCell(cell);
            table.addCell(cell1);
            table.addCell(cell2);
            table.addCell(cell3);
            table.addCell(cell4);
            try {
                pst = conn.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    table.addCell(rs.getString("id"));
                    table.addCell(rs.getString("name"));
                    table.addCell(rs.getString("cost"));
                    table.addCell(rs.getString("proid"));
                    table.addCell(rs.getString("startday"));
                }

            } catch (SQLException ex) {

            }

            document.add(table);
            JOptionPane.showMessageDialog(this, "تم عمل التقرير الخاص بجميع الكورسات بنجاح", "تاكيد", 0, confirm);
            document.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "خطأ في أجراء الداتا بايز", "خطا في الداتا بايز", 0, error);
        }
    }//GEN-LAST:event_btnreportActionPerformed

    private void btnaddnewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddnewActionPerformed
        add.setVisible(true);
        edit.setVisible(false);
        show.setVisible(false);
    }//GEN-LAST:event_btnaddnewActionPerformed

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
        if (rdname.isSelected()) {
                try {
                    sql = "select * from courses where name = '" + txtsearch.getText() + "'";
                    pst = conn.prepareStatement(sql);
                    rs = pst.executeQuery();
                    if (rs.next()) {
                        sql = "select name from instractor where instractor_id = '" + rs.getString("instractor_id") + "'";
                        pst = conn.prepareStatement(sql);
                        rs1 = pst.executeQuery();
                        if (rs1.next()) {
                            txtid1.setText(rs.getString("id"));
                            txtname1.setText(rs.getString("name"));
                            cmbplac1.setSelectedItem(rs.getString("lab"));
                            cmbcours1.setSelectedItem(rs1.getString("name"));
                            txtprice1.setText(rs.getString("cost"));
                            txthour1.setText(rs.getString("hour"));
                            cmbhour1.setSelectedItem(rs.getString("h"));
                            txtstartday1.setText(rs.getString("startday"));
                            txtproid1.setText(rs.getString("proid"));
                        }
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "خطأ في أجراء الداتا بايز" + ex.toString(), "خطا في الداتا بايز", 0, error);
                }
            } else {
                try {
                    sql = "select * from courses where id = '" + txtsearch.getText() + "' or course_id = '" + txtsearch.getText() + "'";
                    pst = conn.prepareStatement(sql);
                    rs = pst.executeQuery();
                    if (rs.next()) {
                        sql = "select name from instractor where instractor_id = '" + rs.getString("instractor_id") + "'";
                        pst = conn.prepareStatement(sql);
                        rs1 = pst.executeQuery();
                        if (rs1.next()) {
                            txtid1.setText(rs.getString("id"));
                            txtname1.setText(rs.getString("name"));
                            cmbplac1.setSelectedItem(rs.getString("lab"));
                            cmbcours1.setSelectedItem(rs1.getString("name"));
                            txtprice1.setText(rs.getString("cost"));
                            txthour1.setText(rs.getString("hour"));
                            cmbhour1.setSelectedItem(rs.getString("h"));
                            txtstartday1.setText(rs.getString("startday"));
                            txtproid1.setText(rs.getString("proid"));
                        }
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "خطأ في أجراء الداتا بايز" + ex.toString(), "خطا في الداتا بايز", 0, error);
                }
            }
        add.setVisible(false);
        edit.setVisible(true);
        show.setVisible(false);
    }//GEN-LAST:event_btneditActionPerformed

    private void cmbhour1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbhour1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbhour1ActionPerformed

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        getdata();
        String i = null;
        sql = "select * from courses";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                i = rs.getString("course_id");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "خطأ في أجراء الداتا بايز" + ex.toString(), "خطا في الداتا بايز", 0, error);
        }
        int x = Integer.parseInt(i) + 1;
        sql = "select instractor_id from instractor where name = '" + course + "'";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                course = rs.getString("instractor_id");
            }
            JOptionPane.showMessageDialog(null, "d");
            sql = "insert into courses (course_id,id,name,instractor_id,lab,cost,startday,hour,h,proid) values(?,?,?,?,?,?,?,?,?,?)";
            pst = conn.prepareStatement(sql);
            pst.setString(1, String.valueOf(x));
            pst.setString(2, id);
            pst.setString(3, name);
            pst.setString(4, course);
            pst.setString(5, lab);
            pst.setString(6, cost);
            pst.setString(7, day);
            pst.setString(8, hour);
            pst.setString(9, cmbhour.getSelectedItem().toString());
            pst.setString(10, proid);
            pst.executeUpdate();
            Show_Courses();
            number();
            JOptionPane.showMessageDialog(this, "تم أضافة الكورس بنجاح", "تاكيد", 0, confirm);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "خطأ في أجراء الداتا بايز" + ex.toString(), "خطا في الداتا بايز", 0, error);
        }
    }//GEN-LAST:event_btnaddActionPerformed

    private void btnadd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnadd1ActionPerformed
       getdataedit();
        try {
            sql = "select instractor_id from instractor where name = '"+cmbcours1.getSelectedItem().toString()+"'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next())
            {
                course = rs.getString("instractor_id");
            }
            sql = "update courses set  name = '" + name + "',instractor_id = '" + course + "',lab='" + lab + "',cost='" + cost + "',proid = '" + proid + "',startday  = '" + day + "',h  = '" + cmbhour1.getSelectedItem().toString() + "'"
                    + " where id = '" + id + "'";
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(this, "تم التعديل بنجاح", "تاكيد", 0, confirm);
            Show_Courses();
            number();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "خطأ في أجراء الداتا بايز" + ex.toString(), "خطا في الداتا بايز", 0, error);
        }
    }//GEN-LAST:event_btnadd1ActionPerformed

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
            java.util.logging.Logger.getLogger(Courses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Courses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Courses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Courses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Courses().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel add;
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btnadd1;
    private javax.swing.JButton btnadd2;
    private javax.swing.JButton btnaddnew;
    private javax.swing.JLabel btnback;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnedit;
    private javax.swing.JButton btnprint;
    private javax.swing.JButton btnreport;
    private javax.swing.JComboBox cmbcours;
    private javax.swing.JComboBox cmbcours1;
    private javax.swing.JComboBox cmbcours2;
    private javax.swing.JComboBox cmbhour;
    private javax.swing.JComboBox cmbhour1;
    private javax.swing.JComboBox cmbplac;
    private javax.swing.JComboBox cmbplac1;
    private javax.swing.JComboBox cmbplac2;
    private javax.swing.JTable courtable;
    private javax.swing.JLabel currenttime;
    private javax.swing.JPanel edit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JRadioButton rdid;
    private javax.swing.JRadioButton rdname;
    private javax.swing.JPanel show;
    private javax.swing.JTextField txthour;
    private javax.swing.JTextField txthour1;
    private javax.swing.JTextField txthour2;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtid1;
    private javax.swing.JTextField txtid2;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtname1;
    private javax.swing.JTextField txtname2;
    private javax.swing.JLabel txtnumbercourses;
    private javax.swing.JTextField txtprice;
    private javax.swing.JTextField txtprice1;
    private javax.swing.JTextField txtprice2;
    private javax.swing.JTextField txtproid;
    private javax.swing.JTextField txtproid1;
    private javax.swing.JTextField txtproid2;
    private javax.swing.JTextField txtsearch;
    private javax.swing.JTextField txtstartday;
    private javax.swing.JTextField txtstartday1;
    private javax.swing.JTextField txtstartday2;
    // End of variables declaration//GEN-END:variables
}
