
public class test {

	public static void main(String[] args) {
		Employee Emp1 = new Employee();
		System.out.println(Emp1.toString());
		Emp1.setAdvisor("Zach");
		Emp1.setName("Johan");
		Emp1.setAge(27);
		Emp1.setId(7832470);
		Emp1.setState("New Mexico");
		Emp1.setZip(88001);
		System.out.println(Emp1.toString());
		
		
		Employee Emp2 = new Employee(Emp1);
		System.out.println(Emp2.toString());
		
		
		System.out.println(Emp1.equals(Emp2));
		
		
		Emp1.setAdvisor("");
		Emp1.setName("");
		Emp1.setAge(-12);
		Emp1.setId(012);
		Emp1.setState("");
		Emp1.setZip(999999999);
		System.out.println(Emp1.toString());
		
		
		Employee Emp3 = Emp2.clone();
		System.out.println(Emp3.toString());
		
		
		
		
		PseudoRandom rand = new PseudoRandom(6415, 100, 576487, 6425);
		System.out.println(rand.nextNum(rand));
		
		
		rand.setIncrement(976);
		rand.setModulus(0);
		rand.setInitialSeed(46354645);
		rand.setMultiplier(00);
		System.out.println(rand.nextNum(rand));
		System.out.println(rand.nextNum(rand));
		
		
		rand.setMultiplier(-745);
		System.out.println(rand.nextNum(rand));
		
	}

}
