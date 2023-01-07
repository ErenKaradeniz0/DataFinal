package BST_Traversal.binarySearchTree;

public class BinarySearchTree<Type extends Comparable<? super Type>> {
	private BinaryNode<Type> root;
	
	public BinarySearchTree() {
		root = null;
	}
	
	public BinarySearchTree(Type[] sortedArray) {
		root = createBST(sortedArray, 0, sortedArray.length-1);
	}
	
	private BinaryNode<Type> createBST(Type[] sortedArray, int start, int end) {
		if(start > end)
			return null;

		//root: binary search mid-point, left subtree will contain values to the left of root
		//  and right subtree will contain values to the right of root.
		int mid = (start + end) / 2;
		BinaryNode<Type> root = new BinaryNode<>(sortedArray[mid]);
		root.left = createBST(sortedArray, start, mid-1);
		root.right = createBST(sortedArray, mid+1, end);
		return root;
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public void makeEmpty() {
		root = null;
	}
	
	public BinaryNode<Type> getRoot() {
		return root;
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
	public BinaryNode<Type> find(Type key) {
		return find(key, root);
	}
	
	/**
	 * Finds the node that contains the smallest data in the BST
	 * @return Reference to the min-data node in the BST
	 */
	public BinaryNode<Type> findMin() {
		return findMin(root);
	}
	
	public BinaryNode<Type> findMax() {
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
	
	private BinaryNode<Type> find(Type key, BinaryNode<Type> subTree) {		
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
	
	private BinaryNode<Type> findMin(BinaryNode<Type> subTree) {
		if(subTree == null) {
			return null;
		} else if(subTree.left == null) {
			return subTree;
		}
		return findMin(subTree.left);
	}
	
	private BinaryNode<Type> findMax(BinaryNode<Type> subTree) {
		if(subTree == null) {
			return null;
		}
		while(subTree.right != null)
			subTree = subTree.right;
		return subTree;
	}
	
	private BinaryNode<Type> insert(Type data, BinaryNode<Type> subTree) {
		if(subTree == null) {
			return new BinaryNode<>(data);
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
	
	private BinaryNode<Type> remove(Type data, BinaryNode<Type> subTree) {	
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
	
	private void printTree(BinaryNode<Type> subTree, int level) {
		if(subTree != null) {
			for(int i = 0; i < level; i++) 
				System.out.print("\t");
			System.out.println(subTree.data);
			printTree(subTree.left, level+1);
			printTree(subTree.right, level+1);
		}
	}
}
