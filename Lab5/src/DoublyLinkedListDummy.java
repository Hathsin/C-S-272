

/**
 * @author hathsin
 *
 */
public class DoublyLinkedListDummy {
	private DIntNode head;
	private DIntNode tail;
	
	 /**
	 * No argument Constructor
	 * Creates dummy head and tail node and links them together.
	 */
	public DoublyLinkedListDummy(){
			head = new DIntNode();
			tail = new DIntNode();
			head.setNext(tail);
			tail.setPrev(head);
	   }
	 
	
	/**
	  * Accessor method to get Head from this list. 
	  * @param - none  
	  * @return - the head for this list
	  */
	public DIntNode getHead() {
		   return head;
	   }

	/**
	  * Accessor method to get Tail from this list. 
	  * @param - none  
	  * @return - the tail for this list
	  */
	public DIntNode getTail() {
		   return tail;
	   }
	
	
	/**
	 * Modification method to set the Head in this list.   
	 * @param node: the new node to act as Head
	 **/
	public void setHead(DIntNode node) {
		   head = node;
	   }

	
	/**
	 * Modification method to set the Tail in this list.   
	 * @param node: the new node to act as Tail
	 **/
	public void setTail(DIntNode node) {
		   tail = node;
	   }
	 
	 
	 
	
	    /**
	     * toString method convert this list's information to a String, both forward and backward
	     */
	    public String toString() {
	    	String str = "(Forward) ";
	    	if(head.getNext() == null || head.getNext() == tail) {
	    		return  str + "\n(Backward) ";
	    	}
	    	DIntNode hold = head.getNext();
	    	str += hold.getData();
	    	hold = hold.getNext();
	    	while(hold != tail) {
	    		str += "<->" + hold.getData();
	    		hold = hold.getNext();
	    	}
	    	hold = tail.getPrev();
	    	str += "\n(Backward) ";
	    	str += hold.getData();
	    	hold = hold.getPrev();
	    	while(hold != head) {
	    		str += "<->" + hold.getData();
	    		hold = hold.getPrev();
	    	}
	    	
	    	
	    	return str;
	    }
	    
	
	    /**
	     * Count the number of times a int value exits in the list
	     * Time complexity of O(n)
	     * @param e - the int value to find
	     * @return the number of occourences of e
	     */
	    public int countOccurrence(int e) {
	    	int count = 0;
	    	DIntNode hold = head;
	    	if(hold.getData() == e) {
	    		count++;
	    	}
	    	hold = hold.getNext();
	    		
	    	while(hold != tail) {
	    		if(hold.getData() == e) {
	        		count++;
	        	}
	        	hold = hold.getNext();
	    	}
	    	return count;
	    }
	    
	    
	    /**
	     * remove all nodes with the data value e 
	     * Time complexity of O(n)
	     * @param e - the data value to remove
	     * @return true if data was removed, false if not. 
	     */
	    public boolean removeAll(int e) {
	    	boolean rem = false;
	    	DIntNode preCursor = head;
	    	DIntNode cursor = head.getNext();
	    	while(cursor != tail.getPrev()) {
		    	if (cursor.getData() == e) {
		    		cursor.getNext().setPrev(preCursor);
		    		preCursor.setNext(cursor.getNext());
		    		
		        	preCursor = cursor.getNext();
		        	cursor = preCursor.getNext();
		        	rem = true;
		    	}
		    	else {
		    		preCursor = preCursor.getNext();
		    		cursor = cursor.getNext();
		    	}
		    	
	    	}
	    	if (cursor.getData() == e) {
	    		cursor.getNext().setPrev(preCursor);
	    		preCursor.setNext(cursor.getNext());
	    		rem = true;
	    	}
	    	
	    	return rem;
	    }
	    
	
	    /**
	     * Removes all duplicate values in the list
	     * Time complexity of O(n^2)
	     * @return dummy head of new list
	     */
	    public DoublyLinkedListDummy removeDuplicates() {
	    	if(head.getNext() == tail) return this;
	    	DIntNode c1 = head.getNext();
	    	DIntNode c2 = c1.getNext();
	    	
	    	while(c1 != tail) {
	    		while(c2.getNext() != tail) {
	    			if(c1.getData() == c2.getData()) {
	    				c2.getPrev().setNext(c2.getNext());
	    				c2.getNext().setPrev(c2.getPrev());
	    			}
	    			c2 = c2.getNext();
	    		}
	    		if(c1.getData() == c2.getData()) {
    				c2.getPrev().setNext(tail);
    				tail.setPrev(c2.getPrev());
    			}
	    		c1 = c1.getNext();
	    	}
	    	
	    	
	    	
	    	
	    	return this;
	    }
	    
	    
	    /**
	     * prints all pairs of numbers where their sum equals the given integer
	     * @param l2 DoublyLinkedListDummy - head of list
	     * @param y int - value a pair must add to
	     */
	    public static void pairs(DoublyLinkedListDummy l2, int y) {
	    	DIntNode top = l2.head.getNext();
	    	DIntNode bottom = l2.tail.getPrev();
	    	while(top.getData() < bottom.getData()) {
	    		if(top.getData() + bottom.getData() == y) {
	    			System.out.print("(" + top.getData() + "," + bottom.getData() + ") ");
		    		top = top.getNext();
		    		bottom = bottom.getPrev();
	    		}
	    		else if(top.getData() + bottom.getData() > y) {
	    			bottom = bottom.getPrev();
	    		}
	    		else if(top.getData() + bottom.getData() < y) {
	    			top = top.getNext();
	    		}
	    	}
	    	System.out.println();
	    	
	    }
	    
	    
	  
	    
	    /**
	     * adds a node with given value to end of list
	     * Time complexity of O(1)
	     * @param element int - value of element to add
	     */
	    public void addEnd(int element) {
	 	   DIntNode add = new DIntNode(element, tail.getPrev(), tail);
	 	   tail.getPrev().setNext(add);
	 	   tail.setPrev(add);
	    }
	 
