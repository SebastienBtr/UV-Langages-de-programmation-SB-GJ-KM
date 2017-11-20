package filRouge.v5;

import java.util.Iterator;

public class FileMutableImplParEtat<E> implements FileMutable<E> {

    EtatMutable<E> etat = new EtatMutableImpl<>();

    @Override
    public void ajouter(E element) {
        etat.ajouter(element);
    }

    @Override
    public void retirer() {
        etat.retirer();
    }

    @Override
    public E premier() {
        return etat.premier();
    }

    @Override
    public FileMutable<E> suivants() {
        return etat.suivants();
    }

    @Override
    public boolean estVide() {
        return etat.estVide();
    }

    @Override
    public int taille() {
        return etat.taille();
    }

    @Override
    public Iterator<E> iterator() {
        return etat.iterator();
    }

    @Override
    public FileMutable<E> creer() {
        return null;
    }

    @Override
    public FileMutable<E> creerCopie() {
        return null;
    }
}
