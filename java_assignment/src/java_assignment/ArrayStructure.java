package java_assignment;

/**
 * File: ArrayStructure.java Author: Abhijeet C Course: Practice clean code
 * Assignment: java_assignment Due Date: None Version: 1.0
 *
 * Brief description of the class goes here. This class provides functionalities
 * for manipulating an array.
 */
public class ArrayStructure {

	// Array to store elements
	private final int[] theArray = new int[50];

	// Current size of the array
	private int arraySize = 10;

	/**
	 * Generates random values and populates the array.
	 */
	public void generateRandomArray() {
		for (var i = 0; i < arraySize; i++) {
			theArray[i] = (int) (Math.random() * 10) + 10;
		}
	}

	/**
	 * Inserts a value into the array.
	 *
	 * @param value The value to insert.
	 */
	public void insetValue(int value) {
		if (arraySize < 50) {
			theArray[arraySize] = value;
			arraySize++;
		}
	}

	/**
	 * Deletes a value at the specified index.
	 *
	 * @param index The index of the value to delete.
	 */
	public void deleteIndex(int index) {
		if (index < arraySize) {
			for (var i = index; i < arraySize - 1; i++) {
				theArray[i] = theArray[i + 1];
			}
			arraySize--;
		}
	}

	/**
	 * Retrieves the value at the specified index.
	 *
	 * @param index The index of the value to retrieve.
	 * @return The value at the specified index.
	 */
	public int getValueIndex(int index) {
		if (index < arraySize) {
			return theArray[index];
		}
		return 0;
	}

	/**
	 * Prints the array.
	 */
	public void printArray() {
		System.out.println("----------");
		for (var i = 0; i < arraySize; i++) {
			System.out.print("| " + i + " | ");
			System.out.println(theArray[i] + " |");
			System.out.println("----------");
		}
	}

	/**
	 * Checks if the array contains a specific value.
	 *
	 * @param searchValue The value to search for.
	 * @return True if the value is found, otherwise false.
	 */
	public boolean doesArrayContainThisValue(int searchValue) {
		for (var i = 0; i < arraySize; i++) {
			if (theArray[i] == searchValue) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Performs linear search for a value in the array.
	 *
	 * @param value The value to search for.
	 * @return The index of the value if found, otherwise "None".
	 */
	public String linearSearchForValue(int value) {
		var indexWithValue = "";
		for (var i = 0; i < arraySize; i++) {
			if (theArray[i] == value) {
				indexWithValue += i + " ";
			}
		}
		return indexWithValue.isEmpty() ? "None" : indexWithValue;
	}

	/**
	 * 
	 * Performs bubbleSort to sort the array.
	 * 
	 */
	public void bubbleSort() {
		for (var i = 0; i < arraySize; i++) {
			for (var j = 0; j < arraySize - 1 - i; j++) {
				if (theArray[j] > theArray[j + 1]) {
					swapValues(j, j + 1);
				}
			}

		}
	}

	/**
	 * 
	 * Performs swapValues to swap two elements in the array.
	 * 
	 * @param indexOne first index for sort and indexTwo is second index for sort.
	 */
	public void swapValues(int indexOne, int indexTwo) {
		var temp = theArray[indexOne];
		theArray[indexOne] = theArray[indexTwo];
		theArray[indexTwo] = temp;
	}

	/**
	 * 
	 * Performs binary search for a value in the array. only works for sorted
	 * elements
	 * 
	 * @return The index of the value if found, otherwise "-1".
	 */
	public int binarySearchForValue(int value) {
		var lowIndex = 0;
		var highIndex = arraySize - 1;

		while (lowIndex <= highIndex) {

			var middleIndex = (highIndex + lowIndex) / 2;
			if (theArray[middleIndex] < value) {
				lowIndex = middleIndex + 1;
			} else if (theArray[middleIndex] > value) {
				highIndex = middleIndex - 1;
			} else {
				lowIndex = highIndex + 1;
				return middleIndex;

			}

		}

		return -1;

	}

	/**
	 * 
	 * Performs selectionSort to sort the array.
	 * 
	 */
	public void selectionSort() {
		for (var i = 0; i < arraySize; i++) {
			var minValue = i;
			for (var j = i; j < arraySize; j++) {
				if (theArray[minValue] > theArray[j]) {
					minValue = j;
				}
			}
			swapValues(i, minValue);
		}
	}

	/**
	 * 
	 * Performs insertionSort to sort the array.
	 * 
	 */
	public void insertionSort() {
		for (var i = 1; i < arraySize; i++) {
			var j = 1;
			var toInsert = theArray[i];

			while (j > 0 && theArray[j - 1] > toInsert) {
				theArray[j] = theArray[j - 1];
				j--;
			}

			theArray[j] = toInsert;
		}

	}

	public static void main(String[] args) {
		var newArray = new ArrayStructure();
		newArray.generateRandomArray();
		newArray.printArray();
		System.out.println(newArray.getValueIndex(3));
		System.out.println(newArray.doesArrayContainThisValue(12));
		newArray.deleteIndex(4);
		newArray.printArray();
		newArray.insetValue(24);
		newArray.printArray();
		newArray.insetValue(22);
		newArray.printArray();
		System.out.println("The value found in " + newArray.linearSearchForValue(12));
		newArray.bubbleSort();
		newArray.printArray();
		var returnValue = newArray.binarySearchForValue(35);
		if (returnValue != -1) {
			System.out.println("\nFound a match for " + 35 + " at index " + returnValue);
		} else {
			System.out.println("\nNo match for " + 35 + " at any index ");
		}
		newArray.generateRandomArray();
		newArray.printArray();
		newArray.selectionSort();
		newArray.printArray();
		newArray.generateRandomArray();
		newArray.printArray();
		newArray.insertionSort();
		newArray.printArray();
	}
}

