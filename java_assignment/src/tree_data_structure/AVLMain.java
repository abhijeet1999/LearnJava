package tree_data_structure;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * AVLMain class demonstrates the AVL Tree data structure. It reads integers
 * from a file and constructs an AVL Tree from them.
 */
public class AVLMain {

	/**
	 * Main method to demonstrate the AVL Tree.
	 *
	 * @param args Command-line arguments
	 */
	public static void main(String[] args) {
		var tree = new AVLTree();
		try {
			tree.insert("src/tree_data_structure/data.txt").print();
		} catch (FileNotFoundException e) {
			System.out.println("File not found!!");
		}

	}

}

/**
 * Node class represents a node in the AVL Tree. It stores integer data, height,
 * and references to left and right child nodes.
 */
class Node {
	public int data, height;
	public Node left, right;

	/**
	 * Constructor to create a new Node with given data.
	 *
	 * @param data The integer data of the node
	 */
	public Node(int data) {
		this.data = data;
		height = 1;
	}

}

/**
 * AVLTree class represents an AVL Tree data structure. It supports insertion of
 * elements and maintains balance using rotations.
 */
class AVLTree {
	private Node root;

	/**
	 * Inserts integers from a file into the AVL Tree.
	 *
	 * @param filename The name of the file containing integers to be inserted
	 * @return The AVLTree object after inserting elements
	 * @throws FileNotFoundException If the file is not found
	 */
	public AVLTree insert(String filename) throws FileNotFoundException {
		var tree1 = new AVLTree();
		var file = new Scanner(new File(filename));

		while (file.hasNext()) {
			tree1.insert(file.nextInt());
		}

		return tree1;
	}

	/**
	 * Inserts an integer into the AVL Tree.
	 *
	 * @param nextInt The integer to be inserted
	 */
	private void insert(int nextInt) {
		root = insert(root, nextInt);
	}

	/**
	 * Inserts an integer into the AVL Tree rooted at given node. Also balances the
	 * tree if necessary.
	 *
	 * @param root    The root of the subtree
	 * @param nextInt The integer to be inserted
	 * @return The root of the modified subtree
	 */
	private Node insert(Node root, int nextInt) {
		// if it is empty we have to make a new node
		if (root == null) {
			return new Node(nextInt);
		}
		// checking if the new data is greater or less than root
		if (nextInt < root.data) {
			root.left = insert(root.left, nextInt);
		} else if (nextInt > root.data) {
			root.right = insert(root.right, nextInt);
		}
		// update the tree height
		root.height = 1 + max(height(root.left), height(root.right));

		// balance the tree
		var balance = getBalance(root);

		// Scenarios of rotation, if left we have even, if right we have odd
		if (balance > 1 && nextInt < root.left.data) {
			return rightRotate(root);
		}
		if (balance > 1 && nextInt > root.left.data) {
			root.left = leftRotate(root.left);
			return rightRotate(root);
		}
		if (balance < -1 && nextInt > root.right.data) {
			return leftRotate(root);
		}
		if (balance < -1 && nextInt < root.right.data) {
			root.right = rightRotate(root.left);
			return leftRotate(root);
		}

		return root;
	}

	/**
	 * Performs left rotation on the given node.
	 *
	 * @param root The node to perform rotation on
	 * @return The root of the modified subtree
	 */
	private Node leftRotate(Node root) {
		var r = root.right;
		var l = root.right.left;
		r.left = root;
		root.right = l;
		root.height = max(height(root.left), height(root.right)) + 1;
		r.height = max(height(root.left), height(root.right)) + 1;
		return r;
	}

	/**
	 * Performs right rotation on the given node.
	 *
	 * @param root The node to perform rotation on
	 * @return The root of the modified subtree
	 */
	private Node rightRotate(Node root) {
		var l = root.left;
		var r = root.left.right;
		l.right = root;
		root.left = r;
		root.height = max(height(root.left), height(root.right)) + 1;
		l.height = max(height(l.left), height(l.right)) + 1;
		return l;
	}

	/**
	 * Calculates the balance factor of a node.
	 *
	 * @param root The node to calculate balance factor for
	 * @return The balance factor of the node
	 */
	private int getBalance(Node root) {
		return root == null ? 0 : height(root.left) - height(root.right);
	}

	/**
	 * Returns the maximum of two integers.
	 *
	 * @param heightL Height of left subtree
	 * @param heightR Height of right subtree
	 * @return The maximum height
	 */
	private int max(int heightL, int heightR) {
		return heightL > heightR ? heightL : heightR;
	}

	/**
	 * Calculates the height of a node.
	 *
	 * @param node The node to calculate height for
	 * @return The height of the node
	 */
	private int height(Node node) {
		if (node == null) {
			return 0;
		}
		return node.height;
	}

	/**
	 * Utility method to print the AVL Tree in 2D format.
	 *
	 * @param root  The root of the AVL Tree
	 * @param space The space to be added for each level
	 */
	static void print2DUtil(Node root, int space) {
		// Base case
		if (root == null) {
			return;
		}

		// Increase distance between levels
		space += 10;

		// Process right child
		print2DUtil(root.right, space);

		// Print current node
		System.out.print("\n");
		for (var i = 10; i < space; i++) {
			System.out.print(" ");
		}
		System.out.print(root.data);

		// Process left child
		print2DUtil(root.left, space);
	}


	/**
	 * Prints the AVL Tree in level order and then in 2D format.
	 */
	public void print() {
		var node = root;
		if (node == null) {
			return;
		}
		Queue<Node> q = new LinkedList<>();
		q.add(node);
		q.add(null);

		while (!q.isEmpty()) {
			var currentN = q.poll();
			if (currentN == null) {
				if (!q.isEmpty()) {
					q.add(null);
					System.out.println();
				}
			} else {
				if (currentN.left != null) {
					q.add(currentN.left);
				}
				if (currentN.right != null) {
					q.add(currentN.right);
				}

				System.out.print("( " + currentN.data + ", " + currentN.height + ", " + getBalance(currentN) + " )");

			}

		}
		System.out.println();
		System.out.println("---------------");
		print2DUtil(root, 0);
	}

}
