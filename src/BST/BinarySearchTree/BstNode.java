package BST.BinarySearchTree;

public class BstNode<Type> {

	protected Type data;
	protected BstNode<Type> left;
	protected BstNode<Type> right;
	
	public BstNode(Type data) {
		this.data = data;
		left = right = null;
	}
	
	public BstNode(Type data, BstNode<Type> left, BstNode<Type> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
	public Type getData() 
	{
		return data;
	}
	
	public String toString() {
		return data.toString();
	}
}
