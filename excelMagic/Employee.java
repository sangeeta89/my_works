package excelMagic;

public class Employee {
	private String Empname,empId,empAddr;
	public Employee()
	{}
	

	public Employee(String Empname,String empId,String empAddr)
	{
		this.Empname=Empname;
		this.empId=empId;
		this.empAddr=empAddr;
				
	}
@Override
	public String toString()
	{
		return "Employee name: " +Empname+ ": Employee ID : "+empId+ "Employee Address: "+empAddr;
	}
}
