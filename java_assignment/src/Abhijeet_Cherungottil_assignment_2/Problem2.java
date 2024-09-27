package Abhijeet_Cherungottil_assignment_2;

/*
 * file: Problem2.java
 * author: Abhijeet Cherungottil
 * course: MSCS 504L-232
 * assignment: 2
 * 
 * This file contains the skeleton code of  
 * Problem 2.
 * 
 * Code perform Binary search method to find square root of given number
 */
public class Problem2 {

	public static int squareroot(int x)
	{
		// Given a positive integer x, return square root of x
		// If x is not a perfect square, return the floor of its square root
		// Complete the method squareroot() here
		// O(log n) time algorithm expected
		// Algorithms slower than O(logn) will be graded out of 10 points
		// Feel free to change the return type or parameters
		// Complete the method
		
		// Initialize mid = 0 and start as10 and end as x  and a remember as -1 to remember the index
		int start = 1;
		int end = x;
		int mid = 0;
		// To store the squuare root of value
		int store = 0;
		
		while(start <= end) {      //  -------------Log(n)
			mid = (start + end) / 2;
		
			if ((mid * mid) == x) {
				store = mid;
				break;
			} else if ((mid * mid) > x) {
				store = mid - 1;
				end = mid - 1 ;
			} else {
				store = mid;
				start = mid + 1 ;
			}
		}
		
		
		return store;
		
	}
	

	
	public static void main(String[] args) {
		// test your squareroot() method here
		
		int x1 = 9;
		int x2 = 5;
		int x3 = 17;
		System.out.println("The square root of " + x1 + " is " + squareroot(x1));
		// 3 expected
		System.out.println("The square root of " + x2 + " is " + squareroot(x2));
		// 2 expected
		System.out.println("The square root of " + x3 + " is " + squareroot(x3));
		// 4 expected
		
		// My test cases
		System.out.println("The square root of " + 49 + " is " + squareroot(49));
		// 4 expected
		
		System.out.println("The square root of " + 0 + " is " + squareroot(0));
		// 0 expected
		

		System.out.println("The square root of " + 9999 + " is " + squareroot(-25));
		// 0 expected

		
	}

}
