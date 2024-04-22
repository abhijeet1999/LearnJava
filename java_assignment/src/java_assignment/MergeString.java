
/**
 * MergeString.java
 * Author: Abhijeet c
 * Course:  Practice clean code
 * Assignment: MergeString
 * Due Date: None
 * Version: 1.0
 */

package java_assignment;

/**
 * This class provides a method to merge two strings alternately.
 */
public class MergeString {

	/**
	 * Merges two strings alternately.
	 *
	 * @param word1 The first string to merge.
	 * @param word2 The second string to merge.
	 * @return The merged string.
	 */
	public static String mergeAlternately(String word1, String word2) {
		var temp = "";
		var length1 = word1.length();
		var length2 = word2.length();
		var array1 = word1.toCharArray();
		var array2 = word2.toCharArray();
		var i = 0;
		while (i < length1 || i < length2) {
			if (i < length1) {
				temp += array1[i];
			}
			if (i < length2) {
				temp += array2[i];
			}

			i++;
		}

		return temp;
	}

	public static void main(String[] args) {
		var a = mergeAlternately("abcefgh", "pqrst");
		// Print the merged string
		System.out.println(a);
	}
}
