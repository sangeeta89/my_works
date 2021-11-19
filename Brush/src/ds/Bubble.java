package ds;

import java.util.Arrays;

public class Bubble {
	
	public void sort() {
		int arr[]= {89,1,30,20, 17};
		for(int i=0;i<arr.length;i++) {
			int j=0;
			while(j<arr.length-1-i)
			{
				if(arr[j] > arr[j+1]){
					int temp=arr[j+1];
					arr[j+1]=arr[j];
					arr[j]=temp;
					
					
				}
				j++;
			}
		}
		System.out.println(Arrays.toString(arr));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bubble bo=new Bubble();
		bo.sort();
	}

}
