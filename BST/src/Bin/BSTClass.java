package Bin;

public class BSTClass<T extends > {

	
	private BTNode<T> findData(T target{
		findData(data, root);
		return null;
		
		
		
		
	}
	
	
	private BTNode<T> findData(T target, BTNode<T> current){
		if((current == null) || current.data.compareTo(target) == 0) {
			return current;
		}
		if(current.data.compareTo(target) > 0) {
			return findData(target, current.left);
		}
		return findData(target, current.right);
	}
	
	public BTNode<T> findDataIteritive(T target) {
		BTNode<T> current = root;
		while(current != null) {
			if(current.data.compareTo(target) == 0) {
				return current;
			}
			if(target.compareTo(current.data) < 0 ) {
				current = current.left;
			}else {
				current = current.right;
			}
															
		}
		return null;
	}
	
	
	
}
