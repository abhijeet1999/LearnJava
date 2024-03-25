package java_assignment_generics;

import java.util.Scanner;

/**
 * File: PostFixEvaluate.java Author: Abhijeet C Course: Practice clean code
 * Assignment: java_assignment Due Date: none Version: 1.0
 * 
 * PostFixEvaluate class is responsible for evaluating postfix expressions. It
 * takes an infix expression as input, converts it to postfix notation, and then
 * evaluates the postfix expression to get the result.
 */
public class PostFixEvaluate {

	/**
	 * Main method of the program. It reads an infix expression from the user,
	 * converts it to postfix notation, evaluates it, and prints the result.
	 * 
	 * @param args Command-line arguments (not used).
	 */
	public static void main(String[] args) {
		// Getting expression input from the user
		var input = new Scanner(System.in);
		System.out.print("Give me an expression: ");

		var expression = input.nextLine();

		// Converting infix expression to postfix notation
		var postfixExpression = Postfix.infixToPostfix(expression);
		System.out.println("Postfix notation: " + postfixExpression);

		// Evaluating the postfix expression and printing the result
		System.out.println("Answer: " + Postfix.evaluate(postfixExpression));

		input.close();
	}
}


/**
 * Postfix class provides methods for converting infix expressions to postfix
 * notation and evaluating postfix expressions.
 */
class Postfix {

	/**
	 * Converts an infix expression to a postfix expression.
	 * 
	 * @param expression The infix expression to convert.
	 * @return The postfix expression.
	 */
	public static String infixToPostfix(String expression) {
		// Creating stack to store operators
		var stack = new Stack<Character>(); // creating generic stack
		// Creating queue to store operands
		var queue = new Queue<Character>(); // creating generic Queue

		for (var i = 0; i < expression.length(); i++) {
			var c = expression.charAt(i);

			if (Character.isDigit(c)) { // for numbers
				queue.add(c);
			} else if (c == '(') { // for open parenthesis
				stack.push(c);
			} else if (c == ')') { // for close parenthesis
				// Adding and popping off stack until encountering open parenthesis
				while (!stack.isEmpty() && stack.peek() != '(') {
					queue.add(stack.pop());
				}
				stack.pop();
			} else { // for operators
				// If the precedence of the previous operator in stack is greater than or equal
				// to current operator,
				// we pop it and add it to the queue
				while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(c)) {
					queue.add(stack.pop());
				}
				// Otherwise, push to stack
				stack.push(c);
			}
		}

		// Pop remaining operators from stack and add to queue
		while (!stack.isEmpty()) {
			queue.add(stack.pop());
		}

		// Constructing the postfix expression from the queue
		var ret = "";
		while (!queue.isEmpty()) {
			ret += queue.remove();
		}

		return ret;
	}

	/**
	 * Determines the precedence of an operator.
	 * 
	 * @param c The operator.
	 * @return The precedence value.
	 */
	public static int precedence(char c) {
		switch (c) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		}
		return -1;
	}

	/**
	 * Evaluates a postfix expression and returns the result.
	 * 
	 * @param postfixExpression The postfix expression to evaluate.
	 * @return The result of the evaluation.
	 */
	public static int evaluate(String postfixExpression) {
		// Storage for operands that we need to push
		var storage = new Stack<Integer>(); // creating generic stack

		for (var i = 0; i < postfixExpression.length(); i++) {
			var c = postfixExpression.charAt(i);

			// If character is an operand
			if (Character.isDigit(c)) {
				storage.push(Character.getNumericValue(c));
			} else if (storage.size() > 1) {
				// If it's an operator, pop the required operands, perform the operation, and
				// push the result back
				int right = storage.pop();
				int left = storage.pop();
				storage.push(solve(left, c, right));
			}
		}

		// When done, pop and return what is left in the stack
		return storage.pop();
	}

	/**
	 * Solves a binary operation given the left operand, operator, and right
	 * operand.
	 * 
	 * @param left     The left operand.
	 * @param operator The operator.
	 * @param right    The right operand.
	 * @return The result of the operation.
	 */
	private static Integer solve(int left, char operator, int right) {
		var result = 0;

		switch (operator) {
		case '+':
			result = left + right;
			break;
		case '-':
			result = left - right;
			break;
		case '*':
			result = left * right;
			break;
		case '/':
			if (right != 0) {
				result = left / right;
			}
			break;
		}

		return result;
	}
}

