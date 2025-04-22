package day4;

class ChildClass extends ParentClass{
	
	void add(int i, float j) {
		System.out.println(i*9+j);
	}

	public static void main(String[] args) {
		ChildClass cc=new ChildClass();
		cc.add(3, 3.3f); //here it will call child add method because it will override parent add method

	}

}
