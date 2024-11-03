package LeetCodeGivenByBowuZhang;

/*
 * file: Problem2.java
 * author: 
 * course: CMPT 435
 * assignment: 5
 * 
 * This file contains the skeleton code of  
 * Problem 2.
 */
public class FindMajority {

    /*
     * This method returns the majority element of the array A, 
     * or -1 if there is no majority element.
     * A majority element is an element that occurs more than n/2 times.
     * 
     * You need to implement this method using a divide-and-conquer approach.
     * Split the array into two halves, find the majority elements of each half, 
     * and then combine this information to figure out the majority element for the whole array.
     * 
     * Full credit will be awarded for an O(n log n) solution using divide-and-conquer.
     * 
     * @param A - the input array (which may contain any type of elements)
     * @return - the majority element of the array, or -1 if there is none
     */
    public static int findMajorityElement(int[] A) {
        // Complete the findMajorityElement() method using a divide-and-conquer approach
        // Feel free to change the method type and parameters if needed
        // The goal is to find the majority element in O(n log n) time
        return -1;  // placeholder return
    }

    /*
     * A helper function to count the occurrences of a given element in a range of the array.
     * 
     * @param A - the input array
     * @param element - the element whose occurrences you are counting
     * @param start - the starting index of the range
     * @param end - the ending index of the range (inclusive)
     * @return - the count of occurrences of the element between start and end
     */
    public static int countOccurrences(int[] A, int element, int start, int end) {
        // Implement the helper function to count occurrences of an element
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (A[i] == element) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // Test the findMajorityElement() method with the given examples

        // Example 1: Majority element exists
        int[] A1 = {1, 2, 3, 1, 1, 1, 1};
        System.out.println("Majority element of A1: " + findMajorityElement(A1)); 
        // Expected output: 1

        // Example 2: No majority element
        int[] A2 = {1, 2, 3, 4, 5, 6};
        System.out.println("Majority element of A2: " + findMajorityElement(A2)); 
        // Expected output: -1 (no majority element)

        // Example 3: Majority element exists
        int[] A3 = {2, 2, 2, 2, 3, 3};
        System.out.println("Majority element of A3: " + findMajorityElement(A3)); 
        // Expected output: 2
    }

}
