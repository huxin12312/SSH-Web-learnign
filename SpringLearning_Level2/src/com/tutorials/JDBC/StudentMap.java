package com.tutorials.JDBC;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
public class StudentMap implements RowMapper<Students> {
    public Students mapRow(ResultSet result, int rowNum) throws SQLException{
		Students student = new Students();
		student.setAge(result.getInt("age"));
		student.setId(result.getInt("id"));
		student.setName(result.getString("name"));
    	return student;	
    }
}
