package ll;

public class LinkedListSimple<T> {

	
 //First node in the list
	ListNode head;
 //Number of items in the list
	int size;
	
	public LinkedListSimple(T[] items) {
		size = items.length;
		ListNode temp = null;
		for(int i = items.length-1; i > 0; i--) {
			temp = new ListNode(items[i], temp);
		}
		head = new ListNode(items[0], temp);
	}
	
	private ListNode findNodeAtPosition(int index) throws IllegalArgumentException {
		
		
		return null;
	}
	
	
	private class ListNode {
		T rdata;
		ListNode nxt;
		
		//constructor
		ListNode(T data, ListNode nextRef){
			rdata = data;
			nxt = nextRef;
		}
		
	} // only here does anyone know about the listNode
	
}
