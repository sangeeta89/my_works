package SimpleRestAssured;

public class javaOperators {
	
	public void widening() {
		int num=9;
		double mydb=num;
		
		//widening cast
		System.out.println("Double data type value after widened="+mydb);
		System.out.println("Integer value ="+num);

		//narrowing cast
	}
	public void narrowing() {
		double dub=10.9;
		int num1=(int)dub;
		System.out.println("integer value narrowed from double data type="+num1);
		System.out.println("double value dub="+dub);
	}
	
	public static void main(String[] args) {
			
		javaOperators jp=new javaOperators();
		jp.widening();
		jp.narrowing();
		
	}

}
