package filRouge.v6;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.Iterator;



public class TestFile {

	private static final ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();
	private static long diviseur = 100000;

	public static void main(String[] args) {
		
		//FileImmutable<Integer> file = new FileImmutableAvecEtatReifie<>(new EtatEnveloppeDeuxListesImmutables<>());

		FileImmutable<Integer> file = new FileImmutableAvecEtatReifie<>(EtatImmutableAvecInversionParesseuse.vide());

		tester(file);
		testerUsageLineaire(file);
		testerUsageNonLineaire(file); // temps trop long
	}

	private static <K extends File<K, Integer>> void tester(K file) {
		int t = 10;

		System.out.println("--------------------------------------------------------");
		System.out.println("*** Test de " + file.getClass() + " ***");

		System.out.println("vide (true) : " + file.estVide());
		Iterator<Integer> iter = file.iterator();
		System.out.println("itérateur a un suivant (false) : " + iter.hasNext());
		file = file.ajout(11);
		System.out.println("[11] : " + file);
        System.out.println(file.taille());
        file = file.retrait();
		System.out.println("[] : " + file);
        System.out.println(file.taille());
        file = file.ajout(11);
		System.out.println("[11] : " + file);
        System.out.println(file.taille());
        file = file.retrait();
		System.out.println("[] : " + file);
        System.out.println(file.taille());

        for (int i = 0; i < t; i++) {
            file = file.ajout(i);
		}
        System.out.println("fin for");
        System.out.println("0 1 ... " + (t-1) + " : " + file);
		System.out.println("taille (" + t + ") : " + file.taille());
		System.out.println("tete 0 : " + file.premier());
		;
		System.out.println("taille (" + t + ") : " + file.taille());
		file = file.retrait();
		System.out.println("tete 1 : " + file.premier());
		System.out.println("vide (false) : " + file.estVide());
		System.out.println("taille (" + (t - 1) + ") : " + file.taille());
		System.out.print("1 ... " + (t-1) + " :");
		for (int i : file) {
			System.out.print(" " + i);
		}
		System.out.println(" ");
	}

	@SuppressWarnings("unused")
	private static <K extends File<K, Integer>> void testerUsageNonLineaire(K file) {
        System.out.println("usage non lineaire :");
        int t = 1118000;
		long time = threadBean.getCurrentThreadCpuTime();

		for (int i = 0; i < t; i++) {
			file = file.ajout(i);
		}
		for (int i = 0; i < t; i++) {
			K f = file.retrait();
		}

		time = threadBean.getCurrentThreadCpuTime() - time;
		System.out.println(file.getClass() + " - ajout/retrait (non linéaire) : " + (time / diviseur));

	}


	private static <K extends File<K, Integer>> void testerUsageLineaire(K file) {
		int t = 1118000;
		long time = threadBean.getCurrentThreadCpuTime();

		for (int i = 0; i < t; i++) {
			file = file.ajout(i);
		}
		while (!file.estVide()) {
			file = file.retrait();
		}

		time = threadBean.getCurrentThreadCpuTime() - time;
		System.out.println(file.getClass() + " - ajout/retrait (linéaire) : " + (time / diviseur));

	}

}




