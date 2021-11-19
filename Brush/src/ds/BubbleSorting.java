package ds;

import java.util.Arrays;

class BubbleSorting {

	public void arraysort() {
		
		int arr[]= {16,9,5,2,4,1};
		int n=arr.length;
	//loop index 0 to length
		for(int i=0;i<n;i++) {
			int flag=0;//flag for indicating swap
			for(int j=0;j<n-1-i;j++) //loop to compare each ith element j times till ith length 
			{
				if(arr[j] > arr[j+1]) { //compare a[j] with next element if 1st element > 2nd element then
					int temp=arr[j];  // swap the position of element
					arr[j]=arr[j+1];  
					arr[j+1]=temp;
					flag=1; //if element swapped then flag=1
					
					
				}//end of if loop

			}//end of j loop
			if(flag==0) {//if not swapped flag=0 then break the loop
				break;
			}
			
		}//end of i loop
		System.out.println("Sorted array using insertion sorting algo:"+Arrays.toString(arr));

	}


	
	public void stringsort() {
		String str[]= {"Sangeeta","Zeenat","Pulak","Anjana","Gilgit","Pijush"};
		String temp;
		System.out.println("Strings sorted in bubble sort algo: ");
		
		for(int x=0; x<str.length; x++) {
			for(int y=x+1;y<str.length;y++) {
				if(str[x].compareTo(str[y])> 0) {
					temp=str[x];
					str[x]=str[y];
					str[y]=temp;			
					}
				
			}
			System.out.print(str[x]+"\t");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BubbleSorting obj=new BubbleSorting();
		obj.stringsort();
		obj.arraysort();
	
}
}