package DAO_Interface;

import JDBC.JDBCConnection;
import JDBC.statementUtil;
import config.config;
import model.Employee;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;
import model.Department;
import model.CasualEmployee;
import model.Project;
import model.Role;
public class Employee_DAO implements DAO_interface<Employee>{
    private statementUtil statement;
    private final String table_name = "database.employee";
    @Override
    public int insert(Employee employee) throws SQLException {
        HashMap<String, Object> map = new HashMap<>();
        map.put("emp_ID", employee.getID());
        map.put("fullname", employee.getFullname());
        map.put("birth", config.f.format(employee.getBirth()));
        map.put("email", employee.getEmail());
        map.put("gender", employee.getGender());
        map.put("role_ID", employee.getRole().getRole_ID());
        map.put("department_ID", employee.getDepartment().getDepartment_ID());
        statement = new statementUtil();
        int result = statement.insert(table_name, map);
        return result;
    }

    @Override
    public int update(Employee employee) throws SQLException {
        HashMap<String, Object> hashmap = new HashMap<>();
        hashmap.put("fullname", employee.getFullname());
        hashmap.put("birth", config.f.format(employee.getBirth()));
        hashmap.put("email", employee.getEmail());
        hashmap.put("gender", employee.getGender());
        hashmap.put("role_ID", employee.getRole().getRole_ID());
        hashmap.put("department_ID", employee.getDepartment().getDepartment_ID());
        statement = new statementUtil();
        String condition = "emp_ID = "+"'"+employee.getID()+"'";
        int result = statement.update(table_name, hashmap, condition);
        return result;
    }

    @Override
    public int delete(Employee employee) throws SQLException {
        statement = new statementUtil();
        String condition = "emp_ID = '" + employee.getID() +"'";
        int result = statement.delete(table_name, condition);
        return result;
    }

    @Override
    public ArrayList<Employee> selectAll() throws SQLException, ParseException {
        statement = new statementUtil();
        ArrayList<Employee> listEmp = new ArrayList<>();
        ResultSet rs = statement.select(table_name);
        while(rs.next()){
            Role_DAO role_DAO = new Role_DAO();
            Department_DAO department_DAO = new Department_DAO();
            String emp_ID = rs.getString("emp_ID");
            String fullname = rs.getString("fullname");
            Date birth = config.f.parse(rs.getString("birth"));
            String email = rs.getString("email");
            String gender = rs.getString("gender");
            String role_ID = rs.getString("role_ID");
            String department_ID = rs.getString("department_ID");
            Role role = role_DAO.selectByID(role_ID);
            Department department = department_DAO.selectByID(department_ID);
            Employee employee = new CasualEmployee(emp_ID, fullname, birth, email, gender, role, department);
            listEmp.add(employee);
        }
        JDBCConnection.disconnect(statement.connect);
        return listEmp;
    }

    @Override
    public ArrayList<Employee> selectByCondition(String condition) throws SQLException, ParseException{
        statement = new statementUtil();
        ArrayList<Employee> listEmployee = new ArrayList<>();
        ResultSet rs = statement.select(table_name, condition);
        while(rs.next()){
            Role_DAO role_DAO = new Role_DAO();
            Department_DAO department_DAO = new Department_DAO();
            String emp_ID = rs.getString("emp_ID");
            String fullname = rs.getString("fullname");
            Date birth = config.f.parse(rs.getString("birth"));
            String email = rs.getString("email");
            String gender = rs.getString("gender");
            String role_ID = rs.getString("role_ID");
            String department_ID = rs.getString("department_ID");
            Role role = role_DAO.selectByID(role_ID);
            Department department = department_DAO.selectByID(department_ID);
            Employee employee = new CasualEmployee(emp_ID, fullname, birth, email, gender, role, department);
            listEmployee.add(employee);
        }
        JDBCConnection.disconnect(statement.connect);
        return listEmployee;
    }

    @Override
    public Employee selectByID(String ID) throws SQLException, ParseException {
        statement = new statementUtil();
        String condition = "emp_ID = '"+ ID +"';";
        ResultSet rs = statement.select(table_name, condition);
        Employee employee = null;
        while(rs.next()){
            Role_DAO role_DAO = new Role_DAO();
            Department_DAO department_DAO = new Department_DAO();
            String emp_ID = rs.getString("emp_ID");
            String fullname = rs.getString("fullname");
            Date birth = config.f.parse(rs.getString("birth"));
            String email = rs.getString("email");
            String gender = rs.getString("gender");
            String role_ID = rs.getString("role_ID");
            String department_ID = rs.getString("department_ID");
            Role role = role_DAO.selectByID(role_ID);
            Department department = department_DAO.selectByID(department_ID);
            employee = new CasualEmployee(emp_ID, fullname, birth, email, gender, role, department);
        }
        JDBCConnection.disconnect(statement.connect);
        return employee;
    }

    public statementUtil getStatement() {
        return statement;
    }

    public void setStatement(statementUtil statement) {
        this.statement = statement;
    }
}
