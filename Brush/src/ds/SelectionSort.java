package ds;

import java.util.Arrays;

public class SelectionSort {
	int a[]= {19,3,1,8,4};
	
	void sort() {
		
		for(int i=0;i<a.length;i++) 
		{
			int low = i;
			for(int j=i+1;j<a.length;j++) {
				if(a[j]<a[low])
				{
					low=j;
				}
				
			}
//			if (low >= 0) {
			int temp=a[i];
			a[i]=a[low];
			a[low]=temp;
				
//				}
		}
		
			System.out.println(Arrays.toString(a));
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SelectionSort ss=new SelectionSort();
		ss.sort();
	}

}
