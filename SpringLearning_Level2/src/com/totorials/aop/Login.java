package com.totorials.aop;

public class Login {
   public void beforeAdvice(){
	   System.out.println("before setup profile");
   }
   
   public void afterAdvice(){
	   System.out.println("After setup profile");
   }
   
   public void afterReturningAdvice(Object obj){
	   System.out.println("Print after return :" + obj.toString());
   }
   
   public void afterThrowingAdvice(IllegalArgumentException ex){
	   System.out.println("Printing after throw some ex :" + ex.toString());
   }
}
