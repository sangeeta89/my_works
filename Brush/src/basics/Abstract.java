package basics;

abstract class Automation {
	public void method() {
		System.out.println("Resource has automation skills");
	}
}
class Account extends Automation{
		public void utilisation() {
			System.out.println("Resource profile must be updated in ADP pool");
		}
	}
	
	
	public class Abstract{
		
	public static void main(String[] args) {

		Account myObj=new Account();
		myObj.utilisation();
		myObj.method();
		

	}

}
