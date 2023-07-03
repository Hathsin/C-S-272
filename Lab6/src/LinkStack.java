

/**
 * Implementation of Stack interface using Singly Linked nodes
 * @author Ben W.
 *
 * @param <E>
 */
public class LinkStack<E> implements StackInterface<E> {
	public SNode<E> x;
	
	/**
	 * no-argument constructor for LinkStack
	 */
	public LinkStack() {
		x = null;
	}
	
	/**
	 * Pushes item onto stack
	 */
	@Override
	public void push(E element) {
		SNode<E> tmp = new SNode<E>(element, x);
		x = tmp;
	}
	
	/**
	 * Returns item from top of stack
	 */
	@Override
	public E pop() {
		if(x == null) {
			return null;
		}
		E popped = x.getData();
		x = x.getNode();
		return popped;
	}
	
	/**
	 * returns the most recently added value in the stack, without removing it from the stack
	 */
	@Override
	public E top() {
		if(x == null) {
		return null;
	}
		return x.getData();	
	}

	/**
	 * returns number of elements in the stack
	 */
	@Override
	public int size() {
		int count = 0;
		if(x == null) {
			return count;
		}
		SNode<E> cursor = x;
		while(cursor != null) {
			cursor = cursor.getNode();
			count++;
		}
		return count;
	}
	
	/**
	 * returns true if the stack is empty, false if not. 
	 */
	@Override
	public boolean isEmpty() {
		if(x == null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * copies the LinkStack and returns refrence to top node
	 * @return
	 */
	public LinkStack<E> copy(){
		LinkStack<E> dupe = new LinkStack<E>();
		if(x == null) {
			return dupe;
		}
		SNode<E> cursor = x;
		while(cursor != null) {
			dupe.push(cursor.getData());
			cursor = cursor.getNode();
		}
		return dupe;
	}
	
}

