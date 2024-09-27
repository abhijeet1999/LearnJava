package Abhijeet_Cherungottil_assignment_2;

/*
 * file: Problem1.java
 * author: Abhijeet Cherungottil
 * course: MSCS 504L-232
 * assignment: 2
 * 
 * This file contains the skeleton code of  
 * Problem 1.
 */
public class Problem1 {

	public static int count(double[] A, double x)
	{
		// Given a sorted array A[], and a value x, 
		// return the number of times x occurs in A[]
		// Complete the method count() here
		// O(log n) time algorithm expected
		// Algorithms slower than O(logn) will be graded out of 10 points
		// Feel free to change the return type or parameters
		// Complete the method
		
		
		// Initialize mid, start,intialOccurance and finalOccurance as 0 and end as length -1 
		// and a 'remember' as 0 to remember the index
	
		int start = 0;
		int end = A.length -1;
		int mid = 0;
		int remember = 0;
		int intialOccurance = 0;
		int finalOccurance = 0;
		
		
		if(A.length <= 0 ) {
			return 0;
		}
		
	
		// Find index where 1st occurrence of mid is equal to x
		while (start <= end) {
			mid = (start + end) /2;
			if(A[mid] == x) {
				remember = mid;
				end = mid -1;
		
			} else if (x > A[mid]) { 
				start  = mid + 1;
			} else {
				end = mid -1;
			}
			
		}
		
		// setting intialOccurance index using remember
		intialOccurance = remember;
		
		// reseting the value
		remember = 0;
		start = 0;
		end = A.length -1;
		
		// Find index where last occurrence of mid is equal to x
		while (start <= end) {
			mid = (start + end) /2;
			
			if(A[mid] == x) {
				remember = mid;
				start = start  + 1;
				
			} else if (x < A[mid]) {
				end  = mid - 1;
			} else {
				start = start  + 1;
			}
			
		}
		// setting finalOccurance index using remember
		finalOccurance = remember;
		
		// count of occurrence is finalOccurance index - intialOccurance index  + 1 since its starts from 0
		return finalOccurance - intialOccurance + 1;
		
		
	}
	

	
	public static void main(String[] args) {
		// test your count() method here
		
		double[] testarray = {1.3, 2.1, 2.1, 2.1, 2.1, 6.7, 7.5, 7.5, 8.6, 9.0};
		double t1 = 2.1;
		double t2 = 7.5;
		double t3 = 1.3;
		System.out.println(t1+" appears "+ count(testarray, t1) + " times");
		// 4 expected
		System.out.println(t2+" appears "+ count(testarray, t2) + " times");
		// 2 expected 
		System.out.println(t3+" appears "+ count(testarray, t3) + " times");
		// 1 expected
		
		// My test cases
		
		double[] testarray1 = {2.1, 2.1, 2.1, 2.1, 2.1,2.1,2.1,2.1};
		System.out.println(t1+" appears "+ count(testarray1, t1) + " times");
		// 8 expected
		
		double[] testarray2 = {};
		System.out.println(t1+" appears "+ count(testarray2, t1) + " times");
		// 0 expected
		
		
	}

}