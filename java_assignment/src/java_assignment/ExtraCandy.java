package java_assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * ExtraCandy class contains a method to determine if each kid can have the
 * greatest number of candies by adding extra candies to their current amount.
 *
 * This program serves as a solution to the problem described above.
 *
 * Author: Abhijeet c Course: Practice clean code Assignment: java_assignment
 * Due Date: None Version: 1.0
 */
public class ExtraCandy {

	public static void main(String[] args) {
		// Define the array of candies and the extra candies
		int[] candies = { 2, 3, 5, 1, 3 };
		var extraCandies = 3;
		// Call the function and store the result
		var result = kidsWithCandies(candies, extraCandies);
		System.out.println(result);

	}

	/**
	 * Determines if each kid can have the greatest number of candies by adding
	 * extra candies.
	 *
	 * @param candies      An array of integers representing the current candies
	 *                     each kid has.
	 * @param extraCandies The number of extra candies that can be added to each
	 *                     kid's current amount.
	 * @return A list of booleans indicating whether each kid can have the greatest
	 *         number of candies.
	 */
	public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

		// Initialize a list to store the result
		List<Boolean> result = new ArrayList<Boolean>(Arrays.asList(new Boolean[candies.length]));

		// Fill the result list with false initially
		Collections.fill(result, Boolean.FALSE);
		System.out.println(result);

		// Find the maximum number of candies among the kids
		var maxCandies = 0;

		for (var i = 0; i < candies.length; i++) {
			if (candies[i] > maxCandies) {
				maxCandies = candies[i];
			}
		}

		// Check if adding extra candies to each kid's current amount makes them have
		// the most candies
		for (var j = 0; j < candies.length; j++) {
			if (candies[j] + extraCandies >= maxCandies) {
				result.set(j, true);
			}
		}

		return result;
	}
}
