package com.instagram.day3;

public class Typecasting_Demo {

	public static void main(String[] args) {
		long l=10;
				
		//explicit type casting
		//smaller <-- larger
		//int  <---   long
		  int i = (int)l*5;
		  System.out.println("explicit result "+i);
		  
		  int i1=10;
		//implicit type casting
		//larger <-- smaller
		//long  <---   int
		  
		  long l1 =   i1*7;
		  System.out.println("implicit result "+l1);

	}

}
