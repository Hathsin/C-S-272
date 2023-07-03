/**
 * seemingly random number generator. 
 *
 */
public class PseudoRandom {
	
	private int initialSeed;
	private int multiplier;
	private int increment;
	private int modulus;
	
	/**
	 * @return int, the initial seed used to generate Random number
	 */
	public int getInitialSeed() {
		return initialSeed;
	}

	/**
	 * @param initialSeed sets initial seed with this value
	 */
	public void setInitialSeed(int initialSeed) {
		this.initialSeed = initialSeed;
	}

	/**
	 * @return int, the multiplier of initiialSeed
	 */
	public int getMultiplier() {
		return multiplier;
	}

	/**
	 * @param multiplier, sets value to a non-zero int
	 */
	public void setMultiplier(int multiplier) {
		if (multiplier != 0) {
			this.multiplier = multiplier;
		}
		else {
			System.out.println("Multiplier cannot be zero");
		}
	}

	/**
	 * @return int, the value initial seed increments by
	 */
	public int getIncrement() {
		return increment;
	}

	/**
	 * @param increment, sets value of increment
	 */
	public void setIncrement(int increment) {
		this.increment = increment;
	}

	/**
	 * @return int, the modulus division of result
	 */
	public int getModulus() {
		return modulus;
	}

	/**
	 * @param modulus, set modulus to a positive, non-zero int
	 */
	public void setModulus(int modulus) {
		if (modulus > 0) {
			this.modulus = modulus;
		}
		else {
			System.out.println("Modulus cannot be less than or equal to zero");
		}
		
	}

	
	/**
	 *  initialize the equation values for a PseudoRandom number
	 * @param initialSeed, the first seed, which will change, based on result of equation
	 * @param multiplier, what initial seed + increment is multiplied by
	 * @param increment, added to initial seed
	 * @param modulus, after all functions, the modulus division is performed
	 */
	public PseudoRandom(int initialSeed, int multiplier, int increment, int modulus) {
		this.initialSeed = initialSeed;
		this.multiplier = multiplier;
		this.increment = increment;
		this.modulus = modulus;
	}
	
	/**
	 * equation is performed to determine next number in sequence to be returned
	 * @param obj, Assumed to be PseudoRandom object
	 * @return int between [0, modulus)
	 */
	public int nextNum(Object obj) {
		if(obj instanceof PseudoRandom && obj != null) {
			PseudoRandom calc = (PseudoRandom) obj;
			calc.initialSeed = (calc.multiplier * calc.initialSeed + calc.increment) % calc.modulus;
			if (calc.initialSeed < 0) {
				calc.initialSeed *= -1;
			}
		}
		return initialSeed;
	}
	
	/**
	 * equation is performed to determine next number in sequence to be returned, then divided by modulus, resulting in decimal [0,1)
	 * @param obj PseudoRandom obj
	 * @return returns value between [0,1)
	 *  
	 */
	public double nextDoubleNum(Object obj) {
		double mod = 1;
		if(obj instanceof PseudoRandom && obj != null) {
			PseudoRandom calc = (PseudoRandom) obj;
			calc.initialSeed = (calc.multiplier * calc.initialSeed + calc.increment) % calc.modulus;
			if (calc.initialSeed < 0) {
				calc.initialSeed *= -1;
			}
			mod = (double)calc.modulus;
		}
		return initialSeed / mod;
	}

	
}
