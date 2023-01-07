package BST_Traversal.binarySearchTree;

import java.util.Stack;

public class BinaryTreeInOrderTraverser<Type> {
	private Stack<BinaryNode<Type>> stack;
	
	public BinaryTreeInOrderTraverser(BinaryNode<Type> root) {
		stack = new Stack<>();
		if(root != null) {
			stack.push(root);
			BinaryNode<Type> curr = root.left;
			while(curr != null) { //keep pushing curr until the left-most child of root is reached 
				stack.push(curr);
				curr = curr.left;
			}
		}
	}
	
	public boolean hasNext() {
		return !stack.isEmpty();
	}
	
	//inorder: left - Root - right
	public BinaryNode<Type> getNext() {
		BinaryNode<Type> retVal = stack.pop();
		//all nodes to the left of retVal has been processed
		//retVal will be processed upon return, so it is the current Root
		//next up should be retVal's right (if any)
		BinaryNode<Type> curr = retVal.right;
		while(curr != null) {
			//push curr and traverse the tree leftwards
			stack.push(curr);
			curr = curr.left;
		}
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
		
		BinaryTreeInOrderTraverser<Integer> traverser = new BinaryTreeInOrderTraverser<>(bst.getRoot());
		System.out.println("Inorder: ");
		while(traverser.hasNext()) {
			BinaryNode<Integer> node = traverser.getNext();
			System.out.print(node.data + ", ");
		}
		//10, 20, 30, 40, 50, 60, 70
		System.out.println();
	}
}
