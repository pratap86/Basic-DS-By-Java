package Questions;

public class AppMaxItem {

	public static void main(String[] args) {

		MaxItemStack maxItemStack = new MaxItemStack();
		
		maxItemStack.push(10);
		maxItemStack.push(3);
		maxItemStack.push(45);
		maxItemStack.push(43);
		
		System.out.println(maxItemStack.getMaxItem());
	}

}
