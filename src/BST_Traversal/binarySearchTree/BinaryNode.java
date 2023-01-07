package BST_Traversal.binarySearchTree;

public class BinaryNode<Type> {
	protected Type data;
	protected BinaryNode<Type> left;
	protected BinaryNode<Type> right;
	
	public BinaryNode(Type data) {
		this.data = data;
		left = right = null;
	}
	
	public BinaryNode(Type data, BinaryNode<Type> left, BinaryNode<Type> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
	public Type getData() {
		return data;
	}
	
	public String toString() {
		return data.toString();
	}
}
