package tp1;

public class Fifo implements Lane<Element> {

	private Element first;
	private Element last;

	public Fifo(){
		this.first = null;
		this.last = null;
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
	}

	@Override
	public Element popElem() {
		Element ret;
		if(this.isEmpty()) ret = null;
		else {
			ret = this.first;
			this.first = ret.getNext();
		}

		return ret;
	}

	@Override
	public boolean isEmpty() {
		boolean ret = false;
		if(this.first == null) ret = true;

		return ret;
	}

	@Override
	public int getLength() {
		int ret = 0;
		if(!this.isEmpty()){
			Element current = this.first;
			ret++;
			while(current.getNext() != null){
				current = current.getNext();
				ret++;
			}
		}

		return ret;
	}

}
