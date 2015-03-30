package com.learnjbehave.roughwork;

public class methodnameprint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println("Hello");
	somefun();
		
	}
	

	public static void foo1(){
	      class Local {};
	      String name = Local.class.getEnclosingMethod().getName();
	      System.out.println(name);
	   }

	
	public static void somefun(){
		foo1();
		 class Local {};
	      String name = Local.class.getEnclosingMethod().getName();
	      System.out.println(name);
	}
}
