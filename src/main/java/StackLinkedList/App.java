package StackLinkedList;

public class App {

	public static void main(String[] args) {

		Stack<Integer> myStack = new Stack<Integer>();
		myStack.push(10);
		myStack.push(100);
		myStack.push(1000);
		
		System.out.println(" size before pop -> "+myStack.size());
		
		System.out.println(myStack.pop());
		System.out.println(myStack.pop());
		System.out.println(myStack.pop());
	}

}
