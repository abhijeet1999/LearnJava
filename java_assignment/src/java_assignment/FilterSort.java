/**
 * File: FilterSort.java
 * Author: Abhijeet C
 * Course: Practice clean code
 * Assignment: java_assignment
 * Due Date: None
 * Version: 1.0
 *
 * Program that reads from a file and prints only the integer tokens to the screen in ascending order.
 */

package java_assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class FilterSort {

	/**
	 * Main method to execute the program. Reads integers from a file and prints
	 * them in ascending order.
	 * 
	 * @param args Command-line arguments.
	 */
	public static void main(String[] args) {
		var array = new int[8]; // Initialize and declare array
		var counter = 0;

		try {
			var scan = new Scanner(new File("src/java_assignment/data.txt")); // Try to open the file

			while (scan.hasNext()) {
				var all = scan.next(); // Store the current string operation
				try { // Check if the next token is an integer
					var num = Integer.parseInt(all); // Convert the token to an integer
					array[counter] = num; // Store the integer in the array
					counter++;

					if (counter == array.length) { // Check if the array is full
						array = doubleArrayAndCopy(array); // Double the array size
					}

				} catch (NumberFormatException e) { // Catch non-integer tokens
					// Ignore non-integer tokens
				}
			}
		} catch (FileNotFoundException e) { // Catch file not found exception
			System.out.println("File not found");
		}

		Arrays.sort(array, 0, counter); // Sort the array up to the counter
		for (var i = 0; i < counter; i++) { // Print the sorted integers
			System.out.println(array[i]);
		}
	}

	/**
	 * Doubles the size of the given array and copies its elements.
	 * 
	 * @param array The array to be doubled.
	 * @return The new array with doubled size containing the original elements.
	 */
	private static int[] doubleArrayAndCopy(int[] array) {
		var size = array.length * 2; // Calculate new size
		return Arrays.copyOf(array, size); // Copy elements to new array with doubled size
	}
}
