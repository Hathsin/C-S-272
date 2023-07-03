

/**
 * IntNode class, which is used as a linked list for integers
 * @author hathsin
 *
 */
public class IntNode {
	private int data;
	private IntNode node;
	
	/**
	 * data getter method
	 * @return the data
	 */
	public int getData() {
		return data;
	}

	/**
	 * node getter method
	 * @return the node
	 */
	public IntNode getNode() {
		return node;
	}

	/**
	 * data setter method
	 * @param data the data to set
	 */
	public void setData(int data) {
		this.data = data;
	}

	/**
	 * node setter method
	 * @param node the node to set
	 */
	public void setNode(IntNode node) {
		this.node = node;
	}
	

	

	/**
	 * no constructor argument. Sets data to 0, node to null
	 */
	public IntNode() {
		data = 0;
		node = null;
	}
	
	/**
	 * constructor with parameters
	 * @param _data int, sets data
	 * @param _node IntNode, points to next node in list
	 */
	public IntNode(int _data, IntNode _node) {
		data = _data;
		node = _node;
	}

	/**
	 * A string Representation of the list in the form Element1 -> Element2 ->... LastElement
	 */
	public String toString() {
		String list = "";
		IntNode x = this;
		while(x != null) {
			list += x.getData();
			x = x.getNode();
			if (x == null){
				break;
			}
			list += "->";
		}
		return list;
	}

	/**
	 * adds node after IntNode it was called on, does not remove other nodes.
	 * @param newdata, int for the value of the new node
	 */
	public void addNodeAfterThis(int newdata) {
		IntNode next = new IntNode(newdata, this.getNode());
		this.setNode(next);
	}
	
	/**
	 * removes node after node called
	 */
	public void removeNodeAfterThis() {
		if(this.getNode() != null) {
			this.setNode(this.getNode().getNode());
		}
	}
	
	/**
	 * returns length of list, starting at 1
	 * @param head IntNode, beginnig of list
	 * @return int, length
	 */
	public static int listLength(IntNode head){
		int count = 0;
		IntNode x = head;
		while(x != null) {
			count++;
			x = x.getNode();
		}
		return count;
	}
	
	/**
	 * Finds if data exists in given list
	 * precondition: head is not null
	 * @param head IntNode, top of list
	 * @param data int, the value to be found
	 * @return boolean, true if found, false if not.
	 */
	public static boolean search(IntNode head, int data) {
		IntNode x = head;
		while(x != null) {
			if(x.getData() != data) {
				x = x.getNode();
			}
			else {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * sorts list from smallest to largest. Rearramges nodes, no deletion or creation.
	 * postcondition: the return value is a head reference of a linked 
	 * list with exactly the same entries as the original list (including 
	 * repetitions, if any), but the entries in this list are sorted from 
	 * smallest to largest. The original linked list is no longer 
	 * available.
	 * @param head IntNode, top of list
	 * @return IntNode, the top of sorted list
	 */
	public static IntNode listSort(IntNode head) {
		IntNode x = head;
		int max = -100;
		IntNode sorted = null;
		IntNode hold;
		int len = listLength(head);
		for(int i = 0; i < len; i++) {
			while(x != null) {
				if(x.getData() > max) {
					max = x.getData();
				}
				x = x.getNode();
			}
			x = head;
			while(x != null) {
				if(x.getData() == max) {
					if (x.getNode() == null) {
						head = x.getNode();
						hold = x;
						x = null;
						hold.setNode(sorted);
						sorted = hold;
						continue;
					}
					head = x.getNode();
					hold = x;
					x = x.getNode();
					hold.setNode(sorted);
					sorted = hold;
					x = null;
				}
				else if(x.getNode().getData() == max) {
					hold = x.getNode();
					x.removeNodeAfterThis();
					hold.setNode(sorted);
					sorted = hold;
					x = null;
				}
				else {
					x = x.getNode();
				}
			}
			max = -100;
			x = head;
		}
		return sorted;
	}
	
	/**
	 * Returns set difference of list1 - list2
	 * @param list1 IntNode, top of list to be subtracted from
	 * @param list2 IntNode, top of list subtracting
	 * @return IntNode, top of new list
	 */
	public static IntNode subtract(IntNode list1, IntNode list2) {
		IntNode hold = null;
		IntNode top = hold;
		IntNode top2 = list2;
		//IntNode fin;
		while(list1 != null) {
			while(list2 != null) {
				if(list1.getData() == list2.getData()) {
					list1 = list1.getNode();
				}
				list2 = list2.getNode();
			}
			list2 = top2;
			if(hold != null) {
				hold.addNodeAfterThis(list1.getData());
				hold = hold.getNode();
			}
			else {
				hold = new IntNode(list1.getData(), null);
				top = hold;
			}
			list1 = list1.getNode();
		}
		return top;
	}
	
	
	/**
	 * Main method, testing success of methods
	 * @param args
	 */
	public static void main(String args[]) {
		IntNode top = new IntNode(5,null);
		for(int i = 0; i < 6; i++) {
			top = new IntNode(i, top);
		}
		System.out.println(top.toString());
		top = listSort(top);
		System.out.println(top.toString());
		
		
		IntNode sub = new IntNode();
		for(int i = 0; i < 20; i += 2) {
			sub.addNodeAfterThis(i);
		}
		
		
		System.out.println(listLength(top));
		
		System.out.println(sub.toString());
		System.out.println(listLength(sub));
		
		top = subtract(top,sub);
		System.out.println(top.toString());
		
		System.out.println(search(top, 3));
		System.out.println(search(top, 2));
		
		System.out.println(listLength(top));
	}
	
	
	
}
