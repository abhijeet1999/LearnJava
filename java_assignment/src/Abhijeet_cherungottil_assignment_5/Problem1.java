package Abhijeet_cherungottil_assignment_5;

/*
 * file: Problem1.java
 * author: Abhijeet Cherungottil
 * course:MSCS 504L-232
 * assignment: 5
 * 
 * This file contains the skeleton code of  
 * Problem 1.
 * 
 * To find intersection and union btween two number in O(n) and in-place
 */
public class Problem1 {
	
	
	
	
	public static void intersection(int[] s1, int[] s2)
	{
		// Complete the intersection() method to output
		// elements that occur in both s1 and s2
		// feel free to change method type and parameters
		// Full credit will awarded to algorithms O(n) time and in-place
		
		// Initialize two pointer
		int i = 0;
		int j = 0;
		
		while(i < s1.length && j < s2.length) {  // )(n)
			
	            if (s1[i] < s2[j]) {
	            	// skip that element
	                i++;
	            } else if (s1[i] > s2[j]) {
	            	// skip that element
	                j++;
	            } else {
	            	// if s1[p1] == s2[p2]
	            	 if (i > 0 && i < s1.length && s1[i] == s1[i - 1]) {
	            		 // check if duplicates is there
	  	                i++;
	  	            }
	  	            // Skip duplicates in B
	  	            if (j > 0 && j < s2.length && s2[j] == s2[j - 1]) {
	  	            	 // check if duplicates is there
	  	                j++;
	  	            }
	  	            
	  	          // stop if any of array ends  
	  	          if (i >= s1.length || j >= s2.length) break;
	  	          
	  	          	// print common element
	                System.out.print(s1[i] + " ");
	                i++;
	                j++;
	            }
		
		
			}
		
	}
	
	public static void union(int[] s1, int[] s2)
	{
		// Complete the union() method to output
		// the union s1 and s2
		// feel free to change method type and parameters
		// Full credit will awarded to algorithms O(n) time and in-place
		// Initialize two pointer
		int i = 0;
		int j = 0;
		
		while(i < s1.length && j < s2.length) { //     --  O(n)
			
            if (s1[i] < s2[j]) {
            	// Skip duplicates in s1
            	 if (i > 0 && i < s1.length && s1[i] == s1[i - 1]) {
   	                i++;
   	            }
            	// print that element
            	System.out.print(s1[i] + " ");
                i++;
            } else if (s1[i] > s2[j]) {
            	// Skip duplicates in s2
            	  if (j > 0 && j < s2.length && s2[j] == s2[j - 1]) {
    	                j++;
    	            }
            	// print that element   
            	System.out.print(s2[j] + " ");
                j++;
                
            } else {
            	// if s1[p1] == s2[p2]
            	
            	// Skip duplicates in s1
            	 if (i > 0 && i < s1.length && s1[i] == s1[i - 1]) {
  	                i++;
  	            }
  	            // Skip duplicates in s2
  	            if (j > 0 && j < s2.length && s2[j] == s2[j - 1]) {
  	                j++;
  	            }
  	            
  	          if (i >= s1.length || j >= s2.length) break;

  	            // print that element   
                System.out.print(s1[i] + " ");
                i++;
                j++;
            }
	
	
		}
		
		// print remaining elements s1
		while(i < s1.length) {
			 if (i > 0 && i < s1.length  && s1[i] == s1[i - 1]) {
	                i++;
	            }
			if(i < s1.length) {
				System.out.print(s1[i] + " ");
			}
			
			i++;
		}

		// print remaining elements s2
		while(j < s2.length) {
			 if (j > 0 && j < s2.length  && s2[j] == s2[j - 1]) {
	                j++;
	            }
			if(j < s2.length) {
				System.out.print(s2[j] + " ");
			}
			
			j++;
		}
		

		
	}
	
	
	
	public static void main(String[] args) {
		// Test your intersection() method here
		int[] testarray1 = {0, 0, 0, 1, 2, 3, 97, 98};
		int[] testarray2 = {0, 1, 2, 3, 4, 4, 10, 98, 100, 100};

		
		System.out.println("intersection of testarray1 and testarray2: ");
		intersection(testarray1,testarray2);
		System.out.println();

		//Expected output 0, 1, 2, 3, 98
		System.out.println("union of testarray1 and testarray2: ");
		union(testarray1,testarray2);
		//Expected output 0, 1, 2, 3, 4, 10, 97, 98, 100

		// My test cases 
		System.out.println();

		// case 1
		int[] testarray3 = {};
		int[] testarray4 = {};

		
		System.out.println("intersection of testarray3 and testarray4: ");
		intersection(testarray3,testarray4);
		System.out.println();

		//Expected output 0, 1, 2, 3, 98
		System.out.println("union of testarray3 and testarray4: ");
		union(testarray3,testarray4);
		//Expected output 0, 1, 2, 3, 4, 10, 97, 98, 100
		
		System.out.println();
		// case 2
		int[] testarray5 = {1,2,3,4};
		int[] testarray6 = {5,6,7,8};

		
		System.out.println("intersection of testarray5 and testarray6: ");
		intersection(testarray5,testarray6);
		System.out.println();

		//Expected output : " "
		System.out.println("union of testarray5 and testarray6: ");
		union(testarray5,testarray6);
		//Expected output 0, 1, 2, 3, 4, 5,6,7,8
		
		System.out.println();
		// case 3
		int[] testarray7 = {1,2,3,4};
		int[] testarray8 = {1,2,3,4};

		
		System.out.println("intersection of testarray7 and testarray8: ");
		intersection(testarray7,testarray8);
		System.out.println();

		//Expected output : " "
		System.out.println("union of testarray7 and testarray8: ");
		union(testarray7,testarray8);
		//Expected output 0, 1, 2, 3, 4, 5,6,7,8
	}

}
