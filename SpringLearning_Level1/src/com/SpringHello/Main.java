package com.SpringHello;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
public class Main {
  public static void main(String[] args){
	 //@SuppressWarnings("deprecation")
	//XmlBeanFactory context = new XmlBeanFactory(new ClassPathResource("Beans.xml"));
	  @SuppressWarnings("resource")
	  ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	  //also we could use ApplicationContext, BeanFactory is usually used for light application, but its faster and smallest
	
	  context.start();
	  HelloWorld hello1 = (HelloWorld) context.getBean("helloWorld");
	  //SayGoodBye goodbye = (SayGoodBye) context.getBean("sayGoodBye");
	  
	  //hello1.setHello("Pobby");
	  //goodbye.setName("pobby");
	  
	  System.out.println(hello1.getName() + " " + hello1.getCheers() + " Third combo: " + hello1.getGreeting());
	  //HelloWorld hello2 = (HelloWorld) context.getBean("helloWorld");
	  SayGoodBye goodbye2 = (SayGoodBye) context.getBean("sayGoodBye");
	  System.out.println(goodbye2.getName() + " " + goodbye2.getGreeting() + " third combo" + goodbye2.getCheers());
	  context.stop();
	  context.close();
	 // context.registerShutdownHook();
  }
}
