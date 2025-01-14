package inclass.heaps;

/**
 * Example implementation of a binary MaxHeap
 * 
 * @author gosnat, albing
 *
 * @param <T>
 */
public class BinaryMaxHeap<T extends Comparable<? super T>>
{
    /** The actual heap storage */
    private T[] heap;

    /** # of items in the heap, doubles as index of next open spot in array */
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
     * Constructor
     * Note this uses the supplied array as our heap storage, not a copy
     * 
     * @param array Turn this array into a maxHeap
     */
    public BinaryMaxHeap(T[] array) {
        buildHeap(array);
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

        int curIndex = size;
        int parent = (curIndex - 1) / 2;  // N.B.: integer division
        heap[curIndex] = item;
        size++;
        //while we aren't at the root and curIndex item is > than its parent...
        while (curIndex != 0 && heap[curIndex].compareTo(heap[parent]) < 0)
        {
            T temp = heap[curIndex];
            heap[curIndex] = heap[parent];
            heap[parent] = temp;
            curIndex = parent;
            parent = (curIndex - 1) / 2;
        }
    } // insert

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

        T maxItem = heap[0];
        heap[0] = heap[size - 1];
        size--;
        percDown(0);

        return maxItem;

    } // deleteMax

    /**
     * Percolate the item at the specified index as far as appropriate
     * 
     * @param curIndex index of item that needs to be percolated down
     */
    private void percDown(int curIndex) {
        int swapIndex;
        int leftChild;   // index of i's left child
        int rightChild;  // index of i's right child
        while (true) {
            leftChild = curIndex*2 + 1;
            rightChild= leftChild + 1; // i.e., curIndex*2 + 2
            if (leftChild >= size) {  // out of range = no children
                return;
            }
            swapIndex = curIndex;
            // there is a left child or we would have stopped already
            if (heap[leftChild].compareTo(heap[curIndex]) < 0) {
                swapIndex = leftChild;
            }

            if (rightChild < size) {// there is a right child also
                if (heap[rightChild].compareTo(heap[swapIndex]) > 0) {
                    swapIndex = rightChild;
                }
            }
            if (swapIndex == curIndex) {   // no change
                return;
            }

            T temp = heap[curIndex];
            heap[curIndex] = heap[swapIndex];
            heap[swapIndex] = temp;

            curIndex = swapIndex;

        } // endwhile

    } // percDown


    /**
     * Turn an unsorted array into a maxHeap. 
     * Note that incoming array becomes this heap, 
     * so no copy/clone is produced. We alter the original.
     * 
     * @param array the array of values we want to turn into a heap
     */
    public void buildHeap(T[] array) {
        heap = array;
        size = array.length;
        for (int i = (size - 1 - 1) / 2; i >= 0; i--) {
            percDown(i);
        }
    } // buildHeap

    /**
     * Perform in-place heapsort algorithm
     * 
     * @param array the array you wish to sort
     */
    public static <Type extends Comparable<? super Type>> void 
    heapSort(Type[] array)
    {
        BinaryMaxHeap<Type> bmh = 
                new BinaryMaxHeap<Type>(array);
        // the constructor will convert array to a heap
        // so now we just need to sort it:
        for (int i = array.length - 1; i > 0; i--) {
            array[i] = bmh.deleteMax();
        }
    } // heapSort

} // BinaryMaxHeap