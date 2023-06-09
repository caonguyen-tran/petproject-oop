/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO_Interface;

import JDBC.statementUtil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.text.ParseException;
import model.ProjectManager;
import JDBC.JDBCConnection;
import java.util.ArrayList;
import java.util.HashMap;
import model.Employee;
import model.Project;


/**
 *
 * @author ACER
 */
public class ProjectManager_DAO implements DAO_interface<ProjectManager>{
    private final String table_name = "database.project_employee";
    private statementUtil statement;
    @Override
    public int insert(ProjectManager t) throws SQLException {
        statement = new statementUtil();
        String emp_ID = t.getEmployee().getID();
        String project_ID = t.getProject().getProject_ID();
        String task = t.getTask();
        Connection connect = JDBCConnection.getConnection();
        Statement stm = connect.createStatement();
        String checkNumberEmp = "SELECT COUNT(emp_ID) AS NumberOfEmployeeInProject"+
                ",(SELECT COUNT(project_ID) FROM "+table_name+" WHERE emp_ID ='"+emp_ID+"') "+
                "AS NumberProjectOfEmployee FROM "+table_name+" WHERE project_ID = '"+project_ID+"';";
        ResultSet rs = stm.executeQuery(checkNumberEmp);
        if(rs.next()){
            int numberEmp = rs.getInt("NumberOfEmployeeInProject");
            int numberProject = rs.getInt("NumberProjectOfEmployee");
            if(numberEmp >= 10){
                return -2;
            }
            else if(numberProject >=3){
                return -1;
            }
            else{
                HashMap<String, Object> hashmap = new HashMap<>();
                hashmap.put("project_ID", project_ID);
                hashmap.put("emp_ID", emp_ID);
                hashmap.put("task", task);
                return statement.insert(table_name, hashmap);
            }
        }
        return -2;
    }

    @Override
    public int update(ProjectManager t) throws SQLException {
        statement = new statementUtil();
        String project_ID = t.getProject().getProject_ID();
        String emp_ID = t.getEmployee().getID();
        String task = t.getTask();
        String condition = "project_ID = '"+project_ID+"' AND emp_ID = '"+emp_ID+"'";
        HashMap<String, Object> hashmap = new HashMap<>();
        hashmap.put("task", task);
        return statement.update(table_name, hashmap, condition);
    }

    @Override
    public int delete(ProjectManager t) throws SQLException {
        statement = new statementUtil();
        String project_ID = t.getProject().getProject_ID();
        String emp_ID = t.getEmployee().getID();
        String checkNumberEmp = "SELECT COUNT(emp_ID) AS NumberOfEmployeeInProject FROM "+table_name+
                " WHERE project_ID = '"+
                project_ID + "';";
        Connection connect = JDBCConnection.getConnection();
        Statement stm = connect.createStatement();
        ResultSet checkEmp = stm.executeQuery(checkNumberEmp);
        if(checkEmp.next()){
            int numberEmp = checkEmp.getInt("NumberOfEmployeeInProject");
            if(numberEmp > 5){
                String condition = " project_ID = '"+project_ID+"' AND emp_ID = '"+emp_ID+"'";
                //Xoa tai project_ID = ? (condition)
                int result = statement.delete(table_name, condition);
                return result;
            }
            return -1;
        }
        return -2;
    }

    @Override
    public ArrayList<ProjectManager> selectAll() throws SQLException, ParseException {
        statement = new statementUtil();
        ArrayList<ProjectManager> listProjectManager = new ArrayList<>();
        ResultSet rs = statement.select(table_name);
        while(rs.next()){
            String project_ID = rs.getString("project_ID");
            String emp_ID = rs.getString("emp_ID");
            String task = rs.getString("task");
            Project_DAO project_DAO = new Project_DAO();
            Employee_DAO emp_DAO = new Employee_DAO();
            Project p = project_DAO.selectByID(project_ID);
            Employee emp = emp_DAO.selectByID(emp_ID);
            ProjectManager projectManager = new ProjectManager(p, emp, task);
            listProjectManager.add(projectManager);
        }
        JDBCConnection.disconnect(statement.connect);
        return listProjectManager;
    }

    @Override
    public ArrayList<ProjectManager> selectByCondition(String condition) throws SQLException, ParseException {
        statement = new statementUtil();
        ArrayList<ProjectManager> listProjectManager = new ArrayList<>();
        ResultSet rs = statement.select(table_name, condition);
        while(rs.next()){
            String project_ID = rs.getString("project_ID");
            String emp_ID = rs.getString("emp_ID");
            String task = rs.getString("task");
            Project_DAO project_DAO = new Project_DAO();
            Employee_DAO emp_DAO = new Employee_DAO();
            Project p = project_DAO.selectByID(project_ID);
            Employee emp = emp_DAO.selectByID(emp_ID);
            ProjectManager projectManager = new ProjectManager(p, emp, task);
            listProjectManager.add(projectManager);
        }
        JDBCConnection.disconnect(statement.connect);
        return listProjectManager;
    }

    @Override
    public ProjectManager selectByID(String ID) throws SQLException, ParseException {
        return null;
    }

    public ArrayList<ProjectManager> selectByProjectID(String ID) throws SQLException, ParseException{
        statement = new statementUtil();
        ArrayList<ProjectManager> listProjectManager = new ArrayList<>();
        String condition = " project_ID = '"+ID+"'";
        ResultSet rs = statement.select(table_name, condition);
        while(rs.next()){
            String project_ID = rs.getString("project_ID");
            String emp_ID = rs.getString("emp_ID");
            String task = rs.getString("task");
            Project_DAO project_DAO = new Project_DAO();
            Employee_DAO emp_DAO = new Employee_DAO();
            Project p = project_DAO.selectByID(project_ID);
            Employee emp = emp_DAO.selectByID(emp_ID);
            ProjectManager projectManager = new ProjectManager(p, emp, task);
            listProjectManager.add(projectManager);
        }
        JDBCConnection.disconnect(statement.connect);
        return listProjectManager;
    }
    public statementUtil getStatement() {
        return statement;
    }

    public void setStatement(statementUtil statement) {
        this.statement = statement;
    }
}
