package BST_Traversal.binarySearchTree;

import java.util.Stack;

public class BinaryTreePostOrderTraverser<Type> {
	private Stack<BinaryNode<Type>> stack;
	
	public BinaryTreePostOrderTraverser(BinaryNode<Type> root) {
		stack = new Stack<>();
		if(root != null) {
			stack.push(root);
			while(root.left != null) { //keep pushing until the left-most child of root is reached 
				stack.push(root.left);
				root = root.left;
			}
		}
	}
	
	public boolean hasNext() {
		return !stack.isEmpty();
	}
	
	//postorder: left - right - Root
	public BinaryNode<Type> getNext() {
		BinaryNode<Type> retVal = stack.pop();
		//all nodes to the left of retVal has been processed already
		//the next step will be to push the right sibling of retVal 
		//onto stack, if such a sibling exists. current top of the 
		//stack should be retVal's parent. and retVal's sibling can 
		//be accessed through this parent. 
		BinaryNode<Type> parent = null;
		if(!stack.isEmpty())
			parent = stack.peek(); //parent of retVal
		//we want to keep the parent in the stack, that is why we peeked above (instead of popping)
		if(parent != null && retVal == parent.left) {
			/* notice that parent will be hit twice (once when returning the left child, and once again when returning the right child)
			 * the clause retVal == parent.left checks for the first hit.
			 * if retVal is the left of its parent, we insert its right sibling and
			 * the leftwards path of the right sibling onto the stack.
			 * this way, we ensure that the parent is processed only after its right subtree. 
			 */
			BinaryNode<Type> curr = parent.right;
			while(curr != null) {
				stack.push(curr); //push the right sibling and traverse the tree leftwards
				curr = curr.left;
			}
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
		
		BinaryTreePostOrderTraverser<Integer> traverser = new BinaryTreePostOrderTraverser<>(bst.getRoot());
		System.out.println("Postorder: ");
		while(traverser.hasNext()) {
			BinaryNode<Integer> node = traverser.getNext();
			System.out.print(node.data + ", ");
		}
		//10, 30, 50, 40, 20, 70, 60
		System.out.println();
	}
}
