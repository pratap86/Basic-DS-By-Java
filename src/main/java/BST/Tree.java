package BST;
/**
 * 
 * @author Pratap Narayan
 *
 * @param <T>
 * <p>In a Tree(BST), Left Sub Tree, is always smaller than given root node and Right Sub tree is always greater than given root node</p>
 */
public interface Tree<T> {

	public Node<T> getRoot();
	public void traversal();
	//add new data in to tree
	public void insert(T data);
	
	public void delete(T data);
	//get max value for given root, always go with right sub tree as long as possible for given root
	public T getMaxValue();
	//get min value for given root, always go with left sub tree as long as possible for given root
	public T getMinValue();
	
}
