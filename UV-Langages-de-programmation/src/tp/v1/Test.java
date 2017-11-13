<<<<<<< HEAD:UV-Langages-de-programmation/src/tp/v1/Test.java
package tp.v1;

=======
package tp1;
>>>>>>> bf47f2e671a7676eb49cd3dda2a097fbcb71b655:UV-Langages-de-programmation/src/tp1/Test.java
public class Test {

	public static void main(String[] args) {
		FifoFactory fifoFa = new FifoFactory();
		System.out.println(testConstructor(fifoFa));
		System.out.println(testIsEmpty(fifoFa));
		System.out.println(testPushElem(fifoFa));
		System.out.println(testPopElem(fifoFa));
	}
	private static String testConstructor(FifoFactory factory){
		String ret = "--Test Constructor-- \n";
		int cas = 0;
		int totalCas = 0;
		//Create an empty Fifo
		Fifo fifo = factory.createLane();
		//Test 1
		totalCas++;
		if(fifo.getFirst() == null){
			cas++;
		}
		else {
			ret += "Error : First non null \n";
		}
		//Test2
		totalCas++;
		if(fifo.getLast() == null){
			cas++;
		}
		else {
			ret += "Error : Last non null \n";
		}
		//Test3
		totalCas++;
		if(fifo.getLength() == 0){
			cas++;
		}
		else {
			ret += "Error : Length != 0 \n";
		}
		ret += "Result : "+cas+"/"+totalCas+"\n\n";
		return ret;
	}
	private static String testIsEmpty(FifoFactory factory){
		String ret = "--Test isEmpty-- \n";
		int cas = 0;
		int totalCas = 0;
		//Create an empty Fifo
		Fifo fifo = factory.createLane();
		//Test 1
		totalCas++;
		if(fifo.isEmpty() == true){
			cas++;
		}
		else {
			ret += "Error : Fifo not Empty \n";
		}
		ret += "Result : "+cas+"/"+totalCas+"\n\n";
		return ret;
	}
	private static String testPushElem(FifoFactory factory){
		String ret = "--Test pushElem-- \n";
		int cas = 0;
		int totalCas = 0;
		//Create an Fifo
		Fifo fifo = factory.createLane();
		Element elem1 = new Element(5);
		fifo.pushElem(elem1);
		//Test 1
		totalCas++;
		if(fifo.isEmpty() == false && fifo.getLength() == 1){
			cas++;
		}
		else {
			ret += "Error : Fifo Empty / Wrong length\n";
		}
		//Test 2
		totalCas++;
		Element elem2 = new Element(8);
		fifo.pushElem(elem2);
		if(fifo.isEmpty() == false && fifo.getLength() == 2){
			cas++;
		}
		else {
			ret += "Error : Fifo Empty / Wrong length\n";
		}
		//Test 3
		totalCas++;
		if(elem1.getNext().getValue() == elem2.getValue()){
			cas++;
		}
		else {
			ret += "Error : Wrong Next element \n";
		}
		ret += "Result : "+cas+"/"+totalCas+"\n\n";
		return ret;
	}
	private static String testPopElem(FifoFactory factory){
		String ret = "--Test popElem-- \n";
		int cas = 0;
		int totalCas = 0;
		//Create an empty Fifo
		Fifo fifo = factory.createLane();
		//Test 1
		totalCas++;
		if(fifo.popElem() == null){
			cas++;
		}
		else {
			ret += "Error : Wrong Pop on empty Fifo\n";
		}
		//Test 2
		totalCas++;
		Element elem1 = new Element(8);
		fifo.pushElem(elem1);
		if(((int)fifo.popElem()) == 8){
			cas++;
		}
		else {
			ret += "Error : Wrong value on pop\n";
		}
		//Test 3
		totalCas++;
		Element elem2 = new Element("String");
		fifo.pushElem(elem2);
		fifo.pushElem(elem1);
		if(((String)fifo.popElem()).equals("String")){
			cas++;
		}
		else {
			ret += "Error : value on pop\n";
		}
		//Test 4
		totalCas++;
		fifo.pushElem(elem2);
		fifo.popElem();
		if(fifo.getLength() == 1){
			cas++;
		}
		else {
			ret += "Error : Wrong length on pop\n";
		}
		ret += "Result : "+cas+"/"+totalCas+"\n\n";
		return ret;
	}
}