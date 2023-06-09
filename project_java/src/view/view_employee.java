/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import DAO_Interface.Department_DAO;
import DAO_Interface.Employee_DAO;
import DAO_Interface.Project_DAO;
import DAO_Interface.Role_DAO;
import JDBC.JDBCConnection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.CasualEmployee;
import model.Department;
import model.Designer;

import model.Developer;
import model.Employee;
import model.Role;
import model.Tester;
import config.config;
import java.math.BigDecimal;
import java.util.ArrayList;
import model.Project;

/**
 *
 * @author ACER
 */
public class view_employee extends javax.swing.JFrame {
    private Employee_DAO emp_DAO;
    private Employee empPositionWork;
    /**
     * Creates new form view_employee
     * @throws java.sql.SQLException
     * @throws java.text.ParseException
     */
    public view_employee() throws SQLException, ParseException {
        initComponents();
        showDataToTable();
        showDataToComboBox();
        boxGender.setModel(new DefaultComboBoxModel<>( new String[]{
            "Male" , "Female"
        }));
    }

    public void reset() throws SQLException, ParseException{
        txtEmpID.setText("");
        txtFullname.setText("");
        txtBirth.setText("");
        txtEmail.setText("");
        txtSearchFullname.setText("");
        txtSearchIDDepartment.setText("");
        txtEmpID.setEnabled(true);
        showDataToTable();
    }
    
