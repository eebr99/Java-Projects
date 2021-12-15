//Eric Blanco, Assignment 2, CS3354.001

//#1:
import java.util.ArrayList;

public class TwinNum {
	
	static boolean findTwin(int arr[], int size) {
		boolean present = false;
		
		ArrayList<Integer> al = new ArrayList<Integer>();
		
		for (int i = 0; i < size - 1; i++) {
			for (int j = i + 1; j < size; j++) {
				if (arr[i] == arr[j]) {
					if (al.contains(arr[i]))
						break;
					else {
						al.add(arr[i]);
						present = true;
					}
				}
			}
		}
		
		if (present == true)
			System.out.print("Duplicates are: " + al + " ");
		else
			System.out.print("There are no duplicates");
		
		return present;
	}
}

import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class driver {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		
		System.out.print("enter preffered size of array: ");
		int size = sc.nextInt();
		int arr[] = new int[size];
		for (int i = 0; i < arr.length; i++)
			arr[i] = rand.nextInt(10); //specified a range of 0-9
		
		System.out.println(Arrays.toString(arr));
		TwinNum.findTwin(arr, size);
	}

}
/*
Test Results:

enter preffered size of array: 10
[5, 2, 0, 6, 4, 0, 6, 9, 6, 5]
Duplicates are: [5, 0, 6] 

enter preffered size of array: 3
[2, 1, 8]
There are no duplicates 

enter preffered size of array: cat
Exception in thread "main" java.util.InputMismatchException
	at java.base/java.util.Scanner.throwFor(Scanner.java:939)
	at java.base/java.util.Scanner.next(Scanner.java:1594)
	at java.base/java.util.Scanner.nextInt(Scanner.java:2258)
	at java.base/java.util.Scanner.nextInt(Scanner.java:2212)
	at a2q1/a2q1.driver.main(driver.java:16)

*/
//****************************************************************

//#2:
public class MaxAndMin {
	
	public static int min (int [] arr) {
		int min = arr[0];
		
		for(int i = 0; i < arr.length; i++)
			if (arr[i] < min)
				min = arr[i];
		
		return min;
	}
	
	public static int max (int [] arr) {
		int max = 0;
		
		for (int i = 0; i < arr.length; i++)
			if(arr[i] > max)
				max = arr[i];
		
		return max;
	}
}

import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class driver {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		
		System.out.print("enter preffered size of array: ");
		int size = sc.nextInt();
		int arr[] = new int[size];
		for (int i = 0; i < arr.length; i++)
			arr[i] = rand.nextInt(21); //specified a range of 0-20
		
		System.out.println(Arrays.toString(arr));
		System.out.println("min value = " + MaxAndMin.min(arr));
		System.out.println("max value = " + MaxAndMin.max(arr));
	}

}
/*
Test Results:

enter preffered size of array: 8
[5, 17, 1, 9, 12, 19, 7, 2]
min value = 1
max value = 19

enter preffered size of array: 16
[20, 20, 19, 15, 14, 10, 11, 7, 2, 6, 2, 11, 7, 20, 11, 13]
min value = 2
max value = 20

enter preffered size of array: 7.56
Exception in thread "main" java.util.InputMismatchException
	at java.base/java.util.Scanner.throwFor(Scanner.java:939)
	at java.base/java.util.Scanner.next(Scanner.java:1594)
	at java.base/java.util.Scanner.nextInt(Scanner.java:2258)
	at java.base/java.util.Scanner.nextInt(Scanner.java:2212)
	at a2q2/a2q2.driver.main(driver.java:16)
	
*/
//****************************************************************

//#3:
public class MaxProduct {
	
