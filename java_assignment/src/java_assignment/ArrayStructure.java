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
	}
}
