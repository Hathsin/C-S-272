import java.util.Scanner;

public class Postfix {
	
	
	/** goven a postfix expression, inserts numbers into stack, pops two numbers when performing math and pushes result
	 *  returns result of equation
	 * @return
	 */
	public static String calc(){
		LinkStack<String> tst = new LinkStack<String>();
		Scanner s = new Scanner(System.in);
		
		System.out.print("Enter postfix expression: ");
		
		String exp = s.nextLine();
		s.close();
		String[] sep = exp.split(" ");
		
		for(String x : sep) {
			switch(x) {
				case "+":
					int a = Integer.parseInt(tst.pop());
					int b = Integer.parseInt(tst.pop());
					String ans = String.valueOf(a + b);
					tst.push(ans);
					break;
				case "-":
					int a2 = Integer.parseInt(tst.pop());
					int b2 = Integer.parseInt(tst.pop());
					String ans2 = String.valueOf(b2 - a2);
					tst.push(ans2);
					break;
				case "*":
					int a3 = Integer.parseInt(tst.pop());
					int b3 = Integer.parseInt(tst.pop());
					String ans3 = String.valueOf(a3 * b3);
					tst.push(ans3);
					break;
				case "/":
					int a4 = Integer.parseInt(tst.pop());
					int b4 = Integer.parseInt(tst.pop());
					String ans4 = String.valueOf(b4 / a4);
					tst.push(ans4);
					break;
				default:
					tst.push(x);
			}
		}
		s.close();
		return tst.pop();
	}
	public static void main(String[] args) {
		System.out.println(calc());
	}
}
