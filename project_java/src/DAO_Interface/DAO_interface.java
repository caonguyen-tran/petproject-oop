package DAO_Interface;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

public interface DAO_interface<T> {
    public int insert(T t) throws SQLException;
    public int update(T t) throws SQLException;
    public int delete(T t) throws SQLException;
    public ArrayList<T> selectAll() throws SQLException, ParseException;
    public ArrayList<T> selectByCondition(String condition) throws SQLException, ParseException;
    public T selectByID(String ID) throws SQLException, ParseException;
}
