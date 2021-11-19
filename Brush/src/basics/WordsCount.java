package basics;

import java.util.Scanner;

public class WordsCount {
	void count() {
		int count=1;
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter string: ");
		String str=sc.nextLine();
		System.out.println(str.length());
		
		char[] ch=str.toCharArray();
		
		for (int i=0;i<str.length();i++) {
			ch[i]=str.charAt(i);
			
			if((ch[i]==' ' && ch[i-1]!=' ') ||(i==str.length()))
			{  
				count=count+1;
			}
		}
		System.out.println("Words count for string '"+str+"' = "+count);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordsCount wc=new WordsCount();
		wc.count();
	}

}
