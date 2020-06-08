package StackLinkedList;

public class Stack<T extends Comparable<T>> {

	private Node<T> root;
	private int count;

	// O(1)
	public void push(T newData) {
		++this.count;
		// Base-case
		if (root == null) {
			this.root = new Node<T>(newData);
		} else {
			Node<T> oldRoot = this.root;
			this.root = new Node<T>(newData);
			this.root.setNextNode(oldRoot);
		}
	}

	// O(1)
	public T pop() {

		T itemToPop = this.root.getData();
		// update reference
		this.root = this.root.getNextNode();
		// decrement the size
		this.count--;
		return itemToPop;
	}
	
	// O(1)
	public T peek() {
		return this.root.getData();
		// no need to update the reference & decrement the size
	}

	// O(1)
	public int size() {
		return this.count;
	}

	// O(1)
	public boolean isEmpty() {
		return this.root == null;
	}

}
