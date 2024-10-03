package Abhijeet_Cherungottil_assignment_3;

/*
 * file: Problem1.java
 * author: Abhijeet Cherungottil
 * course: MSCS 504L-232
 * assignment: 3
 * 
 * This file contains the skeleton code of  
 * Problem 1.
 * This fuction find largest elemnt in given array
 */
public class Problem1 {

	public static int largest(int[] A, int index, int n)
	{
		// Complete the method from here
		// Input: an array A[]
		// Output: the largest element in A[]
		// Full credits (30 points) will be awarded to a recursive methd without loop. A non-recursive method will be scored out of 10 points.
		// Feel free to change the function return type and the parameters
		if(n <= 0) {   // base case 1
			return 0;
			
		} else if (index == n - 1) {   // base case 2
			return A[index];
		} else {  // general case
			// find largest and return recursively 
			int temp = largest(A,index + 1,n);
			if (temp > A[index]){
				return temp;
			} else {
				return A[index];
			}
		}

	}
	
	public static void main(String[] args) {
		// Test your largest() method 
		int[] testarray = {12,25,36,85,28};
		System.out.println(largest(testarray,0,testarray.length));
		// 85 expected
		
		// My test cases
		int[] testarray1 = {12};
		System.out.println(largest(testarray1,0,testarray1.length));
		// 12 expected
		
		int[] testarray2 = {};
		System.out.println(largest(testarray2,0,testarray2.length));
		// 0 expected
		
		int[] testarray3 = {12,25,36,85,28,100};
		System.out.println(largest(testarray3,0,testarray3.length));
		// 100 expected
		
		int[] testarray4 = {200,12,25,36,85,28,100};
		System.out.println(largest(testarray4,0,testarray4.length));
		// 100 expected
		
		int[] testarray5 = {100,12,25,36,85,100,100};
		System.out.println(largest(testarray5,0,testarray5.length));
		// 100 expected


		
	}
	
}

