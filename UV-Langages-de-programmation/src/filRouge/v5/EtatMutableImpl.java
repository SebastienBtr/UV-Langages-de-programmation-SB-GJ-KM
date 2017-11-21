package filRouge.v5;

import java.util.Iterator;

public class EtatMutableImpl<E> implements EtatMutable<E> {

    private ListeMutable<E> liste;
    private ListeMutable<E> fin;

    private int taille;

    public EtatMutableImpl() {
        this.liste = ListeMutable.vide();
        this.fin = null;
        this.taille = 0;
    }

    public EtatMutableImpl(int taille, ListeMutable<E> listeTete, ListeMutable<E> listeFin) {
        this.taille = taille;
        if (listeTete.estVide()) {
            ListeMutable<E> vide = listeTete;
            listeTete = listeFin.miroir();
            listeFin = vide;
        }
        this.liste = listeTete;
        this.fin = listeFin;
    }

    @Override
    public void ajouter(E element) {

        if (this.estVide()) {
            ListeMutable<E> nouvelElement = ListeMutable.cons(element, this.liste);
            this.liste = nouvelElement;
            this.fin = nouvelElement;
            this.taille++;
            return;
        }

        ListeMutable<E> nouvelElement = ListeMutable.cons(element, this.fin.reste());
        this.fin.changerReste(nouvelElement);
        this.fin = nouvelElement;
        this.taille++;
    }

    @Override
    public void retirer() {
        if (this.estVide()) {
            throw new UnsupportedOperationException();
        }
        this.liste = this.liste.reste();
        this.taille--;
    }

    @Override
    public E premier() {
        if (this.estVide()) {
            throw new UnsupportedOperationException();
        }
        return this.liste.tete();
    }

    @Override
    public int taille() {
        return taille;
    }

    @Override
    public Iterator<E> iterator() {
        return new IterateurListe<>(liste);
    }

    @Override
    public EtatMutable<E> creer() {
        return new EtatMutableImpl<E>();
    }

    @Override
    public EtatMutable<E> creerCopie() {
        return new EtatMutableImpl<E>(taille,liste,fin);
    }
}
