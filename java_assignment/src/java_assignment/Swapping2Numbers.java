/**
 * Swapping2Numbers.java
 * Author: Abhijeet
 * Course:  Practice clean code
 * Assignment: java_assignment
 * Due Date: None
 * Version: 1.0
 */

package java_assignment;

/**
 * This class provides methods to swap two numbers using different techniques.
 */
public class Swapping2Numbers {

	/**
	 * Main method to demonstrate swapping techniques.
	 * 
	 * @param args Command line arguments (not used).
	 */
	public static void main(String[] args) {

		var a = 10;
		var b = 20;
		System.out.println("Before Swapping " + a + " and " + b);

		// Logic 1 Using temporary variable
		SwapNumberWithTemp(a, b);

		// Logic 2 Using Addition and subtraction
		SwapNumberWithAdditionAndSubtraction(a, b);

		// Logic 3 Using Multiplication and Division
		SwapNumberWithMultiplicationAndDivision(a, b);

		// Logic 4 Using Bitwise XOR
		SwapNumberWithBitWiseXOROperator(a, b);

		// Logic 5 Using single statement
		b = a + b - (a = b); // swap is evaluated from right to left
		System.out.println("After Swapping with single statement  " + a + " and " + b);
	}

	/**
	 * Swaps two numbers using a temporary variable.
	 * 
	 * @param a The first number.
	 * @param b The second number.
	 */
	public static void SwapNumberWithTemp(int a, int b) {
		var temp = a;
		a = b;
		b = temp;
		System.out.println("After Swapping with Temp variable " + a + " and " + b);
	}

	/**
	 * Swaps two numbers using addition and subtraction.
	 * 
	 * @param a The first number.
	 * @param b The second number.
	 */
	public static void SwapNumberWithAdditionAndSubtraction(int a, int b) {
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println("After Swapping With Addition And Subtraction " + a + " and " + b);
	}

	/**
	 * Swaps two numbers using bitwise XOR operator.
	 * 
	 * @param a The first number.
	 * @param b The second number.
	 */
	public static void SwapNumberWithBitWiseXOROperator(int a, int b) {
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		System.out.println("After Swapping With Bit Wise XOR operator " + a + " and " + b);
	}

	/**
	 * Swaps two numbers using multiplication and division.
	 * 
	 * @param a The first number.
	 * @param b The second number.
	 */
	public static void SwapNumberWithMultiplicationAndDivision(int a, int b) {
		if (b != 0) {
			a = a * b;
			b = a / b;
			a = a / b;
			System.out.println("After Swapping With Multiplication And Division " + a + " and " + b);
		} else {
			System.out.println("Cannot swap with division if second number is 0 ");
		}
	}
}
