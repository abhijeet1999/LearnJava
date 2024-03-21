package java_assignment;

import java.util.Arrays;

/**
 * File: MeanMediumMode.java Author: Abhijeet C Course: Practice clean code
 * Assignment: java_assignment Due Date: none Version: 1.0
 *
 * This class calculates the mean, median, and mode of a given dataset.
 */
public class MeanMediumMode {

	/**
	 * Calculates the mean, median, and mode of a given dataset. Prints the results
	 * to the console.
	 */
	public static void main(String[] args) {
		int[] dataSet = { 1, 2, 2, 2, 3, 4, 4, 4, 4 };

		// Calculate mean
		var sum = 0;
		for (var i = 0; i < dataSet.length; i++) {
			sum += dataSet[i];
		}
		var mean = sum / (float) dataSet.length;
		System.out.println("Mean = " + mean);

		// Sort the data to calculate median
		Arrays.sort(dataSet);
		var median = 0F;
		// Calculate median
		if (dataSet.length % 2 == 0) {
			float term1 = dataSet[dataSet.length / 2];
			float term2 = dataSet[dataSet.length / 2 - 1];
			median = (term1 + term2) / 2;
			System.out.println("Median = " + median);
		} else {
			median = dataSet[dataSet.length / 2];
			System.out.println("Median = " + median);
		}

		// Calculate mode
		var maxNumber = -1;
		var maxAppearance = -1;
		for (var i = 0; i < dataSet.length; i++) {
			var count = 0;
			for (var j = 0; j < dataSet.length; j++) {
				if (dataSet[i] == dataSet[j]) {
					count++;
				}
			}
			if (count > maxAppearance) {
				maxNumber = dataSet[i];
				maxAppearance = count;
			}
		}
		System.out.println("Mode = " + maxNumber + " with maximum appearance " + maxAppearance);

		// Calculate mode using a formula
		// formula = mean - mode = 3(mean - median) for screw distribution

		System.out.println("mean - mod " + (mean - maxNumber) + "  3(mean - median) " + 3 * (mean - median));
	}
}
