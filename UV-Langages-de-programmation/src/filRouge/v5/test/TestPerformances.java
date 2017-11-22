package filRouge.v5.test;
import filRouge.v5.*;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

public class TestPerformances {

    private static final ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();
    private static long diviseur = 100000;

    public static void main(String[] args) {
        testPerformanceFileMutableEtatImpl();
        testPerformanceFileImmutableEtatImpl();
    }

    private static void testPerformanceFileMutableEtatImpl(){
        long temps = threadBean.getCurrentThreadCpuTime();

        FileMutable<Integer> file = new FileMutableImplParEtat<Integer>();

        //Ajout
        file.ajouter(1);

        //Retrait
        file.retirer();

        temps = threadBean.getCurrentThreadCpuTime() - temps;
        System.out.println(file.getClass() + " - ajout/retrait: " + (temps / diviseur));
    }

    private static void testPerformanceFileImmutableEtatImpl(){
        long temps = threadBean.getCurrentThreadCpuTime();

        FileImmutable<Integer> file = new FileImmutableImplParEtat<Integer>();

        //Ajout
        file = file.creer(1);

        //Retrait
        file = file.suivants();

        temps = threadBean.getCurrentThreadCpuTime() - temps;
        System.out.println(file.getClass() + " - ajout/retrait: " + (temps / diviseur));
    }
}
