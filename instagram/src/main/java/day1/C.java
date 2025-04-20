package day1;

public class C extends A{

	public static void main(String[] args) {
		A a=new A();
		System.out.println("default property "+a.i);
		System.out.println("private property "+a.j);
		System.out.println("protected property "+a.k);
		System.out.println("public property "+a.m);

	}

}
