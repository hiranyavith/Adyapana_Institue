/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import java.util.Vector;
import javax.swing.ButtonModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.MYSQLConnection;
import model.MYSQL;

/**
 *
 * @author User
 */
public class Student_Registration extends javax.swing.JFrame {

    public static HashMap<String, Integer> countryMap = new HashMap();
    public static HashMap<String, Integer> nationalMap = new HashMap();
    public static HashMap<String, Integer> citiesMap = new HashMap();
    public static HashMap<String, Integer> ProvinceMap = new HashMap();
    public static HashMap<String, Integer> CourseMap = new HashMap();
    public static HashMap<String, Integer> depatmentMap = new HashMap();
    public static HashMap<String, Integer> batchMap = new HashMap();
    public static HashMap<String, Integer> relationMap1 = new HashMap();
    public static HashMap<String, Integer> relationMap2 = new HashMap();

    /**
     * Creates new form Student_Registration
     */
    public Student_Registration() {
        initComponents();
        disablebutton();
        seticonimage();
        loadCountries();
        loadnational();
        loadcities();
        loadProvince();
        loadcourses();
        loaddepartment();
        loadbatch();
        loadrelation1();
        loadrelation2();
        loadUser();
        firstname.grabFocus();
        updatestudentregistration.setEnabled(false);
        deletestudentregistration.setEnabled(false);

    }

    private void disablebutton() {
        jButton1.setEnabled(false);

    }

    private void seticonimage() {
        setTitle("Student Registration");
        ImageIcon icon2 = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Adyapana_Institute\\src\\img\\icons8_registration_64px.png");
        setIconImage(icon2.getImage());
    }

