package com.tutorials.JDBC;
import java.sql.SQLException;
import java.util.List;

import javax.sql.*;
public interface StudentsDao {
    
	public void setDataSource(DataSource ds);
	
	public void create(String name, Integer age) throws SQLException;
		
	public 	Students getStudent(Integer id);
	
	public List<Students> list();
	 
}
