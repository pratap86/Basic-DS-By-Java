package LinkedList;

public class LinkedList<T extends Comparable<T>> implements List<T> {

	// In linked list, we are able to access only root node
	// perform any operation -> from root node
	private Node<T> root;
	private int sizeOfList;

	@Override
	public void insert(T data) {

		++this.sizeOfList;

		if (root == null) {
			this.root = new Node<>(data);
		} else {
			insertDataAtBegining(data);
		}
	}

//O(1)
	private void insertDataAtBegining(T data) {
		// update the references
		// 1. create new node
		Node<T> newNode = new Node<>(data);
		// 2.update next node
		newNode.setNextNode(root);
		// 3.now newNode is become root node
		this.root = newNode;
	}

// O(N)
	@SuppressWarnings("unused")
	private void insertDataAtEnd(T data, Node<T> node) {
		// traverse the LinkedList until not getting the last node
		if (node.getNextNode() != null) {
			insertDataAtEnd(data, node.getNextNode());
		} else {
			Node<T> newNode = new Node<T>(data);
			node.setNextNode(newNode);
		}
	}

	@Override
	public void remove(T data) {

		// case - 1
		if (this.root == null)
			return;

		--this.sizeOfList;

		// case - 2 : if root is that node, wants to get rid
		if (this.root.getData().compareTo(data) == 0) {
			// update the references
			this.root = this.root.getNextNode();
		} else { // case - 3
			remove(data, root, root.getNextNode());
		}
	}

	private void remove(T dataToRemove, Node<T> previousNode, Node<T> actualNode) {

		while (actualNode != null) {

			if (actualNode.getData().compareTo(dataToRemove) == 0) {
				previousNode.setNextNode(actualNode.getNextNode());
				actualNode = null;// eligible for GC
				return;// no need to further traverse
			}
			// traverse the Linked List one by one

			previousNode = actualNode;
			actualNode = actualNode.getNextNode();
		}
	}

	@Override
	public void traverseList() {

		if (root == null)
			return;
		
		Node<T> actualNode = this.root;
		while(actualNode != null) {
			System.out.print(actualNode + " - ");
			actualNode = actualNode.getNextNode();
		}
	}

	@Override
	public int size() {
		return this.sizeOfList;
	}

	@Override
	public Node<T> getMiddleNode() {

		Node<T> fastPointer = this.root;
		Node<T> slowPointer = this.root;
		
		while(fastPointer.getNextNode() != null && fastPointer.getNextNode().getNextNode() != null) {
			fastPointer = fastPointer.getNextNode().getNextNode();
			slowPointer = slowPointer.getNextNode();
		}
		
		return slowPointer;
	}

	@Override
	public void reverse() {

		// 3-pointers
		Node<T> currentNode = this.root;	//At the beginning current node pointed to the HEAD 
		Node<T> prevNode = null;
		Node<T> nextNode = null;
		
		while(currentNode != null) {
			nextNode = currentNode.getNextNode();
			currentNode.setNextNode(prevNode);
			prevNode = currentNode;
			currentNode = nextNode;
		}
		// finally update the HEAD
		this.root = prevNode;
	}

}
