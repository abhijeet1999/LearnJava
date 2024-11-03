package Abhijeet_Cherungottil_assignmnet_4;

/*
 * file: Problem2.java
 * author: Abhijeet Cherungottil
 * course: MSCS 504L-232
 * assignment: 4
 * 
 * This file contains the skeleton code of  
 * Problem 2.
 * To find largest and second largest element in array using divide and conquer method
 */

class Max2ndMax {
	int max;
	int max2nd;
}

public class Problem2
{

public static Max2ndMax dcfindmax2ndmax(int[] A, int i, int j)
	{
		// Complete this method to find max and 2nd max in an array A
		// At most 3n/2-2 comparisons
		// Algorithms that make more comparisons than 3n/2-2 will be scored out of 10 points
		// Complete the code from here
		// Feel free to change method type, parameters
	
	Max2ndMax tempMax = new Max2ndMax();
	tempMax.max = 0;
	tempMax.max2nd = 0;
	int mid = 0;
	
	if(j < 0) {
		// if its empty string return 0
		return tempMax;
	}
	
	if ( i == j) {
		// if there is only one element return same element as max and 2nd max
		tempMax.max = A[i];
		tempMax.max2nd = A[j];
	} else if (j == i + 1) {
		// If there is exactly two elements return the one with max by comparing the two
		if(A[i] > A[j]) {
			tempMax.max = A[i];
			tempMax.max2nd = A[j];
		} else {
			tempMax.max = A[j];
			tempMax.max2nd = A[i];
		}
	} else {
		// If there is more than 2 element
		// To find mid index
		mid = (i + j) / 2;
		// create default tempLMax for retrieving largest and second largest in left side
		Max2ndMax tempLMax = new Max2ndMax();
		
		// create default tempRMax for retrieving largest and second largest in right side
		Max2ndMax tempRMax = new Max2ndMax();
		
		// Recursively call the to find left side max and right side max until only two elements left
		tempLMax = dcfindmax2ndmax(A, i, mid);
		tempRMax = dcfindmax2ndmax(A, mid , j);
		
		if (tempLMax.max < tempRMax.max) {
			// Since right max is greater than left max new max is right max
			tempMax.max =  tempRMax.max;
			
			// Now we just have to compare leftmax with rightmax2nd find greatest as second max
			if(tempLMax.max < tempRMax.max2nd) {
				tempMax.max2nd = tempRMax.max2nd;
			} else {
				tempMax.max2nd = tempLMax.max;
			}
			
		} else if(tempLMax.max > tempRMax.max) {
			
			// Since left max is greater than right max new max is left max
			tempMax.max =  tempLMax.max;
			
			// Now we just have to compare rightmax with leftmax2nd find greatest as second max
			if( tempRMax.max < tempLMax.max2nd) {
				tempMax.max2nd = tempLMax.max2nd;
			} else {
				tempMax.max2nd = tempRMax.max;

			}

			
		} else {
			// if both left and right max are equal, just set one for each
			tempMax.max =  tempLMax.max;
			tempMax.max2nd =  tempRMax.max;

		}

	}

	return tempMax;
		
		
	}
	
	public static void main(String[] args) {
		int[] givenarray = {100,2,3,4,5,6,7,67,2,32};	

		// Test your method
		Max2ndMax pair = new Max2ndMax();
		// Java does pass-by-value not by-reference
		// Therefore we create a class of Max2ndMax for max and 2ndmax pair
		pair = dcfindmax2ndmax(givenarray, 0, givenarray.length-1);
		int max2nd = pair.max2nd;
		int max = pair.max;
		System.out.println("The max and 2ndmax of the given array are "+ max + " and "+max2nd+".");
		// Your method should return 100 and 67
		
		// my test cases
		
		int[] givenarray1 = {100,2};	

		// Test your method
		Max2ndMax pair1 = new Max2ndMax();
		// Java does pass-by-value not by-reference
		// Therefore we create a class of Max2ndMax for max and 2ndmax pair
		pair1 = dcfindmax2ndmax(givenarray1, 0, givenarray1.length-1);
		int max2nd1 = pair1.max2nd;
		int max1 = pair1.max;
		System.out.println("The max and 2ndmax of the given array are "+ max1 + " and "+max2nd1+".");
		// Your method should return 100 and 2
		
		int[] givenarray2 = {100};	

		// Test your method
		Max2ndMax pair2 = new Max2ndMax();
		// Java does pass-by-value not by-reference
		// Therefore we create a class of Max2ndMax for max and 2ndmax pair
		pair2 = dcfindmax2ndmax(givenarray2, 0, givenarray2.length-1);
		int max2nd2 = pair2.max2nd;
		int max2 = pair2.max;
		System.out.println("The max and 2ndmax of the given array are "+ max2 + " and "+max2nd2+".");
		// Your method should return 100 and 100
		
		
		int[] givenarray3 = {};	

		// Test your method
		Max2ndMax pair3 = new Max2ndMax();
		// Java does pass-by-value not by-reference
		// Therefore we create a class of Max2ndMax for max and 2ndmax pair
		pair3 = dcfindmax2ndmax(givenarray3, 0, givenarray3.length-1);
		int max2nd3 = pair3.max2nd;
		int max3 = pair3.max;
		System.out.println("The max and 2ndmax of the given array are "+ max3 + " and "+max2nd3+".");
		// Your method should return 0 and 0
		
		
		int[] givenarray4 = {7,7,7,7,7,7};	

		// Test your method
		Max2ndMax pair4 = new Max2ndMax();
		// Java does pass-by-value not by-reference
		// Therefore we create a class of Max2ndMax for max and 2ndmax pair
		pair4 = dcfindmax2ndmax(givenarray4, 0, givenarray4.length-1);
		int max2nd4 = pair4.max2nd;
		int max4 = pair4.max;
		System.out.println("The max and 2ndmax of the given array are "+ max4 + " and "+max2nd4+".");
		// Your method should return 7 and 7
		
		
		
	}
	
	
}