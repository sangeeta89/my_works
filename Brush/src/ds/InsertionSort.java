package ds;

import java.util.Arrays;

public class InsertionSort {

	void sort() {
		int a[]= {77,100,1,20};
		int temp=0;
		//loop from 2nd element till < length, leaving 1st element as sorted list element
		for(int i=1;i<a.length;i++) {
			temp=a[i]; //store a[i]th element in temp var
			int j=i-1; //j= left side element i.e if i=1, j=i-1=0
			
			while(j>=0 && a[j]>temp) {// compare jth index >=0(1st index) and a[j]> tempi.e a[j]>a[i] 
				a[j+1]=a[j]; //swap by shifting the jth element to (j+1)th element
				j--; //decrement j to compare with left element
			}
			a[j+1]=temp; // store  (j+1)th element is temp from line 16 after shifting
		}
		System.out.println("Sorted array using insertion sorting algo:"+Arrays.toString(a));
	}
	public static void main(String[] args) {
		
		InsertionSort is=new InsertionSort();
		is.sort();
	}

}
