package Abhijeet_Cherungottil_assignment_2;

/*
 * file: Problem3.java
 * author: Abhijeet Cherungottil
 * course: MSCS 504L-232
 * assignment: 2
 * 
 * This file contains the skeleton code of  
 * Problem 3.
 * 
 *To find index of element in the range
 */

class Subrange
{
	public int index_L;
	
	public int index_R;
	
}


public class Problem3 {

	public static Subrange findNumsWithin(int[] A, int lower, int upper) //   O(logn)
	{
		/* Input: A sorted (from smallest to largest) array A[] of n integers, and two integers: upper and lower. 
		Output: 
		The subrange of A[] that contains all values v such that lower ≤ v ≤ upper.
		That is, output a pair of indices: (index_L, index_R) such that
		lower ≤ A[index_L] ≤ A[index_R] ≤ upper
		If no such range exists, return (-1, -1). 
		*/
		// O(log(n)) time algorithm expected 
		// Feel free to change the return type or parameters
		
		Subrange r = new Subrange();
		// Complete the method
		
		// Initialize left and right of range of index as -1 
		r.index_L = -1;
		r.index_R = -1;
		
		// Initialize mid and start as 0 and end as length -1  and a remember as -1 to remember the index
		int mid = 0;
		int start = 0;
		int end = A.length -1;
		int remember = -1;
	
		// Find index where 1st occurrence of mid being equal or higher than 'lower'
		while(start <= end) {    //    ---------------- O(logn)
			mid = (start + end)/2;
			if(A[mid] >= lower) {
				remember = mid;
				end = mid -1;
			} else {
				start = mid + 1;
			}
			
		}
		// Set remember to left index and reset the start,end and remember
		r.index_L = remember;
		remember = -1;
		start = 0;
		end = A.length -1;
		
		// Find index where 1st occurrence of mid being equal or lower than 'upper'
		while(start <= end) {  //    ---------------- O(logn)
			mid = (start + end)/2;
			if(A[mid] <= upper) {
				remember = mid;
				start = mid + 1;
			} else {
				end = mid - 1;
			}
			
		} 
		
		// if there is no lower limit set right as -1 otherwise set the index in remember
		if (r.index_L == - 1 ){
			r.index_R = -1;
		} else {
			r.index_R = remember; 		
		}
		
		return r;
		
	}
	
	
	

	
	public static void main(String[] args) {
		// test your findNumsWithin() method here
		
		int[] testarray = {0, 1, 3, 5, 6, 8};
		int lower = 2;
		int upper = 6;
		
		Subrange range = new Subrange();
		range = findNumsWithin(testarray, lower, upper);		

		System.out.println("There exists a subrange of elements in the input array >= "+ lower + " and <= "+ upper + " : from index: "+ range.index_L + " to index: " + range.index_R);
		// (2(index_L), 4(index_R)) expected
		
		// My test cases
		
		int[] testarray1 = {0, 1, 3, 5, 6, 8};
		int lower1 = 8;
		int upper1 = 9;
		
		Subrange range1 = new Subrange();
		range1 = findNumsWithin(testarray1, lower1, upper1);		

		System.out.println("There exists a subrange of elements in the input array >= "+ lower1 + " and <= "+ upper1 + " : from index: "+ range1.index_L + " to index: " + range1.index_R);
		// (5(index_L), 5(index_R)) expected

		int[] testarray2 = {0, 1, 3, 5, 6, 8};
		int lower2 = 10;
		int upper2 = 12;
		
		Subrange range2 = new Subrange();
		range2 = findNumsWithin(testarray2, lower2, upper2);		

		System.out.println("There exists a subrange of elements in the input array >= "+ lower2 + " and <= "+ upper2 + " : from index: "+ range2.index_L + " to index: " + range2.index_R);
		// (-1(index_L), -1(index_R)) expected
		
		int[] testarray3 = {};
		int lower3 = 10;
		int upper3 = 12;
		
		Subrange range3 = new Subrange();
		range3 = findNumsWithin(testarray3, lower3, upper3);		

		System.out.println("There exists a subrange of elements in the input array >= "+ lower3 + " and <= "+ upper3 + " : from index: "+ range3.index_L + " to index: " + range3.index_R);
		// (-1(index_L), -1(index_R)) expected
		
		int[] testarray4 = {5};
		int lower4 = 3;
		int upper4 = 6;
		
		Subrange range4 = new Subrange();
		range4 = findNumsWithin(testarray4, lower4, upper4);		

		System.out.println("There exists a subrange of elements in the input array >= "+ lower4 + " and <= "+ upper4 + " : from index: "+ range4.index_L + " to index: " + range4.index_R);
		// (0(index_L), 0(index_R)) expected
		
		int[] testarray5 = {0,1,2,3,4,5};
		int lower5 = 3;
		int upper5 = 3;
		
		Subrange range5 = new Subrange();
		range5 = findNumsWithin(testarray5, lower5, upper5);		

		System.out.println("There exists a subrange of elements in the input array >= "+ lower5 + " and <= "+ upper5 + " : from index: "+ range5.index_L + " to index: " + range5.index_R);
		//( 3(index_L), 3(index_R)) expected
		
		int[] testarray6 = {10,15,26,34,46,543};
		int lower6 = 0;
		int upper6 = 600;
		
		Subrange range6 = new Subrange();
		range6 = findNumsWithin(testarray6, lower6, upper6);		

		System.out.println("There exists a subrange of elements in the input array >= "+ lower6 + " and <= "+ upper6 + " : from index: "+ range6.index_L + " to index: " + range6.index_R);
		//( 0(index_L), 5(index_R)) expected
	}

}