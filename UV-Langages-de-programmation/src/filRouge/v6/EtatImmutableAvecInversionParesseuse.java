package filRouge.v6;

import filRouge.v5.EtatImmutable;
import filRouge.v5.ListeImmutable;

import java.util.Iterator;

public interface EtatImmutableAvecInversionParesseuse<E> extends EtatFileImmutable<E> {

    @Override
    default E premier() {throw new UnsupportedOperationException();}

    @Override
    default EtatFileImmutable<E> suivants() {throw new UnsupportedOperationException();}

    @Override
    default boolean estVide() {return true;}

    @Override
    default int taille() {
        return 0;
    }

    @Override
    EtatFileImmutable<E> creer();



    @Override
    default Iterator<E> iterator() {
        return new IterateurEtatFileImmutable<>(this);
    }

    public static <E> EtatFileImmutable<E> vide() {

        return new EtatImmutableAvecInversionParesseuse<E>() {

            @Override
            public EtatFileImmutable<E> creer() {
                return vide();
            }

            @Override
            public EtatFileImmutable<E> creer(E dernier) {

                FileImmutable<Miroir<E>> miroir = new FileImmutableAvecEtatReifie<>(
                        new EtatEnveloppeDeuxListesImmutables<Miroir<E>>()).creer();

                return EtatImmutableAvecInversionParesseuse.cons(
                        ListeImmutable.cons(dernier, ListeImmutable.vide()),
                        miroir,
                        ListeImmutable.vide());
            }
        };
    }

    public static <E> EtatFileImmutable<E> cons(ListeImmutable<E> debut, FileImmutable<Miroir<E>> miroir, ListeImmutable<E> fin) {

        return new EtatImmutableAvecInversionParesseuse<E>() {

            private ListeImmutable<E> debut;
            private FileImmutable<Miroir<E>> miroir;
            private ListeImmutable<E> fin;

            @Override
            public boolean estVide() {
                return this.taille() == 0;
            }

            @Override
            public E premier() {
                return this.debut.tete();
            }

            @Override
            public EtatFileImmutable<E> suivants() {
                if((debut.taille() + miroir.taille() + fin.taille()) <= 1){
                    return vide();
                }
                else {
                    return cons(debut.reste(), miroir, fin);
                }
            }

            @Override
            public EtatFileImmutable<E> creer() {
                return cons(debut,miroir,fin);
            }

            @Override
            public EtatFileImmutable<E> creer(E dernier) {
                invariant();

                return cons(debut, miroir, fin.creer(dernier));
            }

            private void invariant() {
                if (debut.taille() <= 0) {
                    if(miroir.taille() == 0) throw new UnsupportedOperationException();
                    else {
                        debut = miroir.premier().miroir();
                        miroir = miroir.suivants();
                    }
                }
                if (miroir.taille() <= 0 && fin.taille() > 0) {
                    miroir.ajout(new Miroir<E>(fin));
                    miroir.premier().inverser();
                    fin = ListeImmutable.vide();
                }
                if (fin.taille() >= debut.taille() + miroir.taille()) {
                    miroir.ajout(new Miroir<E>(fin));
                    miroir.premier().inverser();
                    fin = ListeImmutable.vide();
                }
            }
        };
    }


}