	public static void productOfMax(int[] arr) {
		int maxProduct = Integer.MIN_VALUE;
		int maxI = -1, maxJ = -1;
		
		for (int i = 0; i < arr.length - 1; i++)
			for (int j = i + 1; j < arr.length; j++)
				if (maxProduct < arr[i] * arr[j]) {
					maxProduct = arr[i] * arr[j];
					maxI = i;
					maxJ = j;
				}
		System.out.println("The max pair from the array is (" + 
				arr[maxI] + ", " + arr[maxJ] + ")");
		System.out.println("The maximum possible product is " + 
				(arr[maxI] * arr[maxJ]));
	}
}

import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class driver {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		
		System.out.print("enter preffered size of array: ");
		int size = sc.nextInt();
		int arr[] = new int[size];
		for (int i = 0; i < arr.length; i++)
			arr[i] = rand.nextInt(31); //specified a range of 0-30
		
		System.out.println(Arrays.toString(arr));
		MaxProduct.productOfMax(arr);

	}
}
/*
Test Results:

enter preffered size of array: 11
[11, 4, 0, 20, 29, 1, 15, 13, 14, 8, 14]
The max pair from the array is (20, 29)
The maximum possible product is 580

enter preffered size of array: 21
[8, 23, 24, 25, 30, 19, 30, 27, 17, 30, 14, 17, 18, 23, 14, 2, 22, 29, 1, 9, 4]
The max pair from the array is (30, 30)
The maximum possible product is 900

enter preffered size of array: -5
Exception in thread "main" java.lang.NegativeArraySizeException: -5
	at a2q3/a2q3.driver.main(driver.java:17)
	
*/
//****************************************************************

//#4:
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
public class FileInfo {
	
	public static void collectInfo(String filename) throws IOException {
		File file = new File(filename);
		
		Path filepath = Paths.get(filename);
		BasicFileAttributes attr = 
				Files.readAttributes(filepath, BasicFileAttributes.class);
		
		
		System.out.println("File size :" + file.length());
		System.out.println("created: " + attr.creationTime());
		System.out.println("modified: " + attr.lastModifiedTime());
		if(filename.contains(".txt"))
			System.out.println(filename + " is a text file.");
		else
			System.out.println(filename + " is binary file. ");
	}

}

import java.io.IOException;
import java.util.Scanner;

public class driver {

	public static void main(String[] args) throws IOException {
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);
		System.out.print("Enter a file name: ");
		String filename = reader.next();
		
		FileInfo.collectInfo(filename);
	}

}
/*
Test Results:

Enter a file name: D:\test2.txt
File size :189
created: 2021-10-15T19:34:47.7465533Z
modified: 2021-10-15T19:47:41.673195Z
D:\test2.txt is a text file.

Enter a file name: D:\picture.jpg
File size :92245
created: 2021-10-15T20:33:07.7064747Z
modified: 2021-09-04T08:51:34.8355801Z
D:\picture.jpg is binary file. 

Enter a file name: 100
Exception in thread "main" java.nio.file.NoSuchFileException: 100
	at java.base/sun.nio.fs.WindowsException.translateToIOException(WindowsException.java:85)
	at java.base/sun.nio.fs.WindowsException.rethrowAsIOException(WindowsException.java:103)
	at java.base/sun.nio.fs.WindowsException.rethrowAsIOException(WindowsException.java:108)
	at java.base/sun.nio.fs.WindowsFileAttributeViews$Basic.readAttributes(WindowsFileAttributeViews.java:53)
	at java.base/sun.nio.fs.WindowsFileAttributeViews$Basic.readAttributes(WindowsFileAttributeViews.java:38)
	at java.base/sun.nio.fs.WindowsFileSystemProvider.readAttributes(WindowsFileSystemProvider.java:199)
	at java.base/java.nio.file.Files.readAttributes(Files.java:1843)
	at a2q4/a2q4.FileInfo.collectInfo(FileInfo.java:18)
	at a2q4/a2q4.driver.main(driver.java:12)
	
*/
//****************************************************************

//#5:
import java.util.Random;

public class Matrix {
	
