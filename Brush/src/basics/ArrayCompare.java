package basics;

public class ArrayCompare {
	
//Print index of the sum of two elements value equals 9
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a[]= {3, 5, 4, 0, 9, 7, 2};
		int index1=0,index2=0, target=9;
		
		for(int i=0;i<a.length;i++) {
//			index1=i;
			for(int j=i;j<a.length-1;j++)
			{	if(a[j]+a[j+1]==target) 
					index2=j;
					index1=i;
					
			}
			System.out.println("Indexes are: ("+index1+","+index2+")");	
		}
		}
}
