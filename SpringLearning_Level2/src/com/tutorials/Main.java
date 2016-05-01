package com.tutorials;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
         public static void main(String[] args){
        	 ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
            TextEditor editor = (TextEditor) context.getBean("textEditor");
            editor.spellChecking();
            System.out.println();
            JavaCollection javacollection = (JavaCollection) context.getBean("javaCollection");
            System.out.println(javacollection.getTempList() + " " + javacollection.getTempMap() + " " + javacollection.getTempSet());
         }
}
