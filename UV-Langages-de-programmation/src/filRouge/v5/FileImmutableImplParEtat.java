package filRouge.v5;

import java.util.Iterator;

public class FileImmutableImplParEtat<E> implements FileImmutable<E> {

    EtatImmutable<E> etat;

    public FileImmutableImplParEtat() {
        this.etat = new EtatImmutableImpl<>();
    }

    public FileImmutableImplParEtat(EtatImmutable<E> etat) {
        this.etat = etat;
    }

    @Override
    public FileImmutableImplParEtat<E> creer(E dernier) {
        EtatImmutable<E> e = etat.creer(dernier);
        return new FileImmutableImplParEtat<E>(e);
    }

    @Override
    public FileImmutable<E> creer() {
        EtatImmutable<E> e = etat.creer();
        return new FileImmutableImplParEtat<E>(e);
    }

    @Override
    public E premier() {
        return etat.premier();
    }

    @Override
    public FileImmutableImplParEtat<E> suivants() {
        EtatImmutable<E> e = etat.suivants();
        return new FileImmutableImplParEtat<E>(e);
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
}
