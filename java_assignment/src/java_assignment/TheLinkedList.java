
package java_assignment;

/**
 * File: TheLinkedList.java
 * Author: Abhijeet C 
 * Course: Practice clean code
 * Assignment: java_assignment
 * Due Date: none
 * Version: 1.0
 *
 * Brief description of the class goes here. This class provides functionalities
 * for implementing a singly linked list.
 */
public class TheLinkedList {

    private Node head;
    private Node tail;
    private int length;

    /**
     * Inner class representing a node in the linked list.
     */
    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    /**
     * Main method for testing the functionality of the linked list.
     */
    public static void main(String[] args) {

        var myLinkedList = new TheLinkedList(1);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.append(4);

        System.out.println("Linked List before reverse():");
        myLinkedList.printList();

        myLinkedList.reverse();

        System.out.println("\nLinked List after reverse():");
        myLinkedList.printList();

    }

    /**
     * Constructor to create a new linked list with a single node.
     *
     * @param value The value of the first node.
     */
    public TheLinkedList(int value) {
        var newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    /**
     * Retrieves the head node of the linked list.
     *
     * @return The head node.
     */
    public Node getHead() {
        return head;
    }

    /**
     * Retrieves the tail node of the linked list.
     *
     * @return The tail node.
     */
    public Node getTail() {
        return tail;
    }

    /**
     * Retrieves the length of the linked list.
     *
     * @return The length of the linked list.
     */
    public int getLength() {
        return length;
    }

    /**
     * Prints the elements of the linked list.
     */
    public void printList() {
        var temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    /**
     * Prints detailed information about the linked list, including head, tail, and length.
     */
    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nLinked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    /**
     * Empties the linked list by resetting head, tail, and length.
     */
    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    /**
     * Appends a new node with the given value to the end of the linked list.
     *
     * @param value The value to append.
     */
    public void append(int value) {
        var newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    /**
     * Removes and returns the last node from the linked list.
     *
     * @return The removed last node.
     */
    public Node removeLast() {
        if (length == 0) {
            return null;
        }
        var temp = head;
        var pre = head;
        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        length--;
        if (length == 0) {
            head = null;
            tail = null;
        }
        return temp;
    }

    /**
     * Prepends a new node with the given value to the beginning of the linked list.
     *
     * @param value The value to prepend.
     */
    public void prepend(int value) {
        var newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    /**
     * Removes and returns the first node from the linked list.
     *
     * @return The removed first node.
     */
    public Node removeFirst() {
        if (length == 0) {
            return null;
        }
        var temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if (length == 0) {
            tail = null;
        }
        return temp;
    }

    /**
     * Retrieves the node at the specified index in the linked list.
     *
     * @param index The index of the node to retrieve.
     * @return The node at the specified index, or null if index is out of bounds.
     */
    public Node get(int index) {
        if (index < 0 || index >= length) {
            return null;
        }
        var temp = head;
        for (var i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    /**
     * Sets the value of the node at the specified index in the linked list.
     *
     * @param index The index of the node to set.
     * @param value The value to set.
     * @return True if the value is set successfully, false otherwise.
     */
    public boolean set(int index, int value) {
        var temp = get(index);
        if (temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    /**
     * Inserts a new node with the given value at the specified index in the linked list.
     *
     * @param index The index at which to insert the new node.
     * @param value The value to insert.
     * @return True if the insertion is successful, false otherwise.
     */
    public boolean insert(int index, int value) {
        if (index < 0 || index > length) {
            return false;
        }
        if (index == 0) {
            prepend(value);
            return true;
        }
        if (index == length) {
            append(value);
            return true;
        }
        var newNode = new Node(value);
        var temp = get(index - 1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }

    /**
     * Removes and returns the node at the specified index in the linked list.
     *
     * @param index The index of the node to remove.
     * @return The removed node, or null if index is out of bounds.
     */
    public Node remove(int index) {
        if (index < 0 || index >= length) {
            return null;
        }
		if (index == 0) {
            return removeFirst();
        }
        if (index == length - 1) {
            return removeLast();
        }

        var prev = get(index - 1);
        var temp = prev.next;

        prev.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }

    /**
     * Reverses the linked list.
     */
    public void reverse() {
        var temp = head;
        head = tail;
        tail = temp;
        Node before = null;
        var after = temp;

        for (var i = 0; i < length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }

}
