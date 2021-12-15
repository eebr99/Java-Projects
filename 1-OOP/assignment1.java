//Eric Blanco, Assignment 1, CS3354.001

//#1:
public class ReverseString {

	public static String reverse(String s) {
		char[] letters = new char[s.length()];
		
		int letterIndex = 0;
		for(int i = s.length() - 1; i >= 0; i--) {
			letters[letterIndex] = s.charAt(i);
			letterIndex++;
		}
		
		String reverse = "";
		for(int i = 0; i < s.length(); i++) {
			reverse = reverse + letters[i];
		}
		return reverse;
	}

}

public class driver {

	public static void main(String[] args) {
		//ReverseString r = new ReverseString();
		
		//1st test, positive, a simple word
		String r = "Orientation";
		System.out.println(ReverseString.reverse(r));
		
		//2nd test, positive, a simple sentence
		String s = "I am now reversed";
		System.out.println(ReverseString.reverse(s));
		
		//3rd test, negative, trying to reverse a number
		//double d = 1.22;
		//System.out.println(ReverseString.reverse(d));
		//^ commented out, if i try to do this, i get error
		//  because it reverses strings, not doubles.
	}

}
/*
Test Results:

noitatneirO
desrever won ma I

*/
//****************************************************************

//#2:
public class ConcatRev {

	public static String newRev(String s) {
		String even = "";
		String odd = "";
		
		for(int i = s.length() - 1; i >= 0; i--) {
			if(i % 2 == 1)
				odd += s.charAt(i);
			else
				even += s.charAt(i);
		}
		
		String joined = "";
		
		if(s.length() % 2 == 1)
			joined = even + odd;
		else
			joined = odd + even;
		
		return joined;
	}
}

public class driver {

	public static void main(String[] args) {
		//1st test, positive, just string of letters
		String letters = "abscacd";
		System.out.println(ConcatRev.newRev(letters));
		
		//2nd test, positive, now a sentence
		String sentence = "I will become new";
		System.out.println(ConcatRev.newRev(sentence));
		
		//3rd test, negative, now a line of ints
		//int numbers = 01234567;
		//System.out.println(ConcatRev.newRev(numbers));
		//^ fails because it only accepts strings, not ints
	}
}
/*
Test Results:

dasaccb
wneoe lwIe mcbli 

*/
//****************************************************************

//#3:
public class IntShift {

	public static void rightShift(int arr[], int m, int n) {
		while (m > n)
			m = m - n;
		
		int temp[] = new int[n - m];
		
		for (int i = 0; i < n - m; i++)
			temp[i] = arr[i];
		
		for (int i = n - m; i < n; i++)
			arr[i - n + m] = arr[i];
		
		for (int i = 0; i < n - m; i++)
			arr[i + m] = temp[i];
	}
}

public class driver {

	public static void main(String[] args) {
		//test 1, positive, simple int array
		int arr1[] = { 1, 2, 3, 4, 5};
		IntShift.rightShift(arr1, 3, arr1.length);
		for (int i = 0; i < arr1.length; i++)
			System.out.print(arr1[i] + " ");
		
		System.out.println("\n");
		
		//test 2, positive, array with more & larger ints
		int arr2[] = {1, 98, 654, 8875, 45213, 123546, 7895467, 75522113};
		IntShift.rightShift(arr2, 5, arr2.length);
		for (int i = 0; i < arr2.length; i++)
			System.out.print(arr2[i] + " ");
		
		//test 2, negative, array with a value too big
		//int arr3[] = { 5, 2, 12345678910};
		//IntShift.rightShift(arr3, 4, arr3.length);
		//for (int i = 0; i < arr3.length; i++)
		//	System.out.print(arr3[i] + " ");
		//^ the element is out of range, thus error
	}

}
/*
Test Results:

3 4 5 1 2 

8875 45213 123546 7895467 75522113 1 98 654 

*/
//****************************************************************

//#4:
public class NumberFind {

	static int findMissing(int a[], int n) {
		int sum = 1;
		for (int i = 2; i <= (n + 1); i++) {
			sum += i;
			sum -= a[i - 2];
		}
		return sum;
	}
}

public class driver {

	public static void main(String[] args) {
		//test 1, positive, ordered array 1-12, should be 8
		int[] arr1 = {1, 5, 6, 9, 7, 2, 3, 4, 12, 10, 11};
		System.out.println(NumberFind.findMissing(arr1, arr1.length));
		
		//test 2, positive, simple non-ordered array 1-6, should find 2
		int[] arr2 = { 5, 3, 1, 4, 6};
		System.out.println(NumberFind.findMissing(arr2, arr2.length));

		//test 3, negative, array ordered, but starting at 5 instead of 1,
		// going to 12. We get -24 as a result of the function used since 
		// we did not start at 1 like the problem says
		int[] arr3 = { 5, 6, 7, 9, 10, 11, 12};
		System.out.println(NumberFind.findMissing(arr3, arr3.length));
	}

}
/* 
Test Results:

8
2
-24

*/
