package tp.v2;


public class Test {

	public static void main(String[] args) {
		test();
	}

	private static void test (){
		String ret = "--Test cons-- \n";


		//Create an empty Fifo
		ListeMutable<Integer> list = ListeMutable.cons(1,ListeMutable.vide());
		ListeMutable<Integer> list2 = ListeMutable.cons(2,list);
		ListeMutable<Integer> list3 = ListeMutable.cons(3,list2);
		ListeMutable<Integer> list4 = ListeMutable.cons(4,list3);

		System.out.println("---------TEST MUTABLE---------");
		System.out.println(list4.tete());
		System.out.println(list4.reste().tete());
		System.out.println(list4.reste().reste().tete());
		System.out.println(list4.reste().reste().reste().tete());

		ListeMutable<Integer> list5 = list4.miroir();

		System.out.println("Expected : 1 2 3 4");

		System.out.println(list5.tete());
		System.out.println(list5.reste().tete());
		System.out.println(list5.reste().reste().tete());
		System.out.println(list5.reste().reste().reste().tete());


	}

}