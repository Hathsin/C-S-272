import java.util.Scanner;

public class NQueen {
	
	/**
	 * checks if Queen can be placed in given position without attacking others
	 * @param Q int - column the queen will be placed in
	 * @param y stack- holding x position of queen, y position is based on 
	 * @return true if conflict exists, else false
	 */
	public static boolean checkConflict(int Q, LinkStack<Integer> y) {
		LinkStack<Integer> x = new LinkStack<Integer>();
		
		x = y.copy();
		
		
		int num = x.size();
		int dia = x.size();
		int temp;
		
		while (num != 0 ) {

			temp = x.pop();
			

			if(Q == temp) {
				return true;
			}
			else if(Q == (temp + dia)) {
				return true;
			}
			else if(Q == (temp - dia)) {
				return true;
			}
			else {
				dia--;
				
				num--;
			}
		}
		
		return false;
		
	}

	
	/**
	 * prints a board where empty spaces are represented by a - and queens are represented by Q
	 * @param S stack - used to determine x and y values of queen position
	 */
	public static void printStack(StackInterface<Integer> S) {
		int N = S.size();
		int x = S.pop();
		
		while(S.top() != null) {
			for(int i = 1; i < x; i++) {
				System.out.print("-");
			}
			System.out.print("Q");
			for(int i = 1; i < (N - x + 1); i++) {
				System.out.print("-");
			}
			System.out.println();
			x = S.pop();
		}
		for(int i = 1; i < x; i++) {
			System.out.print("-");
		}
		System.out.print("Q");
		for(int i = 1; i < (N - x + 1); i++) {
			System.out.print("-");
		}
		System.out.println();
	}
	
	
	/**
	 * main methos to place queens on a board, given user input
	 * attempts to place a queen on row x
	 * if it succeeds, it moves to x+1 until n
	 * if it fails, it moves to x-1 and tries again
	 * once it succeeds, the board is printed to screen
	 * if it fails, no solution is printed. 
	 */
	public static void Queen() {
		boolean solutionFound = true;
		LinkStack<Integer> S = new LinkStack<Integer>();
		Scanner s = new Scanner(System.in);
		
		int Qpos = 1;
		
		System.out.print("what is N: ");
		int N = s.nextInt(); 
		if(N<=0) {
			System.out.println("no solution");
			solutionFound = false;
		}
		s.close();
		
		boolean conflict = true;
		while(S.size() < N){
			
			while (Qpos <= N) {
				conflict = checkConflict(Qpos, S);
				
				if(!conflict) {
					S.push(Qpos);
					Qpos = 1;
					break;
				}
				else if (conflict) {
					Qpos++;
				}
				
			}
			while(!S.isEmpty() && Qpos > N) {
				boolean shifted = false;
				Qpos = S.pop();
				Qpos++;
				while (Qpos <= N) {
					conflict = checkConflict(Qpos, S);
					if(!conflict) {
						S.push(Qpos);
						shifted = true;
						Qpos = 1;
						break;
					}
					else if (conflict) {
						Qpos++;
					}
				}
				if(shifted) {
					break;
				}
			}
	
			
			if(Qpos > N) {
				System.out.println("no solution");
				solutionFound = false;
				break;
			}
		}
		if(solutionFound) printStack(S);
		
		
	}
	
	public static void main(String[] args) {
		Queen();
	}
	

}
