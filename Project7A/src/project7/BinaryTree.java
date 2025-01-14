package project7;

public class BinaryTree<T>{

	//attributes
	private BTNode<String> root;

	private BTNode<String> current;
	
	//constructors
	public BinaryTree() {
		root = new BTNode<String>(null, null, null);
	}
	
	public BinaryTree(String rootData, BTNode<String> leftTree, BTNode<String> rightTree) {
		root = new BTNode<String>(rootData, null, null);
		if(leftTree != null) root.left = leftTree;
		if(rightTree != null) root.right = rightTree;
		
	}
	/**
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
	
	
	
	
	
	
	
	
	
	**/
	public BTNode<String>  getRoot() {
		return root;
	}

	public String getData() {
		return root.data;
	}

	public void setData(String data) {
		root.data = data; 
	}
	
	public void addNodeLeft(String data){
		if(current.left != null) current = current.left;
	}
	
	public void addNodeRight(String data){
		if(current.right != null) current = current.right;
	}
	
	public BTNode<String> getLeft() {
		return current.left;
	}
	
	public BTNode<String> getRight(){
		return current.right;
	}
	
	

	
	
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

		
	
	}
}
