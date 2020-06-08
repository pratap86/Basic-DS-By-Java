package Queue;
/*
 * @Author Pratap Narayan
 * <p>Queue, contains two ends ie front-end and rear-end, from rear-end, we can perform enqueue operation while front-end we can 
 * perform dequeue operation, implemented this feature via firstNode(front-end) & lastNode(rear-end)</p>
 */
public class Queue<T extends Comparable<T>> {

	private Node<T> firstNode;
	private Node<T> lastNode;
	private int count;
	
	public boolean isEmpty() {
		return this.firstNode == null;
	}
	
	public int size() {
		return this.count;
	}
	// o(1)
	public void enqueue(T newData) {
		
		this.count++;
		Node<T> oldLastNode = this.lastNode;
		this.lastNode = new Node<T>(newData);
		this.lastNode.setNextNode(null);
		// update the reference
		if(isEmpty()) {
			this.firstNode = this.lastNode;
		}
		else {
			oldLastNode.setNextNode(lastNode);
		}
		
	}
	
	// o(1)
	public T dequeue() {

		this.count--;
		T dataToDequeue = this.firstNode.getData();
		// Now update the firstNode
		this.firstNode = this.firstNode.getNextNode();
		if (isEmpty()) {
			this.lastNode = null;
		}
		return dataToDequeue;

	}
}
