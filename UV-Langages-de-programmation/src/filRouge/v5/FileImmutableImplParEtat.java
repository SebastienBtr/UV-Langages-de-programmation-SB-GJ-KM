package filRouge.v5;

import java.util.Iterator;

public class FileImmutableImplParEtat<E> implements FileImmutable<E> {

    EtatImmutable<E> etat = new EtatImmutableImpl<>();

    FileImmutableImplParEtat(EtatImmutable<E> etat) {
        this.etat = etat;
    }

    @Override
    public FileImmutable<E> creer(E dernier) {
        EtatImmutable<E> e = etat.creer(dernier);
        return new FileImmutableImplParEtat<>(e);
    }

    @Override
    public FileImmutable<E> creer() {
        EtatImmutable<E> e = etat.creer();
        return new FileImmutableImplParEtat<>(e);
    }

    @Override
    public E premier() {
        return etat.premier();
    }

    @Override
    public FileImmutable<E> suivants() {
        EtatImmutable<E> e = etat.suivants();
        return new FileImmutableImplParEtat<>(e);
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
