package tp1;

public class Test {
	
	public static void main(String[] args) {
		Element elem1 = new Element(5);
		Element elem2 = new Element("test");

		Fifo fifo = new Fifo();

		System.out.println(fifo.isEmpty());
		System.out.println(fifo.popElem());

		fifo.pushElem(elem1);

		System.out.println(fifo.isEmpty());
		System.out.println(fifo.getLength());

		fifo.pushElem(elem2);

		System.out.println(fifo.getLength());
		System.out.println(fifo.popElem());
		System.out.println(fifo.getLength());

	}
}
