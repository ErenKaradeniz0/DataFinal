package BST_Traversal;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import BST_Traversal.binarySearchTree.BinarySearchTree;
import BST_Traversal.binarySearchTree.BinaryTreeInOrderTraverser;
import BST_Traversal.binarySearchTree.BinaryTreePreOrderTraverser;

public class BSTOperations {
	/**
	 * Generic Comparable sorting algorithm based on Binary Search Trees
	 * @param <Type> Any class that is comparable to itself or any superclass of itself
	 * @param array Array of values
	 */
	public static <Type extends Comparable<? super Type>> void BST_Sort(Type[] array) {
	//SEE LAB4, we have the same signature!!
		//insert values into the bst in array order
		BinarySearchTree<Type> bst = new BinarySearchTree<>();
		for(int i = 0; i < array.length; i++)
			bst.insert(array[i]);
		
		//traverse the bst using in-order traversal
		BinaryTreeInOrderTraverser<Type> traverser = new BinaryTreeInOrderTraverser<>(bst.getRoot());
		int i = 0;
		while(traverser.hasNext()) {
			//copy items into array in traversal order
			array[i++] = traverser.getNext().getData();
		}
	}
	
	public static <Type extends Comparable<? super Type>, Serializable> void serializeBST(BinarySearchTree<Type> bst, String filename) throws IOException {
		//write out node data in pre-order (Rlr) traversal order
		
		//we first place all data into an array list - this is done in pre-order 
		ArrayList<Type> list = new ArrayList<>();
		BinaryTreePreOrderTraverser<Type> traverser = new BinaryTreePreOrderTraverser<>(bst.getRoot());
		while(traverser.hasNext()) {
			Type data = traverser.getNext().getData();
			list.add(data);
		}
		
		//then we serialize the list into our file
		FileOutputStream fos = new FileOutputStream(filename);
		ObjectOutputStream output = new ObjectOutputStream(fos); //code for serialization
		output.writeObject(list);
		
		//close the streams
		fos.close();
		output.close();
	}
	
	@SuppressWarnings("unchecked")
	public static <Type extends Comparable<? super Type>, Serializable> BinarySearchTree<Type> deserializeBST(String filename) throws Exception{
		//read from the file one by one and insert into bst in file order
		
		//read the list from the serialization file
		FileInputStream fis = new FileInputStream(filename);
		ObjectInputStream input = new ObjectInputStream(fis);
		ArrayList<Type> list = (ArrayList<Type>) input.readObject();
		
		//insert list items into bst
		BinarySearchTree<Type> bst = new BinarySearchTree<>();
		while(!list.isEmpty()) {
			bst.insert(list.remove(0)); //since we used add (append), first item will be at index 0
		}
		
		//close the streams
		input.close();
		fis.close();
		return bst;
	}
	
	public static void main(String[] args) throws Exception{
		//sorting with BSTs
		Integer[] array = {60, 20, 70, 10, 40, 30, 50};
		
		System.out.println("Values before sorting: ");
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + ", ");
		}
		System.out.println();
		
		BST_Sort(array);
		System.out.println("Values after sorting: ");
		for(int i = 0; i < array.length; i++)
			System.out.print(array[i] + ", ");
		System.out.println();
		
		////////////////////////////////////////////////
		
		//creating a minimum height BST
		
		Integer[] array2 = {60, 20, 70, 10, 40, 30, 50};
		BinarySearchTree<Integer> insertOrderBST = new BinarySearchTree<>();
		for(int i = 0; i < array2.length; i++)
			insertOrderBST.insert(array2[i]);
		System.out.println("Regular BST: ");
		insertOrderBST.printTree();
		
		BST_Sort(array2);
		
		BinarySearchTree<Integer> minHeightBST = new BinarySearchTree<>(array2);
		System.out.println("Minimum height BST: ");
		minHeightBST.printTree();
		
        ////////////////////////////////////////////////
		
		//BST serialization and de-serialization
		
		Integer[] array3 = {60, 20, 70, 10, 40, 30, 50};
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		for(int i = 0; i < array3.length; i++)
			bst.insert(array3[i]);
		
		System.out.println("BST before serialization: ");
		bst.printTree();
		String filename = "myBST.dat";
		serializeBST(bst, filename);
		BinarySearchTree<Integer> bstDes = deserializeBST(filename);
		System.out.println("BST after serialization: ");
		bstDes.printTree();
	}
}
