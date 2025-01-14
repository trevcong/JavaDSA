package HeapsCA;

/**
 * Example implementation of a binary MaxHeap
 * 
 * @author gosnat
 *
 * @param <T>
 */
public class BinaryMaxHeap<T extends Comparable<? super T>> {
	/** The actual heap storage */
	private T[] heap;

	/** Number of items in the heap, doubles as index of next open spot in array */
	private int size;

	/**
	 * Constructor
	 * 
	 * @param capacity max number of items this heap can hold
	 */
	public BinaryMaxHeap(int capacity) {
		heap = (T[]) (new Comparable[capacity]);
		size = 0;
	}

	/**
	 * Constructor Note this uses the supplied array as our heap storage, not a copy
	 * 
	 * @param array Turn this array into a minHeap
	 */
	public BinaryMaxHeap(T[] array) {
		buildHeap(array);
		size = array.length;
	}

	/**
	 * 
	 * @return true if there are no items in the heap, false otherwise
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * 
	 * @return the maximum item in this heap
	 * @throws IllegalStateException if the heap is empty
	 */
	public T findMax() throws IllegalStateException {
		if (isEmpty()) {
			throw new IllegalStateException("Empty heap has no max");
		}
		
		return heap[0];
	}

	/**
	 * Insert the specified item into the heap and percolate as needed
	 * 
	 * @param item the new element to place in the heap
	 */
	public void insert(T item) {
		
		
	}

	/**
	 * remove the maximum item in the heap
	 * 
	 * @return the former maximum item in the heap
	 * @throws IllegalStateException if the heap is empty
	 */
	public T deleteMax() throws IllegalStateException {
		if (isEmpty()) {
			throw new IllegalStateException("Empty heap has no max");
		}
		T maxItem = heap[0];   // hold onto the top one
		heap[0] = heap[size-1];  // put the last one first
		size--;   // make size smaller
		percDown(0);  // fix the order of things
		
		return maxItem;
		
	} 

	/**
	 * Percolate the item at the specified index as far as appropriate
	 * 
	 * @param curIndex index of item that needs to be percolated down
	 */
	private void percDown(int curIndex) {
		
	}


	/**
	 * Turn an unsorted array into a maxHeap. Note that incoming array becomes this
	 * heap, so no copy/clone is produced. We alter the original.
	 * 
	 * @param array the array of values we want to turn into a heap
	 */
	public void buildHeap(T[] array) {
		heap = array;
		size = array.length;
		for(int i = (size-1 -1)/2; i>=0;i++ ) {
			percDown(i);
		}
	}

	/**
	 * Perform in-place heapsort algorithm
	 * 
	 * @param array the array you wish to sort
	 */
	public static <Type extends Comparable<? super Type>> void 
	heapSort(Type[] array) {
		BinaryMaxHeap<Type> bmh = new BinaryMaxHeap<Type>(array);
		for(int i=array.length-1; i > 0; i--) {
			array[i] = bmh.deleteMax();
		}
		
	}

}