package Questions;

public class TwoStacksQueueApp {

	public static void main(String[] args) {

		TwoStacksQueue queue = new TwoStacksQueue();
		
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		
		System.out.println(queue.dequeue());
		
		queue.enqueue(100);
		
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
//		System.out.println(queue.dequeue());
	}

}
