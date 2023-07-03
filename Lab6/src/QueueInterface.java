/**
 * general interface for Queue
 * 
 * @author Ben W.
 *
 * @param <E>
 */
public interface QueueInterface<E> {
	void enqueue(E element);
	E dequeue();
	E front();
	int size();
	boolean isEmpty(); 
}
