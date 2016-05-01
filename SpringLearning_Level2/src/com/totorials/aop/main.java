package com.totorials.aop;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main {
      public static void main(String[] args){
    	  ApplicationContext context = new ClassPathXmlApplicationContext("Beans2.xml");
          Student student = (Student) context.getBean("student");
          
          Integer age = student.getAge();
          String name = student.getName();
          System.out.println("The student name is : " + name + " and age is :" + age);
          student.printThrowException();
          
          
      }
}
