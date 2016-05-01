package com.tutorials.JDBC;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import com.mysql.jdbc.Connection;


public class StudentJDBCTemplate implements StudentsDao {
    private DataSource dataSource;
    private SimpleJdbcCall jdbcCall;
	@Override
	public void setDataSource(DataSource ds) {
		// TODO Auto-generated method stub
	   dataSource = ds;
	   jdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("getRecord");
	}

	@Override
	public void create(String name, Integer age) throws SQLException {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplateObject = new JdbcTemplate(dataSource);
		String TableName = "students";
		if(!tableExist(jdbcTemplateObject, TableName)) createTable(jdbcTemplateObject, TableName);
		String SQL = "insert into " + TableName + " (name, age) value (?, ?)";
		jdbcTemplateObject.update(SQL, name, age);
		// System.out.println("Created Record Name = " + name + " Age = " + age);		
	}

	private void createTable(JdbcTemplate jdbc, String tableName) {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer("");
		sql.append("CREATE TABLE " + tableName + "(");
		sql.append("id int NOT NULL AUTO_INCREMENT,");
		sql.append("name varchar(255) NOT NULL,");
		sql.append("age int NOT NULL,");
		sql.append("PRIMARY KEY (id));");
		
		try{
			jdbc.update(sql.toString());
			
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			System.out.println("table created + " + tableName);
		}
		
		
	}

	private boolean tableExist(JdbcTemplate jdbc, String tableName) throws SQLException {
		// TODO Auto-generated method stub
		java.sql.Connection connection = jdbc.getDataSource().getConnection();
		  ResultSet tabs = null;  
	        try {  
	            DatabaseMetaData dbMetaData = connection.getMetaData();  
	            String[]   types   =   { "TABLE" };  
	            tabs = dbMetaData.getTables(null, null, tableName, types);  
	            if (tabs.next()) {  
	                return true;  
	            }  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }finally{  
	            tabs.close();  
	            connection.close();  
	        }  
	        return false;  
	    } 

	

	@Override
	public Students getStudent(Integer id) {
		// TODO Auto-generated method stub
		SqlParameterSource in = new MapSqlParameterSource().addValue("id", id);
		Map<String, Object> out = jdbcCall.execute(in);
		Students student = new Students();
		student.setId(id);
		student.setName((String) out.get("name"));
		student.setAge((Integer) out.get("age"));
		
		return student;
	}

	@Override
	public List<Students> list() {
		// TODO Auto-generated method stub
		String sql = "select * from Students";
		JdbcTemplate jdbcTemplateObject = new JdbcTemplate(dataSource);
		List<Students> list = jdbcTemplateObject.query(sql, new StudentMap());
		
		return list;
	}

}
