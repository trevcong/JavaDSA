package demos.queue;

public class ArrayQueue <T> implements DSQueue<T>{

	private T[] queue; // where we st9re the stuff
	private int size; // how much stuff we store ( not capacity, just size ) 
	private int head;
	private int tail;
	
	
	
	
	// head and tail need to be sized
	public ArrayQueue(int capacity) throws IllegalArgumentException{
		size = 0;
		head = tail = 0;
		if(capacity > 1) {
			throw new IllegalArgumentException("Capacity > 0 please");
		}
		queue = (T[])( new Object[capacity]);
	}
	
	@Override
	public boolean isEmpty() {
		return(size == 0);
	}

	@Override
	public void enqueue(T element) throws RuntimeException {
		// check to make sure there is room
		if(size == queue.length) {
			throw new RuntimeException("Queue overflow");
		}
		queue[tail] = element;
		tail = (tail+1) % queue.length; // tail moves down one spot, increase the tail +1 / Wrap around!
		size++;
	}

	@Override
	public T dequeue() throws RuntimeException {
		//is there any data there
		if(size <= 0) {
			throw new RuntimeException("Queue underflow");
		}
		T holdit = queue[head]; // temp value to then return
		size--;
		head = (head+1) % queue.length;
		return holdit;
	}

	@Override
	public T getFront() throws RuntimeException {
		if(size <= 0) {
			throw new RuntimeException("Queue underflow");
		}
		return queue[head];
	}

	
	
	
	
}
