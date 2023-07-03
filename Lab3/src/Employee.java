
/**
 * class that holds information about an Employee
 *
 */
public class Employee {
	private String name;
	private int id;
	private int age;
	private String state;
	private int zip;
	private String advisor;
	
	
	
	/**
	 * @return String, the name of Employee
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name inputs new name for Employee
	 */
	public void setName(String name) {
		if (name != "") {
			this.name = name;
		}
		else {
			System.out.println("Please use a valid name.\n");
		}
	}

	/**
	 * @return int, unique Employee ID
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id, takes input to set employee ID
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return int, Employee's age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age sets Employee's age, within reasonable parameters
	 */
	public void setAge(int age) {
		if (age > 0 && age < 125) {
			this.age = age;
		}
		else {
			System.out.println("Please use a valid age.\n");
		}
	}

	/**
	 * @return String, State employee works in
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state Sets the state that Employee is employed in
	 */
	public void setState(String state) {
		if (state != "") {
			this.state = state;
		}
		else {
			System.out.println("Please use a valid state name.\n");
		}
	}

	/**
	 * @return int, zip code of Employee
	 */
	public int getZip() {
		return zip;
	}

	/**
	 * @param zip, sets zip code for Employee, must be a valid zip
	 */
	public void setZip(int zip) {
		if (zip > 0 && zip < 99951) {
			this.zip = zip;
		}
		else {
			System.out.println("Please use a valid ZIP code.\n");
		}
	}

	/**
	 * @return String, name of the Advisor overseeing Employee
	 */
	public String getAdvisor() {
		return advisor;
	}

	/**
	 * @param advisor sets name of advisor overseeing Employee
	 */
	public void setAdvisor(String advisor) {
		if (advisor != "") {
			this.advisor = advisor;
		}
		else {
			System.out.println("Please use a valid advisor name.\n");
		}
	}



	
	/**
	 * zero parameter initialization
	 */
	public Employee() {
		name = null;
		id = 0;
		age = 0;
		state = null;
		zip = 0;
		advisor = null;
	}
	
	/**
	 *  copy method
	 * @param obj Employee object, to copy to new Employee. Assuming that obj is not null
	 */
	public Employee (Object obj) {
		if(obj instanceof Employee && obj != null) {
			Employee tst = (Employee) obj;
			
			name = tst.name;
			id = tst.id;
			age = tst.age;
			state = tst.state;
			zip = tst.zip;
			advisor = tst.advisor;
		}
	}
	
	/**
	 * clones Employee object
	 *@return Employee, uses values from Employee that called this method
	 */
	public Employee clone() {
		Employee duplicate = new Employee();
		
		duplicate.name = name;
		duplicate.id = id;
		duplicate.age = age;
		duplicate.state = state;
		duplicate.zip = zip;
		duplicate.advisor = advisor;
		return duplicate;
	}
	
	/**
	 * list of each variable on new line
	 *@return String, description of Employee in string format
	 */
	public String toString() {
		return String.format("Name: %s\nID: %d\nAge: %d\nState: %s\nZip: %d\nAdvisor: %s\n", getName(), getId(), getAge(), getState(), getZip(),  getAdvisor());
	}

	/**
	 * tests is id is equal
	 *@return boolean, true or false
	 */
	public boolean equals(Object obj) {
		if(obj instanceof Employee && obj != null) {
			Employee identity = (Employee) obj;
			return (this.getId() == identity.getId());
		}
		return false;
	}


}
