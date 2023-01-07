package BST_Traversal.binarySearchTree;

import java.util.Stack;

public class BinaryTreePreOrderTraverser<Type> {
	private Stack<BinaryNode<Type>> stack;
	
	public BinaryTreePreOrderTraverser(BinaryNode<Type> root) {
		stack = new Stack<>();
		if(root != null) {
			stack.push(root); //push the root such that it is processed next
		}
	}
	
	public boolean hasNext() {
		return !stack.isEmpty();
	}
	
	//preorder: Root - left - right
	public BinaryNode<Type> getNext() {
		BinaryNode<Type> retVal = stack.pop(); //root is taken care of
		//need to push left and right of retVal into stack
		//right is pushed first so that it is popped after left
		if(retVal.right != null)
			stack.push(retVal.right);
		if(retVal.left != null)
			stack.push(retVal.left);
		return retVal;
	}
	
	public static void main(String[] args) {
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		bst.insert(60);
		bst.insert(20);
		bst.insert(70);
		bst.insert(10);
		bst.insert(40);
		bst.insert(30);
		bst.insert(50);
		bst.printTree();
		
		BinaryTreePreOrderTraverser<Integer> traverser = new BinaryTreePreOrderTraverser<>(bst.getRoot());
		System.out.println("Preorder: ");
		//60, 20, 10, 40, 30, 50, 70
		while(traverser.hasNext()) {
			BinaryNode<Integer> node = traverser.getNext();
			System.out.print(node.data + ", ");
		} 
		System.out.println();
	}
}
