
/**
 * holds a set of numbers, duplicates allowed.
 */
public class IntArrayBag {
	
	private int[] data;
    private int manyItems;
    
    
    
    /**
     *  initializes a bag
     * @param data, array that holds all ints
     * @param manyItems, int size of array
     */
    public IntArrayBag(int[] data, int manyItems) {
		this.data = data;
		this.manyItems = manyItems;
	}
    
    
    
    /**
     *  detects if same number of values exist in both bags
     * @param b is another ArrayBag.
     * @return true or false
     */
    public boolean equals(IntArrayBag b) {
        if (this.manyItems != b.manyItems) {
            return false;
        }
        boolean found = false;
        
        for(int i : this.data) {
        	for(int j : b.data) {
        		if(i == j){
        			found = true;
        		}
        	}
        	if(!found) {
        		return false;
        	}
        }
        return true;
    }
}
