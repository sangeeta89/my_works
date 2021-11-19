package basics;

// Importing HashSet class from java.util package
import java.util.HashSet;
 
// Mai class
public class HasSet {
 
    // Main driver method
    public static void main(String[] args)
    {
 
        HashSet<String> hs = new HashSet<String>();
        // Adding elements to the HashSet
        hs.add("geeks");
        hs.add("continue");
        hs.add("geeks");
        ;
 

        // Addition of null values
//        hs.add(null);

 
        // Displaying HashSet elements
        System.out.println("\nAfter adding all values \n\n"
                           + hs);
    }
}