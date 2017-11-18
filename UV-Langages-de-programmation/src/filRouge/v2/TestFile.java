package filRouge.v2;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;



public class TestFile {

	private static final ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();
	private static long diviseur = 100000;

	public static void main(String[] args) {

		FileMutable<Integer> file1 = new EnveloppeListeMutableDoubleAcces<>();
		testerUsageLineaire(file1);

		File<Integer> file = file1;
		tester(file);
		testerUsageLineaire(file);
		file = new EnveloppeDeuxListesImmutables<>();
		tester(file);
		testerUsageLineaire(file);

		Queue<Integer> f = new LinkedList<>();
		testerUsageLineaire(f);

		file1 = new EnveloppeListeMutableDoubleAcces<>();
		testerUsageLineaire(file1);

	}

	private static void tester(File<Integer> file) {
		int t = 10;

		System.out.println("--------------------------------------------------------");
		System.out.println("*** Test de " + file.getClass() + " ***");

		System.out.println("vide (true) : " + file.estVide());
		Iterator<Integer> iter = file.iterator();
		System.out.println("itérateur a un suivant (false) : " + iter.hasNext());
		file = file.ajout(11);
		System.out.println("[11] : " + file);
		file = file.retrait();
		System.out.println("[] : " + file);
		file = file.ajout(11);
		System.out.println("[11] : " + file);
		file = file.retrait();
		System.out.println("[] : " + file);

		for (int i = 0; i < t; i++) {
			file = file.ajout(i);
		}
		System.out.println(file);
		System.out.println("taille (" + t + ") : " + file.taille());
		System.out.println("tete 0 : " + file.premier());
		;
		System.out.println("taille (" + t + ") : " + file.taille());
		file = file.retrait();
		System.out.println("tete 1 : " + file.premier());
		System.out.println("vide (false) : " + file.estVide());
		System.out.println("taille (" + (t - 1) + ") : " + file.taille());
		for (int i : file) {
			System.out.print(" " + i);
		}
		System.out.println(" ");
	}

	@SuppressWarnings("unused")
	private static void testerUsageNonLineaire(File<Integer> file) {
		int t = 11180000;
		long time = threadBean.getCurrentThreadCpuTime();

		for (int i = 0; i < t; i++) {
			file = file.ajout(i);
		}
		for (int i = 0; i < t; i++) {
			File<Integer> f = file.retrait();
		}

		time = threadBean.getCurrentThreadCpuTime() - time;
		System.out.println(file.getClass() + " - ajout/retrait: " + (time / diviseur));

	}

	private static void testerUsageLineaire(File<Integer> file) {
		int t = 11180000;
		long time = threadBean.getCurrentThreadCpuTime();

		for (int i = 0; i < t; i++) {
			file = file.ajout(i);
		}
		while (!file.estVide()) {
			file = file.retrait();
		}

		time = threadBean.getCurrentThreadCpuTime() - time;
		System.out.println(file.getClass() + " - ajout/retrait: " + (time / diviseur));

	}

	private static void testerUsageLineaire(FileMutable<Integer> file) {
		int t = 11180000;
		long time = threadBean.getCurrentThreadCpuTime();

		for (int i = 0; i < t; i++) {
			file.ajouter(i);
		}
		while (!file.estVide()) {
			file.retirer();
		}

		time = threadBean.getCurrentThreadCpuTime() - time;
		System.out.println(file.getClass() + " - ajout/retrait: " + (time / diviseur));

	}
	
	private static void testerUsageLineaire(Queue<Integer> file) {
		int t = 11180000;
		long time = threadBean.getCurrentThreadCpuTime();

		for (int i = 0; i < t; i++) {
			file.add(i);
		}
		while (!file.isEmpty()) {
			file.poll();
		}

		time = threadBean.getCurrentThreadCpuTime() - time;
		System.out.println(file.getClass() + " - ajout/retrait: " + (time / diviseur));

	}

	
}




