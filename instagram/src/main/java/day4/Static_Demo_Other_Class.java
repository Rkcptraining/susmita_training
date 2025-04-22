package day4;

public class Static_Demo_Other_Class {
	
	
	void div() {
		Static_Demo_for_Single_Class ss=new Static_Demo_for_Single_Class();
		ss.add();
		
		Static_Demo_for_Single_Class.sub();
	}

	public static void main(String[] args) {
		
		Static_Demo_for_Single_Class ss=new Static_Demo_for_Single_Class();
		ss.add();
		
		Static_Demo_for_Single_Class.sub();
	}

}
