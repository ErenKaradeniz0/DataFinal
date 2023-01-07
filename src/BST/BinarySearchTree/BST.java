package BST.BinarySearchTree;

public class BST<Type extends Comparable<? super Type>> {
	
private BstNode<Type> root;
	
	public BST() {
		root = null;
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public void makeEmpty() {
		root = null;
	}
	
	/**
	 * Searches for the specified key in this BST
	 * @param key Value to be searched
	 * @return true if key appears as a node in the BST, false otherwise 
	 */
	public boolean contains(Type key) {
		return find(key, root) == null;
	}
	
	/**
	 * Searches for the node that contains the specified key in this BST
	 * @param key The data to be located
	 * @return Reference of the node containing the key
	 */
	public BstNode<Type> find(Type key) {
		return find(key, root);
	}
	
	/**
	 * Finds the node that contains the smallest data in the BST
	 * @return Reference to the min-data node in the BST
	 */
	public BstNode<Type> findMin() {
		return findMin(root);
	}
	
	public BstNode<Type> findMax() {
		return findMax(root);
	}
	
	public void insert(Type data) {
		root = insert(data, root);
	}
	
	public void remove(Type data) {
		root = remove(data, root);
	}
	
	public void printTree() {
		if(isEmpty()) {
			System.out.println("Empty tree");
		} else {
			printTree(root, 0);
		}
	}
	
	private BstNode<Type> find(Type key, BstNode<Type> subTree) {		
		if(subTree == null) {
			return null;
		} 
		int comparison = key.compareTo(subTree.data);
		if (comparison == 0) { //match
			return subTree;
		} else if(comparison < 0) { //left
			return find(key, subTree.left);
		} else //right
			return find(key, subTree.right);
	}
	
	private BstNode<Type> findMin(BstNode<Type> subTree) {
		if(subTree == null) {
			return null;
		} else if(subTree.left == null) {
			return subTree;
		}
		return findMin(subTree.left);
	}
	
	private BstNode<Type> findMax(BstNode<Type> subTree) {
		if(subTree == null) {
			return null;
		}
		while(subTree.right != null)
			subTree = subTree.right;
		return subTree;
	}
	
	private BstNode<Type> insert(Type data, BstNode<Type> subTree) {
		if(subTree == null) {
			return new BstNode<>(data);
		}
		
		int comparison = data.compareTo(subTree.data); 
		if(comparison == 0) {
			//duplicate - do nothing
		} else if(comparison < 0) { //left
			subTree.left = insert(data, subTree.left);
		} else { //right
			subTree.right = insert(data, subTree.right);
		}
		return subTree;
	}
	
	private BstNode<Type> remove(Type data, BstNode<Type> subTree) {	
		if( subTree == null) { //data not found, therefore, not removed
			return subTree; 
		}
		
		int comparison = data.compareTo(subTree.data); 
		if(comparison < 0) {
			subTree.left = remove(data, subTree.left);
		} else if(comparison > 0) {
			subTree.right = remove(data, subTree.right);
		} else {
			//data = curr.data
			if(subTree.left != null && subTree.right != null) { //has both two children
				//replace with either min of right or max of left
				//will replace with min of right
				subTree.data = findMin(subTree.right).data;
				subTree.right = remove(subTree.data, subTree.right);
			} else if(subTree.left != null) {
				subTree = subTree.left;
			} else { //curr.right != null
				subTree = subTree.right;
			}
		}
		return subTree;
	}
	
	private void printTree(BstNode<Type> subTree, int level) {
		if(subTree != null) {
			for(int i = 0; i < level; i++) 
				System.out.print("\t");
			System.out.println(subTree.data);
			printTree(subTree.left, level+1);
			printTree(subTree.right, level+1);
		}
	}

}
