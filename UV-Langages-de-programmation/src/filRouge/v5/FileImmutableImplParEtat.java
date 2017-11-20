package filRouge.v5;

import java.util.Iterator;

public class FileImmutableImplParEtat<E> implements FileImmutable<E> {

    EtatImmutable<E> etat = new EtatImmutableImpl<>();

    @Override
    public FileImmutable<E> creer(E dernier) {
        return null;
    }

    @Override
    public FileImmutable<E> creer() {
        return null;
    }

    @Override
    public E premier() {
        return etat.premier();
    }

    @Override
    public FileImmutable<E> suivants() {
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
}
