package basics;

class ParentClass {
	static int result=0;
	public void overlap(int a, int b) {
		int result=a+b;
		System.out.println("Parent class"+result);
		
	}
	
}
public class Inheritance extends ParentClass{
	public void overlap(int a,int b) {
		result=a-b;
		System.out.println("Child overrides "+result);
	}
	
	public static void main(String[] args) {
		
		Inheritance in=new Inheritance();
		in.overlap(10,2);
		

	}

}
