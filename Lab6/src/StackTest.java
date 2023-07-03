
public class StackTest {

	public static void main(String[] args) {
		LinkStack<String> L1 = new LinkStack<String>();
		
		L1.push("first");
		System.out.println(L1.top());
		L1.push("second");
		System.out.println(L1.pop());
		L1.push("third");
		System.out.println(L1.top());
		System.out.println(L1.size());
		L1.pop();
		System.out.println(L1.pop());
		L1.push("tst");
		System.out.println(L1.isEmpty());
		L1.pop();
		L1.pop();
		L1.pop();//pops nothing
		System.out.println(L1.size());
		System.out.println(L1.isEmpty());
		System.out.println(L1.pop());
		L1.push(null);
		L1.push(null);
		System.out.println(L1.top());
		System.out.println(L1.size());

	}

}
