/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import static gui.Student_Registration.batchMap;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.MYSQLConnection;

/**
 *
 * @author User
 */
public class Student_and_Teacher_Enrollment extends javax.swing.JFrame {

    public static HashMap<String, Integer> TeacherMap = new HashMap<>();
    public static HashMap<String, Integer> ClassMap = new HashMap<>();

    /**
     * Creates new form Student_and_Teacher_Enrollment
     */
    public Student_and_Teacher_Enrollment() {
        initComponents();
        disablebutton();
        settileandicon();
        loadbatch();
        loadteacher();
        loadclass();
        loadstenrollmenttbl();
        deletebtn.setEnabled(false);
        updatebtn.setEnabled(false);
    }

    private void disablebutton() {
        jButton6.setEnabled(false);
    }

    private void settileandicon() {
        setTitle("Student and Teacher Enrollment");
        ImageIcon icon2 = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Adyapana_Institute\\src\\img\\icons8_sand_timer_64px.png");
        setIconImage(icon2.getImage());
    }

    private void loadteacher() {
        try {
            ResultSet resultSet7 = MYSQLConnection.executeSearch("SELECT * FROM `teacher_info`");

            Vector v7 = new Vector();
            v7.add("Select");
            while (resultSet7.next()) {
                v7.add(resultSet7.getString("full_name"));
                TeacherMap.put(resultSet7.getString("full_name"), resultSet7.getInt("idteacher_info"));
            }
            DefaultComboBoxModel model7 = new DefaultComboBoxModel(v7);
            teachercombo.setModel(model7);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadbatch() {
        try {
            ResultSet resultSet7 = MYSQLConnection.executeSearch("SELECT * FROM `batch`");

            Vector v7 = new Vector();
            v7.add("Select");
            while (resultSet7.next()) {
                v7.add(resultSet7.getString("batch_name"));
                batchMap.put(resultSet7.getString("batch_name"), resultSet7.getInt("idbatch"));
            }
            DefaultComboBoxModel model7 = new DefaultComboBoxModel(v7);
            batchcombo.setModel(model7);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadclass() {
        try {
            ResultSet resultSet7 = MYSQLConnection.executeSearch("SELECT * FROM `class_info`");

            Vector v7 = new Vector();
            v7.add("Select");
            while (resultSet7.next()) {
                v7.add(resultSet7.getString("class_name"));
                ClassMap.put(resultSet7.getString("class_name"), resultSet7.getInt("idclass_info"));
            }
            DefaultComboBoxModel model7 = new DefaultComboBoxModel(v7);
            classcombo.setModel(model7);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadstenrollmenttbl() {
        try {
            ResultSet resultSet = MYSQLConnection.executeSearch("SELECT * FROM `teacher_and_student_enrollment` "
                    + "INNER JOIN `class_info` ON `teacher_and_student_enrollment`.`class_info_idclass_info`=`class_info`.`idclass_info` "
                    + "INNER JOIN `teacher_info` ON `teacher_and_student_enrollment`.`teacher_info_idteacher_info`=`teacher_info`.`idteacher_info` "
                    + "INNER JOIN `batch` ON `teacher_and_student_enrollment`.`batch_idbatch`=`batch`.`idbatch`");
            DefaultTableModel modelClass = (DefaultTableModel) jTable1.getModel();
            modelClass.setRowCount(0);
            while (resultSet.next()) {
                Vector<String> vct = new Vector<>();

                vct.add(resultSet.getString("idteacher_and_student_enrollment"));
                vct.add(resultSet.getString("batch.batch_name"));
                vct.add(resultSet.getString("class_info.class_name"));
                vct.add(resultSet.getString("teacher_info.full_name"));
                vct.add(resultSet.getString("class_info.date"));
                vct.add(resultSet.getString("class_info.from_time"));
                vct.add(resultSet.getString("class_info.to_time"));
                vct.add(resultSet.getString("added_date"));
                vct.add(resultSet.getString("update_date"));

                modelClass.addRow(vct);
                jTable1.setModel(modelClass);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void resetST() {
        int option = JOptionPane.showConfirmDialog(this, "Do You Want To Reset This Window?", "Window Resetting", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (option == JOptionPane.YES_OPTION) {
            classcombo.setSelectedIndex(0);
            batchcombo.setSelectedIndex(0);
            teachercombo.setSelectedIndex(0);
            updatebtn.setEnabled(false);
            deletebtn.setEnabled(false);
            savebtn.setEnabled(true);
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
        jLabel3 = new javax.swing.JLabel();
        teachercombo = new javax.swing.JComboBox<>();
        classcombo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        batchcombo = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        searchtext = new javax.swing.JTextField();
        savebtn = new javax.swing.JButton();
        updatebtn = new javax.swing.JButton();
        resetbtn = new javax.swing.JButton();
        deletebtn = new javax.swing.JButton();
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
                .addGap(729, 729, 729)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 568, Short.MAX_VALUE)
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
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Verdana", 0, 30)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_class_64px.png"))); // NOI18N
        jButton5.setText("Class Registration");
        jButton5.setBorderPainted(false);

        jButton6.setFont(new java.awt.Font("Verdana", 0, 30)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_sand_timer_64px.png"))); // NOI18N
        jButton6.setText("S & T Enroll For Sub.");
        jButton6.setBorderPainted(false);

        jButton7.setFont(new java.awt.Font("Verdana", 0, 30)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_checked_user_male_64px.png"))); // NOI18N
        jButton7.setText("Student Attendence");
        jButton7.setBorderPainted(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

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

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Select Teacher :");

        teachercombo.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        teachercombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        classcombo.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        classcombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Select Class :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Select Student Batch :");

        batchcombo.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        batchcombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(classcombo, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(batchcombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(teachercombo, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(teachercombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(142, 142, 142)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(classcombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 147, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(batchcombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Batch Name", "Class Name", "Teacher Name", "Class Date", "From", "To", "Added Date & Time", "Updated Date & Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1408, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Search Enrollment By ID/Name :");

        searchtext.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        searchtext.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchtextKeyReleased(evt);
            }
        });

        savebtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        savebtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_save_64px_1.png"))); // NOI18N
        savebtn.setText("Save");
        savebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savebtnActionPerformed(evt);
            }
        });

        updatebtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        updatebtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_available_updates_64px.png"))); // NOI18N
        updatebtn.setText("Update");
        updatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebtnActionPerformed(evt);
            }
        });

        resetbtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        resetbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_reset_64px.png"))); // NOI18N
        resetbtn.setText("Reset");
        resetbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetbtnActionPerformed(evt);
            }
        });

        deletebtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        deletebtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_trash_can_64px.png"))); // NOI18N
        deletebtn.setText("Delete");
        deletebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebtnActionPerformed(evt);
            }
        });

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(403, 403, 403)
                                .addComponent(savebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(122, 122, 122)
                                .addComponent(updatebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(552, 552, 552)
                                .addComponent(resetbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(105, 105, 105)
                                .addComponent(deletebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(searchtext))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(savebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(updatebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(resetbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deletebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchtext, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(161, 161, 161)))
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

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int option = JOptionPane.showConfirmDialog(this, "Do you Want To Leave This Page?", "Information Message", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (option == JOptionPane.YES_OPTION) {
            Student_payments stu_pay = new Student_payments();
            stu_pay.setVisible(true);
            this.dispose();
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        int option = JOptionPane.showConfirmDialog(this, "Do you Want To Leave This Page?", "Information Message", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (option == JOptionPane.YES_OPTION) {
            Student_Attendence stu_attend = new Student_Attendence();
            stu_attend.setVisible(true);
            this.dispose();
        }

    }//GEN-LAST:event_jButton7ActionPerformed

    private void savebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savebtnActionPerformed
        // TODO add your handling code here:
        ImageIcon IconSuccess = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Adyapana_Institute\\src\\img\\icons8_done_64px.png");
        String teacherSelect = String.valueOf(teachercombo.getSelectedItem());
        String classSelect = String.valueOf(classcombo.getSelectedItem());
        String batchSelect = String.valueOf(batchcombo.getSelectedItem());

        Date date1 = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = dateFormat.format(date1);

        if (teacherSelect.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please Select Teacher", "Class Registration", JOptionPane.INFORMATION_MESSAGE);
            teachercombo.grabFocus();
        } else if (classSelect.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please Select Class", "Class Registration", JOptionPane.INFORMATION_MESSAGE);
            classcombo.grabFocus();
        } else if (batchSelect.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please Select Batch", "Class Registration", JOptionPane.INFORMATION_MESSAGE);
            batchcombo.grabFocus();
        } else {
            Integer teacherID = TeacherMap.get(teacherSelect);
            Integer classID = ClassMap.get(classSelect);
            Integer batchID = batchMap.get(batchSelect);

            try {
                MYSQLConnection.executeIUD("INSERT INTO `adyapana_institute`.`teacher_and_student_enrollment` (`class_info_idclass_info`, `teacher_info_idteacher_info`, `batch_idbatch`, `added_date`) VALUES ('" + classID + "','" + teacherID + "','" + batchID + "', '" + formattedDateTime + "')");
                JOptionPane.showMessageDialog(this, "Student And Teacher Enrollment Successfully", "Student And Enrollment Registration", JOptionPane.INFORMATION_MESSAGE, IconSuccess);
                loadstenrollmenttbl();
                resetST();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }//GEN-LAST:event_savebtnActionPerformed

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1KeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            savebtn.setEnabled(false);
            deletebtn.setEnabled(true);
            updatebtn.setEnabled(true);
            int selectRow = jTable1.getSelectedRow();
            String batch1 = String.valueOf(jTable1.getValueAt(selectRow, 1));
            batchcombo.setSelectedItem(batch1);
            String class1 = String.valueOf(jTable1.getValueAt(selectRow, 2));
            classcombo.setSelectedItem(class1);
            String teacher1 = String.valueOf(jTable1.getValueAt(selectRow, 3));
            teachercombo.setSelectedItem(teacher1);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void resetbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetbtnActionPerformed
        // TODO add your handling code here:
        resetST();
    }//GEN-LAST:event_resetbtnActionPerformed

    private void deletebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebtnActionPerformed
        // TODO add your handling code here:
        //DELETE FROM `adyapana_institute`.`teacher_and_student_enrollment` WHERE  `idteacher_and_student_enrollment`=2;

        ImageIcon Iconmessage = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Adyapana_Institute\\src\\img\\icons8_ok_64px.png");
        ImageIcon IconSelect = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Adyapana_Institute\\src\\img\\icons8_Insert_Row_Above_64px.png");

        int selectRow = jTable1.getSelectedRow();
        if (selectRow == -1) {
            JOptionPane.showMessageDialog(this, "Please Select An Row", "Record Deleting", JOptionPane.ERROR_MESSAGE, IconSelect);

        } else {
            String id = String.valueOf(jTable1.getValueAt(selectRow, 0));
            try {
                MYSQLConnection.executeIUD("DELETE FROM `teacher_and_student_enrollment` WHERE  `idteacher_and_student_enrollment`='" + id + "'");
                JOptionPane.showMessageDialog(this, "Record Delete Success", "Record Deleting", JOptionPane.INFORMATION_MESSAGE, Iconmessage);
                loadstenrollmenttbl();
                resetST();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_deletebtnActionPerformed

    private void updatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebtnActionPerformed
        // TODO add your handling code here:
        ImageIcon IconUpdate = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Adyapana_Institute\\src\\img\\icons8_ok_64px_1.png");
        ImageIcon IconUpdateError = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Adyapana_Institute\\src\\img\\icons8_error_64px.png");
        ImageIcon IconSelect = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Adyapana_Institute\\src\\img\\icons8_Insert_Row_Above_64px.png");
        ImageIcon ResetIcon = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Adyapana_Institute\\src\\img\\icons8_reset_64px_1.png");

        String teacheritem = String.valueOf(teachercombo.getSelectedItem());
        String classitem = String.valueOf(classcombo.getSelectedItem());
        String batchitem = String.valueOf(batchcombo.getSelectedItem());

        Date date1 = new Date();
        SimpleDateFormat dateupdateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedUpdateTime = dateupdateformat.format(date1);

        int selectRow = jTable1.getSelectedRow();
        if (selectRow == -1) {
            JOptionPane.showMessageDialog(this, "Please Select A row First", "Details Updating", JOptionPane.ERROR_MESSAGE, IconSelect);

        } else {
            String stID = String.valueOf(jTable1.getValueAt(selectRow, 0));

            if (teacheritem.equals("Select")) {
                JOptionPane.showMessageDialog(this, "Please Select Teacher", "Student & Teacher Enrollment", JOptionPane.ERROR_MESSAGE, IconUpdateError);
            } else if (classitem.equals("Select")) {
                JOptionPane.showMessageDialog(this, "Please Select Teacher", "Student & Teacher Enrollment", JOptionPane.ERROR_MESSAGE, IconUpdateError);
            } else if (batchitem.equals("Select")) {
                JOptionPane.showMessageDialog(this, "Please Select Batch", "Student & Teacher Enrollment", JOptionPane.ERROR_MESSAGE, IconUpdateError);
            } else {
                Integer teacherId = TeacherMap.get(teacheritem);
                Integer classId = ClassMap.get(classitem);
                Integer batchId = batchMap.get(batchitem);

                try {
                    MYSQLConnection.executeIUD("UPDATE `teacher_and_student_enrollment` SET `class_info_idclass_info`='" + classId + "', `teacher_info_idteacher_info` = '" + teacherId + "', `batch_idbatch` = '" + batchId + "', `update_date` = '" + formattedUpdateTime + "' WHERE `idteacher_and_student_enrollment` = '" + stID + "'");
//                    String message = classitem.concat(" ").concat(lastName);
                    JOptionPane.showMessageDialog(this, classitem + " Details Update Successfully ", "Student & Teacher Enrollment", JOptionPane.INFORMATION_MESSAGE, IconUpdate);
                    loadstenrollmenttbl();
                    JOptionPane.showMessageDialog(this, " This Window Reset Again ", "Window Resetting", JOptionPane.INFORMATION_MESSAGE, ResetIcon);
                    resetST();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }//GEN-LAST:event_updatebtnActionPerformed

    private void searchtextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchtextKeyReleased
        // TODO add your handling code here:
        String searchst = searchtext.getText();
        if (searchst.isEmpty()) {
            loadstenrollmenttbl();
        } else {
            try {
                ResultSet resultSet = MYSQLConnection.executeSearch("SELECT * FROM `teacher_and_student_enrollment`"
                        + " INNER JOIN `class_info` ON `teacher_and_student_enrollment`.`class_info_idclass_info`=`class_info`.`idclass_info` "
                        + "INNER JOIN `teacher_info` ON `teacher_and_student_enrollment`.`teacher_info_idteacher_info` = `teacher_info`.`idteacher_info` "
                        + "INNER JOIN `batch` ON `teacher_and_student_enrollment`.`batch_idbatch`=`batch`.`idbatch`"
                        + " WHERE `class_info`.`class_name` = '" + searchst + "' OR `teacher_info`.`full_name` = '" + searchst + "' OR `batch`.`batch_name` = '" + searchst + "'");
                DefaultTableModel modetseachst = (DefaultTableModel) jTable1.getModel();
                modetseachst.setRowCount(0);
                while (resultSet.next()) {
                    Vector<String> vst = new Vector<>();
                    vst.add(resultSet.getString("idteacher_and_student_enrollment"));
                    vst.add(resultSet.getString("batch.batch_name"));
                    vst.add(resultSet.getString("class_info.class_name"));
                    vst.add(resultSet.getString("teacher_info.full_name"));
                    vst.add(resultSet.getString("class_info.date"));
                    vst.add(resultSet.getString("class_info.from_time"));
                    vst.add(resultSet.getString("class_info.to_time"));
                    vst.add(resultSet.getString("added_date"));
                    vst.add(resultSet.getString("update_date"));

                    modetseachst.addRow(vst);
                    jTable1.setModel(modetseachst);

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_searchtextKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        FlatMacLightLaf.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Student_and_Teacher_Enrollment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> batchcombo;
    private javax.swing.JComboBox<String> classcombo;
    private javax.swing.JButton deletebtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton resetbtn;
    private javax.swing.JButton savebtn;
    private javax.swing.JTextField searchtext;
    private javax.swing.JComboBox<String> teachercombo;
    private javax.swing.JButton updatebtn;
    // End of variables declaration//GEN-END:variables

    private void setTile(String student_and_Teacher_Enrollment) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
