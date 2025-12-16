package gui;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Timer;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.MYSQLConnection;

public final class Student_Attendence extends javax.swing.JFrame {

    public static HashMap<String, Integer> DateMap = new HashMap<>();

    public Student_Attendence() {
        initComponents();
        disableButton();
        settitleandicon();
        loadStudent();
        buttonhide();
        fnamestu.setEnabled(false);
        lnamestu.setEnabled(false);
        batch.setEnabled(false);
        stuid.setEnabled(false);
        loadDate();
        jTable1.setEnabled(false);
        loadattendenttable();
        attendentStartInfo();
        search.setEnabled(false);

//        ButtonEnable();
//        done.setEnabled(false);
    }

    private void attendentStartInfo() {
        ImageIcon IconStart = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Adyapana_Institute\\src\\img\\icons8_start_skin_type_3_64px.png");
        JOptionPane.showMessageDialog(this, "Please Click Start Button To Start Attendent", "Attendent MArking", JOptionPane.INFORMATION_MESSAGE, IconStart);
    }

    private void disableButton() {
        jButton7.setEnabled(false);
    }

    private void settitleandicon() {
        setTitle("Student Attendence");
        ImageIcon icon2 = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Adyapana_Institute\\src\\img\\icons8_checked_user_male_64px.png");
        setIconImage(icon2.getImage());

    }

