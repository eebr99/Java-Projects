//Eric Blanco, Assignment 3, CS3354.001

//#1:
public class Complex { // class for complex
	private double real,imaginary;
	  
	   public Complex(double r , double i) {
	       real = r;
	       imaginary = i;
	   }
	   public void setReal(double r) {
	       real = r;
	   }
	   public void setImag(double i) {
	       imaginary = i;
	   }
	   public double getReal() {
	       return real;
	   }
	   public double getImag() {
	       return imaginary;
	   }
	   public String toString() {
	       return real + " + "+imaginary+ "i\n";
	   }
}

public class Quadratic { //class for quadratic
	
	private double a,b,c;
	  
	   public Quadratic(double a,double b,double c) {
	       this.a = a;
	       this.b = b;
	       this.c = c;
	   }
	   public double discriminant() {
	       return b*b - 4*a*c;
	   }
	  
	   public Complex getRoot1() {
	       double D = discriminant();
	       double real,imaginary;
	       if(D<0) {
	           real = (b*-1)/(2*a);
	           imaginary = Math.sqrt(D*-1)/(2*a);
	           return new Complex(real,imaginary);
	          
	       }
	       real = (b*-1 + Math.sqrt(D))/(2*a);
	       return new Complex(real,0);
	   }
	  
	   public Complex getRoot2() {
	       double D = discriminant();
	       double real,imaginary;
	       if(D<0) {
	           real = (b*-1)/(2*a);
	           imaginary = Math.sqrt(D*-1)/(2*a);
	           return new Complex(real,imaginary);
	          
	       }
	       real = (b*-1 - Math.sqrt(D))/(2*a);
	       return new Complex(real,0);
	   }
}

import java.util.Scanner;

public class driver {

	public static void main(String[] args) {

		Scanner n = new Scanner(System.in);
		 Quadratic q;
	       double a,b,c;
	       System.out.print("Enter a : ");
	       a = n.nextDouble();
	      
	       System.out.print("Enter b : ");
	       b = n.nextDouble();
	      
	       System.out.print("Enter c : ");
	       c = n.nextDouble();
	      
	       q = new Quadratic(a,b,c);
	      
	       System.out.print("Root 1 : "+ q.getRoot1());
	       System.out.print("Root 2 : "+ q.getRoot2());
	      
	       n.close();
	}

}
/*
Test Results:

Enter a : 1
Enter b : 3
Enter c : -18
Root 1 : 3.0 + 0.0i
Root 2 : -6.0 + 0.0i 

Enter a : 2.2
Enter b : 2.3
Enter c : 2.5
Root 1 : -0.5227272727272726 + 0.9290424289077135i
Root 2 : -0.5227272727272726 + 0.9290424289077135i 

Enter a : dog
Exception in thread "main" java.util.InputMismatchException
	at java.base/java.util.Scanner.throwFor(Scanner.java:939)
	at java.base/java.util.Scanner.next(Scanner.java:1594)
	at java.base/java.util.Scanner.nextDouble(Scanner.java:2564)
	at a3q1/a3q1.driver.main(driver.java:12)

*/
//****************************************************************

//#2:
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PoirotString {
	
	public static String isValid(String s) {
		
		Map<Character, Integer> freqMapChar = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int frequency = freqMapChar.getOrDefault(c, 0);
			freqMapChar.put(c, ++frequency);
		}
		
		int[] arr = new int[freqMapChar.size()];
		int index = 0;
		for(Map.Entry<Character, Integer> charIntEntry: freqMapChar.entrySet())
			arr[index++] = charIntEntry.getValue();
		Arrays.sort(arr);
		
		if (freqMapChar.size() == 1) return "Yes";
		
		int first = arr[0], second = arr[1], 
				secondLast = arr[arr.length - 2],
				last = arr[arr.length - 1];
		
		if (first == last) return "Yes";
		if (first == 1 && second == last) return "Yes";
		if (first == second && second == secondLast && secondLast == (last - 1))
			return "Yes";
		
		return "No";
			
	}
}

import java.util.Scanner;

public class driver {

	public static void main(String[] args) {
		
		System.out.println("Your string is valid if all chars appear the same amount.");
		
		Scanner n = new Scanner(System.in);
		String s = "";
		
		System.out.print("\nEnter a string: ");
		s = n.next();
		
		if (PoirotString.isValid(s) == "Yes")
			System.out.println("Your string is valid.");
		else
			System.out.println("Your string is not valid.");
		
		n.close();
	}
}
/*
Test Results:

Your string is valid if all chars appear the same amount.
Enter a string: qqqwwweee
Your string is valid.

Your string is valid if all chars appear the same amount.
Enter a string: ttjjjoo
Your string is valid.

Your string is valid if all chars appear the same amount.
Enter a string: sssdddfeer
Your string is not valid.

Your string is valid if all chars appear the same amount.
Enter a string: 
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 0 out of bounds for length 0
	at a3q2/a3q2.PoirotString.isValid(PoirotString.java:26)
	at a3q2/a3q2.driver.main(driver.java:15)

*/
//****************************************************************

//#3:
import java.util.Arrays;

public class TwoStrings {
	
	static int MAX_CHAR = 26; //# letters in the alphabet
	
	public static boolean sameSub(String s1, String s2) {
		//for storing char occurrences
		boolean v[] = new boolean[MAX_CHAR];
		Arrays.fill(v, false);
		
		for (int i = 0; i < s1.length(); i++)
			v[s1.charAt(i) - 'a'] = true;
		
		//check common substring
		for (int i = 0; i < s1.length(); i++)
			if(v[s2.charAt(i) - 'a'])
				return true; //common found
		
		return false; //no common substring
	}
}

import java.util.Scanner;

public class driver {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str1 = "", str2 = "";
		
		System.out.print("Enter a string: ");
		str1 = sc.nextLine();
		
		System.out.print("Enter another string: ");
		str2 = sc.nextLine();
		
		if (TwoStrings.sameSub(str1, str2))
			System.out.println("The strings share substrings.");
		else
			System.out.println("The strings do not share substrings.");
		
		sc.close();
	}
}
/*
Test Results:

Enter a string: cat
Enter another string: dog
The strings do not share substrings.

Enter a string: metal
Enter another string: gear
The strings share substrings.

Enter a string: 45
Enter another string: 65
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index -45 out of bounds for length 26
	at a3q3/a3q3.TwoStrings.sameSub(TwoStrings.java:15)
	at a3q3/a3q3.driver.main(driver.java:17)
*/
//****************************************************************