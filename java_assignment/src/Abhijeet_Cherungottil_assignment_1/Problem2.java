package Abhijeet_Cherungottil_assignment_1;

/*
 * file: Problem2.java
 * author: Abhijeet Cherungottil
 * course: MSCS 504L-232
 * assignment: 1
 * Due Date: 09/04/2024
 * 
 * This file contains the skeleton code of  
 * Problem 2.
 * This file contain code to find missing element from set A and test different scenario
 * 
 */
public class Problem2 {

	
	public static int missingnumber(int[] A, int B[]) // -----O(n)
	{
		/*
		* Input: There is an array A[] that consists of n integers and 
		* these integers are not in any particular order. There 
		* are no duplicates in A[]. There is another array B[] 
		* that contains the same set of elements as A[], but one 
		* element is missing.
		* Output: Find the missing integer.
		*/
		
		// Complete this method
		
		// Initialize xorSumA and xorSumB as 0
		int xorSumOfA = 0;
		int xorSumOfB = 0;
		
		for(int i = 0; i< A.length; i++) { // -------- O(n)
			// Xor-ing all elements of A
			xorSumOfA = xorSumOfA ^ A[i];
		}
		
		
		for(int j = 0; j< B.length; j++) { // --------- O(n)
			// Xor-ing all elements of B
			xorSumOfB = xorSumOfB ^ B[j];
		}
		
		// Xor-ing elements of a and B to find missing element
		// Property used: A xor B xor C = B xor C xor A = C xor A xor B
		// A xor A = 0
		// So all the common elements get cancelled with each other 
		//and only 1 uncommon element will be remaining 
		return xorSumOfA ^ xorSumOfB;
		
	}
	
	
	
	
	
	public static void main(String[] args) {
	
		// Test case 1
		
		int[] testarray1 = {5, 7, 10, 9, 23, 1, 13, 100};
		
		int[] testarray2 = {100, 7, 5, 13, 1, 9, 10};
		
		System.out.println("The missing number in testarray2 "+ missingnumber(testarray1, testarray2));
		// Expected output: 23
		
		// My test cases
		
        int[] testarray3 = {5};
		
		int[] testarray4 = {};
		
		System.out.println("The missing number in testarray4 "+ missingnumber(testarray3, testarray4));
		// Expected output: 5
		
		 int[] testarray5 = {};
		 int[] testarray6 = {};
		 System.out.println("The missing number in testarray6 "+ missingnumber(testarray5, testarray6));
		// Expected output: 0
		
		
	}

}
