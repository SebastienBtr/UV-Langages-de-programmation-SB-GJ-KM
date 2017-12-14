package filRouge.v6;

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

    default void invariant() {

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
            public String toString() {
                return this.representation();
            }

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

    public static <E> EtatFileImmutable<E> cons(ListeImmutable<E> d, FileImmutable<Miroir<E>> m, ListeImmutable<E> f) {

        EtatImmutableAvecInversionParesseuse<E> e = new EtatImmutableAvecInversionParesseuse<E>() {

            private ListeImmutable<E> debut = d;
            private FileImmutable<Miroir<E>> miroir = m;
            private ListeImmutable<E> fin = f;

            @Override
            public String toString() {
                return this.representation();
            }

            @Override
            public int taille() {
                int mTaille = 0;
                for (Miroir<E> m : miroir) {
                    mTaille += m.taille();
                }
                return debut.taille() + mTaille + fin.taille();
            }

            @Override
            public boolean estVide() {
                return this.taille() == 0;
            }

            @Override
            public E premier() {
                return debut.tete();
            }

            @Override
            public EtatFileImmutable<E> suivants() {
                if((taille()) <= 1){
                    return vide();
                }
                if (!miroir.estVide()) {
                    miroir.premier().inverser();
                }
                return cons(debut.reste(), miroir, fin);
            }

            @Override
            public EtatFileImmutable<E> creer() {
                return cons(debut,miroir,fin);
            }

            @Override
            public EtatFileImmutable<E> creer(E dernier) {
                return cons(debut, miroir, fin.creer(dernier));
            }

            public void invariant() {
                if (debut.estVide()) {
                    try {
                        debut = miroir.premier().miroir();
                        miroir = miroir.suivants();

                    } catch (UnsupportedOperationException e) {
                        e.printStackTrace();
                    }
                }

                if (fin.taille() >= taille() - fin.taille() ) {
                    miroir = miroir.ajout(new Miroir<E>(fin));
                    miroir.premier().inverser();
                    fin = ListeImmutable.vide();
                }
            }
        };
        e.invariant();
        return e;

    }


}