	    /**
	     * removes the first node that is not head
	     * Time complexity of 0(1)
	     */
	    public void removeFromHead() {
	 	   if(head.getNext() != tail) {
	 		   head.setNext(head.getNext().getNext());
	 		   head.getNext().setPrev(head);
	 	   }
	    }
	    
	    
	    /**
	     * @param args
	     */
	    public static void main(String args[]) {
	    	DoublyLinkedListDummy list = new DoublyLinkedListDummy();
	        list.addEnd(1);
	        list.addEnd(2);
	        list.addEnd(3);
	        System.out.println(list.toString());  //expect 1<>2<>3 then 3<>2<>1
	        
	        list.removeFromHead();
	        System.out.println(list.toString());  //expect 2<>3  then 3<>2
	        
	        DoublyLinkedListDummy list1 = new DoublyLinkedListDummy();
	        list1.addEnd(1);
	        list1.addEnd(2);
	        list1.addEnd(3);
	        list1.addEnd(1);
	        list1.addEnd(2);
	        System.out.println(list1.countOccurrence(2));   //expect 2
	        System.out.println(list1.toString()); 
	        
	        
	        System.out.println(list1.removeAll(2));  //expect true
	        System.out.println(list1.toString());   // expected 1 <-> 3 <-> 1
	        
	        DoublyLinkedListDummy list2 = new DoublyLinkedListDummy();
	        list2.addEnd(1);
	        list2.addEnd(2);
	        list2.addEnd(3);
	        list2.addEnd(1);
	        list2.addEnd(2);
	        System.out.println(list2.toString());
	        DoublyLinkedListDummy newList = list2.removeDuplicates();
	        System.out.println(newList.toString());
	        
	        
	        DoublyLinkedListDummy list3 = new DoublyLinkedListDummy();
	        list3.addEnd(1);
	        list3.addEnd(3);
	        list3.addEnd(4);
	        list3.addEnd(6);
	        list3.addEnd(7);
	        list3.addEnd(9);
	        list3.addEnd(10);
	        pairs(list3, 10);
	    }
}
