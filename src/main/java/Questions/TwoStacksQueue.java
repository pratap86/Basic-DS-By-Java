package Questions;
/**
 * 
 * @author 835698
 * implement a queue with the help of two stacks
 * one stack for enqueue operation, second stack for dequeue operation, now perform pop operation from dequeue stack 
 *
 */

import StackLinkedList.Stack;

public class TwoStacksQueue {
	
	// declare two stacks
	private Stack<Integer> enqueueStack;
	private Stack<Integer> dequeueStack;
	
	public TwoStacksQueue() {
		this.enqueueStack = new Stack<Integer>();
		this.dequeueStack = new Stack<Integer>();
	}
	
	// adding an item into enqueueStack O(1)
	public void enqueue(int item) {
		this.enqueueStack.push(item);
	}
	
	public int dequeue() {
		
		// base-case, if both stacks are empty
		if(enqueueStack.isEmpty() && dequeueStack.isEmpty()) {
			throw new RuntimeException("Stacks are empty ...");
		}
		// if only dequeueStack is empty, we have to add items o(N)
		if(dequeueStack.isEmpty()) {
			while(!enqueueStack.isEmpty()) {
				// copy the items from enqueueStack into dequeueStack
				dequeueStack.push(enqueueStack.pop());
			}
		}
		// otherwise we have to pop up items from dequeueStack
		return dequeueStack.pop();
	}
	

}
