import java.util.Scanner;

public class Palindrome {
	
	/**
	 * takes input from user, removes punctuation and seperates words into string array
	 * array is seperated into stack and queue
	 * pop and dequeue are compared, if all are the same, return true, else return false 
	 * @return
	 */
	@SuppressWarnings({ "unused", "null" })
	public static boolean check() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter postfix expression: ");
		ArrayQueue<String> x = new ArrayQueue<String>();
		LinkStack<String> y = new LinkStack<String>();
		
		String exp = s.nextLine().replaceAll("\\p{Punct}", "");
		s.close();
		String[] sep = exp.split(" ");
		
		for(String a : sep) {
			x.enqueue(a);
			y.push(a);
		}
		
		
		for(int i = 0; i < sep.length / 2; i++) {
			if(!x.dequeue().toLowerCase().equals(y.pop().toLowerCase())) {
				return false;
			}
		}
		return true;
		
	}
	public static void main(String[] args) {
		System.out.println(check());
	}
}
	
