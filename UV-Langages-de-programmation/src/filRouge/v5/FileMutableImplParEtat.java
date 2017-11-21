package filRouge.v5;

import java.util.Iterator;

public class FileMutableImplParEtat<E> implements FileMutable<E> {

    EtatMutable<E> etat = new EtatMutableImpl<>();

    FileMutableImplParEtat(EtatMutable<E> etat) {
        this.etat = etat;
    }

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
        EtatMutable<E> e = etat.suivants();
        return new FileMutableImplParEtat<E>(e);
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
    public FileMutableImplParEtat<E> creer() {
        EtatMutable<E> e = etat.creer();
        return new FileMutableImplParEtat<E>(e);
    }

    @Override
    public FileMutableImplParEtat<E> creerCopie() {
        EtatMutable<E> e = etat.creerCopie();
        return new FileMutableImplParEtat<E>(e);
    }
}
