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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Mahmoud Sherbeny
 */
public class Statments {

    //connection
    private Connection conn = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null, rs1 = null;

    //icon
    ImageIcon error = new ImageIcon("src/Image/cancel.png");
    ImageIcon confirm = new ImageIcon("src/Image/confirm.png");

    public Statments() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/imcansystem", "root", "admin");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "خطأ في الاتصال بالداتا بايز", "خطا في الداتا بايز", 0, error);
        }
    }

    public void CurrentTime(JLabel lbltime) {

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

                    lbltime.setText(year + "/" + (month + 1) + "/" + day + "            " + hour + ":" + (mintes) + ":" + second);

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

    public void Set_Table_Data(JTable table, String sql) {
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "خطأ في اجراء بالداتا بايز", "خطا في الداتا بايز", 0, error);
        }
    }

    public void Data_Number(JLabel lbl1, String sql, String prim) {
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                String sum = rs.getString(prim);
                lbl1.setText(sum);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "خطأ في اجراء بالداتا بايز", "خطا في الداتا بايز", 0, error);
        }
    }

    public void Set_cmb_Data(String sql, JComboBox cmb, String item) {
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                String cour = rs.getString(item);
                cmb.addItem(cour);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "خطأ في اجراء بالداتا بايز", "خطا في الداتا بايز", 0, error);
        }
    }

    public void Delete(String sql, JTextField txt1) {
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, txt1.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "تم حذف الطالب بنجاح", "تاكيد", 0, confirm);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "خطأ في أجراء الداتا بايز", "خطا في الداتا بايز", 0, error);
        }
    }
    
    public ResultSet All_Date(String sql) {
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "خطأ في أجراء الداتا بايز", "خطا في الداتا بايز", 0, error);
        }
        return rs;
    }

    public void Print(JTable tbl, String Header, String pagenum) {
        MessageFormat header = new MessageFormat(Header);
        MessageFormat footer = new MessageFormat(pagenum);
        try {
            tbl.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "خطأ في أجراء الداتا بايز", "خطا في الداتا بايز", 0, error);
        }
    }

    public void report(String sql, String report_name, String Photo, String Txt, String[] items) {
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(report_name));

            document.open();
            Image image = Image.getInstance(Photo);
            document.add(image);
            document.add(new Paragraph(Txt + "\n", FontFactory.getFont(FontFactory.TIMES_BOLD, 18, Font.BOLD, BaseColor.RED)));
            document.add(new Paragraph(new Date().toString()));
            document.add(new Paragraph("\t\t\t\t\t\t----------------------------------------------------------------------------------------- \n\n"));

            PdfPTable table = new PdfPTable(items.length);
            PdfPCell[] cell = new PdfPCell[items.length];
            for (int i = 0; i < items.length; i++) {
                cell[i] = new PdfPCell(new Paragraph(items[i]));
                cell[i].setColspan(i);
                cell[i].setHorizontalAlignment(Element.ALIGN_LEFT);
                cell[i].setBackgroundColor(BaseColor.WHITE);
                table.addCell(cell[i]);
            }

            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                for (int i = 0; i < items.length; i++) {
                    table.addCell(rs.getString(items[i]));
                }
            }

            document.add(table);
            JOptionPane.showMessageDialog(null, "تم عمل التقرير بنجاح", "تاكيد", 0, confirm);
            document.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "خطأ في أجراء الداتا بايز", "خطا في الداتا بايز", 0, error);
        }
    }

    public String Result(String sql, String item) {
        String it = null;
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                it = rs.getString(item);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "خطأ في أجراء الداتا بايز", "خطا في الداتا بايز", 0, error);
        }
        return it;
    }

    public void Insert(String sql, int number, String[] items) {
        try {
            pst = conn.prepareStatement(sql);
            for (int i = 0; i < number; i++) {
                pst.setString(i + 1, items[i]);
            }
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "تم الأضافة بنجاح", "تاكيد", 0, confirm);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "خطأ في أجراء الداتا بايز", "خطا في الداتا بايز", 0, error);
        }
    }

    public void update(String sql) {
        try {
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "تم التعديل بنجاح", "تاكيد", 0, confirm);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "خطأ في أجراء الداتا بايز", "خطا في الداتا بايز", 0, error);
        }
    }
}
