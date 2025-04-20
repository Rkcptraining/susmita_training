package com.instagram;

import java.util.Scanner;

public class Table {

	public static void main(String[] args) {
		//Scanner class is use to take input from user
		Scanner sc=new Scanner(System.in);
		System.out.println("please enter your number");
		
		//if input is integer then scanner class object sc will read using nextInt() method
		//nextFloat is use to read decimal number
		//next() is use to read String value i.e. Susmita
		int i=sc.nextInt();
		
		for(int j=1;j<=10;j++) {
			System.out.println(i*j);
		}

	}

}
