public class RecursiveQuestion {

	
	/**
	 * converts string of numbers to integer value
	 * @param str - String of numbers to convert
	 * @return int, value in int
	 */
	public static int convert(String str) {
		if(str.length() == 1) {
			int x = str.charAt(0) - '0';
			return x;
		}
		else {
			int x = (int) (str.charAt(str.length() - 1) - '0');
			return (x + 10 * convert(str.substring(0, str.length() - 1)));
		}
	}
	
	/**
	 * Calculates the value from Ackermann function
	 * @Precondition no negative numbers
	 * @param x
	 * @param y
	 * @return int value
	 */
	public static int Ackermann(int x, int y) {
		if (x==0) {
			return 2*y;
		}
		else if (x>=1 && y==0) {
			return 0;
		}
		else if (x>=1 && y==1) {
			return 2;
		}
		else if (x>=1 && y>=2) {
			return Ackermann(x-1,Ackermann(x,y-1));
		}
		else {
			throw new Error("No Negative numbers allowed");
		}
	}
	
	

	/**
	 * Solves Towers of Hanoi problem for given number of disks. moves to any given positon.
	 * @param n - number of disks
	 * @param start - the plaxce where the stack begins
	 * @param target - the place for the stach to end
	 * @param spare - additonal place for the stack
	 */
	public static void Hanoi(int n, int start, int target, int spare) {
		if(n==0) {
			return;
		}
		else {
			Hanoi(n-1, start, spare, target);
			System.out.println("disk " + n + " moved from "+ start + " to " + target);
			Hanoi(n-1, spare, target, start);
		}
		
		
	}
	
	
	/**
	 * prints all possible permutations of a given array of distinct numbers
	 * @param arr - array of ints
	 * @param l - lowest index of arrar
	 * @param r - highest index of array
	 */
	public static void Permutation(int[] arr, int l, int r) {
		if (arr.length == 1) {
			System.out.println("[" + arr[0] + "]");
			return;
		}
		if (arr.length < 1) {
			System.out.println("Empty array given");
			return;
		}
		if(l == r) {
			for(int x : arr) {
				System.out.print(x + " ");
			}
			System.out.print("\n");
		}
		else {
			for(int i = l; i <= r; i++) {
				int tmp = arr[l];
				arr[l] = arr[i];
				arr[i] = tmp;
				Permutation(arr, l+1, r);
				tmp = arr[l];
				arr[l] = arr[i];
				arr[i] = tmp;
			}
		}
		
		
		
	}
	
	
	/**
	 * Returns a doube value of the sum of the reciprocals of the first n positive integers.
	 * @param n - number of positive ints
	 * @return - value of summation
	 */
	public static double sumover(int n) {
		if(n==0) {
			return 0.0;
		}
		else if(n==1) {
			return 1.0;
		}
		else {
			return ((1.0/n) + sumover(n-1));
		}
		
	}
	

	/**
	 * power function, raises a given number to a given power
	 * @param x - base
	 * @param n - exponent
	 * @return - result
	 */
	public static double pow(int x, int n) {
		if(n==0) {
			return 1;
		}
		else if(n < 0) {
			return (1.0 / pow(x,n * -1)); 
		}
		else if(n%2 == 1) {
			return x * pow(x, n-1);
		}
		else {
			double j = pow(x,n/2);
			return (j*j);
		}
	}
	
	
	
	
	public static void main(String[] args) {
		System.out.println(convert("1234"));
		System.out.println(Ackermann(2,2));
		System.out.println(sumover(0));
		System.out.println(pow(25,-2));
		int[] a = {1,2,3};
		Permutation(a,0,2);
		Hanoi(4, 0, 2, 1);
	}

}
