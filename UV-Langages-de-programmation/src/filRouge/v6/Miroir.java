package filRouge.v6;

import filRouge.v5.ListeImmutable;

public class Miroir<E> {

    private ListeImmutable<E> source;
    private ListeImmutable<E> miroir;

    public Miroir(ListeImmutable<E> source) {

        this.source = source;
        this.miroir = ListeImmutable.vide();
    }

    public int taille() {
        return this.source.taille() + this.miroir.taille();
    }

    public boolean estInversible() {

        return this.source.taille() > 1;
    }

    public void inverser() {

        if (estInversible()) {
            miroir = ListeImmutable.cons(source.tete(), miroir);
            source = source.reste();
        }
        if(source.taille() > 0) {
            miroir = this.miroir.creer(this.source.tete());
            source = source.reste();
        }
    }

    public ListeImmutable<E> miroir() throws UnsupportedOperationException {

        if (source.estVide()) {
            return miroir;

        }else {
            throw new UnsupportedOperationException("Inversion non fini");
        }
    }
}
