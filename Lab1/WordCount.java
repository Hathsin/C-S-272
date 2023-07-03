import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.io.FileNotFoundException;


public class WordCount {
	public static void main(String args[]) {
		
		int test = countLines("pg100.txt");
		System.out.println(test);
		
		wordRepeat("ThIs,his,many", "pg100.txt");
	}
	
	public static int countLines(String fname) {
		int lineNum = 0;
		try {
			BufferedReader br = new BufferedReader(new FileReader(fname));
			while (br.readLine() != null) {
				lineNum++;
			}
			br.close();
			
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fname + "'");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("error");
		}
		return lineNum;
	}
	
	public static void wordRepeat(String words, String fname) {
		String line;
		String[] find = words.split(",");
		int count = 0;
		PrintWriter outputCount = null;
		try {
			
			outputCount = new PrintWriter(new FileWriter("WordCount.csv"));
			for(int i = 0; i < find.length; i++) {	
				BufferedReader input = new BufferedReader(new FileReader(fname));
				while ((line = input.readLine()) != null) {
					String[] x = line.split(" ");
					for(int j = 0; j < x.length; j++) {
						if(x[j].toLowerCase().equals(find[i].toLowerCase())) {
							count++;
							
						}
					}	
				}
				outputCount.println(find[i] + ' ' + count);
				count = 0;
				input.close();
			}
			
		} catch (FileNotFoundException ex) {
				System.out.println("Unable to open file '" + fname + "'");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("error");
		}
		
		
		outputCount.close();
		
	}
}
