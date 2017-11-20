package filRouge.v5;

import java.util.Iterator;

public class EtatImmutableImpl<E> implements EtatImmutable<E> {

    private ListeImmutable<E> listeDebut; // liste de tete dans l'ordre d'arrivée
    private ListeImmutable<E> listeFin;// liste de queue dans l'ordre inverse d'arrivée

    private int taille;

    @Override
    public E premier() {
        if (this.estVide()) {
            throw new UnsupportedOperationException();
        }
        return this.listeDebut.tete();
    }

    @Override
    public int taille() {
        return this.taille;
    }

    @Override
    public FileImmutable<E> suivants() {
        if (this.estVide()) {
            throw new UnsupportedOperationException();
        }
        //return new EnveloppeDeuxListesImmutables<E>(this.taille - 1, this.listeDebut.reste(), this.listeFin);
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return new IterateurListe<>(this.listeDebut);
    }
}