/**
 * ListNode class represents a node in a linked list.
 * 
 * @param <T> The type of data stored in the node.
 */
class ListNode<T> {
	// Data stored in the node
	T data;
	// Reference to the next node
	ListNode<T> next;

	/**
	 * Constructor to initialize the ListNode with data and next node reference.
	 * 
	 * @param data The data to be stored in the node.
	 * @param next Reference to the next node.
	 */
	public ListNode(T data, ListNode<T> next) {
		this.data = data;
		this.next = next;
	}

	/**
	 * Getter method to retrieve the data stored in the node.
	 * 
	 * @return The data stored in the node.
	 */
	public T getData() {
		return data;
	}

	/**
	 * Setter method to set the data stored in the node.
	 * 
	 * @param data The data to be set.
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * Getter method to retrieve the reference to the next node.
	 * 
	 * @return The reference to the next node.
	 */
	public ListNode<T> getNext() {
		return next;
	}

	/**
	 * Setter method to set the reference to the next node.
	 * 
	 * @param next Reference to the next node.
	 */
	public void setNext(ListNode<T> next) {
		this.next = next;
	}
}


/**
 * Stack class represents a stack data structure.
 * 
 * @param <T> The type of data stored in the stack.
 */
class Stack<T> {
	// Reference to the top of the stack
	private ListNode<T> head;
	// Size of the stack
	private int size;

	/**
	 * Constructor to initialize an empty stack.
	 */
	public Stack() {
		head = null;
		size = 0;
	}

	/**
	 * Checks if the stack is empty.
	 * 
	 * @return True if the stack is empty, false otherwise.
	 */
	public boolean isEmpty() {
		return (size == 0);
	}

	/**
	 * Retrieves the element at the top of the stack without removing it.
	 * 
	 * @return The element at the top of the stack.
	 */
	public T peek() {
		return head.data;
	}

	/**
	 * Removes and returns the element at the top of the stack.
	 * 
	 * @return The element removed from the top of the stack.
	 */
	public T pop() {
		var temp = head;
		head = head.next;
		size--;
		return temp.data;
	}

	/**
	 * Pushes an element onto the top of the stack.
	 * 
	 * @param data The data to be pushed onto the stack.
	 */
	public void push(T data) {
		var temp = new ListNode<T>(data, null);

		// Adding the new node to the top of the stack
		temp.next = head;
		head = temp;

		size++;
	}

	/**
	 * Returns the size of the stack.
	 * 
	 * @return The number of elements in the stack.
	 */
	public int size() {
		return size;
	}
}

/**
 * Queue class represents a queue data structure.
 * 
 * @param <T> The type of data stored in the queue.
 */
class Queue<T> {
	// Reference to the head of the queue
	private ListNode<T> head;
	// Reference to the tail of the queue
	private ListNode<T> tail;
	// Size of the queue
	private int size;

	/**
	 * Constructor to initialize an empty queue.
	 */
	public Queue() {
		head = null;
		tail = null;
		size = 0;
	}

	/**
	 * Adds an element to the end of the queue.
	 * 
	 * @param data The data to be added to the queue.
	 */
	public void add(T data) {
		size++;
		var temp = new ListNode<T>(data, null);
		if (head == null && tail == null) {
			// If the queue is empty, both head and tail point to the new node
			head = temp;
			tail = temp;
		} else {
			// If the queue is not empty, add the new node after the tail and update the
			// tail
			tail.next = temp;
			tail = temp;
		}
	}

	/**
	 * Checks if the queue is empty.
	 * 
	 * @return True if the queue is empty, false otherwise.
	 */
	public boolean isEmpty() {
		return (size == 0);
	}

	/**
	 * Removes and returns the element at the front of the queue.
	 * 
	 * @return The element removed from the front of the queue.
	 */
	public T remove() {
		size--;
		var temp = head.data;
		head = head.next;
		return temp;
	}
}
