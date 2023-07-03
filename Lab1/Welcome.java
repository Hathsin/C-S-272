import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintWriter;

public class Welcome {
	public static void main(String args[]) {
		System.out.println("Welcome to Java");
		PrintWriter outputStream = null;
		try {
			outputStream = new PrintWriter(new FileWriter("eclipse_test.txt"));
			outputStream.println(System.currentTimeMillis());
		}
		catch (IOException e) {
			System.out.println("error");
		}
		outputStream.close();
		
		int q = sum();
		System.out.println(q);
	}
	
	
	
	public static int sum() {
		int sum = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String x = br.readLine();
			String[] nums = x.split(" ");
			for(int i = 0; i < nums.length; i++) {
				if(nums[i] == "") {
					
				}
				else {
					sum += Integer.parseInt(nums[i]);
				}
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("error2");
		}
		return sum;
	}
}
