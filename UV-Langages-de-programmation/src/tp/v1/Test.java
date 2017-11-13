package tp.v1;

public class Test {
	
	public static void main(String[] args) {

		System.out.println(testConstructor());
		System.out.println(testIsEmpty());
		System.out.println(testPushElem());
		System.out.println(testPopElem());
	}

	private static String testConstructor(){
		String ret = "--Test Constructor-- \n";
		int cas = 0;
		int totalCas = 0;

		//Create an empty Fifo
		Fifo fifo = new Fifo();

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

	private static String testIsEmpty(){
		String ret = "--Test isEmpty-- \n";
		int cas = 0;
		int totalCas = 0;

		//Create an empty Fifo
		Fifo fifo = new Fifo();

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

	private static String testPushElem(){
		String ret = "--Test pushElem-- \n";
		int cas = 0;
		int totalCas = 0;

		//Create an Fifo
		Fifo fifo = new Fifo();
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

	private static String testPopElem(){
		String ret = "--Test popElem-- \n";
		int cas = 0;
		int totalCas = 0;

		//Create an empty Fifo
		Fifo fifo = new Fifo();

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