    /**
     *
     * @throws SQLException
     * @throws ParseException
     */
    public void showDataToComboBox() throws SQLException, ParseException{
        Department_DAO department_DAO = new Department_DAO();
        Role_DAO role_DAO = new Role_DAO();
        ArrayList<Department> listDepartment = department_DAO.selectAll();
        ArrayList<Role> listRole = role_DAO.selectAll();
        DefaultComboBoxModel comboBox_role = (DefaultComboBoxModel)boxRole.getModel();
        DefaultComboBoxModel comboBox_department = (DefaultComboBoxModel)boxDepartmentID.getModel();
        comboBox_role.removeAllElements();
        comboBox_department.removeAllElements();
        // lay du lieu tu role vao combobox role
        for(Role r : listRole){
            String roleID = r.getRole_ID();
            comboBox_role.addElement(roleID);
        }
        // lay du lieu tu department vao combobox department
        for(Department d : listDepartment){
            String department_ID = d.getDepartment_ID();
            comboBox_department.addElement(department_ID);
        }
        JDBCConnection.disconnect(department_DAO.getStatement().connect);
        JDBCConnection.disconnect(role_DAO.getStatement().connect);
    }
    public void showDataToTable() throws SQLException, ParseException{
        emp_DAO = new Employee_DAO();
        DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
        ArrayList<Employee> listEmp = emp_DAO.selectAll();
        defaultTableModel.setRowCount(0);
        for(Employee e : listEmp){
            String emp_ID = e.getID();
            String fullname = e.getFullname();
            String birth = config.f.format(e.getBirth());
            String email = e.getEmail();
            String gender = e.getGender();
            String role_ID, department_ID;
            if(e.getRole() != null && e.getDepartment() != null){
                role_ID = e.getRole().getRole_ID();
                department_ID = e.getDepartment().getDepartment_ID();
            }
            else if(e.getRole() == null && e.getDepartment() == null){
                role_ID = "null";
                department_ID = "null";
            }
            else{
                if(e.getRole() == null){
                    role_ID = "null";
                    department_ID = e.getDepartment().getDepartment_ID();
                }
                else{
                    role_ID = e.getRole().getRole_ID();
                    department_ID = "null";
                }
            }
            String tbData[] = {emp_ID, fullname, birth, email, gender, role_ID, department_ID};
            defaultTableModel.addRow(tbData);
        }
        JDBCConnection.disconnect(emp_DAO.getStatement().connect);
    }
    public void showDateToTable(String condition) throws SQLException, ParseException{
        emp_DAO = new Employee_DAO();
        DefaultTableModel defaultTableModel = (DefaultTableModel)table.getModel();
        defaultTableModel.setRowCount(0);
        ArrayList<Employee> listEmployee = emp_DAO.selectByCondition(condition);
        for(Employee e : listEmployee){
            String emp_ID = e.getID();
            String fullname = e.getFullname();
            String birth = config.f.format(e.getBirth());
            String email = e.getEmail();
            String gender = e.getGender();
            String role_ID = e.getRole().getRole_ID();
            String department_ID = e.getDepartment().getDepartment_ID();
            Object[] dataRow = {emp_ID, fullname, birth, email, gender, role_ID, department_ID};
            defaultTableModel.addRow(dataRow);
        }
        JDBCConnection.disconnect(emp_DAO.getStatement().connect);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtFullname = new javax.swing.JTextField();
        txtBirth = new javax.swing.JTextField();
        boxGender = new javax.swing.JComboBox<>();
        txtEmpID = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        boxRole = new javax.swing.JComboBox<>();
        boxDepartmentID = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        btnInsert = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btxDelete = new javax.swing.JButton();
        ntbReset = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        btnGetSalary = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        backBtn = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtSearchFullname = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtSearchIDDepartment = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("EMPLOYEE MANAGER");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 153));

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setForeground(new java.awt.Color(255, 153, 153));

        jPanel5.setBackground(new java.awt.Color(255, 204, 204));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Mã NV:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Họ và tên:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Ngày sinh:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Giới tính:");

        txtFullname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFullnameActionPerformed(evt);
            }
        });

        txtBirth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBirthActionPerformed(evt);
            }
        });

        boxGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        boxGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxGenderActionPerformed(evt);
            }
        });

        txtEmpID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmpIDActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Mã phòng:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Vị trí:");

        boxRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        boxDepartmentID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        boxDepartmentID.setBorder(null);
        boxDepartmentID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxDepartmentIDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 178, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 205, Short.MAX_VALUE)
        );

        jPanel7.setBackground(new java.awt.Color(255, 204, 204));
        jPanel7.setForeground(new java.awt.Color(255, 204, 204));

        btnInsert.setBackground(new java.awt.Color(255, 153, 153));
        btnInsert.setForeground(new java.awt.Color(0, 0, 0));
        btnInsert.setText("Thêm");
        btnInsert.setBorder(null);
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(255, 153, 153));
        btnUpdate.setForeground(new java.awt.Color(0, 0, 0));
        btnUpdate.setText("Sửa");
        btnUpdate.setBorder(null);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btxDelete.setBackground(new java.awt.Color(255, 153, 153));
        btxDelete.setForeground(new java.awt.Color(0, 0, 0));
        btxDelete.setText("Xóa");
        btxDelete.setBorder(null);
        btxDelete.setBorderPainted(false);
        btxDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btxDeleteActionPerformed(evt);
            }
        });

        ntbReset.setBackground(new java.awt.Color(255, 153, 153));
        ntbReset.setForeground(new java.awt.Color(0, 0, 0));
        ntbReset.setText("Reset");
        ntbReset.setBorder(null);
        ntbReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ntbResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btxDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ntbReset, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btxDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ntbReset, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 16, Short.MAX_VALUE))
        );

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Email:");

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        btnGetSalary.setBackground(new java.awt.Color(255, 153, 153));
        btnGetSalary.setForeground(new java.awt.Color(0, 0, 0));
        btnGetSalary.setText("Tính lương");
        btnGetSalary.setBorder(null);
        btnGetSalary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetSalaryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEmpID, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtFullname, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtBirth, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(67, 67, 67)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(boxDepartmentID, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(boxRole, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(boxGender, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(btnGetSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(174, 174, 174)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEmpID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFullname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(boxGender, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnGetSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(boxRole, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(boxDepartmentID, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã nhân viên", "Họ tên", "Ngày sinh", "Email", "Giới tính", "Vị trí làm việc", "Phòng ban"
            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 734, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 153, 153));
        jPanel2.setForeground(new java.awt.Color(255, 153, 153));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("EMPLOYEE MANAGER");

        backBtn.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        backBtn.setForeground(new java.awt.Color(0, 0, 0));
        backBtn.setText("<");
        backBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(backBtn)
                .addGap(205, 205, 205)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(backBtn))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Họ tên:");

        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Mã phòng:");

        btnSearch.setBackground(new java.awt.Color(255, 153, 153));
        btnSearch.setForeground(new java.awt.Color(0, 0, 0));
        btnSearch.setText("Tìm kiếm");
        btnSearch.setBorder(null);
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 661, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(235, 235, 235)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearchFullname, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearchIDDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearchFullname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearchIDDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtEmpIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmpIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmpIDActionPerformed

    private void txtBirthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBirthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBirthActionPerformed

    private void txtFullnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFullnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFullnameActionPerformed

    private void boxDepartmentIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxDepartmentIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxDepartmentIDActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        String emp_ID = txtEmpID.getText();
        String fullname = txtFullname.getText();
        String textBirth = txtBirth.getText();
        String email = txtEmail.getText();
        String gender = boxGender.getItemAt(boxGender.getSelectedIndex());
        String role_ID = boxRole.getItemAt(boxRole.getSelectedIndex());
        String department_ID = boxDepartmentID.getItemAt(boxDepartmentID.getSelectedIndex());
        if(emp_ID.equals("") || fullname.equals("") || textBirth.equals("")|| 
           email.equals("") || gender.equals("") || role_ID.equals("") || department_ID.equals("")){
            JOptionPane.showMessageDialog(this, "Yêu cầu nhập đầy đủ thông tin !");
        }
        else{
            try {
                emp_DAO = new Employee_DAO();
                Employee emp = emp_DAO.selectByID(emp_ID);
                if(emp != null){
                    Department_DAO department_DAO = new Department_DAO();
                    Role_DAO role_DAO = new Role_DAO();
                    Role role = role_DAO.selectByID(role_ID);
                    Department department = department_DAO.selectByID(department_ID);
                    JDBCConnection.disconnect(role_DAO.getStatement().connect);
                    JDBCConnection.disconnect(department_DAO.getStatement().connect);
                    Date birth = config.f.parse(textBirth);
                    Employee empUpdate = new CasualEmployee(emp_ID, fullname, birth, email, gender, role, department);
                    int reply = JOptionPane.showConfirmDialog(null, "Xác nhận sửa ?", "Yes", JOptionPane.YES_NO_OPTION);
                    if(reply == JOptionPane.YES_OPTION){
                        emp_DAO.update(empUpdate);
                        JOptionPane.showMessageDialog(this, "Sửa thành công!");
                        reset();
                    }
                    else{
                        JOptionPane.showMessageDialog(this, "Sửa không thành công!");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(this, "Nhân viên không tồn tại!");
                }
                JDBCConnection.disconnect(emp_DAO.getStatement().connect);
            } catch (SQLException ex) {
                Logger.getLogger(view_department.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng định dạng ngày tháng năm \n Ví dụ: 10/11/2003");
            }
        }
        JDBCConnection.disconnect(emp_DAO.getStatement().connect);
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        String emp_ID = txtEmpID.getText();
        String fullname = txtFullname.getText();
        String textBirth = txtBirth.getText();
        String email = txtEmail.getText();
        String gender = boxGender.getItemAt(boxGender.getSelectedIndex());
        String role_ID = boxRole.getItemAt(boxRole.getSelectedIndex());
        String department_ID = boxDepartmentID.getItemAt(boxDepartmentID.getSelectedIndex());
        if(emp_ID.equals("") || fullname.equals("") || textBirth.equals("")|| 
           email.equals("") || gender.equals("") || role_ID.equals("") || department_ID.equals("")){
            JOptionPane.showMessageDialog(this, "Yêu cầu nhập đầy đủ thông tin !");
        }
        else{
            try {
                emp_DAO = new Employee_DAO();
                Employee emp = emp_DAO.selectByID(emp_ID);
                if(emp!=null){
                    JOptionPane.showMessageDialog(this, "Nhân viên đã tồn tại!");
                }
                else{
                    Department_DAO department_DAO = new Department_DAO();
                    Role_DAO role_DAO = new Role_DAO();
                    Role role = role_DAO.selectByID(role_ID);
                    Department department = department_DAO.selectByID(department_ID);
                    Date birth = config.f.parse(textBirth);
                    Employee employee = new CasualEmployee(emp_ID, fullname, birth, email, gender, role, department);
                    emp_DAO.insert(employee);
                    JOptionPane.showMessageDialog(this, "Thêm thành công!");
                    reset();
                    JDBCConnection.disconnect(department_DAO.getStatement().connect);
                }
                JDBCConnection.disconnect(emp_DAO.getStatement().connect);
            } 
            catch(ParseException ex){
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng định dạng ngày tháng năm \n Ví dụ: 10/11/2003");
            }
            catch (SQLException ex) {
                Logger.getLogger(view_employee.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnInsertActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void ntbResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ntbResetActionPerformed
        try {
            reset();
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(view_employee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ntbResetActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String textEmpFullname = txtSearchFullname.getText();
        String textDepartmentID = txtSearchIDDepartment.getText();
        if(textDepartmentID.equals("") && textEmpFullname.equals("")){
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin tìm kiếm!");
        }
        else{
            try{
                if(textDepartmentID.equals("")){
                    String condition = " fullname = '"+textEmpFullname+"'";
                    showDateToTable(condition);
                }
                else if(textEmpFullname.equals("")){
                    String condition = " department_ID = '"+textDepartmentID+"'";
                    showDateToTable(condition);
                }
                else{
                    String condition = " fullname = '"+textEmpFullname+"' AND department_ID = '"+textDepartmentID+"'";
                    showDateToTable(condition);
                }
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng định dạng ngày tháng năm \n Ví dụ: 10/11/2003");
            } catch (SQLException ex) {
                Logger.getLogger(view_project.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void boxGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxGenderActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_boxGenderActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        int x = table.getSelectedRow();
        if(x >=0){
            txtEmpID.setText(table.getValueAt(x, 0) + "");
            txtFullname.setText(table.getValueAt(x, 1) +"");
            txtBirth.setText(table.getValueAt(x, 2) +"");
            txtEmail.setText(table.getValueAt(x, 3) + "");
            boxGender.setSelectedItem(table.getValueAt(x, 4) +"");
            boxRole.setSelectedItem(table.getValueAt(x, 5) + "");
            boxDepartmentID.setSelectedItem(table.getValueAt(x, 6) +"");
            txtEmpID.setEnabled(false);
        }
    }//GEN-LAST:event_tableMouseClicked

    private void btxDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btxDeleteActionPerformed
        String emp_ID = txtEmpID.getText();
        String fullname = txtFullname.getText();
        String birth = txtBirth.getText();
        String email = txtEmail.getText();
        String gender = boxGender.getItemAt(boxGender.getSelectedIndex());
        String role_ID = boxRole.getItemAt(boxRole.getSelectedIndex());
        String department_ID = boxDepartmentID.getItemAt(boxDepartmentID.getSelectedIndex());
        if(emp_ID.equals("")){
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã nhân viên muốn xóa!");
        }
        else{
            try {
                emp_DAO = new Employee_DAO();
                Employee empExist = emp_DAO.selectByID(emp_ID);
                if(empExist != null){
                    Department_DAO department_DAO = new Department_DAO();
                    Role_DAO role_DAO = new Role_DAO();
                    Role role = role_DAO.selectByID(role_ID);
                    Department department = department_DAO.selectByID(department_ID);
                    Employee emp = new CasualEmployee(emp_ID, fullname, config.f.parse("10/11/2003"), email, gender, role, department);
                    int reply = JOptionPane.showConfirmDialog(null, "Việc xóa có thể ảnh hưởng tới dữ liệu tham chiếu. Bạn có muốn xóa ?", "Yes", JOptionPane.YES_NO_OPTION);
                    if(reply == JOptionPane.YES_OPTION){
                        emp_DAO.delete(emp);
                        JOptionPane.showMessageDialog(this, "Xóa thành công!");
                        reset();
                    }
                    else{
                        JOptionPane.showMessageDialog(this, "Xóa không thành công!");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(this, "Nhân viên không tồn tại!");
                }
                JDBCConnection.disconnect(emp_DAO.getStatement().connect);
            } catch (SQLException | ParseException ex) {
                Logger.getLogger(view_department.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btxDeleteActionPerformed

    private void btnGetSalaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetSalaryActionPerformed
        String emp_ID = txtEmpID.getText();
        String fullname = txtFullname.getText();
        String textBirth = txtBirth.getText();
        String email = txtEmail.getText();
        String gender = boxGender.getItemAt(boxGender.getSelectedIndex());
        String role_ID = boxRole.getItemAt(boxRole.getSelectedIndex());
        String department_ID = boxDepartmentID.getItemAt(boxDepartmentID.getSelectedIndex());
        if(emp_ID.equals("") || fullname.equals("") || textBirth.equals("")|| 
           email.equals("") || gender.equals("") || role_ID.equals("") || department_ID.equals("")){
            JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin!");
        }
        else{
            try {
                emp_DAO = new Employee_DAO();
                Department_DAO department_DAO = new Department_DAO();
                Role_DAO role_DAO = new Role_DAO();
                Role role = role_DAO.selectByID(role_ID);
                Department department = department_DAO.selectByID(department_ID);
                Date birth = config.f.parse(textBirth);
                switch (role_ID) {
                    case "DEVELOPER" -> {
                        empPositionWork = new Developer(emp_ID, fullname, birth, email, gender,role, department);
                        break;
                    }
                    case "TESTER" -> {
                        empPositionWork = new Tester(emp_ID, fullname, birth, email, gender, role, department);
                        break;
                    }
                    case "DESIGNER" -> {
                        empPositionWork = new Designer(emp_ID, fullname, birth, email, gender, role, department);
                        break;
                    }
                    case "BINHTHUONG" -> {
                        empPositionWork = new CasualEmployee(emp_ID, fullname, birth, email, gender, role, department);
                        break;
                    }
                }
                view_Salary viewSalary = new view_Salary(empPositionWork);
                viewSalary.setVisible(true);
                this.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(view_department.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch(ParseException ex){
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng định dạng ngày tháng năm \n Ví dụ: 10/11/2003");
            }
        }
    }//GEN-LAST:event_btnGetSalaryActionPerformed

    private void backBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBtnMouseClicked
        new Home().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backBtnMouseClicked

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
            java.util.logging.Logger.getLogger(view_employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(view_employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(view_employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(view_employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new view_employee().setVisible(true);
            } catch (SQLException | ParseException ex) {
                Logger.getLogger(view_employee.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backBtn;
    private javax.swing.JComboBox<String> boxDepartmentID;
    private javax.swing.JComboBox<String> boxGender;
    private javax.swing.JComboBox<String> boxRole;
    private javax.swing.JButton btnGetSalary;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btxDelete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton ntbReset;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtBirth;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEmpID;
    private javax.swing.JTextField txtFullname;
    private javax.swing.JTextField txtSearchFullname;
    private javax.swing.JTextField txtSearchIDDepartment;
    // End of variables declaration//GEN-END:variables
}
