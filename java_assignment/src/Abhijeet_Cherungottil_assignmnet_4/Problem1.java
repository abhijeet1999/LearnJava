package Abhijeet_Cherungottil_assignmnet_4;

/*
 * file: Problem1.java
 * author: Abhijeet Cherungottil
 * course: MSCS 504L-232
 * assignment: 4
 * 
 * This file contains the skeleton code of  
 * Problem 1.
 */

class MaxMin {
    int max;
    int min;
    int difference;

    public MaxMin(int min, int max, int difference) {
        this.min = min;
        this.max = max;
        this.difference = difference;
    }
}

public class Problem1 {

    // Main method to find the maximum difference
    public static int findmaxdiff(int[] A) {
        if (A.length < 2) {
            return 0;
        }
        MaxMin result = findMaxInRightMinInLeft(A, 0, A.length - 1);
        return result.difference;
    }

    // Recursive method to find max, min, and maximum difference
    public static MaxMin findMaxInRightMinInLeft(int[] A, int s, int t) {
        // Base case: if only one element
        if (s == t) {
            return new MaxMin(A[s], A[t], Integer.MIN_VALUE);
        }

        // Find the mid index
        int mid = (s + t) / 2;

        // Recursively find results for left and right subarrays
        MaxMin leftResult = findMaxInRightMinInLeft(A, s, mid);
        MaxMin rightResult = findMaxInRightMinInLeft(A, mid + 1, t);

        // Calculate the difference spanning both left and right
        int crossDifference = rightResult.max - leftResult.min > 0 ? rightResult.max - leftResult.min : 0;

       
        int maxDiff = Math.max(Math.max(leftResult.difference, rightResult.difference), crossDifference);

        // The minimum of the entire range is the smaller of the left and right minimums
        int minElement = Math.min(leftResult.min, rightResult.min);

        // The maximum of the entire range is the larger of the left and right maximums
        int maxElement = Math.max(leftResult.max, rightResult.max);

        // Return the new MaxMin object with updated min, max, and max difference
        return new MaxMin(minElement, maxElement, maxDiff);
    }

    public static void main(String[] args) {
    	// Test your findmaxdiff() method here
    	
    	int[] testarray1 = {2, 3, 10, 6, 4, 8, 1};
    	// maxdiff: 8
    	// Add your test statement of findmaxdiff ()
        System.out.println("Max difference: " + findmaxdiff(testarray1)); // Expected: 8

        // My test case
        int[] testarray2 = {7, 9, 1, 6, 3, 2};
        System.out.println("Max difference: " + findmaxdiff(testarray2)); // Expected: 5
        // maxdiff: 5
        
        int[] testarray3 = {1, 2, 90, 10, 110};
        System.out.println("Max difference: " + findmaxdiff(testarray3)); // Expected: 109
        // maxdiff: 109
        
        int[] testarray4 = {100, 90, 80, 70, 60};
        System.out.println("Max difference: " + findmaxdiff(testarray4)); 
        // // maxdiff: 0
    }
}
