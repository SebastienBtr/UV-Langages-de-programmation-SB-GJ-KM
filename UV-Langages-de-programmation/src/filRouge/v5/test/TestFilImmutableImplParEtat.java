package filRouge.v5.test;

import filRouge.v5.FileImmutableImplParEtat;

public class TestFilImmutableImplParEtat {

    public static void main(String[] args) {
        System.out.println(test());
    }

    private static String test() {
        String ret = "--Test file immutable implementation-- \n";
        int cas = 0;
        int totalCas = 0;

        FileImmutableImplParEtat<Integer> file = new FileImmutableImplParEtat<Integer>();

        //Test 1
        totalCas++;
        FileImmutableImplParEtat<Integer> file1 = file.creer(1);
        if (file1.taille() == 1 && file1.premier() == 1) {
            cas++;
        } else {
            ret += "Error : creer (1er essai)()\n";
        }

        //Test 2
        totalCas++;
        FileImmutableImplParEtat<Integer> file2 = file1.creer(2);
        if (file2.taille() == 2 && file2.suivants().premier() == 2) {
            cas++;
        } else {
            ret += "Error : creer (2eme essai)()\n";
        }

        //Test 3
        totalCas++;
        if (file1.premier() == 1) {
            cas++;
        } else {
            ret += "Error : premier()\n";
        }

        //Test 4
        totalCas++;
        FileImmutableImplParEtat<Integer> file3 = file2.suivants();
        if (file3.taille() == 1 && file3.premier() == 2) {
            cas++;
        } else {
            ret += "Error : suivants()\n";
        }

        ret += "Result : " + cas + "/" + totalCas + "\n\n";
        return ret;
    }

}
