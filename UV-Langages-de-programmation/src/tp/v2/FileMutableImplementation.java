package tp.v2;

import java.util.Iterator;

public class FileMutableImplementation<E> implements FileMutable<E> {


    ListeMutable<E> liste;
    ListeMutable<E> fin;

    public FileMutableImplementation() {
        this.liste = ListeMutable.vide();
        this.fin = ListeMutable.vide();
    }

    @Override
    public void ajouter(E element) {
        if(this.liste.estVide()){
            this.liste = ListeMutable.cons(element, ListeMutable.vide());
            this.fin = ListeMutable.cons(element, ListeMutable.vide());
        }
        else {
            this.liste = liste.miroir();
            this.liste = ListeMutable.cons(element, this.liste);
            this.liste = liste.miroir();

            this.fin = ListeMutable.cons(element, ListeMutable.vide());
        }
    }

    @Override
    public void retirer() {
        if (taille() == 1) {
            liste = ListeMutable.vide();
        }
        else if(taille() > 1) this.liste = ListeMutable.cons(liste.reste().tete(),liste.reste().reste());
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
    public FileMutableImplementation<E> creer() {
        FileMutableImplementation<E> ret = new FileMutableImplementation<E>();

        return ret;
    }

    @Override
    public FileMutableImplementation<E> creerCopie() {
        if(taille() == 0){
            return this.creer();
        }
        else {
            FileMutableImplementation<E> ret = new FileMutableImplementation<E>();
            ret.liste = ListeMutable.cons(this.liste.tete(),this.liste.reste());
            ret.fin = ListeMutable.cons(this.fin.tete(), this.fin.reste());

            return ret;
        }
    }

    @Override
    public void ajouter(File<E> secondeFile) {

        for(E e : secondeFile){
            this.ajouter(e);
        }
    }

    @Override
    public Iterator<E> iterator() {

        return new IterateurListe<E>() {
            FileMutable<E> list = FileMutableImplementation.this.creerCopie();

            public boolean hasNext() {
                return !list.estVide();
            }

            public E next() {
                E ret = list.premier();
                list = list.suivants();

                return ret;
            }
        };
    }
}
