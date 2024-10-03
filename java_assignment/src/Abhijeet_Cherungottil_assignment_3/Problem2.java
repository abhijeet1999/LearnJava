package Abhijeet_Cherungottil_assignment_3;

/*
 * file: Problem2.java
 * author: Abhijeet Cherungottil
 * course: MSCS 504L-232
 * assignment: 3
 * 
 * This file contains the skeleton code of  
 * Problem 2.
 * This code merge to string in inceasing order
 */

public class Problem2 {

	
	public static String merge(String s1, String s2, int index1, int index2, int length1, int length2)
	{
		// Complete this method to merge two alphabetized strings into one string with letters in alphabetical order
		// Feel free to change the function return type and the parameters
		// Full credits (30 points) will be awarded to a recursive methd without loop. A non-recursive method will be scored out of 10 points.
		/* Base case: have we reached the end of one String? If so, return the other String
		Recursive cases: if 0th character of first String < 0th character of second String then 
		return 0th character of first String + recursive method call(rest of first String, second String) 
		else 
		return 0th character of second String + recursive method call(first String, rest of second String)
		*/
		if (index1 == length1 ) {       // base case 1
			// reached end of first string return s2 remaining string
			return s2.substring(index2);
			
		} else if (index2 == length2 ) {    // base case 2
			// reached end of second string return s1 remaining string

			return s1.substring(index1);
			
		} else if (s1.charAt(index1) <= s2.charAt(index2)) { // general case 1

			//return index1 character of first String + recursive method call(rest of first String, second String) 

			return s1.charAt(index1) + merge(s1, s2,index1 + 1, index2, length1,length2);
			
		} else { // general case 2
            
			// 	return index2 character of second String + recursive method call(first String, rest of second String)
			return s2.charAt(index2) + merge(s1, s2,index1 , index2 + 1, length1,length2);

		}
	  


	} 
	
	public static void main(String[] args) {
		// Test your method
		String s1 = "aaaccff";
		String s2 = "bcddeg";
		System.out.println("First string: " + s1);
		System.out.println("Second string: " + s2);
		String ms = merge(s1, s2,0,0,s1.length(),s2.length());
		System.out.println("Merged string: " + ms);
		// Expected output: aaabcccdeffg
		
		// My test cases
		String s3 = "";
		String s4 = "bcddeg";
		System.out.println("First string: " + s3);
		System.out.println("Second string: " + s4);
		String ms1 = merge(s3, s4,0,0,s3.length(),s4.length());
		System.out.println("Merged string: " + ms1);
		// Expected output: bcddeg
		
		String s5 = "absd";
		String s6 = "";
		System.out.println("First string: " + s5);
		System.out.println("Second string: " + s6);
		String ms2 = merge(s5, s6,0,0,s5.length(),s6.length());
		System.out.println("Merged string: " + ms2);
		// Expected output: absd
		
		String s7 = "";
		String s8 = "";
		System.out.println("First string: " + s7);
		System.out.println("Second string: " + s8);
		String ms3 = merge(s7, s8,0,0,s7.length(),s8.length());
		System.out.println("Merged string: " + ms3);
		// Expected output: ""
		
		String s9 = "acd";
		String s10 = "acd";
		System.out.println("First string: " + s9);
		System.out.println("Second string: " + s10);
		String ms4 = merge(s9, s10,0,0,s9.length(),s10.length());
		System.out.println("Merged string: " + ms4);
		// Expected output: ""
		
		
	}
}
