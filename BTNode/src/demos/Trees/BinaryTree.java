package demos.Trees;

public class BinaryTree<T> {

	//attributes
	private BTNode<T> root;
	
	//constructors
	public BinaryTree() {
		root = new BTNode<T>(null, null, null);
	}
	
	public BinaryTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {
		root = new BTNode<T>(rootData, null, null);
		if(leftTree != null) root.left = leftTree.root;
		if(rightTree != null) root.right = rightTree.root;
		
	}
	
	public int size() {
		return size(root);
	}
	private int size(BTNode<T> root) {
		if(root == null) return 0;
		return (1 + size(root.left) +size(root.right));
	}
	
	
	public int height() {
		return height(root);
	}
	
	private int height(BTNode<T> root) {
		if(root == null) return 0;
		return (1 + Math.max(height(root.left), height(root.right)));
	}
	
	

	
	//private classes
	private class BTNode<T>{
		
		
		
		
		
		public T data;  // a ref. to our data
		public BTNode<T> left;   // left child node
		public BTNode<T> right;  // right child node
		
		//constructor
		public BTNode(T data, BTNode<T>  left, BTNode<T> right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
		
		public T getData() {
			return (T) root.data;
		}
	/**	
		public void setData(T data) {
			root.data = data; //ask albing
		}
		
		public BTNode<T> addNodeLeft(T data){
			root.left = new BTNode<T>(data, null, null);
		
		}
		
		public BTNode<T> addNodeRight(T data){
			root.right = new BTNode<T>(data, null, null);
		}
	**/
	}
}
