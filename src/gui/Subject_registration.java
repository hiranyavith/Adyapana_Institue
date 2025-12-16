package gui;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.MYSQL;

public class Subject_registration extends javax.swing.JFrame {

    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    HashMap<String, Integer> StatusMap = new HashMap<>();

    public Subject_registration() {
        initComponents();
        loadStatus();
        Other();
        jButton12.setEnabled(false);
        jButton13.setEnabled(false);
        loadsubject();

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

    private void loadStatus() {
        try {
            ResultSet resultSet = MYSQL.execute("SELECT * FROM `status`");

            Vector v = new Vector();
            v.add("Select");
            while (resultSet.next()) {
                v.add(resultSet.getString("type"));
                StatusMap.put(resultSet.getString("type"), resultSet.getInt("idstatus"));
            }
            DefaultComboBoxModel model = new DefaultComboBoxModel(v);
            substatus.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadsubject() {
        try {
            ResultSet resultSet = MYSQL.execute("SELECT * FROM `subject` INNER JOIN `status` ON `subject`.`status_idstatus` = `status`.`idstatus` ORDER BY `idsubject` ASC");
            DefaultTableModel modelsub = (DefaultTableModel) jTable1.getModel();
            modelsub.setRowCount(0);
            while (resultSet.next()) {
                Vector<String> vsu = new Vector<>();

                vsu.add(resultSet.getString("idsubject"));
                vsu.add(resultSet.getString("subject_code"));
                vsu.add(resultSet.getString("subject_name"));
                vsu.add(resultSet.getString("subject_description"));
                vsu.add(resultSet.getString("status.type"));
                vsu.add(resultSet.getString("added_date"));
                vsu.add(resultSet.getString("updated_date"));

                modelsub.addRow(vsu);
                jTable1.setModel(modelsub);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void resetSubject() {
        genarateID.setText("");
        subname.setText("");
        subdescription.setText("");
        substatus.setSelectedIndex(0);
        jButton12.setEnabled(false);
        jButton13.setEnabled(false);
    }

    private void Other() {
        jButton3.setEnabled(false);
        setTitle("Subject Registration");
        ImageIcon iconsubject = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Adyapana_Institute\\src\\img\\icons8_return_book_64px_1.png");
        setIconImage(iconsubject.getImage());
        jButton9.grabFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        genarateID = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        subname = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        subdescription = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        substatus = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
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

        jPanel4.setBackground(new java.awt.Color(236, 242, 255));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 234, 211), 1, true));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Subject Registration");

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

        jPanel3.setBackground(new java.awt.Color(247, 245, 235));

        jLabel3.setText("Subject Id :");

        genarateID.setEditable(false);

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_knob_turn_32px.png"))); // NOI18N
        jButton9.setText("Genarate Subject Id");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel4.setText("Subject Name :");

        jLabel6.setText("Subject Description :");

        subdescription.setColumns(20);
        subdescription.setRows(5);
        jScrollPane1.setViewportView(subdescription);

        jLabel7.setText("Subject Status :");

        substatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Active", "Deactivate" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(genarateID, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton9)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(subname, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(8, 8, 8)
                        .addComponent(substatus, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(genarateID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton9)
                            .addComponent(jLabel4)
                            .addComponent(subname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(substatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Subject_Code", "Subject Name", "Subject Description", "Status", "Added Date", "Updated Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
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

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel8.setText("Subjects ID / Name");

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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1442, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(499, 499, 499)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton10.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_reset_64px.png"))); // NOI18N
        jButton10.setText("Reset");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_save_64px_1.png"))); // NOI18N
        jButton11.setText("Save");
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

        jButton13.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_trash_can_64px.png"))); // NOI18N
        jButton13.setText("Delete");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(137, 137, 137)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        int option = JOptionPane.showConfirmDialog(this, "Do you Want To Leave This Page?", "Information Message", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (option == JOptionPane.YES_OPTION) {

        }
        Home home = new Home();
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int option = JOptionPane.showConfirmDialog(this, "Do you Want To Leave This Page?", "Information Message", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (option == JOptionPane.YES_OPTION) {

        }
        Teacher_enrollment teachetenroll = new Teacher_enrollment();
        teachetenroll.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        ImageIcon iconinformation = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Adyapana_Institute\\src\\img\\icons8_information_64px.png");
        ImageIcon iconSuccess = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Adyapana_Institute\\src\\img\\icons8_done_64px.png");

        String subjectGenarate = genarateID.getText();
        String subjectName = subname.getText();
        String subjectDescription = subdescription.getText();
        String SubjectStatus = String.valueOf(substatus.getSelectedItem());

        Date Sdate1 = new Date();
        SimpleDateFormat dateSFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedSDateTime = dateSFormat.format(Sdate1);

        if (subjectGenarate.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Click Genarate Button To Genarate Subject ID", "Subject Registration", JOptionPane.INFORMATION_MESSAGE, iconinformation);
            jButton9.grabFocus();
        } else if (subjectName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Valid Subject Name", "Subject Registration", JOptionPane.INFORMATION_MESSAGE, iconinformation);
            subname.grabFocus();
        } else if (SubjectStatus.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please Select Subject Status", "Subject Registration", JOptionPane.INFORMATION_MESSAGE, iconinformation);
            subname.grabFocus();
        } else {
            Integer SubjectStatusID = StatusMap.get(SubjectStatus);
            try {
                MYSQL.execute("INSERT INTO `subject` (`subject_code`,`subject_name`,`subject_description`,`status_idstatus`,`added_date`) VALUES ('" + subjectGenarate + "','" + subjectName + "','" + subjectDescription + "','" + SubjectStatusID + "','" + formattedSDateTime + "')");
                JOptionPane.showMessageDialog(this, "Subject Registration Is Successfully", "Subject Registration", JOptionPane.INFORMATION_MESSAGE, iconSuccess);
                loadsubject();
                JOptionPane.showMessageDialog(this, "This Window Is Going To Reset Again", "Window Reset", JOptionPane.INFORMATION_MESSAGE);
                resetSubject();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        ImageIcon EoorIcon = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Adyapana_Institute\\src\\img\\icons8_information_64px.png");
        ImageIcon IconReset = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Adyapana_Institute\\src\\img\\icons8_reset_64px_3.png");
        ImageIcon IconSuccess = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Adyapana_Institute\\src\\img\\icons8_ok_64px_1.png");

        String SubjectGenID = genarateID.getText();
        String SubjectName = subname.getText();
        String SubjectDescription = subdescription.getText();
        String SubjectStatus = String.valueOf(substatus.getSelectedItem());

        int selectROW = jTable1.getSelectedRow();
        if (selectROW == -1) {
            JOptionPane.showMessageDialog(this, "Please Slect A Row", "Subject Updating", JOptionPane.ERROR_MESSAGE);

        } else {
            String SubID = String.valueOf(jTable1.getValueAt(selectROW, 0));

            if (SubjectGenID.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Genarate New ID", "Subject Id", JOptionPane.INFORMATION_MESSAGE, EoorIcon);
                jButton9.grabFocus();
            } else if (SubjectName.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Enter Subject Name", "Subject Name", JOptionPane.INFORMATION_MESSAGE, EoorIcon);
                subname.grabFocus();
            } else if (SubjectDescription.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Enter Subject Description", "Subject Description", JOptionPane.INFORMATION_MESSAGE, EoorIcon);
                subdescription.grabFocus();
            } else if (SubjectStatus.equals("Select")) {
                JOptionPane.showMessageDialog(this, "Please Select Subject Status", "Subject Statusn", JOptionPane.INFORMATION_MESSAGE, EoorIcon);
                substatus.grabFocus();
            } else {
                Integer StatusID = StatusMap.get(SubjectStatus);
                Date Udate1 = new Date();
                SimpleDateFormat dateUFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String formattedUDateTime = dateUFormat.format(Udate1);

                try {
                    MYSQL.execute("UPDATE `subject` SET `subject_code` = '" + SubjectGenID + "', `subject_name`='" + SubjectName + "', `subject_description`='" + SubjectDescription + "',"
                            + "`status_idstatus`='" + StatusID + "', `updated_date`='" + formattedUDateTime + "' WHERE `idsubject` = '" + SubID + "'");
                    JOptionPane.showMessageDialog(this, "Update Is Success", "Subject Updating", JOptionPane.INFORMATION_MESSAGE, IconSuccess);
                    loadsubject();
                    JOptionPane.showMessageDialog(this, "This Window Reset", "Window Resetting", JOptionPane.INFORMATION_MESSAGE, IconReset);

                    resetSubject();
                    jButton11.setEnabled(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }

    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int option = JOptionPane.showConfirmDialog(this, "Do you Want To Leave This Page?", "Information Message", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (option == JOptionPane.YES_OPTION) {
            Student_Registration st_reg = new Student_Registration();
            st_reg.setVisible(true);
            this.dispose();
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

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

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        String genaratedID = generateID(6);
        genarateID.setText("SUB" + genaratedID);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        ImageIcon IconReset = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Adyapana_Institute\\src\\img\\icons8_reset_64px_3.png");
        String subjectGenarate = genarateID.getText();
        String subjectName = subname.getText();
        String subjectDescription = subdescription.getText();
        String SubjectStatus = String.valueOf(substatus.getSelectedItem());

        if (subjectGenarate.isEmpty() && subjectName.isEmpty() && subjectDescription.isEmpty() && SubjectStatus.equals("Select")) {
            resetSubject();
            JOptionPane.showMessageDialog(this, "This Window Reset", "Window Resetting", JOptionPane.INFORMATION_MESSAGE);
            jButton9.grabFocus();
            jButton11.setEnabled(true);

        } else {
            int option = JOptionPane.showConfirmDialog(this, "Are You Sure Do You Want To Reset This Window ?", "Window Resetting", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, IconReset);

            if (option == JOptionPane.YES_OPTION) {
                resetSubject();
                jButton9.grabFocus();
                jButton11.setEnabled(true);
                jButton9.setEnabled(true);

            }

        }


    }//GEN-LAST:event_jButton10ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            jButton11.setEnabled(false);
            jButton12.setEnabled(true);
            jButton13.setEnabled(true);
            jTextField1.setText("");
            jButton9.setEnabled(false);

            int selectedRow = jTable1.getSelectedRow();

            String ID1 = String.valueOf(jTable1.getValueAt(selectedRow, 0));
            String SubCODE = String.valueOf(jTable1.getValueAt(selectedRow, 1));
            genarateID.setText(SubCODE);
            String SUBNAME = String.valueOf(jTable1.getValueAt(selectedRow, 2));
            subname.setText(SUBNAME);
            String SUBDESC = String.valueOf(jTable1.getValueAt(selectedRow, 3));
            subdescription.setText(SUBDESC);
            String SUTATUS = String.valueOf(jTable1.getValueAt(selectedRow, 4));
            substatus.setSelectedItem(SUTATUS);

        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
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
                MYSQL.execute("DELETE FROM `subject` WHERE `idsubject` = '" + id + "'");
                JOptionPane.showMessageDialog(this, "Record Delete Success", "Record Deleting", JOptionPane.INFORMATION_MESSAGE, Iconmessage);
                loadsubject();
                JOptionPane.showMessageDialog(this, "This Window Resetting Now", "Window Resetting", JOptionPane.INFORMATION_MESSAGE, IconReset);

                resetSubject();
                jButton11.setEnabled(true);
                jButton9.setEnabled(true);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Cannot delete or update a parent row: a foreign key constraint fails (`adyapana_institute`.`class_info`, CONSTRAINT `fk_class_info_subject1` FOREIGN KEY (`subject_idsubject`) REFERENCES `subject` (`idsubject`))","Warning Message",JOptionPane.ERROR);
            }
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here:
        String search2 = jTextField1.getText();

        if (search2.isEmpty()) {
            loadsubject();
        } else {
            try {
                ResultSet resultSet1 = MYSQL.execute("SELECT * FROM `subject` INNER JOIN `status` ON `subject`.`idsubject` = `status`.`idstatus` WHERE `subject_code` = '" + search2 + "' OR `subject_name` = '" + search2 + "'");

                DefaultTableModel model1 = (DefaultTableModel) jTable1.getModel();
                model1.setRowCount(0);
                while (resultSet1.next()) {
                    Vector<String> vsu = new Vector<>();

                    vsu.add(resultSet1.getString("idsubject"));
                    vsu.add(resultSet1.getString("subject_code"));
                    vsu.add(resultSet1.getString("subject_name"));
                    vsu.add(resultSet1.getString("subject_description"));
                    vsu.add(resultSet1.getString("status.type"));
                    vsu.add(resultSet1.getString("added_date"));
                    vsu.add(resultSet1.getString("updated_date"));

                    model1.addRow(vsu);
                    jTable1.setModel(model1);

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jTextField1KeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        FlatMacLightLaf.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Subject_registration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField genarateID;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
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
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextArea subdescription;
    private javax.swing.JTextField subname;
    private javax.swing.JComboBox<String> substatus;
    // End of variables declaration//GEN-END:variables
}
