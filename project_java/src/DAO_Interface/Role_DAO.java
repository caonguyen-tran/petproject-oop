package DAO_Interface;

import JDBC.JDBCConnection;
import JDBC.statementUtil;
import model.Role;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

public class Role_DAO implements DAO_interface<Role>{
    private final String table_name = "database.role";
    private statementUtil statement;
    @Override
    public int insert(Role role) throws SQLException {
        statement = new statementUtil();
        HashMap<String, Object> map = new HashMap<>();
        map.put("role_ID", role.getRole_ID());
        map.put("name_role", role.getName_role());
        int result = statement.insert(table_name, map);
        System.out.println(result);
        return result;
    }

    @Override
    public int update(Role role) throws SQLException {
        return 0;
    }

    @Override
    public int delete(Role role) throws SQLException {
        statement = new statementUtil();
        int result = statement.delete(table_name, "role_ID = '" + role.getRole_ID() +"'");
        return result;
    }

    @Override
    public ArrayList<Role> selectAll() throws SQLException, ParseException {
        statement = new statementUtil();
        ArrayList<Role> listRole = new ArrayList<>();
        ResultSet rs = statement.select(table_name);
        while(rs.next()){
            String role_ID = rs.getString("role_ID");
            String name_role = rs.getString("name_role");
            Role r = new Role(role_ID, name_role);
            listRole.add(r);
        }
        JDBCConnection.disconnect(statement.connect);
        return listRole;
    }

    @Override
    public ArrayList<Role> selectByCondition(String condition) {
        return null;
    }

    @Override
    public Role selectByID(String ID) throws SQLException, ParseException {
        statement = new statementUtil();
        Role r = null;
        String condition = "role_ID = '"+ ID +"';";
        ResultSet rs = statement.select(table_name, condition);
        while(rs.next()){
            String role_ID = rs.getString("role_ID");
            String name_role = rs.getString("name_role");
            r = new Role(role_ID, name_role);
        }
        JDBCConnection.disconnect(statement.connect);
        return r;
    }

    public statementUtil getStatement() {
        return statement;
    }

    public void setStatement(statementUtil statement) {
        this.statement = statement;
    }
    
}
