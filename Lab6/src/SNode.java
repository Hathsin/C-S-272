
/**
 * general Singly Linked node class
 * @author Ben W.
 *
 * @param <E>
 */
public class SNode<E> {
		private E data;
		private SNode<E> node;
		
		/**
		 * returns data in node
		 * @return
		 */
		public E getData() {
			return data;
		}

		/**
		 * returns node this points to
		 * @return
		 */
		public SNode<E> getNode() {
			return node;
		}

		/**
		 * set data stored in node
		 * @param data
		 */
		public void setData(E data) {
			this.data = data;
		}


		/**
		 * set node this is pointing to
		 * @param node
		 */
		public void setNode(SNode<E> node) {
			this.node = node;
		}
			
		/**
		 * no-argument constructor
		 */
		public SNode() {
			data = null;
			node = null;
		}
		
		
		/**
		 * constructor taking input to set data and node
		 * @param _data
		 * @param _node
		 */
		public SNode(E _data, SNode<E> _node) {
			data = _data;
			node = _node;
		}

			
		/**
		 * converts node to string representation
		 */
		public String toString() {
			String list = "";
			SNode<E> x = this;
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
		 * add node after given node
		 * added node holds given data
		 * @param newdata E - data for new node to hold
		 */
		public void addNodeAfterThis(E newdata) {
			SNode<E> next = new SNode<E>(newdata, this.getNode());
			this.setNode(next);
		}
		
		/**
		 * removes node this points to
		 */
		public void removeNodeAfterThis() {
			if(this.getNode() != null) {
				this.setNode(this.getNode().getNode());
			}
		}
		
		
	
}
