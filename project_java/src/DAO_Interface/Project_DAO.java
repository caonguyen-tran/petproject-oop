/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO_Interface;
import JDBC.JDBCConnection;
import JDBC.statementUtil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashMap;
import model.Project;
import config.config;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author ACER
 */
public class Project_DAO implements DAO_interface<Project>{
    private statementUtil statement;
    private final String table_name = "database.project";
    @Override
    public int insert(Project t) throws SQLException {
        statement = new statementUtil();
        HashMap<String, Object> hashmap = new HashMap<>();
        hashmap.put("project_ID", t.getProject_ID());
        hashmap.put("project_name", t.getProject_name());
        hashmap.put("ngay_bat_dau", config.f.format(t.getNgayBatDau()));
        hashmap.put("ngay_ket_thuc", config.f.format(t.getNgayKetThuc()));
        hashmap.put("nguoi_chu_nhiem", t.getnguoiChuNhiem());
        hashmap.put("chi_phi", t.getKinhPhiDauTu());
        int result = statement.insert(table_name, hashmap);
        return result;
    }

    @Override
    public int update(Project t) throws SQLException {
        statement = new statementUtil();
        HashMap<String, Object> hashmap = new HashMap<>();
        hashmap.put("project_name", t.getProject_name());
        hashmap.put("ngay_bat_dau", config.f.format(t.getNgayBatDau()));
        hashmap.put("ngay_ket_thuc", config.f.format(t.getNgayKetThuc()));
        hashmap.put("nguoi_chu_nhiem", t.getnguoiChuNhiem());
        hashmap.put("chi_phi", t.getKinhPhiDauTu());
        String condition = " project_ID ='" + t.getProject_ID() +"'";
        int result = statement.update(table_name, hashmap, condition);
        return result;
    }

    @Override
    public int delete(Project t) throws SQLException {
        statement = new statementUtil();
        String condition = " project_ID = '"+t.getProject_ID()+"'";
        int result = statement.delete(table_name, condition);
        return result;
    }

    @Override
    public ArrayList<Project> selectAll() throws SQLException, ParseException {
        statement = new statementUtil();
        ArrayList<Project> listProject = new ArrayList<>();
        ResultSet rs = statement.select(table_name);
        while(rs.next()){
            String project_ID = rs.getString("project_ID");
            String project_name = rs.getString("project_name");
            Date dateStart = config.f.parse(rs.getString("ngay_bat_dau"));
            Date dateEnd = config.f.parse(rs.getString("ngay_ket_thuc"));
            String project_lead = rs.getString("nguoi_chu_nhiem");
            double funding = rs.getDouble("chi_phi");
            Project p = new Project(project_ID, project_name, dateStart, dateEnd, project_lead, funding);
            listProject.add(p);
        }
        JDBCConnection.disconnect(statement.connect);
        return listProject;
    }

    @Override
    public ArrayList<Project> selectByCondition(String condition) throws SQLException, ParseException {
        statement = new statementUtil();
        ArrayList<Project> listProject = new ArrayList<>();
        ResultSet rs = statement.select(table_name, condition);
        while(rs.next()){
            String project_ID = rs.getString("project_ID");
            String project_name = rs.getString("project_name");
            Date dateStart = config.f.parse(rs.getString("ngay_bat_dau"));
            Date dateEnd = config.f.parse(rs.getString("ngay_ket_thuc"));
            String project_lead = rs.getString("nguoi_chu_nhiem");
            double funding = rs.getDouble("chi_phi");
            Project p = new Project(project_ID, project_name, dateStart, dateEnd, project_lead, funding);
            listProject.add(p);
        }
        JDBCConnection.disconnect(statement.connect);
        return listProject;
    }

    @Override
    public Project selectByID(String ID) throws SQLException, ParseException {
        statement = new statementUtil();
        Project p = null;
        String condition = "project_ID = '"+ID+"'";
        ResultSet rs = statement.select(table_name, condition);
        while(rs.next()){
            String project_ID = rs.getString("project_ID");
            String project_name = rs.getString("project_name");
            Date dateStart = config.f.parse(rs.getString("ngay_bat_dau"));
            Date dateEnd = config.f.parse(rs.getString("ngay_ket_thuc"));
            String project_lead = rs.getString("nguoi_chu_nhiem");
            double funding = rs.getDouble("chi_phi");
            p = new Project(project_ID, project_name, dateStart, dateEnd, project_lead, funding);
        }
        JDBCConnection.disconnect(statement.connect);
        return p;
    }

    public statementUtil getStatement() {
        return statement;
    }

    public void setStatement(statementUtil statement) {
        this.statement = statement;
    }
    
}
