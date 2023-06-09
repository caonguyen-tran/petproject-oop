package JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class statementUtil {
    public Connection connect;
    public ResultSet select(String table_name, String condition) throws SQLException{
        connect = JDBCConnection.getConnection();
        StringBuilder sb = new StringBuilder("SELECT * FROM " + table_name);
        sb.append(" WHERE ").append(condition);
        Statement statement = connect.createStatement();
        ResultSet rs = statement.executeQuery(sb.toString());
        return rs;
    }
    public ResultSet select(String table_name) throws SQLException {
        connect = JDBCConnection.getConnection();
        String sql = "SELECT * FROM " + table_name;
        Statement statement = connect.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        return rs;
    }

    public int insert(String table_name, HashMap<String, Object> hashmap) throws SQLException {
        connect = JDBCConnection.getConnection();
        Statement stm = connect.createStatement();
        StringBuilder sb = new StringBuilder("INSERT INTO " + table_name + "(");
        StringBuilder insert_values = new StringBuilder("VALUES (");
        for(Entry<String, Object> entry : hashmap.entrySet()){
            sb.append(entry.getKey()).append(",");
            insert_values.append("'").append(entry.getValue()).append("',");
        }
        sb.delete(sb.length() - 1, sb.length());
        insert_values.delete(insert_values.length() - 1, insert_values.length());
        sb.append(")");
        insert_values.append(");");
        sb.append(insert_values);
        int result = stm.executeUpdate(String.valueOf(sb));
        return result;
    }

    public int update(String table_name, HashMap<String, Object> hashmap, String condition) throws SQLException {
        connect = JDBCConnection.getConnection();
        Statement statement = connect.createStatement();
        StringBuilder sql = new StringBuilder("UPDATE "+table_name+" SET ");
        for(Map.Entry<String, Object> entry: hashmap.entrySet()){
            sql.append(entry.getKey()).append(" = '").append(entry.getValue()).append("',");
        }
        sql.delete(sql.length() - 1, sql.length());
        sql.append(" WHERE ").append(condition).append(";");
        int result = statement.executeUpdate(String.valueOf(sql));
        return result;
    }

    public int delete(String table_name, String condition) throws SQLException{
        connect = JDBCConnection.getConnection();
        Statement statement = connect.createStatement();
        StringBuilder sql = new StringBuilder("DELETE FROM "+table_name+" WHERE "+condition+";");
        int result = statement.executeUpdate(String.valueOf(sql));
        return result;
    }
}