	public static int [][] createMatrix(int m, int n) {
		
		Random rand = new Random();
		int[][] matrix = new int[m][n];
		
		for(int i = 0; i < m; i++)
			for(int j = 0; j < n; j++)
				matrix[i][j] = rand.nextInt(11); //range to 10 for easy check of operations
		
		return matrix;
	}
	
	public static void printMatrix (int[][] matrix) {
		for (int r = 0; r < matrix.length; r++) {
			for (int c = 0; c < matrix[r].length; c++)
				System.out.print(matrix[r][c] + " ");
		
			System.out.println();
		}
		
	}
	
	public static int[][] matrixSum (int A[][], int B[][], int r, int c){
		
		int i, j;
		int C[][] = new int[r][c];
		
		for (i = 0; i < r; i++)
			for (j = 0; j < c; j++)
				C[i][j] = A[i][j] + B[i][j];
		
		return C;
	}
	
public static int[][] matrixProduct (int A[][], int B[][], int r1, int c2, int r2){
		
		int i, j;
		int C[][] = new int[r1][c2];
		
		for (i = 0; i < r1; i++) {
			for (j = 0; j < c2; j++) {
				for(int k = 0; k < r2; k++)
					C[i][j] += A[i][k] * B[k][j];
			}
		}
		return C;
	}
}

import java.util.Scanner;

public class driver {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//matrix A:
		System.out.print("Enter the number of rows for matrix A:");
		int rowA = sc.nextInt();
		System.out.print("Enter the number of columns for matrix A:");
		int columnA = sc.nextInt();
		int [][] matrixA = Matrix.createMatrix(rowA, columnA); 
		System.out.println("\nMatrix A: ");
		Matrix.printMatrix(matrixA);
		
		//matrix b:
		System.out.print("\nEnter the number of rows for matrix B:");
		int rowB = sc.nextInt();
		System.out.print("Enter the number of columns for matrix B:");
		int columnB = sc.nextInt();
		int [][] matrixB = Matrix.createMatrix(rowB, columnB); 
		System.out.println("\nMatrix B: ");
		Matrix.printMatrix(matrixB);
		
		// A & B addition:
		if(rowA == rowB && columnA == columnB) {
			int [][] matrixABSum = Matrix.matrixSum(matrixA, matrixB, rowA, columnA); 
			System.out.println("\nMatrix A & B sum: ");
			Matrix.printMatrix(matrixABSum);
		}
		else
			System.out.println("\nAddition not possible.");
		
		//A & B multiplication:
		if(columnA == rowB) {
			int[][] matrixABProduct = Matrix.matrixProduct(matrixA, matrixB, rowA, columnB, rowB);
			System.out.println("\nMatrix A & B product: ");
			Matrix.printMatrix(matrixABProduct);
		}
		else
			System.out.println("\nMultiplication not possible.");
	}

}
/*
Test Results:

Enter the number of rows for matrix A:2
Enter the number of columns for matrix A:3

Matrix A: 
5 7 7 
5 7 3 

Enter the number of rows for matrix B:2
Enter the number of columns for matrix B:3

Matrix B: 
10 4 8 
5 8 5 

Matrix A & B sum: 
15 11 15 
10 15 8 

Multiplication not possible.


Enter the number of rows for matrix A:2
Enter the number of columns for matrix A:3

Matrix A: 
6 5 4 
8 4 0 

Enter the number of rows for matrix B:3
Enter the number of columns for matrix B:2

Matrix B: 
9 5 
3 4 
9 7 

Addition not possible.

Matrix A & B product: 
105 78 
84 56 
 

Enter the number of rows for matrix A:g
Exception in thread "main" java.util.InputMismatchException
	at java.base/java.util.Scanner.throwFor(Scanner.java:939)
	at java.base/java.util.Scanner.next(Scanner.java:1594)
	at java.base/java.util.Scanner.nextInt(Scanner.java:2258)
	at java.base/java.util.Scanner.nextInt(Scanner.java:2212)
	at a2q5/a2q5.driver.main(driver.java:13)
	
*/