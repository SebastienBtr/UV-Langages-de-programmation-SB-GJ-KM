package filRouge.v5;

import java.util.Iterator;

public class EtatImmutableImpl<E> implements EtatImmutable<E> {

    private ListeImmutable<E> listeDebut; // liste de tete dans l'ordre d'arrivée
    private ListeImmutable<E> listeFin;// liste de queue dans l'ordre inverse d'arrivée

    private int taille;

    public EtatImmutableImpl() {
        ListeImmutable<E> vide = ListeImmutable.vide();
        this.listeFin = vide;
        this.listeDebut = vide;
        this.taille = 0;
    }

    public EtatImmutableImpl(int taille, ListeImmutable<E> listeTete, ListeImmutable<E> listeFin) {
        this.taille = taille;
        if (listeTete.estVide()) {
            ListeImmutable<E> vide = listeTete;
            listeTete = listeFin.miroir();
            listeFin = vide;
        }
        this.listeDebut = listeTete;
        this.listeFin = listeFin;
    }

    @Override
    public EtatImmutable<E> creer() {
        return new EtatImmutableImpl<E>();
    }

    @Override
    public EtatImmutable<E> creer(E dernier) {
        return new EtatImmutableImpl<E>(this.taille + 1, this.listeDebut,
                ListeImmutable.cons(dernier, this.listeFin));
    }

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
    public EtatImmutable<E> suivants() {
        if (this.estVide()) {
            throw new UnsupportedOperationException();
        }
        return new EtatImmutableImpl<E>(this.taille - 1, this.listeDebut.reste(), this.listeFin);
    }

    @Override
    public Iterator<E> iterator() {
        return new IterateurFile<>(this);
    }
}
