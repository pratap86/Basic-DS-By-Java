package Questions;

import StackLinkedList.Stack;

public class MaxItemStack {

	private Stack<Integer> mainStack;
	private Stack<Integer> maxStack;

	public MaxItemStack() {
		this.mainStack = new Stack<>();
		this.maxStack = new Stack<>();
	}

	public void push(int item) {
		// push new item into stack
		mainStack.push(item);
		// 1st item must same in both stacks
		if( mainStack.size() == 1 ) {
			maxStack.push(item);
			return;
		}
		// if the item is largest so far : we are inserted it in to maxstack
		if( item > maxStack.peek() ) {
			maxStack.push(item);
		}// else we duplicate push the item into maxStack
		else {
			maxStack.push(maxStack.peek());
		}
	}
	
	// remove the items from both stacks
	public int pop() {
		maxStack.pop();
		return mainStack.pop();
	}
	
	// get the max item -> last item into maxStack
	public int getMaxItem() {
		return maxStack.peek();
	}
	
}
