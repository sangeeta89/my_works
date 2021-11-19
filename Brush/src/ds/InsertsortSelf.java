package ds;

import java.util.Arrays;

public class InsertsortSelf {
	void sorting() {
		 int a[]= {99,100,9,7,4};
		 
		
		for(int i=1;i<a.length;i++) {
				int temp=a[i];
			for(int j=i-1;j>=0;j--) {
				
				if(temp < a[j]) 
				{
					int x=a[j];
					a[j]=temp;
					
					a[j+1]=x;
				}
			}
			
		}	
		
		System.out.println("Sorted array using insertion algorithm"+Arrays.toString(a));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		InsertsortSelf ob=new InsertsortSelf();
		ob.sorting();

}
}
