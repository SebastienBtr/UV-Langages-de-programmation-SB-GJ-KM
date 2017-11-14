package tp.v2;

import java.util.Iterator;

public class FileMutatableImplementation<E> implements FileMutable<E> {


    ListeMutable<E> liste;
    ListeMutable<E> fin;


    @Override
    public void ajouter(E element) {

        if(this.liste.estVide()) {
            this.liste = ListeMutable.cons(element,ListeMutable.vide());
        }else {
            liste = ListeMutable.cons(element,liste);
        }

        this.fin = ListeMutable.cons(element,ListeMutable.vide());
    }

    @Override
    public void retirer() {
        this.liste = this.liste.reste();
    }

    @Override
    public E premier() {
        return this.liste.tete();
    }

    @Override
    public int taille() {
        return this.liste.taille();
    }

    @Override
    public FileMutable<E> creer() {
        return null;
    }

    @Override
    public FileMutable<E> creerCopie() {
        return null;
    }

    @Override
    public void ajouter(File<E> secondeFile) {

    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
