package DAO_Interface;

import JDBC.JDBCConnection;
import JDBC.statementUtil;
import model.Department;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

public class Department_DAO implements DAO_interface<Department>{
    private final String table_name = "database.department";
    private statementUtil statement;
    @Override
    public int insert(Department department) throws SQLException {
        statement = new statementUtil();
        HashMap<String, Object> hashmap = new HashMap<>();
        hashmap.put("department_ID", department.getDepartment_ID());
        hashmap.put("department_name", department.getDepartment_name());
        int result = statement.insert(table_name, hashmap);
        System.out.println(result);
        return result;
    }

    @Override
    public int update(Department department) throws SQLException {
        statement = new statementUtil();
        HashMap<String, Object> hashmap = new HashMap<>();
        hashmap.put("department_name", department.getDepartment_name());
        String condition = "department_ID = '"+department.getDepartment_ID()+"'";
        int result = statement.update(table_name, hashmap, condition);
        return result;
    }

    @Override
    public int delete(Department department) throws SQLException {
        statement = new statementUtil();
        String condition = "department_ID = '" + department.getDepartment_ID() +"'";
        int result = statement.delete(table_name, condition);
        return result;
    }

    @Override
    public ArrayList<Department> selectAll() throws SQLException, ParseException {
        statement = new statementUtil();
        ArrayList<Department> listDepartment = new ArrayList<>();
        ResultSet rs = statement.select(table_name);
        while(rs.next()){
            String department_ID = rs.getString("department_ID");
            String department_name = rs.getString("department_name");
            Department department = new Department(department_ID, department_name);
            listDepartment.add(department);
        }
        JDBCConnection.disconnect(statement.connect);
        return listDepartment;
    }

    @Override
    public ArrayList<Department> selectByCondition(String condition) {
        return null;
    }

    @Override
    public Department selectByID(String ID) throws SQLException, ParseException {
        statement = new statementUtil();
        String condition = "department_ID = '"+ ID +"';";
        Department department = null;
        ResultSet rs = statement.select(table_name, condition);
        while(rs.next()){
            String department_ID = rs.getString("department_ID");
            String department_name = rs.getString("department_name");
            department = new Department(department_ID, department_name);
        }
        JDBCConnection.disconnect(statement.connect);
        return department;
    }

    public statementUtil getStatement() {
        return statement;
    }

    public void setStatement(statementUtil statement) {
        this.statement = statement;
    }
    
    
}
