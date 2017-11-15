package tp.v2;

public class TestFilMutImpl {

    public static void main(String[] args) {
        System.out.println(test());
    }

    private static String test(){
        String ret = "--Test file mutable implementation-- \n";
        int cas = 0;
        int totalCas = 0;

        FileMutableImplementation<Integer> file = new FileMutableImplementation<Integer>();

        //Test 1
        totalCas++;
        file.ajouter(1);
        if(file.taille() == 1 && file.premier() == 1){
            cas++;
        }
        else {
            ret += "Error : ajouter()\n";
        }

        //Test 2
        totalCas++;
        file.retirer();
        if(file.taille() == 0){
            cas++;
        }
        else {
            ret += "Error : retirer()\n";
        }

        //Test 3
        totalCas++;
        file.retirer();
        if(file.taille() == 0){
            cas++;
        }
        else {
            ret += "Error : retirer() when empty\n";
        }

        //Test 4
        totalCas++;
        file.ajouter(1);
        file.ajouter(2);
        FileMutableImplementation<Integer> filecopy = file.creerCopie();
        if(filecopy.taille() == 2 && filecopy.premier() == 1 && filecopy.suivants().premier() == 2){
            cas++;
        }
        else {
            ret += "Error : creerCopie()\n";
        }


        ret += "Result : "+cas+"/"+totalCas+"\n\n";
        return ret;

    }

}
