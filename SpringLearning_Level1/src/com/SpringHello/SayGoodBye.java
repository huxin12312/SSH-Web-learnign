package com.SpringHello;

public class SayGoodBye {
  private String name;
  private String Greeting;
  private String Cheers;

public String getName() {
	System.out.println("GoodBye ");
	return name;
}

public String getGreeting() {
	return Greeting;
}

public void setGreeting(String Greeting) {
	this.Greeting = Greeting;
}

public String getCheers() {
	return Cheers;
}

public void setCheers(String Cheers) {
	this.Cheers = Cheers;
}

public void setName(String name) {
	this.name = name;
} 
}
