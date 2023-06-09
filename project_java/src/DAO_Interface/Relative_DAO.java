/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO_Interface;

import JDBC.JDBCConnection;
import JDBC.statementUtil;
import config.config;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import model.Employee;
import model.Relative;

/**
 *
 * @author ACER
 */
public class Relative_DAO implements DAO_interface<Relative>{
    private statementUtil statement;
    private final String table_name = "database.relative";
    @Override
    public int insert(Relative t) throws SQLException {
        HashMap<String, Object> map = new HashMap<>();
        map.put("ID", t.getID());
        map.put("fullname", t.getFullname());
        map.put("birth", config.f.format(t.getBirth()));
        map.put("email", t.getEmail());
        map.put("gender", t.getGender());
        map.put("emp_ID", t.getEmployee().getID());
        map.put("relationship", t.getRelationship());
        statement = new statementUtil();
        int result = statement.insert(table_name, map);
        return result;
    }

    @Override
    public int update(Relative t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(Relative t) throws SQLException {
        statement = new statementUtil();
        String condition = "ID = '" + t.getID() +"'";
        int result = statement.delete(table_name, condition);
        return result;
    }

    @Override
    public ArrayList<Relative> selectAll() throws SQLException, ParseException {
        statement = new statementUtil();
        ArrayList<Relative> listRelative = new ArrayList<>();
        ResultSet rs = statement.select(table_name);
        while(rs.next()){
            Employee_DAO emp_DAO = new Employee_DAO();
            String relative_ID = rs.getString("ID");
            String fullname = rs.getString("fullname");
            Date birth = config.f.parse(rs.getString("birth"));
            String email = rs.getString("email");
            String gender = rs.getString("gender");
            String emp_ID = rs.getString("emp_ID");
            Employee emp = emp_DAO.selectByID(emp_ID);
            String relationship = rs.getString("relationship");
            Relative relative = new Relative(relative_ID, fullname, birth, email, gender, emp, relationship);
            listRelative.add(relative);
        }
        JDBCConnection.disconnect(statement.connect);
        return listRelative;
    }

    @Override
    public ArrayList<Relative> selectByCondition(String condition) throws SQLException, ParseException {
        statement = new statementUtil();
        ArrayList<Relative> listRelative = new ArrayList<>();
        ResultSet rs = statement.select(table_name, condition);
        while(rs.next()){
            Employee_DAO emp_DAO = new Employee_DAO();
            String relative_ID = rs.getString("ID");
            String fullname = rs.getString("fullname");
            Date birth = config.f.parse(rs.getString("birth"));
            String email = rs.getString("email");
            String gender = rs.getString("gender");
            String emp_ID = rs.getString("emp_ID");
            Employee emp = emp_DAO.selectByID(emp_ID);
            String relationship = rs.getString("relationship");
            Relative relative = new Relative(relative_ID, fullname, birth, email, gender, emp, relationship);
            listRelative.add(relative);
        }
        JDBCConnection.disconnect(statement.connect);
        return listRelative;
    }

    @Override
    public Relative selectByID(String ID) throws SQLException, ParseException {
        statement = new statementUtil();
        Relative relative = null;
        String condition = "ID = '"+ ID +"';";
        ResultSet rs = statement.select(table_name, condition);
        while(rs.next()){
            Employee_DAO emp_DAO = new Employee_DAO();
            String relative_ID = rs.getString("ID");
            String fullname = rs.getString("fullname");
            Date birth = config.f.parse(rs.getString("birth"));
            String email = rs.getString("email");
            String gender = rs.getString("gender");
            String emp_ID = rs.getString("emp_ID");
            Employee emp = emp_DAO.selectByID(emp_ID);
            String relationship = rs.getString("relationship");
            relative = new Relative(relative_ID, fullname, birth, email, gender, emp, relationship);
        }
        JDBCConnection.disconnect(statement.connect);
        return relative;
    }
}
