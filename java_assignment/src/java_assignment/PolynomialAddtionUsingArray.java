package java_assignment;

import java.util.Scanner;

/**
 * File: PolynomialAddtionUsingArray.java Author: Abhijeet C Course: Practice
 * clean code Assignment: java_assignment Due Date: None Version: 1.0 A program
 * to perform addition of two polynomials using arrays.
 */
public class PolynomialAddtionUsingArray {

	public static void main(String[] args) {
		var scanner = new Scanner(System.in);

		System.out.print("Enter number of terms in first polynomial: ");
		var size1 = scanner.nextInt();
		var poly1 = new int[2][size1];
		inputPoly(size1, poly1, scanner);

		System.out.print("Enter number of terms in second polynomial: ");
		var size2 = scanner.nextInt();
		var poly2 = new int[2][size2];
		inputPoly(size2, poly2, scanner);

		// Check if either polynomial is empty
		if (size1 <= 0 || size2 <= 0) {
			System.out.print("Need polynomial of at least 1 term");
			return;
		}

		System.out.print("\nFirst Polynomial: ");
		printPoly(size1, poly1);
		System.out.print("\nSecond Polynomial: ");
		printPoly(size2, poly2);

		// Add the polynomials
		addPoly(size1, poly1, size2, poly2);

		scanner.close();

	}

	/**
	 * Method to input polynomial terms.
	 * 
	 * @param size    The number of terms in the polynomial.
	 * @param poly    The array to store the polynomial.
	 * @param scanner Scanner object for input.
	 */
	public static void inputPoly(int size, int[][] poly, Scanner scanner) {
		System.out.println("\nEnter the coefficient and power of polynomial, in descending order of power");
		System.out.println("For example: 3X^(5) + 4x^(2) + x + 6 is entered as 3 5 4 2 1 1 6 0");
		for (var i = 0; i < size; i++) {
			poly[1][i] = scanner.nextInt(); // Coefficient
			poly[0][i] = scanner.nextInt(); // Power
		}
	}

	/**
	 * Method to print a polynomial.
	 * 
	 * @param size The number of terms in the polynomial.
	 * @param poly The array containing the polynomial.
	 */
	public static void printPoly(int size, int[][] poly) {
		for (var i = 0; i < size; i++) {
			if (poly[0][i] == 0) {
				System.out.print(" " + poly[1][i]);
			} else if (poly[0][i] == 1) {
				System.out.print(" " + poly[1][i] + "x");
			} else {
				System.out.print(" " + poly[1][i] + "x^(" + poly[0][i] + ") ");
			}
			if (i < size - 1) {
				System.out.print("+");
			}
		}
	}

	/**
	 * Method to add two polynomials.
	 * 
	 * @param size1 The number of terms in the first polynomial.
	 * @param poly1 The array containing the first polynomial.
	 * @param size2 The number of terms in the second polynomial.
	 * @param poly2 The array containing the second polynomial.
	 */
	public static void addPoly(int size1, int[][] poly1, int size2, int[][] poly2) {
		var size3 = size1 + size2;
		var addedPoly = new int[2][size3];
		var i = 0;
		var j = 0;
		var k = 0;

		while (i < size1 && j < size2) {
			if (poly1[0][i] == poly2[0][j]) {
				addedPoly[0][k] = poly1[0][i];
				addedPoly[1][k] = poly1[1][i] + poly2[1][j];
				i++;
				j++;
				k++;
			} else if (poly1[0][i] > poly2[0][j]) {
				addedPoly[0][k] = poly1[0][i];
				addedPoly[1][k] = poly1[1][i];
				i++;
				k++;
			} else {
				addedPoly[0][k] = poly2[0][j];
				addedPoly[1][k] = poly2[1][j];
				j++;
				k++;
			}
		}

		while (i < size1) {
			addedPoly[0][k] = poly1[0][i];
			addedPoly[1][k] = poly1[1][i];
			i++;
			k++;
		}

		while (j < size2) {
			addedPoly[0][k] = poly2[0][j];
			addedPoly[1][k] = poly2[1][j];
			j++;
			k++;
		}

		System.out.print("\nAdded Polynomial: ");
		printPoly(k, addedPoly);

	}

}
