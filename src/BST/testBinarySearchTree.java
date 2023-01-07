package BST;

import BST.BinarySearchTree.BST;
import BST.BinarySearchTree.BstNode;

public class testBinarySearchTree {

	public static void main(String[] args) {
		
		BST<Integer> bst = new BST<Integer>();
		bst.insert(10);
		System.out.println("BST after insert(10)");
		bst.printTree();
		bst.insert(20);
		System.out.println("BST after insert(20)");
		bst.printTree();
		bst.insert(30);
		System.out.println("BST after insert(30)");
		bst.printTree();
		bst.insert(60);
		System.out.println("BST after insert(60)");
		bst.printTree();
		bst.remove(30);
		System.out.println("BST after remove(30)");
		bst.printTree();
		
		System.out.println();
		BstNode<Integer> node = bst.find(30);
		if(node == null) 
			System.out.println("Result of find(30): null");
		node = bst.find(10);
		if(node != null)
			System.out.println("Result of find(10): " + node.getData());
		node = bst.findMin();
		if(node != null)
			System.out.println("Min = " + node.getData());
		node = bst.findMax();
		if(node != null)
			System.out.println("Max = " + node.getData());

	}

}
