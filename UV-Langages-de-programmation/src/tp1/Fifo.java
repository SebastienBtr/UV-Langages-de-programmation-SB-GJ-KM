package tp1;
/**
 * Implement of a Lane for Fifo (mutable list)
 * @author K.Mer, G.Jacquet, S.Bouttier
 */
public class Fifo implements Lane<Element> {
	private Element first;
	private Element last;
	private int length;
	/**
	 * Constructor of the class
	 * Create an empty Lane (Set the first/last element to null)
	 */
	public Fifo(){
		this.first = null;
		this.last = null;
		this.length = 0;
	}
	/**
	 * Add an element at the end of the Lane
	 * @param e - The new element to add
	 */
	@Override
	public void pushElem(Element e) {
		if(this.isEmpty()) {
			this.first = e;
			this.last = e;
		}
		else {
			Element tmp = this.last;
			this.last = e;
			tmp.setNext(this.last);
		}
		this.length++;
	}
	/**
	 * Remove the first element of the Lane
	 * @return the value of the element
	 */
	@Override
	public Object popElem() {
		Object ret;
		if(this.isEmpty()) ret = null;
		else {
			Element tmp = this.first;
			this.first = tmp.getNext();
			this.length--;
			ret = tmp.getValue();
		}
		return ret;
	}
	/**
	 * @return false is the lane is empty
	 */
	@Override
	public boolean isEmpty() {
		boolean ret = false;
		if(this.length == 0) ret = true;
		return ret;
	}
	/**
	 * @return the length of the lane
	 */
	@Override
	public int getLength() {
		return this.length;
	}
	/**
	 * @return the first element of the lane
	 */
	public Element getFirst() {
		return first;
	}
	/**
	 * @return the last element of the lane
	 */
	public Element getLast() {
		return last;
	}
}