    private void loadStudent() {
        try {
            ResultSet resultSet = MYSQLConnection.executeSearch("SELECT * FROM `student_info` INNER JOIN `batch` ON `student_info`.`batch_idbatch` = `batch`.`idbatch`");
            //"SELECT * FROM `student_info` INNER JOIN `attendence_tbl` ON `attendence_tbl`.`student_info_student_id` = `student_info`.`student_id` INNER JOIN `batch` ON `student_info`.`batch_idbatch` = `batch`.`idbatch`"

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            while (resultSet.next()) {
                Vector<String> v = new Vector<>();

                v.add(resultSet.getString("student_id"));

                v.add(resultSet.getString("nic_no"));
                v.add(resultSet.getString("first_name"));
                v.add(resultSet.getString("last_name"));
                v.add(resultSet.getString("batch.batch_name"));

                model.addRow(v);
                jTable1.setModel(model);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void buttonhide() {
        markAttendent.setEnabled(false);
        done.setEnabled(false);
        end.setEnabled(false);
        reset.setEnabled(false);
    }

    private void loadDate() {
        try {
            ResultSet resultSet = MYSQLConnection.executeSearch("SELECT * FROM `attendent_date`");

            Vector v1 = new Vector();
            v1.add("Select");
            while (resultSet.next()) {
                v1.add(resultSet.getString("today_date"));
                DateMap.put(resultSet.getString("today_date"), resultSet.getInt("idattendent_date"));
            }
            DefaultComboBoxModel model = new DefaultComboBoxModel(v1);
            date.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void reset() {
        search.setText("");
        fnamestu.setText("");
        lnamestu.setText("");
        batch.setText("");
        stuid.setText("");
        date.setSelectedIndex(0);

    }

    private void loadattendenttable() {
        Date date1 = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDateTime = dateFormat.format(date1);
        try {
            ResultSet resultSet = MYSQLConnection.executeSearch("SELECT * FROM `attendence_tbl` "
                    + "INNER JOIN `student_info` ON `attendence_tbl`.`student_info_student_id`="
                    + "`student_info`.`student_id` INNER JOIN `attendence_type` ON "
                    + "`attendence_tbl`.`attendence_type_idattendence_type`="
                    + "`attendence_type`.`idattendence_type` INNER JOIN `attendent_date` ON "
                    + "`attendence_tbl`.`attendent_date_idattendent_date`=`attendent_date`.`idattendent_date` WHERE `today_date` = '" + formattedDateTime + "'ORDER BY `idattendence_tbl` ASC");

            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            model.setRowCount(0);
            while (resultSet.next()) {
                Vector<String> v = new Vector<>();

                v.add(resultSet.getString("student_info.nic_no"));
                v.add(resultSet.getString("attendence_type.type"));
                v.add(resultSet.getString("attendent_date.today_date"));
                v.add(resultSet.getString("attendent_time"));

                model.addRow(v);
                jTable2.setModel(model);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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
        search = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        search1 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        markAttendent = new javax.swing.JButton();
        done = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        stuid = new javax.swing.JTextField();
        fnamestu = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lnamestu = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        batch = new javax.swing.JTextField();
        Date = new javax.swing.JLabel();
        date = new javax.swing.JComboBox<>();
        start = new javax.swing.JButton();
        end = new javax.swing.JButton();
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

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

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Search Student By NIC / Name : ");

        search.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Search Student Attendence By NIC / Date : ");

        search1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        search1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search1KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(search1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(search1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "NIC", "First Name", "Last Name", "Batch"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setHeaderValue("Student ID");
        }

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NIC", "Attendent Type", "Attendet Date", "Attendent Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel8.setText("Student Attendent");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1051, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1051, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(453, 453, 453))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        markAttendent.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        markAttendent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_Checkmark_128px.png"))); // NOI18N
        markAttendent.setText("Mark Attence ");
        markAttendent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                markAttendentActionPerformed(evt);
            }
        });

        done.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        done.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_done_64px.png"))); // NOI18N
        done.setText("All Done");
        done.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doneActionPerformed(evt);
            }
        });

        reset.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        reset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_reset_64px.png"))); // NOI18N
        reset.setText("Reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("NIC :");

        stuid.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        fnamestu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("First Name :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Last Name :");

        lnamestu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Batch :");

        batch.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        Date.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Date.setText("Date :");

        date.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(0, 245, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stuid, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(228, 228, 228))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(batch, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(fnamestu, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addComponent(Date)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lnamestu, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(stuid, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)))
                .addGap(12, 12, 12)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(fnamestu, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lnamestu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(batch, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(Date)
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        start.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        start.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_start_skin_type_3_64px.png"))); // NOI18N
        start.setText("Start");
        start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startActionPerformed(evt);
            }
        });

        end.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        end.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_end_64px.png"))); // NOI18N
        end.setText("End");
        end.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endActionPerformed(evt);
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(markAttendent, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(start, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(end, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addComponent(done, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(197, 197, 197))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(markAttendent, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(done, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(start, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(end, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 33, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
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

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        int option = JOptionPane.showConfirmDialog(this, "Do you Want To Leave This Page?", "Information Message", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (option == JOptionPane.YES_OPTION) {
            Class_Registration clz_rg = new Class_Registration();
            clz_rg.setVisible(true);
            this.dispose();
        }

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        int option = JOptionPane.showConfirmDialog(this, "Do you Want To Leave This Page?", "Information Message", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (option == JOptionPane.YES_OPTION) {
            Student_and_Teacher_Enrollment stutecenrol = new Student_and_Teacher_Enrollment();
            stutecenrol.setVisible(true);
            this.dispose();
        }

    }//GEN-LAST:event_jButton6ActionPerformed

    private void startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startActionPerformed
        // TODO add your handling code here:
        search.setEnabled(true);
        ImageIcon IconStart = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Adyapana_Institute\\src\\img\\icons8_start_skin_type_3_64px.png");
        ImageIcon Iconbad = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Adyapana_Institute\\src\\img\\icons8_bad_decision_64px.png");
        int option = JOptionPane.showConfirmDialog(this, "Do You Want To Start Mark The Attendence?", "Attendent Marking Process", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, IconStart);
        Date date1 = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = dateFormat.format(date1);
        if (option == JOptionPane.YES_OPTION) {
            start.setEnabled(false);
            markAttendent.setEnabled(true);
            reset.setEnabled(true);
            end.setEnabled(true);
            jTable1.setEnabled(true);
            try {
                MYSQLConnection.executeIUD("INSERT INTO `attendent_date`(`today_date`) VALUES ('" + formattedDateTime + "') ");
                System.out.println("Date Added");
                loadDate();
            } catch (Exception e) {
                e.printStackTrace();

            }
        } else {
            JOptionPane.showMessageDialog(this, "Marking Attendence Discard", "Attendent Marking", JOptionPane.INFORMATION_MESSAGE, Iconbad);
            start.setEnabled(true);
            markAttendent.setEnabled(false);
            reset.setEnabled(false);
            end.setEnabled(false);
        }

    }//GEN-LAST:event_startActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_resetActionPerformed

    private void endActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endActionPerformed
        // TODO add your handling code here:
        ImageIcon Iconattention = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Adyapana_Institute\\src\\img\\icons8_stop_sign_64px.png");
        int option = JOptionPane.showConfirmDialog(this, "Do You Want To End Attendence Marking Process? (Because If You End This Process You Cannot Add Another Response To This Attendent Time)", "End Process", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, Iconattention);
        if (option == JOptionPane.YES_OPTION) {
            start.setEnabled(false);
            markAttendent.setEnabled(false);
            reset.setEnabled(false);
            end.setEnabled(false);
            done.setEnabled(true);
        }
        //SELECT `idattendence_tbl`, `student_info_student_id`, `attendence_type_idattendence_type`, `attendent_date_idattendent_date` FROM `adyapana_institute`.`attendence_tbl` WHERE  `idattendence_tbl`=1;
///INSERT INTO `adyapana_institute`.`attendence_tbl` (`student_info_student_id`, `attendence_type_idattendence_type`, `attendent_date_idattendent_date`) VALUES ('10', '1', '3');
    }//GEN-LAST:event_endActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            int selectRow = jTable1.getSelectedRow();
            String StuID = String.valueOf(jTable1.getValueAt(selectRow, 0));
            String StuNIC = String.valueOf(jTable1.getValueAt(selectRow, 1));
            stuid.setText(StuNIC);
            String StuFName = String.valueOf(jTable1.getValueAt(selectRow, 2));
            fnamestu.setText(StuFName);
            String StuLName = String.valueOf(jTable1.getValueAt(selectRow, 3));
            lnamestu.setText(StuLName);
            String StuBatch = String.valueOf(jTable1.getValueAt(selectRow, 4));
            batch.setText(StuBatch);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable2MouseClicked

    private void markAttendentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_markAttendentActionPerformed
        // TODO add your handling code here:
        ImageIcon IconSuccess = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Adyapana_Institute\\src\\img\\icons8_done_64px.png");
        String STUfname = fnamestu.getText();
        String STUlname = lnamestu.getText();
        String FullName = STUfname + " " + STUlname;
        int option = JOptionPane.showConfirmDialog(this, FullName + "Do You Want To Mark Attendnt For This Student ?", "MArk Attendent", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        String DateSelect = String.valueOf(date.getSelectedItem());

        if (option == JOptionPane.YES_OPTION) {

            LocalTime currentTime = LocalTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            String currentTimeString = currentTime.format(formatter);
            int selectRow = jTable1.getSelectedRow();

            if (selectRow == -1) {
                JOptionPane.showMessageDialog(this, "Please Select A row First", "Details Updating", JOptionPane.ERROR_MESSAGE);

            } else {
                if (DateSelect.equals("Select")) {
                    JOptionPane.showMessageDialog(this, "Please Select Date", "Date Select", JOptionPane.INFORMATION_MESSAGE);
                    date.grabFocus();
                } else {
                    String stuid1 = String.valueOf(jTable1.getValueAt(selectRow, 0));
                    Integer DateID = DateMap.get(DateSelect);
                    try {
                        MYSQLConnection.executeIUD("INSERT INTO `attendence_tbl` (`student_info_student_id`,`attendence_type_idattendence_type`,`attendent_date_idattendent_date`,`attendent_time`) VALUES ('" + stuid1 + "','1','" + DateID + "','" + currentTimeString + "')");
                        JOptionPane.showMessageDialog(this, "Student Attendent Mark Successfully", "Attendence Marking", JOptionPane.INFORMATION_MESSAGE, IconSuccess);
                        reset();
                        loadattendenttable();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

        }


    }//GEN-LAST:event_markAttendentActionPerformed

    private void doneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doneActionPerformed
        // TODO add your handling code here:
        ImageIcon Icontnx = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Adyapana_Institute\\src\\img\\icons8_you_(singular)_64px.png");
        JOptionPane.showMessageDialog(this, "Attendent Added Successfully", "Thank You!", JOptionPane.INFORMATION_MESSAGE, Icontnx);
        start.setEnabled(true);
        markAttendent.setEnabled(false);
        reset.setEnabled(false);
        end.setEnabled(false);
        jTable1.setEnabled(false);
        reset();
        done.setEnabled(false);
        loadStudent();
    }//GEN-LAST:event_doneActionPerformed

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased
        // TODO add your handling code here:
        String search1 = search.getText();

        if (search1.isEmpty()) {
            loadStudent();

        } else {
            try {
                ResultSet resultSet1 = MYSQLConnection.executeSearch("SELECT *FROM `student_info` INNER JOIN `gender` ON "
                        + "`student_info`.`gender_gender_id` = `gender`.`gender_id` INNER JOIN `nationality` ON `student_info`.`nationality_nationalityid` = `nationality`.`nationalityid` INNER JOIN "
                        + "`city` ON `student_info`.`city_city_id` = `city`.`city_id` INNER JOIN `province` ON `student_info`.`Province_idProvince` = `province`.`idProvince` INNER JOIN "
                        + "`country` ON `student_info`.`country_idcountry` = `country`.`idcountry` INNER JOIN `course` ON `student_info`.`Course_course_id` = `course`.`course_id` INNER JOIN"
                        + "`department` ON `student_info`.`department_iddepartment` = `department`.`iddepartment` INNER JOIN `batch` ON `student_info`.`batch_idbatch` = `batch`.`idbatch` INNER JOIN"
                        + "`relationshiptostudent` ON `student_info`.`relationshiptostudent_idrelationshiptostudent` = `relationshiptostudent`.`idrelationshiptostudent` INNER JOIN"
                        + "`emegency_relation` on `student_info`.`Emegency_relation_idEmegency_relation` = `emegency_relation`.`idEmegency_relation` WHERE `nic_no` = '" + search1 + "' OR `first_name` = '" + search1 + "'");
                DefaultTableModel modelsearch = (DefaultTableModel) jTable1.getModel();
                modelsearch.setRowCount(0);
                while (resultSet1.next()) {
                    Vector<String> vs = new Vector<>();
                    vs.add(resultSet1.getString("student_id"));

                    vs.add(resultSet1.getString("nic_no"));
                    vs.add(resultSet1.getString("first_name"));
                    vs.add(resultSet1.getString("last_name"));
                    vs.add(resultSet1.getString("batch.batch_name"));

                    modelsearch.addRow(vs);
                    jTable1.setModel(modelsearch);

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_searchKeyReleased

    private void search1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search1KeyReleased
        // TODO add your handling code here:
        String search11 = search1.getText();

        if (search11.isEmpty()) {
            loadattendenttable();

        } else {
            try {
                ResultSet resultSet1 = MYSQLConnection.executeSearch("SELECT * FROM `attendence_tbl` "
                        + "INNER JOIN `student_info` ON `attendence_tbl`.`student_info_student_id`="
                        + "`student_info`.`student_id` INNER JOIN `attendence_type` ON "
                        + "`attendence_tbl`.`attendence_type_idattendence_type`="
                        + "`attendence_type`.`idattendence_type` INNER JOIN `attendent_date` ON "
                        + "`attendence_tbl`.`attendent_date_idattendent_date`=`attendent_date`.`idattendent_date` WHERE `student_info`.`nic_no` = '" + search11 + "'");
                DefaultTableModel modelsearch = (DefaultTableModel) jTable2.getModel();
                modelsearch.setRowCount(0);
                while (resultSet1.next()) {
                    Vector<String> vs = new Vector<>();
                    vs.add(resultSet1.getString("student_info.nic_no"));
                    vs.add(resultSet1.getString("attendence_type.type"));
                    vs.add(resultSet1.getString("attendent_date.today_date"));
                    vs.add(resultSet1.getString("attendent_time"));

                    modelsearch.addRow(vs);
                    jTable2.setModel(modelsearch);

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_search1KeyReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        Student_payments stupay = new Student_payments();
        stupay.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    public static void main(String args[]) {
        FlatMacLightLaf.setup();

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Student_Attendence().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Date;
    private javax.swing.JTextField batch;
    private javax.swing.JComboBox<String> date;
    private javax.swing.JButton done;
    private javax.swing.JButton end;
    private javax.swing.JTextField fnamestu;
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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField lnamestu;
    private javax.swing.JButton markAttendent;
    private javax.swing.JButton reset;
    private javax.swing.JTextField search;
    private javax.swing.JTextField search1;
    private javax.swing.JButton start;
    private javax.swing.JTextField stuid;
    // End of variables declaration//GEN-END:variables

    private ActionListener ActionEvent() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
