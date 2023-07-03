


/**
 * Implementation of Queue interface using Singly Linked nodes
 * @author Ben W.
 *
 * @param <E>
 */
public class LinkedQueue<E> implements QueueInterface<E> {
	SNode<E> front = new SNode<E>();
	SNode<E> end = new SNode<E>();
	int count;
	
	/**
	 * no-argument constructor for linkedQueue
	 * links front to end
	 */
	public LinkedQueue() {
		front.setNode(end);
		count = 0;
	}
	

		
		
	/**
	 *	Puts item in back of queue.
	 */
	@Override
	public void enqueue(E element) {
		if(front.getData() == null) {
			front.setData(element);
		}
		else if(end.getData() == null) {
			end.setData(element);
			}
		else {
			SNode<E> tmp = new SNode<E>(element, null);
			end.setNode(tmp);
			end = tmp;
		}
		count++;
	}
		

	/**
	 * returns the first item in the queue
	 */
	@Override
	public E dequeue() {
		E hold = front.getData();
		if (front.getNode() == null) {
			front= new SNode<E>();
			count = 0;
		}
		else {
			front = front.getNode();
			count--;
		}
		return hold;
	}
	
	/**
	 * returns the first value in the queue, without removing it from the queue
	 */
	@Override
	public E front() {
		if(front == null) {
			return null;
		}
		E hold = front.getData();
		return hold;
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
