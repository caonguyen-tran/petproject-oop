/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO_Interface;

import JDBC.JDBCConnection;
import java.sql.Connection;
import JDBC.statementUtil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.HashMap;
import model.DepartmentManager;
import config.config;
import java.util.ArrayList;
import java.util.Date;
import model.Department;
import model.Employee;

/**
 *
 * @author ACER
 */
public class DepartmentManager_DAO implements DAO_interface<DepartmentManager>{
    private final String table_name = "database.department_manager";
    private statementUtil statement;
    private Statement statementSql;
    @Override
    public int insert(DepartmentManager t) throws SQLException {
        statement = new statementUtil();
        Connection connect = JDBCConnection.getConnection();
        statementSql = connect.createStatement();
        String sqlCheck = "SELECT COUNT(emp_ID) AS NumberOfEmployees FROM " + table_name + " WHERE emp_ID = '"+t.getEmployee().getID()+"';";
        ResultSet rs = statementSql.executeQuery(sqlCheck);
        if(rs.next()){
            int countEmp = Integer.parseInt(rs.getString("NumberOfEmployees"));
            if(countEmp < 2){
                HashMap<String, Object> hashmap = new HashMap<>();
                hashmap.put("department_ID", t.getDepartment().getDepartment_ID());
                hashmap.put("emp_ID", t.getEmployee().getID());
                hashmap.put("ngay_bo_nhiem", config.f.format(t.getNgay_bo_nhiem()));
                int result = statement.insert(table_name, hashmap);
                return result;
            }
        }
        JDBCConnection.disconnect(connect);
        return 0;
    }

    @Override
    public int update(DepartmentManager t) throws SQLException {
        statement = new statementUtil();
        Connection connect = JDBCConnection.getConnection();
        statementSql = connect.createStatement();
        String sqlCheck = "SELECT COUNT(emp_ID) AS NumberOfEmployees FROM " + table_name + " WHERE emp_ID = '"+t.getEmployee().getID()+"';";
        ResultSet rs = statementSql.executeQuery(sqlCheck);
        if(rs.next()){
            int countEmp = Integer.parseInt(rs.getString("NumberOfEmployees"));
            if(countEmp < 2){
                HashMap<String, Object> hashmap = new HashMap<>();
                hashmap.put("emp_ID", t.getEmployee().getID());
                hashmap.put("ngay_bo_nhiem", config.f.format(t.getNgay_bo_nhiem()));
                String condition = "department_ID = '"+t.getDepartment().getDepartment_ID()+"'";
                int result = statement.update(table_name, hashmap, condition);
                return result;
            }
        }
        return 0;
    }

    @Override
    public int delete(DepartmentManager t) throws SQLException {
        String condition = "department_ID = '" + t.getDepartment().getDepartment_ID() +"'";
        int result = statement.delete(table_name, condition);
        return result;
    }

    @Override
    public ArrayList<DepartmentManager> selectAll() throws SQLException, ParseException {
        statement = new statementUtil();
        ArrayList<DepartmentManager> listDepartmentManager = new ArrayList<>();
        ResultSet rs = statement.select(table_name);
        while(rs.next()){
            Employee_DAO emp_DAO = new Employee_DAO();
            Department_DAO department_DAO = new Department_DAO();
            String department_ID = rs.getString("department_ID");
            Department department = department_DAO.selectByID(department_ID);
            String emp_ID = rs.getString("emp_ID");
            Employee emp = emp_DAO.selectByID(emp_ID);
            Date dateStart = config.f.parse(rs.getString("ngay_bo_nhiem"));
            DepartmentManager departmentManager = new DepartmentManager(department, emp, dateStart);
            listDepartmentManager.add(departmentManager);
        }
        JDBCConnection.disconnect(statement.connect);
        return listDepartmentManager;
    }

    @Override
    public ArrayList<DepartmentManager> selectByCondition(String condition) throws SQLException, ParseException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public DepartmentManager selectByID(String ID) throws SQLException, ParseException {
        statement = new statementUtil();
        String condition = "department_ID = '"+ ID +"';";
        ResultSet rs = statement.select(table_name, condition);
        DepartmentManager departmentManager = null;
        while(rs.next()){
            Employee_DAO emp_DAO = new Employee_DAO();
            Department_DAO department_DAO = new Department_DAO();
            String department_ID = rs.getString("department_ID");
            Department department = department_DAO.selectByID(department_ID);
            String emp_ID = rs.getString("emp_ID");
            Employee emp = emp_DAO.selectByID(emp_ID);
            Date dateStart = config.f.parse(rs.getString("ngay_bo_nhiem"));
            departmentManager = new DepartmentManager(department, emp, dateStart);
        }
        JDBCConnection.disconnect(statement.connect);
        return departmentManager;
    }
    
    public statementUtil getStatement() {
        return statement;
    }

    public void setStatement(statementUtil statement) {
        this.statement = statement;
    }

    public Statement getStatementSql() {
        return statementSql;
    }

    public void setStatementSql(Statement statementSql) {
        this.statementSql = statementSql;
    }
    
    
}
