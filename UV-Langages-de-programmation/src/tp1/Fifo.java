package tp1;

public class Fifo implements Lane<Element> {

	private Element first;
	private Element last;
	private int length;

	public Fifo(){
		this.first = null;
		this.last = null;
		this.length = 0;
	}

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

	@Override
	public Element popElem() {
		Element ret;
		if(this.isEmpty()) ret = null;
		else {
			ret = this.first;
			this.first = ret.getNext();
			this.length--;
		}

		return ret;
	}

	@Override
	public boolean isEmpty() {
		boolean ret = false;
		if(this.length == 0) ret = true;

		return ret;
	}

	@Override
	public int getLength() {
		return this.length;
	}

}
