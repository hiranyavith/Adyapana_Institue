package gui;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import static gui.Student_Registration.ProvinceMap;
import static gui.Student_Registration.citiesMap;
import static gui.Student_Registration.countryMap;
import static gui.Student_Registration.depatmentMap;
import static gui.Student_Registration.nationalMap;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.ButtonModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.MYSQLConnection;

public class Teacher_enrollment extends javax.swing.JFrame {

    public static HashMap<String, Integer> SubjectMap = new HashMap<>();

    public Teacher_enrollment() {
        initComponents();
        settitleandicon();
        loadcities();
        loadProvince();
        loadnational();
        loadCountries();
        loaddepartment();
//        loadSubject();
        loadTeachers();
        jButton12.setEnabled(false);
        jButton11.setEnabled(false);

    }

    private void settitleandicon() {
        setTitle("Teacher Enrollment");
        ImageIcon iconteacherenroll = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Adyapana_Institute\\src\\img\\icons8_teacher_64px.png");
        setIconImage(iconteacherenroll.getImage());
        jButton2.setEnabled(false);
    }

    private void loadcities() {
        try {
            ResultSet resultSet3 = MYSQLConnection.executeSearch("SELECT * FROM `city`");

            Vector v2 = new Vector();
            v2.add("Select");
            while (resultSet3.next()) {
                v2.add(resultSet3.getString("name"));
                citiesMap.put(resultSet3.getString("name"), resultSet3.getInt("city_id"));

            }
            DefaultComboBoxModel model1 = new DefaultComboBoxModel(v2);
            cityCombo.setModel(model1);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadProvince() {
        try {
            ResultSet resultSet4 = MYSQLConnection.executeSearch("SELECT * FROM `province`");

            Vector v4 = new Vector();
            v4.add("Select");
            while (resultSet4.next()) {
                v4.add(resultSet4.getString("province_name"));
                ProvinceMap.put(resultSet4.getString("province_name"), resultSet4.getInt("idProvince"));
            }
            DefaultComboBoxModel model4 = new DefaultComboBoxModel(v4);
            provinceCombo.setModel(model4);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadnational() {
        try {
            ResultSet resultSet1 = MYSQLConnection.executeSearch("SELECT * FROM `nationality`");

            Vector v1 = new Vector();
            v1.add("Select");
            while (resultSet1.next()) {
                v1.add(resultSet1.getString("nationality_type"));
                nationalMap.put(resultSet1.getString("nationality_type"), resultSet1.getInt("nationalityid"));
            }
            DefaultComboBoxModel model2 = new DefaultComboBoxModel(v1);
            nationalCombo.setModel(model2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadCountries() {
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Adyapana_institute", "root", "Inter@357#%&N");
//            Statement statement = connection.createStatement();
//            ResultSet resultset = statement.executeQuery("SELECT * FROM `country`");

            ResultSet resultSet = MYSQLConnection.executeSearch("SELECT * FROM `country`");

            Vector v = new Vector();
            v.add("Select");
            while (resultSet.next()) {
                v.add(resultSet.getString("name"));
                countryMap.put(resultSet.getString("name"), resultSet.getInt("idcountry"));
            }
            DefaultComboBoxModel model1 = new DefaultComboBoxModel(v);
            countyCombo.setModel(model1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loaddepartment() {
        try {
            ResultSet resultSet6 = MYSQLConnection.executeSearch("SELECT * FROM `department`");

            Vector v6 = new Vector();
            v6.add("Select");
            while (resultSet6.next()) {
                v6.add(resultSet6.getString("department_name"));
                depatmentMap.put(resultSet6.getString("department_name"), resultSet6.getInt("iddepartment"));
            }
            DefaultComboBoxModel model6 = new DefaultComboBoxModel(v6);
            departmentCombo.setModel(model6);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadSubject() {
        try {
            ResultSet resultSet = MYSQLConnection.executeSearch("SELECT * FROM `subject` INNER JOIN `status` ON `subject`.`idsubject` = `status`.`idstatus` WHERE `status`.`type` = 'Active'");
            Vector<String> vdep = new Vector<>();
            vdep.add("Select");

            while (resultSet.next()) {
                vdep.add(resultSet.getString("subject_name"));
                SubjectMap.put(resultSet.getString("subject_name"), resultSet.getInt("idsubject"));
            }

            DefaultComboBoxModel<String> modelDep = new DefaultComboBoxModel<>(vdep);
//            subjectCombo.setModel(modelDep);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void resetTeachers() {
        teacherfullName.setText("");
        teacherNic.setText("");
        buttonGroup1.clearSelection();
        teachetBirthDay.setDate(null);
        nationalCombo.setSelectedIndex(0);
        teacher_email.setText("");
        teacher_addresText.setText("");
        teacher_postalCode.setText("");
        ContactnumberTeacher.setText("");
        provinceCombo.setSelectedIndex(0);
        cityCombo.setSelectedIndex(0);
        countyCombo.setSelectedIndex(0);
//        subjectCombo.setSelectedIndex(0);
        departmentCombo.setSelectedIndex(0);
        jButton10.setEnabled(true);
        teacherfullName.grabFocus();
        jButton12.setEnabled(false);
        jButton11.setEnabled(false);

    }

    private void loadTeachers() {
        try {
            ResultSet resultSet = MYSQLConnection.executeSearch("SELECT * FROM `teacher_info` INNER JOIN `gender` ON `teacher_info`.`gender_gender_id` = `gender`.`gender_id` INNER JOIN `country` ON `teacher_info`.`country_idcountry` = `country`.`idcountry` "
                    + "INNER JOIN `department` ON `teacher_info`.`department_iddepartment` = `department`.`iddepartment` INNER JOIN `nationality` ON `teacher_info`.`nationality_nationalityid` = `nationality`.`nationalityid`"
                    + "INNER JOIN `province` ON `teacher_info`.`Province_idProvince` = `province`.`idProvince` INNER JOIN `city` ON `teacher_info`.`city_city_id` = `city`.`city_id`");
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            while (resultSet.next()) {
                Vector<String> v = new Vector<>();

                v.add(resultSet.getString("idteacher_info"));
                v.add(resultSet.getString("full_name"));
                v.add(resultSet.getString("teacher_nic"));
                v.add(resultSet.getString("teacher_phone"));
                v.add(resultSet.getString("date_of_birth_teacher"));
                v.add(resultSet.getString("teacher_mail"));
                v.add(resultSet.getString("teacher_address"));
                v.add(resultSet.getString("teacher_postal_code"));
//                v.add(resultSet.getString("subject.subject_name"));
                v.add(resultSet.getString("gender.gender_type"));
                v.add(resultSet.getString("country.name"));
                v.add(resultSet.getString("department.department_name"));
                v.add(resultSet.getString("nationality.nationality_type"));
                v.add(resultSet.getString("province.province_name"));
                v.add(resultSet.getString("city.name"));
                v.add(resultSet.getString("teacher_added_date"));
                v.add(resultSet.getString("teacher_update_date"));

                model.addRow(v);
                jTable1.setModel(model);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        teacherfullName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        teachetBirthDay = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        nationalCombo = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        teacher_email = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        teacher_addresText = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        cityCombo = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        provinceCombo = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        teacher_postalCode = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        countyCombo = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        teacherNic = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel17 = new javax.swing.JLabel();
        departmentCombo = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        ContactnumberTeacher = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_school_64px_resize.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 40)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Adyapana Institute");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(729, 729, 729)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
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
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(204, 204, 255));
        jButton8.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jButton8.setText("Home");
        jButton8.setBorderPainted(false);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 242, 242));

        jLabel3.setText("Full Name :");

        jLabel4.setText("Gender :");

        jLabel6.setText("Date Of Birth :");

        jLabel7.setText("Nationality :");

        nationalCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel8.setText("E - mail :");

        jLabel9.setText("Address :");

        teacher_addresText.setColumns(20);
        teacher_addresText.setRows(5);
        jScrollPane1.setViewportView(teacher_addresText);

        jLabel10.setText("City :");

        cityCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel11.setText("Province :");

        provinceCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel12.setText("Postal Code :");

        jButton9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_reset_64px.png"))); // NOI18N
        jButton9.setText("Reset");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_save_64px_1.png"))); // NOI18N
        jButton10.setText("Save");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_trash_can_64px.png"))); // NOI18N
        jButton11.setText("Delete");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_available_updates_64px.png"))); // NOI18N
        jButton12.setText("Update");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jLabel13.setText("Country :");

        countyCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel15.setText("Teacher NIC :");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Male");
        jRadioButton1.setActionCommand("1");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Female");
        jRadioButton2.setActionCommand("2");

        jLabel17.setText("Department :");

        departmentCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel18.setText("Contact Number :");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel8)
                        .addGap(7, 7, 7)
                        .addComponent(teacher_email, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel7)
                        .addGap(5, 5, 5)
                        .addComponent(nationalCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(5, 5, 5)
                                .addComponent(teachetBirthDay, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel18))
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(teacher_postalCode, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ContactnumberTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(16, 16, 16)
                            .addComponent(jLabel4)))
                    .addComponent(jLabel15))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(teacherNic)
                            .addComponent(teacherfullName, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton1)
                        .addGap(37, 37, 37)
                        .addComponent(jRadioButton2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(countyCombo, 0, 242, Short.MAX_VALUE)
                    .addComponent(provinceCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cityCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(13, 13, 13))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(departmentCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(teacherfullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(teacherNic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton2))
                        .addGap(21, 21, 21))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(teacher_postalCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(provinceCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel17)
                                        .addComponent(departmentCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel13)
                                        .addComponent(countyCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cityCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel18))
                            .addComponent(ContactnumberTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel6))
                            .addComponent(teachetBirthDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel7))
                            .addComponent(nationalCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel8))
                            .addComponent(teacher_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(236, 242, 255));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 234, 211), 1, true));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Personal Information");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addContainerGap())
        );

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel14.setText("Teachers NIC / Name");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Full Name", "Teacher NIC", "Teacher Phone", "DOB", "Email", "Address", "Postal Code", "Gender", "Country", "Department", "nationality", "Province", "City", "Added Date", "Updated Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
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
        jScrollPane2.setViewportView(jTable1);

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(378, 378, 378)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        int option = JOptionPane.showConfirmDialog(this, "Do you Want To Leave This Page?", "Information Message", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (option == JOptionPane.YES_OPTION) {
            Home home = new Home();
            home.setVisible(true);
            this.dispose();
        }

    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int option = JOptionPane.showConfirmDialog(this, "Do you Want To Leave This Page?", "Information Message", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (option == JOptionPane.YES_OPTION) {
            Student_payments stu_payments = new Student_payments();
            stu_payments.setVisible(true);
            this.dispose();
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        int option = JOptionPane.showConfirmDialog(this, "Do you Want To Leave This Page?", "Information Message", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (option == JOptionPane.YES_OPTION) {
            Student_Attendence stuaddent = new Student_Attendence();
            stuaddent.setVisible(true);
            this.dispose();
        }

    }//GEN-LAST:event_jButton7ActionPerformed

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

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        ImageIcon IconSaveError = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Adyapana_Institute\\src\\img\\icons8_error_64px.png");
        ImageIcon IconSave = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Adyapana_Institute\\src\\img\\icons8_ok_64px_1.png");

        String fullName = teacherfullName.getText();
        String NIC = teacherNic.getText();
        ButtonModel gernderTeacher = buttonGroup1.getSelection();

//        Date Dateob = teachetBirthDay.getDate();//bithday
//        LocalDate localDate = Dateob.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//        String birthday1 = String.valueOf(localDate);
        String nationality = String.valueOf(nationalCombo.getSelectedItem());
        String Emailteacher = teacher_email.getText();
        String teacherAddress = teacher_addresText.getText();
        String teacherPC = teacher_postalCode.getText();
        String provinceteacher = String.valueOf(provinceCombo.getSelectedItem());
        String cityteacher = String.valueOf(cityCombo.getSelectedItem());
        String countryteacher = String.valueOf(countyCombo.getSelectedItem());
//        String subjectteacher = String.valueOf(subjectCombo.getSelectedItem());
        String departmentteacher = String.valueOf(departmentCombo.getSelectedItem());
        String teachetCnumber = ContactnumberTeacher.getText();

        Date date1 = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedteacheraddDateTime = dateFormat.format(date1);

        if (fullName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Teacher Full Name", "Teacher Registration", JOptionPane.INFORMATION_MESSAGE, IconSaveError);
            teacherfullName.grabFocus();
        } else if (NIC.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Teacher National Identity Card Number", "Teacher Registration", JOptionPane.INFORMATION_MESSAGE, IconSaveError);
            teacherNic.grabFocus();
        } else if (gernderTeacher == null) {
            JOptionPane.showMessageDialog(this, "Please Select Gender", "Teacher Registration", JOptionPane.INFORMATION_MESSAGE, IconSaveError);
            jRadioButton1.grabFocus();
        } else if (nationality.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please Select Nationality", "Teacher Registration", JOptionPane.INFORMATION_MESSAGE, IconSaveError);
            nationalCombo.grabFocus();
        } else if (Emailteacher.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Email Address", "Teacher Registration", JOptionPane.INFORMATION_MESSAGE, IconSaveError);
            teacher_email.grabFocus();
        } else if (teacherAddress.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Teacher Street Address", "Teacher Registration", JOptionPane.INFORMATION_MESSAGE, IconSaveError);
            teacher_addresText.grabFocus();
        } else if (teacherPC.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Teacher Postal Code", "Teacher Registration", JOptionPane.INFORMATION_MESSAGE, IconSaveError);
            teacher_postalCode.grabFocus();
        } else if (provinceteacher.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please Select Province", "Teacher Registration", JOptionPane.INFORMATION_MESSAGE, IconSaveError);
            provinceCombo.grabFocus();
        } else if (cityteacher.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please Select City", "Teacher Registration", JOptionPane.INFORMATION_MESSAGE, IconSaveError);
            cityCombo.grabFocus();
        } else if (countryteacher.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please Select City", "Teacher Registration", JOptionPane.INFORMATION_MESSAGE, IconSaveError);
            countyCombo.grabFocus();
//        } 
//        else if (subjectteacher.equals("Select")) {
//            JOptionPane.showMessageDialog(this, "Please Select Subject", "Teacher Registration", JOptionPane.INFORMATION_MESSAGE, IconSaveError);
//            subjectCombo.grabFocus();
        } else if (departmentteacher.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please Select Department", "Teacher Registration", JOptionPane.INFORMATION_MESSAGE, IconSaveError);
            departmentCombo.grabFocus();
        } else if (teachetCnumber.isEmpty() || teachetCnumber.length() != 10) {
            JOptionPane.showMessageDialog(this, "Please Enter Teacher Contact Number OR Check The Validation", "Teacher Registration", JOptionPane.INFORMATION_MESSAGE, IconSaveError);
            ContactnumberTeacher.grabFocus();
        } else {
            String genderID = gernderTeacher.getActionCommand();
            Integer nationalityID = nationalMap.get(nationality);
            Integer ProvinceID = ProvinceMap.get(provinceteacher);
            Integer CityID = citiesMap.get(cityteacher);
            Integer CountryID = countryMap.get(countryteacher);
//            Integer subJectID = SubjectMap.get(subjectteacher);
            Integer DepartmentID = depatmentMap.get(departmentteacher);

            Date Dateob = teachetBirthDay.getDate();//bithday
            LocalDate localDate = Dateob.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            String birthday1 = String.valueOf(localDate);

            try {
                MYSQLConnection.executeIUD("INSERT INTO `teacher_info` "
                        + "(`full_name`,`teacher_nic`,`teacher_phone`,`date_of_birth_teacher`,`teacher_mail`,`teacher_address`,`teacher_postal_code`,`gender_gender_id`,`country_idcountry`,`department_iddepartment`,`nationality_nationalityid`,`Province_idProvince`,`city_city_id`,`teacher_added_date`) "
                        + "VALUES ('" + fullName + "','" + NIC + "','" + teachetCnumber + "', '" + birthday1 + "', '" + Emailteacher + "', '" + teacherAddress + "',"
                        + " '" + teacherPC + "', '" + genderID + "', '" + CountryID + "', '" + DepartmentID + "',"
                        + " '" + nationalityID + "', '" + ProvinceID + "', '" + CityID + "', '" + formattedteacheraddDateTime + "')");
                JOptionPane.showMessageDialog(this, "This Window Automatically Resetted", "Window Reset", JOptionPane.INFORMATION_MESSAGE);
                resetTeachers();
                JOptionPane.showMessageDialog(this, "Teacher Registration is Success", "Teacher Registation", JOptionPane.INFORMATION_MESSAGE, IconSave);
                loadTeachers();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        ImageIcon iconreset = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Adyapana_Institute\\src\\img\\icons8_sync_64px.png");
        int option = JOptionPane.showConfirmDialog(this, "Do You Want To Reset This Window?", "Window Resetting", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, iconreset);
        if (option == JOptionPane.YES_OPTION) {
            resetTeachers();
            teacherfullName.grabFocus();
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            jButton10.setEnabled(false);
            jButton12.setEnabled(true);
            jButton11.setEnabled(true);

            int selectRow = jTable1.getSelectedRow();

            String ID1 = String.valueOf(jTable1.getValueAt(selectRow, 0));
            String FIRSTNAME = String.valueOf(jTable1.getValueAt(selectRow, 1));
            teacherfullName.setText(FIRSTNAME);
            String NIC = String.valueOf(jTable1.getValueAt(selectRow, 2));
            teacherNic.setText(NIC);
            String CONTACTNO = String.valueOf(jTable1.getValueAt(selectRow, 3));
            ContactnumberTeacher.setText(CONTACTNO);
            String DOB = String.valueOf(jTable1.getValueAt(selectRow, 4));

// Parse the string value to a Date object using SimpleDateFormat
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = null;
            try {
                date = dateFormat.parse(DOB);
            } catch (ParseException e) {
                e.printStackTrace();
            }

// Set the parsed date to the JDateChooser component
            teachetBirthDay.setDate(date);

            String EMAIL = String.valueOf(jTable1.getValueAt(selectRow, 5));
            teacher_email.setText(EMAIL);
            String ADDRESS = String.valueOf(jTable1.getValueAt(selectRow, 6));
            teacher_addresText.setText(ADDRESS);
            String POSTALCODE = String.valueOf(jTable1.getValueAt(selectRow, 7));
            teacher_postalCode.setText(POSTALCODE);
//            String SUBJECT = String.valueOf(jTable1.getValueAt(selectRow, 8));
//            subjectCombo.setSelectedItem(SUBJECT);
            String GENDER = String.valueOf(jTable1.getValueAt(selectRow, 8));

            if (GENDER.equals("Male")) {
                jRadioButton1.setSelected(true);
            } else {
                jRadioButton2.setSelected(true);
            }

            String COUNTRY = String.valueOf(jTable1.getValueAt(selectRow, 9));
            countyCombo.setSelectedItem(COUNTRY);

            String DEPARTMENT = String.valueOf(jTable1.getValueAt(selectRow, 10));
            departmentCombo.setSelectedItem(DEPARTMENT);

            String NATIONALITY = String.valueOf(jTable1.getValueAt(selectRow, 11));
            nationalCombo.setSelectedItem(NATIONALITY);

            String PROVINCE = String.valueOf(jTable1.getValueAt(selectRow, 12));
            provinceCombo.setSelectedItem(PROVINCE);

            String City = String.valueOf(jTable1.getValueAt(selectRow, 13));
            cityCombo.setSelectedItem(City);

        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        ImageIcon IconUpdate = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Adyapana_Institute\\src\\img\\icons8_ok_64px_1.png");
        ImageIcon IconUpdateError = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Adyapana_Institute\\src\\img\\icons8_error_64px.png");
        ImageIcon IconSelect = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Adyapana_Institute\\src\\img\\icons8_Insert_Row_Above_64px.png");
        ImageIcon ResetIcon = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Adyapana_Institute\\src\\img\\icons8_reset_64px_1.png");

        String FirstName = teacherfullName.getText();
        String teacherNIC = teacherNic.getText();

        String Nationality = String.valueOf(nationalCombo.getSelectedItem());
        String EmailAdd = teacher_email.getText();
        String teacherAdd = teacher_addresText.getText();
        String PostalCodteacher = teacher_postalCode.getText();
        String teacherphone = ContactnumberTeacher.getText();
        String teacherProvince = String.valueOf(provinceCombo.getSelectedItem());
        String teacherCity = String.valueOf(cityCombo.getSelectedItem());
        String teacherCountry = String.valueOf(countyCombo.getSelectedItem());
//        String teacherSubject = String.valueOf(subjectCombo.getSelectedItem());
        String teacherDepartment = String.valueOf(departmentCombo.getSelectedItem());

        Date Udate1 = new Date();
        SimpleDateFormat dateUFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedUDateTime = dateUFormat.format(Udate1);

        int selectRow = jTable1.getSelectedRow();
        if (selectRow == -1) {
            JOptionPane.showMessageDialog(this, "Please Select A Row", "Teache Updating", JOptionPane.ERROR_MESSAGE);
        } else {
            String teaid = String.valueOf(jTable1.getValueAt(selectRow, 0));

            ButtonModel GenderSelect = buttonGroup1.getSelection();
            if (FirstName.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Enter Teacher Name", "Details Updating", JOptionPane.INFORMATION_MESSAGE, IconUpdateError);
                teacherfullName.grabFocus();
            } else if (teacherNIC.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Enter Teacher NIC", "Details Updating", JOptionPane.INFORMATION_MESSAGE, IconUpdateError);
                teacherNic.grabFocus();
            } else if (Nationality.equals("Select")) {
                JOptionPane.showMessageDialog(this, "Please Select Nationality", "Details Updating", JOptionPane.INFORMATION_MESSAGE, IconUpdateError);
                nationalCombo.grabFocus();
            } else if (EmailAdd.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Enter Teacher Email", "Details Updating", JOptionPane.INFORMATION_MESSAGE, IconUpdateError);
                teacher_email.grabFocus();
            } else if (teacherAdd.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Enter Teacher Address", "Details Updating", JOptionPane.INFORMATION_MESSAGE, IconUpdateError);
                teacher_addresText.grabFocus();
            } else if (PostalCodteacher.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Enter Teacher Postal Code", "Details Updating", JOptionPane.INFORMATION_MESSAGE, IconUpdateError);
                teacher_postalCode.grabFocus();
            } else if (teacherphone.isEmpty() || teacherphone.length() != 10) {
                JOptionPane.showMessageDialog(this, "Please Enter Teacher Contact Number OR Please Check Number Length", "Details Updating", JOptionPane.INFORMATION_MESSAGE, IconUpdateError);
                ContactnumberTeacher.grabFocus();
            } else if (teacherProvince.equals("Select")) {
                JOptionPane.showMessageDialog(this, "Please Select Province", "Details Updating", JOptionPane.INFORMATION_MESSAGE, IconUpdateError);
                provinceCombo.grabFocus();
            } else if (teacherCity.equals("Select")) {
                JOptionPane.showMessageDialog(this, "Please Select City", "Details Updating", JOptionPane.INFORMATION_MESSAGE, IconUpdateError);
                cityCombo.grabFocus();
            } else if (teacherCountry.equals("Select")) {
                JOptionPane.showMessageDialog(this, "Please Select City", "Details Updating", JOptionPane.INFORMATION_MESSAGE, IconUpdateError);
                countyCombo.grabFocus();
//            } else if (teacherSubject.equals("Select")) {
//                JOptionPane.showMessageDialog(this, "Please Select Subject", "Details Updating", JOptionPane.INFORMATION_MESSAGE, IconUpdateError);
//                subjectCombo.grabFocus();
            } else if (teacherDepartment.equals("Select")) {
                JOptionPane.showMessageDialog(this, "Please Select Department", "Details Updating", JOptionPane.INFORMATION_MESSAGE, IconUpdateError);
                departmentCombo.grabFocus();
            } else {
                String genderID = GenderSelect.getActionCommand();
                Integer NationalityID = nationalMap.get(Nationality);
                Integer CityID = citiesMap.get(teacherCity);
                Integer ProvinceID = ProvinceMap.get(teacherProvince);
                Integer CountryID = countryMap.get(teacherCountry);
//                Integer SubjectID = SubjectMap.get(teacherSubject);
                Integer DepartmentID = depatmentMap.get(teacherDepartment);

                Date DOB = teachetBirthDay.getDate();//bithday
                LocalDate localDate = DOB.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                String birthday1 = String.valueOf(localDate);//Use This Var

                try {
                    MYSQLConnection.executeIUD("UPDATE `teacher_info` SET `full_name` = '" + FirstName + "', `teacher_nic` = '" + teacherNIC + "', "
                            + "`teacher_phone` = '" + teacherphone + "', `date_of_birth_teacher` = '" + birthday1 + "', `teacher_mail` = '" + EmailAdd + "',"
                            + " `gender_gender_id` = '" + genderID + "', "
                            + "`country_idcountry` = '" + CountryID + "', `department_iddepartment` = '" + DepartmentID + "', "
                            + "`nationality_nationalityid` = '" + NationalityID + "', `Province_idProvince` = '" + ProvinceID + "', "
                            + "`city_city_id` = '" + CityID + "', `teacher_update_date` = '" + formattedUDateTime + "' WHERE `idteacher_info` = '" + teaid + "'");

                    JOptionPane.showMessageDialog(this, FirstName + " Details Update Successfully ", "Teacher Details Updated", JOptionPane.INFORMATION_MESSAGE, IconUpdate);

                    JOptionPane.showMessageDialog(this, " This Window Reset Again ", "Window Resetting", JOptionPane.INFORMATION_MESSAGE, ResetIcon);

                    resetTeachers();
                    loadTeachers();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        ImageIcon Iconmessage = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Adyapana_Institute\\src\\img\\icons8_ok_64px.png");
        ImageIcon IconSelect = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Adyapana_Institute\\src\\img\\icons8_Insert_Row_Above_64px.png");
        ImageIcon IconReset = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Adyapana_Institute\\src\\img\\icons8_reset_64px_1.png");

        int selectRow = jTable1.getSelectedRow();
        if (selectRow == -1) {
            JOptionPane.showMessageDialog(this, "Please Select An Row", "Record Deleting", JOptionPane.ERROR_MESSAGE, IconSelect);
        } else {
            String id = String.valueOf(jTable1.getValueAt(selectRow, 0));
            try {
                MYSQLConnection.executeIUD("DELETE FROM `teacher_info` WHERE `idteacher_info` = '" + id + "'");
                JOptionPane.showMessageDialog(this, "Record Delete Success", "Record Deleting", JOptionPane.INFORMATION_MESSAGE, Iconmessage);
                loadTeachers();
                JOptionPane.showMessageDialog(this, "This Window Resetting Now", "Window Resetting", JOptionPane.INFORMATION_MESSAGE, IconReset);

                resetTeachers();
                jButton10.setEnabled(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here:
        String search2 = jTextField1.getText();

        if (search2.isEmpty()) {
            loadTeachers();
        } else {
            try {
                ResultSet resultSet1 = MYSQLConnection.executeSearch("SELECT * FROM `teacher_info` "
                        + "INNER JOIN `gender` ON `teacher_info`.`gender_gender_id` = `gender`.`gender_id` INNER JOIN `country` ON `teacher_info`.`country_idcountry` = `country`.`idcountry` "
                        + "INNER JOIN `department` ON `teacher_info`.`department_iddepartment` = `department`.`iddepartment` INNER JOIN `nationality` ON `teacher_info`.`nationality_nationalityid` = `nationality`.`nationalityid`"
                        + "INNER JOIN `province` ON `teacher_info`.`Province_idProvince` = `province`.`idProvince` INNER JOIN `city` ON `teacher_info`.`city_city_id` = `city`.`city_id` WHERE `teacher_nic` = '" + search2 + "' OR `full_name` = '" + search2 + "'");

                DefaultTableModel model1 = (DefaultTableModel) jTable1.getModel();
                model1.setRowCount(0);
                while (resultSet1.next()) {
                    Vector<String> vs = new Vector<>();

                    vs.add(resultSet1.getString("idteacher_info"));
                    vs.add(resultSet1.getString("full_name"));
                    vs.add(resultSet1.getString("teacher_nic"));
                    vs.add(resultSet1.getString("teacher_phone"));
                    vs.add(resultSet1.getString("date_of_birth_teacher"));
                    vs.add(resultSet1.getString("teacher_mail"));
                    vs.add(resultSet1.getString("teacher_address"));
                    vs.add(resultSet1.getString("teacher_postal_code"));
//                    vs.add(resultSet1.getString("subject.subject_name"));
                    vs.add(resultSet1.getString("gender.gender_type"));
                    vs.add(resultSet1.getString("country.name"));
                    vs.add(resultSet1.getString("department.department_name"));
                    vs.add(resultSet1.getString("nationality.nationality_type"));
                    vs.add(resultSet1.getString("province.province_name"));
                    vs.add(resultSet1.getString("city.name"));
                    vs.add(resultSet1.getString("teacher_added_date"));

                    model1.addRow(vs);
                    jTable1.setModel(model1);

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jTextField1KeyReleased

//    private String generateRandomId(int length) {
//        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
//        StringBuilder idBuilder = new StringBuilder();
//
//        for (int i = 0; i < length; i++) {
//            int randomIndex = (int) (Math.random() * characters.length());
//            char randomChar = characters.charAt(randomIndex);
//            idBuilder.append(randomChar);
//        }
//
//        return idBuilder.toString();
//    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        FlatMacLightLaf.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Teacher_enrollment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ContactnumberTeacher;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cityCombo;
    private javax.swing.JComboBox<String> countyCombo;
    private javax.swing.JComboBox<String> departmentCombo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
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
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
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
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JComboBox<String> nationalCombo;
    private javax.swing.JComboBox<String> provinceCombo;
    private javax.swing.JTextField teacherNic;
    private javax.swing.JTextArea teacher_addresText;
    private javax.swing.JTextField teacher_email;
    private javax.swing.JTextField teacher_postalCode;
    private javax.swing.JTextField teacherfullName;
    private com.toedter.calendar.JDateChooser teachetBirthDay;
    // End of variables declaration//GEN-END:variables
}
