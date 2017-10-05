package tp1;

public interface Lane<E> {
	
	/**
	 * Add an element to the lane 
	 */
    public void pushElem(E e);
    
    /**
     * Remove an element of the lane
     * @return The element removed
     */
    public E popElem();
    
    /**
     * Check if the lane is empty
     * @return true if the lane is empty
     */
    public boolean isEmpty();
    
    /**
     * @return the lane's length
     */
    public int getLength();
}
