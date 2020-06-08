package Questions;
/**
 * Implement a Queue, with the help of single stack
 * @author 835698
 *
 */

import StackLinkedList.Stack;

public class OneStackQueue {

	private Stack<Integer> stack;
	
	public OneStackQueue() {
		this.stack = new Stack<Integer>();
	}
	
	// enqueue operation, o(1)
	public void enqueue(int item) {
		this.stack.push(item);
	}
	
	// dequeue operation: we use 2 stacks again but instead of explicitly define second stack,
	// we use call stack of program (stack memory or execution stack)
	public int dequeue() {
		
		// base-case, for recursive method call
		if(stack.size() == 1) {
			return stack.pop();
		}
		// popping the item until, we can't get last item
		int item = stack.pop();
		
		// we call method recursively
		int lastDequeueItem = dequeue();
		
		//after find the item for dequeue, we have to inserted item one by one from call stack
		enqueue(item);
		
		return lastDequeueItem;
	}

}
