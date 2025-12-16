/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import static gui.Teacher_enrollment.SubjectMap;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.MYSQL;
import model.MYSQLConnection;

/**
 *
 * @author User
 */
public class Class_Registration extends javax.swing.JFrame {

    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    HashMap<String, Integer> HAllMap = new HashMap<>();

    /**
     * Creates new form Class_Registration
     */
    public Class_Registration() {
        initComponents();
        disablebutton();
        settitleandicon1();
        loadsubject();
        loadSubjectCombo();
        loadHall();
        loadClass();
        deletebtn.setEnabled(false);
        updatebtn.setEnabled(false);
    }

    private static String generateID(int length) {
        StringBuilder sb = new StringBuilder(length);
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(index);
            sb.append(randomChar);
        }
        return sb.toString();
    }

    private void loadsubject() {
        try {
            ResultSet resultSet = MYSQL.execute("SELECT * FROM `subject` INNER JOIN `status` ON `subject`.`status_idstatus` = `status`.`idstatus` ORDER BY `idsubject` ASC");
            DefaultTableModel modelsub = (DefaultTableModel) jTable2.getModel();
            modelsub.setRowCount(0);
            while (resultSet.next()) {
                Vector<String> vsu = new Vector<>();

                vsu.add(resultSet.getString("idsubject"));
                vsu.add(resultSet.getString("subject_code"));
                vsu.add(resultSet.getString("subject_name"));
                vsu.add(resultSet.getString("status.type"));

                modelsub.addRow(vsu);
                jTable2.setModel(modelsub);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadSubjectCombo() {
        try {
            ResultSet resultSet1 = MYSQL.execute("SELECT * FROM `subject` WHERE `status_idstatus` = '1'");
            Vector<String> vclz = new Vector<>();
            vclz.add("Select");

            while (resultSet1.next()) {
                vclz.add(resultSet1.getString("subject_name"));
                SubjectMap.put(resultSet1.getString("subject_name"), resultSet1.getInt("idsubject"));
            }

            DefaultComboBoxModel<String> modelDep1 = new DefaultComboBoxModel<>(vclz);
            subjectcombo.setModel(modelDep1);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void loadHall() {
        try {
            ResultSet resultset = MYSQL.execute("SELECT * FROM `hall_tbl`");
            Vector<String> ClzHall = new Vector<>();
            ClzHall.add("Select");
            while (resultset.next()) {
                ClzHall.add(resultset.getString("hall_name"));
                HAllMap.put(resultset.getString("hall_name"), resultset.getInt("idhall_tbl"));

            }
            DefaultComboBoxModel<String> model1 = new DefaultComboBoxModel<>(ClzHall);
            hallnamecombo.setModel(model1);
        } catch (Exception e) {
        }
    }

    private void disablebutton() {
        jButton5.setEnabled(false);
    }

    private void settitleandicon1() {
        setTitle("Class Registration");
        ImageIcon icon2 = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Adyapana_Institute\\src\\img\\icons8_checked_user_male_64px.png");
        setIconImage(icon2.getImage());

    }

    private void reset() {
        clsgenaratedid.setText("");
        clsname.setText("");
        subjectcombo.setSelectedIndex(0);
//        frontime.setTime(null);
//        totime.setTime(null);
        clsdate.setDate(null);
        hallnamecombo.setSelectedIndex(0);
    }

    private void loadClass() {
        try {
            ResultSet resultSet = MYSQLConnection.executeSearch("SELECT * FROM `class_info` INNER JOIN `hall_tbl` ON `class_info`.`hall_tbl_idhall_tbl` = `hall_tbl`.`idhall_tbl` INNER JOIN `subject` ON `class_info`.`subject_idsubject`=`subject`.`idsubject` ORDER BY `idclass_info` ASC ");

            DefaultTableModel model1 = (DefaultTableModel) jTable3.getModel();
            model1.setRowCount(0);
            while (resultSet.next()) {
                Vector<String> v = new Vector<>();

                v.add(resultSet.getString("idclass_info"));
                v.add(resultSet.getString("class_code"));
                v.add(resultSet.getString("class_name"));
                v.add(resultSet.getString("from_time"));
                v.add(resultSet.getString("to_time"));
                v.add(resultSet.getString("date"));
                v.add(resultSet.getString("subject.subject_name"));
                v.add(resultSet.getString("hall_tbl.hall_name"));

                v.add(resultSet.getString("added_date"));

                v.add(resultSet.getString("updated_date"));

                model1.addRow(v);
                jTable3.setModel(model1);

            }
        } catch (Exception e) {
            e.printStackTrace();
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

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        clsgenaratedid = new javax.swing.JTextField();
        jButton14 = new javax.swing.JButton();
        clsname = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        subjectcombo = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        frontime = new lu.tudor.santec.jtimechooser.JTimeChooser();
        totime = new lu.tudor.santec.jtimechooser.JTimeChooser();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        clsdate = new com.toedter.calendar.JDateChooser();
        resetbtn = new javax.swing.JButton();
        savebtn = new javax.swing.JButton();
        deletebtn = new javax.swing.JButton();
        updatebtn = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        hallnamecombo = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jTextField5 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_school_64px_resize.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 40)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Adyapana Institute");

        jButton8.setBackground(new java.awt.Color(204, 204, 255));
        jButton8.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jButton8.setText("Home");
        jButton8.setBorderPainted(false);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(707, 707, 707)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 590, Short.MAX_VALUE)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setFont(new java.awt.Font("Verdana", 0, 30)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_registration_64px.png"))); // NOI18N
        jButton1.setText("Student Registration");
        jButton1.setBorderPainted(false);
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Verdana", 0, 30)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_teacher_64px.png"))); // NOI18N
        jButton2.setText("Teacher Enrollment");
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Verdana", 0, 30)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_return_book_64px_1.png"))); // NOI18N
        jButton3.setText("Subject Registration");
        jButton3.setBorderPainted(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Verdana", 0, 30)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_payment_history_64px.png"))); // NOI18N
        jButton4.setText("Student Payments");
        jButton4.setBorderPainted(false);

        jButton5.setFont(new java.awt.Font("Verdana", 0, 30)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_class_64px.png"))); // NOI18N
        jButton5.setText("Class Registration");
        jButton5.setBorderPainted(false);

        jButton6.setFont(new java.awt.Font("Verdana", 0, 30)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_sand_timer_64px.png"))); // NOI18N
        jButton6.setText("S & T Enroll For Sub.");
        jButton6.setBorderPainted(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Verdana", 0, 30)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_checked_user_male_64px.png"))); // NOI18N
        jButton7.setText("Student Attendence");
        jButton7.setBorderPainted(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(289, 289, 289)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
                .addGap(312, 312, 312))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(1106, 1106, 1106)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(171, 171, 171)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(103, 103, 103))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("Add Class");

        jLabel6.setText("Class ID :");

        clsgenaratedid.setEditable(false);

        jButton14.setText("Genarate");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jLabel7.setText("Class Name :");

        jLabel8.setText("Subject :");

        subjectcombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel10.setText("From :");

        jLabel11.setText("To :");

        jLabel12.setText("Date :");

        resetbtn.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        resetbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_reset_64px.png"))); // NOI18N
        resetbtn.setText("Reset");
        resetbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetbtnActionPerformed(evt);
            }
        });

        savebtn.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        savebtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_save_64px_1.png"))); // NOI18N
        savebtn.setText("Save");
        savebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savebtnActionPerformed(evt);
            }
        });

        deletebtn.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        deletebtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_trash_can_64px.png"))); // NOI18N
        deletebtn.setText("Delete");
        deletebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebtnActionPerformed(evt);
            }
        });

        updatebtn.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        updatebtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_available_updates_64px.png"))); // NOI18N
        updatebtn.setText("Update");
        updatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebtnActionPerformed(evt);
            }
        });

        jLabel13.setText("Hall Name:");

        hallnamecombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(resetbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(frontime, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(updatebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deletebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totime, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(194, 194, 194))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(clsgenaratedid, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jButton14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 157, Short.MAX_VALUE)
                                .addComponent(jLabel7))
                            .addComponent(subjectcombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clsname, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clsdate, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(savebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hallnamecombo, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(clsgenaratedid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton14)
                            .addComponent(jLabel7)
                            .addComponent(clsname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(67, 67, 67)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(subjectcombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(59, 59, 59)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(6, 6, 6))
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addComponent(totime, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                            .addComponent(frontime, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(65, 65, 65)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(clsdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(hallnamecombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 164, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(savebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resetbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updatebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deletebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Subject ID/Name");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Subject Code", "Subject Name", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField5KeyReleased(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("Class ID / Name");

        jTextField6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField6KeyReleased(evt);
            }
        });

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Class Code", "Class Name", "From", "To", "Date", "Subject", "Hall", "Added Date", "Updated Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 904, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(224, 224, 224))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(202, 202, 202)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenuBar1.setBorderPainted(false);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
         int option = JOptionPane.showConfirmDialog(this, "Do you Want To Leave This Page?", "Information Message", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (option == JOptionPane.YES_OPTION) {
         Home home = new Home();
        home.setVisible(true);
        this.dispose();
        }
       
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int option = JOptionPane.showConfirmDialog(this, "Do you Want To Leave This Page?", "Information Message", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (option == JOptionPane.YES_OPTION) {
         Student_Registration st_reg = new Student_Registration();
        st_reg.setVisible(true);
        this.dispose();
        }
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int option = JOptionPane.showConfirmDialog(this, "Do you Want To Leave This Page?", "Information Message", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (option == JOptionPane.YES_OPTION) {
        Teacher_enrollment teachetenroll = new Teacher_enrollment();
        teachetenroll.setVisible(true);
        this.dispose();
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int option = JOptionPane.showConfirmDialog(this, "Do you Want To Leave This Page?", "Information Message", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (option == JOptionPane.YES_OPTION) {
        Subject_registration sub_reg = new Subject_registration();
        sub_reg.setVisible(true);
        this.dispose();
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        int option = JOptionPane.showConfirmDialog(this, "Do you Want To Leave This Page?", "Information Message", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (option == JOptionPane.YES_OPTION) {
         Student_and_Teacher_Enrollment stutecenrol = new Student_and_Teacher_Enrollment();
        stutecenrol.setVisible(true);
        this.dispose();
        }
       
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
      
        String genaratedID = generateID(6);
        clsgenaratedid.setText("CLS" + genaratedID);
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jTextField5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyReleased
        // TODO add your handling code here:
        String search2 = jTextField5.getText();

        if (search2.isEmpty()) {
            loadsubject();
        } else {
            try {
                ResultSet resultSet1 = MYSQL.execute("SELECT * FROM `subject` INNER JOIN `status` ON `subject`.`idsubject` = `status`.`idstatus` WHERE `subject_code` = '" + search2 + "' OR `subject_name` = '" + search2 + "'");

                DefaultTableModel model1 = (DefaultTableModel) jTable2.getModel();
                model1.setRowCount(0);
                while (resultSet1.next()) {
                    Vector<String> vsu = new Vector<>();

                    vsu.add(resultSet1.getString("idsubject"));
                    vsu.add(resultSet1.getString("subject_code"));
                    vsu.add(resultSet1.getString("subject_name"));

                    vsu.add(resultSet1.getString("status.type"));

                    model1.addRow(vsu);
                    jTable2.setModel(model1);

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jTextField5KeyReleased

    private void savebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savebtnActionPerformed
        // TODO add your handling code here:
        ImageIcon Isuccess = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Adyapana_Institute\\src\\img\\icons8_ok_64px_1.png");
        ImageIcon Iattention = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Adyapana_Institute\\src\\img\\icons8_siren_64px.png");
        ImageIcon IconAttention1 = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Adyapana_Institute\\src\\img\\icons8_stop_sign_64px.png");
        String ClzGenaratedCode = clsgenaratedid.getText();
        String ClzName = clsname.getText();
        String Clzsubject = String.valueOf(subjectcombo.getSelectedItem());
        String frontimeClz = String.valueOf(frontime.getFormatedTime());
        String toTimeClz = String.valueOf(totime.getFormatedTime());

        String clzhallname = String.valueOf(hallnamecombo.getSelectedItem());
        Date date1 = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = dateFormat.format(date1);

        if (ClzGenaratedCode.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Genarate Class ID", "Class Registration", JOptionPane.INFORMATION_MESSAGE);
            jButton14.grabFocus();
        } else if (ClzName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Class Name", "Class Registration", JOptionPane.INFORMATION_MESSAGE);
            clsname.grabFocus();
        } else if (Clzsubject.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please Select Subject", "Class Registration", JOptionPane.INFORMATION_MESSAGE);
            subjectcombo.grabFocus();
        } else if (clzhallname.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please Select Hall", "Class Registration", JOptionPane.INFORMATION_MESSAGE);
            hallnamecombo.grabFocus();
        } else {
            Date DateClz = clsdate.getDate();//CLZ DATE
            LocalDate localDate = DateClz.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            String classDate = String.valueOf(localDate);

            Integer SubID = SubjectMap.get(Clzsubject);
            Integer CLZhallID = HAllMap.get(clzhallname);

            int option = JOptionPane.showConfirmDialog(this, "Your From Time is :" + frontimeClz + "And Your To Time is :" + toTimeClz + "This Times Cannot Be Change Again Do You Want To Continue?(You Can Do Update Both Only)", "Attention Please", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, IconAttention1);
            if (option == JOptionPane.YES_OPTION) {
                try {
                    MYSQL.execute("INSERT INTO `class_info` (`class_code`,`class_name`,`from_time`,`to_time`,`date`,"
                            + "`added_date`,`hall_tbl_idhall_tbl`,`subject_idsubject`) VALUES ('" + ClzGenaratedCode + "','" + ClzName + "','" + frontimeClz + "','" + toTimeClz + "','" + classDate + "','" + formattedDateTime + "','" + CLZhallID + "','" + SubID + "')");
                    JOptionPane.showMessageDialog(this, "Class Registration Was Successfully", "Class Registration", JOptionPane.INFORMATION_MESSAGE, Isuccess);
                    JOptionPane.showMessageDialog(this, "From And To Time Is not Going To Reset Againg Please Check It Before You Add Another Record", "Attention Please", JOptionPane.INFORMATION_MESSAGE, Iattention);
                    JOptionPane.showMessageDialog(this, "Window Resetting", "Rset", JOptionPane.INFORMATION_MESSAGE);
                    reset();
                    loadClass();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }


    }//GEN-LAST:event_savebtnActionPerformed

    private void resetbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetbtnActionPerformed
        // TODO add your handling code here:
        ImageIcon IconReset = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Adyapana_Institute\\src\\img\\icons8_reset_64px_3.png");
        String claGenarate = clsgenaratedid.getText();
        String className = clsname.getText();
        String hallnameclass = String.valueOf(hallnamecombo.getSelectedItem());
        String SubjectStatus = String.valueOf(subjectcombo.getSelectedItem());

        if (claGenarate.isEmpty() && className.isEmpty() && hallnameclass.equals("Select") && SubjectStatus.equals("Select")) {
            reset();
            JOptionPane.showMessageDialog(this, "This Window Reset", "Window Resetting", JOptionPane.INFORMATION_MESSAGE);
            jButton14.grabFocus();
            savebtn.setEnabled(true);
            deletebtn.setEnabled(false);
            updatebtn.setEnabled(false);

        } else {
            int option = JOptionPane.showConfirmDialog(this, "Are You Sure Do You Want To Reset This Window ?", "Window Resetting", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, IconReset);

            if (option == JOptionPane.YES_OPTION) {
                reset();
                jButton14.grabFocus();
                savebtn.setEnabled(true);
                jButton14.setEnabled(true);
                deletebtn.setEnabled(false);
                updatebtn.setEnabled(false);

            }

        }
    }//GEN-LAST:event_resetbtnActionPerformed

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        // TODO add your handling code here:
        ImageIcon iconAttention = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Adyapana_Institute\\src\\img\\icons8_stop_sign_64px.png");
        if (evt.getClickCount() == 2) {
            JOptionPane.showMessageDialog(this, "If Your Gonna Update A Class You Must Update The From And To Time Again", "Attention Please", JOptionPane.INFORMATION_MESSAGE, iconAttention);
            savebtn.setEnabled(false);
            deletebtn.setEnabled(true);
            updatebtn.setEnabled(true);
            clsgenaratedid.setText("");
            jButton14.setEnabled(false);

            int selectRow = jTable3.getSelectedRow();
            String ClassID = String.valueOf(jTable3.getValueAt(selectRow, 1));
            clsgenaratedid.setText(ClassID);
            String ClassName = String.valueOf(jTable3.getValueAt(selectRow, 2));
            clsname.setText(ClassName);
            String SubjectClass = String.valueOf(jTable3.getValueAt(selectRow, 6));
            subjectcombo.setSelectedItem(SubjectClass);
            String dob = String.valueOf(jTable3.getValueAt(selectRow, 5));

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = null;
            try {
                date = dateFormat.parse(dob);
            } catch (ParseException e) {
                e.printStackTrace();
            }

// Set the parsed date to the JDateChooser component
            clsdate.setDate(date);
            String ClassHall = String.valueOf(jTable3.getValueAt(selectRow, 7));
            hallnamecombo.setSelectedItem(ClassHall);

        }
    }//GEN-LAST:event_jTable3MouseClicked

    private void updatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebtnActionPerformed
        // TODO add your handling code here:
        ImageIcon EoorIcon = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Adyapana_Institute\\src\\img\\icons8_information_64px.png");
        ImageIcon IconReset = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Adyapana_Institute\\src\\img\\icons8_reset_64px_3.png");
        ImageIcon IconSuccess = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Adyapana_Institute\\src\\img\\icons8_ok_64px_1.png");
        ImageIcon IconAttention1 = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Adyapana_Institute\\src\\img\\icons8_stop_sign_64px.png");

        String ClassName = clsname.getText();
        String ClassSubject = String.valueOf(subjectcombo.getSelectedItem());
        String ClassHall = String.valueOf(hallnamecombo.getSelectedItem());

        Date Udate1 = new Date();
        SimpleDateFormat dateUFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedUDateTime = dateUFormat.format(Udate1);

        int selectedRow = jTable3.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please Select A Row", "Class Updatting", JOptionPane.ERROR_MESSAGE);
        } else {
            String clzid = String.valueOf(jTable3.getValueAt(selectedRow, 0));

            if (ClassName.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Enter Class Name", "Class Updatting", JOptionPane.ERROR_MESSAGE, EoorIcon);
                clsname.grabFocus();
            } else if (ClassSubject.equals("Select")) {
                JOptionPane.showMessageDialog(this, "Please Select Subject", "Class Updatting", JOptionPane.ERROR_MESSAGE, EoorIcon);
                subjectcombo.grabFocus();
            } else if (ClassHall.equals("Select")) {
                JOptionPane.showMessageDialog(this, "Please Select Hall", "Class Updatting", JOptionPane.ERROR_MESSAGE, EoorIcon);
                hallnamecombo.grabFocus();
            } else {
                Date ClassDate = clsdate.getDate();
                LocalDate localDate = ClassDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                String clzDate = String.valueOf(localDate);//Use This Var

                String frontimeClz = String.valueOf(frontime.getFormatedTime());
                String toTimeClz = String.valueOf(totime.getFormatedTime());

                Integer SubjectID = SubjectMap.get(ClassSubject);
                Integer hallID = HAllMap.get(ClassHall);

                try {
                    MYSQL.execute("UPDATE `class_info` SET `class_name`='" + ClassName + "',`from_time`='" + frontimeClz + "',`to_time`='" + toTimeClz + "',`date`='" + clzDate + "',`hall_tbl_idhall_tbl`='" + hallID + "',`subject_idsubject`='" + SubjectID + "',`updated_date`='" + formattedUDateTime + "' "
                            + "WHERE `idclass_info` = '" + clzid + "'");
                    JOptionPane.showMessageDialog(this, ClassName + " Details Update Successfully ", "Class Details Updated", JOptionPane.INFORMATION_MESSAGE, IconSuccess);

                    JOptionPane.showMessageDialog(this, " This Window Reset Again ", "Window Resetting", JOptionPane.INFORMATION_MESSAGE, IconReset);

                    reset();
                    loadClass();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }


    }//GEN-LAST:event_updatebtnActionPerformed

    private void deletebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebtnActionPerformed
        // TODO add your handling code here:
        ImageIcon Iconmessage = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Adyapana_Institute\\src\\img\\icons8_ok_64px.png");
        ImageIcon IconSelect = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Adyapana_Institute\\src\\img\\icons8_Insert_Row_Above_64px.png");
        ImageIcon IconReset = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Adyapana_Institute\\src\\img\\icons8_reset_64px_1.png");

        int selectRow = jTable3.getSelectedRow();
        if (selectRow == -1) {
            JOptionPane.showMessageDialog(this, "Please Select An Row", "Class Record Deleting Process", JOptionPane.INFORMATION_MESSAGE, IconSelect);
        } else {
            String id = String.valueOf(jTable3.getValueAt(selectRow, 0));
            try {
                MYSQLConnection.executeIUD("DELETE FROM `class_info` WHERE `idclass_info` = '" + id + "'");
                JOptionPane.showMessageDialog(this, "Record Delete Success", "Record Deleting", JOptionPane.INFORMATION_MESSAGE, Iconmessage);
                loadClass();
                JOptionPane.showMessageDialog(this, "This Window Resetting Now", "Window Resetting", JOptionPane.INFORMATION_MESSAGE, IconReset);
                reset();
                savebtn.setEnabled(true);
                updatebtn.setEnabled(false);
                deletebtn.setEnabled(false);
            } catch (Exception e) {
                e.printStackTrace();

            }
        }
    }//GEN-LAST:event_deletebtnActionPerformed

    private void jTextField6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyReleased
        // TODO add your handling code here:
        String searchtext = jTextField6.getText();
        if (searchtext.isEmpty()) {
            loadClass();
        } else {
            try {
                ResultSet resultSet = MYSQL.execute("SELECT * FROM `class_info` INNER JOIN `hall_tbl` ON `class_info`.`hall_tbl_idhall_tbl` = `hall_tbl`.`idhall_tbl` INNER JOIN `subject` ON `class_info`.`subject_idsubject`=`subject`.`idsubject` WHERE `class_code` = '" + searchtext + "' OR `idclass_info` = '" + searchtext + "'");
                DefaultTableModel model1 = (DefaultTableModel) jTable3.getModel();
                model1.setRowCount(0);
                while (resultSet.next()) {
                    Vector<String> v = new Vector<>();

                    v.add(resultSet.getString("idclass_info"));
                    v.add(resultSet.getString("class_code"));
                    v.add(resultSet.getString("class_name"));
                    v.add(resultSet.getString("from_time"));
                    v.add(resultSet.getString("to_time"));
                    v.add(resultSet.getString("date"));
                    v.add(resultSet.getString("hall_tbl.hall_name"));
                    v.add(resultSet.getString("subject.subject_name"));
                    v.add(resultSet.getString("added_date"));

                    v.add(resultSet.getString("updated_date"));

                    model1.addRow(v);
                    jTable3.setModel(model1);

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jTextField6KeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        FlatMacLightLaf.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Class_Registration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser clsdate;
    private javax.swing.JTextField clsgenaratedid;
    private javax.swing.JTextField clsname;
    private javax.swing.JButton deletebtn;
    private lu.tudor.santec.jtimechooser.JTimeChooser frontime;
    private javax.swing.JComboBox<String> hallnamecombo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JButton resetbtn;
    private javax.swing.JButton savebtn;
    private javax.swing.JComboBox<String> subjectcombo;
    private lu.tudor.santec.jtimechooser.JTimeChooser totime;
    private javax.swing.JButton updatebtn;
    // End of variables declaration//GEN-END:variables
}
