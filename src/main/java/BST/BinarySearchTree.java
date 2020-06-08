package BST;

/**
 * 
 * @author Pratap Narayan
 *
 * @param <T>
 */
public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {

	// we are started from root node
	private Node<T> root;

	@Override
	public Node<T> getRoot() {
		return this.root;
	}
	
	@Override
	public void insert(T data) {

		if (root == null) {
			// this is the first node
			root = new Node<T>(data);
		} else {
			insertNode(data, root);
		}

	}

	@Override
	public T getMinValue() {
		if (root == null) {// if tree is empty
			return null;
		}
		return getMin(root);
	}

	@Override
	public T getMaxValue() {
		if (root == null) {
			return null;
		}
		return getMax(root);
	}

	@Override
	public void traversal() {
		
		if( root != null ) {
			inorderTraversal(root);
		}
	}

	private void inorderTraversal(Node<T> node) {

		if( node.getLeftChild() != null ) {
			inorderTraversal(node.getLeftChild());
		}
		
		System.out.print(node+" --> ");
		
		if( node.getRightChild() != null ) {
			inorderTraversal(node.getRightChild());
		}
		
	}

	private Node<T> delete(Node<T> node, T data) {

		if(node == null) {
			return node;
		}
		
		if( data.compareTo(node.getData()) < 0 ) {
			
			node.setLeftChild( delete(node.getLeftChild(), data) );
			
		} else if( data.compareTo(node.getData()) > 0 ) {
			
			node.setRightChild( delete(node.getRightChild(), data) );
			
		} else {
			
			// we have found the node, we want to remove
			if( node.getLeftChild() == null && node.getRightChild() == null ) {
				System.out.println("Removing leaf node..");
				return null;
			}
			if( node.getLeftChild() != null ) {
				System.out.println("Removing the right child..");
				Node<T> tempNode = node.getRightChild();
				node = null;
				return tempNode;
			}
			if( node.getRightChild() == null ) {
				System.out.println("Removing the left child..");
				Node<T> tempNode = node.getLeftChild();
				node = null;
				return tempNode;
			}
			// this is the node with two children's
			System.out.println("Removing item with two children");
			// get the predecessor - highest element in left sub tree
			Node<T> tempNode = getPredecessor(node.getLeftChild());
			// swap items
			node.setData(tempNode.getData());
			node.setLeftChild( delete(node.getLeftChild(), tempNode.getData()) );
			
		}
		
		return node;
	}
	
	private Node<T> getPredecessor(Node<T> node) {
		
		if( node.getRightChild() != null ) {
			return getPredecessor(node.getRightChild());
		}
		
		return node;
	}

	private void insertNode(T newData, Node<T> root) {

		if (newData.compareTo(root.getData()) < 0) {
			// consider left sub tree
			if (root.getLeftChild() != null) {
				// call insertNode() recursively
				insertNode(newData, root.getLeftChild());
			} else {
				Node<T> newNode = new Node<T>(newData);
				// update the reference
				root.setLeftChild(newNode);
			}

		} else {
			if (root.getRightChild() != null) {
				// call insertNode() recursively
				insertNode(newData, root.getRightChild());
			} else {
				Node<T> newNode = new Node<T>(newData);
				root.setRightChild(newNode);
			}
		}

	}

	@Override
	public void delete(T data) {

		if( root != null )
			root = delete(root, data);
	}


	private T getMax(Node<T> node) {
		// go with Right sub tree, as for as possible
		if (node.getRightChild() != null) {
			return getMax(node.getRightChild());
		}
		return node.getData();
	}

	private T getMin(Node<T> node) {
		// go with Left sub tree, as for as possible
		if (node.getLeftChild() != null) {// call recursively ie. go with Left sub tree, as for as possible
			return getMin(node.getLeftChild());
		}
		return node.getData();
	}

}
