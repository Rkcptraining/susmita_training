package day4;

public class Static_Demo_for_Single_Class {
	
	void add() {
		System.out.println("i am non static add method");
	}
	
	static void sub() {
		System.out.println("i am static sub method");
	}

	public static void main(String[] args) {
		sub();
		
		Static_Demo_for_Single_Class ss=new Static_Demo_for_Single_Class();
		ss.add();

	}
	
	
	void mult() {
		add();
		sub();
	}

}
