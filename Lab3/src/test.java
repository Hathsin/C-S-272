import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Testing classes for lab2
 * @author Ben Widner
 */
public class test {

	/**
	 * main method where classes are tested
	 * @param args none
	 */
	public static void main(String[] args) {
		Employee e1 = new Employee();
		Employee e2 = new Employee();
		EmployeeSet s1 = new EmployeeSet();
		
		
		e1.setAdvisor("Dr. Manhattan");
		e1.setAge(42);
		e1.setId(9782390);
		e1.setName("Jane Chatwin");
		e1.setState("NM");
		e1.setZip(88001);
		
		e2.setAdvisor("Dr. Curry");
		e2.setAge(35);
		e2.setId(9329073);
		e2.setName("Dirk Strider");
		e2.setState("CO");
		e2.setZip(84927);
		
		s1.add(e1);
		s1.add(e2);
		
		if(s1.contains(e1.getId())) {
			System.out.println("e1 exists");
		}
		
		if(s1.contains(e2.getId())) {
			System.out.println("e2 exists");
		}
		
		s1.remove(e1.getId());
		
		if(!s1.contains(e1.getId())) {
			System.out.println("e1 is removed");
		}
		
		if(!s1.remove(420)) {
			System.out.println("nothing was removed");
		}
		
		
		Employee e3 = new Employee(e2);
		
		s1.add(e3);

		Employee e4 = e2.clone();
		
		s1.add(e4);
		
	
		e3.setAdvisor("Dr. Hargreeves");
		e3.setAge(35);
		//e3.setId(098394);
		e3.setName("Gerard Way");
		e3.setState("CA");
		e3.setZip(76731);
		
		s1.add(e3);
		
		e3.setId(98394);
		s1.add(e3);
		
		e4.setId(92394);
		s1.add(e4);
		s1.add(e1);
		Employee e5 = e2.clone();
		Employee e6 = e2.clone();
		Employee e7 = e2.clone();
		Employee e8 = e2.clone();
		Employee e9 = e2.clone();
		Employee e10 = e2.clone();
		Employee e11 = e2.clone();

		e5.setId(0);
		e6.setId(1);
		e7.setId(2);
		e8.setId(3);
		e9.setId(4);
		e10.setId(5);
		
		s1.add(e5);
		s1.add(e6);
		s1.add(e7);
		s1.add(e8);
		s1.add(e9);
		s1.add(e10);
		
		s1.add(e11);
		e11.setId(420);
		s1.add(e11);
		
		s1.saveFile();
		
		
		EmployeeSet s2 = new EmployeeSet();
		String q;
		String name;
		try {
			BufferedReader br = new BufferedReader(new FileReader("core_dataset.csv"));
			q = br.readLine();
			q = br.readLine();
			while(q != null) {

				Employee ee1 = new Employee();
				
				String[] x = q.split(",");
				
				name = x[0] + x[1];
				ee1.setName(name);
				ee1.setId(Integer.parseInt(x[2]));
				ee1.setState(x[3]);
				ee1.setZip(Integer.parseInt(x[4]));
				ee1.setAge(Integer.parseInt(x[5]));
				ee1.setAdvisor(x[6]);
				
				s2.add(ee1);
				

				q = br.readLine();
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		s2.saveFile();
	}

}
