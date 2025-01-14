package linkedlist;
/**
 * This is a sorted linked list class able to delete and add items to a linked list per user instructions
 * @author Trevor Conger
 *
 * @param <T> This is a generic class that will be taking in the comparable interface
 */
public class SortedLinkedList<T extends Comparable<? super T>> {
	/**
	 * Attribute for the head of the list of type ListNode
	 */
	private ListNode head; 
	/**
	 * Attribute for the size of the list of type int
	 */
	private int size;
	/**
	 * Attribute for the tail of the list, of type ListNode
	 */
	private ListNode tail;
	/**
	 * A constructor to create the list, this will make the size = 0, and the head and tail will
	 * be correctly positioned. 
	 */
	public SortedLinkedList(){
		size = 0;
		tail = new ListNode(null, null); 
		head = new ListNode(null, tail);
	}
	/**
	 * Add item method to add items to the LinkedList
	 * @param data Will take in a generic T data type to add to the list
	 */
	public void addItem(T data){
		
		ListNode current = head.next;
		ListNode previous = head;
		
		while(current != tail) {
			if(current.data.compareTo(data) < 0) { // if current is less than 0 ( move to next list node ) 
				previous = current;
				current = current.next;
			}else {
				ListNode newListNode = new ListNode(data, current); 
				previous.next = newListNode;
				size++;
				return;
			}
		}
		ListNode newListNode = new ListNode(data, current); 
		previous.next = newListNode;
		size++;
		return;
	}
	/**
	 * Delete item method to delete items from the linked list
	 * @param data Will take in the data that it wants to delete and will compare it to the list till it finds the item
	 * @throws IllegalArgumentException Will throw an IllegalArgumentException if the item is not in the list
	 */
	public void deleteItem(T data) throws IllegalArgumentException{ // current.data , once we find current node to delete, previous.next = current.next size--;
		
		ListNode current = head.next;
		ListNode previous = head;
		int oldSize = size;
		for(int i = 0; i < size; i++) {
			if(current.data.compareTo(data) == 0) {
				previous.next = current.next;
				size--;
				return;
			}
			current = current.next;
			previous = previous.next;
		}
		if(oldSize == size) {
			throw new IllegalArgumentException("This item is not in the list");
		}
	}
	/**\
	 * This method will print out the list to show the user
	 */
	public String toString() {
		ListNode current = head.next;
		String tests = "";
		tests += "Size: " + size + "\n";
		for(int i = 0; i < size; i++) {
				tests += i + ":\t" + current.data + "\n";
				current = current.next;
		}
		return tests;
	}
	/**
	 * Class for the ListNode
	 * @author Trevor Conger
	 *
	 */
	private class ListNode  {
		/**
		 * Generic T for the data
		 */
		public T data;
		/**
		 * Attribute for the next item of type ListNode
		 */
		public ListNode next;
		/**
		 * Constructor to made the list nodes for the class above
		 * @param data Data that will be used in the node for the linked list
		 * @param next the next position in the list to keep track
		 */
		public ListNode(T data, ListNode next) {
			this.data = data;
			this.next = next;
		}
	}
	
}

