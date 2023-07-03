
public class QueueTest {
	public static void main(String[] args) {
		LinkedQueue<String> L1 = new LinkedQueue<String>();
		LinkedQueue<Integer> L2 = new LinkedQueue<Integer>();
		L1.enqueue("first");
		System.out.println(L1.front());
		L1.enqueue("second");
		System.out.println(L1.front());
		L1.enqueue("third");
		System.out.println(L1.size());
		L1.dequeue();
		System.out.println(L1.front());
		System.out.println(L1.isEmpty());
		L1.dequeue();
		L1.dequeue();
		L1.dequeue();//dequeues nothing
		System.out.println(L1.size());
		System.out.println(L1.isEmpty());
		System.out.println(L1.front());
		L1.enqueue(null);
		System.out.println(L1.front());
		System.out.println(L1.size());
		
		System.out.println();
		System.out.println();
		
		L2.enqueue(1);
		System.out.println(L2.front());
		L2.enqueue(2);
		System.out.println(L2.front());
		L2.enqueue(3);
		System.out.println(L2.size());
		L2.dequeue();
		System.out.println(L2.front());
		System.out.println(L2.isEmpty());
		L2.dequeue();
		L2.dequeue();
		L2.dequeue();//dequeues nothing
		System.out.println(L2.size());
		System.out.println(L2.isEmpty());
		System.out.println(L2.front());
		L2.enqueue(null);
		System.out.println(L2.front());
		System.out.println(L2.size());
		
		System.out.println();System.out.println();System.out.println();System.out.println();
		
		ArrayQueue<String> A1 = new ArrayQueue<String>();
		ArrayQueue<Integer> A2 = new ArrayQueue<Integer>();
		
		A1.enqueue("first");
		System.out.println(A1.front());
		A1.enqueue("second");
		System.out.println(A1.front());
		A1.enqueue("third");
		System.out.println(A1.size());
		A1.dequeue();
		System.out.println(A1.front());
		System.out.println(A1.isEmpty());
		A1.dequeue();
		A1.dequeue();
		A1.dequeue();//dequeues nothing
		System.out.println(A1.size());
		System.out.println(A1.isEmpty());
		System.out.println(A1.front());
		A1.enqueue(null);
		System.out.println(A1.front());
		System.out.println(A1.size());
		
		System.out.println();
		System.out.println();
		
		 
		A2.enqueue(1);
		System.out.println(A2.front());
		A2.enqueue(2);
		System.out.println(A2.front());
		A2.enqueue(3);
		System.out.println(A2.size());
		A2.dequeue();
		System.out.println(A2.front());
		System.out.println(A2.isEmpty());
		A2.dequeue();
		A2.dequeue();
		A2.dequeue();//dequeues nothing
		System.out.println(A2.size());
		System.out.println(A2.isEmpty());
		System.out.println(A2.front());
		A2.enqueue(null);
		System.out.println(A2.front());
		System.out.println(A2.size());
		
		System.out.println();
		System.out.println();
		
		ArrayQueue<String> A3 = new ArrayQueue<String>(0);
		//ArrayQueue<String> A4 = new ArrayQueue<String>(-1); gives error as expected
		
		A3.enqueue("first");
		System.out.println(A3.front());
		A3.enqueue("second");
		System.out.println(A3.front());
		A3.enqueue("third");
		A3.enqueue("H");
		A3.enqueue("E");
		A3.enqueue("L");
		A3.enqueue("L");
		A3.enqueue("O ");
		A3.enqueue("W");
		A3.enqueue("O");
		A3.enqueue("R");
		A3.enqueue("L");
		A3.enqueue("D!");
		System.out.println(A3.size());
		A3.dequeue();
		System.out.println(A3.front());
		A3.dequeue();
		System.out.println(A3.front());
		A3.dequeue();
		System.out.println(A3.front());
		A3.dequeue();
		System.out.println(A3.front());
		A3.dequeue();
		System.out.println(A3.front());
		A3.dequeue();
		System.out.println(A3.front());
		A3.dequeue();
		System.out.println(A3.front());
		A3.dequeue();
		System.out.println(A3.front());
		A3.dequeue();
		System.out.println(A3.front());
		A3.dequeue();
		System.out.println(A3.front());
		A3.dequeue();
		System.out.println(A3.front());
		A3.dequeue();
		
		System.out.println(A3.dequeue());
		System.out.println(A3.size());
		System.out.println(A3.isEmpty());
		
		A3.enqueue(null);
		System.out.println(A3.front());
		System.out.println(A3.size());
		
	}
}
