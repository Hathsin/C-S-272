
/**
 * General interface for stack
 * @author Ben W.
 *
 * @param <E>
 */
public interface StackInterface<E> {
	
		void push(E element);
		E pop();
		E top();
		int size();
		boolean isEmpty();
	
}
