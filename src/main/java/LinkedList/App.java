package LinkedList;

public class App {

	public static void main(String[] args) {

		List<String> names = new LinkedList<String>();
		names.insert("A");
		names.insert("B");
		names.insert("C");
		names.insert("D");
		names.insert("E");
		
		System.out.println(names.size());
		
//		names.remove("C");
		
		System.out.println("Middle Node : "+ names.getMiddleNode());
		names.reverse();
		
		names.traverseList();
		
	}

}
