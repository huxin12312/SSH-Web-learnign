package com.SpringHello;

public class HelloWorld {
   private String name;
   private String cheers;
   private String Greeting;

public String getName() {
	System.out.println("hello Body ");
	return name;
}

public void setName(String name) {
	this.name = name;
}


/*
public void init(){
	 System.out.println("init it");
}
   
public void destory(){
	System.out.println("destory the method");
}
*/
public String getCheers() {
	return cheers;
}

public void setCheers(String cheers) {
	this.cheers = cheers;
}

public String getGreeting() {
	return Greeting;
}

public void setGreeting(String greeting) {
	Greeting = greeting;
}
   
}
