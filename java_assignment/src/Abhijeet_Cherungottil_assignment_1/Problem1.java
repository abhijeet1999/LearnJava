package Abhijeet_Cherungottil_assignment_1;
import java.util.*;
/*
 * file: Problem1.java
 * author: Abhijeet Cherungottil
 * course: MSCS 504L-232
 * assignment: 1
 * Due Date: 09/04/2024
 * 
 * This file contains the skeleton code 
 * Problem 1.
 * It find element that most of number of consecutive times and test different scenarios
 */
public class Problem1 {

	public static char findCM(char[] A)  // ---------- O(n)
	{

		/*
		 * Given a character array A[], return the element in A[]
		 * that occurs the most number of consecutive times.
		 * If multiple elements appear consecutively the maximum  * number of times, you should return the element whose 
		 * sequence comes first in the array. 
		 * If the array is Empty or Null, return an empty string 
		 * ("").
		 */
		// Complete the method

		// Initialize the mostCountedChar as '\0', which acts as an empty string
		char mostCountedChar = '\0';

		// Initialize maxValue to 0
		int maxValue = 0;

		// If the array is empty, return the default value
		if (A.length == 0) {
			return mostCountedChar;
		}

		// Initialize currentCharacter as the first character in the array
		char currentCharacter = A[0];
		int currentCharacterCount = 1;

		// Iterate through the array starting from the second character
		for (int i = 1; i < A.length; i++) {      //----- O(n)
			
			if( A[i] != '\0' ) {
				if (A[i] == currentCharacter) {
					// increase the count of number
					currentCharacterCount++;
				} else {
					// Update the mostCountedChar if the current sequence is longer and only if previous value is not empty
					if (currentCharacterCount > maxValue && A[i-1] != '\0') {
						maxValue = currentCharacterCount;
						mostCountedChar = currentCharacter;
					}
					// Reset for the new character sequence
					currentCharacter = A[i];
					currentCharacterCount = 1;
				}
			}

			// To check ß happening each step
			// System.out.println(A[i] + " " + currentCharacterCount + " " + maxValue);

		}

		// Final check to update the mostCountedChar if the last sequence is the longest
		if (currentCharacterCount > maxValue) {
			mostCountedChar = currentCharacter;
		}

		return mostCountedChar;

	}



	public static void main(String[] args) 
	{
		// Test case 1		
		char[] A = {'g','g','b','b','h','b','d','d','d','e','e','b','a','b','b','c','g','g'};		
		System.out.println("The element that occurs the most number of consecutive times : " + findCM(A));
		//Expected output: d

		// Test case 2
		char[] B = {'m','a','r','i','s','t'};
		System.out.println("The element that occurs the most number of consecutive times : " + findCM(B));
		//Expected output: m

		// Test case 3
		char[] C = {};
		System.out.println("The element that occurs the most number of consecutive times : " + findCM(C));
		//Expected output: an empty string "" 

		// My test cases

		// Test case 4
		char[] D = {'a','b','a','b'};
		System.out.println("The element that occurs the most number of consecutive times : " + findCM(D));
		//Expected output:  a

		// Test case 5
		char[] E = {'a'};
		System.out.println("The element that occurs the most number of consecutive times : " + findCM(E));
		//Expected output: a

		// Test case 6
		char[] F = {'\0','\0'};
		System.out.println("The element that occurs the most number of consecutive times : " + findCM(F));
		//Expected output: an empty string ""


		// Test case 6
		char[] G = {'\0','\0','a'};
		System.out.println("The element that occurs the most number of consecutive times : " + findCM(G));
		//Expected output: a
	}

}
