package tp.v1;

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

	public Element getFirst() {
		return first;
	}

	public Element getLast() {
		return last;
	}
}
