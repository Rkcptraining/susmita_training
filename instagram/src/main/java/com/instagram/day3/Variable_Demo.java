package com.instagram.day3;

public class Variable_Demo {
	
	int i=5;
	static int j=7;
	

	public static void main(String[] args) {
		int k=9;
		
		//if a non static variable and function/method, we have to call inside static function then we will create object first then will call variable with object
		Variable_Demo v=new Variable_Demo();
		System.out.println(v.i);
		v.createProfile();
		
		//if a static variable or local variable or static function we have to call inside another static function then can call directly i.e. without object
		System.out.println(j);
		
		System.out.println(k);
		
		viewProfile();
		
		

	}
	
	void createProfile() {
		System.out.println("profile created");
	}
	
	static void viewProfile() {
		System.out.println("profile viewed");
	}

}
