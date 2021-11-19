package basics;

import java.util.Scanner;

public class StringPalindrome {
	
	public void stringPalin() {
		
		System.out.println("Provide input string: ");
		
		@SuppressWarnings("resource")
		String str=new Scanner(System.in).nextLine();
		str=str.toUpperCase();
		boolean flag=true;
		for(int i=0;i<str.length()/2;i++) {
			if(str.charAt(i)!=str.charAt(str.length()-i-1))
			{
				flag=false;
				break;
			}
		}
		if(flag)
			System.out.println(str+" is a palindrome string");
		else
			System.out.println(str+" is not palindrome string");
	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StringPalindrome obj=new StringPalindrome();
		obj.stringPalin();
	}

}
