package java_assignment;

/**
 * File: QuickSort.java Author: Abhijeet C Course: Practice clean code
 * Assignment: java_assignment Due Date: None Version: 1.0
 * 
 * QuickSort - A class implementing the QuickSort algorithm.
 * 
 * This class provides methods to sort an array using the QuickSort algorithm.
 */

public class QuickSort {
	
	/**
	 * Prints the elements of the array.
	 * 
	 * @param theArray  An array of integers to be printed.
	 * @param arraySize The size of the array.
	 */
	public static void printArray(int theArray[], int arraySize ) {
		System.out.println("----------");
		for (var i = 0; i < arraySize; i++) {
			System.out.print("| " + i + " | ");
			System.out.println(theArray[i] + " |");
			System.out.println("----------");
		}
	}
	
	/**
	 * Partitions the array and returns the index of the pivot element.
	 * 
	 * @param arr  The array to be partitioned.
	 * @param low  The starting index of the partition.
	 * @param high The ending index of the partition.
	 * @return The index of the pivot element after partitioning.
	 */
	public static int partition(int arr[], int low, int high) {
		var pivot = arr[high];
		var i = low - 1;
		
		for(var j = low; j < high; j++) {
			if ( arr[j] < pivot) {
				i++;
				var temp = arr[i]; // swapping elements less than pivot to its left side
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		i++;
		var temp = arr[i]; // swapping pivot to its right position
		arr[i] = pivot;
		arr[high] = temp;
		return i; // pivot index
	}
	
	/**
	 * Sorts the array using the QuickSort algorithm.
	 * 
	 * @param arr  The array to be sorted.
	 * @param low  The starting index of the array.
	 * @param high The ending index of the array.
	 */
	public static void quickSort(int arr[], int low, int high) {
		if (low < high) {
			var pivotIndex = partition(arr, low, high);
			
			quickSort(arr, low, pivotIndex - 1);
			quickSort(arr, pivotIndex + 1, high);
		}
	}

	/**
	 * The main method to demonstrate QuickSort.
	 * 
	 * @param args Command-line arguments (not used).
	 */
	public static void main(String[] args) {
		int[] arr = {6,9,5,2,8};
		var n = arr.length;
		
		quickSort(arr,0,n-1);
		printArray(arr, n);
	}
}
