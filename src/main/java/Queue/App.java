package Queue;

public class App {

	public static void main(String[] args) {

		Queue<Integer> intQueue = new Queue<Integer>();
		intQueue.enqueue(10);
		intQueue.enqueue(100);
		intQueue.enqueue(1000);
		
		System.out.println("Queue size before dequeue "+ intQueue.size());
		
		System.out.println(intQueue.dequeue());
		System.out.println(intQueue.dequeue());
		System.out.println(intQueue.dequeue());
	}

}
