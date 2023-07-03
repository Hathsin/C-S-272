

/**
 * Implementation of Queue interface using array
 * @author Ben W.
 *
 * @param <E>
 */
public class ArrayQueue<E> implements QueueInterface<E> {
	
	/**
	 * no-argument constructor for array queue
	 */
	@SuppressWarnings("unchecked")
	public ArrayQueue() {
		arr = (E[]) new Object[10];
		count = 0;
	}
	
	/**
	 * constructor setting initial capacity of array
	 * @param initial - int, initializes size of array
	 */
	@SuppressWarnings("unchecked")
	public ArrayQueue(int initial) {
		if (initial < 0)
	         throw new IllegalArgumentException
	         ("initialCapacity is negative: " + initial);
		count = 0;
		arr = (E[]) new Object[initial];
	}

	E[] arr;
	int count;
	int front;
	int back;

	/**
	 * Puts item in back of queue.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void enqueue(E element) {		
		if(count == arr.length) {
			E[] big = (E[]) new Object[2 * count + 1];
			if (back < front) {
				 int n1 = arr.length - front;
		         int n2 = back + 1;
		         System.arraycopy(arr, front, big, 0, n1);
		         System.arraycopy(arr, 0, big, n1, n2);
		         front = 0;
		         back = count; 
			}
			else if(count == 0) {
				
			}
			else {
				System.arraycopy(arr, front, big, 0, count);
				back = count;
			}
			arr = big;
		}
		arr[back] = element;
		count++;
		if(back + 1 == arr.length ) {
			back = 0;
		}
		else {
			back++;
		}
		
	}

	/**
	 * returns the first item in the queue
	 */
	@Override
	public E dequeue() {
		if(count == 0) {
			return null;
		}
		E hold = arr[front];
		count--;
		if(front + 1 == arr.length) {
			front = 0;
		}
		else {
			front++;
		}
		return hold;
	}

	/**
	 * returns the first value in the queue, without removing it from the queue
	 */
	@Override
	public E front() {
		if(count == 0) {
			return null;
		}
		return arr[front];
	}

	/**
	 * returns number of elements in the queue
	 */
	@Override
	public int size() {
		return count;
	}

	/**
	 * returns true if the queue is empty, false if not. 
	 */
	@Override
	public boolean isEmpty() {
		if(count == 0) {
			return true;
		}
		return false;
	}	
}

