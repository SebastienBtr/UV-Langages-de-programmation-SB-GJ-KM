package filRouge.v5;

import java.util.Iterator;

public interface EtatImmutable<E> {

    E premier();

    default public boolean estVide(){
        return this.taille() == 0;
    }

    int taille();

    EtatImmutable<E> suivants();

    Iterator<E> iterator();

    EtatImmutable<E> creer();

    EtatImmutable<E> creer(E dernier);
}
