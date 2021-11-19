package basics;

public class SmallestElementIndex {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a[]= {56, 100, 8, 4, 1};
		int index=0;
		
		for(int i=1;i<a.length;i++) {
			 
			if(a[i]< a[index]) {
				
				index=i;
			}
		}
		System.out.print("index is "+index+" for element "+a[index]);
	}

}
