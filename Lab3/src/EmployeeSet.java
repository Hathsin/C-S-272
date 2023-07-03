import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * class designed to hold a set of employees
 */
public class EmployeeSet {
	private int size;
	private int capacity;
	private Employee[] set;
	
	/**
	 * no argument constructor for set, capacity is 10, size is 0, set is empty
	 */
	public EmployeeSet() {
		capacity = 10;
		size = 0;
		set = new Employee[10];
	}
	
	/**
	 *  public size access
	 * @return size of set being used
	 */
	public int size() {
		return size;
	}
	
	/**
	 *  public capacity access
	 * @return size available in set
	 */
	public int capacity() {
		return capacity;
	}
	
	/**
	 *  adds Employee to set
	 * @param a is Employee being added to set. Assumes that a is not null
	 */
	public void add(Employee a) {
		if(a != null) {
			if(size == capacity){
				ensureCapacity(size + 1);
				
			}
			set[size] = a;
			size++;
		}
	}

	/**
	 *  detects if Employee with id equal to input is removed.
	 * @param eid is int, meaning employee id
	 * @return true or false
	 */
	public boolean remove(int eid) {
		Employee[] temp = new Employee [capacity];
		for(int i = 0; i < size; i++) {
			if(set[i].getId() == eid) {
				System.arraycopy(set, 0, temp, 0, i);
				System.arraycopy(set, i + 1, temp, i, size - i - 1);
				set = temp;
				size--;
				return true;
			}
		}
		return false;
	}
	
	/**
	 *  increases capacity as needed
	 * @param minimumCapacity is int, which sets the new capacity for set
	 */
	private void ensureCapacity(int minimumCapacity) {
		if(minimumCapacity > 0 && minimumCapacity >= size) {
			Employee[] newSet = new Employee[minimumCapacity];
	        System.arraycopy(set, 0, newSet, 0, size);
	        set = newSet;
	        capacity = minimumCapacity;
		}
	}
	
	/**
	 *  detects if Employee with given id exists
	 * @param eid is int, meaning Employee ID
	 * @return true or false
	 */
	public boolean contains(int eid) {
		for(int i = 0; i < size; i++) {
			if(set[i].getId() == eid) {
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * Saves all employees in set to a csv file.
	 */
	public void saveFile() {
		try {
			PrintWriter tst = new PrintWriter(new FileWriter("Employee Information.csv"));
			tst.println("Employee Name,Employee Number,State,Zip,Age,Manager Name");
			for(int i = 0; i < size; i++) {
				tst.println(set[i].getName() + ',' + set[i].getId() + ',' + set[i].getState() + ',' + set[i].getZip() + ',' + set[i].getAge() + ',' + set[i].getAdvisor());
			}
			tst.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
}







	
