package basics;
//Print index of array elements added ,tht equals to 9
public class Arr {
	
	public void method1() {
		int[] num= {2,7,3,4,5,9,0};
		int target=9;

		for(int i=0;i<num.length;i++) {
			int flag = 0;
			int index1 = 0, index2 =0;
			for (int j=i+1; j<num.length; j++) {
				if (num[i]+num[j]== target) {
					index1 = i;
					index2 = j;
					flag = 1;
					
				}
			}
			if (flag == 1) {
				
				System.out.println(index1+ "," + index2);
			}

		}
	}
	public void method2() {
		int[] num1= {3,3};
		int target1=6; int indexi1=0,indexi2=0;
		for(int i1=0;i1<num1.length;i1++) {
			int flag1=0;
			for(int j1=i1+1;j1<num1.length;j1++) {
				if(num1[i1]+num1[j1]==target1) {
					 indexi1=i1;
					 indexi2=j1;
					flag1=1;
				}
			}
			if(flag1==0) {
				System.out.println("("+indexi1+","+indexi2+")");
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Arr ob=new Arr();
//		ob.method1();
		ob.method2();
	}

}
