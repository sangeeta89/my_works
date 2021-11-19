package basics;
import java.util.HashMap;

public class HashMapEx {

	public static void main(String[] args)
	{

		// This is how to declare HashMap
		HashMap<Integer, String> hm = new HashMap<Integer, String>();

		// Adding elements to HashMap*/
		hm.put(1, "geeks");
		hm.put(2, "continue");
		hm.put(1, "geeks");

//		System.out.println("\nHashMap object output :\n\n" + hm);

		// store data with null key and null value
		hm.put(3, null);
		hm.put(null, "Null");

		System.out.println("\nAdding all :\n\n" + hm);
	}
}
