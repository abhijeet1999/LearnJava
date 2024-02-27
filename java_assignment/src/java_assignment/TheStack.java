package java_assignment;

import java.util.Arrays;

/**
 * File: TheStack.java Author: Abhijeet C Course: Practice clean code
 * Assignment: java_assignment Due Date: None Version: 1.0
 *
 * Represents a stack data structure with limited capacity.
 * 
 */

public class TheStack {

	private final String[] stackArray;
	private final int stackSize;
	private int topOfStack = -1;

	/**
	 * Constructs a stack with the specified size.
	 * 
	 * @param size The maximum capacity of the stack
	 */
	TheStack(int size) {
		stackSize = size;
		stackArray = new String[size];
		Arrays.fill(stackArray, "-1");
	}

	/**
	 * Pushes an element onto the top of the stack.
	 * 
	 * @param input The element to be pushed onto the stack
	 */
	public void push(String input) {
		if (topOfStack + 1 < stackSize) {
			topOfStack++;
			stackArray[topOfStack] = input;
			System.out.println("Push " + input + " was added to the stack");
		} else {
			System.out.println("Sorry but stack is full");
		}
	}

	/**
	 * Removes and returns the element at the top of the stack.
	 * 
	 * @return The element removed from the top of the stack, or "-1" if the stack
	 *         is empty
	 */
	public String pop() {
		if (topOfStack >= 0) {
			System.out.println("Pop " + stackArray[topOfStack] + " was removed from the stack");
			var poppedValue = stackArray[topOfStack];
			stackArray[topOfStack] = "-1";
			topOfStack--;
			return poppedValue;
		}
		System.out.println("Sorry but stack is empty");
		return "-1";
	}

	/**
	 * Returns the element at the top of the stack without removing it.
	 * 
	 * @return The element at the top of the stack, or "-1" if the stack is empty
	 */
	public String peek() {
		if (topOfStack >= 0) {
			System.out.println("Peek " + stackArray[topOfStack] + " is top of stack");
			return stackArray[topOfStack];
		}
		System.out.println("Sorry but stack is empty");
		return "-1";
	}

	/**
	 * Pushes multiple elements onto the stack.
	 * 
	 * @param multipleValues A string containing space-separated values to be pushed
	 *                       onto the stack
	 */
	public void pushMany(String multipleValues) {
		var tempString = multipleValues.split(" ");
		for (var i = 0; i < tempString.length; i++) {
			push(tempString[i]);
		}
	}

	/**
	 * Prints the contents of the stack.
	 */
	public void printArray() {
		System.out.println("----------");
		for (var i = 0; i < stackSize; i++) {
			System.out.print("| " + i + " | ");
			System.out.println(stackArray[i] + " |");
			System.out.println("----------");
		}
	}

	/**
	 * Removes all elements from the stack.
	 */
	public void popAll() {
		topOfStack = -1;
		Arrays.fill(stackArray, "-1");
	}

	public static void main(String[] args) {
		var stack = new TheStack(10);
		stack.push("10");
		stack.printArray();
		stack.push("30");
		stack.printArray();
		stack.peek();
		stack.pop();
		stack.printArray();
		stack.peek();
		stack.pushMany("20 30 40 50 60");
		stack.peek();
		stack.printArray();
		stack.popAll();
		stack.printArray();
	}
}
