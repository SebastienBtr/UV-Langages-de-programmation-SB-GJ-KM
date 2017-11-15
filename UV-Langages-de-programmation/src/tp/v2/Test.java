package tp.v2;


public class Test {

	public static void main(String[] args) {
		test();
	}

	private static void test (){
		String ret = "--Test cons-- \n";



		FileMutableImplementation<Integer> file = new FileMutableImplementation<Integer>();

		System.out.println("__________________________");
		file.ajouter(1);
		System.out.println("Add 1 : "+file.premier());
		file.ajouter(3);
		System.out.print("Add 3 : " + file.premier());
		System.out.println(file.suivants().premier());
		file.retirer();
		System.out.println("Retirer : " +file.premier());

		file.ajouter(2);
		System.out.print("Add 2 : " + file.premier());
		System.out.println(file.suivants().premier());

		FileMutableImplementation<Integer> file2 = new FileMutableImplementation<Integer>();
		file2.ajouter(3);
		file2.ajouter(2);
		file2.retirer();
		file2.ajouter(2);

		System.out.print("File 2 : " + file2.premier());
		System.out.println(file2.suivants().premier());

		System.out.println(file.estEgal(file2));
	}

}