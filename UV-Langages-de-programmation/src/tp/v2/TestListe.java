package tp.v2;

import java.util.List;

public class TestListe {

    public static void main(String[] args) {
        System.out.println(testListeVide());
        System.out.println(testListeCons());
        System.out.println(testListeMutableVide());
        System.out.println(testListeMutableCons());
    }

    private static String testListeVide(){
        String ret = "--Test Liste vide-- \n";
        int cas = 0;
        int totalCas = 0;

        Liste<Integer> list = Liste.vide();

        //Test 1
        totalCas++;
        if(list.casVide() && list.estVide() && !list.casCons()){
            cas++;
        }
        else {
            ret += "Error : casVide() et estVide() et casCons()\n";
        }
        //Test2
        totalCas++;
        if(list.iterator() == null){
            cas++;
        }
        else {
            ret += "Error : iterator() \n";
        }

        //Test3
        totalCas++;
        if(list.miroir().estVide()){
            cas++;
        }
        else {
            ret += "Error : miroir() \n";
        }

        ret += "Result : "+cas+"/"+totalCas+"\n\n";
        return ret;

    }

    private static String testListeCons() {
        String ret = "--Test Liste Cons-- \n";
        int cas = 0;
        int totalCas = 0;

        Liste<Integer> list = Liste.cons(1,Liste.vide());

        //Test 1
        totalCas++;
        if(!list.casVide() && !list.estVide() && list.casCons()){
            cas++;
        }
        else {
            ret += "Error : casVide() et estVide() et casCons()\n";
        }

        //Test 2
        totalCas++;
        if(list.tete() == 1){
            cas++;
        }
        else {
            ret += "Error : tete()\n";
        }

        //Test 3
        totalCas++;
        if(list.reste().estVide()){
            cas++;
        }
        else {
            ret += "Error : reste() vide\n";
        }

        //Test 4
        Liste<Integer> list2 = Liste.cons(2,list);
        totalCas++;
        if(list2.reste().tete() == 1){
            cas++;
        }
        else {
            ret += "Error : reste() non vide\n";
        }

        //Test 5
        totalCas++;
        if(list2.taille() == 2){
            cas++;
        }
        else {
            ret += "Error : taille()\n";
        }

        //Test 6
        totalCas++;
        Liste<Integer> list3 = list2.miroir();
        if(list3.tete() == 1 && list3.reste().tete() == 2){
            cas++;
        }
        else {
            ret += "Error : miroir()\n";
        }

        ret += "Result : "+cas+"/"+totalCas+"\n\n";
        return ret;
    }

    private static String testListeMutableVide() {
        String ret = "--Test Liste Mutable vide-- \n";
        int cas = 0;
        int totalCas = 0;

        ListeMutable<Integer> list = ListeMutable.vide();

        //Test 1
        totalCas++;
        if(list.casVide() && list.estVide() && !list.casCons()){
            cas++;
        }
        else {
            ret += "Error : casVide() et estVide() et casCons()\n";
        }
        //Test2
        totalCas++;
        if(list.iterator() == null){
            cas++;
        }
        else {
            ret += "Error : iterator() \n";
        }

        //Test3
        totalCas++;
        if(list.miroir().estVide()){
            cas++;
        }
        else {
            ret += "Error : miroir() \n";
        }

        ret += "Result : "+cas+"/"+totalCas+"\n\n";
        return ret;
    }

    private static String testListeMutableCons() {
        String ret = "--Test Liste Mutable Cons-- \n";
        int cas = 0;
        int totalCas = 0;

        ListeMutable<Integer> list = ListeMutable.cons(1,ListeMutable.vide());

        //Test 1
        totalCas++;
        if(!list.casVide() && !list.estVide() && list.casCons()){
            cas++;
        }
        else {
            ret += "Error : casVide() et estVide() et casCons()\n";
        }

        //Test 2
        totalCas++;
        if(list.tete() == 1){
            cas++;
        }
        else {
            ret += "Error : tete()\n";
        }

        //Test 3
        totalCas++;
        if(list.reste().estVide()){
            cas++;
        }
        else {
            ret += "Error : reste() vide\n";
        }

        //Test 4
        ListeMutable<Integer> list2 = ListeMutable.cons(2,list);
        totalCas++;
        if(list2.reste().tete() == 1){
            cas++;
        }
        else {
            ret += "Error : reste() non vide\n";
        }

        //Test 5
        totalCas++;
        if(list2.taille() == 2){
            cas++;
        }
        else {
            ret += "Error : taille()\n";
        }

        //Test 6
        totalCas++;
        ListeMutable<Integer> list3 = list2.miroir();
        if(list3.tete() == 1 && list3.reste().tete() == 2){
            cas++;
        }
        else {
            ret += "Error : miroir()\n";
        }

        ret += "Result : "+cas+"/"+totalCas+"\n\n";
        return ret;
    }
}
