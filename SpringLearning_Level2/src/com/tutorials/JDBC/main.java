package com.tutorials.JDBC;

import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main {
   public static void main(String[] args) throws SQLException{
	   ApplicationContext context = new ClassPathXmlApplicationContext("Beans3.xml");
       StudentJDBCTemplate studentJDBCTemplate = (StudentJDBCTemplate) context.getBean("studentJDBCTemplate");
       System.out.println("Starting storing......");
       studentJDBCTemplate.create("Xin", 26);
       studentJDBCTemplate.create("Chfishly", 21);
       studentJDBCTemplate.create("lisa", 24);
       System.out.println("Finished create table....");
       List<Students> list = studentJDBCTemplate.list();
       for(Students s : list){
    	   System.out.println("name is " + s.getName());
    	   System.out.println("age is :" + s.getAge());
    	   System.out.println("Student ID is :" + s.getId());
        }
       
       System.out.println("-----------test ID searching");
       Students studentID = studentJDBCTemplate.getStudent(2);
       System.out.println("ID is :" + studentID.getId());
       System.out.println("name is :" + studentID.getName());
       System.out.println("age is :" + studentID.getAge());
       
   }
}