    private void resetall() {
        firstname.setText("");
        lastname.setText("");
        buttonGroup2.clearSelection();
        birthday.setDate(null);
        nationality.setSelectedIndex(0);
        nicno.setText("");
        contactno.setText("");
        email.setText("");
        street.setText("");
        city.setSelectedIndex(0);
        province.setSelectedIndex(0);
        country.setSelectedIndex(0);
        postalCode.setText("");

        course.setSelectedIndex(0);
        department.setSelectedIndex(0);
        batch.setSelectedIndex(0);
        studyyear.setYear(2023);

        parentguardianname.setText("");
        contactnumber.setText("");
        relationship1.setSelectedIndex(0);
        emailparent.setText("");

        emergencycontname.setText("");
        emergencycontactnumber.setText("");
        relationship2.setSelectedIndex(0);
        emergencycontactnumber1.setText("");

        firstname.grabFocus();

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
            country.setModel(model1);
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
            nationality.setModel(model2);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
            DefaultComboBoxModel model3 = new DefaultComboBoxModel(v2);
            city.setModel(model3);

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
            province.setModel(model4);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadcourses() {
        try {
            ResultSet resultSet5 = MYSQLConnection.executeSearch("SELECT * FROM `course`");

            Vector v5 = new Vector();
            v5.add("Select");
            while (resultSet5.next()) {
                v5.add(resultSet5.getString("name"));
                CourseMap.put(resultSet5.getString("name"), resultSet5.getInt("course_id"));
            }
            DefaultComboBoxModel model5 = new DefaultComboBoxModel(v5);
            course.setModel(model5);
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
            department.setModel(model6);
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
            batch.setModel(model7);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadrelation1() {
        try {
            ResultSet resultSet8 = MYSQLConnection.executeSearch("SELECT * FROM `relationshiptostudent`");

            Vector v8 = new Vector();
            v8.add("Select");
            while (resultSet8.next()) {
                v8.add(resultSet8.getString("relationship_type"));
                relationMap1.put(resultSet8.getString("relationship_type"), resultSet8.getInt("idrelationshiptostudent"));
            }
            DefaultComboBoxModel model8 = new DefaultComboBoxModel(v8);
            relationship1.setModel(model8);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadrelation2() {
        try {
            ResultSet resultSet8 = MYSQLConnection.executeSearch("SELECT * FROM `emegency_relation`");

            Vector v8 = new Vector();
            v8.add("Select");
            while (resultSet8.next()) {
                v8.add(resultSet8.getString("Emegency_relationcol_type"));
                relationMap2.put(resultSet8.getString("Emegency_relationcol_type"), resultSet8.getInt("idEmegency_relation"));
            }
            DefaultComboBoxModel model8 = new DefaultComboBoxModel(v8);
            relationship2.setModel(model8);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void loadUser() {
        try {
            ResultSet resultSet = MYSQLConnection.executeSearch("SELECT *FROM `student_info` INNER JOIN `gender` ON "
                    + "`student_info`.`gender_gender_id` = `gender`.`gender_id` INNER JOIN `nationality` ON `student_info`.`nationality_nationalityid` = `nationality`.`nationalityid` INNER JOIN "
                    + "`city` ON `student_info`.`city_city_id` = `city`.`city_id` INNER JOIN `province` ON `student_info`.`Province_idProvince` = `province`.`idProvince` INNER JOIN "
                    + "`country` ON `student_info`.`country_idcountry` = `country`.`idcountry` INNER JOIN `course` ON `student_info`.`Course_course_id` = `course`.`course_id` INNER JOIN"
                    + "`department` ON `student_info`.`department_iddepartment` = `department`.`iddepartment` INNER JOIN `batch` ON `student_info`.`batch_idbatch` = `batch`.`idbatch` INNER JOIN"
                    + "`relationshiptostudent` ON `student_info`.`relationshiptostudent_idrelationshiptostudent` = `relationshiptostudent`.`idrelationshiptostudent` INNER JOIN"
                    + "`emegency_relation` on `student_info`.`Emegency_relation_idEmegency_relation` = `emegency_relation`.`idEmegency_relation`");

            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            model.setRowCount(0);
            while (resultSet.next()) {
                Vector<String> v = new Vector<>();

                v.add(resultSet.getString("first_name"));
                v.add(resultSet.getString("last_name"));
                v.add(resultSet.getString("gender.gender_type"));
                v.add(resultSet.getString("date_of_birth"));
                v.add(resultSet.getString("nationality.nationality_type"));
                v.add(resultSet.getString("nic_no"));
                v.add(resultSet.getString("contact_no"));
                v.add(resultSet.getString("email"));
                v.add(resultSet.getString("street_po_box"));
                v.add(resultSet.getString("city.name"));
                v.add(resultSet.getString("province.province_name"));
                v.add(resultSet.getString("country.name"));
                v.add(resultSet.getString("postal_code"));
                v.add(resultSet.getString("department.department_name"));
                v.add(resultSet.getString("course.name"));
                v.add(resultSet.getString("yearofstudy"));
                v.add(resultSet.getString("batch.batch_name"));
                v.add(resultSet.getString("parent_guardiant_name"));
                v.add(resultSet.getString("parentguardiantcontactno"));
                v.add(resultSet.getString("relationshiptostudent.relationship_type"));
                v.add(resultSet.getString("emailparentguardiant"));
                v.add(resultSet.getString("emergency_contact_name"));
                v.add(resultSet.getString("emergency_contact_number"));
                v.add(resultSet.getString("emegency_relation.Emegency_relationcol_type"));
                v.add(resultSet.getString("emergency_contact_email"));
                v.add(resultSet.getString("Added_date"));
                v.add(resultSet.getString("student_id"));
                v.add(resultSet.getString("Updated_date"));

                model.addRow(v);
                jTable2.setModel(model);

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

        buttonGroup2 = new javax.swing.ButtonGroup();
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
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        firstname = new javax.swing.JTextField();
        lastname = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        birthday = new com.toedter.calendar.JDateChooser();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        nationality = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        nicno = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        contactno = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        street = new javax.swing.JTextArea();
        jLabel21 = new javax.swing.JLabel();
        province = new javax.swing.JComboBox<>();
        city = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        postalCode = new javax.swing.JTextField();
        country = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        course = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        department = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        studyyear = new com.toedter.calendar.JYearChooser();
        jLabel13 = new javax.swing.JLabel();
        batch = new javax.swing.JComboBox<>();
        jPanel10 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        parentguardianname = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        relationship1 = new javax.swing.JComboBox<>();
        jLabel29 = new javax.swing.JLabel();
        contactnumber = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        emailparent = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        emergencycontname = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        relationship2 = new javax.swing.JComboBox<>();
        jLabel34 = new javax.swing.JLabel();
        emergencycontactnumber = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        emergencycontactnumber1 = new javax.swing.JTextField();
        resetstudentregistration = new javax.swing.JButton();
        updatestudentregistration = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        searchidnamesturegistration = new javax.swing.JTextField();
        savestudentregistration = new javax.swing.JButton();
        deletestudentregistration = new javax.swing.JButton();

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
                .addContainerGap(742, Short.MAX_VALUE))
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
        jButton1.setSelected(true);

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
        jButton6.setText("S & T Enroll For Stu.");
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
                .addGap(124, 124, 124)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(242, 234, 211));
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
                .addContainerGap(502, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 214, 165));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Academic Information");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(562, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(251, 255, 220));

        jLabel7.setText("First Name :");

        jLabel8.setText("Last Name :");

        jLabel14.setText("Gender :");

        jLabel15.setText("DOB :");

        jLabel16.setText("Nationality :");

        jLabel17.setText("NIC No :");

        jLabel18.setText("Contact No :");

        jLabel19.setText("Email :");

        jLabel20.setText("Street :");

        street.setColumns(20);
        street.setRows(5);
        jScrollPane2.setViewportView(street);

        jLabel21.setText("Province :");

        province.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Western\t" }));

        city.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Western\t" }));

        jLabel22.setText("City :");

        jLabel23.setText("Postal Code :");

        country.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Western\t" }));

        jLabel24.setText("Country :");

        buttonGroup2.add(jRadioButton3);
        jRadioButton3.setText("Male");
        jRadioButton3.setActionCommand("1");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRadioButton4);
        jRadioButton4.setText("Female");
        jRadioButton4.setActionCommand("2");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel18)
                            .addComponent(jLabel16)
                            .addComponent(jLabel7))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jRadioButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jRadioButton4))
                            .addComponent(firstname)
                            .addComponent(nationality, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(contactno))
                        .addGap(65, 65, 65)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel8)
                            .addComponent(jLabel15)
                            .addComponent(jLabel19))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(nicno, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(birthday, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lastname, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addGap(18, 18, 18))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addGap(32, 32, 32)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(country, 0, 202, Short.MAX_VALUE)
                                    .addComponent(city, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel21)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(province, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel23)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(postalCode, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(6, 6, 6))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(firstname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jRadioButton3)
                            .addComponent(jRadioButton4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(nationality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(contactno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(lastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(birthday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(nicno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17))
                                .addGap(18, 18, 18)
                                .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel19)))))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(province, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel21))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel22)
                        .addComponent(city, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(country, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(postalCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(152, 238, 204));

        jLabel10.setText("Course :");

        course.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel11.setText("Department :");

        department.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel12.setText("Year Of Study :");

        jLabel13.setText("Batch :");

        batch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(batch, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(209, 209, 209))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(department, 0, 252, Short.MAX_VALUE)
                        .addGap(51, 51, 51)
                        .addComponent(jLabel12)
                        .addGap(29, 29, 29)
                        .addComponent(studyyear, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(course, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(course, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(department, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)
                        .addComponent(jLabel12))
                    .addComponent(studyyear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(batch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel10.setBackground(new java.awt.Color(243, 188, 200));

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel26.setText("Parent/Guardian Information");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel11.setBackground(new java.awt.Color(248, 232, 238));

        jLabel27.setText("Parent/Guardiant Name :");

        jLabel28.setText("Relationship To the Student :");

        relationship1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel29.setText("Contact Number :");

        jLabel30.setText("Email(Optional) :");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(parentguardianname))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(relationship1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(contactnumber, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailparent, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel29)
                        .addComponent(contactnumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel27)
                        .addComponent(parentguardianname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel30)
                        .addComponent(emailparent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel28)
                        .addComponent(relationship1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel12.setBackground(new java.awt.Color(196, 223, 223));

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel31.setText("Emergency Contact Information");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel31)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel31)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel13.setBackground(new java.awt.Color(249, 155, 125));

        jLabel32.setText("Emergency Contact Name :");

        jLabel33.setText("Relationship To the Student :");

        relationship2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel34.setText("Emergency Contact Number :");

        jLabel35.setText("Email(Optional) :");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emergencycontname))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(relationship2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(emergencycontactnumber1, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                    .addComponent(emergencycontactnumber))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(emergencycontname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34)
                    .addComponent(emergencycontactnumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(relationship2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35)
                    .addComponent(emergencycontactnumber1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        resetstudentregistration.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        resetstudentregistration.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_reset_64px.png"))); // NOI18N
        resetstudentregistration.setText("Reset");
        resetstudentregistration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetstudentregistrationActionPerformed(evt);
            }
        });

        updatestudentregistration.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        updatestudentregistration.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_available_updates_64px.png"))); // NOI18N
        updatestudentregistration.setText("Update");
        updatestudentregistration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatestudentregistrationActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "First Name", "Last Name", "Gender", "Date Of Birth", "Nationality", "NIC No", "Contact No", "Email", "Street", "City", "Province", "Country", "Postal Code", "Department", "Course", "Year Of Study", "Batch", "Parent/Guardiant Name", "Parent/Guardiant Contact No", "Parent/Guardiant Relationship To Student", "Parent/Guardiant Email", "Emergency Contact Name", "Emergency Contact No", "Emergency Contact Relationship To Student", "Emergency Contact Email", "Added Date and Time", "student ID", "Updated Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
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
        jScrollPane3.setViewportView(jTable2);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Search Student By Name Or NIC :");

        searchidnamesturegistration.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchidnamesturegistrationKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchidnamesturegistrationKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchidnamesturegistrationKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(509, 509, 509)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchidnamesturegistration, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(539, Short.MAX_VALUE))
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(searchidnamesturegistration, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        savestudentregistration.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        savestudentregistration.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_save_64px_1.png"))); // NOI18N
        savestudentregistration.setText("Save");
        savestudentregistration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savestudentregistrationActionPerformed(evt);
            }
        });

        deletestudentregistration.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        deletestudentregistration.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_trash_can_64px.png"))); // NOI18N
        deletestudentregistration.setText("Delete");
        deletestudentregistration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletestudentregistrationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(savestudentregistration, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(resetstudentregistration, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(deletestudentregistration, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(updatestudentregistration, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(resetstudentregistration, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(updatestudentregistration, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(49, 49, 49)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(savestudentregistration, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(deletestudentregistration, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int option = JOptionPane.showConfirmDialog(this, "Do you Want To Leave This Page?", "Information Message", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (option == JOptionPane.YES_OPTION) {
            Subject_registration sub_regis = new Subject_registration();
            sub_regis.setVisible(true);
            this.dispose();
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int option = JOptionPane.showConfirmDialog(this, "Do you Want To Leave This Page?", "Information Message", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (option == JOptionPane.YES_OPTION) {
            Teacher_enrollment teachetenroll = new Teacher_enrollment();
            teachetenroll.setVisible(true);
            this.dispose();
        }

    }//GEN-LAST:event_jButton2ActionPerformed

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

    private void savestudentregistrationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savestudentregistrationActionPerformed
        // TODO add your handling code here:

        ImageIcon IconSave = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Adyapana_Institute\\src\\img\\icons8_ok_64px_1.png");
        ImageIcon IconSaveError = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Adyapana_Institute\\src\\img\\icons8_error_64px.png");
        ImageIcon IconSaveReset = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Adyapana_Institute\\src\\img\\icons8_reset_64px_2.png");

        String fname = firstname.getText(); //first name

//
        String lname = lastname.getText(); //last name
//////
        ButtonModel genderSelection = buttonGroup2.getSelection(); //gender
//////

//////
        String nationality_combo = String.valueOf(nationality.getSelectedItem()); //nationality
//
        String nic = nicno.getText(); //nic
////
        String phone = String.valueOf(contactno.getText()); //student Phone Number
////
        String emailadd = email.getText(); //Student Email Address
////
        String pobox = street.getText(); //Student POBox
////
        String city1 = String.valueOf(city.getSelectedItem()); //Student City
////
        String province1 = String.valueOf(province.getSelectedItem()); //Student Province
//////
        String country1 = String.valueOf(country.getSelectedItem()); //Student Country
////
        String postalC = postalCode.getText(); //Student Postal Code

//
////
        String course1 = String.valueOf(course.getSelectedItem()); //Student Course
//
        String department1 = String.valueOf(department.getSelectedItem()); //Student Department
//
        Integer getyear = studyyear.getYear(); //Student Year 
        String yearasstString = String.valueOf(getyear);
////
        String batch1 = String.valueOf(batch.getSelectedItem()); //Student ?BAtch
//
        String parentguardiantname = parentguardianname.getText(); //Student Pname
//
        String parentguardiancontactno = contactnumber.getText(); //Student Pnum
//
        String parentguardianemail = emailparent.getText(); //Student PEmail
//
        String Emerelation1 = String.valueOf(relationship1.getSelectedItem()); //emerelation1

        String Emename = emergencycontname.getText();//emename
//
        String Emenum = emergencycontactnumber.getText();//emenum
//
        String Emeemail = emergencycontactnumber1.getText();//emeemail
//
        String Emerelation2 = String.valueOf(relationship2.getSelectedItem());//emerelation2

        Date date1 = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = dateFormat.format(date1);

        if (fname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Student First Name", "Student Registration", JOptionPane.WARNING_MESSAGE, IconSaveError);
        } else if (lname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Student Last Name", "Student Registration", JOptionPane.WARNING_MESSAGE, IconSaveError);
        } else if (genderSelection == null) {
            JOptionPane.showMessageDialog(this, "Please Select Student Gender", "Student Registration", JOptionPane.WARNING_MESSAGE, IconSaveError);
        } else if (nationality_combo.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please Select Student Nationality", "Student Registration", JOptionPane.WARNING_MESSAGE, IconSaveError);
        } else if (nic.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Select Student National Identity Card", "Student Registration", JOptionPane.WARNING_MESSAGE, IconSaveError);
        } else if (phone.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Student Phone Number is Not Enough characters", "Student Registration", JOptionPane.ERROR_MESSAGE, IconSaveError);
        } else if (emailadd.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Student Email", "Student Registration", JOptionPane.WARNING_MESSAGE, IconSaveError);
        } else if (pobox.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Student Address", "Student Registration", JOptionPane.WARNING_MESSAGE, IconSaveError);
        } else if (city1.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please Select Student City", "Student Registration", JOptionPane.WARNING_MESSAGE, IconSaveError);
        } else if (province1.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please Select Student Province", "Student Registration", JOptionPane.WARNING_MESSAGE, IconSaveError);
        } else if (country1.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please Select Student Country", "Student Registration", JOptionPane.WARNING_MESSAGE, IconSaveError);
        } else if (postalC.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Student Postal Code", "Student Registration", JOptionPane.WARNING_MESSAGE, IconSaveError);
        } else if (course1.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please Select Course For Student", "Academic Information", JOptionPane.WARNING_MESSAGE, IconSaveError);
        } else if (department1.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please Select Department For Student", "Academic Information", JOptionPane.WARNING_MESSAGE, IconSaveError);
        } else if (batch1.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please Select Batch For Student", "Academic Information", JOptionPane.WARNING_MESSAGE, IconSaveError);
        } else if (parentguardiantname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Parent Or Guardiant Name", "Parent / Guardiant Information", JOptionPane.WARNING_MESSAGE, IconSaveError);
        } else if (parentguardiancontactno.isEmpty() || parentguardiancontactno.length() != 10) {
            JOptionPane.showMessageDialog(this, "Please Enter Correct Contact Number", "Parent / Guardiant Informationn", JOptionPane.ERROR_MESSAGE, IconSaveError);
        } else if (Emerelation1.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please Select Parent OR Guardiant Relationship To Student", "Parent / Guardiant Information", JOptionPane.WARNING_MESSAGE, IconSaveError);
        } else if (Emename.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Emergency Contact Name", "Emergency Contact Information", JOptionPane.WARNING_MESSAGE, IconSaveError);
        } else if (Emenum.isEmpty() || Emenum.length() != 10) {
            JOptionPane.showMessageDialog(this, "Please Enter Correct Emergency Contact Number", "Emergency Contact Information", JOptionPane.ERROR_MESSAGE, IconSaveError);
        } else if (Emerelation2.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please Select Parent OR Guardiant Relationship To Student", "Emergency Contact Information", JOptionPane.WARNING_MESSAGE, IconSaveError);
        } else {
            String genderID = genderSelection.getActionCommand();
            Integer nationid = nationalMap.get(nationality_combo);
            Integer courseId = CourseMap.get(course1);
            Integer cityId = citiesMap.get(city1);
            Integer provinceId = ProvinceMap.get(province1);
            Integer departmentId = depatmentMap.get(department1);
            Integer countryId = countryMap.get(country1);
            Integer batchId = batchMap.get(batch1);
            Integer EmeregencylationId1 = relationMap1.get(Emerelation1);
            Integer EmeregencylationId2 = relationMap2.get(Emerelation2);
            Date Dateob = birthday.getDate();//bithday
            LocalDate localDate = Dateob.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            String birthday1 = String.valueOf(localDate);

            try {
                MYSQLConnection.executeIUD("INSERT INTO "
                        + "`student_info` "
                        + "(`first_name`,`last_name`,`date_of_birth`,`nic_no`,`contact_no`,"
                        + "`email`,`street_po_box`,`postal_code`,`yearofstudy`,`parent_guardiant_name`,"
                        + "`parentguardiantcontactno`,`emailparentguardiant`,`emergency_contact_name`,`emergency_contact_number`,"
                        + "`emergency_contact_email`,`gender_gender_id`,`nationality_nationalityid`,`city_city_id`,`Province_idProvince`,"
                        + "`country_idcountry`,`Course_course_id`,`department_iddepartment`,`batch_idbatch`,`relationshiptostudent_idrelationshiptostudent`,`Emegency_relation_idEmegency_relation`,`Added_date`) "
                        + "VALUES ('" + fname + "','" + lname + "','" + birthday1 + "','" + nic + "','" + phone + "','" + emailadd + "','" + pobox + "','" + postalC + "','" + yearasstString + "',"
                        + "'" + parentguardiantname + "','" + parentguardiancontactno + "','" + parentguardianemail + "','" + Emename + "','" + Emenum + "','" + Emeemail + "','" + genderID + "',"
                        + "'" + nationid + "','" + cityId + "','" + provinceId + "','" + countryId + "','" + courseId + "','" + departmentId + "','" + batchId + "','" + EmeregencylationId1 + "','" + EmeregencylationId2 + "','" + formattedDateTime + "')");

                JOptionPane.showMessageDialog(this, "Student Registration Is Success", "Student REgistration", JOptionPane.INFORMATION_MESSAGE, IconSave);
                JOptionPane.showConfirmDialog(null, "This Window Is Reset Again !!!!", "Information Message", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, IconSaveReset);
                resetall();
                loadUser();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }


    }//GEN-LAST:event_savestudentregistrationActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void resetstudentregistrationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetstudentregistrationActionPerformed
        // TODO add your handling code here:
        int option = JOptionPane.showConfirmDialog(null, "Do you want to reset this window ?", "Window Restting", JOptionPane.YES_NO_CANCEL_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            resetall();
            savestudentregistration.setEnabled(true);

        }

    }//GEN-LAST:event_resetstudentregistrationActionPerformed

    private void searchidnamesturegistrationKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchidnamesturegistrationKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchidnamesturegistrationKeyPressed

    private void searchidnamesturegistrationKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchidnamesturegistrationKeyReleased
        // TODO add your handling code here:
        String search1 = searchidnamesturegistration.getText();

        if (search1.isEmpty()) {
            loadUser();

        } else {
            try {
                ResultSet resultSet1 = MYSQL.execute("SELECT *FROM `student_info` INNER JOIN `gender` ON "
                        + "`student_info`.`gender_gender_id` = `gender`.`gender_id` INNER JOIN `nationality` ON `student_info`.`nationality_nationalityid` = `nationality`.`nationalityid` INNER JOIN "
                        + "`city` ON `student_info`.`city_city_id` = `city`.`city_id` INNER JOIN `province` ON `student_info`.`Province_idProvince` = `province`.`idProvince` INNER JOIN "
                        + "`country` ON `student_info`.`country_idcountry` = `country`.`idcountry` INNER JOIN `course` ON `student_info`.`Course_course_id` = `course`.`course_id` INNER JOIN"
                        + "`department` ON `student_info`.`department_iddepartment` = `department`.`iddepartment` INNER JOIN `batch` ON `student_info`.`batch_idbatch` = `batch`.`idbatch` INNER JOIN"
                        + "`relationshiptostudent` ON `student_info`.`relationshiptostudent_idrelationshiptostudent` = `relationshiptostudent`.`idrelationshiptostudent` INNER JOIN"
                        + "`emegency_relation` on `student_info`.`Emegency_relation_idEmegency_relation` = `emegency_relation`.`idEmegency_relation` WHERE `nic_no` = '" + search1 + "' OR `first_name` = '" + search1 + "'");
                DefaultTableModel modelsearch = (DefaultTableModel) jTable2.getModel();
                modelsearch.setRowCount(0);
                while (resultSet1.next()) {
                    Vector<String> vs = new Vector<>();
                    vs.add(resultSet1.getString("first_name"));
                    vs.add(resultSet1.getString("last_name"));
                    vs.add(resultSet1.getString("gender.gender_type"));
                    vs.add(resultSet1.getString("date_of_birth"));
                    vs.add(resultSet1.getString("nationality.nationality_type"));
                    vs.add(resultSet1.getString("nic_no"));
                    vs.add(resultSet1.getString("contact_no"));
                    vs.add(resultSet1.getString("email"));
                    vs.add(resultSet1.getString("street_po_box"));
                    vs.add(resultSet1.getString("city.name"));
                    vs.add(resultSet1.getString("province.province_name"));
                    vs.add(resultSet1.getString("country.name"));
                    vs.add(resultSet1.getString("postal_code"));
                    vs.add(resultSet1.getString("department.department_name"));
                    vs.add(resultSet1.getString("course.name"));
                    vs.add(resultSet1.getString("yearofstudy"));
                    vs.add(resultSet1.getString("batch.batch_name"));
                    vs.add(resultSet1.getString("parent_guardiant_name"));
                    vs.add(resultSet1.getString("parentguardiantcontactno"));
                    vs.add(resultSet1.getString("relationshiptostudent.relationship_type"));
                    vs.add(resultSet1.getString("emailparentguardiant"));
                    vs.add(resultSet1.getString("emergency_contact_name"));
                    vs.add(resultSet1.getString("emergency_contact_number"));
                    vs.add(resultSet1.getString("emegency_relation.Emegency_relationcol_type"));
                    vs.add(resultSet1.getString("emergency_contact_email"));
                    vs.add(resultSet1.getString("Added_date"));
                    vs.add(resultSet1.getString("student_id"));
                    vs.add(resultSet1.getString("Updated_date"));

                    modelsearch.addRow(vs);
                    jTable2.setModel(modelsearch);

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }//GEN-LAST:event_searchidnamesturegistrationKeyReleased

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            savestudentregistration.setEnabled(false);
            updatestudentregistration.setEnabled(true);
            deletestudentregistration.setEnabled(true);
            int selectRow = jTable2.getSelectedRow();

            String firstname1 = String.valueOf(jTable2.getValueAt(selectRow, 0));
            firstname.setText(firstname1);
            String lastname1 = String.valueOf(jTable2.getValueAt(selectRow, 1));
            lastname.setText(lastname1);
            String gender = String.valueOf(jTable2.getValueAt(selectRow, 2));

            if (gender.equals("Male")) {
                jRadioButton3.setSelected(true);
            } else {
                jRadioButton4.setSelected(true);
            }

            String dob = String.valueOf(jTable2.getValueAt(selectRow, 3));

// Parse the string value to a Date object using SimpleDateFormat
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = null;
            try {
                date = dateFormat.parse(dob);
            } catch (ParseException e) {
                e.printStackTrace();
            }

// Set the parsed date to the JDateChooser component
            birthday.setDate(date);

            String national = String.valueOf(jTable2.getValueAt(selectRow, 4));
            nationality.setSelectedItem(national);

            String nic = String.valueOf(jTable2.getValueAt(selectRow, 5));
            nicno.setText(nic);

            String contactno1 = String.valueOf(jTable2.getValueAt(selectRow, 6));
            contactno.setText(contactno1);

            String email1 = String.valueOf(jTable2.getValueAt(selectRow, 7));
            email.setText(email1);

            String streetStr = String.valueOf(jTable2.getValueAt(selectRow, 8));
            street.setText(streetStr);

            String city1 = String.valueOf(jTable2.getValueAt(selectRow, 9));
            city.setSelectedItem(city1);

            String province1 = String.valueOf(jTable2.getValueAt(selectRow, 10));
            province.setSelectedItem(province1);

            String country1 = String.valueOf(jTable2.getValueAt(selectRow, 11));
            country.setSelectedItem(country1);

            String pC = String.valueOf(jTable2.getValueAt(selectRow, 12));
            postalCode.setText(pC);

            String department1 = String.valueOf(jTable2.getValueAt(selectRow, 13));
            department.setSelectedItem(department1);
//            
            String course1 = String.valueOf(jTable2.getValueAt(selectRow, 14));
            course.setSelectedItem(course1);

            String batch1 = String.valueOf(jTable2.getValueAt(selectRow, 16));
            batch.setSelectedItem(batch1);
//            
            String yos1 = String.valueOf(jTable2.getValueAt(selectRow, 15));
            int year = Integer.parseInt(yos1);
            studyyear.setYear(year);

            String parentnname = String.valueOf(jTable2.getValueAt(selectRow, 17));
            parentguardianname.setText(parentnname);

            String parentcontactnumber = String.valueOf(jTable2.getValueAt(selectRow, 18));
            contactnumber.setText(parentcontactnumber);

            String relation1 = String.valueOf(jTable2.getValueAt(selectRow, 19));
            relationship1.setSelectedItem(relation1);

            String parentemailaddress = String.valueOf(jTable2.getValueAt(selectRow, 20));
            emailparent.setText(parentemailaddress);

            String Emegencyname = String.valueOf(jTable2.getValueAt(selectRow, 21));
            emergencycontname.setText(Emegencyname);

            String Emegencyphone = String.valueOf(jTable2.getValueAt(selectRow, 22));
            emergencycontactnumber.setText(Emegencyphone);

            String relation2 = String.valueOf(jTable2.getValueAt(selectRow, 23));
            relationship2.setSelectedItem(relation2);

            String Emegencymail1 = String.valueOf(jTable2.getValueAt(selectRow, 24));
            emergencycontactnumber1.setText(Emegencymail1);

        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void updatestudentregistrationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatestudentregistrationActionPerformed
        // TODO add your handling code here:
        ImageIcon IconUpdate = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Adyapana_Institute\\src\\img\\icons8_ok_64px_1.png");
        ImageIcon IconUpdateError = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Adyapana_Institute\\src\\img\\icons8_error_64px.png");
        ImageIcon IconSelect = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Adyapana_Institute\\src\\img\\icons8_Insert_Row_Above_64px.png");
        ImageIcon ResetIcon = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Adyapana_Institute\\src\\img\\icons8_reset_64px_1.png");

        String firstName = firstname.getText();
        String lastName = lastname.getText();
        String Nationality = String.valueOf(nationality.getSelectedItem());
        String NICNo = nicno.getText();
        String ContactNo = contactno.getText();
        String Email = email.getText();
        String StreetAdd = street.getText();
        String City = String.valueOf(city.getSelectedItem());
        String Province = String.valueOf(province.getSelectedItem());
        String Country = String.valueOf(country.getSelectedItem());
        String PostalCode = postalCode.getText();
        String Department = String.valueOf(department.getSelectedItem());
        String Course = String.valueOf(course.getSelectedItem());
        String Batch = String.valueOf(batch.getSelectedItem());
        Integer GetYear = studyyear.getYear(); //Student Year 
        String yearasstString = String.valueOf(GetYear);//Use This Var
        String ParentGuardiantName = parentguardianname.getText();
        String ParentGuardiantContactNo = contactnumber.getText();
        String RelationShip1 = String.valueOf(relationship1.getSelectedItem());
        String ParentGuardiantEmail = emailparent.getText();
        String EmergencyContactName = emergencycontname.getText();
        String EmergencyContactNo = emergencycontactnumber.getText();
        String EmergencyEmailAddress = emergencycontactnumber1.getText();
        String EmergenceRelationShop = String.valueOf(relationship2.getSelectedItem());

        Date Udate1 = new Date();
        SimpleDateFormat dateUFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedUDateTime = dateUFormat.format(Udate1);

        int selectRow = jTable2.getSelectedRow();
        if (selectRow == -1) {
            JOptionPane.showMessageDialog(this, "Please Select A row First", "Details Updating", JOptionPane.ERROR_MESSAGE, IconSelect);
        } else {
            String stuid = String.valueOf(jTable2.getValueAt(selectRow, 26));

            ButtonModel GenderSelect = buttonGroup2.getSelection();

            if (firstName.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Enter Student First Name", "Student Details Updating(Personal Info)", JOptionPane.ERROR_MESSAGE, IconUpdateError);
            } else if (lastName.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Enter Student Last Name", "Student Details Updating(Personal Info)", JOptionPane.WARNING_MESSAGE, IconUpdateError);
            } else if (GenderSelect == null) {
                JOptionPane.showMessageDialog(this, "Please Select Student Gender", "Student Details Updating(Personal Info)", JOptionPane.WARNING_MESSAGE, IconUpdateError);
            } else if (Nationality.equals("Select")) {
                JOptionPane.showMessageDialog(this, "Please Select Student Nationality", "Student Details Updating(Personal Info)", JOptionPane.WARNING_MESSAGE, IconUpdateError);
            } else if (NICNo.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Select Student National Identity Card", "Student Details Updating(Personal Info)", JOptionPane.WARNING_MESSAGE, IconUpdateError);
            } else if (ContactNo.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Student Phone Number is Not Enough characters", "Student Details Updating(Personal Info)", JOptionPane.ERROR_MESSAGE, IconUpdateError);
            } else if (Email.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Enter Student Email", "Student Details Updating(Personal Info)", JOptionPane.WARNING_MESSAGE, IconUpdateError);
            } else if (StreetAdd.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Enter Student Address", "Student Details Updating(Personal Info)", JOptionPane.WARNING_MESSAGE, IconUpdateError);
            } else if (City.equals("Select")) {
                JOptionPane.showMessageDialog(this, "Please Select Student City", "Student Details Updating(Personal Info)", JOptionPane.WARNING_MESSAGE, IconUpdateError);
            } else if (Province.equals("Select")) {
                JOptionPane.showMessageDialog(this, "Please Select Student Province", "Student Details Updating(Personal Info)", JOptionPane.WARNING_MESSAGE, IconUpdateError);
            } else if (Country.equals("Select")) {
                JOptionPane.showMessageDialog(this, "Please Select Student Country", "Student Details Updating(Personal Info)", JOptionPane.WARNING_MESSAGE, IconUpdateError);
            } else if (PostalCode.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Enter Student Postal Code", "Student Details Updating(Personal Info)", JOptionPane.WARNING_MESSAGE, IconUpdateError);
            } else if (Course.equals("Select")) {
                JOptionPane.showMessageDialog(this, "Please Select Course For Student", "Student Details Updating(Academic Info)", JOptionPane.WARNING_MESSAGE, IconUpdateError);
            } else if (Department.equals("Select")) {
                JOptionPane.showMessageDialog(this, "Please Select Department For Student", "Student Details Updating(Academic Info)", JOptionPane.WARNING_MESSAGE, IconUpdateError);
            } else if (Batch.equals("Select")) {
                JOptionPane.showMessageDialog(this, "Please Select Batch For Student", "Student Details Updating(Academic Info)", JOptionPane.WARNING_MESSAGE, IconUpdateError);
            } else if (ParentGuardiantName.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Enter Parent Or Guardiant Name", "Student Details Updating(Parent / Guardiant Information)", JOptionPane.WARNING_MESSAGE, IconUpdateError);
            } else if (ParentGuardiantContactNo.isEmpty() || ParentGuardiantContactNo.length() != 10) {
                JOptionPane.showMessageDialog(this, "Please Enter Correct Contact Number", "Student Details Updating(Parent / Guardiant Information)", JOptionPane.ERROR_MESSAGE, IconUpdateError);
            } else if (RelationShip1.equals("Select")) {
                JOptionPane.showMessageDialog(this, "Please Select Parent OR Guardiant Relationship To Student", "Student Details Updating(Parent / Guardiant Information)", JOptionPane.WARNING_MESSAGE, IconUpdateError);
            } else if (EmergencyContactName.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Enter Emergency Contact Name", "Student Details Updating(Emergency Contact Information)", JOptionPane.WARNING_MESSAGE, IconUpdateError);
            } else if (EmergencyContactNo.isEmpty() || EmergencyContactNo.length() != 10) {
                JOptionPane.showMessageDialog(this, "Please Enter Correct Emergency Contact Number", "Student Details Updating(Emergency Contact Information)", JOptionPane.ERROR_MESSAGE, IconUpdateError);
            } else if (EmergenceRelationShop.equals("Select")) {
                JOptionPane.showMessageDialog(this, "Please Select Parent OR Guardiant Relationship To Student", "Student Details Updating(Emergency Contact Information)", JOptionPane.WARNING_MESSAGE, IconUpdateError);
            } else {
                String genderID = GenderSelect.getActionCommand();
                Integer NationalityID = nationalMap.get(Nationality);
                Integer CityID = citiesMap.get(City);
                Integer ProvinceID = ProvinceMap.get(Province);
                Integer CountryID = countryMap.get(Country);
                Integer CourseID = CourseMap.get(Course);
                Integer DepartmentID = depatmentMap.get(Department);
                Integer BatchID = batchMap.get(Batch);
                Integer RelationShip1ID = relationMap1.get(RelationShip1);
                Integer EmergenceRelationShopID = relationMap2.get(EmergenceRelationShop);
                Date DOB = birthday.getDate();//bithday
                LocalDate localDate = DOB.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                String birthday1 = String.valueOf(localDate);//Use This Var

                try {
                    MYSQL.execute("UPDATE `student_info` SET"
                            + "`first_name` = '" + firstName + "',"
                            + "`last_name` = '" + lastName + "',"
                            + "`date_of_birth` = '" + birthday1 + "',"
                            + "`nic_no` = '" + NICNo + "',"
                            + "`contact_no` = '" + ContactNo + "',"
                            + "`email` = '" + Email + "' , `street_po_box` = '" + StreetAdd + "' , `postal_code` = '" + PostalCode + "' , `yearofstudy` = '" + yearasstString + "' , "
                            + "`parent_guardiant_name` = '" + ParentGuardiantName + "' , `parentguardiantcontactno` = '" + ParentGuardiantContactNo + "' ,"
                            + " `emailparentguardiant` = '" + ParentGuardiantEmail + "', `emergency_contact_name` = '" + EmergencyContactName + "',"
                            + " `emergency_contact_number` = '" + EmergencyContactNo + "', `emergency_contact_email` = '" + EmergencyEmailAddress + "', "
                            + "`gender_gender_id` = '" + genderID + "', `nationality_nationalityid` = '" + NationalityID + "', `city_city_id` = '" + CityID + "', "
                            + "`Province_idProvince` = '" + ProvinceID + "', `country_idcountry` = '" + CountryID + "', `Course_course_id` = '" + CourseID + "', "
                            + "`department_iddepartment` = '" + DepartmentID + "', `batch_idbatch` = '" + BatchID + "', `relationshiptostudent_idrelationshiptostudent` = '" + RelationShip1ID + "',"
                            + "`Emegency_relation_idEmegency_relation` = '" + EmergenceRelationShopID + "',`Updated_date` = '" + formattedUDateTime + "'"
                            + "WHERE `student_id` = '" + stuid + "' ");
                    String message = firstName.concat(" ").concat(lastName);
                    JOptionPane.showMessageDialog(this, message + " Details Update Successfully ", "Student Update", JOptionPane.INFORMATION_MESSAGE, IconUpdate);
                    loadUser();
                    JOptionPane.showMessageDialog(this, " This Window Reset Again ", "Window Resetting", JOptionPane.INFORMATION_MESSAGE, ResetIcon);

                    resetall();
                    savestudentregistration.setEnabled(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }

    }//GEN-LAST:event_updatestudentregistrationActionPerformed

    private void deletestudentregistrationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletestudentregistrationActionPerformed
        // TODO add your handling code here:
        ImageIcon Iconmessage = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Adyapana_Institute\\src\\img\\icons8_ok_64px.png");
        ImageIcon IconSelect = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Adyapana_Institute\\src\\img\\icons8_Insert_Row_Above_64px.png");

        int selectRow = jTable2.getSelectedRow();
        if (selectRow == -1) {
            JOptionPane.showMessageDialog(this, "Please Select An Row", "Record Deleting", JOptionPane.ERROR_MESSAGE, IconSelect);
        } else {
            String id = String.valueOf(jTable2.getValueAt(selectRow, 26));
            try {
                MYSQL.execute("DELETE FROM `student_info` WHERE `student_id` = '" + id + "'");
                JOptionPane.showMessageDialog(this, "Record Delete Success", "Record Deleting", JOptionPane.INFORMATION_MESSAGE, Iconmessage);
                loadUser();
                resetall();
                savestudentregistration.setEnabled(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_deletestudentregistrationActionPerformed

    private void searchidnamesturegistrationKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchidnamesturegistrationKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_searchidnamesturegistrationKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        FlatMacLightLaf.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Student_Registration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> batch;
    private com.toedter.calendar.JDateChooser birthday;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> city;
    private javax.swing.JTextField contactno;
    private javax.swing.JTextField contactnumber;
    private javax.swing.JComboBox<String> country;
    private javax.swing.JComboBox<String> course;
    private javax.swing.JButton deletestudentregistration;
    private javax.swing.JComboBox<String> department;
    private javax.swing.JTextField email;
    private javax.swing.JTextField emailparent;
    private javax.swing.JTextField emergencycontactnumber;
    private javax.swing.JTextField emergencycontactnumber1;
    private javax.swing.JTextField emergencycontname;
    private javax.swing.JTextField firstname;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField lastname;
    private javax.swing.JComboBox<String> nationality;
    private javax.swing.JTextField nicno;
    private javax.swing.JTextField parentguardianname;
    private javax.swing.JTextField postalCode;
    private javax.swing.JComboBox<String> province;
    private javax.swing.JComboBox<String> relationship1;
    private javax.swing.JComboBox<String> relationship2;
    private javax.swing.JButton resetstudentregistration;
    private javax.swing.JButton savestudentregistration;
    private javax.swing.JTextField searchidnamesturegistration;
    private javax.swing.JTextArea street;
    private com.toedter.calendar.JYearChooser studyyear;
    private javax.swing.JButton updatestudentregistration;
    // End of variables declaration//GEN-END:variables
}
